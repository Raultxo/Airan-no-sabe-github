package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;


public class GestionConexion {

	private Connection conexion;
	
	public GestionConexion() throws SQLException {
		String host = "localhost";
		String baseDatos = "aeropuertos";
		String usuario = "admin";
		String password = "password";
		String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos+ "?serverTimezone=" + TimeZone.getDefault().getID();
		conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
		conexion.setAutoCommit(true);
	 }

	 public void cerrarConexion() throws SQLException {
		 this.conexion.close();
	 }
	 
	 public Connection getConexion() {
		 return conexion;
	 }
	 
}
