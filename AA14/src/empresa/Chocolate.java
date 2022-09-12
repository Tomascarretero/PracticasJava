package empresa;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class Chocolate extends Golosina {

	private static final String ARCHIVO_SALIDA = "salida_" + LocalDate.now() + ".txt";
	private static final String ARCHIVO_JENKINS = "JenkinsTres.txt";

	public static void main(String[] args) {
		
		Chocolate chocolate = new Chocolate();

		StringBuilder informacionString = null;
		Scanner sc = null;
		try {
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/41/municipios/41091");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Declaro la conexión
			conn.connect(); // Abro la conexión.
			int tiempoRespuesta = conn.getResponseCode();
			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse " + tiempoRespuesta);
			} else {
				informacionString = new StringBuilder();
				sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					informacionString.append(sc.nextLine());
				}
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		} finally {
			sc.close();
		}

		// Creo objeto JSON.
		JSONObject job = null;
		int grados = 0;
		try {
			job = new JSONObject(informacionString.toString());
			String temperatura = job.getString("temperatura_actual");
			grados = Integer.valueOf(temperatura);
		} catch (JSONException ex) {
			System.err.println("Error JSONException: " + ex);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}

		if (chocolate.produccionActiva(grados)) {
			System.out.println("Se puede producir chocolate. Hoy hace menos o igual que 40 grados. Hoy hace " + grados
					+ " grados.\n");
			Golosina uno = new Golosina("Chocolate Blanco", 1000);
			Golosina dos = new Golosina("Chocolate Negro", 1500);
			Golosina tres = new Golosina("Chocolate con almendras", 1200);
			Golosina cuatro = new Golosina("Chocolate con castañas de caju", 1300);
			Golosina cinco = new Golosina("Chocolate en rama", 100);
			Golosina seis = new Golosina("Chocolate con 70% de cacao", 1500);

			String infoChocolate = "Nombre                                   CANTIDAD PRODUCIDA \n" + uno.toString()
					+ dos.toString() + tres.toString() + cuatro.toString() + cinco.toString() + seis.toString();

			String infoChocolateDos = "Nombre                                   CANTIDAD PRODUCIDA" + uno.stringJenkins()
			+ dos.stringJenkins() + tres.stringJenkins() + cuatro.stringJenkins() + cinco.stringJenkins() + seis.stringJenkins();
			
			System.out.println(infoChocolate);

			String Jenkins = "pipeline {\r\n"
					+ "    agent any\r\n"
					+ "\r\n"
					+ "    stages {\r\n"
					+ "        stage('info') {\r\n"
					+ "            steps {\r\n"
					+ "                script{\r\n"
					+ "println \" " +  infoChocolateDos  +    "\" "    
					+ "                }\r\n"
					+ "            }\r\n"
					+ "        }  \r\n"
					+ "    }\r\n"
					+ "}";
			
			extracted(infoChocolate, ARCHIVO_SALIDA);
			extracted(Jenkins, ARCHIVO_JENKINS);

		} else {
			System.out.println(
					"No se puede producir chocolate. Hoy hace más de 40 grados. Hoy hace " + grados + " grados.");
		}
	}// Fin main.

	/**
	 *  Método para escribir archivos.
	 * @param info Información a pasar.
	 * @param archivo Archivo a pasar.
	 */
	private static void extracted(String info, String archivo) {
		// Escribo en el fichero.
		try (PrintWriter ficheroSalida = new PrintWriter(archivo)) {

			ficheroSalida.println(info);

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