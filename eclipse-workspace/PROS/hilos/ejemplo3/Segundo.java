package ejemplo3;

public class Segundo extends Thread {
	public void run(){
		for (int i=1;i<10;i++){
		System.out.println("Segundo " + i);
		try {
		sleep (1000);
		} 	
		catch (InterruptedException e) {
			}
		}
	}
}
