/**
 * 
 */
package spotify;


/**
 * @author Tomás Carretero Reyes.
 *
 */
public class Artista extends Persona implements Recaudar {
	private String cancion;
	private int vecesEscuchado;
	private int recaudado;
	
	/**
	 * @param nombre
	 * @param cancion
	 * @param vecesEscuchado
	 */
	public Artista(String nombre, String cancion, int vecesEscuchado) {
		super(nombre);
		this.cancion = cancion;
		this.vecesEscuchado = vecesEscuchado;
	}
	
	/**
	 * @param nombre
	 * @param cancion
	 * @param vecesEscuchado
	 * @param recaudado
	 */
	public Artista(String nombre, String cancion, int vecesEscuchado, int recaudado) {
		super(nombre);
		this.cancion = cancion;
		this.vecesEscuchado = vecesEscuchado;
		this.recaudado = recaudado;
	}

	/**
	 * @return el recaudado
	 */
	public int getRecaudado() {
		return recaudado;
	}

	/**
	 * @param recaudado el recaudado a establecer
	 */
	public void setRecaudado(int recaudado) {
		this.recaudado = recaudado;
	}

	/**
	 * @return el cancion
	 */
	public String getCancion() {
		return cancion;
	}
	/**
	 * @param canción el cancion a establecer
	 */
	public void setCanción(String cancion) {
		this.cancion = cancion;
	}
	/**
	 * @return el vecesEscuchado
	 */
	public int getVecesEscuchado() {
		return vecesEscuchado;
	}
	/**
	 * @param vecesEscuchado el vecesEscuchado a establecer
	 */
	public void setVecesEscuchado(int vecesEscuchado) {
		this.vecesEscuchado = vecesEscuchado;
	}
	
	@Override
	public int recaudacion() {
		return this.vecesEscuchado * 2;

	}

	@Override
	public String toString() {
		return this.getNombre() + ":" + cancion + ":" + vecesEscuchado + ":" + this.recaudacion();
	}
}