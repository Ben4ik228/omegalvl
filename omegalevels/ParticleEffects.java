/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package omegalevels;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import omegalevels.OmegaLevels;

public class ParticleEffects {
    @SideOnly(value=Side.CLIENT)
    static void spawnParticles(World worldObj, EntityPlayer player) {
        ItemStack Boots = player.field_71071_by.func_70440_f(0);
        ItemStack Legs = player.field_71071_by.func_70440_f(1);
        ItemStack Body = player.field_71071_by.func_70440_f(2);
        ItemStack Helmet = player.field_71071_by.func_70440_f(3);
        if (Boots == null || Legs == null || Body == null || Helmet == null) {
            return;
        }
        Random rand = new Random();
        if (OmegaLevels.getItemStackLevel(Helmet) == 1 && OmegaLevels.getItemStackLevel(Body) == 1 && OmegaLevels.getItemStackLevel(Legs) == 1 && OmegaLevels.getItemStackLevel(Boots) == 1 && rand.nextInt(15) == 1) {
            worldObj.func_72869_a("fireworksSpark", player.field_70165_t + (rand.nextDouble() - 0.5) * ((double)player.field_70130_N + 1.5), player.field_70163_u + rand.nextDouble() * ((double)player.field_70131_O + 0.5) - (double)player.field_70129_M, player.field_70161_v + (rand.nextDouble() - 0.5) * ((double)player.field_70130_N + 1.5), 0.0, 0.0, 0.0);
        }
        if (OmegaLevels.getItemStackLevel(Helmet) == 2 && OmegaLevels.getItemStackLevel(Body) == 2 && OmegaLevels.getItemStackLevel(Legs) == 2 && OmegaLevels.getItemStackLevel(Boots) == 2 && rand.nextInt(3) == 1) {
            worldObj.func_72869_a("splash", player.field_70165_t + (rand.nextDouble() - 0.5) * ((double)player.field_70130_N + 1.5), player.field_70163_u + rand.nextDouble() * ((double)player.field_70131_O + 0.5) - (double)player.field_70129_M, player.field_70161_v + (rand.nextDouble() - 0.5) * ((double)player.field_70130_N + 1.5), 0.0, 0.0, 0.0);
        }
        if (OmegaLevels.getItemStackLevel(Helmet) == 3 && OmegaLevels.getItemStackLevel(Body) == 3 && OmegaLevels.getItemStackLevel(Legs) == 3 && OmegaLevels.getItemStackLevel(Boots) == 3 && rand.nextInt(12) == 1) {
            worldObj.func_72869_a("happyVillager", player.field_70165_t + (rand.nextDouble() - 0.5) * ((double)player.field_70130_N + 1.5), player.field_70163_u + rand.nextDouble() * ((double)player.field_70131_O + 0.5) - (double)player.field_70129_M, player.field_70161_v + (rand.nextDouble() - 0.5) * ((double)player.field_70130_N + 1.5), 0.0, 0.0, 0.0);
        }
        if (OmegaLevels.getItemStackLevel(Helmet) == 4 && OmegaLevels.getItemStackLevel(Body) == 4 && OmegaLevels.getItemStackLevel(Legs) == 4 && OmegaLevels.getItemStackLevel(Boots) == 4 && rand.nextInt(7) == 1) {
            OmegaLevels.Proxy.ClientProxy.INSTANCE.generateParticlesRed(player);
        }
        if (rand.nextInt(8) == 1 && OmegaLevels.getItemStackLevel(Helmet) == 5 && OmegaLevels.getItemStackLevel(Body) == 5 && OmegaLevels.getItemStackLevel(Legs) == 5 && OmegaLevels.getItemStackLevel(Boots) == 5) {
            OmegaLevels.Proxy.ClientProxy.INSTANCE.generateParticlesPurple(player);
        }
        if (rand.nextInt(8) == 1 && OmegaLevels.getItemStackLevel(Helmet) == 6 && OmegaLevels.getItemStackLevel(Body) == 6 && OmegaLevels.getItemStackLevel(Legs) == 6 && OmegaLevels.getItemStackLevel(Boots) == 6) {
            OmegaLevels.Proxy.ClientProxy.INSTANCE.generateParticlesWhite(player);
        }
        if (rand.nextInt(8) == 1 && OmegaLevels.getItemStackLevel(Helmet) == 7 && OmegaLevels.getItemStackLevel(Body) == 7 && OmegaLevels.getItemStackLevel(Legs) == 7 && OmegaLevels.getItemStackLevel(Boots) == 7) {
            OmegaLevels.Proxy.ClientProxy.INSTANCE.generateParticlesYellow(player);
        }
    }
}

