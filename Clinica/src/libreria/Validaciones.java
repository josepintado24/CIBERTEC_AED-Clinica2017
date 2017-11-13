package libreria;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class Validaciones {
	
	//Métodos static void con parámetros
	public static void soloNumero(KeyEvent e, JTextField txt, int longitud) {
		if (txt.getText().length() >= longitud) {
			e.consume();
		}
		
		char car = e.getKeyChar();
		
		if (!Character.isDigit(car)) {
			e.consume();
		}
	}
	
	public static void numeroReal(JTextField txt, KeyEvent e, int longitud) {
		if (txt.getText().length() >= longitud) {
			e.consume();
		}
		
		
		char car = e.getKeyChar();
		String numero = txt.getText().trim();
		
		if (!Character.isDigit(car) && car != '.') {
			e.consume();
		}else {
			if (numero.indexOf(".") != -1 && !Character.isDigit(car)) {
				e.consume();
			}
		}
	}
	
	public static void soloLetras(KeyEvent e, JTextField txt, int longitud) {
		if (txt.getText().length() >= longitud) {
			e.consume();
		}
		
		//OBTIENES EL VALOR DEL CARACTER
		char car = e.getKeyChar();
		
		if (!Character.isLetter(car) && car != KeyEvent.VK_SPACE) {
			e.consume();
		}
	}
	
	public static void letrasyNumeros(KeyEvent e, JTextField txt, int longitud) {
		if (txt.getText().length() >= longitud) {
			e.consume();
		}
		
		char car = e.getKeyChar();
		
		if (!Character.isLetter(car) && !Character.isDigit(car)) {
			e.consume();
		}
	}
	
	public static void cadenaTexto(KeyEvent e, JTextField txt, int longitud) {
		if (txt.getText().length() >= longitud) {
			e.consume();
		}
		
		char car = e.getKeyChar();
		
		if (!Character.isLetter(car) && car != KeyEvent.VK_SPACE && !Character.isDigit(car)) {
			e.consume();
		}
	}

}
