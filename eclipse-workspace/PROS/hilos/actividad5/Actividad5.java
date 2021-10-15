package actividad5;

public class Actividad5 {
	public static void main(String arg[]) {
		// Creamos los hilos Primero y Segundo
		Primero p = new Primero();
		Segundo s = new Segundo();
		p.start();
		s.start();
		System.out.println("Fin programa");
	}
}