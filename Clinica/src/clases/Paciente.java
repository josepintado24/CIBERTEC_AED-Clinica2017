package clases;

public class Paciente {

	private int codpaciente;
	private String apellidos, nombres, telefono, DNI;

	public Paciente (int codpaciente, String apellidos, String nombres, String telefono, String DNI) {
		this.codpaciente = codpaciente;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.telefono = telefono;
		this.DNI = DNI;
	}

	public int getCodpaciente() {
		return codpaciente;
	}

	public void setCodpaciente(int codpaciente) {
		this.codpaciente = codpaciente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombre) {
		this.nombres = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		this.DNI = dNI;
	}

}
