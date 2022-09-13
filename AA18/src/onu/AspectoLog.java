package onu;

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

	Usuario usuario = new Usuario("1", "Tomás Carretero Reyes", "tomascr1@yahoo.es");
	
	@Before("execution(* generaArchivo())")
	public void logGenerar() {
		Lambda mensaje_lambda = () -> usuario.toString();
		darMensaje(mensaje_lambda); //Uso lambda.
	}

	// La función que muestra mensaje.
	public static void darMensaje(Lambda men) {
		String mensaje = men.mensaje();
		System.out.println("Información de usuario que corrió el proceso de generación de archivos:\n" + mensaje);
	}

	@After("execution(* generaArchivo())")
	public void logGeneraDos() {
		System.out.println("\nSe generaron los archivos.");
	}

}// Fin class.