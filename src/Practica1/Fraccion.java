package Practica1;

public class Fraccion {
		public int numerador;
		public int denominador;

		public Fraccion(int numerador, int denominador) {
			if(denominador < 0 ) {
			denominador = -denominador;
			numerador = -numerador;
			}
			this.numerador = numerador;
			this.denominador = denominador;
		}

		public void imprimir() {
			System.out.print(this.numerador);
			if(this.denominador != 1) {
				System.out.println("/" + this.denominador);
			} else {
				System.out.println();
			}
		}

		public void invertirsigno(){
			this.numerador = -this.numerador;
		}

		public void invertir() {
			int aux = this.numerador;
			this.numerador= this.denominador;
			this.denominador= aux;
			if(denominador < 0) {
				this.denominador = -this.denominador;
				this.numerador = -this.numerador;
			}
		}

		public double aDouble() {
			return 1.0*this.numerador/this.denominador;
		}

		public static int mCD(int a , int b) {
			return b == 0 ? a : mCD(b,a%b);
		}

		public void reducir() {
			int aud = mCD(this.numerador, this.denominador);
			this.numerador = this.numerador / aud;
			this.denominador = this.denominador / aud;
		}

		public static Fraccion producto(Fraccion q1, Fraccion q2) {
			Fraccion aux = new Fraccion(q1.numerador*q2.numerador, q1.denominador*q2.denominador);
			aux.reducir();
			return aux;
		}

		public static Fraccion suma(Fraccion q1, Fraccion q2) {
			Fraccion aux = new Fraccion(1,1);
			aux.numerador = q1.numerador * q2.denominador + q1.denominador * q2.numerador;
			aux.denominador = q1.denominador * q2.denominador;
			aux.reducir();
			return aux;
		}

		public int getNumerador() {
			return numerador;
		}

		public void setNumerador(int numerador) {
			this.numerador = numerador;
		}

		public int getDenominador() {
			return denominador;
		}

		public void setDenominador(int denominador) {
			if(denominador == 0){
				System.out.println("El denominador no puede ser 0");
		}
			this.denominador = denominador;
		}
}
