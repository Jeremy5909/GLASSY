package com.superherczeg.glassy.init;

import com.superherczeg.glassy.Glassy;
import com.superherczeg.glassy.blockentity.ProjectorBlockEntity;
import com.superherczeg.glassy.blockentity.TerminalBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Glassy.MODID);

    public static final RegistryObject<BlockEntityType<?>> PROJECTOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("projector",
            () -> BlockEntityType.Builder.of(ProjectorBlockEntity::new, BlockInit.PROJECTOR_BLOCK.get()).build(null)
    );

    public static final RegistryObject<BlockEntityType<?>> TERMINAL_BLOCK_ENTITY = BLOCK_ENTITIES.register("terminal",
            () -> BlockEntityType.Builder.of(TerminalBlockEntity::new, BlockInit.PROJECTOR_BLOCK.get()).build(null)
    );
}
