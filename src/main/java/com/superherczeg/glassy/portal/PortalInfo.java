package com.superherczeg.glassy.portal;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;

public class PortalInfo {
    public PortalCarrier parent;

    public int orientation = 0;// 90 degree increments
    public int face = 0; //0 = face up, 1 = face down, 2 = horizontal
    public boolean horizontal = false;

    public double height = 3.0; //height of scanzone
    public double width = 1.5; //width of scanzone

    public double offsetHeight = 1.0; //height offset of scanzone
    public double offsetDepth = 0.1; //depth offset of scanzone

    public boolean active = true; //if inactive... don't render the projection or teleport at all
    public boolean project = false; //show projection, obviously.

    public int teleport = 1;

    public String channelName = "Unnamed";

    public PortalInfo link;

    public void write(CompoundTag tag) {
        tag.putInt("orientation", orientation);
        tag.putInt("face", face);
        tag.putBoolean("horizontal", horizontal);
        tag.putDouble("height", height);
        tag.putDouble("width", width);

        tag.putDouble("offsetHeight", offsetHeight);
        tag.putDouble("offsetDepth", offsetDepth);

        tag.putBoolean("active", active);
        tag.putBoolean("project", project);
        tag.putInt("teleport", teleport);
        tag.putString("channelName", channelName);

        if (link != null) {
            CompoundTag linkTag = new CompoundTag();
            link.write(linkTag);
            tag.put("linkInfo", linkTag);
        }
    }

    public void readSelfInfo(CompoundTag tag) {
        orientation = tag.getInt("orientation");
        face = tag.getInt("face");
        horizontal = tag.getBoolean("horizontal");

        height = tag.getDouble("height");
        width = tag.getDouble("width");

        offsetHeight = tag.getDouble("offsetHeight");
        offsetDepth = tag.getDouble("offsetDepth");

        active = tag.getBoolean("active");
        project = tag.getBoolean("project");
        teleport = tag.getInt("teleport");
        channelName = tag.getString("channelName");

        if (height < 0.1D) {
            height = 0.1D;
        }
        if (width < 0.05D) {
            width = 0.05D;
        }

        if (tag.contains("linkInfo")) {
            link = new PortalInfo();
            link.read(tag.getCompound("linkInfo"));
        }
    }

    public void read(CompoundTag tag) {
        readSelfInfo(tag);
    }

    public void render(Level world, double x, double y, double z, float f) {
        Minecraft mc = Minecraft.getInstance();
        DebugScreenOverlay debug = mc.gui.getDebugOverlay();

        if (!(debug.showDebugScreen() || active && project && link == null)) {
            System.out.println("Portal not active or already linked or something...?");
            return;
        }

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableCull();

        orientPlane();

        if (debug.showDebugScreen()) {
            RenderSystem.setShaderColor(1.0F, 0.0F, 1.0F, 1.0F);

            renderPlane();

            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
        RenderSystem.disableCull();
        RenderSystem.disableBlend();
    }

    public void orientPlane() {
        // TODO
    }

    public void renderPlane() {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();

        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
        builder.vertex(-width, (height/2),0).endVertex();
        builder.vertex(-width, -(height/2), 0).endVertex();
        builder.vertex(width, -(height/2), 0).endVertex();
        builder.vertex(width, (height/2), 0).endVertex();
        tesselator.end();
    }
}
