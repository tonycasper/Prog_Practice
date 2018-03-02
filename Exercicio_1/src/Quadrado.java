
public class Quadrado extends Poligono implements Diagonal{
	
	double altura = 10;
	double largura = 8;
	double result = 0;
	
	public Quadrado(double l, double a) {
		super(l, a);

	}
	
	public double diagonal(double altura, double largura) {
		return result = altura * Math.sqrt(2);
	}
	
}
