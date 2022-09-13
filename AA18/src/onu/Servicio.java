package onu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Servicio {

	List<Pais> lista = null;

	public void cargarTXT() {
		File paises = new File("INFO_PAISES.txt");

		Pais paisNuevo;

		try (BufferedReader leer = new BufferedReader(new FileReader(paises))) {

			lista = new LinkedList<>();
			// Utilizo un readLine para leer líneas completas.
			String leido = leer.readLine();

			// Utilizo un while para que se haga mientras que lo leído no sea null. Para
			// cada País.
			while (leido != null) {

				String pais = "", continente = "", capital = "", clima = "";
				int habitantes = 0, salario = 0;

				// Divido la línea anterior en atributos usando : como separador.
				String[] atributo = leido.split(":");

				// "Cojo" los datos de cada país.
				if (atributo[0].equals("PAIS")) {
					pais = atributo[1];
					leido = leer.readLine();
					atributo = leido.split(":");

					do {

						if (atributo[0].equals("Continente")) {
							continente = atributo[1];
						}
						if (atributo[0].equals("Capital")) {
							capital = atributo[1];
						}
						if (atributo[0].equals("Habitantes")) {
							habitantes = Integer.valueOf(atributo[1]);
						}
						if (atributo[0].equals("Clima Predominante")) {
							clima = atributo[1];
						}
						if (atributo[0].equals("Salario Minimo")) {
							salario = Integer.valueOf(atributo[1]);
						}

						leido = leer.readLine();
						if (leido != null) {
							atributo = leido.split(":");
						}
					} while ((leido != null) && !(atributo[0].equals("PAIS")));

				}

				paisNuevo = new Pais(continente, pais, capital, clima, habitantes, salario);

				lista.add(paisNuevo);

				// System.out.println(lista.toString());

			} // Fin while.

		} catch (FileNotFoundException ex) {
			System.err.println("Error: " + ex);
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
		} // Fin try-with-resources.

	}// Fin cargarTXT.

	public void generaArchivo() {
		int i;
		StringBuilder info = null;
		// Recorro el List, y escribo el valor de cada país.
		for (i = 1; i <= lista.size();) {
			for (Pais c : lista) {
				info = new StringBuilder();
				info.append(c.toString());
				//1 archivo por cada país.
				extracted(info, c.getNombrePais());
				i++;
			}

		}

	}

	/**
	 * 
	 */
	private void extracted(StringBuilder info, String nombre) {
		// Escribo en el fichero.
		try (PrintWriter ficheroSalida = new PrintWriter("archivo_salida_" + nombre + ".txt")) {

			Usuario usuario = new Usuario("1", "Tomás Carretero Reyes", "tomascr1@yahoo.es");

			ficheroSalida.println(usuario.toString() + "\n");

			ficheroSalida.println(info);
			
			// Utilizo un flush para asegurarme que se vuelca en disco todo lo que hay en el
			// buffer.
			ficheroSalida.flush();

			// Muestro un mensaje como que el archivo se ha generado.
			if (ficheroSalida != null) {

				System.out.println();
				System.out.println("Archivo de texto de" + nombre + " generado");
			}

		} catch (FileNotFoundException ex) {
			System.err.println(ex);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} // Fin try-with-resources.
	}

}// Fin class.