package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloEmpleado;
import clases.Empleado;
import libreria.DiseñoObjetos;
import libreria.Validaciones;
import libreria.Libreria;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class DlgEmpleado extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JLabel lblApellidos;
	private JLabel lblNombres;
	private JLabel lblTipo;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JLabel lblTurno;
	private JTextField txtApellidos;
	private JTextField txtNombres;
	private JComboBox<String> cboTipo;
	private JTextField txtLogin;
	private JTextField txtPassword;
	private JComboBox<String> cboTurno;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private JLabel lblMensaje;
	private JScrollPane scrollPane;
	private JTextField txtCodigo;
	private JButton btnGuardar;
	private JTable jtblEmpleados;

	// Declaración global para modelo de tabla
	private DefaultTableModel dtm;

	/*
	 * Tipo de operación a procesar: Adicionar, Modificar, Eliminar o Consultar
	 */
	private int tipoOperacion;
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR = 2;
	public final static int CONSULTAR = 3;
	// Declaración global
	ArregloEmpleado ae = new ArregloEmpleado("empleados.txt");

	// Declaración global de librerias
	Validaciones v = new Validaciones();
	DiseñoObjetos ds = new DiseñoObjetos();
	Libreria lb = new Libreria();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgEmpleado dialog = new DlgEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgEmpleado.class.getResource("/imagenes/mantenimiento.png")));
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setModal(true);
		setTitle("MANTENIMIENTO | EMPLEADOS");
		setBounds(100, 100, 1257, 571);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(14, 60, 71, 14);
		getContentPane().add(lblCodigo);

		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(0, 101, 85, 14);
		getContentPane().add(lblApellidos);

		lblNombres = new JLabel("NOMBRES");
		lblNombres.setForeground(Color.BLACK);
		lblNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombres.setBounds(0, 141, 85, 14);
		getContentPane().add(lblNombres);

		lblTipo = new JLabel("TIPO");
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(0, 181, 85, 14);
		getContentPane().add(lblTipo);

		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(39, 221, 46, 14);
		getContentPane().add(lblLogin);

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(0, 261, 85, 14);
		getContentPane().add(lblPassword);

		lblTurno = new JLabel("TURNO");
		lblTurno.setForeground(Color.BLACK);
		lblTurno.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblTurno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTurno.setBounds(20, 301, 65, 14);
		getContentPane().add(lblTurno);

		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.setEditable(false);
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtApellidos.setBounds(96, 94, 227, 29);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.setEditable(false);
		txtNombres.setForeground(Color.BLACK);
		txtNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtNombres.setBounds(95, 134, 228, 29);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		cboTipo = new JComboBox<String>();
		cboTipo.setEnabled(false);
		cboTipo.setForeground(Color.BLACK);
		cboTipo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		cboTipo.setBounds(95, 174, 154, 29);
		cboTipo.addItem("Administrador");
		cboTipo.addItem("Cajero");
		getContentPane().add(cboTipo);

		txtLogin = new JTextField();
		txtLogin.addKeyListener(this);
		txtLogin.setEditable(false);
		txtLogin.setForeground(Color.BLACK);
		txtLogin.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtLogin.setBounds(95, 214, 154, 29);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.addKeyListener(this);
		txtPassword.setEditable(false);
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtPassword.setBounds(95, 254, 154, 29);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		cboTurno = new JComboBox<String>();
		cboTurno.setEnabled(false);
		cboTurno.setForeground(Color.BLACK);
		cboTurno.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		cboTurno.setBounds(95, 294, 154, 29);
		cboTurno.addItem("Noche");
		cboTurno.addItem("Día");
		getContentPane().add(cboTurno);

		txtCodigo = new JTextField();
		txtCodigo.setBackground(new Color(255, 255, 255));
		txtCodigo.addKeyListener(this);
		txtCodigo.setEditable(false);
		txtCodigo.setForeground(Color.BLACK);
		txtCodigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(95, 53, 85, 29);
		getContentPane().add(txtCodigo);

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBackground(new Color(124, 252, 0));
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAdicionar.setBounds(20, 347, 137, 39);
		ds.setCurvasButton(btnAdicionar, "imagenes/adicionar.png");
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setBackground(Color.CYAN);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnConsultar.setBounds(177, 347, 145, 39);
		ds.setCurvasButton(btnConsultar, "imagenes/consultar.png");
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBackground(new Color(0, 139, 139));
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnModificar.setBounds(177, 397, 145, 39);
		ds.setCurvasButton(btnModificar, "imagenes/modificar.png");
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(127, 255, 212));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnEliminar.setBounds(20, 397, 137, 39);
		ds.setCurvasButton(btnEliminar, "imagenes/eliminar.png");
		getContentPane().add(btnEliminar);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBackground(new Color(30, 144, 255));
		btnAceptar.setEnabled(false);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAceptar.setBounds(20, 447, 137, 39);
		ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setBackground(new Color(0, 255, 255));
		btnCancelar.setEnabled(false);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnCancelar.setBounds(177, 447, 145, 39);
		ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
		getContentPane().add(btnCancelar);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setBackground(new Color(102, 205, 170));
		btnBuscar.setEnabled(false);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnBuscar.setBounds(213, 53, 110, 29);
		ds.setCurvasButton(btnBuscar, "imagenes/buscar.png");
		getContentPane().add(btnBuscar);

		lblMensaje = new JLabel("");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setBackground(Color.DARK_GRAY);
		lblMensaje.setBounds(10, 11, 313, 29);
		getContentPane().add(lblMensaje);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 11, 908, 520);
		getContentPane().add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblEmpleados = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}

		};
		jtblEmpleados.setForeground(Color.BLACK);
		jtblEmpleados.setFont(new Font("Arial", Font.BOLD, 14));
		jtblEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtblEmpleados.setRowHeight(25);
		scrollPane.setViewportView(jtblEmpleados);

		btnGuardar = new JButton("GUARDAR EMPLEADOS");
		btnGuardar.addActionListener(this);
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnGuardar.setBackground(new Color(0, 250, 154));
		btnGuardar.setBounds(20, 492, 303, 39);
		ds.setCurvasButton(btnGuardar, "imagenes/grabar.png");
		getContentPane().add(btnGuardar);

		listado();
		modeloTabla();
		this.setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando Empleado");
		txtCodigo.setText("" + ae.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.setEditable(false);
		txtApellidos.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Empleado");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Empleado");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.requestFocus();
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Empleado");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarEmpleado();
	}

	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarEmpleado();
				break;
			case CONSULTAR:
				limpieza();
				habilitarBusqueda(false);
				habilitarOperaciones(true);
				lblMensaje.setText("");
				break;
			case MODIFICAR:
				modificarEmpleado();
				break;
			case ELIMINAR:
				eliminarEmpleado();
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		if (tipoOperacion != ADICIONAR)
			habilitarBusqueda(false);
		lblMensaje.setText("");
		habilitarEntradas(false);
		habilitarOperaciones(true);
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		if (ae.existeArchivo()) {
			int ok = Libreria.confirmacion(this, "¿ Desea actualizar \"" + ae.getArchivo() + "\" ?");
			if (ok == 0) {
				ae.grabarEmpleados();
				Libreria.mensajeInformacion(this, "\"" + ae.getArchivo() + "\" ha sido actualizado");
			}
			else
				Libreria.mensajeInformacion(this, "No se actualizó  \"" + ae.getArchivo() + "\"");
		}
		else {
			ae.grabarEmpleados();
			Libreria.mensajeInformacion(this, "\"" + ae.getArchivo() + "\" ha sido creado");
		}
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtPassword) {
			keyTypedTxtPassword(arg0);
		}
		if (arg0.getSource() == txtLogin) {
			keyTypedTxtLogin(arg0);
		}
		if (arg0.getSource() == txtNombres) {
			keyTypedTxtNombres(arg0);
		}
		if (arg0.getSource() == txtApellidos) {
			keyTypedTxtApellidos(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigo(arg0);
		}
	}

	protected void keyTypedTxtCodigo(KeyEvent e) {
		Validaciones.soloNumero(e, txtCodigo, 4);

		char t = e.getKeyChar();
		if (t == KeyEvent.VK_ENTER && tipoOperacion != ADICIONAR)
			consultarEmpleado();
	}

	protected void keyTypedTxtApellidos(KeyEvent e) {
		Validaciones.soloLetras(e, txtApellidos, 20);
	}

	protected void keyTypedTxtNombres(KeyEvent e) {
		Validaciones.soloLetras(e, txtNombres, 20);
	}

	protected void keyTypedTxtLogin(KeyEvent e) {
		Validaciones.letrasyNumeros(e, txtLogin, 10);
	}

	protected void keyTypedTxtPassword(KeyEvent e) {
		Validaciones.letrasyNumeros(e, txtPassword, 10);
	}

	// Métodos tipo void sin parámetros
	void modeloTabla() {
		TableColumnModel tc = jtblEmpleados.getColumnModel();
		tc.getColumn(0).setPreferredWidth(70);
		tc.getColumn(1).setPreferredWidth(200);
		tc.getColumn(2).setPreferredWidth(200);
		tc.getColumn(3).setPreferredWidth(150);
		tc.getColumn(4).setPreferredWidth(150);
		tc.getColumn(5).setPreferredWidth(150);
		tc.getColumn(6).setPreferredWidth(100);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
		tc.getColumn(3).setCellRenderer(tcr);
		tc.getColumn(4).setCellRenderer(tcr);
		tc.getColumn(5).setCellRenderer(tcr);
		tc.getColumn(6).setCellRenderer(tcr);

		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
	}

	void limpieza() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		cboTipo.setSelectedIndex(0);
		txtLogin.setText("");
		txtPassword.setText("");
		cboTurno.setSelectedIndex(0);
	}

	void listado() {
		Libreria.limpiarJTable(jtblEmpleados, dtm);

		if (ae.tamaño() == 0) {

		}
		else {
			for (int i = 0; i < ae.tamaño(); i++) {
				Empleado x = ae.obtener(i);
				dtm.addRow(new Object[] { x.getCodEmpleado(), x.getApellidos(), x.getNombres(),
						getTipoEmpleado(x.getTipoEmpleado()), x.getLogin(), x.getPassword(),
						getTurnoEmpleado(x.getTurno()) });
			}
		}
	}

	void adicionarEmpleado() {
		if (leerApellidos().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su APELLIDO");
			txtApellidos.setText("");
			txtApellidos.requestFocus();
		}
		else if (leerNombres().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su NOMBRE");
			txtNombres.requestFocus();
		}
		else if (leerLogin().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su LOGIN");
			txtLogin.setText("");
			txtLogin.requestFocus();
		}
		else if (leerPassword().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su PASSWORD");
			txtPassword.setText("");
			txtPassword.requestFocus();
		}
		else if (validarUsuarioExistente()) {
			Libreria.mensajeError(this, "El LOGIN ingresado ya existe.");
			txtLogin.setText("");
			txtLogin.requestFocus();
		}
		else {
			Empleado nuevo = new Empleado(leerCodigo(), leerApellidos(), leerNombres(), leerTipo(), leerLogin(),
					leerPassword(), leerTurno());
			ae.adicionar(nuevo);
			listado();
			habilitarEntradas(false);
			habilitarOperaciones(true);
			lblMensaje.setText("");
		}
	}

	void consultarEmpleado() {

		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Empleado");
			txtCodigo.requestFocus();
		}
		else {
			Empleado x = ae.buscar(leerCodigo());
			if (x != null) {
				txtNombres.setText(x.getNombres());
				txtApellidos.setText(x.getApellidos());
				cboTipo.setSelectedIndex(x.getTipoEmpleado());
				txtLogin.setText(x.getLogin());
				txtPassword.setText(x.getPassword());
				cboTurno.setSelectedIndex(x.getTurno());
			}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				limpieza();
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	void modificarEmpleado() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Empleado");
			txtCodigo.requestFocus();
		}
		else {
			Empleado x = ae.buscar(leerCodigo());
			if (x != null)
				if (leerApellidos().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó su APELLIDO");
					txtApellidos.setText("");
					txtApellidos.requestFocus();
				}
				else if (leerNombres().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó su NOMBRE");
					txtNombres.requestFocus();
				}
				else if (leerLogin().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó su LOGIN");
					txtLogin.setText("");
					txtLogin.requestFocus();
				}
				else if (leerPassword().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó su PASSWORD");
					txtPassword.setText("");
					txtPassword.requestFocus();
				}
				else if (validarUsuarioExistente()) {
					Libreria.mensajeError(this, "El LOGIN ingresado ya existe.");
					txtLogin.setText("");
					txtLogin.requestFocus();
				}
				else {
					lblMensaje.setText("");
					x.setNombres(leerNombres());
					x.setApellidos(leerApellidos());
					x.setTipoEmpleado(leerTipo());
					x.setLogin(leerLogin());
					x.setPassword(leerPassword());
					x.setTurno(leerTurno());
					listado();
					habilitarBusqueda(false);
					habilitarEntradas(false);
					habilitarOperaciones(true);
				}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	void eliminarEmpleado() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Empleado");
			txtCodigo.requestFocus();
		}
		else {
			Empleado x = ae.buscar(leerCodigo());
			if (x != null) {
				lblMensaje.setText("");
				ae.eliminar(x);
				listado();
				limpieza();
				habilitarBusqueda(false);
				habilitarOperaciones(true);
			}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	// Métodos tipo void con parámetros
	void habilitarBusqueda(boolean sino) {
		btnBuscar.setEnabled(sino);
		txtCodigo.setEditable(sino);
		if (sino)
			txtCodigo.requestFocus();
	}

	void habilitarEntradas(boolean sino) {
		if (!sino)
			limpieza();
		txtNombres.setEditable(sino);
		txtApellidos.setEditable(sino);
		txtLogin.setEditable(sino);
		txtPassword.setEditable(sino);
		txtCodigo.setEditable(sino);
		cboTipo.setEnabled(sino);
		cboTurno.setEnabled(sino);
	}

	void habilitarOperaciones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnAceptar.setEnabled(!sino);
		btnCancelar.setEnabled(!sino);
	}

	// Métodos que retornan valor sin parámetros
	String[] getColumnas() {
		String columnas[] = new String[] { "CÓDIGO", "APELLIDOS", "NOMBRES", "TIPO", "LOGIN", "PASSWORD", "TURNO" };
		return columnas;
	}

	int leerCodigo() {
		return Libreria.leerEntero(txtCodigo);
	}

	String leerNombres() {
		return Libreria.leerCadena(txtNombres);
	}

	String leerApellidos() {
		return Libreria.leerCadena(txtApellidos);
	}

	int leerTipo() {
		return cboTipo.getSelectedIndex();
	}

	String leerLogin() {
		return Libreria.leerCadena(txtLogin);
	}

	String leerPassword() {
		return Libreria.leerCadena(txtPassword);
	}

	int leerTurno() {
		return cboTurno.getSelectedIndex();
	}

	// Métodos que retornan valor con parámetros
	boolean validarUsuarioExistente() {
		Empleado e;
		for (int i = 0; i < ae.tamaño(); i++) {
			e = ae.obtener(i);
			if (e.getCodEmpleado() != leerCodigo()) {
				if (e.getLogin().equalsIgnoreCase(leerLogin())) {
					return true;
				}
			}
			else {
				if (e.getLogin().equalsIgnoreCase(leerLogin())) {
					return false;
				}
			}
		}
		return false;
	}

	String getTipoEmpleado(int tipo) {
		if (tipo == 0) {
			return "ADMINISTRADOR";
		}
		else {
			return "CAJERO";
		}
	}

	String getTurnoEmpleado(int turno) {
		if (turno == 0) {
			return "NOCHE";
		}
		else {
			return "DÍA";
		}
	}
}
