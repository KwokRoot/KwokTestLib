package testlib.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 该练习是一个简单的连接数据库的工具类，可以在测试环境中使用，正式环境中推荐使用数据库连接池。
 * @author Kwok
 */
public class Test_JDBC {

	private static final String URL = "jdbc:mysql://......";
	private static final String USERNAME = "...";
	private static final String PASSWORD = "...";
	private static Connection conn;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

}
