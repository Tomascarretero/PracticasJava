/**
 * 
 */
package onu;

/**
 * @author Tomás Carretero Reyes
 *
 */
public class Usuario {
	private String ID_USUARIO, nombre, email;

	/**
	 * @param iD_USUARIO
	 * @param nombre
	 * @param email
	 */
	public Usuario(String iD_USUARIO, String nombre, String email) {
		ID_USUARIO = iD_USUARIO;
		this.nombre = nombre;
		this.email = email;
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
	 * @return el email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email el email a establecer
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario que crea este reporte --> ID_USUARIO=" + ID_USUARIO + ", nombre=" + nombre + ", email=" + email;
	}

}
