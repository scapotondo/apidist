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
import dto.ClienteDto;
import dto.PedidoPrendasDto;
import dto.UsuarioDto;
import exceptions.ApplicationException;
import exceptions.PedidoException;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class PedidosPendientes
 */
@WebServlet("/PedidosPendientes")
public class PedidosPendientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidosPendientes() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = 0;
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getName().equals("usuario"))
					codigo = Integer.parseInt(cookie.getValue());
			}
		
			UsuarioDto usuario = BusinessDelegate.getInstance().getUserCliente(codigo);
			ClienteDto cliente = BusinessDelegate.getInstance().BuscarCliente(usuario.getCodigo());
			
			ArrayList<PedidoPrendasDto> pedidosPendientes = BusinessDelegate.getInstance().getPedidosPendientesAceptacionCliente(cliente);
			
			request.setAttribute("pedidosPendientes", pedidosPendientes);
			request.setAttribute("usuario", usuario);
			
			String action = request.getParameter("action");
			String numeroPedido = request.getParameter("nro");
			
			if(action!= null && numeroPedido!= null){
				doPost(request,response);
			}else
				request.getRequestDispatcher("cliente/pedidosPendientes.jsp").forward(request, response);
		
		} catch (RemoteObjectNotFoundException | UsuarioException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			int numeroPedido = Integer.parseInt(request.getParameter("nro"));
			
			if(action.equals("aceptar"))
				BusinessDelegate.getInstance().AceptarPedidoCliente(numeroPedido);
				
			if(action.equals("rechazar"))
				BusinessDelegate.getInstance().RechazarPedidoCliente(numeroPedido);;
				
			response.sendRedirect(request.getContextPath()+"/PedidosPendientes");
		
		} catch (NumberFormatException | RemoteObjectNotFoundException | PedidoException e) {
			e.printStackTrace();
		} 
	}

}
