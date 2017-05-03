package de.automessenger.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import de.automessenger.main.core;
import de.automessenger.mysql.messengerMySQL;

public class messengerService {

	public static boolean autoStart;
	public static Integer interval = 10;
	private static Integer sched;
	private static int actual = 0;
	
	public static ArrayList<Player> toggled = new ArrayList<>();
	
	public static void startMessenger(final ArrayList<String> msg) {
		
		sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(core.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				if (actual < msg.size()) {
					Bukkit.broadcastMessage(msg.get(actual));
					actual = actual + 1;
				} else {
					actual = 0;
					Bukkit.broadcastMessage(msg.get(actual));
					actual = actual + 1;
				}
				
			}
		}, 0, 20 * interval);
	}
	public static void stopMessenger() {
		Bukkit.getScheduler().cancelTask(sched);
		actual = 0;
	}
	public static ArrayList<String> getMessages(HashMap<Integer, String> msg) {
		ArrayList<String> list = new ArrayList<>();
		for (Integer i : msg.keySet()) {
			list.add(msg.get(i));
		}
		return list;
	}
	@SuppressWarnings("deprecation")
	public static void sendMessage(String message) {
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (!toggled.contains(all)) {
				all.sendMessage(messages.serverName + " " + ChatColor.translateAlternateColorCodes('&', message));
			}
		}
	}
	
}
