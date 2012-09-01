package com.Iain.bitzcommands.settings;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Iain.bitzcommands.BitzCommands;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class UserConfig {
	public static BitzCommands plugin;

	
	public static FileConfiguration UserConfig = null;
	public static File ConfigFile = null;

	public static void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		}
	
	public static void reloadConfig() {
	    if (ConfigFile == null) {
	    	ConfigFile = new File("plugins/BitzCommands/players.yml");
	    }
	    UserConfig = YamlConfiguration.loadConfiguration(ConfigFile);
	}
	
	public static FileConfiguration getConfig() {
	    if (UserConfig == null) {
	        reloadConfig();
	    }
	    return UserConfig;
	}
	
	public static void saveConfig() {
	    if (UserConfig == null || ConfigFile == null) {
	    return;
	    }
	    try {
	    	UserConfig.save(ConfigFile);
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + ConfigFile, ex);
	    }
	}
}
