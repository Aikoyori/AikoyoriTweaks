package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ChorusFruitItem;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

@Mixin(ChorusFruitItem.class)
public class ChorusMixin {
    World worlde;
    @Inject(method = "finishUsing",locals = LocalCapture.CAPTURE_FAILSOFT,at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/player/PlayerEntity;getItemCooldownManager()Lnet/minecraft/entity/player/ItemCooldownManager;",shift = At.Shift.AFTER))
    void setCooldownToWhatever(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir, ItemStack itemStack){
        worlde = world;
    }
    @ModifyArg(method = "finishUsing",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/player/ItemCooldownManager;set(Lnet/minecraft/item/Item;I)V"),index = 1)
    int cooldownModeee(int i){

        return worlde.getGameRules().getInt(AikoyoriTweaks.TELEPORT_ITEM_COOLDOWN);
    }
}
