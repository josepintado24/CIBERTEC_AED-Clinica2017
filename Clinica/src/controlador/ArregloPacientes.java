package controlador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Clases.Pacientes;
public class ArregloPacientes {
private ArrayList<Pacientes>pa;
private String archivo;

public  ArregloPacientes(){
	
	pa= new ArrayList<Pacientes>();
}

public int tamano(){
	return pa.size();
}
public Pacientes obtener(int pos){
	return pa.get(pos);
}

public void adicionar(Pacientes p){
	pa.add(p);
}

public void eliminar(Pacientes x){
	pa.remove(x);
}

public Pacientes buscar(int codigo){
	Pacientes c;
	for(int i=0;i<tamano();i++){
		c=obtener(i);
		if(c.getCodigo()==codigo){
			return c;
		}
			}
	return null;
	}	
public int codigoCorrelativo() {
	if (tamano() == 0)
		return 1001;
	else
		return obtener(tamano()-1).getCodigo()+1;		
}


}
