package tablas;

public class Deportista {

	private int id, peso, altura;
	private String nombre, sexo;
	public Deportista(int id, String nombre, String sexo, int peso, int altura) {
		super();
		this.id = id;
		this.peso = peso;
		this.altura = altura;
		this.nombre = nombre;
		this.sexo = sexo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		String str = nombre + ", sexo: " + sexo;
		if(peso > 0) {
			str += ", peso: " + peso + "kg";
		}
		if(altura > 0) {
			str += ", altura: " + altura + "cm";
		}
		return str;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + altura;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + peso;
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Deportista other = (Deportista) obj;
		if (altura != other.altura)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (peso != other.peso)
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	
	
	
	
}
