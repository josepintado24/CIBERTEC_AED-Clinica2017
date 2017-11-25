package controlador;

import java.util.ArrayList;

import Clases.Atencion;

public class ArregloAtencion {


	// Atributo privado
	private ArrayList<Atencion> ate;
	private String archivo;

	// Constructor
	public ArregloAtencion(String archivo) {
		ate= new ArrayList<Atencion>();
		this.archivo = archivo;
		//cargarAtencion();
	}

	// Operaciones públicas
	public void adicionar(Atencion a) {
		ate.add(a);
	}

	public Atencion obtener(int pos) {
		return ate.get(pos);
	}

	public int tamaño() {
		return ate.size();
	}

	public void eliminar(Atencion x) {
		ate.remove(x);
	}

	public Atencion buscar(int codigo_atencion) {
		Atencion a;
		for (int i = 0; i < tamaño(); i++) {
			a = obtener(i);
			if (a.getcodigo_atencion() == codigo_atencion)
				return a;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 10001;
		else
			return obtener(tamaño() - 1).getcodigo_atencion() + 1;
	}
	
	
	
}
