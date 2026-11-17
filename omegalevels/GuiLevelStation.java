/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.inventory.Container
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package omegalevels;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import omegalevels.ContainerLevelStation;
import omegalevels.OmegaLevels;
import omegalevels.PacketImprove;
import omegalevels.TileLevelStation;
import org.lwjgl.opengl.GL11;

public class GuiLevelStation
extends GuiContainer {
    public final TileLevelStation tile;

    public GuiLevelStation(ContainerLevelStation container) {
        super((Container)container);
        this.tile = container.tile;
        this.field_146999_f = 176;
        this.field_147000_g = 166;
    }

    private boolean isMouseOverButton(int mouseX, int mouseY) {
        int x = (this.field_146294_l - this.field_146999_f) / 2;
        int y = (this.field_146295_m - this.field_147000_g) / 2;
        return mouseX - x > 121 && mouseX - x <= 145 && mouseY - y > 28 && mouseY - y <= 52;
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        int x = (this.field_146294_l - this.field_146999_f) / 2;
        int y = (this.field_146295_m - this.field_147000_g) / 2;
        GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        this.field_146297_k.func_110434_K().func_110577_a(new ResourceLocation("omegalevels", "textures/gui/container/level_station.png"));
        this.func_73729_b(x, y, 0, 0, this.field_146999_f, this.field_147000_g);
        this.func_73729_b(x + 68, y + 32, 176, 0, (int)(46.0 * ((double)this.tile.progress / 80.0)), 14);
        if (this.tile.getChance() > 0) {
            this.func_73729_b(x + 121, y + 28, this.isMouseOverButton(mouseX, mouseY) ? 200 : 176, 14, 24, 24);
        }
        this.field_146289_q.func_78276_b(I18n.func_135052_a((String)"gui.chance.double", (Object[])new Object[0]) + " " + this.tile.getChanceSkipLevel() + "%", x + 42, y + 13, 16777215);
        this.field_146289_q.func_78276_b(I18n.func_135052_a((String)"gui.chance.text", (Object[])new Object[0]) + " " + this.tile.getChance() + "%", x + 65, y + 62, 16777215);
    }

    protected void func_73864_a(int mouseX, int mouseY, int button) {
        super.func_73864_a(mouseX, mouseY, button);
        if (this.tile.getChance() > 0 && this.isMouseOverButton(mouseX, mouseY)) {
            OmegaLevels.channel.sendToServer((IMessage)new PacketImprove(this.tile.field_145851_c, this.tile.field_145848_d, this.tile.field_145849_e));
        }
    }
}

