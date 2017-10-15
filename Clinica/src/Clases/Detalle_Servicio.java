package Clases;

public class Detalle_Servicio {
private int Id_Servicio,codigo_Medicina,cantidad;
private double precio_Unitario,subTotal;

public Detalle_Servicio(int Id_Servicio,int codigo_Medicina,int cantidad,double precio_Unitario,double subTotal){
	this.Id_Servicio=Id_Servicio;
	this.codigo_Medicina=codigo_Medicina;
	this.cantidad=cantidad;
	this.precio_Unitario=precio_Unitario;
	this.subTotal=subTotal;
}

public int getId_Servicio(){
	return Id_Servicio;
}

public void setId_Servicio(int Id_Servicio){
	this.Id_Servicio=Id_Servicio;
}

public int getCodigo_Medicina() {
	return codigo_Medicina;
}

public void setCodigo_Medicina(int codigo_Medicina) {
	this.codigo_Medicina = codigo_Medicina;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public double getPrecio_Unitario() {
	return precio_Unitario;
}

public void setPrecio_Unitario(double precio_Unitario) {
	this.precio_Unitario = precio_Unitario;
}

public double getSubTotal() {
	return subTotal;
}

public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
}





}
