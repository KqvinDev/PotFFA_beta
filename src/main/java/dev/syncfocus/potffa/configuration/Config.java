package dev.syncfocus.potffa.configuration;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static File file;
    private static FileConfiguration fileConfig;

    public static void config(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("PotFFA").getDataFolder(), "config.yml");

        if (!file.exists()){
            try{
                System.out.println("Config file not found... creating config...");
                file.createNewFile();
                System.out.println("Created the config.yml!");
            }catch (IOException ignored){
            }
        }
        fileConfig = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return fileConfig;
    }

    public static void save(){
        try{
            fileConfig.save(file);
        }catch(IOException e){
            System.out.println("Could not save config.yml file!");
        }
    }

    public static void reload(){
        fileConfig = YamlConfiguration.loadConfiguration(file);
    }
}
