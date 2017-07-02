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
import dto.MovimientoMateriaPrimaDto;
import dto.MovimientoPrendaDto;
import dto.StockMateriaPrimaDto;
import dto.StockPrendaDto;
import dto.UsuarioDto;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;

/**
 * Servlet implementation class Almacen
 */
@WebServlet("/Almacen")
public class Almacen extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Almacen() {
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
			
			
			ArrayList<StockPrendaDto> stockPrenda = BusinessDelegate.getInstance().getStockPrendas();
			ArrayList<StockMateriaPrimaDto> stockMateriaPrima = BusinessDelegate.getInstance().getStockMateriaPrima();
			ArrayList<MovimientoPrendaDto> movimientosPrenda = BusinessDelegate.getInstance().getMovimientosPrendas();
			ArrayList<MovimientoMateriaPrimaDto> movimientosMateriaPrima = BusinessDelegate.getInstance().getMovimientosMateriaPrima();
			
			request.setAttribute("stockPrendas", stockPrenda);
			request.setAttribute("stockMateriaPrima", stockMateriaPrima);
			request.setAttribute("movimientosPrenda", movimientosPrenda);
			request.setAttribute("movimientosMateriaPrima", movimientosMateriaPrima);
			request.setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("/admin/almacen.jsp").forward(request, response);
			
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
