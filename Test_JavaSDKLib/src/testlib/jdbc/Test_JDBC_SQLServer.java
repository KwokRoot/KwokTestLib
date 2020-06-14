package testlib.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 该练习是一个简单的连接 SQL Server 数据库的测试练习。
 * @author Kwok
 */

/*
 * SQL 脚本
 * 
CREATE TABLE [dbo].[person](
		[id] [int] NOT NULL,
		[name] [varchar](50) NULL,
	 CONSTRAINT [PK_person] PRIMARY KEY CLUSTERED 
	)
*/

public class Test_JDBC_SQLServer {
	
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";
	private static Connection conn;
	
	static{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println(Test_JDBC_SQLServer.getConnection().getCatalog());
		
		Connection conn=Test_JDBC_SQLServer.getConnection();
		
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT  * FROM  person");
		
		while(rs.next()){
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}
		
	}
}
