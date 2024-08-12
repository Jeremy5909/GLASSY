package com.superherczeg.glassy.init;

import com.superherczeg.glassy.Glassy;

import com.superherczeg.glassy.block.ProjectorBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Glassy.MODID);

    public static final RegistryObject<ProjectorBlock> PROJECTOR_BLOCK = BLOCKS.register("projector",
            () -> new ProjectorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN))
    );
}
