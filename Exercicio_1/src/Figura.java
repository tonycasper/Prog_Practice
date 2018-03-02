
public abstract class Figura {
	public double largura;
	public double altura;
	
	public Figura(double l, double a) {
		this.largura = l;
		this.altura = a;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}