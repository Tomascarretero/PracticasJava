/**
 * 
 */
package onu;

import java.text.DecimalFormat;

/**
 * @author Tomás Carretero Reyes
 *
 */
public class Pais extends Continente implements PBI {
	
	private String nombrePais, capital, clima;
	private int habitantes;
	private int salarioMinimo;
	private double pib; //producto interno bruto o producto interior bruto.
	
	/**
	 * @param nombreContinente
	 * @param nombrePais
	 * @param capital
	 * @param clima
	 * @param habitantes
	 * @param salarioMinimo
	 */
	public Pais(String nombreContinente, String nombrePais, String capital, String clima, int habitantes,
			int salarioMinimo) {
		super(nombreContinente);
		this.nombrePais = nombrePais;
		this.capital = capital;
		this.clima = clima;
		this.habitantes = habitantes;
		this.salarioMinimo = salarioMinimo;
	}
	/**
	 * @return el nombrePais
	 */
	public String getNombrePais() {
		return nombrePais;
	}
	/**
	 * @param nombrePais el nombrePais a establecer
	 */
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
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
	 * @return el clima
	 */
	public String getClima() {
		return clima;
	}
	/**
	 * @param clima el clima a establecer
	 */
	public void setClima(String clima) {
		this.clima = clima;
	}
	/**
	 * @return el habitantes
	 */
	public int getHabitantes() {
		return habitantes;
	}
	/**
	 * @param habitantes el habitantes a establecer
	 */
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	/**
	 * @return el salarioMinimo
	 */
	public int getSalarioMinimo() {
		return salarioMinimo;
	}
	/**
	 * @param salarioMinimo el salarioMinimo a establecer
	 */
	public void setSalarioMinimo(int salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}
	/**
	 * @return el pib
	 */
	public double getPib() {
		return pib;
	}
	/**
	 * @param pib el pib a establecer
	 */
	public void setPib(double pib) {
		this.pib = pib;
	}
	
	DecimalFormat df = new DecimalFormat("#.00");
	
	@Override
	public String toString() {
		return "PAIS:" + nombrePais + "\nContinente: " +  this.getNombreContinente()+ "\nCapital: " + capital + "\nClima predominante: " + clima + "\nHabitantes: "
				+ habitantes + "\nSalario Mínimo: " + salarioMinimo + "\nPIB: " + df.format(this.calcularPIB());
	}
	
	/**
	 * Muestra el PIB.
	 * 
	 * Si el número es muy grande, los mostraría en notación científica, pero si el exponente.
	 * Ver --> https://es.wikipedia.org/wiki/Coma_flotante#Ejemplo
	 * 
	 */
	@Override
	public double calcularPIB() {
	
		return this.getHabitantes() * this.getSalarioMinimo();
	
	}
}