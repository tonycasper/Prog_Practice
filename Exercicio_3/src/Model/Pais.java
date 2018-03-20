package Model;
public class Pais{
	private int id, populacao;
	private String nome;
	private double area;
	
	public Pais(int id){
		this.id = id;
	}
	
	
	public Pais(int id, String nome, int popul, double area){
		this.id        = id;
		this.nome      = nome;
		this.populacao = popul;
		this.area      = area;
		
	}
	//set's
	public void setId(int id){
		this.id = id;
	}
	public void setPopulacao(int popul){
		this.populacao = popul;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setArea(double area){
		this.area = area;
	}
	//get's
	public int getId(){
		return id;
	}
	public int getPopulacao(){
		return populacao;
	}
	public String getNome(){
		return nome;
	}
	public double getArea(){
		return area;
	}
	@Override
	public String toString() {
		return "Pais [id= " + id + ", nome= " + nome + ", populacao= " + populacao + 
				" area= " + area + "]";
	}
	

}
