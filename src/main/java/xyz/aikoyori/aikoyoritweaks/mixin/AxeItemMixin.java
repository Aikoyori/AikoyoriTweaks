package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Mixin(AxeItem.class)
public class AxeItemMixin {
    private static Map<Block, Block> DESTRIPPED_BLOCKS = new HashMap<>();

    ServerWorld world;

    @Inject(method = "<init>",locals = LocalCapture.CAPTURE_FAILSOFT,at = @At(value = "INVOKE",shift = At.Shift.AFTER,target = "Lnet/minecraft/item/MiningToolItem;<init>(FFLnet/minecraft/item/ToolMaterial;Lnet/minecraft/tag/TagKey;Lnet/minecraft/item/Item$Settings;)V"))
    private void backwardsStripping(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings, CallbackInfo ci){
        for(Map.Entry<Block, Block> i:AxeItem.STRIPPED_BLOCKS.entrySet())
        {
            DESTRIPPED_BLOCKS.put(i.getValue(),i.getKey());
        }
    }

    @Inject(method = "useOnBlock",locals = LocalCapture.CAPTURE_FAILSOFT,at=@At("HEAD"))
    void worldGet(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
        if(!context.getWorld().isClient) world = (ServerWorld) context.getWorld();

    }
    @Inject(method = "getStrippedState",locals = LocalCapture.CAPTURE_FAILSOFT,cancellable = true,at=@At("HEAD"))
    void realStrippedStateMyGuy(BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir)
    {
        try{
            if(DESTRIPPED_BLOCKS.containsKey(state.getBlock()) && world.getGameRules().getBoolean(AikoyoriTweaks.ALLOW_DESTRIPPING) )
            {
                cir.setReturnValue(Optional.ofNullable((Block)DESTRIPPED_BLOCKS.get(state.getBlock())).map((block) -> {
                    return (BlockState)block.getDefaultState().with(PillarBlock.AXIS, (Direction.Axis)state.get(PillarBlock.AXIS));
                }));
            }
        }
        catch (Exception ex){

        }


    }

}
