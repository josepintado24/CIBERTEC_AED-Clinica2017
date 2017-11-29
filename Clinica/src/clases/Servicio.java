package clases;

public class Servicio {
	// Atributos Privados
	private int CodServicio, Tipo;
	private String Descripcion;
	private double Precio;

	// Constructor
	public Servicio(int CodServicio, String Descripcion, int Tipo, double Precio) {

		this.CodServicio = CodServicio;
		this.Descripcion = Descripcion;
		this.Tipo = Tipo;
		this.Precio = Precio;

	}

	// Métodos de acceso público: set/get
	public int getCodServicio() {
		return CodServicio;
	}

	public void setCodServicio(int codServicio) {
		this.CodServicio = codServicio;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		this.Tipo = tipo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		this.Precio = precio;
	}

}
