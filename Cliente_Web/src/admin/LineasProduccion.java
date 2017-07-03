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
import dto.AreaProduccionDto;
import dto.LineaProduccionDto;
import dto.UsuarioDto;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class LineasProduccion
 */
@WebServlet("/LineasProduccion")
public class LineasProduccion extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public LineasProduccion() {
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
			
			String id = (String) request.getAttribute("id");
			
			AreaProduccionDto area = BusinessDelegate.getInstance().getAreaProducion(Integer.parseInt(id));
			
			ArrayList<LineaProduccionDto> lineas = BusinessDelegate.getInstance().getLineasOcupadas(area);
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("lineas", lineas);
			
			request.getRequestDispatcher("/admin/areasDeProduccion.jsp").forward(request, response);
			
		} catch (RemoteObjectNotFoundException | UsuarioException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}