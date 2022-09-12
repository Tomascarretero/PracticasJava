/**
 * 
 */
package estado;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Tomás Carretero Reyes.
 *
 */
public class Provincia implements Archivo {
	private String provincia, capital;
	
	/**
	 * @return el capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * @param capital el capital a establecer
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * 
	 * @param provincia
	 * @param capital
	 */
	public Provincia(String provincia, String capital) {
		super();
		this.provincia = provincia;
		this.capital = capital;
	}

	/**
	 * 
	 */
	public Provincia() {
		super();
	}

	/**
	 * 
	 * @param provincia
	 */
	public Provincia(String provincia) {
		super();
		this.provincia = provincia;
	}

	/**
	 * @return el provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia el provincia a establecer
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "[provincia=" + provincia + ", capital=" + capital + "]";
	}

	/**
	 *  Método para escribir archivos.
	 * @param info Información a pasar.
	 * @param archivo Archivo a pasar.
	 */
	@Override
	public void generarArchivo(String info, String archivo) {
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
}