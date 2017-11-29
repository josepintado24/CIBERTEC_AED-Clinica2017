package libreria;

import java.text.DecimalFormat;


import java.text.NumberFormat;
import java.util.Locale;
import java.lang.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Libreria {

	// Métodos static void que no retornan valor con parámetros
	public static void limpiarJTable(JTable jtbl, DefaultTableModel dtm) {
		for (int i = 0; i < jtbl.getRowCount(); i++) {
			dtm.removeRow(i);
			i--;
		}
	}

	public  static void mensajeAdvertenciaFrame(JFrame jf, String s) {
		JOptionPane.showMessageDialog(jf, s, "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

	public static void mensajeError(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void mensajeAdvertencia(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

	public static void mensajeInformacion(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	// Métodos static que retornan valor con parámetros
	public static int confirmacion(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "Advertencia", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
	}

	public static String formatoSoles(double numero) {
		Locale lp = new Locale("es", "PE");
		NumberFormat nf = NumberFormat.getCurrencyInstance(lp);
		return nf.format(numero);
	}

	public static String formatoDecimales(double numero) {
		DecimalFormat df = new DecimalFormat("##.##");
		return df.format(numero);
	}

	public static String formato2Decimales(double numero) {
		return String.format("%.2f", numero);
	}

	public static String getPassword(JPasswordField txt) {
		return new String(txt.getPassword());
	}

	public static int leerEntero(JTextField txt) {
		try {
			return Integer.parseInt(txt.getText().trim());
		}
		catch (Exception e) {
			return -1;
		}
	}

	public static double leerReal(JTextField txt) {
		try {
			return Double.parseDouble(txt.getText().trim());
		}
		catch (Exception e) {
			return -1.0;
		}
	}

	public static String leerCadena(JTextField txt) {
		return txt.getText().trim();
	}
}
