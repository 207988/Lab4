package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class ParolaDAO {
	private String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root";	
	
	public boolean checkParola(String s){
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			String sql= "SELECT nome FROM parola WHERE nome=?;";			
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1,s);
			
			ResultSet res=st.executeQuery();
			
			if(res.next()){
				res.close();
				conn.close();
				return true;
			}
			
			res.close();
			conn.close();
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
		
	}
}
