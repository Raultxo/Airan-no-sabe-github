package consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBBDD.Conexion;
import tablas.Equipo;

public class ConsultasEquipos {

	private Conexion cn;
	private ConsultasParticipaciones cParticipacion;
	
	public ConsultasEquipos() {
		try {
			this.cn = new Conexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Equipo getEquipoPorId(int id) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Equipo where id_equipo = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Equipo(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch(SQLException e) {
			return null;
		}
		return null;
	}
	
	public ArrayList<Equipo> listaEquipos() {
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Equipo");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Equipo equipo = new Equipo(rs.getInt(1), rs.getString(2), rs.getString(3));
				equipos.add(equipo);
			}
		} catch(SQLException e) {
			return equipos;
		}
		
		return equipos;	
	}
	
	public void aniadirEquipo(Equipo equipo) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("insert into Equpo (nombre, inciales) values (?,?)");
			ps.setString(1, equipo.getNombre());
			ps.setString(2, equipo.getIniciales());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean borrarEquipo(Equipo equipo) {
		if(cParticipacion.existeParticipacionConEquipo(equipo)) {
			return false;
		}
		
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("delete from Equipo where id_equipo = ?");
			ps.setInt(1, equipo.getId());
			ps.executeUpdate();
			return true;
		} catch(SQLException e) {
			return false;
		}
	}
	
	public void cerrarConexion() {
		cn.cerrarConexion();
	}
	
	
	
}
