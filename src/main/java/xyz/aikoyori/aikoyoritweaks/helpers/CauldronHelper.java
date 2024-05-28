package xyz.aikoyori.aikoyoritweaks.helpers;

import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.BedItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import xyz.aikoyori.aikoyoritweaks.AikoyoriTweaks;

public class CauldronHelper {
    public static CauldronBehavior CLEAN_WOOL = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());
        if (!Registries.BLOCK.getId(block).getPath().contains("_wool")){
            return ActionResult.PASS;
        } else {
            if (!world.isClient && world.getGameRules().getBoolean(AikoyoriTweaks.MORE_CAULDRON_CLEANER)) {
                ItemStack itemStack = new ItemStack(Blocks.WHITE_WOOL);
                if (stack.hasNbt()) {
                    itemStack.setNbt(stack.getNbt().copy());
                }
                itemStack.setCount(stack.getCount());
                world.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,4f,1f,true);

                player.setStackInHand(hand, itemStack);
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            }

            return ActionResult.success(world.isClient);
        }
    };
    public static CauldronBehavior CLEAN_BED = (state, world, pos, player, hand, stack) -> {
        if (!(stack.getItem() instanceof BedItem)) {
            return ActionResult.PASS;
        } else {
            if (!world.isClient && world.getGameRules().getBoolean(AikoyoriTweaks.MORE_CAULDRON_CLEANER)) {
                ItemStack itemStack = new ItemStack(Blocks.WHITE_BED);
                if (stack.hasNbt()) {
                    itemStack.setNbt(stack.getNbt().copy());
                }
                world.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,4f,1f,true);

                itemStack.setCount(stack.getCount());
                player.setStackInHand(hand, itemStack);
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            }

            return ActionResult.success(world.isClient);
        }
    };

    public static CauldronBehavior CLEAN_GLASS = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());
        if (!(block instanceof AbstractGlassBlock)) {
            return ActionResult.PASS;
        } else {
            if (!world.isClient && world.getGameRules().getBoolean(AikoyoriTweaks.MORE_CAULDRON_CLEANER)) {
                ItemStack itemStack = new ItemStack(Blocks.GLASS);
                if (stack.hasNbt()) {
                    itemStack.setNbt(stack.getNbt().copy());
                }
                world.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,4f,1f,true);
                itemStack.setCount(stack.getCount());

                player.setStackInHand(hand, itemStack);
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            }

            return ActionResult.success(world.isClient);
        }
    };
    public static CauldronBehavior CLEAN_GLASS_PANE = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());
        if (!(block instanceof PaneBlock)) {
            return ActionResult.PASS;
        } else {
            if (!world.isClient && world.getGameRules().getBoolean(AikoyoriTweaks.MORE_CAULDRON_CLEANER)) {
                ItemStack itemStack = new ItemStack(Blocks.GLASS_PANE);
                if (stack.hasNbt()) {
                    itemStack.setNbt(stack.getNbt().copy());
                }
                world.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,4f,1f,true);
                itemStack.setCount(stack.getCount());

                player.setStackInHand(hand, itemStack);
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            }

            return ActionResult.success(world.isClient);
        }
    };
    public static CauldronBehavior CLEAN_TERRACOTTA = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());

        if (!Registries.BLOCK.getId(block).getPath().contains("_terracotta") || Registries.BLOCK.getId(block).getPath().contains("_glazed_terracotta") ){
            return ActionResult.PASS;
        } else {
            if (!world.isClient && world.getGameRules().getBoolean(AikoyoriTweaks.MORE_CAULDRON_CLEANER)) {
                ItemStack itemStack = new ItemStack(Blocks.TERRACOTTA);
                if (stack.hasNbt()) {
                    itemStack.setNbt(stack.getNbt().copy());
                }
                world.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,4f,1f,true);
                itemStack.setCount(stack.getCount());

                player.setStackInHand(hand, itemStack);
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            }

            return ActionResult.success(world.isClient);
        }
    };
    public static CauldronBehavior WASH_CONCRETE = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());

        if (!(block instanceof ConcretePowderBlock)) {
            return ActionResult.PASS;
        } else {
            if (!world.isClient && world.getGameRules().getBoolean(AikoyoriTweaks.MORE_CAULDRON_CLEANER)) {
                ConcretePowderBlock con = (ConcretePowderBlock) block;
                ItemStack itemStack = new ItemStack(con.hardenedState.getBlock());
                if (stack.hasNbt()) {
                    itemStack.setNbt(stack.getNbt().copy());
                }
                world.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,4f,1f,true);
                itemStack.setCount(stack.getCount());

                player.setStackInHand(hand, itemStack);
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            }

            return ActionResult.success(world.isClient);
        }
    };
}
