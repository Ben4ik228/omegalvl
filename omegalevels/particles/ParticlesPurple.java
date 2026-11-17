/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.particle.EntityPortalFX
 *  net.minecraft.world.World
 */
package omegalevels.particles;

import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.world.World;

public class ParticlesPurple
extends EntityPortalFX {
    public ParticlesPurple(World parWorld, double parX, double parY, double parZ, double parMotionX, double parMotionY, double parMotionZ) {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        this.func_70536_a((int)(Math.random() * 7.0) + 160);
        this.field_70544_f = 0.7f;
        this.func_70538_b(0.5f, 0.0f, 0.5f);
    }
}

