package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManterPaisController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		int pPopu = Integer.parseInt(request.getParameter("popu"));
		double pArea = Double.parseDouble(request.getParameter("area"));
		
		//instanciar o java bean
		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setPopu(pPopu);
		pais.setArea(pArea);
		
		//instanciar a service
		PaisService ps = new PaisService();
		ps.criar(pais);
		pais = ps.carregar(pais.getId());
		
		//enviar para o jsp
		request.setAttribute("pais", pais);
		
		RequestDispatcher view = 
		request.getRequestDispatcher("Cliente.jsp");
		view.forward(request, response);
		
	}

}
