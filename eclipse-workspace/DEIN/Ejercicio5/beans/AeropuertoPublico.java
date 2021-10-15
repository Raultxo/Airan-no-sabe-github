package beans;

public class AeropuertoPublico {

	private Aeropuerto aeropuerto;
	private double financiacion;
	private int num_trabajadores;
	public AeropuertoPublico(Aeropuerto aeropuerto, double financiacion, int num_trabajadores) {
		this.aeropuerto = aeropuerto;
		this.financiacion = financiacion;
		this.num_trabajadores = num_trabajadores;
	}
	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}
	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	public double getFinanciacion() {
		return financiacion;
	}
	public void setFinanciacion(double financiacion) {
		this.financiacion = financiacion;
	}
	public int getNum_trabajadores() {
		return num_trabajadores;
	}
	public void setNum_trabajadores(int num_trabajadores) {
		this.num_trabajadores = num_trabajadores;
	}
	
	
	
}
