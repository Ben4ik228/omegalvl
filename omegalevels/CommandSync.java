/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  net.minecraft.command.CommandBase
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.IChatComponent
 */
package omegalevels;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import omegalevels.OmegaLevels;
import omegalevels.PacketConfig;

public class CommandSync
extends CommandBase {
    public String func_71517_b() {
        return "syncLvl";
    }

    public String func_71518_a(ICommandSender commandSender) {
        return "/syncLvl";
    }

    public void func_71515_b(ICommandSender commandSender, String[] args) {
        OmegaLevels.INSTANCE.loadConfigFile();
        OmegaLevels.readConfig(OmegaLevels.INSTANCE.jsonString);
        OmegaLevels.channel.sendToAll((IMessage)new PacketConfig(OmegaLevels.INSTANCE.jsonString));
        if (commandSender instanceof EntityPlayer) {
            commandSender.func_145747_a((IChatComponent)new ChatComponentText((Object)EnumChatFormatting.BLUE + "\u0421\u0438\u043d\u0445\u0440\u043e\u043d\u0438\u0437\u0430\u0446\u0438\u044f \u043f\u0440\u043e\u043a\u0430\u0447\u0435\u043a..."));
        }
    }

    public int func_82362_a() {
        return 3;
    }
}

