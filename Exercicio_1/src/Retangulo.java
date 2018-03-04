
public class Retangulo extends Poligono {
	
	double ladoA =10;
	double ladoB=5;
	
	
	
	public Retangulo(double l, double a) {
		super(l, a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double perimetro() {
		return (ladoA +ladoB)*4;
	}

	@Override
	public double diagonal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

}
