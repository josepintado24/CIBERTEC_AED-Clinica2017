package Clases;

public class Atencion {
	
	private int codigo,tipo;
	private String descripcion;
	private double precio;
	
	public Atencion(int codigo,int tipo,String descripcion,double precio){
		this.codigo=codigo;
		this.tipo=tipo;
		this.descripcion=descripcion;
		this.precio=precio;
	}
	
	public int getCodigo(){
		return codigo;
		}
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
