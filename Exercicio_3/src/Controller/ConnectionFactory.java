package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String url = "jdbc:postgresql://localhost:5432/pratprog";
	private final static String usuario = "postgres";
	private final static String senha = "ziul";
	private final static String driver = "org.postgresql.Driver";
	
		static {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	// Obtém conexão com o banco de dados
		public static Connection obtemConexao() throws SQLException {
			return DriverManager.getConnection(url,usuario,senha);
		}
}
