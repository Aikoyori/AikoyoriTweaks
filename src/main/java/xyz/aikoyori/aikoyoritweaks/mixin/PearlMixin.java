package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.entity.player.PlayerEntity;
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
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

@Mixin(EnderPearlItem.class)
public class PearlMixin {
    World worlde;
    @Inject(method = "use",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/player/PlayerEntity;getItemCooldownManager()Lnet/minecraft/entity/player/ItemCooldownManager;"))
    void setCooldownToWhatever(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir){
        this.worlde = world;
    }
    @ModifyArg(method = "use",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/player/ItemCooldownManager;set(Lnet/minecraft/item/Item;I)V"),index = 1)
    int cooldownModeee(int i){

       return worlde.getGameRules().getInt(AikoyoriTweaks.TELEPORT_ITEM_COOLDOWN);
    }
}
