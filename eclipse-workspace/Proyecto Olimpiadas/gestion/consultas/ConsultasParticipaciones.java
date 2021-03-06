package consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBBDD.Conexion;
import tablas.Deportista;
import tablas.Equipo;
import tablas.Evento;
import tablas.Participacion;

public class ConsultasParticipaciones {

	private ConsultasDeportistas cDeportista;
	private ConsultasEquipos cEquipo;
	private Conexion cn;
	
	public ConsultasParticipaciones() {
		cDeportista = new ConsultasDeportistas();
		cEquipo = new ConsultasEquipos();
		try {
			this.cn = new Conexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Participacion> listaParticipacionesPorEvento(Evento evento) {
		ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
		if(evento != null) {
			PreparedStatement ps;
			try {
				ps = cn.getConexion().prepareStatement("select * from Participacion where id_evento = ?");
				ps.setInt(1, evento.getId());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String medalla = rs.getString(5);
					if(rs.wasNull()) {
						medalla = "Sin medalla";
					}
					Participacion part = new Participacion(
							cDeportista.getDeportistaPorId(rs.getInt(1)), 
							evento, 
							cEquipo.getEquipoPorId(rs.getInt(3)), 
							rs.getInt(4), 
							medalla);
					participaciones.add(part);
				} 
			} catch(SQLException e) {
				return participaciones;
			}
		}
		return participaciones;
	}
	
	public boolean existeParticipacionConEvento(Evento evento) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Participacion where id_evento = ?");
			ps.setInt(1, evento.getId());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			return true;
		}
	}
	
	public boolean existeParticipacionConEquipo(Equipo equipo) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Participacion where id_equipo = ?");
			ps.setInt(1, equipo.getId());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			return true;
		}
	}
	
	public boolean existeParticipacionConDeportsta(Deportista deportista) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Participacion where id_deportista = ?");
			ps.setInt(1, deportista.getId());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			return true;
		}
	}
	
	public boolean borrarParticipacion(Participacion part) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("delete from Participacion where id_deportista = ? and id_evento = ?");
			ps.setInt(1, part.getDeportista().getId());
			ps.setInt(2, part.getEvento().getId());
			ps.executeUpdate();
			return true;
		} catch(SQLException e) {
			return false;
		}
	}
	
	public void cerrarConexion() {
		cDeportista.cerrarConexion();
		cEquipo.cerrarConexion();
		cn.cerrarConexion();
	}
}
