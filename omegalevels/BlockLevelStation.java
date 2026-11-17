/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockContainer
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.renderer.texture.IIconRegister
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.IIcon
 *  net.minecraft.world.World
 */
package omegalevels;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import omegalevels.OmegaLevels;
import omegalevels.TileLevelStation;

public class BlockLevelStation
extends BlockContainer {
    @SideOnly(value=Side.CLIENT)
    private IIcon sTop;
    @SideOnly(value=Side.CLIENT)
    private IIcon sDown;
    @SideOnly(value=Side.CLIENT)
    private IIcon blockIcon;

    public BlockLevelStation() {
        super(Material.field_151573_f);
        this.func_149647_a(OmegaLevels.tab);
        this.func_149663_c("level_station");
        this.func_149711_c(4.0f);
    }

    public IIcon func_149691_a(int down, int top) {
        return down == 0 ? this.sDown : (down == 1 ? this.sTop : this.blockIcon);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_149651_a(IIconRegister IconRegister) {
        this.blockIcon = IconRegister.func_94245_a("omegalevels:ench_side");
        this.sTop = IconRegister.func_94245_a("omegalevels:ench_top");
        this.sDown = IconRegister.func_94245_a("omegalevels:ench_down");
    }

    public TileEntity func_149915_a(World world, int meta) {
        return new TileLevelStation();
    }

    @SideOnly(value=Side.CLIENT)
    public void func_149734_b(World par1World, int par2, int par3, int par4, Random par5Random) {
        super.func_149734_b(par1World, par2, par3, par4, par5Random);
        for (int var6 = par2 - 2; var6 <= par2 + 2; ++var6) {
            block1: for (int var7 = par4 - 2; var7 <= par4 + 2; ++var7) {
                if (var6 > par2 - 2 && var6 < par2 + 2 && var7 == par4 - 1) {
                    var7 = par4 + 2;
                }
                if (par5Random.nextInt(16) != 0) continue;
                for (int var8 = par3; var8 <= par3 + 1 && par1World.func_147437_c((var6 - par2) / 2 + par2, var8, (var7 - par4) / 2 + par4); ++var8) {
                    par1World.func_72869_a("enchantmenttable", (double)par2 + 0.5, (double)par3 + 2.0, (double)par4 + 0.5, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0f), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5);
                    if (!par1World.func_147437_c((var6 - par2) / 2 + par2, var8, (var7 - par4) / 2 + par4)) continue block1;
                    par1World.func_72869_a("enchantmenttable", (double)par2 + 0.5, (double)par3 + 2.0, (double)par4 + 0.5, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0f), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5);
                }
            }
        }
    }

    public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.field_72995_K) {
            player.openGui((Object)OmegaLevels.INSTANCE, 0, player.func_130014_f_(), x, y, z);
        }
        return true;
    }

    public void func_149749_a(World world, int x, int y, int z, Block block, int meta) {
        TileLevelStation tile = (TileLevelStation)world.func_147438_o(x, y, z);
        if (tile != null) {
            for (int i = 0; i < tile.func_70302_i_(); ++i) {
                ItemStack stack = tile.func_70301_a(i);
                if (stack == null) continue;
                float offsetX = new Random().nextFloat() * 0.8f + 0.1f;
                float offsetY = new Random().nextFloat() * 0.8f + 0.1f;
                float offsetZ = new Random().nextFloat() * 0.8f + 0.1f;
                while (stack.field_77994_a > 0) {
                    int size = new Random().nextInt(21) + 10;
                    if (size > stack.field_77994_a) {
                        size = stack.field_77994_a;
                    }
                    stack.field_77994_a -= size;
                    EntityItem entityItem = new EntityItem(world, (double)((float)x + offsetX), (double)((float)y + offsetY), (double)((float)z + offsetZ), new ItemStack(stack.func_77973_b(), size, stack.func_77960_j()));
                    if (stack.func_77942_o()) {
                        entityItem.func_92059_d().func_77982_d((NBTTagCompound)stack.func_77978_p().func_74737_b());
                    }
                    entityItem.field_70159_w = (float)new Random().nextGaussian() * 0.05f;
                    entityItem.field_70181_x = (float)new Random().nextGaussian() * 0.05f + 0.2f;
                    entityItem.field_70179_y = (float)new Random().nextGaussian() * 0.05f;
                    world.func_72838_d((Entity)entityItem);
                }
            }
            world.func_147453_f(x, y, z, block);
        }
        super.func_149749_a(world, x, y, z, block, meta);
    }
}

