package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.TransaccionController;
import entidades.Transaccion;
/**
 * Servlet implementation class transferencia
 */
@WebServlet("/transferencia")
public class TransferenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferenciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("transaccion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TransaccionController itc = new TransaccionController();
		//String res = itc.getAllTransaccionesByRut(request.getParameter("rut_emisor")).toString();
		Transaccion tf = new Transaccion();
		tf.setRut_cliente(request.getParameter("rut_cliente"));
		tf.setId_cuenta(request.getParameter("numero_cuenta"));
		tf.setMonto(request.getParameter("monto_transferencia"));
		tf.setTipo_cuenta(request.getParameter("tipo_cuenta"));
		tf.setTipo_banco(request.getParameter("tipo_banco"));
		tf.setUsuario(request.getParameter("rut_emisor"));
		itc.insertarTransaccion(tf);
		doGet(request, response);
	}

}
