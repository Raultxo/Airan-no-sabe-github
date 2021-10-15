package ejemplo3;

public class Primero extends Thread {
	public void run(){
		for (int i=1;i<10;i++){
		System.out.println("Primero " + i);
		try {
		sleep (1000);
		} 	
		catch (InterruptedException e) {
			}
		}
	}
}
