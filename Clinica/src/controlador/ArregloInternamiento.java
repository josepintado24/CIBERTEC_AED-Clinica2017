package controlador;

import java.util.ArrayList;

import Clases.Cama;
import Clases.Internamiento;

public class ArregloInternamiento {

	private ArrayList<Internamiento>Int;
	private String archivo;
	
	public ArregloInternamiento() {
		
		Int=new ArrayList<Internamiento>();
		this.archivo = archivo;
	}
	
	public int tamaño(){
		return Int.size();
	}
	
	public Internamiento obtener(int pos){
		return Int.get(pos);
	}

	public void adicionar(Internamiento c){
		Int.add(c);
	}

	public void eliminar(Internamiento x){
		Int.remove(x);
		}

	public Internamiento buscar(int Id_Internamiento){
		Internamiento s;
		for(int i=0;i<tamaño();i++){
			s=obtener(i);
			if(s.getId_Internamiento()==Id_Internamiento){
				return s;
			}
		}
		return null;
	}
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 1001;
		else
			return obtener(tamaño() - 1).getId_Internamiento() + 1;
	}


	

	
	
}
