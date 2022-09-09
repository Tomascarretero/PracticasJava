package peliculas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Tomás Carretero Reyes.
 * 
 *         Programa que lee dos archivos de películas. Tiene nombre y
 *         recaudación. Se muestra ordenado por recaudación (de mayor
 *         recaudación a menor recaudación). 1º, un archivo de la película que
 *         ha recaudado de 11 a la 20. Posteriormente, de la 1ª a la 10ª. Luego
 *         sale en el orden mencionado anteriormente.
 * 
 *         También creo un Jenkinsfile para usar en Jenkins desde GitHub.
 *
 */
public class Principal {

	public static void main(String[] args) {

		// Los 2 archivos a pasar.
		File archivo = new File("Peliculas_11_20.txt");
		File archivoDos = new File("Peliculas_01_10.txt");

		// Almaceno películas, donde la clave es la recaudación. Se ordena por la clave.
		TreeMap<Long, String> almacen = new TreeMap(Collections.reverseOrder());
		StringBuilder builder = new StringBuilder();

		// Llamo al método para leer los archivos.
		extracted(archivo, almacen);
		extracted(archivoDos, almacen);

		// Para guardar en un StringBuilder las películas de forma ordenada.
		for (Map.Entry<Long, String> peliculas : almacen.entrySet()) {
			builder.append(peliculas.getValue() + "                                            " + peliculas.getKey() + "\n");
		}

		// Muestro las películas.
		System.out.println(builder.toString());

		// Escribo en el fichero de las películas.
		try (PrintWriter ficheroSalida = new PrintWriter("top20_mejores_peliculas.txt")) {

			// Escribo en el fichero.
			ficheroSalida.println(builder.toString());

			// Utilizo un flush para asegurarme que se vuelca en disco todo lo que hay en el
			// buffer.
			ficheroSalida.flush();

			// Muestro un mensaje como que el archivo se ha generado.
			if (ficheroSalida != null) {

				System.out.println();
				System.out.println("Archivo de peliculas generado");
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (Exception e) {
			System.out.println("Error: " + e.getCause());
		} // Fin try-with-resources.

		// Creo el fichero Jenkinsfile.
		try (PrintWriter ficheroSalida = new PrintWriter("JenkinsfileDos.txt")) {

			ficheroSalida.println("import java.text.DateFormat;\r\n" + "import java.text.SimpleDateFormat;\r\n"
					+ "import java.util.Date;\r\n" + "\r\n" + "Date date = new Date();\r\n"
					+ "DateFormat dateFormat=new SimpleDateFormat(\"dd/MM/yyyy\");\r\n"
					+ "def elDia = dateFormat.format(date)\r\n" + "pipeline {\r\n" + "    agent any\r\n" + "\r\n"
					+ "    stages {\r\n" + "        stage('info') {\r\n" + "            steps {\r\n"
					+ "                script{\r\n"
					+ "                        println \"Hola Mundo! EL día de hoy es \" + elDia + \" . Este curso me hizo programar mas de lo que me hubiese gustado.\"\r\n"
					+ "                                    \r\n" + "                }\r\n" + "            }\r\n"
					+ "        }  \r\n" + "    }\r\n" + "}");

			// Utilizo un flush para asegurarme que se vuelca en disco todo lo que hay en el
			// buffer.
			ficheroSalida.flush();

			// Muestro un mensaje como que el archivo se ha generado.
			if (ficheroSalida != null) {

				System.out.println();
				System.out.println("Archivo JenkinsfileDos generado");
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} // Fin try-with-resources.

	}// Fin Main.

	/**
	 * Método para leer los archivos y guardar los datos en un TreeMap.
	 * 
	 * @param archivo Archivo a pasar
	 * @param almacen TreeMap para añadir las claves y valores.
	 */
	private static void extracted(File archivo, TreeMap<Long, String> almacen) {
		try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {

			// Utilizo un readLine para leer líneas completas.
			String leido = leer.readLine();

			// Utilizo un while para que se haga mientras que lo leído no sea null.
			while (leido != null) {

				// Divido la línea anterior en atributos usando : como separador.
				String[] atributo = leido.split(":");

				// Guardo en el TreeMap.
				almacen.put(Long.valueOf(atributo[1]), atributo[0]);

				// Para que vuelva a leer.
				leido = leer.readLine();
			}

		} catch (FileNotFoundException ex) {
			System.err.println("Error: " + ex);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		} // Fin try-with-resources.
	}// Fin Main.
}// Fin class.