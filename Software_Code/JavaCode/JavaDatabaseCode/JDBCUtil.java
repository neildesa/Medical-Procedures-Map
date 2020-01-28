package JavaDatabaseCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static String url = "jdbc:mysql://35.195.221.186:3306";
	public static String user = "Zeng";
	public static String psw = "agile";
	public static String DriverName = "com.mysql.jdbc.Driver";

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
