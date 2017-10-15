package Clases;

public class Empleado {
	private int codigo,telefono,dni;
	private String Apellido_Paterno,Apellido_Materno,Nombres;

	
	public Empleado(int codigo,int telefono,int dni,String Apellido_Paterno,String Apellido_Materno,String Nombres){
		this.codigo=codigo;
		this.telefono=telefono;
		this.dni=dni;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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
