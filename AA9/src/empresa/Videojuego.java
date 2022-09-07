package empresa;

public class Videojuego implements Monto {

	private String titulo;
	private int cantidadUnidadesVendidas, montoTotal;

	public Videojuego(String titulo, int cantidadUnidadesVendidas, int montoTotal) {
		super();
		this.titulo = titulo;
		this.cantidadUnidadesVendidas = cantidadUnidadesVendidas;
		this.montoTotal = montoTotal;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantidadUnidadesVendidas() {
		return cantidadUnidadesVendidas;
	}

	public void setCantidadUnidadesVendidas(int cantidadUnidadesVendidas) {
		this.cantidadUnidadesVendidas = cantidadUnidadesVendidas;
	}

	public int getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}

	@Override
	public String toString() {
		return titulo + "     " + cantidadUnidadesVendidas + "                      " + this.montoTotal();
	}

	@Override
	public int montoTotal() {

		return this.cantidadUnidadesVendidas * this.montoTotal;
	}
}