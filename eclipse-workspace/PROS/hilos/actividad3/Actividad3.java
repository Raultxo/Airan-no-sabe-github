package actividad3;

public class Actividad3 {

	public static void main(String[] args) {
		// Creamos el hilo con el nombre y prioridad por defecto
		Hilo hilo = new Hilo();	
		hilo.start();
		// Visualizamos
		System.out.println("El nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());
		// Le cambiamos el nombre y la prioridad
		hilo.setName("SUPER-HILO-DM2");
		hilo.setPriority(6);
		// Visualizamos
		System.out.println("Ahora el nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());
		System.out.println("Final del programa");
	}
}
