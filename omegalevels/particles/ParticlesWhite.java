/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.particle.EntityEnchantmentTableParticleFX
 *  net.minecraft.world.World
 */
package omegalevels.particles;

import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.world.World;

public class ParticlesWhite
extends EntityEnchantmentTableParticleFX {
    public ParticlesWhite(World parWorld, double parX, double parY, double parZ, double parMotionX, double parMotionY, double parMotionZ) {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        this.func_70536_a((int)(Math.random() * 25.0) + 225);
        this.field_70544_f = 0.7f;
        this.func_70538_b(1.0f, 1.0f, 1.0f);
    }
}

