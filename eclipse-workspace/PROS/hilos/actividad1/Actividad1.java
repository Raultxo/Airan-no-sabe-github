package actividad1;

public class Actividad1 {
	public static void main(String[] args) {	
		// Creamos los 2 hilos y les damos un nombre
		Hilo hilo1 = new Hilo();	
		hilo1.setName("Primero");
		Hilo hilo2 = new Hilo();
		hilo2.setName("Segundo");
		
		// Empezamos los hilos
		hilo1.start();			
		hilo2.start();								

		System.out.print("Fin programa\n");
	}
}
