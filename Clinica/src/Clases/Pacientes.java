package Clases;

public class Pacientes {
	
	private int codigo;
	private String telefono,dni;
	private String nombres,apellidos;
	public Pacientes(int codigo, String telefono, String dni, String nombres, String apellidos) {
		
		this.codigo = codigo;
		this.telefono = telefono;
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
		

}
