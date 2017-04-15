package de.automessenger.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class automessengerCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("automessenger.administrate")) {
			if (args.length == 0) {
				Bukkit.dispatchCommand(sender, "am help");
			} else if (args.length == 1)  {
				if (args[0].equalsIgnoreCase("help")) {
					
				} else if (args[0].equalsIgnoreCase("start")) {
					
				} else if (args[0].equalsIgnoreCase("stop")) {
					
				} else if (args[0].equalsIgnoreCase("list")) {
					
				} else {
					//TODO: Code
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("remove")) {
					
				} else {
					//TODO: CODE
				}
			} else if (args.length >= 3) {
				if (args[0].equalsIgnoreCase("add")) {
					
				}
			}
		}
		return true;
	}

}
