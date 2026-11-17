/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.ICrafting
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 *  net.minecraft.inventory.SlotFurnace
 *  net.minecraft.item.ItemStack
 */
package omegalevels;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import omegalevels.TileLevelStation;

public class ContainerLevelStation
extends Container {
    public final TileLevelStation tile;
    private int lastCookTime;

    public ContainerLevelStation(InventoryPlayer inventoryPlayer, final TileLevelStation tile) {
        int i;
        this.tile = tile;
        this.func_75146_a(new Slot((IInventory)tile, 0, 23, 11){

            public boolean func_75214_a(ItemStack itemStack) {
                return tile.func_94041_b(this.field_75222_d, itemStack);
            }
        });
        this.func_75146_a(new Slot((IInventory)tile, 1, 45, 32){

            public boolean func_75214_a(ItemStack itemStack) {
                return tile.func_94041_b(this.field_75222_d, itemStack);
            }
        });
        this.func_75146_a(new Slot((IInventory)tile, 2, 23, 53){

            public boolean func_75214_a(ItemStack itemStack) {
                return tile.func_94041_b(this.field_75222_d, itemStack);
            }
        });
        this.func_75146_a((Slot)new SlotFurnace(inventoryPlayer.field_70458_d, (IInventory)tile, 3, 125, 32));
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.func_75146_a(new Slot((IInventory)inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.func_75146_a(new Slot((IInventory)inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    public boolean func_75145_c(EntityPlayer player) {
        return this.tile.func_70300_a(player);
    }

    public ItemStack func_82846_b(EntityPlayer player, int slotIndex) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.field_75151_b.get(slotIndex);
        if (slot != null && slot.func_75216_d()) {
            ItemStack stackInSlot = slot.func_75211_c();
            itemStack = stackInSlot.func_77946_l();
            if (slotIndex < this.tile.func_70302_i_()) {
                if (!this.func_75135_a(stackInSlot, this.tile.func_70302_i_(), this.field_75151_b.size(), true)) {
                    return null;
                }
            } else {
                boolean found = false;
                for (int i = 0; i < this.tile.func_70302_i_(); ++i) {
                    if (!this.func_75139_a(i).func_75214_a(itemStack) || !this.func_75135_a(stackInSlot, i, i + 1, true)) continue;
                    found = true;
                    break;
                }
                if (!found) {
                    return null;
                }
            }
            if (stackInSlot.field_77994_a == 0) {
                slot.func_75215_d(null);
            } else {
                slot.func_75218_e();
            }
        }
        return itemStack;
    }

    public void func_75142_b() {
        super.func_75142_b();
        for (Object crafter : this.field_75149_d) {
            ICrafting crafting = (ICrafting)crafter;
            if (this.lastCookTime == this.tile.progress) continue;
            crafting.func_71112_a((Container)this, 0, this.tile.progress);
        }
        this.lastCookTime = this.tile.progress;
    }

    public void func_75137_b(int progressId, int progressValue) {
        if (progressId == 0) {
            this.tile.progress = progressValue;
        }
    }

}

