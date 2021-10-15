package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Aeropuerto;
import beans.AeropuertoPrivado;
import beans.AeropuertoPublico;
import beans.Direccion;

public class GestionAeropuerto {

	private GestionConexion gc;
	
	public GestionAeropuerto() {
		try {
			this.gc = new GestionConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<AeropuertoPublico> aeropuertosPublicos(String nombreAero) {
		ArrayList<AeropuertoPublico> aeropuertos = new ArrayList<AeropuertoPublico>();
		
		PreparedStatement ps;
		try {
			if(nombreAero.equals("")) {
				ps = gc.getConexion().prepareStatement("select * "
						+ "from aeropuertos, aeropuertos_publicos, direcciones "
						+ "where aeropuertos.id = aeropuertos_publicos.id_aeropuerto and direcciones.id = aeropuertos.id_direccion");
			}
			else {
				ps = gc.getConexion().prepareStatement("select * "
						+ "from aeropuertos, aeropuertos_publicos, direcciones "
						+ "where aeropuertos.id = aeropuertos_publicos.id_aeropuerto and direcciones.id = aeropuertos.id_direccion and aeropuertos.nombre LIKE ?");
				ps.setString(1, "%" + nombreAero + "%");
			}
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				int anio = rs.getInt(3);
				int capacidad = rs.getInt(4);
				int idDireccion = rs.getInt(5);
				double financiacion = rs.getDouble(7);
				int numTrabajadores = rs.getInt(8);
				String pais = rs.getString(10);
				String ciudad = rs.getString(11);
				String calle = rs.getString(12);
				int numero = rs.getInt(13);
			
				AeropuertoPublico aerPublic = new AeropuertoPublico(new Aeropuerto(id, nombre, anio, capacidad, new Direccion(idDireccion, pais, ciudad, calle, numero)), financiacion, numTrabajadores);
				aeropuertos.add(aerPublic);
			}
		} catch (SQLException e) {
			 return null;
		}
			
		return aeropuertos;
	}
	
	public ArrayList<AeropuertoPrivado> aeropuertosPrivados(String nombreAero) {
		ArrayList<AeropuertoPrivado> aeropuertos = new ArrayList<AeropuertoPrivado>();
		
		PreparedStatement ps;
		try {
			if(nombreAero.equals("")) {
				ps = gc.getConexion().prepareStatement("select * "
						+ "from aeropuertos, aeropuertos_privados, direcciones "
						+ "where aeropuertos.id = aeropuertos_privados.id_aeropuerto and direcciones.id = aeropuertos.id_direccion");
			}
			else {
				ps = gc.getConexion().prepareStatement("select * "
						+ "from aeropuertos, aeropuertos_privados, direcciones "
						+ "where aeropuertos.id = aeropuertos_privados.id_aeropuerto and direcciones.id = aeropuertos.id_direccion and aeropuertos.nombre LIKE ?");
				ps.setString(1, "%" + nombreAero + "%");
			}
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				int anio = rs.getInt(3);
				int capacidad = rs.getInt(4);
				int idDireccion = rs.getInt(5);
				int numero_socios = rs.getInt(7);
				String pais = rs.getString(9);
				String ciudad = rs.getString(10);
				String calle = rs.getString(11);
				int numero = rs.getInt(12);
			
				AeropuertoPrivado aerPriv = new AeropuertoPrivado(new Aeropuerto(id, nombre, anio, capacidad, new Direccion(idDireccion, pais, ciudad, calle, numero)), numero_socios);
				aeropuertos.add(aerPriv);
			}
		} catch (SQLException e) {
			 return null;
		}
			
		return aeropuertos;
	}
	
	
	
}
