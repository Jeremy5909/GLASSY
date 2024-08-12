package com.superherczeg.glassy.init;

import com.superherczeg.glassy.Glassy;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Glassy.MODID);

    public static final RegistryObject<Item> PROJECTOR_ITEM = ITEMS.register("projector",
            () -> new BlockItem(
                            BlockInit.PROJECTOR_BLOCK.get(),
                            new Item.Properties()
                    )
            );
}
