package arreglos;

import java.io.*;
import java.util.ArrayList;

import clases.Camas;

public class ArregloCamas {

	private ArrayList<Camas> cam;
	private String archivo;

	public ArregloCamas(String archivo) {
		cam = new ArrayList<Camas>();
		this.archivo = archivo;
		cargarCamas();
	}

	public void adicionar(Camas c) {
		cam.add(c);
	}

	public int tamaño() {
		return cam.size();
	}

	public Camas obtener(int i) {
		return cam.get(i);
	}

	public void eliminar(Camas c) {
		cam.remove(c);
	}

	public Camas buscar(int codigo) {
		Camas c;
		for (int i = 0; i < tamaño(); i++) {
			c = obtener(i);
			if (c.getNroCama() == codigo)
				return c;
		}
		return null;
	}

	public String getArchivo() {
		return archivo;
	}

	public void eliminarAlFinal() {
		if (tamaño() > 0)
			cam.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			cam.clear();
	}

	public void grabarCamas() {
		try {
			PrintWriter pw;
			String linea;
			Camas x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getNroCama() + ";" + x.getCategoria() + ";" + x.getPrecioxDia() + ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarCamas() {
		try {
			BufferedReader br;
			String linea, s[];
			int nroCama, estado, categoria;
			double precioxdia;
			Camas nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				nroCama = Integer.parseInt(s[0].trim());
				categoria = Integer.parseInt(s[1].trim());
				precioxdia = Double.parseDouble(s[2].trim());
				estado = Integer.parseInt(s[3].trim());

				nuevo = new Camas(nroCama, categoria, precioxdia, estado);
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
