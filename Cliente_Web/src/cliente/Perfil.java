package cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelegate.BusinessDelegate;
import dto.ClienteDto;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;

/**
 * Servlet implementation class NuevoPedido
 */
@WebServlet("/Perfil")
public class Perfil extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Perfil() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = 0;
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getName().equals("clienteId"))
					id = Integer.parseInt(cookie.getValue());
			}
		
			ClienteDto cliente = new ClienteDto();
			cliente = BusinessDelegate.getInstance().BuscarCliente(id);
			
		
			request.setAttribute("cliente", cliente);
			
			
			request.getRequestDispatcher("/cliente/perfil.jsp").forward(request, response);
			
		} catch (RemoteObjectNotFoundException | ApplicationException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
}