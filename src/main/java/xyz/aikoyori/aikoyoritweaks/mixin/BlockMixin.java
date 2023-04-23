package xyz.aikoyori.aikoyoritweaks.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import org.spongepowered.asm.mixin.Mixin;
import xyz.aikoyori.aikoyoritweaks.accessor.BlockMixin$MaterialAccessor;

@Mixin(Block.class)
public abstract class BlockMixin extends AbstractBlock implements BlockMixin$MaterialAccessor {
    AbstractBlock.Settings setting;
    public BlockMixin(Settings settings) {
        super(settings);
        setting = settings;
    }

    @Override
    public Material getMaterial() {
        return this.material;
    }
}
