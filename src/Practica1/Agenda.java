package Practica1;

import java.util.Arrays;

public class Agenda {
	private Persona[] contactos;
	private String[] telefonos;
	public Agenda (int tamanio){
		this.contactos=new Persona[tamanio];
		this.telefonos=new String[tamanio];
	}
	void guardar(Persona contacto, String telefono) {
		for (int i=0; i < this.contactos.length;i++) {
			if (this.contactos[i]==null) {
				this.contactos[i]=contacto;
				this.telefonos[i]=telefono;
				return;
			}
		}
		Persona[] nuevosCont=new Persona[this.contactos.length+10];
		String[] nuevosTel=new String[this.contactos.length+10];
		for (int i=0; i < this.contactos.length;i++) {
			nuevosCont[i]=this.contactos[i];
			nuevosTel[i]=this.telefonos[i];
		}
		nuevosCont[this.contactos.length]=contacto;
		nuevosTel[this.contactos.length]=telefono;
		this.contactos=nuevosCont;
		this.telefonos=nuevosTel;
	}
	void eliminar(Persona contacto) {
		for (int i=0; i < this.contactos.length;i++) {
			if (this.contactos[i].mismaPersona(contacto)) {
				this.contactos[i]=null;
				this.telefonos[i]=null;
				return;
			}
		}
	}
	boolean pertenece(Persona contacto) {
		for (Persona p : this.contactos) {
			if (p!=null && p.mismaPersona(contacto)) {
				return true;
			}
		}
		return false;

	}
	String dameTelefono(Persona contacto) {
		for (int i=0; i < this.contactos.length;i++) {
			if (this.contactos[i] != null && this.contactos[i].mismaPersona(contacto)){
				return this.telefonos[i];
			}
		}
		return "No esta agendada";
	}

	public Persona[] getContactos() {
		return contactos;
	}
	public void setContactos(Persona[] contactos) {
		this.contactos = contactos;
	}
	public String[] getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(String[] telefonos) {
		this.telefonos = telefonos;
	}
	@Override
	public String toString() {
		return "contactos=" + Arrays.toString(contactos) + ", telefonos=" + Arrays.toString(telefonos);
	}

}
