package actividad3;

public class Hilo extends Thread {
	public void run() {
		try {
			// Dormimos el hilo 1000ms para que pueda cambiar de prioridad
			sleep(1000);
		} catch (InterruptedException e) {}
	}
}
