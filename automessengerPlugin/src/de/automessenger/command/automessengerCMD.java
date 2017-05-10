package de.automessenger.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.automessenger.fileconfig.MessengerConfig;
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
					sender.sendMessage(messages.prefix + " Messenger have been started!");
				} else if (args[0].equalsIgnoreCase("stop")) {
					messengerService.stopMessenger();
					sender.sendMessage(messages.prefix + " Messenger have been stopped!");
				} else if (args[0].equalsIgnoreCase("list")) {
					messages.sendMessageList(sender);
				} else {
					//TODO: Code
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("remove")) {
					messengerMySQL.removeMessage(Integer.parseInt(args[1]));
					sender.sendMessage(messages.prefix + " message have been removed!");
				} else if (args[0].equalsIgnoreCase("seconds")){
					Integer sec = Integer.parseInt(args[1]);
					MessengerConfig.setInterval(sec);
					sender.sendMessage(messages.prefix + " Message Interval has been updated!");
				}
			} else if (args.length >= 2) {
				if (args[0].equalsIgnoreCase("add")) {
					String msg = "";
					for (int i = 1; i < args.length; i++) {
						msg = msg + args[i] + " ";
					}
					messengerMySQL.insertMessage(msg);
					sender.sendMessage(messages.prefix + " message have been added!");
				}
			}
		}
		return true;
	}
	private static void printHelpScreen(CommandSender sender) {
		if (sender.hasPermission("automessenger.administrate")) {
			sender.sendMessage(ChatColor.AQUA + "/am start - start the automessenger");
			sender.sendMessage(ChatColor.AQUA + "/am stop - stop the automessenger");
			sender.sendMessage(ChatColor.AQUA + "/am list - list all messages");
			sender.sendMessage(ChatColor.AQUA + "/am remove <id> - remove a specific messages by messageID");
			sender.sendMessage(ChatColor.AQUA + "/am add <args...> - add a new automessages");
			sender.sendMessage(ChatColor.AQUA + "/am toggle - you won't get any more messages!");
		} else {
			sender.sendMessage(ChatColor.AQUA + "/am toggle - you won't get any more messages!");
		}
	}

}
