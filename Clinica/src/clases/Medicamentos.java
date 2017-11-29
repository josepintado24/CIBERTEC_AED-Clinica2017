package clases;

public class Medicamentos {

	private int CodMedicamento, stock;
	private String nombre, laboratorio;
	private double precio;

	public Medicamentos(int CodMedicamento, String nombre, String laboratorio, double precio, int stock) {
		this.CodMedicamento = CodMedicamento;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.precio = precio;
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodMedicamento() {
		return CodMedicamento;
	}

	public void setCodMedicamento(int codMedicamento) {
		this.CodMedicamento = codMedicamento;
	}
	
	public void restarStock(int stock) {
		this.stock = this.stock - stock;
	}

}
