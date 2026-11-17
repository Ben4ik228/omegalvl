/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.IIcon
 *  net.minecraft.util.StatCollector
 */
package omegalevels;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import omegalevels.OmegaLevels;

public class ItemGem
extends Item {
    public ItemGem() {
        this.func_77637_a(OmegaLevels.tab);
        this.func_77655_b("gem");
        this.func_77627_a(true);
        this.func_77656_e(0);
    }

    public void func_94581_a(IIconRegister iconRegister) {
        Arrays.stream(EnumType.values()).forEach(type -> type.register(iconRegister));
    }

    public IIcon func_77617_a(int meta) {
        return EnumType.byOrdinal((int)meta).icon;
    }

    public String func_77667_c(ItemStack itemStack) {
        return super.func_77658_a() + "." + EnumType.byOrdinal(itemStack.func_77960_j()).name().toLowerCase(Locale.ROOT);
    }

    public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
        if (EnumType.byOrdinal(p_77624_1_.func_77960_j()) == EnumType.RED) {
            p_77624_3_.add((Object)EnumChatFormatting.RED + StatCollector.func_74837_a((String)"tooltip.broke", (Object[])new Object[0]));
        }
        if (EnumType.byOrdinal(p_77624_1_.func_77960_j()) == EnumType.GREEN) {
            p_77624_3_.add((Object)EnumChatFormatting.GREEN + StatCollector.func_74837_a((String)"tooltip.green", (Object[])new Object[0]));
            p_77624_3_.add((Object)EnumChatFormatting.GREEN + StatCollector.func_74837_a((String)"tooltip.green1", (Object[])new Object[0]));
        }
        if (EnumType.byOrdinal(p_77624_1_.func_77960_j()) == EnumType.BLUE) {
            p_77624_3_.add((Object)EnumChatFormatting.BLUE + StatCollector.func_74837_a((String)"tooltip.blue", (Object[])new Object[0]));
        }
        if (EnumType.byOrdinal(p_77624_1_.func_77960_j()) == EnumType.PURPLE) {
            p_77624_3_.add((Object)EnumChatFormatting.DARK_PURPLE + StatCollector.func_74837_a((String)"tooltip.purple", (Object[])new Object[0]));
        }
        if (EnumType.byOrdinal(p_77624_1_.func_77960_j()) == EnumType.ORANGE) {
            p_77624_3_.add((Object)EnumChatFormatting.RED + StatCollector.func_74837_a((String)"tooltip.orange", (Object[])new Object[0]));
        }
    }

    public void func_150895_a(Item item, CreativeTabs tab, List variants) {
        IntStream.range(0, EnumType.values().length).mapToObj(i -> new ItemStack(item, 1, i)).forEach(variants::add);
    }

    public static enum EnumType {
        RED,
        BLUE,
        GREEN,
        PURPLE,
        ORANGE;

        public IIcon icon;

        public static EnumType byOrdinal(int ordinal) {
            return EnumType.values()[ordinal >= 0 && ordinal < EnumType.values().length ? ordinal : 0];
        }

        public void register(IIconRegister iconRegister) {
            this.icon = iconRegister.func_94245_a("omegalevels:gem_" + this.name().toLowerCase(Locale.ROOT));
        }
    }

}

