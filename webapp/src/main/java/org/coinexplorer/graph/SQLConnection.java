package org.coinexplorer.graph;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnection {
	
	private final String PSQL_DRIVER_CLASS = "org.postgresql.Driver";

	public ArrayList<String> GetAddressesFrom(int start, int finish) {
		
		ArrayList<String> addressList = new ArrayList<String>();
		
		try {
			Class.forName(PSQL_DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Class: " + PSQL_DRIVER_CLASS + " not found.");
			e.printStackTrace();
		}
	
		try {
			Connection db = DriverManager.getConnection("jdbc:postgresql:abe");
			
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT pubkey_hash FROM pubkey WHERE pubkey_id >= " + start + " AND pubkey_id < " + finish );
			while (rs.next()) {
				addressList.add(rs.getString(1));
			}
			rs.close();
			st.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(addressList.size() != finish - start)
		{
			System.out.println("Failed count check for " + start + " to " + finish);
			return null;
		}
		
		return addressList;
		
	}
	
	
}
