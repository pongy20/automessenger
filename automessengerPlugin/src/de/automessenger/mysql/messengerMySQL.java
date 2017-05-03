package de.automessenger.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class messengerMySQL {

	public static boolean didIDExist(int id) {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT * FROM messages WHERE id = " + id);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void insertMessage(String msg) {
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("INSERT INTO messages (message) VALUES (?)");
			ps.setString(1, msg);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static HashMap<Integer, String> getMessages() {
		HashMap<Integer, String> map = new HashMap<>();
		try {
			PreparedStatement ps = mysql.getConnection().prepareStatement("SELECT * FROM messages");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				map.put(rs.getInt("id"), rs.getString("message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	public static boolean removeMessage(Integer id) {
		if (didIDExist(id)) {
			try {
				PreparedStatement ps = mysql.getConnection().prepareStatement("DELETE FROM messages WHERE id = ?");
				ps.setInt(1, id);
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
