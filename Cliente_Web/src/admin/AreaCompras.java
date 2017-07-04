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
import dto.OrdenDeCompraDto;
import dto.UsuarioDto;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class AreaCompras
 */
@WebServlet("/AreaCompras")
public class AreaCompras extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaCompras() {
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
			
			ArrayList<OrdenDeCompraDto> ordenesCompra = BusinessDelegate.getInstance().getOrdenesCompraPendientes();
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("ordenes", ordenesCompra);
			
			String id = request.getParameter("id");
			if(id != null){
				doPost(request,response);
			} else {
				request.getRequestDispatcher("/admin/areaCompras.jsp").forward(request, response);
			}
			
		} catch (RemoteObjectNotFoundException | ApplicationException | UsuarioException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OrdenDeCompraDto orden = new OrdenDeCompraDto();
			Integer id = Integer.parseInt(request.getParameter("id"));
			orden.setId(id);
		
			BusinessDelegate.getInstance().comprar(orden);
			
			response.sendRedirect(request.getContextPath()+"/AreaCompras");
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}
