package net.vadamdev.gentoolkit.utils;

import net.vadamdev.gentoolkit.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public enum FileUtils {
    CONFIG("config.yml");

    private final String filename;
    private final File dataForlder;

    FileUtils(String filename) {
        this.filename = filename;
        this.dataForlder = Main.instance.getDataFolder();
    }

    public File getFile() {
        return new File(dataForlder,filename);
    }

    public FileConfiguration getConfig(){
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public void save(FileConfiguration configuration){
        try {
            configuration.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename(){
        return filename;
    }
}
