package cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelegate.BusinessDelegate;
import dto.ClienteDto;
import dto.ItemPrendaDto;
import dto.PedidoPrendasDto;
import dto.PrendaDto;
import dto.UsuarioDto;
import exceptions.ApplicationException;
import exceptions.PedidoException;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class NuevoPedido
 */
@WebServlet("/NuevoPedido")
public class NuevoPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoPedido() {
        super(); 
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<PrendaDto> prendas = BusinessDelegate.getInstance().getPrendas();
			
			request.setAttribute("prendas", prendas); 
		} catch (RemoteObjectNotFoundException | ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		request.getRequestDispatcher("cliente/nuevoPedido.jsp").forward(request, response);
	}  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			int codigo = 0;
			ArrayList<ItemPrendaDto> itemsDto = new ArrayList<>();
			String[] items = request.getParameterValues("items[]");
			
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getName().equals("usuarioCliente"))
					codigo = Integer.parseInt(cookie.getValue());
			}  

			UsuarioDto usuario = BusinessDelegate.getInstance().getUserCliente(codigo);
			
			for(String item : items) {
				String[] values = item.split("-");
				itemsDto.add(new ItemPrendaDto(Integer.parseInt(values[3]), values[2], values[1], new PrendaDto(Integer.parseInt(values[0]))));
			}
			ClienteDto cliente = BusinessDelegate.getInstance().BuscarCliente(usuario.getCodigo());
			PedidoPrendasDto pedido = new PedidoPrendasDto(Calendar.getInstance().getTime(),cliente, itemsDto);
			
			pedido = BusinessDelegate.getInstance().CrearPedido(pedido);
			
			response.sendRedirect(request.getContextPath()+"/PedidosPendientes");
			
		} catch (RemoteObjectNotFoundException | UsuarioException | PedidoException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
