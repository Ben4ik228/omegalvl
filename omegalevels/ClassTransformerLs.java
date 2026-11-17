/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.IClassTransformer
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.MethodVisitor
 */
package omegalevels;

import java.io.PrintStream;
import java.util.Objects;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class ClassTransformerLs
implements IClassTransformer {
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        final boolean obfuscated = !Objects.equals(name, transformedName);
        boolean bl = obfuscated;
        switch (transformedName) {
            case "net.minecraft.entity.item.EntityItemFrame": {
                ClassWriter classWriter = new ClassWriter(0);
                new ClassReader(basicClass).accept(new ClassVisitor(327680, (ClassVisitor)classWriter){

                    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                        if (name.equals(obfuscated ? "c" : "interactFirst") && desc.equals(obfuscated ? "(Lyz;)Z" : "(Lnet/minecraft/entity/player/EntityPlayer;)Z")) {
                            return new MethodVisitor(327680, this.cv.visitMethod(access, name, desc, signature, exceptions)){

                                public void visitCode() {
                                    this.mv.visitInsn(3);
                                    this.mv.visitInsn(172);
                                    super.visitCode();
                                }
                            };
                        }
                        return this.cv.visitMethod(access, name, desc, signature, exceptions);
                    }

                }, 0);
                return classWriter.toByteArray();
            }
            case "net.minecraft.block.BlockDispenser": {
                ClassWriter classWriter = new ClassWriter(0);
                new ClassReader(basicClass).accept(new ClassVisitor(327680, (ClassVisitor)classWriter){

                    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                        if (name.equals(obfuscated ? "a" : "updateTick") && desc.equals(obfuscated ? "(Lahb;IIILjava/util/Random;)V" : "(Lnet/minecraft/world/World;IIILjava/util/Random;)V")) {
                            System.out.println("VisitMethod");
                            return new MethodVisitor(327680, this.cv.visitMethod(access, name, desc, signature, exceptions)){

                                public void visitCode() {
                                    this.mv.visitInsn(177);
                                    super.visitCode();
                                }
                            };
                        }
                        return this.cv.visitMethod(access, name, desc, signature, exceptions);
                    }

                }, 0);
                return classWriter.toByteArray();
            }
            case "net.minecraft.network.NetHandlerPlayServer": {
                ClassWriter classWriter = new ClassWriter(0);
                new ClassReader(basicClass).accept(new ClassVisitor(327680, (ClassVisitor)classWriter){

                    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                        if (name.equals(obfuscated ? "a" : "processUseEntity") && desc.equals(obfuscated ? "(Lja;)V" : "(Lnet/minecraft/network/play/client/C02PacketUseEntity;)V")) {
                            return new MethodVisitor(327680, this.cv.visitMethod(access, name, desc, signature, exceptions)){

                                public void visitLdcInsn(Object cst) {
                                    if (cst.equals(9.0) || cst.equals(36.0)) {
                                        this.mv.visitVarInsn(25, 0);
                                        this.mv.visitFieldInsn(180, obfuscated ? "nh" : "net/minecraft/network/NetHandlerPlayServer", obfuscated ? "field_147369_b" : "playerEntity", obfuscated ? "Lmw;" : "Lnet/minecraft/entity/player/EntityPlayerMP;");
                                        this.mv.visitVarInsn(25, 3);
                                        this.mv.visitMethodInsn(184, "omegalevels/AsmHandlers", "getDamageDistance", obfuscated ? "(Lyz;Lsa;)D" : "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;)D", false);
                                    } else {
                                        super.visitLdcInsn(cst);
                                    }
                                }
                            };
                        }
                        return this.cv.visitMethod(access, name, desc, signature, exceptions);
                    }

                }, 0);
                return classWriter.toByteArray();
            }
            case "net.minecraft.entity.EntityLivingBase": {
                break;
            }
        }
        return basicClass;
    }

}

