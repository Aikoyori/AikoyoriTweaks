package xyz.aikoyori.aikoyoritweaks.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.apache.commons.lang3.builder.Diff;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

@Mixin(ZombieEntity.class)
public abstract class ZombieEntityMixin extends HostileEntity {
    protected ZombieEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyExpressionValue(method = "onKilledOther",at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty Aikoyrori$makeItAllHard(Difficulty original)
    {
        if(this.getWorld().getGameRules().getBoolean(AikoyoriTweaks.ZOMBIE_ALWAYS_INFECT_VILLAGER)){
            return Difficulty.HARD;
        }
        return original;
    }
}
