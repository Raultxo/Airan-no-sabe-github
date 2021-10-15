package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Usuario;


public class GestionUsuario {

	private GestionConexion gc;
	
	public GestionUsuario() {
		try {
			this.gc = new GestionConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int comprobarLogin(Usuario user) { 
		PreparedStatement ps;
		try {
			ps = gc.getConexion().prepareStatement("select * from usuarios where usuario = ? and password = ?");
			ps.setString(1, user.getUsuario());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			return -1;
		}		 
		return 0;
	}
	 
}
