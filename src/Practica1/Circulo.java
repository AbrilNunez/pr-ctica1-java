package Practica1;

public class Circulo {

	double radio;
	Punto centro;
	
		public Circulo(double x, double y, double radio) {
		  this.radio=radio;
		  this.centro=new Punto(x,y);
		 }
		
		public void imprimir() {
			System.out.println("Centro : (" + centro.getX() + ", " + centro.getY() + ")");
			System.out.println("Radio: " + radio);
		}
		
		public double perimetro() {
			double perimetro = 2*Math.PI*this.radio;
			return perimetro;
		}
		
		public double superficie() {
			double superficie = Math.PI*Math.pow(radio, 2);
			return superficie;
		}
		
		public void escalar(double factor) {
			this.radio+=factor;
		}
		
		public void desplazar(double desp_x, double desp_y) {
			this.centro.x += desp_x;
			this.centro.y += desp_y;
		}
		
		public static double distancia(Circulo c1, Circulo c2) {
			return Punto.distancia(c1.centro, c2.centro)-c1.radio-c2.radio <=0?
					0: Punto.distancia(c1.centro, c2.centro)-c1.radio-c2.radio;
		}
		
		public static boolean seTocan(Circulo c1, Circulo c2) {
			return distancia(c1,c2) <= 0;
		}
		
		boolean loContiene(Circulo otro) {
			return Punto.distancia(this.centro, otro.centro)+otro.radio <= this.radio;
		}

		 public String toString() {
		  return "Circulo [radio=" + radio + ", centro=" + centro.toString() + "]";
		 }

		 public double getRadio() {
		  return radio;
		 }

		 public void setRadio(double radio) {
		  if(radio < 0){
		   this.radio=-radio;
		   return;
		  }
		  this.radio = radio;
		 }

		 public Punto getCentro() {
		  return centro;
		 }

		 public void setCentro(Punto centro) {
		  this.centro = centro;
		 }

	
	
	
}
