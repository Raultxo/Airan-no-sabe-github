package consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBBDD.Conexion;
import tablas.Olimpiada;

public class ConsultasOlimpiadas {

	private Conexion cn;
	private ConsultasEventos consultasEventos;
	
	public ConsultasOlimpiadas() {
		consultasEventos = new ConsultasEventos();
		try {
			this.cn = new Conexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public Olimpiada getOlimpiadaPorId(int id) {
		Olimpiada olimp = null;
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Olimpiada where id_olimpiada = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				olimp = new Olimpiada(id, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));	
			}
		} catch(SQLException e) {
			return null;
		}
		return olimp;
	}
	
	*/
	public ArrayList<Olimpiada> listaOlimpiadas() {
		ArrayList<Olimpiada> olimpiadas = new ArrayList<Olimpiada>();
		
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Olimpiada order by anio desc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Olimpiada olimp = new Olimpiada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				olimpiadas.add(olimp);
			}
		} catch (SQLException e) {
			return olimpiadas;
		}		 
		return olimpiadas;
	}
	
	public boolean existeOlimpiada(Olimpiada olimp) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Olimpiada where anio = ? and ciudad = ? and temporada = ?");
			ps.setInt(1, olimp.getAnio());
			ps.setString(2, olimp.getCiudad());
			ps.setString(3, olimp.getTemporada());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			return true;
		}	
		return false;
	}
	
	public void insertarOlimpiada(Olimpiada olimp) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("insert into Olimpiada (nombre, anio, temporada, ciudad) VALUES (?, ?, ?, ?)");
			ps.setString(1, olimp.getNombre());
			ps.setInt(2, olimp.getAnio());
			ps.setString(3, olimp.getTemporada());
			ps.setString(4, olimp.getCiudad());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void editarOlimpiada(Olimpiada olimp) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("update Olimpiada set nombre = ?, anio = ?, temporada = ?, ciudad = ? where id_olimpiada = ?");
			ps.setString(1, olimp.getNombre());
			ps.setInt(2, olimp.getAnio());
			ps.setString(3, olimp.getTemporada());
			ps.setString(4, olimp.getCiudad());
			ps.setInt(5, olimp.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean borrarOlimpiada(Olimpiada olimp) {		
		if(consultasEventos.existeEventoConOlimpiada(olimp)) {
			return false;
		}	
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("delete from Olimpiada where id_olimpiada = ?");
			ps.setInt(1, olimp.getId());
			ps.executeUpdate();
			return true;
		} catch(SQLException e) {
			return false;
		}
	}
	
	public void cerrarConexion() {
		consultasEventos.cerrarConexion();
		cn.cerrarConexion();
	}
}
