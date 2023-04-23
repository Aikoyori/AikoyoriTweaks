package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;
import xyz.aikoyori.aikoyoritweaks.helpers.BlockCheckHelper;

@Mixin(LavaFluid.class)
public abstract class LavaFluidMixin extends FlowableFluid {

    @Inject(method = "flow",locals = LocalCapture.CAPTURE_FAILSOFT,at=@At(value = "INVOKE",target = "Lnet/minecraft/world/WorldAccess;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"),cancellable = true)
    void aikotweaks$stoneamongthem(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState, CallbackInfo ci, FluidState fluidState2){
        if(!world.isClient())
        {
            if(world.getServer().getGameRules().getBoolean(AikoyoriTweaks.STONE_GENERATOR_VARIATION))
            {
                Block block = BlockCheckHelper.cobbleGenReplace(Blocks.STONE,Blocks.COBBLESTONE,world,pos);


                world.setBlockState(pos, block.getDefaultState(),Block.NOTIFY_ALL);

                world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
                ci.cancel();
            }
        }

    }
}
