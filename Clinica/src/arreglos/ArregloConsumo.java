package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Atencion;

public class ArregloConsumo {

	private ArrayList<Atencion> con;
	private String archivo;

	public ArregloConsumo(String archivo) {
		con = new ArrayList<Atencion>();
		this.archivo = archivo;
		cargarConsumo();
	}

	public void adicionar(Atencion c) {
		con.add(c);
	}

	public int tamaño() {
		return con.size();
	}

	public Atencion obtener(int i) {
		return con.get(i);
	}

	public void eliminar(Atencion c) {
		con.remove(c);
	}

	public Atencion buscar(int codigo) {
		Atencion c;
		for (int i = 0; i < tamaño(); i++) {
			c = obtener(i);
			if (c.getCodConsumo() == codigo)
				return c;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10000001;
		}
		else {
			return obtener(tamaño() - 1).getCodConsumo() + 1;
		}
	}

	public String getArchivo() {
		return archivo;
	}

	public void eliminarAlFinal() {
		if (tamaño() > 0)
			con.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			con.clear();
	}

	public void grabarConsumo() {
		try {
			PrintWriter pw;
			String linea;
			Atencion x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodConsumo() + ";" + x.getCodPaciente() + ";" + x.getFechaConsumo() + ";" + x.getEstado()
						+ ";" + x.getTotalPago();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarConsumo() {
		try {
			BufferedReader br;
			String linea, s[];
			int codConsumo, codPaciente, fechaConsumo, estado;
			double totalPago;
			Atencion nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codConsumo = Integer.parseInt(s[0].trim());
				codPaciente = Integer.parseInt(s[1].trim());
				fechaConsumo = Integer.parseInt(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				totalPago = Double.parseDouble(s[4].trim());

				nuevo = new Atencion(codConsumo, codPaciente, fechaConsumo, estado, totalPago);
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
