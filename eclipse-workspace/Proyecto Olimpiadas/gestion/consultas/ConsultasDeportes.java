package consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBBDD.Conexion;
import tablas.Deporte;

public class ConsultasDeportes {

private Conexion cn;
	
	public ConsultasDeportes() {
		try {
			this.cn = new Conexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Deporte getDeportePorId(int id) {
		Deporte deporte = null;
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Deporte where id_deporte = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				deporte = new Deporte(id, rs.getString(2));
				
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return deporte;
	}
	
	public ArrayList<Deporte> listaDeportes() {
		ArrayList<Deporte> deportes = new ArrayList<Deporte>();
		
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Deporte order by nombre");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Deporte deporte = new Deporte(rs.getInt(1), rs.getString(2));
				deportes.add(deporte);
			}
		} catch (SQLException e) {
			return deportes;
		}		 
		return deportes;
	}
	
	public void aniadirDeporte(Deporte depor) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("insert into Deporte (nombre) values (?)");
			ps.setString(1, depor.getNombre());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void editarDeporte(Deporte depor) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("update Deporte set nombre = ? where id_deporte = ?");
			ps.setString(1, depor.getNombre());
			ps.setInt(2, depor.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void borrarDeporte(Deporte depor) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("delete from Deporte where id_deporte = ?");
			ps.setInt(1, depor.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean existeDeporte(Deporte depor) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Deporte where nombre = ?");
			ps.setString(1, depor.getNombre());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			return false;
		}		 
		return false;
	}
	
	public void cerrarConexion() {
		cn.cerrarConexion();
	}
	
}
