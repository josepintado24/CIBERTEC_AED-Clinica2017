package clases;

public class Camas {

	private int nroCama, categoria, estado;
	private double precioxdia;

	public Camas(int nroCama, int categoria, double precioxdia, int estado) {
		this.nroCama = nroCama;
		this.categoria = categoria;
		this.estado = estado;
		this.precioxdia = precioxdia;

	}

	public int getNroCama() {
		return nroCama;
	}

	public void setNroCama (int nroCama) {
		this.nroCama = nroCama;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getPrecioxDia() {
		return precioxdia;
	}

	public void setPrecioxDia(double precioxdia) {
		this.precioxdia = precioxdia;
	}
}
