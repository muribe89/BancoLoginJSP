package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Transaccion;
import utils.Conexion;

public class TransaccionController {

	public ArrayList<Transaccion> getAllTransaccionesByRut(String rut) {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Transaccion> restf = new ArrayList<Transaccion>();
		try {
			cn = Conexion.getConexion();
			String sql = "select * from Transaccion where usuario = ?;";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, rut);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Transaccion tf = new Transaccion();
				tf.setId(rs.getString("id"));
				tf.setRut_cliente(rs.getString("rut_cliente"));
				tf.setId_cuenta(rs.getString("id_cuenta"));
				tf.setMonto(rs.getString("monto"));
				tf.setTipo_cuenta(rs.getString("tipo_cuenta"));
				tf.setUsuario(rs.getString("usuario"));
				restf.add(tf);
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
		return restf;
	}

	public Transaccion insertarTransaccion(Transaccion transaccion) {
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = Conexion.getConexion();
			String sql = "INSERT INTO `Transaccion` (`rut_cliente`, `id_cuenta`, `monto`, `tipo_cuenta`, `tipo_banco`, `usuario`)\n"
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, transaccion.getRut_cliente());
			pstm.setString(2, transaccion.getId_cuenta());
			pstm.setString(3, transaccion.getMonto());
			pstm.setString(4, transaccion.getTipo_cuenta());
			pstm.setString(5, transaccion.getTipo_banco());
			pstm.setString(6, transaccion.getUsuario());
			pstm.execute();
			cn.close();
		} catch (Exception e){
			System.out.println(e.toString());
		}
		return null;
	}
}
