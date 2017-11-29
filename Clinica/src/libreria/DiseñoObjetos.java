package libreria;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DiseñoObjetos {

	// Métodos void con parámetros
	public void setCurvasButton(JButton btn, String ruta) {
		btn.setIcon(new ImageIcon(ruta));
	}

}
