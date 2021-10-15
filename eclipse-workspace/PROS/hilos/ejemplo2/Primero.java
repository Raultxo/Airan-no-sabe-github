package ejemplo2;

public class Primero implements Runnable {
	public void run() {
		for (int i=1;i<100;i++)
			System.out.println( "Primero " + i );
		}
}
