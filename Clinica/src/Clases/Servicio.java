package Clases;

public class Servicio {
private int Id_Servicio,Id_Paciente,fecha_Servicio,estado;
private double total_Pagar;

public Servicio(int Id_Servicio,int Id_Paciente,int fecha_Servicio,int estado,double total_Pagar){
	this.Id_Servicio=Id_Servicio;
	this.Id_Paciente=Id_Paciente;
	this.fecha_Servicio=fecha_Servicio;
	this.estado=estado;
	this.total_Pagar=total_Pagar;
	}

public int getId_Servicio(){
	return Id_Servicio;
}

public void setId_Servicio(int Id_Servicio){
	this.Id_Servicio=Id_Servicio;
}

public int getId_Paciente() {
	return Id_Paciente;
}

public void setId_Paciente(int id_Paciente) {
	Id_Paciente = id_Paciente;
}

public int getFecha_Servicio() {
	return fecha_Servicio;
}

public void setFecha_Servicio(int fecha_Servicio) {
	this.fecha_Servicio = fecha_Servicio;
}

public int getEstado() {
	return estado;
}

public void setEstado(int estado) {
	this.estado = estado;
}

public double getTotal_Pagar() {
	return total_Pagar;
}

public void setTotal_Pagar(double total_Pagar) {
	this.total_Pagar = total_Pagar;
}

}

