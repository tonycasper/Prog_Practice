package Controller;

import Controller.PaisService;;

public class Teste {
	public static void main(String args[]){
		PaisService ps = new PaisService(9,"Brasil",15000,776512.11);
		System.out.println("pais criado com sucesso"+ ps.getNome());
	}
	
}
