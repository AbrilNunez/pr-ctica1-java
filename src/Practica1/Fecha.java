package Practica1;

public class Fecha {
	// variables de instancia
	 private int dia;
	 private int mes;
	 private int anio;

	 public Fecha() {
	  this.dia=1;
	  this.mes=1;
	  this.anio=1970;
	 }
	 public Fecha(int dia, int mes, int anio) {
	  this.dia = 1;
	  this.mes = 1;
	  setAnio(anio);
	  setMes(mes);
	  setDia(dia);


	 }

	 public void imprimir() {
	  System.out.println(this.dia+"/"+this.mes+"/"+this.anio);

	 }

	 public void imprimirConString() {
	  String[] s= {"","Enero","Febrero","Marzo","Abril","Mayo","Junio","julio",
	    "Agosto","Setiembre","Noviembre","Diciembre"};
	  System.out.println(this.dia+" de "+s[this.mes ]+" de "+this.anio);
	 }

	 public boolean esVerano() {
	  if(this.mes <= 2) {
	   return true; 
	  }
	  if(this.mes == 12 && this.dia >=21) {
	   return true; 
	  }
	  if(this.mes == 3 && this.dia < 21 ) {
	   return true; 
	  }
	  return false;
	 }

	 public static boolean esBisiesto(int a) {
	  return((a%4 == 0 && a%100 != 0 ) || a%400 == 0);

	 }
	 public static int diasDelMes(int mes, int anio) {
	  if(mes==2 ) {
	   return esBisiesto(anio)?29:28;  }
	  if(mes == 1 || mes == 5 || mes == 7 ||
	     mes == 10 || mes == 12) {
	   return 31;
	  }
	  return 30;
	 }
	 public boolean esValida() {
	  if(this.mes < 1 || this.mes > 12) {
	   return false;  }
	  if(this.dia < 1 || this.dia > diasDelMes(this.mes, this.anio)) {
	   return false;  }
	  return true;
	 }

	 public void avanzarDia() {
	  if(this.dia==31 && this.mes==12) {
	   this.dia=1;
	   this.mes=1;
	   this.anio++;
	   return;
	  }

	  if(this.dia == diasDelMes(this.mes, this.anio)) {
	   this.dia=1;
	   this.mes++;
	   return;
	  }
	  this.dia++;


	 }

	 public int diaDelAnio() {
	  int aux = 0;
	  for (int i=1; i < this.mes;i++) {
	   aux=aux+diasDelMes(i, this.anio);
	  }
	  return aux+this.dia;
	 }
	 // tomo fecha base 1900
	 public int numSerie() {
	  int aux=0;
	  for (int i=1900; i < this.anio;i++) {
	   aux=aux+365+(esBisiesto(i)?1:0);
	  }
	  return aux+this.diaDelAnio();
	 }

	 public boolean antesQue(Fecha otra) {
	  return this.numSerie() < otra.numSerie();
	 }
	 public int diasDeDiferenciaCon(Fecha otra) {
	  return otra.numSerie()-this.numSerie();
	 }
	 public int getDia() {
	  return dia;
	 }
	 public void setDia(int dia) {
	  if(dia < 1 || dia > diasDelMes(this.mes, this.anio)) {
	   System.out.println("Dia invalido");
	   return;
	  }
	  this.dia = dia;
	 }
	 public int getMes() {
	  return mes;
	 }
	 public void setMes(int mes) {

	  if(mes < 1 || mes > 12) {
	   System.out.println("Mes invalido");
	   return;
	  }
	  if (this.dia > diasDelMes(mes, this.anio)) {
	   System.out.println("La combinacion entre dias y mes invalida");
	   return;
	  }
	  this.mes = mes;
	 }
	 public int getAnio() {
	  return anio;
	 }
	 public void setAnio(int anio) {
	  if (this.dia > diasDelMes(this.mes, anio)) {
	   System.out.println("La combinacion entre dias invalida para este año");
	   return;
	  }
	  this.anio = anio;
	 }
}
