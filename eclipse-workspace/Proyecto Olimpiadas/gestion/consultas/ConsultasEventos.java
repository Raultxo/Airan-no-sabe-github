package consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBBDD.Conexion;
import tablas.Deporte;
import tablas.Evento;
import tablas.Olimpiada;

public class ConsultasEventos {

	private Conexion cn;
	private ConsultasDeportes cDeportes;
	private ConsultasParticipaciones cParticipaciones;
	
	public ConsultasEventos() {
		try {
			this.cn = new Conexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cParticipaciones = new ConsultasParticipaciones();
		this.cDeportes = new ConsultasDeportes();
	}
	
	public ArrayList<Evento> listaEventos(Olimpiada olimp, String nombre) {
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Evento where id_olimpiada = ? and nombre like ?");
			ps.setInt(1, olimp.getId());
			ps.setString(2, "%" + nombre + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Deporte deporte = cDeportes.getDeportePorId(rs.getInt(4));
				Evento evento = new Evento(rs.getInt(1), rs.getString(2), olimp, deporte);
				eventos.add(evento);
			}
		} catch (SQLException e) {
			return eventos;
		}		 
		
		return eventos;
	}
	
	public void aniadirEvento(Evento evento) {
		
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("insert into Evento (nombre, id_olimpiada, id_deporte) values (?,?,?)");
			ps.setString(1, evento.getNombre());
			ps.setInt(2, evento.getOlimp().getId());
			ps.setInt(3, evento.getDeporte().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void editarEvento(Evento evento) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("update Evento set nombre = ?, id_olimpiada = ?, id_deporte = ? where id_evento = ?");
			ps.setString(1, evento.getNombre());
			ps.setInt(2, evento.getOlimp().getId());
			ps.setInt(3, evento.getDeporte().getId());
			ps.setInt(4, evento.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean elimiarEvento(Evento evento) {
		
		if(cParticipaciones.existeParticipacionConEvento(evento)) {
			return false;
		}
		
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("delete from Evento where id_evento = ?");
			ps.setInt(1, evento.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean existeEvento(Evento evento) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Evento where nombre = ? and id_olimpiada = ? and id_deporte = ?");
			ps.setString(1, evento.getNombre());
			ps.setInt(2, evento.getOlimp().getId());
			ps.setInt(3, evento.getDeporte().getId());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean existeEventoConOlimpiada(Olimpiada olimp) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Evento where id_olimpiada = ?");
			ps.setInt(1, olimp.getId());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch(SQLException e) {
			return true;
		}
	}
	
	public void cerrarConexion() {
		cDeportes.cerrarConexion();
		cParticipaciones.cerrarConexion();
		cn.cerrarConexion();
	}
	
}
