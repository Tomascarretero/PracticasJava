package spotify;


import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Tomás Carretero Reyes.
 *
 */
@Aspect
@Component
public class AspectoLog {
	@Before("execution(* cargartxt())")
	public void logCargar() {
		System.out.println("Cargando TXT. Validando si es ese formato:");

		ArrayList<String> array = new ArrayList<String>();
		array.add("Artistas 2020.txt");
		array.add("Artistas 2021.txt");
		array.add("Canciones 2020.txt");
		array.add("Canciones 2021.txt");

		//Para comprobar si es txt.
		for (int i = 0; i < array.size(); i++) {
			String fe = "";
			int a = array.get(i).lastIndexOf('.');
			if (a > 0) {
				fe = array.get(i).substring(a + 1);
			}
			if (fe.equals("txt")) {
				System.out.println(array.get(i) + " Es un archivo txt.");
			}
		}
	}

	@Before("execution(* generarArchivo())")
	public void logGenerar() {
		System.out.println("\nSe va a generar un archivo nuevo.");

	}

	@After("execution(* generarArchivo())")
	public void logGenerar2() {
		System.out.println("Se generó el archivo.");
	}

}// Fin class.