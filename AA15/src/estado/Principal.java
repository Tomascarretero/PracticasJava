/**
 * 
 */
package estado;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Tomás Carretero Reyes.
 *
 */
public class Principal {

	private Usuario usuario;

	/**
	 * Constructor
	 * @param usuario
	 */
	public Principal(Usuario usuario) {
		this.usuario = usuario;
		
	}
	
	/**
	 * @return el usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario el usuario a establecer
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Imprime información.
	 */
	@Override
	public String toString() {
		return "[Usuario=" + usuario + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final String ARCHIVO_SALIDA = "salida_" + LocalDate.now() + ".txt";
		final String ARCHIVO_JENKINS = "JenkinsCuatro.txt";
		
		Scanner sc = null;
		String json = "";

		try {
			URL url = new URL(
					"https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=provincia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Declaro la conexión
			conn.connect(); // Abro la conexión.
			int tiempoRespuesta = conn.getResponseCode();
			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse " + tiempoRespuesta);
			} else {
				sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					json = json + sc.nextLine();

				}
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		} finally {
			sc.close();
		}

		List<Provincia> listaProvincia = null;
		try {
			//Recupero provincia y capital.
			JSONObject objetoJSON = new JSONObject(json);
			JSONArray arrayJSON = (JSONArray) objetoJSON.get("facet_groups");
			objetoJSON = (JSONObject) arrayJSON.get(0);
			arrayJSON = (JSONArray) objetoJSON.get("facets");

			listaProvincia = new ArrayList<>();
			for (Object iteracion : arrayJSON) {
				listaProvincia.add(new CapitalProvincia(((JSONObject) iteracion).getString("name"),
						((JSONObject) iteracion).getString("path")));
			}
		} catch (JSONException ex) {
			System.err.println("Error JSONException: " + ex);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}

		Usuario usuarioUno = new Usuario ("1", "Carretero Reyes, Tomás", LocalDate.now());
		Principal main = new Principal(usuarioUno);
		System.out.println("Fecha que corre el proceso: " + LocalDate.now() + "\n" +"Usuario que lo implementa: " + main.toString());
		
		System.out.println("Estas son las provincias: " + listaProvincia.toString());
		
		Provincia provincia = new Provincia();
		provincia.generarArchivo("Fecha que corre el proceso: " + LocalDate.now() + "\n" + main.toString() + "\n" + listaProvincia.toString(), ARCHIVO_SALIDA);
		
		String Jenkins = "pipeline {\r\n"
				+ "    agent any\r\n"
				+ "\r\n"
				+ "    stages {\r\n"
				+ "        stage('info') {\r\n"
				+ "            steps {\r\n"
				+ "                script{\r\n"
				+ "println \" " +  LocalDate.now()+ "  "+ main.toString() + "  "+ listaProvincia.toString()  +    "\" "    
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        }  \r\n"
				+ "    }\r\n"
				+ "}";
		
		provincia.generarArchivo(Jenkins, ARCHIVO_JENKINS);

	}// Fin main.
}