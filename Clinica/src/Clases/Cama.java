package Clases;

public class Cama {
private int numero_Cama;
private double precioDia;
private String Categoria,estado;

public Cama(int numero_Cama,String estado,Double precioDia ,String  Categoria){
	this.numero_Cama=numero_Cama;
	this.Categoria=Categoria;	
	this.estado=estado;
	this.precioDia=precioDia;
}

public String getCategoria() {
	return Categoria;
}

public void setCategoria(String categoria) {
	Categoria = categoria;
}

public int getnumero_Cama(){
	return numero_Cama;
}
public void setnumero_Cama(int numero_Cama){
	this.numero_Cama=numero_Cama;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public double getPrecioDia() {
	return precioDia;
}

public void setPrecioDia(double precioDia) {
	this.precioDia = precioDia;
}


}
