/**
 * 
 */
package estado;

import java.time.LocalDate;

/**
 * @author Tomás Carretero Reyes.
 *
 */
public class Usuario {
	
	private String ID_USUARIO, nombre;
	private LocalDate fecha;
	
	/**
	 * @param iD_USUARIO
	 * @param nombre
	 * @param fecha
	 */
	public Usuario(String iD_USUARIO, String nombre, LocalDate fecha) {
		super();
		ID_USUARIO = iD_USUARIO;
		this.nombre = nombre;
		this.fecha = fecha;
	}
	/**
	 * @return el iD_USUARIO
	 */
	public String getID_USUARIO() {
		return ID_USUARIO;
	}
	/**
	 * @param iD_USUARIO el iD_USUARIO a establecer
	 */
	public void setID_USUARIO(String iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
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
	/**
	 * @return el fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	/**
	 * @param fecha el fecha a establecer
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "ID_USUARIO=" + ID_USUARIO + ", Nombre del usuario=" + nombre + ", fecha=" + fecha;
	}
}