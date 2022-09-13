/**
 * 
 */
package onu;

/**
 * @author Tomás Carretero Reyes
 *
 */
public class Continente {
	
	private String nombreContinente;

	/**
	 * @param nombreContinente
	 */
	public Continente(String nombreContinente) {
		this.nombreContinente = nombreContinente;
	}

	/**
	 * @return el nombreContinente
	 */
	public String getNombreContinente() {
		return nombreContinente;
	}

	/**
	 * @param nombreContinente el nombreContinente a establecer
	 */
	public void setNombreContinente(String nombreContinente) {
		this.nombreContinente = nombreContinente;
	}

	@Override
	public String toString() {
		return "Continente [nombreContinente=" + nombreContinente + "]";
	}
	
	

}
