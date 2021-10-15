package ejemplo5;

public class Segundo implements Runnable {
	public void run() {
		for (int i=1;i<10;i++)
			System.out.println("Segundo " + i + Thread.currentThread().getName());
			Thread.yield();
		}
}
