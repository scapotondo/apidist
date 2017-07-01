package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelegate.BusinessDelegate;
import dto.StockPrendaDto;
import exceptions.RemoteObjectNotFoundException;


/**
 * Servlet implementation class DisminuirPrendas
 */
@WebServlet("/DisminuirPrendas")
public class DisminuirPrendas extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisminuirPrendas() {
        super();
    }
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<StockPrendaDto> stockPrendas = BusinessDelegate.getInstance().getStockPrendas();
			
			request.setAttribute("stockPrendas", stockPrendas);
			
			request.getRequestDispatcher("/admin/disminuirPrendas.jsp").forward(request, response);
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenda = request.getParameter("prenda");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String talle = request.getParameter("talle");
		String color = request.getParameter("color");
		String encargado = request.getParameter("encargado");
		String autoriza = request.getParameter("prenda");
		
		//TODO:TERMINAR
		
	}
}

