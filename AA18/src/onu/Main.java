/**
 * 
 */
package onu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tomás Carretero Reyes
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)){
			Servicio servicio = ctx.getBean(Servicio.class);
			servicio.cargarTXT();
			servicio.generaArchivo();
		}catch(Exception e) {
			System.err.println("Error en Main: " + e);
			e.printStackTrace();
		}
	}//Fin main.
}//Fin class.