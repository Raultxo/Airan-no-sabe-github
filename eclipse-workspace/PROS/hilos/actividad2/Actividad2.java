package actividad2;

public class Actividad2 {
	public static void main(String[] args) {
		// Guardamos en un int el numero que se pasa como argumento
		int n = Integer.parseInt(args[0]);
		// Bucle que crea n Hilos
		for(int i = 1; i <= n; i++){
			// Creamos un hilo y le ponemos un nombre
			Hilo hilo = new Hilo();
			hilo.setName("Hilo " + (i));
			// Empezamos el hilo
			hilo.start();
		}	
		System.out.println("Final Programa");
	}
}
