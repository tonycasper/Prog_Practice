
public class Quadrado extends Poligono{
	
	double ladoA =10;
	
	
	public Quadrado(double l, double a) {
		super(l, a);

	}
	
	@Override
	public double diagonal() {
		return altura * Math.sqrt(2);
	}

	@Override
	public double area() {
		return base * altura;
	}

	@Override
	public double perimetro() {
		return ladoA*4;
	}

	
}
