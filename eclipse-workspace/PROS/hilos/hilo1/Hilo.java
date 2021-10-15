package hilo1;

public class Hilo extends Thread {

	public void run() {
		// Bucle de 20 sacando el nombre del Hilo + el numero del bucle
		for (int i = 1; i <= 20;i++)
			System.out.println(getName() + " " + i);
	}
}
