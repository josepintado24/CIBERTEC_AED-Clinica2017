package Clases;

public class Pacientes {
	
	private int codigo;
	private String telefono,dni;
	private String nombres,apellido_paterno,apellido_materno;
	
	
	public Pacientes(int codigo,String telefono,String dni,String nombres,String apellido_paterno,String apellido_materno){
		this.codigo=codigo;
		this.telefono=telefono;
		this.dni=dni;
		this.nombres=nombres;
		this.apellido_paterno=apellido_paterno;
		this.apellido_materno=apellido_materno;
		
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	
	

}
