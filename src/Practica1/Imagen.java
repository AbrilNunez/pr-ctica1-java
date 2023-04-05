package Practica1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen {
	Pixel[][] pixels;
	int alto;
	int ancho;
	
	Imagen(String archivo)
	{
		File file= new File(archivo);
		try {
			BufferedImage image = ImageIO.read(file);
			ancho = image.getWidth();
			alto = image.getHeight();
			pixels = new Pixel[alto][ancho];
			for(int i=0; i<alto; i++)
			{
				for(int j=0; j<ancho; j++)
				{
					pixels[i][j]=new Pixel(image.getRGB(j, i));
				}
			}
		} catch (IOException e) {
			System.err.println("No se encontr� el archivo " + archivo);
			System.exit(0);
		}
	}
	/* Guarda la imagen en un archivo segun el formato indicado
	 @param archivo El nombre de archivo, e.g., "lena.bmp"
	  @param formato El formato de imagen: "bmp", "png", "jpg", etc. 
	 */
	void guardar(String archivo, String formato)
	{
		BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		for(int i=0; i<alto; i++)
		{
			for(int j=0; j<ancho; j++)
				image.setRGB(j,i, pixels[i][j].aInt());
		}
		
		try {
			ImageIO.write(image, formato, new File(archivo));
		} catch (IOException e) {
			System.err.println("Error al guardar en el archivo " + archivo);
			e.printStackTrace();
		}
	}
	 public void lineaNegra() 
	 {
	  for(int i=50;i  < 100;i++) {
	   for(int j=0; j < ancho; j++) {
	    pixels[i][j].rojo=0; 
	    pixels[i][j].azul=255; 
	    pixels[i][j].verde=0; 
	   }
	  }
	  
	 }
	 public void enrojecer(int cant) {
	  for(int i=0;i  < alto;i++) {
	   for(int j=0; j < ancho; j++) {
	    pixels[i][j].enrojecer(cant);
	   
	   }
	  }
	 }
	 public  void enverdecer(int cant) {
		int aux=0;
		for(int i=0; i<alto; i++){
			for(int j=0; j<ancho; j++){
				aux = pixels[i][j].verde+cant;
				if (aux>255) {
					aux=255;
				}
				pixels[i][j].verde=aux;
	  }
	 }
	}
	public  void aumentarBrillo(int cant) {
		int auxR=0;
		int auxV=0;
		int auxA=0;
		for(int i=0; i<alto; i++){
			for(int j=0; j<ancho; j++){
				auxR = pixels[i][j].rojo+cant;
				if (auxR>255) {
					auxR=255;
				}
				auxV = pixels[i][j].verde+cant;
					if (auxV>255) {
						auxV=255;
				}
				auxA = pixels[i][j].azul+cant;
					if (auxA>255) {
						auxA=255;
					}
				auxR = pixels[i][j].rojo+cant;
					if (auxR<0) {
						auxR=0;
					}
				auxV = pixels[i][j].verde+cant;
					if (auxV<0) {
						auxV=0;
					}
				auxA = pixels[i][j].azul+cant;
					if (auxA<0) {
						auxA=0;
					}
					pixels[i][j].rojo=auxR;
					pixels[i][j].verde= auxV;
					pixels[i][j].azul=auxA;
				}
			}
		}
	void aGrises() {
		int aux=0;
		for(int i=0; i<alto; i++){
			for(int j=0; j<ancho; j++){
				aux=(int) (pixels[i][j].rojo*0.3 + pixels[i][j].verde*0.6+ pixels[i][j].azul*0.1);
				if (aux>255) {
					aux=255;
				}
				pixels[i][j].rojo=aux;
				pixels[i][j].verde=aux;
				pixels[i][j].azul=aux;
			}
		}
	}
	 
	 public void abrillantar(int cant) {
	  for(int i=0;i  < alto;i++) {
	   for(int j=0; j < ancho; j++) {
	    pixels[i][j].abrillantar(cant);
	   
	   }
	  }
	 }
	 void invertir() {
		for(int i=0; i<alto; i++){
			for(int j=0; j<ancho; j++){
				pixels[i][j].rojo=255-pixels[i][j].rojo;
				pixels[i][j].verde=255-pixels[i][j].verde;
				pixels[i][j].azul= 255- pixels[i][j].azul;
			}
		}
	 }
	 void espejar() {
		Pixel[][] p = new Pixel[alto][ancho];
		for(int i=0; i<alto; i++){
			for(int j=0; j<ancho; j++){
				p[i][j]=pixels[i][ancho- 1-j];
			}
		}
		//aca arranco otro ciclo
		for(int i=0; i<alto; i++){
			for(int j=0; j<ancho; j++){
				pixels[i][j]=p[i][j];
			}
		}  
	}
	 void girarDerecha() {
		int ancho1= alto;
		int alto1= ancho;
		Pixel[][] p = new Pixel[alto1][ancho1];
		for(int i=0; i<alto1; i++){
			for(int j=0; j<ancho1; j++) {
				p[i][j]=pixels[j][i];
			}
		}
		//rearmar pixels
		pixels = new Pixel[alto1][ancho1];
		for(int i=0; i<alto1; i++){
			for(int j=0; j<ancho1; j++){
				pixels[i][j]=p[i][j];
				}
			}  
		alto= alto1;
		ancho=ancho1;
	}
}

