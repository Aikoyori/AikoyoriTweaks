package xyz.aikoyori.aikoyoritweaks.mixin;

import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;
import xyz.aikoyori.aikoyoritweaks.helpers.BlockCheckHelper;

@Mixin(FluidBlock.class)
public abstract class FluidBlockMixin extends Block implements FluidDrainable {
    public FluidBlockMixin(Settings settings) {
        super(settings);
    }



    @Inject(method = "receiveNeighborFluids",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z",ordinal = 0),locals = LocalCapture.CAPTURE_FAILSOFT,cancellable = true)
    void moreStoneTypeGeneratorsLol(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir, Block block){
        if(world.getGameRules().getBoolean(AikoyoriTweaks.STONE_GENERATOR_VARIATION))
        {

            Block block2 = BlockCheckHelper.cobbleGenReplace(Blocks.COBBLESTONE,block,world,pos);

            world.setBlockState(pos, block2.getDefaultState());

            world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
            cir.setReturnValue(false);
        }
    }
}
