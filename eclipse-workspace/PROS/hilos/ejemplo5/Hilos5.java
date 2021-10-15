package ejemplo5;

public class Hilos5 {
	public static void main(String arg[]) {
		Thread p = new Thread(new Primero());
		Thread s = new Thread(new Segundo());
		p.start();
		s.start();
		System.out.println( "Fin programa ");
	}
}
