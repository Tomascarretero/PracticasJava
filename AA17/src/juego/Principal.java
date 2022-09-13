package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Tomás Carretero Reyes
 *
 */
public class Principal {

	public static void main(String[] args) {

		String cadena, cad = "";
		Scanner teclado = null;

		Matcher linea;
		int numeroVeces = 0;

		String cadenaNombre, cadNombre;
		try {
			teclado = new Scanner(System.in);
			System.out.println("Inserte su nombre: ");
			cadenaNombre = teclado.nextLine();
			cadNombre = cadenaNombre.trim();

			//Nuevo Usuario.
			Usuario usuario = new Usuario(cadNombre);

			// Controlo que el nombre no esté vacío.
			while (cadNombre.isEmpty()) {
				System.out.println("Inserte su nombre (No has introducido nada): ");
				cadenaNombre = teclado.nextLine();
				cadNombre = cadenaNombre.trim();
				usuario = new Usuario(cadNombre);
			}

			System.out.println("Bienvenido " + usuario.getNombre() + "\n");

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}//Fin try-catch.

		//Genero número aleatorio y lo muestro, para poder comprobar cuál es el número y que funcione el programa.
		int numero = generaNumero();

		do {
			try {
				teclado = new Scanner(System.in);

				System.out.println("Inserte un número entre 1 y 1000000. Tienes 5 intentos:");
				cadena = teclado.nextLine();
				cad = cadena.trim();// Limpio

				// Formato correcto
				Pattern formato = Pattern.compile("[0-9]{1,7}");
				linea = formato.matcher(cad);// Si la línea es válida.

				//Si es válido.
				if (linea.matches()) {

					while (Integer.valueOf(cad) < 1 || Integer.valueOf(cad) > 1000000) {
						System.err.println("No es un número entre 1 y 1000000. Tienes 5 intentos:");
						cadena = teclado.nextLine();
						cad = cadena.trim();// Limpio
						linea = formato.matcher(cad);// Si la línea es válida.
						if (linea.matches()) {

						} else {
							System.err.println("No coincide el formato.");
							cad = "0";
						}

					}

					numeroVeces++;
					System.out.println();
				} else {
					System.err.println("No coincide el formato.");
					cad = "0";
				}
			} catch (Exception e) {
				System.err.println("Error " + e);
				cad = "0";
			}

		} while (Integer.valueOf(cad) != numero && numeroVeces < 5);

		//Cierro Scanner.
		teclado.close();

		if (Integer.valueOf(cad) == numero) {
			//Función lambda.
			Lambda mensaje_lambda = () -> "Adivinaste campeón";
			darMensaje(mensaje_lambda);
		} else {
			System.out.println("Perdiste el juego");
		}

	}// Fin main.

	//La función que muestra mensaje.
	public static void darMensaje(Lambda men) {
		String mensaje = men.mensaje();
		System.out.println(mensaje);
	}

	/**
	 * 
	 * @return Número aleatorio.
	 */
	public static int generaNumero() {

		int max = 1000000;
		int min = 1;
		int range = max - min + 1;
		int rand = 0;

		rand = (int) (Math.random() * range) + 1;

		System.out.println("Número aleatorio: " + rand + "\n");
		return rand;
	}
}//Fin class.