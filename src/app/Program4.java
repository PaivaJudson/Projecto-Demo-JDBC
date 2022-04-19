package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program4 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					  "DELETE FROM DEPARTMENT "
					+ "WHERE "
					+ "ID = ?");
			
			st.setInt(1, 2);
			
			int rows = st.executeUpdate();
			System.out.println("Linhas afectadas = "+ rows);
		}catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
		

	}

}
