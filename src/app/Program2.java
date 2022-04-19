package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program2 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement stm = null;
		
		String querySql = 
				  "INSERT INTO SELLER "
				+ "(NAME, EMAIL, BIRTHDATE, BASESALARY, DEPARTMENTID)"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		String querySql1 = 
				  "INSERT INTO DEPARTMENT "
				+ "(NAME)"
				+ "VALUES (?)";
		
		try {
			conn = DB.getConnection();
			stm = conn.prepareStatement(querySql1);
			
			stm.setString(1, "D2");
			//stm.setString(2, "D2");
			/*
			stm.setString(1, "Judson Paiva");
			stm.setString(2, "judson.paiva@isptec.co.ao");
			stm.setDate(3, new java.sql.Date(sdf.parse("12/05/1900").getTime()));
			stm.setDouble(4, 3000000.0);
			stm.setInt(5, 4);
			*/
			int rowsAffected = stm.executeUpdate();
			/*
			if(rowsAffected > 0) {
				ResultSet rs = stm.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Id = "+id);
				}
			}else {
				System.out.println("No rown affected!");
			}
			*/
			
		}catch(SQLException /*| ParseException*/ e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(stm);
			DB.closeConnection();
		}

	}

}
