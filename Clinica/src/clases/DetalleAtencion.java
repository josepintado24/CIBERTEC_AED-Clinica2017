package clases;

public class DetalleAtencion {

	private int codConsumo;
	private int codProducto;
	private int cantidad;
	private double precioUnitario;
	private double subtotal;

	public DetalleAtencion(int codConsumo, int codProducto, int cantidad, double precioUnitario, double subtotal) {
		this.codConsumo = codConsumo;
		this.codProducto = codProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}

	public int getCodConsumo() {
		return codConsumo;
	}

	public void setCodConsumo(int codConsumo) {
		this.codConsumo = codConsumo;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}
