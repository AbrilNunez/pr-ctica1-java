package Practica1;

public class Main {

	 public static void main(String[] args) 
	 {
	//  Punto a=new Punto(2 , 10);
	////  System.out.println(a);
	//  Circulo cc=new Circulo(400,300,300);
	//  System.out.println(cc);
	//  cc.setRadio(-5);
	//  System.out.println(cc);
	//  cc.setCentro(a);
	//  System.out.println(cc);
	//  Punto b=cc.getCentro();
	//  System.out.println(b);
	//  b.x=200;
	//  System.out.println(cc);
	  Dibujador dib=new Dibujador(800,800);
	  //dib.dibujar(cc);
	  Imagen img=new Imagen("lena.bmp");
	//  dib.dibujar(img);
	//  img.lineaNegra();
	  dib.dibujar(img);
	  //img.enrojecer(150);
	  //img.abrillantar(-100);
	  img.espejar();
	  dib.dibujar(img);
	}

}
