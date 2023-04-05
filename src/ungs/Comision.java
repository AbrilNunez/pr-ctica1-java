package ungs;

public class Comision {
	String materia;
	int numero;
	Docente[] docentes;
	Estudiante[] inscriptos;
	int[] calificaciones;

	public Comision(String mat, int num) {
		 
	}
	boolean verEstudiante(Estudiante e) {
		for(Estudiante est:inscriptos) {
			if(est.equals(e)) {
				return true;
			}
		}
		return false;
	}
	boolean verDocente(Docente d) {
		for(Docente doc:docentes) {
			if(doc.equals(d)) {
				return true;
			}
		}
		return false;
	}
}
