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
import dto.ItemPrendaDto;
import dto.PedidoPrendasDto;
import dto.UsuarioDto;
import exceptions.RemoteObjectNotFoundException;

/**
 * Servlet implementation class Sucursal
 */
@WebServlet("/ItemsPedido")
public class ItemsPedido extends HttpServlet{

	private static final long serialVersionUID = 1L;

	 /**
    * @see HttpServlet#HttpServlet()
    */
   public ItemsPedido() {
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
		
			UsuarioDto usuario = BusinessDelegate.getInstance().getUser(codigo);
			
			String numero = request.getParameter("numero");
			
			PedidoPrendasDto pedido = BusinessDelegate.getInstance().BuscarPedido(Integer.parseInt(numero));
			
			ArrayList<ItemPrendaDto> items = pedido.getItems();

			request.setAttribute("usuario", usuario);
			request.setAttribute("items", items);
			
			request.getRequestDispatcher("/admin/itemsPedido.jsp").forward(request, response);
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
