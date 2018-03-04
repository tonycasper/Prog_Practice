
public abstract class Poligono extends Figura {
	
	double base;
	double altura;
	
	
	public Poligono(double l, double a) {
		super(l, a);
		// TODO Auto-generated constructor stub
	}
	
	public abstract double perimetro();
	
	public abstract double diagonal();
}
