package ejemplo4;

public class Segundo implements Runnable {
public void run() {
		for (int i=1;i<10;i++){
			System.out.println( "Segundo " + i );
		try{
			Thread.sleep((long) ( Math.random() * 200));
			}catch (InterruptedException e){}
		}
	}
}
