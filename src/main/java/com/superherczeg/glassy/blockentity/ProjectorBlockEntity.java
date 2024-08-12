package com.superherczeg.glassy.blockentity;

import com.superherczeg.glassy.Glassy;
import com.superherczeg.glassy.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ProjectorBlockEntity extends BlockEntity {
    public ProjectorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.PROJECTOR_BLOCK_ENTITY.get(), pos, state);
    }
}