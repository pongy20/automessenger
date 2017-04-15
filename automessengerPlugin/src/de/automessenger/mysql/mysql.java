package de.automessenger.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;

public class mysql {
	public static String host;
	public static String port;
	public static String database;
	public static String username;
	public static String password;
	private static Connection con;
	
	public static void connect() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				Bukkit.getConsoleSender().sendMessage("s[MySQL] connected to database!");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	public static void close() {
		if (isConnected()) {
			try {
				con.close();
				Bukkit.getConsoleSender().sendMessage("[MySQL] disconnected from database!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static boolean isConnected() {
		return (con == null ? false : true);
	}
	public static Connection getConnection() {
		return con;
	}
	public static void createTable() {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS messanges "
					+ " (id INT NOT NULL primary key AUTO_INCREMENT, message VARCHAR(100))");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
