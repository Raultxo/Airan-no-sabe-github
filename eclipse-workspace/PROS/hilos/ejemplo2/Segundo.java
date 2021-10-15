package ejemplo2;

public class Segundo implements Runnable {
	public void run() {
		for (int i=1;i<100;i++)
			System.out.println( "Segundo " + i );
	}
}
