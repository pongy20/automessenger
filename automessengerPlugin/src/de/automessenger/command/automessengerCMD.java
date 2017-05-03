package de.automessenger.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.automessenger.mysql.messengerMySQL;
import de.automessenger.utils.messages;
import de.automessenger.utils.messengerService;

public class automessengerCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("automessenger.administrate")) {
			if (args.length == 0) {
				Bukkit.dispatchCommand(sender, "am help");
			} else if (args.length == 1)  {
				if (args[0].equalsIgnoreCase("help")) {
					
				} else if (args[0].equalsIgnoreCase("start")) {
					messengerService.startMessenger(messengerService.getMessages(messengerMySQL.getMessages()));
				} else if (args[0].equalsIgnoreCase("stop")) {
					messengerService.stopMessenger();
				} else if (args[0].equalsIgnoreCase("list")) {
					messages.sendMessageList(sender);
				} else {
					//TODO: Code
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("remove")) {
					messengerMySQL.removeMessage(Integer.parseInt(args[1]));
				} else {
					//TODO: CODE
				}
			} else if (args.length >= 2) {
				if (args[0].equalsIgnoreCase("add")) {
					String msg = "";
					for (int i = 1; i < args.length; i++) {
						msg = msg + args[i] + " ";
					}
					messengerMySQL.insertMessage(msg);
				}
			}
		}
		return true;
	}

}
