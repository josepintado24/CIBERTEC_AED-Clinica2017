package Clases;

public class Atencion {
	
	private int codigo_atencion,codigo_paciente;
	private int fecha_atencion,estado;
	private double totalPagar;
	
	
	public Atencion(int codigo_atencion,int codigo_paciente,int fecha_atencion,int estado, double totalPagar){
	this.codigo_atencion=codigo_atencion;
	this.codigo_paciente=codigo_paciente;
	this.fecha_atencion=fecha_atencion;
	this.estado=estado;
	this.totalPagar=totalPagar;
	}
	
	public int getcodigo_atencion(){
		return codigo_atencion;
	}
	public void setcodigo_atencion(int codigo_atencion){
		this.codigo_atencion=codigo_atencion;
	}

	public int getCodigo_paciente() {
		return codigo_paciente;
	}

	public void setCodigo_paciente(int codigo_paciente) {
		this.codigo_paciente = codigo_paciente;
	}

	public int getFecha_atencion() {
		return fecha_atencion;
	}

	public void setFecha_atencion(int fecha_atencion) {
		this.fecha_atencion = fecha_atencion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
	
	
	
}