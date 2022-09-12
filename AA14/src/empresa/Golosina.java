package empresa;

public class Golosina implements Produccion {
	
	private String nombre;
	private int cantidadProducida;
	
	public Golosina(String nombre, int cantidadProducida) {
		this.nombre = nombre;
		this.cantidadProducida = cantidadProducida;
	}

	public Golosina() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadProducida() {
		return cantidadProducida;
	}

	public void setCantidadProducida(int cantidadProducida) {
		this.cantidadProducida = cantidadProducida;
	}

	
	@Override
	public String toString() {
		return nombre + "                    "  +   cantidadProducida + "\n";
	}
	
	public String stringJenkins() {
		return nombre + "                    "  +   cantidadProducida;
		
	}

	@Override
	public boolean produccionActiva(int temperatura) {
		
		if(!(temperatura > 40)) {
			return true;
		}
		return false;
	}
}