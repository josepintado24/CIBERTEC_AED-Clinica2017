package gui;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import arreglos.ArregloEmpleado;
import clases.Empleado;
import libreria.DiseñoObjetos;
import libreria.Libreria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class DlgLogin extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JPasswordField passwordField;
	private JButton btnCancelar;

	// Declaración global libreria Diseño Objetos
	DiseñoObjetos ds = new DiseñoObjetos();
	// Declaración global libreria ArregloEmpleado
	ArregloEmpleado ae = new ArregloEmpleado("empleados.txt");
	// Variable global de empleado que inicio sesión
	public int codigoEmpleado = -1;
	public int tipoEmpleado;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgLogin dialog = new DlgLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
	 private int x;
	 private int y;
	 private JLabel lblLogin;
	 private JLabel label;

	public DlgLogin() {
		setUndecorated(true);
		setForeground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Robert\\Desktop\\ProyectoClinica\\Clinica\\src\\imagenes\\login.jpg"));
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setResizable(false);
		setTitle("---=Bienvenido=---");
		setBounds(100, 100, 308, 568);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				Point ubicacion = MouseInfo.getPointerInfo().getLocation();
			    setLocation(ubicacion.x - x, ubicacion.y - y);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
			    y = e.getY();
			}
		});
		
				txtUsuario = new JTextField();
				txtUsuario.setBorder(null);
				txtUsuario.setCaretColor(Color.BLACK);
				txtUsuario.setBounds(83, 279, 181, 25);
				getContentPane().add(txtUsuario);
				txtUsuario.setForeground(Color.BLACK);
				txtUsuario.setFont(new Font("Decker", Font.PLAIN, 14));
				txtUsuario.setColumns(10);
		
				btnIngresar = new JButton("INGRESAR");
				btnIngresar.setBorderPainted(false);
				btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnIngresar.setBorder(new LineBorder(Color.BLACK, 1, true));
				btnIngresar.setBounds(102, 417, 122, 41);
				getContentPane().add(btnIngresar);
				btnIngresar.addActionListener(this);
				btnIngresar.setForeground(Color.BLACK);
				btnIngresar.setBackground(Color.WHITE);
				btnIngresar.setFont(new Font("Decker", Font.PLAIN, 16));
				ds.setCurvasButton(btnIngresar, "imagenes/aceptar.png");
		
				passwordField = new JPasswordField();
				passwordField.setFont(new Font("Decker", Font.PLAIN, 14));
				passwordField.setDisabledTextColor(Color.WHITE);
				passwordField.setBorder(null);
				passwordField.setBounds(83, 355, 181, 25);
				getContentPane().add(passwordField);
				passwordField.setForeground(Color.BLACK);
		
				btnCancelar = new JButton("CANCELAR");
				btnCancelar.setBorderPainted(false);
				btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnCancelar.setBounds(102, 489, 122, 41);
				getContentPane().add(btnCancelar);
				btnCancelar.addActionListener(this);
				btnCancelar.setForeground(Color.BLACK);
				btnCancelar.setBackground(Color.WHITE);
				btnCancelar.setFont(new Font("Decker", Font.PLAIN, 16));
				ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 308, 39);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Icon m = new ImageIcon(getClass().getResource("/image/ADVERTENCIA.png"));
				int dialog = JOptionPane.YES_NO_OPTION;
				int result =JOptionPane.showConfirmDialog(null, "¿Seguro que Quiere Salir?","Alert!",dialog,dialog,m);
				
				if(result ==0){
					System.exit(0);
				}
			}
		});
		lblNewLabel.setIcon(new ImageIcon(DlgLogin.class.getResource("/image/X_32px.png")));
		lblNewLabel.setBounds(269, 0, 32, 40);
		panel.add(lblNewLabel);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Decker", Font.PLAIN, 16));
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogin.setBounds(39, 0, 90, 40);
		panel.add(lblLogin);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(DlgLogin.class.getResource("/image/seguridad.png")));
		label.setBounds(10, 0, 19, 40);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(51, 305, 213, 9);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(51, 381, 213, 9);
		getContentPane().add(separator_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DlgLogin.class.getResource("/image/user.png")));
		label_1.setBounds(92, 65, 140, 159);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(DlgLogin.class.getResource("/image/User_32px.png")));
		label_2.setBounds(49, 276, 33, 26);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(DlgLogin.class.getResource("/image/Key_32px.png")));
		label_3.setBounds(49, 352, 33, 26);
		getContentPane().add(label_3);

		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		if (leerUsuario().equals("")) {
			
			Libreria.mensajeAdvertencia(this, "Debe ingresar su USUARIO");
			txtUsuario.requestFocus();
		}
		else if (leerPasword().equals("")) {
			Libreria.mensajeAdvertencia(this, "Debe ingresar su PASSWORD");
			passwordField.requestFocus();
		}
		else {
			if (ae.tamaño() == 0) {
				ae.adicionar(new Empleado(1001, "Huaman", "Esthefano", 0, "admin", "admin", 1));
				ae.adicionar(new Empleado(1002, "Altamirano", "Pablo", 0, "pablo", "pablo123", 1));
				ae.grabarEmpleados();
				validarLogin();
			}
			
			
			else {
				validarLogin();
			}
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		this.dispose();
	}

	// métodos void con parámetros
	void validarLogin() {
		int c = 0;

		Empleado e;
		for (int i = 0; i < ae.tamaño(); i++) {
			e = ae.obtener(i);
			if (e.getLogin().equalsIgnoreCase(leerUsuario())
					&& e.getPassword().equalsIgnoreCase(leerPasword())) {

				Libreria.mensajeInformacion(this,
						"BIENVENIDO: " + e.getNombres().toUpperCase() + " " + e.getApellidos().toUpperCase());
				c++;
				codigoEmpleado = e.getCodEmpleado();
				tipoEmpleado = e.getTipoEmpleado();
				Principal jFrame= new Principal();
				this.setVisible(false);
				jFrame.setVisible(true);
				jFrame.setLocationRelativeTo(null);
				dispose();
				break;
			}
		}

		if (c == 0) {
			Libreria.mensajeAdvertencia(this, "LOS DATOS INGRESADOS SON INCORRECTOS.");
			txtUsuario.setText("");
			passwordField.setText("");
			txtUsuario.requestFocus();
		}
	}

	// metódos con retorno sin parámetros
	String leerUsuario() {
		return Libreria.leerCadena(txtUsuario);
	}

	String leerPasword() {
		return Libreria.getPassword(passwordField);
	}
}
