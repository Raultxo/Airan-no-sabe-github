package actividad5;

class Primero extends Thread  { 
	public void run() {
		// Sacamos por pantalla 15 veces "Primero"
		for (int i=1; i<15; i++) {
			System.out.println("Primero " + i);
			try {
				// Esperamos 100ms (0,2s) antes de sacar el siguiente
				sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}
