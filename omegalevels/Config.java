/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 */
package omegalevels;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.item.Item;

public class Config {
    public Map<Item, Map<Integer, Map<String, EffectData>>> weapons = new HashMap<Item, Map<Integer, Map<String, EffectData>>>();
    public Map<Set<Item>, Map<Integer, Map<String, EffectData>>> armors = new HashMap<Set<Item>, Map<Integer, Map<String, EffectData>>>();
    public Map<String, Map<Integer, ImproveData>> improves = new HashMap<String, Map<Integer, ImproveData>>();
    public Map<String, Integer> stabilizers = new HashMap<String, Integer>();

    public static class EffectData {
        public int chance = 100;
        public int amount = 0;
        public int time = 10;
    }

    public static class ImproveData {
        public int chance = 100;
        public int chanceSkipLevel = 0;
        public boolean breakOnFail = false;
        public boolean decreaseLevelOnFail = false;
    }

}

