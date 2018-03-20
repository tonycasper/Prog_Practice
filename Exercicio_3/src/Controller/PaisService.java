package Controller;

import Model.PaisDAO;
import Model.Pais;

public class PaisService {
	private PaisDAO dao;
	private Pais to;
	
	public PaisService(int id, String nome, int populacao, double area){
		to = new Pais(id,nome,populacao,area);
		dao = new PaisDAO();
	}
	//set`s
	public void setId(int id){
		to.setId(id);
	}
	public void setNome(String nome){
		to.setNome(nome);
	}
	public void setArea(double area){
		to.setArea(area);
	}
	public void setPopulacao(int popul){
		to.setPopulacao(popul);
	}
	//get`s
	public int getId(){
		return to.getId();
	}
	public String getNome(){
		return to.getNome();
	}
	public double getArea(){
		return to.getArea();
	}
	public int getPopulacao(){
		return to.getPopulacao();
	}
	//metodos DAO
	public void criar(){
		dao.incluir(to);
	}
	public void atualizar(){
		dao.atualizar(to);
	}
	public void excluir(){
		dao.excluir(to);
	}
	public Pais carregar(int id){
		Pais to = dao.carregar(id);
				return to;
	}
	@Override
	public String toString() {
		return "Pais [id= " + to.getId() + ", nome= " + to.getNome() + ", populacao= " + to.getPopulacao() + 
				" area= " + to.getArea() + "]";
	}

}
