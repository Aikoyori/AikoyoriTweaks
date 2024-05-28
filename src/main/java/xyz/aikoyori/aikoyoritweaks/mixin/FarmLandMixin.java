package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

@Mixin(FarmlandBlock.class)
public abstract class FarmLandMixin extends Block {
    @Shadow public abstract void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance);

    public FarmLandMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "onLandedUpon",cancellable = true,locals = LocalCapture.CAPTURE_FAILSOFT,at = @At(value = "INVOKE",target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/entity/Entity;Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"))
    void nomoredirtsetifgameruleisfalse(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci)
    {
        if(!world.getGameRules().getBoolean(AikoyoriTweaks.CROPS_TRAMPLE))
        {
            super.onLandedUpon(world, state, pos, entity,fallDistance);
            ci.cancel();
        }

    }
}
