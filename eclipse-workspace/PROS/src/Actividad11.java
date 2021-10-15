import java.io.*;

public class Actividad11 {

	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		String comando="java Ejemplo2"; // Comando para ejecutar un class de Java
	    Process p = null; // Creo una variable Process
		try {
			p = r.exec (comando); // Guardo en la variable process la salida del comando
			InputStream is = p.getInputStream(); // Creo un InputStream para escribir la salida del comando
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			String linea;
			while((linea = br.readLine()) != null) // lee una linea
				System.out.println(linea);
			br.close();
			}
		catch (Exception e) { // Cazo cualquier excepcion por si ocurre algo durante la ejecucion
			e.printStackTrace();
		}
		
		///// Comprobación: Valor= 0 bien, Valor = - 1 mal
		int exitVal;
		try {
			exitVal=p.waitFor();
			System.out.println ("Valor de Salida "+exitVal);
		}  catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}

