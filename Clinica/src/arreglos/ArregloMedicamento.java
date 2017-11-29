package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Medicamentos;

public class ArregloMedicamento {

	private ArrayList<Medicamentos> med;
	private String archivo;

	public ArregloMedicamento(String archivo) {
		med = new ArrayList<Medicamentos>();
		this.archivo = archivo;
		cargarMedicamentos();
	}

	public void adicionar(Medicamentos m) {
		med.add(m);
	}

	public int tamaño() {
		return med.size();
	}

	public Medicamentos obtener(int i) {
		return med.get(i);
	}

	public void eliminar(Medicamentos m) {
		med.remove(m);
	}

	public Medicamentos buscar(int codigo) {
		Medicamentos m;
		for (int i = 0; i < tamaño(); i++) {
			m = obtener(i);
			if (m.getCodMedicamento() == codigo)
				return m;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		}
		else {
			return obtener(tamaño() - 1).getCodMedicamento() + 1;
		}
	}
	
	public String getArchivo() {
		return archivo;
	}

	public void eliminarAlFinal() {
		if (tamaño() > 0)
			med.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			med.clear();
	}

	public void grabarMedicamentos() {
		try {
			PrintWriter pw;
			String linea;
			Medicamentos x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodMedicamento() + ";" + x.getNombre() + ";" + x.getLaboratorio() + ";" 
				+ x.getPrecio() + ";" + x.getStock();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarMedicamentos() {
		try {
			BufferedReader br;
			String linea, s[], nombre, laboratorio;
			int codigo, stock;
			double precio;
			Medicamentos nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				laboratorio = s[2].trim();
				precio = Double.parseDouble(s[3].trim());
				stock = Integer.parseInt(s[4].trim());
				
				nuevo = new Medicamentos(codigo, nombre, laboratorio, precio, stock);
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
