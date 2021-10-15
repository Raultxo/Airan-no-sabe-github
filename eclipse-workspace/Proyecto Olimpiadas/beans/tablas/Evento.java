package tablas;

public class Evento {

	private int id;
	private Olimpiada olimp;
	private Deporte deporte;
	private String nombre;
	public Evento(int id,String nombre, Olimpiada olimp, Deporte deporte ) {
		super();
		this.id = id;
		this.olimp = olimp;
		this.deporte = deporte;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Olimpiada getOlimp() {
		return olimp;
	}
	public void setOlimp(Olimpiada olimp) {
		this.olimp = olimp;
	}
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre + ", deporte: " + deporte.getNombre();
	}
	

	
	
	
}
