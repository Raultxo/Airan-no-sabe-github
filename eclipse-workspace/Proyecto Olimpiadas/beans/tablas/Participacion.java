package tablas;

public class Participacion {

	private int edad;
	private Deportista deportista;
	private Evento evento;
	private Equipo equipo;
	private String medalla;
	public Participacion(Deportista deportista, Evento evento, Equipo equipo, int edad, String medalla) {
		super();
		this.deportista = deportista;
		this.evento = evento;
		this.equipo = equipo;
		this.edad = edad;
		this.medalla = medalla;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Deportista getDeportista() {
		return deportista;
	}
	public void setDeportista(Deportista deportista) {
		this.deportista = deportista;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public String getMedalla() {
		return medalla;
	}
	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	
	@Override
	public String toString() {
		String str = deportista.getNombre() + " del equipo: " + equipo.getNombre() + ", a la edad de: " + edad;
		if(medalla.equals("Oro")) {
			str += ", medalla: Oro";
		}
		if(medalla.equals("Plata")) {
			str += ", medalla: Plata";
		}
		if(medalla.equals("Bronce")) {
			str += ", medalla: Bronce";
		}
		if(medalla.equals("Sin medalla")) {
			str += ", sin medalla";
		}
		return str;
	}
	
	
	
	
	
}
