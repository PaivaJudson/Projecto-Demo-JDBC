package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program5 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			st = conn.createStatement();
			int rows1 = st.executeUpdate("UPDATE SELLER SET BASESALARY = 2090 WHERE DEPARTMENTID = 1");
			
			int x = 1;
			//if(x < 2) {
			//	throw new SQLException("Fake Error!");
			//}
			
			int rows2 = st.executeUpdate("UPDATE SELLER SET BASESALARY = 3090 WHERE DEPARTMENTID = 2");
			
			conn.setAutoCommit(true);
			
			System.out.println("rows1 "+ rows1);
			System.out.println("rows2 "+ rows2);
			
		}catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Trasaction rolled back! Caused by: "+e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Trasaction trying to rolled back! Caused by: "+e.getMessage());
			}
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
