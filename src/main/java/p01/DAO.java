package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private static final String URL = "jdbc:postgresql:canon_db";
	private static final String USER = "postgres";
	private static final String PASS = "himitu";

	protected Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection(URL, USER, PASS);

		return con;
	}
}
