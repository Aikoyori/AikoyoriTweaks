package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

import static net.minecraft.block.LeavesBlock.updateDistanceFromLogs;

@Mixin(LeavesBlock.class)
public abstract class LeavesMixin {
    @Shadow public abstract void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random);

    @Shadow protected abstract boolean shouldDecay(BlockState state);

    @Shadow public abstract void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random);


    @Inject(method = "scheduledTick",cancellable = true,locals = LocalCapture.CAPTURE_FAILSOFT,at = @At("HEAD"))
    void whentheleavesgetscheduled(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci){
        if(world.getGameRules().getBoolean(AikoyoriTweaks.RAPID_FOLIAGE_BREAK))
        {
            LeavesBlock leaf = (LeavesBlock) (Object)this;

            if (this.shouldDecay(world.getBlockState(pos))) {
                Block.dropStacks(world.getBlockState(pos), world, pos);
                world.removeBlock(pos, false);
                updateNearbyBlock(world, pos, random);
                ci.cancel();
            }
        }
    }

    @Inject(method = "getStateForNeighborUpdate",cancellable = true,locals = LocalCapture.CAPTURE_FAILSOFT,at=@At(value = "INVOKE",target = "Lnet/minecraft/world/WorldAccess;scheduleBlockTick(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;I)V"))
    void nomoreupdateshit(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos, CallbackInfoReturnable<BlockState> cir){
        if(!world.isClient())
        {
            if(world.getServer().getGameRules().getBoolean(AikoyoriTweaks.RAPID_FOLIAGE_BREAK))
            {
                world.setBlockState(pos, updateDistanceFromLogs(state, world, pos), Block.NOTIFY_LISTENERS);
                cir.setReturnValue(state);

            }
        }

    }
    @Inject(method = "randomTick",cancellable = true,locals = LocalCapture.CAPTURE_FAILSOFT,at = @At("HEAD"))
    void randomTickSus(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci){
        if(world.getGameRules().getBoolean(AikoyoriTweaks.RAPID_FOLIAGE_BREAK))
        {

            world.setBlockState(pos, LeavesBlock.updateDistanceFromLogs(state, world, pos), Block.NOTIFY_ALL);

            scheduledTick(state,world,pos,random);
            /*
            WorldChunk chunk = world.getChunk(pos.getX()/16,pos.getZ()/16);

            int k =  random.nextBetween(chunk.getBottomY(),chunk.getTopY());
            BlockPos blockPos3 = world.getRandomPosInChunk(chunk.getPos().getStartX(),k, chunk.getPos().getStartZ(), 15);

            BlockState blockState2 = chunk.getBlockState(new BlockPos(blockPos3.getX() - chunk.getPos().getStartX(), blockPos3.getY() - k, blockPos3.getZ() - chunk.getPos().getStartZ()));
            if (blockState2.hasRandomTicks()) {
                blockState2.randomTick(world, blockPos3, random);
            }*/
            ci.cancel();
        }
    }
    private void updateNearbyBlock(ServerWorld world,BlockPos pos,Random random)
    {
        /*
        *
        for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)
            {
                for(int k=-1;k<=1;k++)
                {

                    updateBlockOffset(world,pos.add(i,j,k),random);
                }
            }
        }*/
        updateBlockOffset(world,pos.add(1,0,0),random);
        updateBlockOffset(world,pos.add(-1,0,0),random);
        updateBlockOffset(world,pos.add(1,1,0),random);
        updateBlockOffset(world,pos.add(-1,1,0),random);
        updateBlockOffset(world,pos.add(1,-1,0),random);
        updateBlockOffset(world,pos.add(-1,-1,0),random);
        updateBlockOffset(world,pos.add(0,1,0),random);
        updateBlockOffset(world,pos.add(0,-1,0),random);
        updateBlockOffset(world,pos.add(0,0,1),random);
        updateBlockOffset(world,pos.add(0,0,-1),random);
    }
    private void updateBlockOffset(ServerWorld world,BlockPos pos,Random random)
    {
            LeavesBlock leaf = (LeavesBlock) (Object)this;

            world.scheduleBlockTick(pos,(LeavesBlock)(Object)this,2);

    }
}
