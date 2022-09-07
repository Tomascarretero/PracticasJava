package clima;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Tomás Carretero Reyes
 *
 */
public class Principal {

	public static void main(String[] args) {

		String cadena, cad;
		Scanner teclado = null;
		try {
			teclado = new Scanner(System.in);
			System.out.println("Inserte su nombre: ");
			cadena = teclado.nextLine();
			cad = cadena.trim();
			
			//Controlo que el nombre no esté vacío. 
			while (cad.isEmpty()) {
				System.out.println("Inserte su nombre (No has introducido nada): ");
				cadena = teclado.nextLine();
				cad = cadena.trim();
			}
			
			System.out.println("Bienvenido " + cad + ". Vamos a mostrar el clima actual de Moguer (Huelva)." + "\n");

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}finally {
		    teclado.close();
		}
		
		StringBuilder informacionString = null;
		Scanner sc = null;
		try {
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/21/municipios/21050");
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
		}finally {
			sc.close();
		}

		// Creo objeto JSON.
		JSONObject job = null;
		try {
			job = new JSONObject(informacionString.toString());
			System.out.println(job.toString(2));// Muestro en formato JSON.
		} catch (JSONException e) {
			System.err.println("Error JSONException: " + e);
		}
	}// main.
}