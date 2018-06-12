package src.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.model.Pais;
import src.service.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPaisController.do")
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
		
		System.out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		System.out.println(	"id: "+pais.getId()+"<br>");
		System.out.println(	"nome: "+pais.getNome()+"<br>");
		System.out.println(	"fone: "+pais.getArea()+"<br>");
		System.out.println(	"e-mail: "+pais.getPopu()+"<br>");
		System.out.println("</body></html>");
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
