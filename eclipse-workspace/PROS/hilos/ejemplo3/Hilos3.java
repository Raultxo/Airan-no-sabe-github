package ejemplo3;

public class Hilos3 {
	public static void main(String arg[]) {
		Primero p=new Primero();
		Segundo s=new Segundo();
		p.start();
		s.start();
		System.out.print("Fin programa \n");
	}
}
