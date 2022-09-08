package net.vadamdev.gentoolkit;

import net.vadamdev.gentoolkit.utils.BiomeDictionnary;
import net.vadamdev.gentoolkit.utils.FileUtils;
import net.vadamdev.viaapi.VIPlugin;
import net.vadamdev.viaapi.startup.APIVersion;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * @author VadamDev
 * @since 07/09/2022
 */
public class Main extends VIPlugin {
    public static Main instance;

    public BiomeReplacer biomeReplacer;

    @Override
    public void onEnable() {
        super.onEnable();

        instance = this;

        for(FileUtils value : FileUtils.values())
            saveResource(value.getFilename());

        biomeReplacer = new BiomeReplacer();
        replaceBiomes(FileUtils.CONFIG.getConfig());
    }

    public void replaceBiomes(FileConfiguration config) {
        ConfigurationSection biomeReplacerSection = config.getConfigurationSection("biomeReplacer");
        for (String key : biomeReplacerSection.getKeys(false))
            biomeReplacer.swapBiomes(BiomeDictionnary.valueOf(biomeReplacerSection.getString(key + ".from")), BiomeDictionnary.valueOf(biomeReplacerSection.getString(key + ".to")));
    }

    @Override
    public APIVersion getAPIVersion() {
        return APIVersion.V2_4_17;
    }
}
