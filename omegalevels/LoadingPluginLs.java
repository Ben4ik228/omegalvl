/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin$MCVersion
 */
package omegalevels;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;
import omegalevels.ClassTransformerLs;

@IFMLLoadingPlugin.MCVersion(value="1.7.10")
public class LoadingPluginLs
implements IFMLLoadingPlugin {
    public String[] getASMTransformerClass() {
        return new String[]{ClassTransformerLs.class.getName()};
    }

    public String getModContainerClass() {
        return null;
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> data) {
    }

    public String getAccessTransformerClass() {
        return null;
    }
}

