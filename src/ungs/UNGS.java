package ungs;

public class UNGS {
	Comision[] comisiones;
	public UNGS(int cantComisiones) {
		comisiones=new Comision[cantComisiones];
	}

	boolean cursaCon(Estudiante est, Docente doc) {	
		for(Comision co:comisiones) {
			for(Estudiante e:co.inscriptos) {
				if (e.equals(est)) {
					for (Docente d:co.docentes) {
						if(d.equals(doc)) {
							return true;
						}
					}
				}
			}
		}
		 		 
		return false;
	}
	boolean suficientesDocentes() {
		for(Comision co:this.comisiones) {
			if(co.docentes.length*20 < co.inscriptos.length){
				return false;
			}
		}
		return true;
	}
	Estudiante elMasEstudioso() {
		Estudiante masEst=comisiones[0].inscriptos[0];
		int masCur=cantMatAprobadas(masEst);
		for(Comision co:comisiones) {
			for(Estudiante es:co.inscriptos) {
				if(cantMatAprobadas(es) > masCur) {
					masCur=cantMatAprobadas(es);
					masEst=es;
				}
			}
		}
		return masEst;
	}	
	public int cantMatAprobadas(Estudiante e) {
		int cant=0;
		for(Comision co:comisiones) {
			for (int i=0; i < co.inscriptos.length;i++) {
				if (co.inscriptos[i].equals(e) && co.calificaciones[i] >= 4) {
					cant++;
				}
			}
		}
		return cant;
	}	
	public int losMejores() {
		int cant=0;
		int nota=0;
		for(Comision co:comisiones) {
			nota=0;
			for(int calif:co.calificaciones) {
				if(nota < calif) {
					nota=calif;
				}
			}
			for(int calif:co.calificaciones) {
				if(calif==nota) {
					cant++;
				}
			}
		}
		return cant;
	}
	public int alumnosDe(Docente d) {
		int cant=0;
		for(Comision co:comisiones) {
			for(Docente doc:co.docentes) {
				if(doc.equals(d)) {
					cant +=co.inscriptos.length;
				}
			}
		}
			return cant;
	}	
	public int unicaComision() {
		int cant=0;
		for(Comision co:comisiones) {
			if(cantMaterias(co.materia) == 1) {
				cant++;
			}
		}
		return cant;
	}
	public int cantMaterias(String m) {
		int cant=0;
		for(Comision ko:comisiones) {
			if(ko.materia.equals(m)) {
				cant++;
			}
		}
		return cant;
	}
}
