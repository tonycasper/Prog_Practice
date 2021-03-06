package service;
import java.util.ArrayList;

import dao.PaisDao;
import model.Pais;

public class PaisService {
	PaisDao dao = new PaisDao();
	
	public int criar(Pais pais) {
		return dao.criar(pais);
	}
	
	public void atualizar(Pais pais) {
		 dao.atualizar(pais);
	}
	
	public void excluir (int id) {
		dao.excluir(id);
	}
	
	public Pais carregar(int id) {
		return dao.carregar(id);
	}
	
	public ArrayList<Pais> listarPais(String chave) {
		return dao.listarPais(chave);
	}
	
	public ArrayList<Pais> listarPais() {
		return dao.listarPais();
	}
}
