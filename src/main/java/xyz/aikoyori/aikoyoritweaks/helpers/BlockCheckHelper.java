package xyz.aikoyori.aikoyoritweaks.helpers;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

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
}
