package controlador;

import java.util.ArrayList;

import Clases.DetalleAtencion;

public class ArregloDetalleAtencion {


	private ArrayList<DetalleAtencion> det;
	private String archivo;

	public ArregloDetalleAtencion(String archivo) {
		det = new ArrayList<DetalleAtencion>();
		this.archivo = archivo;
		//cargarDetalleAtencion();
	}

	public void adicionar(DetalleAtencion d) {
		det.add(d);
	}

	public int tamaño() {
		return det.size();
	}

	public DetalleAtencion obtener(int i) {
		return det.get(i);
	}

	public void eliminar(DetalleAtencion d) {
		det.remove(d);
	}

	public DetalleAtencion buscar(int codigo) {
		DetalleAtencion c;
		for (int i = 0; i < tamaño(); i++) {
			c = obtener(i);
			if (c.getcodigo_atencion() == codigo)
				return c;
		}
		return null;
	}

	
	
	
}
