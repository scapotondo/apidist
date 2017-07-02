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
import dto.ModificacionStockDto;
import dto.StockPrendaDto;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;


/**
 * Servlet implementation class DisminuirPrendas
 */
@WebServlet("/ModificarStockPrendas")
public class ModificarStockPrendas extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarStockPrendas() {
		super();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			ArrayList<StockPrendaDto> stockPrendas = BusinessDelegate.getInstance().getStockPrendas();

			request.setAttribute("stockPrendas", stockPrendas);

			request.getRequestDispatcher("/admin/modificarStockPrendas.jsp").forward(request, response);
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigoStock = Integer.parseInt(request.getParameter("stockPrenda"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			String autoriza = request.getParameter("autoriza");
			String tipo = request.getParameter("tipoMovimiento");

			int codigo = 0;
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getName().equals("usuario"))
					codigo = Integer.parseInt(cookie.getValue());
			}

			EmpleadoDto empleadoDto = BusinessDelegate.getInstance().getEmpleado(new EmpleadoDto(codigo));
			StockPrendaDto stockDto = new StockPrendaDto(codigoStock);
			ModificacionStockDto modifDto = new ModificacionStockDto(cantidad, tipo);
			EmpleadoDto quienAutorizoDto = new EmpleadoDto();
			quienAutorizoDto.setNombre(autoriza);

			BusinessDelegate.getInstance().ModificarStockPrenda(stockDto, empleadoDto, quienAutorizoDto, modifDto);
		} catch (RemoteObjectNotFoundException | ApplicationException | UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}

