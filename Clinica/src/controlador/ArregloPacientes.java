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

public  ArregloPacientes(String archivo){
	
	pa= new ArrayList<Pacientes>();
	this.archivo=archivo;
	cargarPacientes();
}

public int tamaño(){
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
	for(int i=0;i<tamaño();i++){
		c=obtener(i);
		if(c.getCodigo()==codigo){
			return c;
		}
			}
	return null;
	}	
public int codigoCorrelativo() {
	if (tamaño() == 0)
		return 1001;
	else
		return obtener(tamaño()-1).getCodigo()+1;		
}

public void  grabarPaciente(){
	try{
		PrintWriter pw; 
		String linea;
		Pacientes pc = null; 
		pw = new PrintWriter(new FileWriter(archivo));
		for(int i=0;i<tamaño();i++){
			pc= pa.get(i);
			linea=pc.getCodigo()+"-"+
			pc.getNombres()+"-"+
			pc.getApellido_paterno()+"-"+
			pc.getApellido_materno()+"-"+
			pc.getTelefono()+"-"+
			pc.getDni()+"-";
			pw.println(linea);
		}
		pw.close();
		}catch(Exception e){
			System.out.println("Error" +e);
		}
}

	
public void cargarPacientes(){
	try {
	BufferedReader br; 
	String linea; 
	StringTokenizer st;
	int codigo;
	String nombres;
	String apellido_paterno;
	String apellido_materno;
	String telefono;
	String dni;	
	br=new BufferedReader(new FileReader(archivo));
	while ((linea = br.readLine()) != null) {
		st = new StringTokenizer(linea,"-");
		codigo = Integer.parseInt(st.nextToken());
		nombres = st.nextToken();
		apellido_paterno = st.nextToken();
		apellido_materno = st.nextToken();
		telefono=st.nextToken();
		dni=st.nextToken();
		Pacientes s=new Pacientes(codigo, nombres, apellido_paterno, apellido_materno, telefono, dni );
		adicionar(s);
		} 
	br.close();
	}catch (Exception e){
		System.out.println("Error "+e);
		}
	}
	


}
