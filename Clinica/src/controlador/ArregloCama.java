package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Clases.Cama;

public class ArregloCama {
private ArrayList <Cama>ca;
private String archivo;

public ArregloCama(){
	ca=new ArrayList<Cama>();
	this.archivo=archivo;
}


public int tamano(){
	return ca.size();
}

public Cama obtener(int pos){
	return ca.get(pos);
}

public void adicionar(Cama c){
	ca.add(c);
}

public void eliminar(Cama x){
	ca.remove(x);
	}

public Cama buscar(int numero){
	Cama s;
	for(int i=0;i<tamano();i++){
		s=obtener(i);
		if(s.getnumero_Cama()==numero){
			return s;
		}
	}
	return null;
}


	
	
	




}
