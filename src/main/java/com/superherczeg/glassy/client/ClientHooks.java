package com.superherczeg.glassy.client;

import com.superherczeg.glassy.client.screen.ProjectorScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;

public class ClientHooks {
    public static void openProjectorScreen(BlockPos pos) {
        Minecraft.getInstance().setScreen(new ProjectorScreen(pos));
    }
}
