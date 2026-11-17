/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ISidedInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.world.World
 *  net.minecraftforge.common.util.ForgeDirection
 */
package omegalevels;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import omegalevels.Config;
import omegalevels.ItemGem;
import omegalevels.ItemStabilizer;
import omegalevels.OmegaLevels;

public class TileLevelStation
extends TileEntity
implements ISidedInventory {
    public static final int TARGET = 80;
    private ItemStack[] itemStacks = new ItemStack[4];
    private boolean startImprove;
    public int progress;

    private Config.ImproveData getImproveData() {
        if (this.itemStacks[0] == null || this.itemStacks[1] == null) {
            return null;
        }
        return Optional.ofNullable(OmegaLevels.config.improves).map(improves -> (Map)improves.get(ItemGem.EnumType.byOrdinal(this.itemStacks[0].func_77960_j()).name().toLowerCase(Locale.ROOT))).map(improvesData -> (Config.ImproveData)improvesData.get(OmegaLevels.getItemStackLevel(this.itemStacks[1]) + 1)).orElse(null);
    }

    private int getChance(Config.ImproveData improveData, ItemStack stabilizerStack, int level) {
        if (improveData == null) {
            return 0;
        }
        return Math.min(100, improveData.chance + (stabilizerStack != null ? OmegaLevels.config.stabilizers.get(ItemStabilizer.EnumType.byOrdinal(stabilizerStack.func_77960_j()).name().toLowerCase(Locale.ROOT)) : 0));
    }

    public int getChance() {
        return this.getChance(this.getImproveData(), this.itemStacks[2], OmegaLevels.getItemStackLevel(this.itemStacks[1]));
    }

    public void improve() {
        this.startImprove = true;
    }

    public void func_145845_h() {
        if (this.field_145850_b.field_72995_K) {
            return;
        }
        boolean improve = this.progress > 0;
        boolean bl = improve;
        if (this.startImprove) {
            improve = true;
            this.startImprove = false;
        }
        if (improve && this.itemStacks[0] != null && this.itemStacks[1] != null && this.itemStacks[3] == null) {
            Config.ImproveData improveData = this.getImproveData();
            if (improveData != null) {
                ++this.progress;
                if (this.progress == 80) {
                    this.func_70298_a(0, 1);
                    ItemStack itemStack = this.func_70298_a(1, 1);
                    int itemStackLevel = OmegaLevels.getItemStackLevel(itemStack);
                    ItemStack stabilizerStack = this.func_70298_a(2, 1);
                    if (OmegaLevels.isChance(this.getChance(improveData, stabilizerStack, itemStackLevel))) {
                        if (++itemStackLevel < TileLevelStation.getItemMaxLevel(itemStack) && OmegaLevels.isChance(improveData.chanceSkipLevel)) {
                            ++itemStackLevel;
                        }
                    } else {
                        if (improveData.decreaseLevelOnFail) {
                            --itemStackLevel;
                        }
                        if (improveData.breakOnFail) {
                            itemStackLevel = -1;
                        }
                    }
                    if (itemStackLevel == -1) {
                        itemStack = null;
                    } else {
                        OmegaLevels.setItemStackLevel(itemStack, itemStackLevel);
                    }
                    this.func_70299_a(3, itemStack);
                    this.progress = 0;
                }
            } else {
                this.progress = 0;
            }
        } else {
            this.progress = 0;
        }
    }

    public int getChanceSkipLevel() {
        Config.ImproveData improveData = this.getImproveData();
        if (improveData != null) {
            return improveData.chanceSkipLevel;
        }
        return 0;
    }

    public int[] func_94128_d(int side) {
        int[] arrn;
        if (side == ForgeDirection.DOWN.ordinal()) {
            int[] arrn2;
            arrn = arrn2 = new int[1];
            arrn2[0] = 1;
        } else if (side == ForgeDirection.UP.ordinal()) {
            int[] arrn3 = new int[2];
            arrn3[0] = 0;
            arrn = arrn3;
            arrn3[1] = 2;
        } else {
            int[] arrn4 = new int[1];
            arrn = arrn4;
            arrn4[0] = 3;
        }
        return arrn;
    }

    public boolean func_102007_a(int slot, ItemStack item, int side) {
        return this.func_94041_b(slot, item);
    }

    public boolean func_102008_b(int slot, ItemStack item, int side) {
        return slot == 3;
    }

    public int func_70302_i_() {
        return this.itemStacks.length;
    }

    public ItemStack func_70301_a(int slot) {
        return this.itemStacks[slot];
    }

    public ItemStack func_70298_a(int slot, int count) {
        if (this.itemStacks[slot] != null) {
            if (this.itemStacks[slot].field_77994_a <= count) {
                ItemStack itemStack = this.itemStacks[slot];
                this.itemStacks[slot] = null;
                return itemStack;
            }
            ItemStack itemStack = this.itemStacks[slot].func_77979_a(count);
            if (this.itemStacks[slot].field_77994_a == 0) {
                this.itemStacks[slot] = null;
            }
            return itemStack;
        }
        return null;
    }

    public ItemStack func_70304_b(int slot) {
        if (this.itemStacks[slot] != null) {
            ItemStack itemStack = this.itemStacks[slot];
            this.itemStacks[slot] = null;
            return itemStack;
        }
        return null;
    }

    public void func_70299_a(int slot, ItemStack itemStack) {
        this.itemStacks[slot] = itemStack;
        if (itemStack != null && itemStack.field_77994_a > this.func_70297_j_()) {
            itemStack.field_77994_a = this.func_70297_j_();
        }
    }

    public String func_145825_b() {
        return "container.levelStation";
    }

    public boolean func_145818_k_() {
        return false;
    }

    public int func_70297_j_() {
        return 64;
    }

    public boolean func_70300_a(EntityPlayer player) {
        return player.func_70092_e((double)this.field_145851_c + 0.5, (double)this.field_145848_d + 0.5, (double)this.field_145849_e + 0.5) <= 64.0;
    }

    public void func_70295_k_() {
    }

    public void func_70305_f() {
    }

    public boolean func_94041_b(int slot, ItemStack itemStack) {
        switch (slot) {
            case 0: {
                return itemStack != null && itemStack.func_77973_b() == OmegaLevels.gem;
            }
            case 1: {
                return itemStack != null ? Boolean.valueOf(Stream.concat(OmegaLevels.config.weapons.keySet().stream(), OmegaLevels.config.armors.keySet().stream().flatMap(Collection::stream)).anyMatch(Predicate.isEqual((Object)itemStack.func_77973_b())) && !TileLevelStation.isThisItemMaxedOut(itemStack)) : null;
            }
            case 2: {
                return itemStack != null && itemStack.func_77973_b() == OmegaLevels.stabilizer;
            }
        }
        return false;
    }

    public static boolean isThisItemMaxedOut(ItemStack itemStack) {
        if (OmegaLevels.getItemStackLevel(itemStack) == 0) {
            return false;
        }
        AtomicBoolean flag = new AtomicBoolean(true);
        OmegaLevels.config.weapons.forEach((item, levelEffects) -> {
            if (itemStack != null && itemStack.func_77973_b() == item && levelEffects.containsKey(OmegaLevels.getItemStackLevel(itemStack) + 1)) {
                flag.set(false);
            }
        });
        OmegaLevels.config.armors.forEach((items, levelEffects) -> {
            if (itemStack != null && items.contains((Object)itemStack.func_77973_b()) && levelEffects.containsKey(OmegaLevels.getItemStackLevel(itemStack) + 1)) {
                flag.set(false);
            }
        });
        return flag.get();
    }

    public static boolean isItemWeapon(ItemStack stack) {
        if (stack == null) {
            return false;
        }
        AtomicBoolean isa = new AtomicBoolean(false);
        OmegaLevels.config.weapons.forEach((item, levelEffects) -> {
            if (stack.func_77973_b() == item) {
                isa.set(true);
            }
        });
        return isa.get();
    }

    public static int getItemMaxLevel(ItemStack itemStack) {
        if (OmegaLevels.getItemStackLevel(itemStack) == 0) {
            return -1;
        }
        AtomicInteger lastMaxLevel = new AtomicInteger(-1);
        OmegaLevels.config.weapons.forEach((item, levelEffects) -> {
            if (itemStack != null && itemStack.func_77973_b() == item && levelEffects.containsKey(OmegaLevels.getItemStackLevel(itemStack) + 1)) {
                lastMaxLevel.set(OmegaLevels.getItemStackLevel(itemStack) + 1);
            }
        });
        OmegaLevels.config.armors.forEach((items, levelEffects) -> {
            if (itemStack != null && items.contains((Object)itemStack.func_77973_b()) && levelEffects.containsKey(OmegaLevels.getItemStackLevel(itemStack) + 1)) {
                lastMaxLevel.set(OmegaLevels.getItemStackLevel(itemStack) + 1);
            }
        });
        return lastMaxLevel.get();
    }

    public void func_145841_b(NBTTagCompound nbt) {
        super.func_145841_b(nbt);
        NBTTagList itemStacksTag = new NBTTagList();
        for (int i = 0; i < this.itemStacks.length; ++i) {
            if (this.itemStacks[i] == null) continue;
            NBTTagCompound slotData = new NBTTagCompound();
            slotData.func_74774_a("Slot", (byte)i);
            this.itemStacks[i].func_77955_b(slotData);
            itemStacksTag.func_74742_a((NBTBase)slotData);
        }
        nbt.func_74782_a("Items", (NBTBase)itemStacksTag);
        nbt.func_74768_a("Progress", this.progress);
    }

    public void func_145839_a(NBTTagCompound nbt) {
        super.func_145839_a(nbt);
        NBTTagList itemStacksTag = nbt.func_150295_c("Items", 10);
        this.itemStacks = new ItemStack[this.func_70302_i_()];
        for (int i = 0; i < itemStacksTag.func_74745_c(); ++i) {
            NBTTagCompound slotData = itemStacksTag.func_150305_b(i);
            byte slot = slotData.func_74771_c("Slot");
            if (slot < 0 || slot >= this.itemStacks.length) continue;
            this.itemStacks[slot] = ItemStack.func_77949_a((NBTTagCompound)slotData);
        }
        this.progress = nbt.func_74762_e("Progress");
    }
}

