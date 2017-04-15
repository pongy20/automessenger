package de.automessenger.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.automessenger.command.automessengerCMD;
import de.automessenger.mysql.mysql;
import de.automessenger.mysql.mysqlConfig;

public class core extends JavaPlugin {

	public void onEnable() {
	
		mysqlConfig.setConfig();
		mysqlConfig.readConfig();
		
		mysql.connect();
		mysql.createTable();
		
	}
	public void onDisable() {
		mysql.close();
	}
	private void registerCommands() {
		this.getCommand("automessenger").setExecutor(new automessengerCMD());
	}
	
}
