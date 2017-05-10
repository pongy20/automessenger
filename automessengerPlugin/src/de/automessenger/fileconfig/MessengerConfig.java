package de.automessenger.fileconfig;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import de.automessenger.mysql.mysql;
import de.automessenger.utils.messages;
import de.automessenger.utils.messengerService;

public class MessengerConfig {
	private static File getConfigFile() {
        return new File("plugins/automessenger", "settings.yml");
    }

    private static YamlConfiguration getConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setConfig() {
        YamlConfiguration cfg = getConfiguration();
        cfg.options().copyDefaults(true); 
        
        cfg.addDefault("autostart", false);
        cfg.addDefault("seconds", 60);
        cfg.addDefault("servername", "&6Server");
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        YamlConfiguration cfg = getConfiguration();	
        
        messengerService.autoStart = cfg.getBoolean("autostart");
        messengerService.interval = cfg.getInt("seconds");
        messages.serverName = cfg.getString("servername");
    }
    public static void setInterval(int seconds) {
    	YamlConfiguration cfg = getConfiguration();
    	cfg.set("seconds", seconds);
    	try {
			cfg.save(getConfigFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
