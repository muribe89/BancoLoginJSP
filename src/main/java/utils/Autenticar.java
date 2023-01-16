package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidades.Persona;

public class Autenticar {

	public static final Persona iniciarSesion(String nombreUsuario, String password) {
		Persona persona = new Persona();
		;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = Conexion.getConexion();
			String sql = "SELECT U.Username as user, U.Password as password, P.Rut as rut ,P.Nombre as nombre, P.Apellido as apellido ,  P.Telefono as telefono,  P.FechaIngreso as fecha_ingreso FROM Usuarios U, Personas P WHERE U.Username  = ? AND U.Password = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombreUsuario);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			while (rs.next()) {
				persona.setRut(rs.getString("rut"));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellido(rs.getString("apellido"));
				persona.setTelefono(rs.getString("telefono"));
				persona.setFechaIngreso(rs.getString("fecha_ingreso"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return persona;
	}
}
