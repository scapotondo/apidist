package admin;

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
import exceptions.ApplicationException;
import exceptions.PedidoException;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class Sucursal
 */
@WebServlet("/Sucursal")
public class Sucursal extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public Sucursal() {
        super();
    }
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int codigo = 0;
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getName().equals("usuarioEmpleado"))
					codigo = Integer.parseInt(cookie.getValue());
			}
		
			UsuarioDto usuario = BusinessDelegate.getInstance().getUserEmpleado(codigo);
			ArrayList<PedidoPrendasDto> pedidos = BusinessDelegate.getInstance().getPedidosPendientesAceptacionAdmin();
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("pedidos", pedidos);
			
			String action = request.getParameter("action");
			String nro = request.getParameter("nro");
			
			if(action != null && nro != null && (action.equals("aprobar") || action.equals("rechazar")))
				doPost(request, response);
			else
				request.getRequestDispatcher("/admin/sucursal.jsp").forward(request, response);
			
		} catch (RemoteObjectNotFoundException | UsuarioException e) {
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
			
			PedidoPrendasDto pedido = BusinessDelegate.getInstance().BuscarPedido(numeroPedido);
			
			if(action.equals("aprobar"))
				BusinessDelegate.getInstance().AprobarPedidoAdmin(pedido);
			else
				BusinessDelegate.getInstance().RechazarPedidoAdmin(pedido, "rechazado");
			
			response.sendRedirect(request.getContextPath()+"/Sucursal");
			
		} catch (RemoteObjectNotFoundException | ApplicationException | PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


