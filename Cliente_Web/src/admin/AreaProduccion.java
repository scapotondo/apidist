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
import dto.OrdenDeProduccionDto;
import dto.UsuarioDto;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class AreaProduccion
 */
@WebServlet("/AreaProduccion")
public class AreaProduccion extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaProduccion() {
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

			String id = request.getParameter("codigo");
			
			
			AreaProduccionDto area = new AreaProduccionDto();
			
			area.setCodigo(Integer.parseInt(id));
			
			ArrayList<OrdenDeProduccionDto> ordenes = BusinessDelegate.getInstance().getOrdenesAreaProduccion(area);
			
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("ordenes", ordenes);
				
			Integer confeccionId = Integer.parseInt(request.getParameter("confeccionId"));
			Integer nroOrden = Integer.parseInt(request.getParameter("nroOrden"));
			
			if(confeccionId != null && nroOrden != null){
				doPost(request,response);
			}
			
			request.getRequestDispatcher("/admin/areaProduccion.jsp").forward(request, response);
			
		} catch (RemoteObjectNotFoundException | UsuarioException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer confeccionId = Integer.parseInt(request.getParameter("confeccionId"));
		Integer nroOrden = Integer.parseInt(request.getParameter("nroOrden"));
		
		String id = request.getParameter("codigo");
		
		AreaProduccionDto area = new AreaProduccionDto();
		area.setCodigo(Integer.parseInt(id));
		
		
		
	}
}
