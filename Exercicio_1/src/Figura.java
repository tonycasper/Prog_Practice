
public abstract class Figura {
	public double largura;
	public double altura;
	
	public Figura(double l, double a) {
		this.largura = l;
		this.altura = a;
	}

	public abstract double area();
	
}