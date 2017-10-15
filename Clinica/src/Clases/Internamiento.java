package Clases;

public class Internamiento {
private int Id_Internamiento,Id_Paciente,Id_Empleado;
private int idNumero_Cama,fecha_ingreso,fecha_salida;
private int hora_ingreso,hora_salida,estado;

public Internamiento(int Id_Internamiento,int Id_Paciente,int Id_Empleado,int idNumero_Cama,int fecha_ingreso,
		int fecha_salida,int hora_ingreso,int hora_salida,int estado){
	
	this.Id_Internamiento=Id_Internamiento;
	this.Id_Paciente=Id_Paciente;
	this.Id_Empleado=Id_Empleado;
	this.idNumero_Cama=idNumero_Cama;
	this.fecha_ingreso=fecha_ingreso;
	this.fecha_salida=fecha_salida;
	this.hora_ingreso=hora_ingreso;
	this.hora_salida=hora_salida;
	this.estado=estado;
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

public int getId_Empleado() {
	return Id_Empleado;
}

public void setId_Empleado(int id_Empleado) {
	Id_Empleado = id_Empleado;
}

public int getIdNumero_Cama() {
	return idNumero_Cama;
}

public void setIdNumero_Cama(int idNumero_Cama) {
	this.idNumero_Cama = idNumero_Cama;
}

public int getFecha_ingreso() {
	return fecha_ingreso;
}

public void setFecha_ingreso(int fecha_ingreso) {
	this.fecha_ingreso = fecha_ingreso;
}

public int getFecha_salida() {
	return fecha_salida;
}

public void setFecha_salida(int fecha_salida) {
	this.fecha_salida = fecha_salida;
}

public int getHora_ingreso() {
	return hora_ingreso;
}

public void setHora_ingreso(int hora_ingreso) {
	this.hora_ingreso = hora_ingreso;
}

public int getHora_salida() {
	return hora_salida;
}

public void setHora_salida(int hora_salida) {
	this.hora_salida = hora_salida;
}

public int getEstado() {
	return estado;
}

public void setEstado(int estado) {
	this.estado = estado;
}



}
