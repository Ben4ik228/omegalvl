/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonParseException
 *  com.google.gson.reflect.TypeToken
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.Mod
 *  cpw.mods.fml.common.Mod$EventHandler
 *  cpw.mods.fml.common.Mod$Instance
 *  cpw.mods.fml.common.SidedProxy
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.event.FMLServerStartingEvent
 *  cpw.mods.fml.common.eventhandler.EventBus
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  cpw.mods.fml.common.gameevent.TickEvent
 *  cpw.mods.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  cpw.mods.fml.common.network.IGuiHandler
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  cpw.mods.fml.common.network.simpleimpl.IMessageHandler
 *  cpw.mods.fml.common.network.simpleimpl.MessageContext
 *  cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.divinerpg.utils.items.JourneyItemsArmor
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.particle.EffectRenderer
 *  net.minecraft.client.particle.EntityFX
 *  net.minecraft.command.ICommand
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.network.NetHandlerPlayServer
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionAttackDamage
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.FoodStats
 *  net.minecraft.util.RegistryNamespaced
 *  net.minecraft.util.StatCollector
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.EntityJoinWorldEvent
 *  net.minecraftforge.event.entity.living.LivingHurtEvent
 *  net.minecraftforge.event.entity.player.ItemTooltipEvent
 *  org.apache.commons.io.FileUtils
 *  org.apache.commons.lang3.tuple.Pair
 *  ru.harvax.OmegaHolograms
 */
package omegalevels;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.divinerpg.utils.items.JourneyItemsArmor;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.command.ICommand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAttackDamage;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.FoodStats;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import omegalevels.BlockLevelStation;
import omegalevels.CommandSync;
import omegalevels.Config;
import omegalevels.ContainerLevelStation;
import omegalevels.GuiLevelStation;
import omegalevels.ItemGem;
import omegalevels.ItemStabilizer;
import omegalevels.PacketConfig;
import omegalevels.PacketImprove;
import omegalevels.ParticleEffects;
import omegalevels.TileLevelStation;
import omegalevels.particles.ParticlesPurple;
import omegalevels.particles.ParticlesRed;
import omegalevels.particles.ParticlesWhite;
import omegalevels.particles.ParticlesYellow;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;
import ru.harvax.OmegaHolograms;

@Mod(modid="levels", name="Levels", version="1.8")
public class OmegaLevels {
    private Item boots = null;
    private Item body = null;
    private Item legs = null;
    private Item helmet = null;
    private final UUID healthId = UUID.fromString("c90a97d0-8d1e-11e9-bc42-526af7264f64");
    private final UUID damageId = UUID.fromString("fcb925a8-aaea-11e9-a2a3-2a2ae2dbcce4");
    static final SimpleNetworkWrapper channel = NetworkRegistry.INSTANCE.newSimpleChannel("levels");
    public static CreativeTabs tab = new CreativeTabs("omegalevels"){

        public Item func_78016_d() {
            return Item.func_150898_a((Block)levelStation);
        }
    };
    public static BlockLevelStation levelStation;
    public static ItemGem gem;
    public static ItemStabilizer stabilizer;
    private static Potion damage;
    @Mod.Instance
    public static OmegaLevels INSTANCE;
    static Config config;
    private File suggestedConfigurationFile;
    String jsonString;

    @Mod.EventHandler
    public void onFMLPreInitialization(FMLPreInitializationEvent event) {
        this.suggestedConfigurationFile = event.getSuggestedConfigurationFile();
        levelStation = new BlockLevelStation();
        GameRegistry.registerBlock((Block)levelStation, (String)"level_station");
        GameRegistry.registerTileEntity(TileLevelStation.class, (String)"level_station");
        gem = new ItemGem();
        GameRegistry.registerItem((Item)gem, (String)"gem");
        stabilizer = new ItemStabilizer();
        GameRegistry.registerItem((Item)stabilizer, (String)"stabilizer");
        damage = new PotionAttackDamage(31, false, 964304){
            {
                this.func_76390_b("potion.damageBoost");
                this.func_111184_a(SharedMonsterAttributes.field_111264_e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 3.0, 2);
            }

            public double func_111183_a(int p_111183_1_, AttributeModifier p_111183_2_) {
                return Float.intBitsToFloat(p_111183_1_) - 1.0f;
            }
        };
        channel.registerMessage((arg_0, arg_1) -> this.receiveConfig(arg_0, arg_1), PacketConfig.class, 0, Side.CLIENT);
        channel.registerMessage((arg_0, arg_1) -> this.receiveImprove(arg_0, arg_1), PacketImprove.class, 1, Side.SERVER);
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)INSTANCE, (IGuiHandler)Proxy.INSTANCE);
        MinecraftForge.EVENT_BUS.register((Object)INSTANCE);
        FMLCommonHandler.instance().bus().register((Object)INSTANCE);
    }

    private IMessage receiveConfig(PacketConfig var1, MessageContext var2) {
        OmegaLevels.readConfig(var1.jsonString);
        return null;
    }

    private IMessage receiveImprove(PacketImprove var1, MessageContext var2) {
        TileEntity tileEntity = var2.getServerHandler().field_147369_b.field_70170_p.func_147438_o(var1.x, var1.y, var1.z);
        System.out.println("[Debug] trying to open container");
        if (tileEntity instanceof TileLevelStation) {
            TileLevelStation tile = (TileLevelStation)tileEntity;
            tile.improve();
        }
        return null;
    }

    @Mod.EventHandler
    public void onFMLServerStarting(FMLServerStartingEvent event) {
        this.loadConfigFile();
        event.registerServerCommand((ICommand)new CommandSync());
        OmegaLevels.readConfig(this.jsonString);
    }

    public void loadConfigFile() {
        try {
            File file = new File(this.suggestedConfigurationFile.getPath().replaceAll("cfg$", "json"));
            System.out.println(file);
            if (file.exists()) {
                System.out.println(file);
                this.jsonString = FileUtils.readFileToString((File)file);
            } else {
                this.jsonString = "{}";
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public void onClientTick(TickEvent.PlayerTickEvent event) {
        Random rand = new Random();
        ItemStack stackBoots = event.player.field_71071_by.func_70440_f(0);
        ItemStack stackLegs = event.player.field_71071_by.func_70440_f(1);
        ItemStack stackBody = event.player.field_71071_by.func_70440_f(2);
        ItemStack stackHelmet = event.player.field_71071_by.func_70440_f(3);
        this.boots = stackBoots != null ? stackBoots.func_77973_b() : null;
        this.body = stackBody != null ? stackBody.func_77973_b() : null;
        this.legs = stackLegs != null ? stackLegs.func_77973_b() : null;
        Item item = this.helmet = stackHelmet != null ? stackHelmet.func_77973_b() : null;
        if (this.boots == JourneyItemsArmor.flameBoots && this.body == JourneyItemsArmor.flameChestPlate && this.legs == JourneyItemsArmor.flameLeggings && this.helmet == JourneyItemsArmor.flameHelmet) {
            event.player.field_70170_p.func_72869_a("flame", event.player.field_70165_t + (rand.nextDouble() - 0.5) * ((double)event.player.field_70130_N + 1.5), event.player.field_70163_u + rand.nextDouble() * ((double)event.player.field_70131_O + 0.5) - (double)event.player.field_70129_M, event.player.field_70161_v + (rand.nextDouble() - 0.5) * ((double)event.player.field_70130_N + 1.5), 0.0, 0.0, 0.0);
        }
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayerMP) {
            channel.sendTo((IMessage)new PacketConfig(this.jsonString), (EntityPlayerMP)event.entity);
        }
    }

    public static void readConfig(String jsonString) {
        config = (Config)new GsonBuilder().registerTypeAdapter(Item.class, (Object)((JsonDeserializer)(json, typeOfT, context) -> (Item)Item.field_150901_e.func_82594_a(json.getAsString()))).registerTypeAdapter(new TypeToken<Map<Set<Item>, Map<Integer, Map<String, Config.EffectData>>>>(){}.getType(), (Object)((JsonDeserializer)(json, typeOfT, context) -> {
            List list = (List)context.deserialize(json, new TypeToken<List<Entry<Set<Item>, Map<Integer, Map<String, Config.EffectData>>>>>(){}.getType());
            return list.stream().collect(Collectors.toMap(entry -> (Set)entry.key, entry -> (Map)entry.value));
        })).create().fromJson(jsonString, Config.class);
    }

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
        Pair<Map<String, Config.EffectData>, Boolean> allEffects = OmegaLevels.getAllEffects(event.itemStack);
        if (allEffects == null) {
            return;
        }
        int level = OmegaLevels.getItemStackLevel(event.itemStack);
        if (level != 0) {
            event.toolTip.add(" ");
            if (TileLevelStation.isThisItemMaxedOut(event.itemStack)) {
                event.toolTip.add("\u00a7y" + StatCollector.func_74837_a((String)"tooltip.maxedout", (Object[])new Object[]{level}));
            }
            if (level == 1) {
                event.toolTip.add((Object)EnumChatFormatting.WHITE + StatCollector.func_74837_a((String)"tooltip.level", (Object[])new Object[]{level}));
            }
            if (level == 2) {
                event.toolTip.add((Object)EnumChatFormatting.DARK_BLUE + StatCollector.func_74837_a((String)"tooltip.level", (Object[])new Object[]{level}));
            }
            if (level == 3) {
                event.toolTip.add((Object)EnumChatFormatting.GREEN + StatCollector.func_74837_a((String)"tooltip.level", (Object[])new Object[]{level}));
            }
            if (level == 4) {
                event.toolTip.add((Object)EnumChatFormatting.DARK_RED + StatCollector.func_74837_a((String)"tooltip.level", (Object[])new Object[]{level}));
            }
            if (level == 5) {
                event.toolTip.add((Object)EnumChatFormatting.DARK_PURPLE + StatCollector.func_74837_a((String)"tooltip.level", (Object[])new Object[]{level}));
            }
            if (level >= 6) {
                event.toolTip.add("\u00a7y" + StatCollector.func_74837_a((String)"tooltip.level", (Object[])new Object[]{level}));
            }
            if (((Boolean)allEffects.getRight()).booleanValue()) {
                event.toolTip.add(StatCollector.func_74838_a((String)"tooltip.armoreffects"));
            } else {
                event.toolTip.add(StatCollector.func_74838_a((String)"tooltip.effects"));
            }
        }
        HashSet unique = new HashSet();
        ((Map)allEffects.getLeft()).forEach((effectName, effectData) -> {
            String effectString = ">" + StatCollector.func_74838_a((String)("tooltip.effect." + effectName));
            for (Field field : effectData.getClass().getFields()) {
                try {
                    effectString = effectString.replaceAll("\\$\\{" + field.getName() + "}", field.get(effectData).toString());
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (!effectName.contains("unique")) {
                event.toolTip.add(effectString);
            } else {
                unique.add(effectString);
            }
        });
        if (!unique.isEmpty()) {
            event.toolTip.add(" ");
            if (((Boolean)allEffects.getRight()).booleanValue()) {
                event.toolTip.add(StatCollector.func_74838_a((String)"tooltip.hasUniqueArmor"));
            } else {
                event.toolTip.add(StatCollector.func_74838_a((String)"tooltip.hasUnique"));
            }
            event.toolTip.addAll(unique);
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == Side.CLIENT) {
            ParticleEffects.spawnParticles(event.player.field_70170_p, event.player);
        } else {
            EntityPlayer entityPlayer;
            System.out.println((Object)event.player.func_110144_aD());
            AtomicBoolean changedHealth = new AtomicBoolean(false);
            IAttributeInstance healthAttribute = event.player.func_110148_a(SharedMonsterAttributes.field_111267_a);
            AttributeModifier healthModifier = healthAttribute.func_111127_a(this.healthId);
            AtomicBoolean changedDamage = new AtomicBoolean(false);
            IAttributeInstance damageAttribute = event.player.func_110148_a(SharedMonsterAttributes.field_111264_e);
            AttributeModifier damageModifier = damageAttribute.func_111127_a(this.damageId);
            OmegaLevels.getWeaponEffects(event.player).forEach((effectName, effectData) -> {
                if (effectName.equals("damage")) {
                    if (damageModifier == null) {
                        System.out.println("set attribute damage");
                        AttributeModifier newMod = new AttributeModifier(this.damageId, "damageBoost", (double)effectData.amount, 0).func_111168_a(false);
                        damageAttribute.func_111121_a(newMod);
                    }
                    changedDamage.set(true);
                }
            });
            OmegaLevels.getArmorEffects(event.player).forEach((effectName, effectData) -> {
                if (effectName.equals("health")) {
                    if (healthModifier == null) {
                        System.out.println("set attribute health");
                        AttributeModifier newMod = new AttributeModifier(this.healthId, "healthBoost", (double)effectData.amount, 0).func_111168_a(false);
                        healthAttribute.func_111121_a(newMod);
                    }
                    changedHealth.set(true);
                }
                if (effectName.equals("speed")) {
                    event.player.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 2, effectData.amount - 1, true));
                }
                if (effectName.equals("regeneration") && (long)(event.player.field_70173_aa % 10) == 0L) {
                    event.player.func_70691_i((float)effectData.amount / 4.0f);
                }
                if (effectName.equals("saturation") && (long)event.player.field_70173_aa % (long)(effectData.time * 20) == 0L) {
                    event.player.func_71024_bL().func_75122_a(effectData.amount / 2, 0.1f);
                    if (event.player.func_71024_bL().func_75116_a() < 20) {
                        OmegaHolograms.INSTANCE.sendText("\u041d\u0430\u0441\u044b\u0449\u0435\u043d\u0438\u0435", 1042026, (Entity)event.player);
                    }
                }
            });
            if (!changedHealth.get() && healthModifier != null) {
                System.out.println("remove  health attribute");
                healthAttribute.func_111124_b(healthModifier);
                entityPlayer = event.player;
                if (entityPlayer.func_110143_aJ() > entityPlayer.func_110138_aP()) {
                    entityPlayer.func_70606_j(entityPlayer.func_110138_aP());
                }
            }
            if (!changedDamage.get() && damageModifier != null) {
                System.out.println("remove  damage attribute");
                damageAttribute.func_111124_b(damageModifier);
                entityPlayer = event.player;
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent e) {
        if (e.source != null && e.source.func_76346_g() != null) {
            EntityPlayer player;
            if (e.entityLiving instanceof EntityPlayer) {
                player = (EntityPlayer)e.entityLiving;
                OmegaLevels.getArmorEffects(player).forEach((effectName, effectData) -> {
                    if (effectName.equals("unique.return") && OmegaLevels.isChance(effectData)) {
                        e.source.func_76346_g().func_70097_a(DamageSource.func_76358_a((EntityLivingBase)player), e.ammount * (float)effectData.amount / 100.0f);
                    }
                    if (effectName.equals("evasion") && OmegaLevels.isChance(effectData)) {
                        OmegaHolograms.INSTANCE.sendText("\u0423\u043a\u043b\u043e\u043d!", 16777215, (Entity)player);
                        e.setCanceled(true);
                    }
                    if (effectName.equals("restore") && OmegaLevels.isChance(effectData)) {
                        player.func_70691_i((float)effectData.amount);
                    }
                });
            }
            if (e.source.func_76346_g() instanceof EntityPlayer) {
                player = (EntityPlayer)e.source.func_76346_g();
                OmegaLevels.getWeaponEffects(player).forEach((effectName, effectData) -> {
                    if (effectName.equals("unique.critical") && OmegaLevels.isChance(effectData)) {
                        e.ammount = e.ammount * (float)effectData.amount / 100.0f;
                        OmegaHolograms.INSTANCE.sendText("\u041a\u0440\u0438\u0442!", 10420224, (Entity)e.entityLiving);
                    }
                    if (effectName.equals("unique.speedAttack")) {
                        e.entityLiving.field_70172_ad -= effectData.amount;
                    }
                    if (effectName.equals("fire") && OmegaLevels.isChance(effectData)) {
                        e.entityLiving.func_70015_d(effectData.time);
                    }
                    if (effectName.equals("slow") && OmegaLevels.isChance(effectData)) {
                        e.entityLiving.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, effectData.time * 20, effectData.amount - 1, true));
                    }
                    if (effectName.equals("poison") && OmegaLevels.isChance(effectData)) {
                        e.entityLiving.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, effectData.time * 20, effectData.amount - 1, true));
                    }
                    if (effectName.equals("damage")) {
                        e.ammount += (float)effectData.amount;
                    }
                    if (effectName.equals("speedbreak")) {
                        ((EntityLivingBase)e.entity).func_70690_d(new PotionEffect(Potion.field_76422_e.field_76415_H, 3, effectData.amount - 1, true));
                    }
                });
            }
        }
    }

    public static boolean isChance(int chance) {
        return Math.random() <= (double)chance / 100.0;
    }

    public static boolean isChance(Config.EffectData effectData) {
        return OmegaLevels.isChance(effectData.chance);
    }

    public static int getItemStackLevel(ItemStack itemStack) {
        NBTTagCompound nbt;
        if (itemStack != null && itemStack.func_77942_o() && (nbt = itemStack.func_77978_p()).func_74764_b("LsLevel")) {
            return nbt.func_74762_e("LsLevel");
        }
        return 0;
    }

    public static void setItemStackLevel(ItemStack itemStack, int level) {
        if (itemStack.func_77942_o()) {
            NBTTagCompound nbt = itemStack.func_77978_p();
            if (level == 0) {
                if (nbt.func_74764_b("LsLevel")) {
                    nbt.func_82580_o("LsLevel");
                }
            } else {
                nbt.func_74768_a("LsLevel", level);
            }
        } else if (level != 0) {
            itemStack.func_77982_d(new NBTTagCompound());
            NBTTagCompound nbt = itemStack.func_77978_p();
            nbt.func_74768_a("LsLevel", level);
        }
    }

    public static Map<String, Config.EffectData> getWeaponEffects(EntityPlayer player) {
        ItemStack itemStack = player.func_70694_bm();
        AtomicReference effects = new AtomicReference(Collections.emptyMap());
        if (config != null && OmegaLevels.config.weapons != null) {
            OmegaLevels.config.weapons.forEach((item, levelEffects) -> {
                if (itemStack != null && itemStack.func_77973_b() == item && levelEffects.containsKey(OmegaLevels.getItemStackLevel(itemStack))) {
                    effects.set(levelEffects.get(OmegaLevels.getItemStackLevel(itemStack)));
                }
            });
        }
        return effects.get();
    }

    public static Pair<Map<String, Config.EffectData>, Boolean> getAllEffects(ItemStack itemStack) {
        AtomicReference<Pair> effects = new AtomicReference<Pair>(Pair.of(Collections.emptyMap(), null));
        OmegaLevels.config.weapons.forEach((item, levelEffects) -> {
            if (itemStack != null && itemStack.func_77973_b() == item && levelEffects.containsKey(OmegaLevels.getItemStackLevel(itemStack))) {
                effects.set(Pair.of(levelEffects.get(OmegaLevels.getItemStackLevel(itemStack)), (Object)false));
            }
        });
        OmegaLevels.config.armors.forEach((items, levelEffects) -> {
            if (itemStack != null && items.contains((Object)itemStack.func_77973_b()) && levelEffects.containsKey(OmegaLevels.getItemStackLevel(itemStack))) {
                effects.set(Pair.of(levelEffects.get(OmegaLevels.getItemStackLevel(itemStack)), (Object)true));
            }
        });
        return effects.get();
    }

    public static Map<String, Config.EffectData> getArmorEffects(EntityPlayer player) {
        AtomicReference effects = new AtomicReference(Collections.emptyMap());
        OmegaLevels.config.armors.forEach((items, levelEffects) -> {
            List armorLevels;
            Stream<Item> var10000 = Arrays.stream(player.field_71071_by.field_70460_b).filter(Objects::nonNull).map(ItemStack::func_77973_b);
            items.getClass();
            if (var10000.allMatch(items::contains) && (armorLevels = Arrays.stream(player.field_71071_by.field_70460_b).map(Optional::ofNullable).map(itemStack -> itemStack.map(OmegaLevels::getItemStackLevel).orElse(-1)).collect(Collectors.toList())).stream().distinct().count() == 1L && levelEffects.containsKey(armorLevels.get(0))) {
                effects.set(levelEffects.get(armorLevels.get(0)));
            }
        });
        return effects.get();
    }

    static {
        INSTANCE = null;
    }

    private static class Entry<K, V> {
        public K key;
        public V value;

        private Entry() {
        }
    }

    public static class Proxy
    implements IGuiHandler {
        @SidedProxy(serverSide="omegalevels.OmegaLevels$Proxy$ServerProxy", clientSide="omegalevels.OmegaLevels$Proxy$ClientProxy")
        public static Proxy INSTANCE;

        public void generateParticlesRed(EntityPlayer e) {
        }

        public void generateParticlesWhite(EntityPlayer e) {
        }

        public void generateParticlesPurple(EntityPlayer e) {
        }

        public void generateParticlesYellow(EntityPlayer e) {
        }

        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            TileEntity tile = world.func_147438_o(x, y, z);
            if (id == 0 && tile instanceof TileLevelStation) {
                return new ContainerLevelStation(player.field_71071_by, (TileLevelStation)tile);
            }
            return null;
        }

        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }

        public boolean isLongDistance(EntityPlayer player, Entity entity) {
            return player.func_70685_l(entity);
        }

        public static class ServerProxy
        extends Proxy {
        }

        public static class ClientProxy
        extends Proxy {
            @Override
            public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
                TileEntity tile = world.func_147438_o(x, y, z);
                if (id == 0 && tile instanceof TileLevelStation) {
                    return new GuiLevelStation(new ContainerLevelStation(player.field_71071_by, (TileLevelStation)tile));
                }
                return null;
            }

            @Override
            public void generateParticlesRed(EntityPlayer theEntity) {
                double motionX = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                double motionY = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                double motionZ = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                ParticlesRed particle = new ParticlesRed(theEntity.field_70170_p, theEntity.field_70165_t + (theEntity.field_70170_p.field_73012_v.nextDouble() - 0.5) * ((double)theEntity.field_70130_N + 1.5), theEntity.field_70163_u + theEntity.field_70170_p.field_73012_v.nextDouble() * ((double)theEntity.field_70131_O + 0.5) - (double)theEntity.field_70129_M, theEntity.field_70161_v + (theEntity.field_70170_p.field_73012_v.nextDouble() - 0.5) * ((double)theEntity.field_70130_N + 1.5), motionX, motionY, motionZ);
                Minecraft.func_71410_x().field_71452_i.func_78873_a((EntityFX)particle);
            }

            @Override
            public void generateParticlesWhite(EntityPlayer theEntity) {
                double motionX = theEntity.field_70170_p.field_73012_v.nextGaussian() * 1.02;
                double motionY = theEntity.field_70170_p.field_73012_v.nextGaussian() * 1.02;
                double motionZ = theEntity.field_70170_p.field_73012_v.nextGaussian() * 1.02;
                ParticlesWhite particle = new ParticlesWhite(theEntity.field_70170_p, theEntity.field_70165_t + (theEntity.field_70170_p.field_73012_v.nextDouble() - 0.5) * ((double)theEntity.field_70130_N + 1.5), theEntity.field_70163_u + theEntity.field_70170_p.field_73012_v.nextDouble() * ((double)theEntity.field_70131_O + 0.5) - (double)theEntity.field_70129_M, theEntity.field_70161_v + (theEntity.field_70170_p.field_73012_v.nextDouble() - 0.5) * ((double)theEntity.field_70130_N + 1.5), motionX, motionY, motionZ);
                Minecraft.func_71410_x().field_71452_i.func_78873_a((EntityFX)particle);
            }

            @Override
            public void generateParticlesPurple(EntityPlayer theEntity) {
                double motionX = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                double motionY = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                double motionZ = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                ParticlesPurple particle = new ParticlesPurple(theEntity.field_70170_p, theEntity.field_70165_t + (theEntity.field_70170_p.field_73012_v.nextDouble() - 0.5) * ((double)theEntity.field_70130_N + 1.5), theEntity.field_70163_u + theEntity.field_70170_p.field_73012_v.nextDouble() * ((double)theEntity.field_70131_O + 0.5) - (double)theEntity.field_70129_M, theEntity.field_70161_v + (theEntity.field_70170_p.field_73012_v.nextDouble() - 0.5) * ((double)theEntity.field_70130_N + 1.5), motionX, motionY, motionZ);
                Minecraft.func_71410_x().field_71452_i.func_78873_a((EntityFX)particle);
            }

            @Override
            public void generateParticlesYellow(EntityPlayer theEntity) {
                double motionX = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                double motionY = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                double motionZ = theEntity.field_70170_p.field_73012_v.nextGaussian() * 0.6;
                ParticlesYellow particle = new ParticlesYellow(theEntity.field_70170_p, theEntity.field_70165_t + (theEntity.field_70170_p.field_73012_v.nextDouble() - 0.5) * ((double)theEntity.field_70130_N + 1.5), theEntity.field_70163_u + theEntity.field_70170_p.field_73012_v.nextDouble() * ((double)theEntity.field_70131_O + 0.5) - (double)theEntity.field_70129_M, theEntity.field_70161_v + (theEntity.field_70170_p.field_73012_v.nextDouble() - 0.5) * ((double)theEntity.field_70130_N + 1.5), motionX, motionY, motionZ);
                Minecraft.func_71410_x().field_71452_i.func_78873_a((EntityFX)particle);
            }

            @Override
            public boolean isLongDistance(EntityPlayer player, Entity entity) {
                return entity instanceof EntityPlayerMP ? super.isLongDistance(player, entity) : Minecraft.func_71410_x().field_71442_b.func_78749_i();
            }
        }

    }

}

