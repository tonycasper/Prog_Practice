package src.model;

public class Pais{
	private int id, popu;
	private String nome;
	private double area;
	
	public Pais(){

	}
	
	
	public Pais(int id, String nome, int popu, double area){
		this.id        = id;
		this.nome      = nome;
		this.popu	   = popu;
		this.area      = area;
		
	}
	
	
	public void setId(int id){
		this.id = id;
	}
	public void setPopu(int popu){
		this.popu = popu;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setArea(double area){
		this.area = area;
	}
	
	public int getId(){
		return id;
	}
	public int getPopu(){
		return popu;
	}
	public String getNome(){
		return nome;
	}
	public double getArea(){
		return area;
	}	

}
