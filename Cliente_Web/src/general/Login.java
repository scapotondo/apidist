package general;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelegate.BusinessDelegate;
import dto.UsuarioDto;
import exceptions.RemoteObjectNotFoundException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDto usuario = null;
		String userName = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		if (userName == null || userName.trim().isEmpty() || 
				password == null == password.trim().isEmpty()){
			//TODO: mostrar un error
		}
		
		try {
			usuario = BusinessDelegate.getInstance().Login(userName, password);
		} catch (RemoteObjectNotFoundException e) {
			// TODO: mostrar mensaje de error
		}
		//TODO: chequear que se encontro el usuario con exception del server?
		
		String page = "/login.jsp";
				
		switch (usuario.getRol()) {
		case Cliente:
			page = "/cliente/pedidosPendientes.jsp";
			break;
		default:
			break;
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}
