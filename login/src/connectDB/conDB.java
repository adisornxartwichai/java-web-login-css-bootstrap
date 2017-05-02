package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conDB {

	public static void main(String[] args) {
		connect();

	}

	public static Connection connect() {

		Connection con = null;

		try {
			// 1. โหลดคลาส JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2. กำหนด URL สำหรับติดต่อกับฐานข้อมูล
			String dbURL = "jdbc:mysql://localhost/kkumarket?characterEncoding=utf-8";

			// 3. สร้าง Connection
			con = DriverManager.getConnection(dbURL, "root", "");

		} catch (ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch (SQLException e) {
			System.err.println("Error database connection: " + e);

		}
		return con;
	}

}