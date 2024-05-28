package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

import java.util.ArrayList;
import java.util.List;

@Mixin(CocoaBlock.class)
public abstract class CocoaBeanBlockMixin extends HorizontalFacingBlock implements Fertilizable {
    @Shadow @Final public static IntProperty AGE;

    protected CocoaBeanBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        CocoaBlock crop = (CocoaBlock)(Object)this;
        if(world.getGameRules().getBoolean(AikoyoriTweaks.HARVEST_CROPS_ON_USE) && !world.isClient)
        {
            if(state.get(CocoaBlock.AGE) == 2)
            {

                ArrayList<ItemStack> stacker = new ArrayList<>();
                //List<ItemStack> stacks = state.getDroppedStacks(new LootContext.Builder((ServerWorld) world).parameter(LootContextParameters.BLOCK_STATE,state).parameter(LootContextParameters.ORIGIN,new Vec3d(pos.getX(),pos.getY(),pos.getZ())).parameter(LootContextParameters.TOOL,player.getMainHandStack()));
                List<ItemStack> stacks = state.getDroppedStacks(new LootContextParameterSet.Builder((ServerWorld) world).add(LootContextParameters.BLOCK_STATE,state).addOptional(LootContextParameters.ORIGIN,new Vec3d(pos.getX(),pos.getY(),pos.getZ())).addOptional(LootContextParameters.TOOL,player.getMainHandStack()));
                stacks.forEach(itemStack -> {
                    if(itemStack.getItem() == Items.COCOA_BEANS)
                    {
                        itemStack.setCount(itemStack.getCount()-1);
                    }
                    if(world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS)) dropStack(world,pos,itemStack);
                });
                //dropStacks(world,pos);
                world.setBlockState(pos,state.with(AGE,0));
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
