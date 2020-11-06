package de.tempoo50.eco.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
	
	public static Connection con;
	
	public static void connect() {
		
		if(!isConnected()) {
			
			try {
				
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/con?autoReconnect=true", "econ", "Ga3eguz12edIT6LaFEYofuniS83A77");
				System.out.println("MySQL Verbunden!");
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public static void disconnect() {
		
		if(isConnected()) {
			
			try {
				
				con.close();
				System.out.println("MySQL Verbindung getrennt!");
				
			}catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public static boolean isConnected() {
		
		return (con != null);
		
	}
	
	public static void createTable() {
		
		try {
			
			con.prepareStatement("CREATE TABLE IF NOT EXISTS coinTable (UUID VARCHAR(100), coins DOUBLE(16))").executeUpdate();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
