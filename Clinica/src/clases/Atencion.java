package clases;



public class Atencion {
	private int codConsumo, codPaciente, fechaConsumo, estado;
	private double totalPago;

	public Atencion(int codConsumo, int codPaciente, int fechaConsumo, int estado, double totalPago) {
		this.codConsumo = codConsumo;
		this.codPaciente = codPaciente;
		this.fechaConsumo = fechaConsumo;
		this.estado = estado;
		this.totalPago = totalPago;
	}

	public int getCodConsumo() {
		return codConsumo;
	}

	public void setCodConsumo(int codConsumo) {
		this.codConsumo = codConsumo;
	}

	public int getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}

	public int getFechaConsumo() {
		return fechaConsumo;
	}

	public void setFechaConsumo(int fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}
}
