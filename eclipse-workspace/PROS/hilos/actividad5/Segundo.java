package actividad5;

class Segundo extends Thread { 
	public void run() {
		// Sacamos por pantalla 15 veces "Segundo"
		for (int i=1; i<=15; i++) {
			System.out.println("Segundo " + i);
			try {
				// Esperamos 200ms (0,2s) antes de sacar el siguiente
				sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}
