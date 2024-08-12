package com.superherczeg.glassy.block;

import com.superherczeg.glassy.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TerminalBlock extends Block implements EntityBlock {
    public TerminalBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BlockEntityInit.TERMINAL_BLOCK_ENTITY.get().create(blockPos, blockState);
    }
}