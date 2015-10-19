package lesson151019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionExample {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");   // load driver
			connection = DriverManager.getConnection("jdbc:mysql://localhost/Students?user=root"); // make connection
			System.out.println(connection.getClass().getCanonicalName());
			
			Statement statement = connection.createStatement();   // create request
			
//			ResultSet resultSet = statement.executeQuery("select now()"); // send request and get result
			
//			while (resultSet.next()) {   /// process result
//				System.out.println(resultSet.getString(1));
//			}
			
//			print(resultSet);
			
//			ResultSet resultSet2 = statement.executeQuery("select * from student"); // send request and get result
			
//			print(resultSet2);
			
			queryAndPrint(statement, "select now()");
			queryAndPrint(statement, "select * from student");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();  // close connection
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("finish");
		
	}
	
	private static void queryAndPrint(Statement statement, String query) {
		try {
			ResultSet rs = statement.executeQuery(query);
			print(rs);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void print(ResultSet rs) throws SQLException {
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		int columns = metaData.getColumnCount();
		
		while (rs.next()) {   /// process result
			for (int i = 1; i <= columns; i++) {
				System.out.print(rs.getString(i) + " ");
			}
			System.out.println();
		}
	}

}
