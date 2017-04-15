package de.automessenger.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
	}
	
}
