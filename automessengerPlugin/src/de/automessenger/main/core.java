package de.automessenger.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.automessenger.command.automessengerCMD;
import de.automessenger.fileconfig.MessengerConfig;
import de.automessenger.fileconfig.mysqlConfig;
import de.automessenger.mysql.mysql;

public class core extends JavaPlugin {

	public static core instance;
	
	public void onEnable() {
		instance = this;
	
		mysqlConfig.setConfig();
		mysqlConfig.readConfig();
		
		mysql.connect();
		mysql.createTable();
		
		MessengerConfig.setConfig();
		MessengerConfig.readConfig();
		
		registerCommands();
		
	}
	public void onDisable() {
		mysql.close();
	}
	private void registerCommands() {
		this.getCommand("automessenger").setExecutor(new automessengerCMD());
	}
	public static core getInstance() {
		return instance;
	}
	
}
