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
import dto.EmpleadoDto;
import dto.PedidoPrendasDto;
import dto.UsuarioDto;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class Despacho
 */
@WebServlet("/Despacho")
public class Despacho extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public Despacho() {
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
		
			UsuarioDto usuario = BusinessDelegate.getInstance().getUserEmpleado(codigo);
			ArrayList<PedidoPrendasDto> pedidos = BusinessDelegate.getInstance().getPedidosDespacho();
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("pedidos", pedidos);
			
			String idPedido = request.getParameter("IdPedido");
			if(idPedido != null){
				doPost(request,response);
			}
			
			request.getRequestDispatcher("/admin/despacho.jsp").forward(request, response);
			
		} catch (RemoteObjectNotFoundException | UsuarioException e) {
			e.printStackTrace(); 
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idPedido = request.getParameter("IdPedido");
			PedidoPrendasDto pedido = BusinessDelegate.getInstance().BuscarPedido(Integer.parseInt(idPedido));
			
			EmpleadoDto empleado = new EmpleadoDto();
			empleado.setNombre(pedido.getCliente().getSucursal().getGerente().getNombre());
			
			BusinessDelegate.getInstance().despacharPedido(pedido, empleado);
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
}

