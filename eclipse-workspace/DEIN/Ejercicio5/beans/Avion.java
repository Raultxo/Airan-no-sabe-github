package beans;

public class Avion {

	private int id;
	private String modelo;
	private int numero_asientos;
	private int velocidad_maxima;
	private int activado;
	private Aeropuerto aeropuerto;
	public Avion(int id, String modelo, int numero_asientos, int velocidad_maxima, int activado, Aeropuerto aeropuerto) {
		this.id = id;
		this.modelo = modelo;
		this.numero_asientos = numero_asientos;
		this.velocidad_maxima = velocidad_maxima;
		this.activado = activado;
		this.aeropuerto = aeropuerto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumero_asientos() {
		return numero_asientos;
	}
	public void setNumero_asientos(int numero_asientos) {
		this.numero_asientos = numero_asientos;
	}
	public int getVelocidad_maxima() {
		return velocidad_maxima;
	}
	public void setVelocidad_maxima(int velocidad_maxima) {
		this.velocidad_maxima = velocidad_maxima;
	}
	public int getActivado() {
		return activado;
	}
	public void setActivado(int activado) {
		this.activado = activado;
	}
	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	
	
	
	
}
