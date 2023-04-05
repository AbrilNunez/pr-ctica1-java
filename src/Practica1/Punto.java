package Practica1;

public class Punto {
	public double x,y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;	
	}
	public Punto() {
		this.x=0;
		this.y=0;
	}
	public void imprimir() {
		System.out.println("("+ this.x + " , "+ this.y + ")");
	}
	public void desplazar(double d_x,double y_d) {
		this.x=+d_x;
		this.y=+y_d;
	}
	public static double distancia (Punto p1, Punto p2) {
		return Math.sqrt(Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y, 2));
	}
	public String getX() {
		// TODO Auto-generated method stub
		return null;
	}
}
