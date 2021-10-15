package ejemplo4;

public class Primero implements Runnable {
	public void run() {
		for (int i=1;i<10;i++){
			System.out.println( "Primero " + i );
		try{
			Thread.sleep(100);
			} catch (InterruptedException e){}
		}
	}	
}
