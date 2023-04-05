package Practica1;

public class TestFecha {
	 public static void main(String[] args) {
		   Fecha f=new Fecha(33,2,2023);
		   //Fecha otra=new Fecha(31,5,2023);
		   f.imprimir();
		    f.setDia(01);
		    f.setMes(2);
		    
		    f.imprimir();
		    f.setAnio(2023);
		    f.imprimir();
		   //f.imprimirConString();
		   //System.out.println(f.mes); 
		   //System.out.println(f.esBisiesto(2020));
		   //System.out.println(Fecha.esBisiesto(f.anio));
		  // System.out.println(f.diaDelAnio());
		//   System.out.println(f.antesQue(otra));
		//   System.out.println(f.diasDeDiferenciaCon(otra));
		 }
}
