package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelegate.BusinessDelegate;
import dto.UsuarioDto;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	 /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
			
		
			request.setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
			
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
