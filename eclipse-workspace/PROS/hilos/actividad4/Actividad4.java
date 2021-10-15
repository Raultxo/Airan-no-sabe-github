package actividad4;

public class Actividad4 {
	public static void main(String arg[]) {
		
		// Creamos los 2 hilos, como los hilos no extienden de la clase
		// Thread, hay que crearlos como Thread
		Thread p = new Thread(new Posicion());
		Thread s = new Thread(new Posicion());
		// Les ponemos el nombre
		p.setName("Primero");
		s.setName("Segundo");
		// Los iniciamos
		p.start();
		s.start();
		System.out.println( "Fin programa ");
	}
}
