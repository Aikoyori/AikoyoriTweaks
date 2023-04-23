package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.world.GameRules;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.BooleanRule.class)
public interface GameRule$BooleanAccessor {

    @Invoker
    static GameRules.Type<GameRules.BooleanRule> invokeCreate(boolean defaultValue) {
        throw new NotImplementedException("Mixin failed");
    }
}
