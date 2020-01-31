package JavaDatabaseCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static String url = "jdbc:mysql://silva.computing.dundee.ac.uk:3306";
	public static String user = "19agileteam3";
	public static String psw = "9047.at3.7409";
	public static String DriverName = "com.mysql.cj.jdbc.Driver";

	// load driver (only need to be loaded once)
	static {
		try {
			Class.forName(JDBCUtil.DriverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// connect to database (for DAO to use )
	public static Connection getconn() {
		try {
			return DriverManager.getConnection(JDBCUtil.url, JDBCUtil.user, JDBCUtil.psw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// release resources (release connection, statement and result set)
	public static void close(Connection conn, Statement st, ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
