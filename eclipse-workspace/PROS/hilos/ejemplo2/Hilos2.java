package ejemplo2;

public class Hilos2 {
	public static void main(String arg[]) {
		Thread p = new Thread(new Primero());
		Thread s = new Thread(new Segundo());
		p.start();
		s.start();
		System.out.println( "Fin programa ");
	}
}