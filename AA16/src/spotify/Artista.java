/**
 * 
 */
package spotify;


/**
 * @author Tom�s Carretero Reyes.
 *
 */
public class Artista extends Persona implements Recaudar {
	private String canci�n;
	private int vecesEscuchado;
	private int recaudado;
	
	/**
	 * @param nombre
	 * @param canci�n
	 * @param vecesEscuchado
	 */
	public Artista(String nombre, String canci�n, int vecesEscuchado) {
		super(nombre);
		this.canci�n = canci�n;
		this.vecesEscuchado = vecesEscuchado;
	}
	
	/**
	 * @param nombre
	 * @param canci�n
	 * @param vecesEscuchado
	 * @param recaudado
	 */
	public Artista(String nombre, String canci�n, int vecesEscuchado, int recaudado) {
		super(nombre);
		this.canci�n = canci�n;
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
	 * @return el canci�n
	 */
	public String getCanci�n() {
		return canci�n;
	}
	/**
	 * @param canci�n el canci�n a establecer
	 */
	public void setCanci�n(String canci�n) {
		this.canci�n = canci�n;
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
		return this.getNombre() + ":" + canci�n + ":" + vecesEscuchado + ":" + this.recaudacion();
	}
}