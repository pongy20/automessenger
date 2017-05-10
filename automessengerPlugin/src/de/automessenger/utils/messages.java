package de.automessenger.utils;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import de.automessenger.mysql.messengerMySQL;

public class messages {

	public static String prefix = ChatColor.BLUE + "Automessenger" + ChatColor.GOLD + " »»" + ChatColor.WHITE;
	public static String noperm = prefix + ChatColor.RED + " sorry but you don't have permissions to do that!";
	
	public static String MessageAdded = prefix + ChatColor.GREEN + " message have been added!";
	public static String MessageRemoved = prefix + ChatColor.GREEN + " message have been removed!";
	
	public static String serverName = ChatColor.GOLD + "Server";
	
	public static void sendMessageList(CommandSender sender) {
		HashMap<Integer, String> map = messengerMySQL.getMessages();
		for (Integer index : map.keySet()) {
			sender.sendMessage(ChatColor.GRAY + "ID: " + index + " : "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', map.get(index)));
		}
	}
	
}
