package cliente;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelegate.BusinessDelegate;
import dto.PedidoPrendasDto;
import dto.UsuarioDto;

/**
 * Servlet implementation class PedidosAceptados
 */
@WebServlet("/PedidosAceptados")
public class PedidosAceptados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidosAceptados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = 0;
		for (Cookie cookie : request.getCookies()) {
			if(cookie.getName().equals("clienteId"));
		
			codigo = Integer.parseInt(cookie.getValue());
		}
	
		UsuarioDto usuario = new UsuarioDto();
		usuario = BusinessDelegate.getInstance().getUser(codigo);
		
		ArrayList<PedidoPrendasDto> pedidosAceptados = BusinessDelegate.getInstance().getPedidosAceptados(usuario.getCliente());
		
		request.getRequestDispatcher("cliente/pedidosPendientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
