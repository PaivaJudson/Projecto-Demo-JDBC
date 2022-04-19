package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program4 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					  "UPDATE SELLER "
					+ "SET BASESALARY = BASESALARY + ? "
					+ "WHERE "
					+ "(DEPARTMENTID = ?)");
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Linhas afectadas = "+ rowsAffected);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
		

	}

}
