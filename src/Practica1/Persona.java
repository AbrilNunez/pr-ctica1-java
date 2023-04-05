package Practica1;

public class Persona {
	private String nombre;
    private int edad;
    private int DNI;
    
    public Persona(String nombre, int edad, int dni) {
    	setNombre(nombre);
    	setEdad(edad);
    	setDNI(dni);    	
    }
    boolean masJovenQue(Persona otro) {
    	return this.edad < otro.edad;  	
    }
    boolean tocayo(Persona otro) {
    	return this.nombre.equalsIgnoreCase(otro.nombre);
    }  
	public boolean mismaPersona(Persona otro) {
//		 return this.nombre.equalsIgnoreCase(otro.nombre)
//				 && this.edad==otro.edad;
		return tocayo(otro) && this.edad==otro.edad
				&& this.DNI==otro.DNI;
	}	
	public static Persona masJoven(Persona[] grupo) {
		Persona mj=grupo[0];
		int joven=grupo[0].edad;
		for (int i=1; i < grupo.length;i++) {
			if(grupo[i].edad < joven) {
				joven=grupo[i].edad;
				mj=grupo[i];
			}
		}
		return mj;
	}
	static Persona buscar(Persona[] grupo, String nom) {
		for(int i=0; i < grupo.length; i++) {
			if(grupo[i].getNombre().equals(nom)) {
				return grupo[i];
			}
		} 
		throw new RuntimeException("NO se encontro la persona");
		//return null;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		if(nombre.length() < 3) {
			throw new RuntimeException("Nombre invalido");
		}
		this.nombre = nombre;
	}
	public int getEdad() {
		return this.edad;
	}
	public void setEdad(int edad) {
		if( edad < 0 || edad > 100) {
			throw new RuntimeException("Edad invalida");
		}
		this.edad = edad;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		if(dNI < 100000 || dNI > 100000000) {
			throw new RuntimeException("DNI invalido");
		}
		DNI = dNI;
	}
	@Override
	public String toString() {
		return "nombre=" + this.nombre + ", edad=" + this.edad + ", DNI=" + this.DNI ;
	}
}
