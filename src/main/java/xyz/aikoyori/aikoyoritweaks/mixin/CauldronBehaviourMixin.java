package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xyz.aikoyori.aikoyoritweaks.helpers.CauldronHelper;

@Mixin(CauldronBehavior.class)
public interface CauldronBehaviourMixin {

    @Inject(method = "registerBehavior",locals = LocalCapture.CAPTURE_FAILSOFT,at=@At(value = "TAIL"))
    private static void addMoreCauldronStuff(CallbackInfo ci){

        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_WOOL, CauldronHelper.CLEAN_WOOL);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_WOOL, CauldronHelper.CLEAN_WOOL);

        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_BED, CauldronHelper.CLEAN_BED);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_BED, CauldronHelper.CLEAN_BED);

        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.WHITE_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_STAINED_GLASS, CauldronHelper.CLEAN_GLASS);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_STAINED_GLASS, CauldronHelper.CLEAN_BED);

        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.WHITE_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_STAINED_GLASS_PANE, CauldronHelper.CLEAN_GLASS_PANE);

        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.WHITE_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);

        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.WHITE_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_GLAZED_TERRACOTTA, CauldronHelper.CLEAN_TERRACOTTA);

        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.WHITE_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GRAY_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLACK_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BLUE_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.BROWN_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.CYAN_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.GREEN_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_BLUE_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIGHT_GRAY_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.LIME_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.MAGENTA_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.ORANGE_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PINK_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.PURPLE_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.RED_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(Items.YELLOW_CONCRETE_POWDER, CauldronHelper.WASH_CONCRETE);


    }
}
