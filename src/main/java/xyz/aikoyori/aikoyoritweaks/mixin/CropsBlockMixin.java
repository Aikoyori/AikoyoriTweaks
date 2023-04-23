package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Mixin(CropBlock.class)
public abstract class CropsBlockMixin extends PlantBlock implements Fertilizable{

    protected CropsBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        CropBlock crop = (CropBlock)(Object)this;
        if(world.getGameRules().getBoolean(AikoyoriTweaks.HARVEST_CROPS_ON_USE) && !world.isClient)
        {


            if(crop.isMature(state))
            {

                ArrayList<ItemStack> stacker = new ArrayList<>();
                List<ItemStack> stacks = state.getDroppedStacks(new LootContext.Builder((ServerWorld) world).parameter(LootContextParameters.BLOCK_STATE,state).parameter(LootContextParameters.ORIGIN,new Vec3d(pos.getX(),pos.getY(),pos.getZ())).parameter(LootContextParameters.TOOL,player.getMainHandStack()));
                AtomicBoolean isTakenoff = new AtomicBoolean(false);
                stacks.stream().forEach(itemStack -> {
                    if(itemStack.getItem() == crop.getSeedsItem() && !isTakenoff.get())
                    {
                        itemStack.setCount(itemStack.getCount()-1);
                        isTakenoff.set(true);
                    }
                    if(world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS)) dropStack(world,pos,itemStack);
                });
                //dropStacks(world,pos);
                world.setBlockState(pos,state.getBlock().getDefaultState());
                return ActionResult.SUCCESS;
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
