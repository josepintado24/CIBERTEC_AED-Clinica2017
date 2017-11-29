package libreria;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

public class Fecha {

	// Métodos static tipo void (con parámetros)
	public static void colocarMeses(JComboBox<String> cbo) {
		cbo.addItem("Enero");
		cbo.addItem("Febrero");
		cbo.addItem("Marzo");
		cbo.addItem("Abril");
		cbo.addItem("Mayo");
		cbo.addItem("Junio");
		cbo.addItem("Julio");
		cbo.addItem("Agosto");
		cbo.addItem("Setiembre");
		cbo.addItem("Octubre");
		cbo.addItem("Noviembre");
		cbo.addItem("Diciembre");
	}

	public static void colocarDiaActual(JComboBox<String> cboDia) {
		Calendar calendario = new GregorianCalendar();
		cboDia.setSelectedIndex(calendario.get(Calendar.DAY_OF_MONTH) - 1);
	}

	public static void colocarMesActual(JComboBox<String> cbo) {
		Calendar calendario = new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.MONTH));
	}

	public static void colocarItems(JComboBox<String> cbo, int inicio, int fin) {
		if (inicio < fin)
			while (inicio <= fin) {
				cbo.addItem("" + inicio);
				inicio++;
			}
		else
			while (inicio >= fin) {
				cbo.addItem("" + inicio);
				inicio--;
			}
	}

	public static int obtenerHoraActual() {
		String minuto = "";
		String segundo = "";

		Calendar calendario = new GregorianCalendar();

		int h = calendario.get(Calendar.HOUR_OF_DAY);

		int m = calendario.get(Calendar.MINUTE);
		if (m < 10)
			minuto = "0" + m;
		else
			minuto = "" + m;

		int s = calendario.get(Calendar.SECOND);
		if (s < 10)
			segundo = "0" + s;
		else
			segundo = "" + s;

		return Integer.parseInt(h + minuto + segundo);
	}

	public static void setFecha(JComboBox<String> dia, JComboBox<String> mes, JComboBox<String> año, int fecha) {
		int dd = fecha % 100, mm = (fecha / 100) % 100, aa = fecha / 10000;
		dia.setSelectedIndex(dd - 1);
		mes.setSelectedIndex(mm - 1);
		año.setSelectedItem(aa + "");
	}

	// Métodos static que retornan valor (sin parámetros)
	public static int añoActual() {
		Calendar calendario = new GregorianCalendar();
		return calendario.get(Calendar.YEAR);
	}

	// Métodos static que retornan valor (con parámetros)
	public static String dd_mm_aaaa(int fecha) {
		String s = "" + fecha;
		return "" + s.charAt(6) + s.charAt(7) + '/' + s.charAt(4) + s.charAt(5) + '/' + s.charAt(0) + s.charAt(1)
				+ s.charAt(2) + s.charAt(3);
	}

	public static int obtenerDiaDeFecha(int fecha) {
		String s = "" + fecha;
		return s.charAt(6) + s.charAt(7);
	}

	public static int obtenerMesDeFecha(int fecha) {
		String s = "" + fecha;
		return s.charAt(4) + s.charAt(5);
	}

	public static int obtenerAñoDeFecha(int fecha) {
		String s = "" + fecha;
		return s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(3);
	}

	public static String hh_mm_ss(int hora) {
		String s = "" + hora;
		if (s.length() == 4) {
			return "00" + ':' + s.charAt(0) + s.charAt(1) + ':' + s.charAt(2) + s.charAt(3);
		}
		else if (s.length() == 5) {
			return "0" + s.charAt(0) + ':' + s.charAt(1) + s.charAt(2) + ':' + s.charAt(3) + s.charAt(4);
		}
		else {
			return "" + s.charAt(0) + s.charAt(1) + ':' + s.charAt(2) + s.charAt(3) + ':' + s.charAt(4) + s.charAt(5);
		}
	}

	public static int getFecha(JComboBox<String> dia, JComboBox<String> mes, JComboBox<String> año) {
		int dd = dia.getSelectedIndex() + 1, mm = mes.getSelectedIndex() + 1,
				aa = Integer.parseInt(año.getSelectedItem().toString());
		return (aa * 100 + mm) * 100 + dd;
	}

	public static int CantidadDiasEntre2fechas(int Y1, int M1, int D1, int Y2, int M2, int D2) {
		GregorianCalendar date = new GregorianCalendar(Y1, M1, D1);
		GregorianCalendar date2 = new GregorianCalendar(Y2, M2, D2);
		long difms = date2.getTimeInMillis() - date.getTimeInMillis();
		long difd = difms / (1000 * 60 * 60 * 24);
		return (int) difd;
	}
}
