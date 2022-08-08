package com.electric.ElectricBilling;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection 
{
	
	public Connection getConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MD1?autoReconnect=true&useSSL=false",
					"root", "G@nesh1348");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
}
