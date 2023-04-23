package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

@Mixin(SweetBerryBushBlock.class)
public class BerryBushMixin {

    @Inject(cancellable = true,locals = LocalCapture.CAPTURE_FAILSOFT,method = "onEntityCollision",at=@At(value = "INVOKE",target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
    void noDamageForBerryBush$among(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci, double d, double e)
    {
        if(!world.getGameRules().getBoolean(AikoyoriTweaks.BERRY_BUSH_DAMAGE) && entity instanceof PlayerEntity) ci.cancel();
    }

}
