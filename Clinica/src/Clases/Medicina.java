package Clases;

public class Medicina {
private int codigo_Medicina,stock;
private String Laboratorio,nombres;
private double precio;

public Medicina(int codigo_Medicina,int stock,String Laboratorio,String nombres,double precio){
		this.codigo_Medicina=codigo_Medicina;
		this.stock=stock;
		this.Laboratorio=Laboratorio;
		this.nombres=nombres;
		this.precio=precio;	
}

public int getcodigo_Medicina(){
	return codigo_Medicina;
}
public void setcodigo_Medicina(int codigo_Medicina){
	this.codigo_Medicina=codigo_Medicina;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public String getLaboratorio() {
	return Laboratorio;
}

public void setLaboratorio(String laboratorio) {
	Laboratorio = laboratorio;
}

public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}



}

