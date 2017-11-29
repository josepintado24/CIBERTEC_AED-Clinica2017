package gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import org.yatusaes.FocusTraversalOnArray;

import arreglos.ArregloPaciente;
import clases.Paciente;
import libreria.DiseñoObjetos;
import libreria.Libreria;
import libreria.Validaciones;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JRadioButton;
import java.awt.Component;

public class DlgPaciente extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JScrollPane scrollPane;
	public JButton btnAdicionar;
	public JButton btnConsultar;
	public JButton btnModificar;
	public JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelfono;
	private JLabel lblDni;
	private JLabel lblMensaje;
	private JTable tblPacientes;
	public JButton btnGuardarPacientes;
	private JTextField filtro;
	private JRadioButton rdbtnApellidos;
	private JRadioButton rdbtnDni;
	private JLabel lblBuscarPor;

	private ButtonGroup bp;

	// Declaración de variables globales para obtener datos de tabla
	public String codigoPaciente;

	// Declaración global para modelo de tabla
	private DefaultTableModel dtm;
	// DECLARACIÓN GLOBAL PARA PODER FILTRAR DATOS EN TABLA
	TableRowSorter<DefaultTableModel> sorter;
	RowFilter<DefaultTableModel, Object> rf;

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
	ArregloPaciente ap = new ArregloPaciente("pacientes.txt");
	// Declaración global de libreria Validaciones
	Validaciones v = new Validaciones();
	// Declaración global de libreria DiseñoObjetos
	DiseñoObjetos ds = new DiseñoObjetos();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgPaciente dialog = new DlgPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgPaciente() {
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setResizable(false);
		setTitle("MANTENIMIENTO | PACIENTE");
		setBounds(100, 100, 1013, 494);
		getContentPane().setLayout(null);

		lblCdigo = new JLabel("C\u00D3DIGO");
		lblCdigo.setForeground(Color.BLACK);
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblCdigo.setBounds(15, 64, 75, 14);
		getContentPane().add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setEditable(false);
		txtCodigo.setForeground(Color.BLACK);
		txtCodigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtCodigo.setBounds(100, 57, 137, 29);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBackground(new Color(102, 205, 170));
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnBuscar.setBounds(247, 57, 110, 29);
		ds.setCurvasButton(btnBuscar, "imagenes/buscar.png");
		getContentPane().add(btnBuscar);

		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.setEditable(false);
		txtNombres.setForeground(Color.BLACK);
		txtNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtNombres.setColumns(10);
		txtNombres.setBounds(100, 97, 257, 29);
		getContentPane().add(txtNombres);

		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.setEditable(false);
		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(100, 137, 257, 29);
		getContentPane().add(txtApellidos);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setEditable(false);
		txtTelefono.setForeground(Color.BLACK);
		txtTelefono.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(100, 177, 137, 29);
		getContentPane().add(txtTelefono);

		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setEditable(false);
		txtDni.setForeground(Color.BLACK);
		txtDni.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		txtDni.setColumns(10);
		txtDni.setBounds(100, 217, 137, 29);
		getContentPane().add(txtDni);

		// ASIGNANDO MODELO DE TABLA
		dtm = new DefaultTableModel(null, getColumnas());
		// ESTABLECIENDO A TABLEROWSORTER EL MODELO DE LA TABLA
		sorter = new TableRowSorter<DefaultTableModel>(dtm);
		// ESTABLECIMIENTO NULL ROWFILTER
		rf = null;

		tblPacientes = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};
		tblPacientes.setForeground(Color.BLACK);
		tblPacientes.setFont(new Font("Arial", Font.BOLD, 14));
		tblPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPacientes.setRowHeight(25);
		;

		scrollPane = new JScrollPane(tblPacientes);
		scrollPane.setBounds(367, 97, 630, 360);
		getContentPane().add(scrollPane);

		tblPacientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (e.getClickCount() == 2) {
						int row = tblPacientes.getSelectedRow();

						if (row < 0) {
							
						}
						else {
							codigoPaciente = tblPacientes.getValueAt(row, 0).toString();
							dispose();
						}
					}
				}
			}
		});

		tblPacientes.setAutoCreateRowSorter(true);
		tblPacientes.setRowSorter(sorter);

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setBackground(new Color(124, 252, 0));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAdicionar.setBounds(39, 268, 137, 39);
		ds.setCurvasButton(btnAdicionar, "imagenes/adicionar.png");
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBackground(Color.CYAN);
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnConsultar.setBounds(196, 268, 145, 39);
		ds.setCurvasButton(btnConsultar, "imagenes/consultar.png");
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(0, 139, 139));
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnModificar.setBounds(196, 318, 145, 39);
		ds.setCurvasButton(btnModificar, "imagenes/modificar.png");
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(127, 255, 212));
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnEliminar.setBounds(39, 318, 137, 39);
		ds.setCurvasButton(btnEliminar, "imagenes/eliminar.png");
		getContentPane().add(btnEliminar);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBackground(new Color(30, 144, 255));
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAceptar.setBounds(39, 368, 137, 39);
		ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(new Color(0, 255, 255));
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnCancelar.setBounds(196, 368, 145, 39);
		ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
		getContentPane().add(btnCancelar);

		lblNombres = new JLabel("NOMBRES");
		lblNombres.setForeground(Color.BLACK);
		lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblNombres.setBounds(15, 104, 75, 14);
		getContentPane().add(lblNombres);

		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblApellidos.setBounds(15, 144, 75, 14);
		getContentPane().add(lblApellidos);

		lblTelfono = new JLabel("TEL\u00C9FONO");
		lblTelfono.setForeground(Color.BLACK);
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblTelfono.setBounds(15, 184, 75, 14);
		getContentPane().add(lblTelfono);

		lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.BLACK);
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblDni.setBounds(15, 224, 75, 14);
		getContentPane().add(lblDni);

		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setBackground(Color.DARK_GRAY);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setOpaque(true);
		lblMensaje.setBounds(15, 11, 342, 29);
		getContentPane().add(lblMensaje);

		btnGuardarPacientes = new JButton("GUARDAR PACIENTES");
		btnGuardarPacientes.addActionListener(this);
		btnGuardarPacientes.setForeground(Color.BLACK);
		btnGuardarPacientes.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnGuardarPacientes.setBackground(new Color(0, 250, 154));
		btnGuardarPacientes.setBounds(39, 418, 302, 39);
		ds.setCurvasButton(btnGuardarPacientes, "imagenes/grabar.png");
		getContentPane().add(btnGuardarPacientes);

		filtro = new JTextField();
		filtro.addKeyListener(this);
		filtro.setHorizontalAlignment(SwingConstants.CENTER);
		filtro.setForeground(Color.BLACK);
		filtro.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		filtro.setColumns(10);
		filtro.setBounds(556, 57, 257, 29);
		getContentPane().add(filtro);

		rdbtnApellidos = new JRadioButton("APELLIDOS");
		rdbtnApellidos.addActionListener(this);
		rdbtnApellidos.setSelected(true);
		rdbtnApellidos.setBounds(606, 32, 97, 23);
		getContentPane().add(rdbtnApellidos);

		rdbtnDni = new JRadioButton("DNI");
		rdbtnDni.addActionListener(this);
		rdbtnDni.setBounds(715, 32, 60, 23);
		getContentPane().add(rdbtnDni);

		bp = new ButtonGroup();
		bp.add(rdbtnApellidos);
		bp.add(rdbtnDni);

		lblBuscarPor = new JLabel("BUSCAR POR");
		lblBuscarPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscarPor.setForeground(Color.BLACK);
		lblBuscarPor.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblBuscarPor.setBounds(637, 11, 97, 14);
		getContentPane().add(lblBuscarPor);

		listado();
		modeloTabla();
		setLocationRelativeTo(this);
		setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { txtCodigo, txtNombres, txtApellidos, txtTelefono, txtDni }));
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == rdbtnDni) {
			actionPerformedRdbtnDni(arg0);
		}
		if (arg0.getSource() == rdbtnApellidos) {
			actionPerformedRdbtnApellidos(arg0);
		}
		if (arg0.getSource() == btnGuardarPacientes) {
			actionPerformedBtnGuardarPacientes(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando Paciente");
		txtCodigo.setText("" + ap.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.setEditable(false);
		txtNombres.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Paciente");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Paciente");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Paciente");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarPaciente();
	}

	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarPaciente();
				lblMensaje.setText("");
				break;
			case CONSULTAR:
				limpieza();
				habilitarBusqueda(false);
				habilitarOperaciones(true);
				lblMensaje.setText("");
				break;
			case MODIFICAR:
				modificarPaciente();
				lblMensaje.setText("");
				break;
			case ELIMINAR:
				eliminarPaciente();
				lblMensaje.setText("");
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		if (tipoOperacion != ADICIONAR)
			habilitarBusqueda(false);
		lblMensaje.setText("");
		habilitarEntradas(false);
		habilitarOperaciones(true);
	}

	protected void actionPerformedBtnGuardarPacientes(ActionEvent arg0) {
		if (ap.existeArchivo()) {
			int ok = Libreria.confirmacion(this, "¿ Desea actualizar \"" + ap.getArchivo() + "\" ?");
			if (ok == 0) {
				ap.grabarPacientes();
				Libreria.mensajeInformacion(this, "\"" + ap.getArchivo() + "\" ha sido actualizado");
			}
			else
				Libreria.mensajeInformacion(this, "No se actualizó  \"" + ap.getArchivo() + "\"");
		}
		else {
			ap.grabarPacientes();
			Libreria.mensajeInformacion(this, "\"" + ap.getArchivo() + "\" ha sido creado");
		}
	}

	protected void actionPerformedRdbtnApellidos(ActionEvent arg0) {
		filtro.setText("");
		filtro.requestFocus();
	}

	protected void actionPerformedRdbtnDni(ActionEvent arg0) {
		filtro.setText("");
		filtro.requestFocus();
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == filtro) {
			keyReleasedFiltro(arg0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtDni) {
			keyTypedTxtDni(arg0);
		}
		if (arg0.getSource() == txtTelefono) {
			keyTypedTxtTelefono(arg0);
		}
		if (arg0.getSource() == txtApellidos) {
			keyTypedTxtApellidos(arg0);
		}
		if (arg0.getSource() == txtNombres) {
			keyTypedTxtNombres(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigo(arg0);
		}
	}

	protected void keyReleasedFiltro(KeyEvent arg0) {
		filtro.setText(filtro.getText().toUpperCase());

		if (rdbtnApellidos.isSelected()) {
			rf = RowFilter.regexFilter(filtro.getText(), 2);
		}
		else {
			rf = RowFilter.regexFilter(filtro.getText(), 4);
		}
		sorter.setRowFilter(rf);
	}

	protected void keyTypedTxtCodigo(KeyEvent e) {
		Validaciones.soloNumero(e, txtCodigo, 6);

		char t = e.getKeyChar();
		if (t == KeyEvent.VK_ENTER) {
			consultarPaciente();
		}
	}

	protected void keyTypedTxtNombres(KeyEvent e) {
		Validaciones.soloLetras(e, txtNombres, 20);
	}

	protected void keyTypedTxtApellidos(KeyEvent e) {
		Validaciones.soloLetras(e, txtApellidos, 20);
	}

	protected void keyTypedTxtTelefono(KeyEvent e) {
		Validaciones.soloNumero(e, txtTelefono, 9);
	}

	protected void keyTypedTxtDni(KeyEvent e) {
		Validaciones.soloNumero(e, txtDni, 8);
	}

	// Métodos tipo void sin parámetros
	void modeloTabla() {
		TableColumnModel tc = tblPacientes.getColumnModel();
		tc.getColumn(0).setPreferredWidth(50);
		tc.getColumn(1).setPreferredWidth(150);
		tc.getColumn(2).setPreferredWidth(150);
		tc.getColumn(3).setPreferredWidth(100);
		tc.getColumn(4).setPreferredWidth(100);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
		tc.getColumn(3).setCellRenderer(tcr);
		tc.getColumn(4).setCellRenderer(tcr);
	}

	void listado() {
		for (int i = 0; i < tblPacientes.getRowCount(); i++) {
			dtm.removeRow(i);
			i--;
		}

		if (ap.tamaño() == 0) {
		}
		else {
			for (int i = 0; i < ap.tamaño(); i++) {
				Paciente x = ap.obtener(i);
				dtm.addRow(new Object[] { x.getCodpaciente(), x.getNombres().toUpperCase(),
						x.getApellidos().toUpperCase(), x.getTelefono(), x.getDNI() });
			}
		}

	}

	void limpieza() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
	}

	void adicionarPaciente() {
		if (leerNombres().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su NOMBRE");
			txtNombres.requestFocus();
		}
		else if (leerApellidos().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su APELLIDO");
			txtApellidos.setText("");
			txtApellidos.requestFocus();
		}
		else if (leerTelefono().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su TELÉFONO");
			txtTelefono.setText("");
			txtTelefono.requestFocus();
		}
		else if (leerDni().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su DNI");
			txtDni.setText("");
			txtDni.requestFocus();
		}
		else if (validarDni()) {
			Libreria.mensajeAdvertencia(this, "El DNI que ingresó ya existe");
			txtDni.setText("");
			txtDni.requestFocus();
		}
		else {
			Paciente nuevo = new Paciente(leerCodigo(), leerApellidos(), leerNombres(), leerTelefono(), leerDni());
			ap.adicionar(nuevo);
			listado();
			habilitarEntradas(false);
			habilitarOperaciones(true);
		}
	}

	void consultarPaciente() {

		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Paciente");
			txtCodigo.requestFocus();
		}
		else {
			Paciente x = ap.buscar(leerCodigo());
			if (x != null) {
				txtNombres.setText(x.getNombres().toUpperCase());
				txtApellidos.setText(x.getApellidos().toUpperCase());
				txtTelefono.setText(x.getTelefono());
				txtDni.setText(x.getDNI());
			}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				limpieza();
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	void modificarPaciente() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Paciente");
			txtCodigo.requestFocus();
		}
		else {
			Paciente x = ap.buscar(leerCodigo());
			if (x != null)
				if (leerNombres().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó su NOMBRE");
					txtNombres.requestFocus();
				}
				else if (leerApellidos().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó su APELLIDO");
					txtApellidos.setText("");
					txtApellidos.requestFocus();
				}
				else if (leerTelefono().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó su TELÉFONO");
					txtTelefono.setText("");
					txtTelefono.requestFocus();
				}
				else if (leerDni().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó su DNI");
					txtDni.setText("");
					txtDni.requestFocus();
				}
				else if (validarDni()) {
					Libreria.mensajeAdvertencia(this, "El DNI que ingresó ya existe");
					txtDni.setText("");
					txtDni.requestFocus();
				}
				else {
					x.setNombres(leerNombres());
					x.setApellidos(leerApellidos());
					x.setTelefono(leerTelefono());
					x.setDNI(leerDni());
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

	void eliminarPaciente() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Paciente");
			txtCodigo.requestFocus();
		}
		else {
			Paciente x = ap.buscar(leerCodigo());
			if (x != null) {
				ap.eliminar(x);
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
		txtTelefono.setEditable(sino);
		txtDni.setEditable(sino);
		txtCodigo.setEditable(sino);
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
		String columnas[] = new String[] { "CODIGO", "NOMBRES", "APELLIDOS", "TELEFONO", "DNI" };
		return columnas;
	}

	boolean validarDni() {
		Paciente p;
		for (int i = 0; i < ap.tamaño(); i++) {
			p = ap.obtener(i);
			if (p.getCodpaciente() != leerCodigo()) {
				if (p.getDNI().equals(leerDni())) {
					return true;
				}
			}
			else {
				if (p.getDNI().equals(leerDni())) {
					return false;
				}
			}
		}
		return false;
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

	String leerTelefono() {
		return Libreria.leerCadena(txtTelefono);
	}

	String leerDni() {
		return Libreria.leerCadena(txtDni);
	}
}
