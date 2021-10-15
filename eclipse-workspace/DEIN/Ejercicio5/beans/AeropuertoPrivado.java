package beans;

public class AeropuertoPrivado {

	private Aeropuerto aeropuerto;
	private int num_socios;
	
	public AeropuertoPrivado(Aeropuerto aeropuerto, int num_socios) {
		this.aeropuerto = aeropuerto;
		this.num_socios = num_socios;
	}
	
	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	public int getNum_socios() {
		return num_socios;
	}
	public void setNum_socios(int num_socios) {
		this.num_socios = num_socios;
	}
	
	

	
	
	
}
