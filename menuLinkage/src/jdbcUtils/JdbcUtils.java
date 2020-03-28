package jdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtils {
	private static String driver = "jdbc:postgresql://localhost:5432/webcondb";
	private static String name = "postgres";
	private static String password = "888";

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(driver, name, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
		
		public static void close(Connection cnn, Statement st, ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (st != null) {
				try {
					st.close();
					rs = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (cnn != null) {
				try {
					cnn.close();
					cnn = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
}
