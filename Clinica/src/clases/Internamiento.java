package clases;

public class Internamiento {

	// Atributos Privados
	private int CodHosp, CodPaci, CodEmpl, NumCama, FecLleg, HorLleg, FecSali, HorSali, Estado;

	// Constructor

	public Internamiento(int CodHosp, int CodPaci, int CodEmpl, int NumCama, int FecLleg, int HorLleg, int FecSali,
			int HorSali, int Estado) {

		this.CodHosp = CodHosp;
		this.CodPaci = CodPaci;
		this.CodEmpl = CodEmpl;
		this.NumCama = NumCama;
		this.FecLleg = FecLleg;
		this.HorLleg = HorLleg;
		this.FecSali = FecSali;
		this.HorSali = HorSali;
		this.Estado = Estado;

	}
	// Métodos de acceso público: set/get

	public int getCodHosp() {
		return CodHosp;
	}

	public void setCodHosp(int codHosp) {
		this.CodHosp = codHosp;
	}

	public int getCodPaci() {
		return CodPaci;
	}

	public void setCodPaci(int codPaci) {
		this.CodPaci = codPaci;
	}

	public int getCodEmpl() {
		return CodEmpl;
	}

	public void setCodEmpl(int codEmpl) {
		this.CodEmpl = codEmpl;
	}

	public int getNumCama() {
		return NumCama;
	}

	public void setNumCama(int numCama) {
		this.NumCama = numCama;
	}

	public int getFecLleg() {
		return FecLleg;
	}

	public void setFecLleg(int fecLleg) {
		this.FecLleg = fecLleg;
	}

	public int getHorLleg() {
		return HorLleg;
	}

	public void setHorLleg(int horLleg) {
		this.HorLleg = horLleg;
	}

	public int getFecSali() {
		return FecSali;
	}

	public void setFecSali(int fecSali) {
		this.FecSali = fecSali;
	}

	public int getHorSali() {
		return HorSali;
	}

	public void setHorSali(int horSali) {
		this.HorSali = horSali;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		this.Estado = estado;
	}

}
