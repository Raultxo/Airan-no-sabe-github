package hilo2;

public class Hilo extends Thread {

	public void run() {
		// Bucle de 20 sacando el nombre del Hilo
		for(int i = 1; i <= 20; i++) {
			System.out.println(getName() + ": " + i);
		}
	}
}
