package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

import java.util.List;
import java.util.Objects;

@Mixin(Explosion.class)
public class ExplosionMixin {
    @Shadow @Final private World world;

    @ModifyVariable(method = "collectBlocksAndDamageEntities",at=@At("STORE"),ordinal = 0)
    private List<Entity> aikotweaks$removePassiveMobs(List<Entity> value){
        if(!world.getGameRules().getBoolean(AikoyoriTweaks.CREEPER_DAMAGE_PASSIVE_MOBS) &&
                Objects.nonNull(((Explosion)(Object)(this)).getEntity()) && ((Explosion)(Object)(this)).getEntity() instanceof CreeperEntity)
        {
            value.removeIf(entity -> entity instanceof PassiveEntity);
        }
        return value;
    }
}
