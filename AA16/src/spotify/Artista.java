/**
 * 
 */
package spotify;


/**
 * @author Tomás Carretero Reyes.
 *
 */
public class Artista extends Persona implements Recaudar {
	private String canción;
	private int vecesEscuchado;
	private int recaudado;
	
	/**
	 * @param nombre
	 * @param canción
	 * @param vecesEscuchado
	 */
	public Artista(String nombre, String canción, int vecesEscuchado) {
		super(nombre);
		this.canción = canción;
		this.vecesEscuchado = vecesEscuchado;
	}
	
	/**
	 * @param nombre
	 * @param canción
	 * @param vecesEscuchado
	 * @param recaudado
	 */
	public Artista(String nombre, String canción, int vecesEscuchado, int recaudado) {
		super(nombre);
		this.canción = canción;
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
	 * @return el canción
	 */
	public String getCanción() {
		return canción;
	}
	/**
	 * @param canción el canción a establecer
	 */
	public void setCanción(String canción) {
		this.canción = canción;
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
		return this.getNombre() + ":" + canción + ":" + vecesEscuchado + ":" + this.recaudacion();
	}
}