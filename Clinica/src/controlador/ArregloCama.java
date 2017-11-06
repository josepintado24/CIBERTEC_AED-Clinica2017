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

public ArregloCama(String archivo){
	ca=new ArrayList<Cama>();
	this.archivo=archivo;
	cargarCama();	
}


public int tamaño(){
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
	for(int i=0;i<tamaño();i++){
		s=obtener(i);
		if(s.getnumero_Cama()==numero){
			return s;
		}
	}
	return null;
}

public void grabarCama(){
	try{
		PrintWriter pw;
		String linea;
		Cama cama=null;
		pw=new PrintWriter(new FileWriter(archivo));
		for(int i=0;i<tamaño();i++){
			cama=ca.get(i);
			linea=cama.getnumero_Cama()+"-"+
			cama.getEstado()+"-"+
			cama.getPrecioDia()+"-";
			pw.print(linea);			
		}
		pw.close();
	}catch(Exception e){
		System.out.println("Error: "+e);
	}
	}
	
	public void cargarCama(){
		try{
			BufferedReader br;
			String linea;
			StringTokenizer st;
			
			int numero_cama;
			int estado;
			double precioDia;
			
			br=new BufferedReader(new FileReader(archivo));
			while((linea= br.readLine())!=null){
				st = new StringTokenizer(linea,"-");
				numero_cama = Integer.parseInt(st.nextToken());
				precioDia= Integer.parseInt(st.nextToken());
				estado = Integer.parseInt(st.nextToken());
				
				Cama f=new Cama(numero_cama, estado, precioDia);
				adicionar(f);
			}
			br.close();
		}catch(Exception e){
			System.out.print("Error: "+e);
		
	}
	


}

}
