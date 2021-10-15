package actividad4;

public class Posicion implements Runnable {
	public void run() {
		// Bucle de 15 que saca por pantalla el nombre del hilo
		for (int i=1; i<=15; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}