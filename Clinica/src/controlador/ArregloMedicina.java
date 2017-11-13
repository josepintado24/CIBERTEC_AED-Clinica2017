package controlador;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Medicina;
import Clases.Pacientes;

public class ArregloMedicina {
private ArrayList<Medicina>med;
private String archivo;

public ArregloMedicina(String archivo){
	med= new ArrayList<Medicina>();
	this.archivo=archivo;
	//cargarMedicina();
}


public int tamaño(){
	return med.size();
}


public Medicina obtener(int pos){
	return med.get(pos);
}

public void adicionar(Medicina m){
	med.add(m);
}

public void eliminar(Medicina x){
	med.remove(x);
}

public Medicina buscar(int codigo){
	Medicina c;
	for(int i=0;i<tamaño();i++){
		c=obtener(i);
		if(c.getcodigo_Medicina()==codigo){
			return c;
		}
			}
	return null;
	}	

public int codigoCorrelativo() {
	if (tamaño() == 0)
		return 10001;
	else
		return obtener(tamaño()-1).getcodigo_Medicina()+1;		
}


public void  grabarMedicina(){
	try{
		PrintWriter pw; 
		String linea;
		Medicina me = null; 
		pw = new PrintWriter(new FileWriter(archivo));
		for(int i=0;i<tamaño();i++){
			me= med.get(i);
			linea=me.getcodigo_Medicina()+"-"+
			me.getNombres()+"-"+
			me.getPrecio()+"-"+
			me.getStock()+"-"+
			me.getLaboratorio()+"-";
		pw.println(linea);
		}
		pw.close();
		}catch(Exception e){
			System.out.println("Error" +e);
		}
}







}
