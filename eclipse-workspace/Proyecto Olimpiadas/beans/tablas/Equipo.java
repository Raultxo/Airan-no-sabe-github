package tablas;

public class Equipo {

	private int id;
	private String nombre, iniciales;
	public Equipo(int id, String nombre, String iniciales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.iniciales = iniciales;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIniciales() {
		return iniciales;
	}
	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
	
	@Override
	public String toString() {
		return nombre + ", abreviatura: " + iniciales;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iniciales == null) ? 0 : iniciales.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (iniciales == null) {
			if (other.iniciales != null)
				return false;
		} else if (!iniciales.equals(other.iniciales))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
	
}
