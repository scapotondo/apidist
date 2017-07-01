package cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import BusinessDelegate.BusinessDelegate;
import dto.PrendaDto;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;

/**
 * Servlet implementation class GetPrenda
 */
@WebServlet("/GetPrenda")
public class GetPrenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPrenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String codigoPrenda = request.getParameter("codigoPrenda");
			if (codigoPrenda == null || codigoPrenda.trim().isEmpty())
				return; 
			
			PrendaDto prenda = BusinessDelegate.getInstance().buscarPrendaPorCodigo(Integer.parseInt(codigoPrenda));
			
			PrendaInfo info = new PrendaInfo(prenda.getColoresValidos(), prenda.getTallesValidos(), prenda.getPrecio());
			
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(info));
		} catch (RemoteObjectNotFoundException | ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	class PrendaInfo {
		List<String> Colores;
		List<String> Talles;
		float Precio;
		
		public PrendaInfo(List<String> colores, List<String> talles, float precio) {
			Colores = colores;
			Talles = talles;
			Precio = precio;
		}
	}
}
