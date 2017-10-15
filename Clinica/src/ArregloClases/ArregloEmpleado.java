package ArregloClases;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import Clases.Empleado;

public class ArregloEmpleado {
	private ArrayList<Empleado> emp;
	private String archivo;
	
	public ArregloEmpleado(String archivo){
		emp=new ArrayList<Empleado>();
		this.archivo=archivo;
		cargarEmpleado();
		
	}
	
	public int tamano(){
		return emp.size();
	}
	
	public  Empleado Obtener(int pos){
		return emp.get(pos);
	}
	public void adicionar(Empleado p){
		emp.add(p);
	}
	public void eliminar(Empleado x){
		emp.remove(x);
	}
	
	public Empleado buscar(int codigo){
		Empleado e;
		for(int i=0;i<tamano();i++){
			e=Obtener(i);
			if(e.getCodigo()==codigo)
				return e;
			}
			return null;
		}
	
	public int codigoCorrelativo(){
		if(tamano()==0)
			return 1001;
		else
			return Obtener(tamano()-1).getCodigo()+1;
		}
	public void grabarEmpleado(){
		try {
		PrintWriter pw; 
		String linea;
		Empleado pro = null; 
		pw = new PrintWriter(new FileWriter(archivo));
		for(int i=0; i<tamano(); i++){
		pro = emp.get(i);
		linea = pro.getCodigo()+"//"+ 
		pro.getNombres()+"//"+ 
		pro.getApellido_Paterno()+"//"+ 
		pro.getApellido_Materno()+"//"+
		pro.getTurno()+"//"+
		pro.getTipo_Empleado();
		
		
		pw.println(linea); 
		}
		pw.close(); 
		} catch (Exception e){
		System.out.println("Error: "+e);
		}
		}
	public void cargarEmpleado(){
		try {
		BufferedReader br; 
		String linea; 
		StringTokenizer st; 
		int codigo;
		String Nombres; 
		String Apellido_Paterno;
		String Apellido_Materno;
		String tipo_de_empleado;
		String turno;
	
		br = new BufferedReader(new FileReader(archivo));
		while ((linea = br.readLine()) != null) {
		st = new StringTokenizer(linea,"//");
		codigo = Integer.parseInt(st.nextToken());
		Nombres = st.nextToken();
		Apellido_Paterno = st.nextToken();
		Apellido_Materno = st.nextToken();
		tipo_de_empleado = st.nextToken();
		turno=st.nextToken();
		
		Empleado p=new Empleado(codigo, Nombres,Apellido_Paterno,Apellido_Materno,tipo_de_empleado,turno);
		adicionar(p); // Se agrega empleado al arrayList
		}
		br.close(); // Se cierra “br”
		}
		catch(Exception e) {
		System.out.println("Error: "+e);
		}
		}
}

	
	


