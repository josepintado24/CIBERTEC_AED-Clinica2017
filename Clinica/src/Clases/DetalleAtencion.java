package Clases;

public class DetalleAtencion {
	
	private int codigo_atencion,codigo_medicina,cantidad;
	private double precioUnitario;


public DetalleAtencion(int codigo_atencion,int codigo_medicina,int cantidad,double precioUnitario){
	this.codigo_atencion=codigo_atencion;
	this.codigo_medicina=codigo_medicina;
	this.cantidad=cantidad;
	this.precioUnitario=precioUnitario;
	
}

public int getcodigo_atencion(){
	return codigo_atencion;
}
public void setcodigo_atencion(){
	this.codigo_atencion=codigo_atencion;
}

public int getCodigo_medicina() {
	return codigo_medicina;
}

public void setCodigo_medicina(int codigo_medicina) {
	this.codigo_medicina = codigo_medicina;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public double getPrecioUnitario() {
	return precioUnitario;
}

public void setPrecioUnitario(double precioUnitario) {
	this.precioUnitario = precioUnitario;
}






}