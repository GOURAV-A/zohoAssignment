package Login.check;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection connection=null;
	public static Connection getConn() {
		try {
			if(connection==null) {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibdb","root","root");
		
			return connection;
			}else {
				return connection;
			}
			} catch ( Exception e) {
		
			e.printStackTrace();
		}
		return connection;
	}
}
