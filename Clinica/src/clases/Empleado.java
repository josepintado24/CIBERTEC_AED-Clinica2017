package clases;

public class Empleado {

	private int codEmpleado;
	private String apellidos;
	private String nombres;
	private int tipoEmpleado;
	private String login;
	private String password;
	private int turno;

	public Empleado(int codEmpleado, String apellidos, String nombres, int tipoEmpleado, String login, String password, int turno) {
		this.codEmpleado = codEmpleado;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.tipoEmpleado = tipoEmpleado;
		this.login = login;
		this.password = password;
		this.turno = turno;
	}

	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
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

	public int getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

}
