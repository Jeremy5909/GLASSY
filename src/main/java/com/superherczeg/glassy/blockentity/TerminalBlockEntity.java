package com.superherczeg.glassy.blockentity;

import com.superherczeg.glassy.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TerminalBlockEntity extends BlockEntity {
    public TerminalBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.TERMINAL_BLOCK_ENTITY.get(), pos, state);
    }
}
