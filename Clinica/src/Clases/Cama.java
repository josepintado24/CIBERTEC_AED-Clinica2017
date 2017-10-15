package Clases;

public class Cama {
private int numero_Cama,categoria,estado;
private double precioDia;

public Cama(int numero_Cama,int categoria,int estado,Double precioDia){
	this.numero_Cama=numero_Cama;
	this.categoria=categoria;
	this.estado=estado;
	this.precioDia=precioDia;
}

public int getnumero_Cama(){
	return numero_Cama;
}
public void setnumero_Cama(int numero_Cama){
	this.numero_Cama=numero_Cama;
}

public int getCategoria() {
	return categoria;
}

public void setCategoria(int categoria) {
	this.categoria = categoria;
}

public int getEstado() {
	return estado;
}

public void setEstado(int estado) {
	this.estado = estado;
}

public double getPrecioDia() {
	return precioDia;
}

public void setPrecioDia(double precioDia) {
	this.precioDia = precioDia;
}


}
