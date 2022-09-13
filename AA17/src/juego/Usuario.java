/**
 * 
 */
package juego;

/**
 * @author Tomás Carretero Reyes
 *
 */
public class Usuario {
	
	private String nombre;

	/**
	 * @param nombre
	 */
	public Usuario(String nombre) {
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

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + "]";
	}
}