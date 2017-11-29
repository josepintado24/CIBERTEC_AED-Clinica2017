package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Empleado;

public class ArregloEmpleado {

	private ArrayList<Empleado> emp;
	private String archivo;

	public ArregloEmpleado(String archivo) {
		emp = new ArrayList<Empleado>();
		this.archivo = archivo;
		cargarEmpleados();
	}

	public void adicionar(Empleado e) {
		emp.add(e);
	}

	public int tamaño() {
		return emp.size();
	}

	public Empleado obtener(int i) {
		return emp.get(i);
	}

	public void eliminar(Empleado e) {
		emp.remove(e);
	}

	public Empleado buscar(int codigo) {
		Empleado e;
		for (int i = 0; i < tamaño(); i++) {
			e = obtener(i);
			if (e.getCodEmpleado() == codigo)
				return e;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 1001;
		}
		else {
			return obtener(tamaño() - 1).getCodEmpleado() + 1;
		}
	}

	public String getArchivo() {
		return archivo;
	}

	public void eliminarAlFinal() {
		if (tamaño() > 0)
			emp.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			emp.clear();
	}

	public void grabarEmpleados() {
		try {
			PrintWriter pw;
			String linea;
			Empleado x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodEmpleado() + ";" + x.getApellidos() + ";" + x.getNombres() + ";" + 
				x.getTipoEmpleado() + ";" + x.getLogin() + ";" + x.getPassword() + ";" + x.getTurno();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarEmpleados() {
		try {
			BufferedReader br;
			String linea, s[], apellidos, nombres, login, password;
			int codigo, tipoEmpleado, turno;
			Empleado nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				apellidos = s[1].trim();
				nombres = s[2].trim();
				tipoEmpleado = Integer.parseInt(s[3].trim());
				login = s[4].trim();
				password = s[5].trim();
				turno = Integer.parseInt(s[6].trim());

				nuevo = new Empleado(codigo, apellidos, nombres, tipoEmpleado, login, password, turno);
				adicionar(nuevo);
			}
			br.close();
		}
		catch (Exception e) {
		}
	}

	public boolean existeArchivo() {
		File f = new File(archivo);
		return f.exists();
	}
}
