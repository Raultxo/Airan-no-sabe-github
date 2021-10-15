package conexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class Conexion {

	private Connection conexion;
	
	public Conexion() throws SQLException {
		String host = "localhost";
		String baseDatos = "olimpiadas";
		String usuario = "admin";
		String password = "password";
		String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos+ "?serverTimezone=" + TimeZone.getDefault().getID();
		conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
		conexion.setAutoCommit(true);
	 }

	 public void cerrarConexion() {
		 try {
			this.conexion.close();
		} catch (SQLException e) {
			return;
		}
	 }
	 
	public Connection getConexion() {
		 return conexion;
	 }
	 
}
