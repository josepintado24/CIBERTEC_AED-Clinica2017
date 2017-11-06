package Clases;

public class Internamiento {
private int Id_Internamiento,Id_Paciente;
private int idNumero_Cama,estado;
private String fecha_ingreso,fecha_salida,hora_ingreso,hora_salida;

public Internamiento(int Id_Internamiento,int Id_Paciente,int Id_Empleado,int idNumero_Cama,int estado,String fecha_ingreso
		,String fecha_salida,String hora_ingreso,String hora_salida){
	
	this.Id_Internamiento=Id_Internamiento;
	this.Id_Paciente=Id_Paciente;
	this.idNumero_Cama=idNumero_Cama;
	this.estado=estado;
	this.fecha_ingreso=fecha_ingreso;
	this.fecha_salida=fecha_salida;
	this.hora_ingreso=hora_ingreso;
	this.hora_salida=hora_salida;
	
}

public int getId_Internamiento(){
	return Id_Internamiento;
}

public void setId_Internamiento(int Id_Internamiento){
	this.Id_Internamiento=Id_Internamiento;
}

public int getId_Paciente() {
	return Id_Paciente;
}

public void setId_Paciente(int id_Paciente) {
	Id_Paciente = id_Paciente;
}


public int getIdNumero_Cama() {
	return idNumero_Cama;
}

public void setIdNumero_Cama(int idNumero_Cama) {
	this.idNumero_Cama = idNumero_Cama;
}

public int getEstado() {
	return estado;
}

public void setEstado(int estado) {
	this.estado = estado;
}


public String getFecha_ingreso() {
	return fecha_ingreso;
}

public void setFecha_ingreso(String fecha_ingreso) {
	this.fecha_ingreso = fecha_ingreso;
}

public String getFecha_salida() {
	return fecha_salida;
}

public void setFecha_salida(String fecha_salida) {
	this.fecha_salida = fecha_salida;
}

public String getHora_ingreso() {
	return hora_ingreso;
}

public void setHora_ingreso(String hora_ingreso) {
	this.hora_ingreso = hora_ingreso;
}

public String getHora_salida() {
	return hora_salida;
}

public void setHora_salida(String hora_salida) {
	this.hora_salida = hora_salida;
}




}
