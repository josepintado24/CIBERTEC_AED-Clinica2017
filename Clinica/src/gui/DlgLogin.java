package gui;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
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

public class DlgLogin extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JPanel panelLogin;
	private JButton btnIngresar;
	private JPasswordField passwordField;
	private JButton btnCancelar;
	private JLabel lblImagen;

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

	public DlgLogin() {
		setForeground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Robert\\Desktop\\ProyectoClinica\\Clinica\\src\\imagenes\\login.jpg"));
		getContentPane().setBackground(new Color(102, 204, 153));
		setModal(true);
		setResizable(false);
		setTitle("---=Bienvenido=---");
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(null);

		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(102, 153, 102));
		panelLogin.setBorder(UIManager.getBorder("ProgressBar.border"));
		panelLogin.setBounds(21, 34, 463, 226);
		getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		panelLogin.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));

		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(12, 51, 80, 14);
		panelLogin.add(lblUsuario);
		lblUsuario.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(12, 103, 78, 14);
		panelLogin.add(lblPassword);
		lblPassword.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));

		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setBounds(100, 38, 211, 41);
		panelLogin.add(txtUsuario);
		txtUsuario.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtUsuario.setColumns(10);

		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setBackground(new Color(152, 251, 152));
		btnIngresar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnIngresar.setBounds(39, 146, 122, 41);
		panelLogin.add(btnIngresar);
		ds.setCurvasButton(btnIngresar, "imagenes/aceptar.png");

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(100, 89, 211, 41);
		panelLogin.add(passwordField);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(new Color(0, 255, 255));
		btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnCancelar.setBounds(178, 146, 122, 41);
		panelLogin.add(btnCancelar);
		ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");

		lblImagen = new JLabel("");
		lblImagen.setBounds(321, 11, 132, 202);
		lblImagen.setIcon(new ImageIcon("imagenes/login.jpg"));
		panelLogin.add(lblImagen);

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
