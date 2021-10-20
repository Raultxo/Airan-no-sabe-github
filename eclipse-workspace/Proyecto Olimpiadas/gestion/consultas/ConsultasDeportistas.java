package consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBBDD.Conexion;
import tablas.Deportista;

public class ConsultasDeportistas {

	private Conexion cn;
	
	public ConsultasDeportistas() {
		try {
			this.cn = new Conexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Deportista getDeportistaPorId(int id) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Deportista where id_deportista = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Deportista(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}
	
	public ArrayList<Deportista> listaDeportistas(String nombre) {
		ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
		
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("select * from Deportista where nombre like ?");
			ps.setString(1, "%" + nombre + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Deportista depor = new Deportista(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				deportistas.add(depor);
			}
		} catch(SQLException e) {
			return deportistas;
		}
		
		return deportistas;	
	}
	
	public void cerrarConexion() {
		cn.cerrarConexion();
	}
	
}
