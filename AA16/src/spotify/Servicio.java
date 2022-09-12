package spotify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Funciones y metodos a implementar USANDO AOP
 * 
 * @author USUARIO
 *
 */
@Service
public class Servicio {
	
	StringBuilder info = new StringBuilder();
	List<Artista> lista = null;

	public void cargartxt() {
		System.out.println("Cargando txt en la Clase Servicio.");
		File artistas20 = new File("Artistas 2020.txt");
		File artistas21 = new File("Artistas 2021.txt");
		File canciones20 = new File("Canciones 2020.txt");
		File canciones21 = new File("Canciones 2021.txt");

		Artista artista = null;

		info.append("TOP 10 ARTISTAS DE 2020\n");
		try (BufferedReader leer = new BufferedReader(new FileReader(artistas20))) {

			// Utilizo un readLine para leer líneas completas.
			String leido = leer.readLine();

			// Utilizo un while para que se haga mientras que lo leído no sea null.
			while (leido != null) {

				info.append(leido + "\n");

				// Para que vuelva a leer.
				leido = leer.readLine();
			}

		} catch (FileNotFoundException ex) {
			System.err.println("Error: " + ex);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		} // Fin try-with-resources.

		info.append("\nTOP 10 ARTISTAS DE 2021");
		try (BufferedReader leer = new BufferedReader(new FileReader(artistas21))) {

			// Utilizo un readLine para leer líneas completas.
			String leido = leer.readLine();

			info.append("\n");
			// Utilizo un while para que se haga mientras que lo leído no sea null.
			while (leido != null) {

				info.append(leido + "\n");

				// Para que vuelva a leer.
				leido = leer.readLine();
			}

		} catch (FileNotFoundException ex) {
			System.err.println("Error: " + ex);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		} // Fin try-with-resources.

		try (BufferedReader leer = new BufferedReader(new FileReader(canciones20))) {

			lista = new LinkedList<>();
			// Utilizo un readLine para leer líneas completas.
			String leido = leer.readLine();

			// Utilizo un while para que se haga mientras que lo leído no sea null.
			while (leido != null) {

				// Divido la línea anterior en atributos usando : como separador.
				String[] atributo = leido.split(":");

				artista = new Artista(atributo[0], atributo[1], Integer.valueOf(atributo[2]));

				lista.add(artista);

				// Para que vuelva a leer.
				leido = leer.readLine();
			}

		} catch (FileNotFoundException ex) {
			System.err.println("Error: " + ex);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		} // Fin try-with-resources.

		try (BufferedReader leer = new BufferedReader(new FileReader(canciones21))) {

			// Utilizo un readLine para leer líneas completas.
			String leido = leer.readLine();

			// Utilizo un while para que se haga mientras que lo leído no sea null.
			while (leido != null) {

				// Divido la línea anterior en atributos usando : como separador.
				String[] atributo = leido.split(":");

				artista = new Artista(atributo[0], atributo[1], Integer.valueOf(atributo[2]));

				lista.add(artista);

				// Para que vuelva a leer.
				leido = leer.readLine();
			}

		} catch (FileNotFoundException ex) {
			System.err.println("Error: " + ex);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		} // Fin try-with-resources.

	}// Fin cargartxt.

	public void generarArchivo() {
		// Escribo en el fichero.
		try (PrintWriter ficheroSalida = new PrintWriter("archivo_salida.txt")) {

			Usuario usuario = new Usuario("1", "Tomás Carretero Reyes", "tomascr1@yahoo.es");

			ficheroSalida.println(usuario.toString() + "\n");
			ficheroSalida.println(info + "\n" + "Artista:Canción:Veces Escuchado:Recaudación ---->\n");
			int i;
			// Recorro el List, y escribo el valor de cada artista,
			for (i = 1; i <= lista.size();) {
				ficheroSalida.println("TOP 10 ARTISTAS DE 2020");
				for (Artista c : lista) {

					if (i == 11) {
						ficheroSalida.println("\nTOP 10 ARTISTAS DE 2021");
					}
					ficheroSalida.println(c.toString());
					i++;
				}
			}

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
	}
}// Fin class.