/**
 * 
 */
package spotify;

/**
 * @author Tomás Carretero Reyes.
 *
 */
public class Persona {
	private String nombre;

	/**
	 * @param nombre
	 */
	public Persona(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}