package com.superherczeg.glassy.client.screen;

import com.superherczeg.glassy.Glassy;
import com.superherczeg.glassy.blockentity.ProjectorBlockEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.client.event.ForgeEventFactoryClient;
import org.jetbrains.annotations.NotNull;

import java.io.Console;
import java.util.Iterator;

public class ProjectorScreen extends Screen {
    private static final Component TITLE = Component.translatable("gui." + Glassy.MODID + ".projector");
    private static final Component TEST_BUTTON = Component.translatable("gui." + Glassy.MODID + ".projector.button.test");
    private static final ResourceLocation TEXTURE = new ResourceLocation(Glassy.MODID, "textures/gui/projector_screen.png");

    private final BlockPos position;
    private final int imageWidth, imageHeight;

    private ProjectorBlockEntity blockEntity;
    private int leftPos, topPos;

    private Button button;

    public ProjectorScreen(BlockPos position) {
        super(TITLE);
        this.position = position;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderTransparentBackground(pGuiGraphics);
        Iterator var5 = this.renderables.iterator();

        while(var5.hasNext()) {
            Renderable renderable = (Renderable)var5.next();
            renderable.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        }
        // super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        pGuiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        if (this.minecraft == null) return;

        Level level = this.minecraft.level;
        if (level == null) return;

        BlockEntity be = level.getBlockEntity(this.position);
        if (be instanceof ProjectorBlockEntity blockEntity) {
            this.blockEntity = blockEntity;
        } else {
            System.err.printf("BlockEntity at %s is not of type ProjectorBlockEntity!\n", this.position);
            return;
        }
        this.button = addRenderableWidget(
                Button.builder(TEST_BUTTON, btn -> {})
                        .bounds(this.leftPos + 8, this.topPos + 8, 64, 20)
                        .build()
        );
    }
}
