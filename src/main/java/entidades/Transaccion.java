package entidades;

public class Transaccion {
	String id, rut_cliente,  id_cuenta,tipo_cuenta, usuario, monto, tipo_banco;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getRut_cliente() {
		return rut_cliente;
	}
	public void setRut_cliente(String rut_cliente) {
		this.rut_cliente = rut_cliente;
	}

	public String getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(String id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public String getTipo_cuenta() {
		return tipo_cuenta;
	}
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTipo_banco() {
		return tipo_banco;
	}
	public void setTipo_banco(String tipo_banco) {
		this.tipo_banco = tipo_banco;
	}
	
	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", rut_cliente=" + rut_cliente  + ", id_cuenta="
				+ id_cuenta + ", tipo_cuenta=" + tipo_cuenta + ", usuario=" + usuario + ", monto=" + monto
				+ ", tipo_banco=" + tipo_banco + "]";
	}
}
