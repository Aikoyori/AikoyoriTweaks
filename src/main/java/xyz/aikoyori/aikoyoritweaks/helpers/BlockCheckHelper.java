package xyz.aikoyori.aikoyoritweaks.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class BlockCheckHelper {
    public static boolean checkAroundIfBlockExist(WorldAccess world, Block block, BlockPos pos)
    {
        return
                (((world.getBlockState(pos.down())).getBlock()==block)||
                        ((world.getBlockState(pos.up())).getBlock()==block)||
                        ((world.getBlockState(pos.north())).getBlock()==block)||
                        ((world.getBlockState(pos.west())).getBlock()==block)||
                        ((world.getBlockState(pos.south())).getBlock()==block)||
                        ((world.getBlockState(pos.east())).getBlock()==block));
    }
    public static Block cobbleGenReplace(@Nullable Block original, Block block, WorldAccess world, BlockPos pos){
        if(block == Blocks.COBBLESTONE)
        {
            if (BlockCheckHelper.checkAroundIfBlockExist(world,Blocks.DRIPSTONE_BLOCK,pos)) {
                return Blocks.DRIPSTONE_BLOCK;
            }else if (BlockCheckHelper.checkAroundIfBlockExist(world,Blocks.POLISHED_GRANITE,pos)) {
                return Blocks.GRANITE;
            } else if (BlockCheckHelper.checkAroundIfBlockExist(world,Blocks.POLISHED_DIORITE,pos) ) {
                return Blocks.DIORITE;
            } else if (BlockCheckHelper.checkAroundIfBlockExist(world,Blocks.POLISHED_ANDESITE,pos)) {
                return Blocks.ANDESITE;
            } else if (BlockCheckHelper.checkAroundIfBlockExist(world,Blocks.SOUL_SOIL,pos) || BlockCheckHelper.checkAroundIfBlockExist(world,Blocks.SOUL_SAND,pos) ) {
                return Blocks.BLACKSTONE;
            } else if (BlockCheckHelper.checkAroundIfBlockExist(world,Blocks.MAGMA_BLOCK,pos)) {
                return Blocks.COBBLED_DEEPSLATE;
            }
        }

        return Objects.requireNonNullElse(original,block);
    }
}
