package com.superherczeg.glassy;

import com.superherczeg.glassy.init.BlockEntityInit;
import com.superherczeg.glassy.init.BlockInit;
import com.superherczeg.glassy.init.ItemInit;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Glassy.MODID)
public class Glassy
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "glassy";

    public Glassy()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(bus);
        BlockEntityInit.BLOCK_ENTITIES.register(bus);
        ItemInit.ITEMS.register(bus);
    }
}
