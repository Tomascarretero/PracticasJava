package empresa;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 
 * @author Tomás Carretero Reyes
 *
 */
public class Principal {

	public static void main(String[] args) {

		Videojuego Uno = new Videojuego("DARK SOULS 3", 10000, 5);
		Videojuego Dos = new Videojuego("THE LAST OF US", 50000, 10);
		Videojuego Tres = new Videojuego("FIFA 2022", 60000, 15);
		Videojuego Cuatro = new Videojuego("MARIO BROSS", 45000, 1);
		Videojuego Cinco = new Videojuego("DOOM 2", 100000, 1);
		Videojuego Seis = new Videojuego("HORIZON", 50000, 5);

		System.out.println(Uno.montoTotal());
		System.out.println(Uno.toString());

		// Escribo en el fichero.
		try (PrintWriter ficheroSalida = new PrintWriter("salida.txt")) {

			ficheroSalida.println("VIDEOJUEGOS:     CANTIDAD DE REGISTROS         MONTO TOTAL");
			ficheroSalida.println(Uno.toString() + "\n" +  Dos.toString() + "\n" +  
			Tres.toString() + "\n" +  Cuatro.toString() + "\n" +  Cinco.toString() + "\n" + Seis.toString());

			// Utilizo un flush para asegurarme que se vuelca en disco todo lo que hay en el
			// buffer.
			ficheroSalida.flush();

			// Muestro un mensaje como que el archivo se ha generado.
			if (ficheroSalida != null) {

				System.out.println();
				System.out.println("Archivo de texto generado");
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} // Fin try-with-resources.

	}// Fin main.

}// Fin class.