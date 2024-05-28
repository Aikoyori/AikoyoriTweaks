package xyz.aikoyori.aikoyoritweaks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.BedItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.world.GameRules;
import xyz.aikoyori.aikoyoritweaks.mixin.GameRule$BooleanAccessor;
import xyz.aikoyori.aikoyoritweaks.mixin.GameRule$IntAccessor;
import xyz.aikoyori.aikoyoritweaks.mixin.GameRule$BooleanAccessor;
import xyz.aikoyori.aikoyoritweaks.mixin.GameRule$IntAccessor;
import xyz.aikoyori.aikoyoritweaks.mixin.GameRuleMixin;

public class AikoyoriTweaks implements ModInitializer {

    public static final GameRules.Key<GameRules.BooleanRule> RAPID_FOLIAGE_BREAK =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_rapidFoliageBreak", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(false));
    public static final GameRules.Key<GameRules.BooleanRule> ALLOW_DESTRIPPING =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_allowDestripping", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(false));
    public static final GameRules.Key<GameRules.BooleanRule> BERRY_BUSH_DAMAGE =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_doesBerryBushDamage", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(true));
    /*public static final GameRules.Key<GameRules.BooleanRule> BERRY_BUSH_SLOW =
            GameRuleMixin.invokeRegister("doesBerryBushSlowDown", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(true));*/
    public static final GameRules.Key<GameRules.BooleanRule> CROPS_TRAMPLE =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_doesCropTrampling", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(true));
    public static final GameRules.Key<GameRules.IntRule> TELEPORT_ITEM_COOLDOWN =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_teleportItemCooldown", GameRules.Category.UPDATES, GameRule$IntAccessor.invokeCreate(20));
    public static final GameRules.Key<GameRules.BooleanRule> MORE_CAULDRON_CLEANER =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_cauldronsWashMoreThings", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(false));

    public static final GameRules.Key<GameRules.BooleanRule> HARVEST_CROPS_ON_USE =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_allowHarvestingByRightClick", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(false));
    public static final GameRules.Key<GameRules.BooleanRule> CREEPER_GRIEFING =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_doCreeperGriefing", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(true));

    public static final GameRules.Key<GameRules.BooleanRule> STONE_GENERATOR_VARIATION =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_moreStoneGenerator", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(false));
   public static final GameRules.Key<GameRules.BooleanRule> CREEPER_DAMAGE_PASSIVE_MOBS =
            GameRuleMixin.invokeRegister("aikoyoriTweaks_creeperDamagePassiveMobs", GameRules.Category.UPDATES, GameRule$BooleanAccessor.invokeCreate(true));

    @Override
    public void onInitialize() {

    }
}
