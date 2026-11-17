/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.util.Vec3
 *  net.minecraft.world.World
 */
package omegalevels;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import omegalevels.Config;
import omegalevels.OmegaLevels;

public class AsmHandlers {
    public static double getDamageDistance(EntityPlayer player, Entity entity) {
        AtomicInteger result = new AtomicInteger(OmegaLevels.Proxy.INSTANCE.isLongDistance(player, entity) ? 6 : 3);
        Map<String, Config.EffectData> effects = OmegaLevels.getWeaponEffects(player);
        if (effects != null) {
            effects.forEach((effectName, effectData) -> {
                if ("distance".equals(effectName) && effectData != null) {
                    result.set(result.get() + effectData.amount);
                }
            });
        }
        if (entity != null && !AsmHandlers.canPlayerSeeEntity(player, entity)) {
            return 0.0;
        }
        return result.get() * result.get();
    }

    private static boolean canPlayerSeeEntity(EntityPlayer player, Entity e) {
        if (player == null || e == null) {
            return false;
        }
        double[][] offs = new double[][]{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, player.func_70047_e(), 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, e.func_70047_e(), 0.0}, {0.0, player.func_70047_e(), 0.0, 0.0, e.func_70047_e(), 0.0}, {0.0, 0.5, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.5, 0.0}, {0.0, 0.5, 0.0, 0.0, 0.5, 0.0}};
        World w = player.field_70170_p;
        for (double[] sub : offs) {
            Vec3 v2;
            Vec3 v1 = Vec3.func_72443_a((double)(player.field_70165_t + sub[0]), (double)(player.field_70163_u + sub[1]), (double)(player.field_70161_v + sub[2]));
            if (w.func_72933_a(v1, v2 = Vec3.func_72443_a((double)(e.field_70165_t + sub[3]), (double)(e.field_70163_u + sub[4]), (double)(e.field_70161_v + sub[5]))) != null) continue;
            return true;
        }
        return false;
    }
}

