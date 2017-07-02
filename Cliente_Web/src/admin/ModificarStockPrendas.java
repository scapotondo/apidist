package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessDelegate.BusinessDelegate;
import dto.EmpleadoDto;
import dto.ModificacionStockDto;
import dto.StockPrendaDto;
import exceptions.RemoteObjectNotFoundException;


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
		int codigo = Integer.parseInt(request.getParameter("stockPrenda"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String autoriza = request.getParameter("autoriza");
		String tipo = request.getParameter("tipoMovimiento");
		
		StockPrendaDto stockDto = new StockPrendaDto(codigo);
		ModificacionStockDto modifDto = new ModificacionStockDto(cantidad, tipo);
		EmpleadoDto quienAutorizoDto = new EmpleadoDto();
		quienAutorizoDto.setNombre(autoriza);
		
		//TODO:TERMINAR
		//(ArrayList<StockPrendaDto> stockDtos, EmpleadoDto empleadoDto, EmpleadoDto quienAutorizoDto, ModificacionStockDto modifDto)
		//BusinessDelegate.getInstance().ModificarStockPrenda(stockDto, empleadoDto, quienAutorizoDto, modifDto);
	}
}

