package Clases;

public class Empleado {
	private int codigo;
	private String Apellido_Paterno,Apellido_Materno,Nombres,tipo_Empleado,turno;

	
	public Empleado(int codigo,String Nombres,String Apellido_Paterno,String Apellido_Materno,String tipo_Empleado,String turno){
		this.codigo=codigo;
		this.tipo_Empleado=tipo_Empleado;
		this.turno=turno;
		this.Apellido_Paterno=Apellido_Paterno;
		this.Apellido_Materno=Apellido_Materno;
		this.Nombres=Nombres;
				}
	
	public int getCodigo(){
		return codigo;
	}
	public void setCodigo(int codigo){
		 this.codigo=codigo;
	}


	public String getTipo_Empleado() {
		return tipo_Empleado;
	}

	public void setTipo_Empleado(String tipo_Empleado) {
		this.tipo_Empleado = tipo_Empleado;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getApellido_Paterno() {
		return Apellido_Paterno;
	}

	public void setApellido_Paterno(String apellido_Paterno) {
		Apellido_Paterno = apellido_Paterno;
	}

	public String getApellido_Materno() {
		return Apellido_Materno;
	}

	public void setApellido_Materno(String apellido_Materno) {
		Apellido_Materno = apellido_Materno;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	
	
}
