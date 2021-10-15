package hilo3;

public class Hilo extends Thread {
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {}
	}
}
