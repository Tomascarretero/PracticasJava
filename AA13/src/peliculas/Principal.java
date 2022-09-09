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
 * @author Tom�s Carretero Reyes.
 * 
 *         Programa que lee dos archivos de pel�culas. Tiene nombre y
 *         recaudaci�n. Se muestra ordenado por recaudaci�n (de mayor
 *         recaudaci�n a menor recaudaci�n). 1�, un archivo de la pel�cula que
 *         ha recaudado de 11 a la 20. Posteriormente, de la 1� a la 10�. Luego
 *         sale en el orden mencionado anteriormente.
 * 
 *         Tambi�n creo un Jenkinsfile para usar en Jenkins desde GitHub.
 *
 */
public class Principal {

	public static void main(String[] args) {

		// Los 2 archivos a pasar.
		File archivo = new File("Peliculas_11_20.txt");
		File archivoDos = new File("Peliculas_01_10.txt");

		// Almaceno pel�culas, donde la clave es la recaudaci�n. Se ordena por la clave.
		TreeMap<Long, String> almacen = new TreeMap(Collections.reverseOrder());
		StringBuilder builder = new StringBuilder();

		// Llamo al m�todo para leer los archivos.
		extracted(archivo, almacen);
		extracted(archivoDos, almacen);

		// Para guardar en un StringBuilder las pel�culas de forma ordenada.
		for (Map.Entry<Long, String> peliculas : almacen.entrySet()) {
			builder.append(peliculas.getValue() + "                                            " + peliculas.getKey() + "\n");
		}

		// Muestro las pel�culas.
		System.out.println(builder.toString());

		// Escribo en el fichero de las pel�culas.
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
					+ "                        println \"Hola Mundo! EL d�a de hoy es \" + elDia + \" . Este curso me hizo programar mas de lo que me hubiese gustado.\"\r\n"
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
	 * M�todo para leer los archivos y guardar los datos en un TreeMap.
	 * 
	 * @param archivo Archivo a pasar
	 * @param almacen TreeMap para a�adir las claves y valores.
	 */
	private static void extracted(File archivo, TreeMap<Long, String> almacen) {
		try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {

			// Utilizo un readLine para leer l�neas completas.
			String leido = leer.readLine();

			// Utilizo un while para que se haga mientras que lo le�do no sea null.
			while (leido != null) {

				// Divido la l�nea anterior en atributos usando : como separador.
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