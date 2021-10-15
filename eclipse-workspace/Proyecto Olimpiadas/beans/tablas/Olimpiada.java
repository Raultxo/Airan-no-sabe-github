package tablas;

public class Olimpiada {

	private int id, anio;
	private String nombre, temporada, ciudad;
	public Olimpiada(int id, String nombre, int anio, String temporada, String ciudad) {
		super();
		this.id = id;
		this.anio = anio;
		this.nombre = nombre;
		this.temporada = temporada;
		this.ciudad = ciudad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return "Olimpiada: " + nombre + ", ciudad: " + ciudad;
	}
	
	
	
}
