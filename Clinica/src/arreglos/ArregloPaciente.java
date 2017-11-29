package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Paciente;

public class ArregloPaciente {

	private ArrayList<Paciente> pac;
	private String archivo;

	public ArregloPaciente(String archivo) {
		pac = new ArrayList<Paciente>();
		this.archivo = archivo;
		cargarPacientes();
	}

	public void adicionar(Paciente p) {
		pac.add(p);
	}

	public int tamaño() {
		return pac.size();
	}

	public Paciente obtener(int i) {
		return pac.get(i);
	}

	public void eliminar(Paciente p) {
		pac.remove(p);
	}

	public Paciente buscar(int codigo) {
		Paciente p;
		for (int i = 0; i < tamaño(); i++) {
			p = obtener(i);
			if (p.getCodpaciente() == codigo)
				return p;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 100001;
		}
		else {
			return obtener(tamaño() - 1).getCodpaciente() + 1;
		}
	}
	
	public String getArchivo() {
		return archivo;
	}

	public void eliminarAlFinal() {
		if (tamaño() > 0)
			pac.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			pac.clear();
	}

	public void grabarPacientes() {
		try {
			PrintWriter pw;
			String linea;
			Paciente x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodpaciente() + ";" + x.getApellidos() + ";" + x.getNombres() + ";" 
				+ x.getTelefono() + ";" + x.getDNI();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarPacientes() {
		try {
			BufferedReader br;
			String linea, s[], apellidos, nombres, telefono, dni;
			int codigo;
			Paciente nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				apellidos = s[1].trim();
				nombres = s[2].trim();
				telefono = s[3].trim();
				dni = s[4].trim();
				
				nuevo = new Paciente(codigo, apellidos, nombres, telefono, dni);
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
