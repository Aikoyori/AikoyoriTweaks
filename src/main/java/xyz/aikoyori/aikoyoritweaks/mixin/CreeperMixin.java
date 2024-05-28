package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

@Mixin(CreeperEntity.class)
public abstract class CreeperMixin extends MobEntity {
    protected CreeperMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }
    /*
    @Inject(method = "explode",at=@At(value = "INVOKE",target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/world/explosion/Explosion$DestructionType;)Lnet/minecraft/world/explosion/Explosion;"),locals = LocalCapture.CAPTURE_FAILSOFT)
    void explosionOfLeShit(CallbackInfo ci, Explosion.DestructionType destructionType, float f){
        destructionType = this.world.getGameRules().getBoolean(AikoyoriTweaks.CREEPER_GRIEFING)? destructionType: Explosion.DestructionType.NONE;
    }*/
    @ModifyArgs(method = "explode",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/world/World$ExplosionSourceType;)Lnet/minecraft/world/explosion/Explosion;"))
    void destructionTypeMixinCreeperBS(Args args){
        args.set(5,this.getWorld().getGameRules().getBoolean(AikoyoriTweaks.CREEPER_GRIEFING)? args.get(5): World.ExplosionSourceType.NONE);
    }
}
