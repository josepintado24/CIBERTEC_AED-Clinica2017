package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloCamas;
import clases.Camas;
import libreria.DiseñoObjetos;
import libreria.Validaciones;
import libreria.Libreria;

import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class DlgCamas extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNroCama;
	private JLabel lblCategoria;
	private JLabel lblPrecioPorDia;
	private JTextField txtPrecioxDia;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtNroCama;
	private JLabel lblEstado;
	private JComboBox<String> cboCategoria;
	private JComboBox<String> cboEstado;
	private JScrollPane scpMedicamentos;
	private JLabel lblMensaje;
	private JButton btnGrabarCamas;
	private JTable jtblCamas;

	private ButtonGroup bp;

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
	ArregloCamas ac = new ArregloCamas("camas.txt");
	// Declaración global de libreria Validaciones
	Validaciones v = new Validaciones();
	// Declaración global de libreria DiseñoObjetos
	DiseñoObjetos ds = new DiseñoObjetos();
	// Declaración global de libreria
	Libreria lb = new Libreria();
	private JRadioButton rdbtnLibre;
	private JRadioButton rdbtnOcupado;
	private JRadioButton rdbtnTodo;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgCamas dialog = new DlgCamas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgCamas() {
		setModal(true);
		setResizable(false);
		setTitle("MANTENIMIENTO | CAMAS");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNroCama = new JLabel("NRO CAMA");
		lblNroCama.setForeground(Color.BLACK);
		lblNroCama.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNroCama.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblNroCama.setBounds(10, 59, 110, 14);
		contentPane.add(lblNroCama);

		lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCategoria.setBounds(10, 99, 110, 14);
		contentPane.add(lblCategoria);

		lblPrecioPorDia = new JLabel("PRECIO POR D\u00CDA");
		lblPrecioPorDia.setForeground(Color.BLACK);
		lblPrecioPorDia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioPorDia.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblPrecioPorDia.setBounds(10, 137, 110, 14);
		contentPane.add(lblPrecioPorDia);

		lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblEstado.setBounds(25, 181, 95, 14);
		contentPane.add(lblEstado);

		txtPrecioxDia = new JTextField();
		txtPrecioxDia.addKeyListener(this);
		txtPrecioxDia.setForeground(Color.BLACK);
		txtPrecioxDia.setFont(new Font("Arial", Font.BOLD, 12));
		txtPrecioxDia.setEditable(false);
		txtPrecioxDia.setBounds(130, 130, 86, 29);
		contentPane.add(txtPrecioxDia);
		txtPrecioxDia.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 219, -394, -54);
		contentPane.add(scrollPane);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setIcon(new ImageIcon(DlgCamas.class.getResource("/imagenes/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnBuscar.setEnabled(false);
		btnBuscar.setBackground(new Color(102, 205, 170));
		btnBuscar.setBounds(217, 52, 110, 29);
		ds.setCurvasButton(btnBuscar, "imagenes/buscar.png");
		contentPane.add(btnBuscar);

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAdicionar.setBackground(new Color(124, 252, 0));
		btnAdicionar.setBounds(23, 227, 137, 39);
		ds.setCurvasButton(btnAdicionar, "imagenes/adicionar.png");
		contentPane.add(btnAdicionar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnConsultar.setBackground(Color.CYAN);
		btnConsultar.setBounds(170, 227, 145, 39);
		ds.setCurvasButton(btnConsultar, "imagenes/consultar.png");
		contentPane.add(btnConsultar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnModificar.setBackground(new Color(0, 139, 139));
		btnModificar.setBounds(170, 277, 145, 39);
		ds.setCurvasButton(btnModificar, "imagenes/modificar.png");
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(127, 255, 212));
		btnEliminar.setBounds(23, 277, 137, 39);
		ds.setCurvasButton(btnEliminar, "imagenes/eliminar.png");
		contentPane.add(btnEliminar);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAceptar.setEnabled(false);
		btnAceptar.setBackground(new Color(30, 144, 255));
		btnAceptar.setBounds(23, 327, 137, 39);
		ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
		contentPane.add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnCancelar.setEnabled(false);
		btnCancelar.setBackground(new Color(0, 255, 255));
		btnCancelar.setBounds(170, 327, 145, 39);
		ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
		contentPane.add(btnCancelar);

		txtNroCama = new JTextField();
		txtNroCama.addKeyListener(this);
		txtNroCama.setForeground(Color.BLACK);
		txtNroCama.setFont(new Font("Arial", Font.BOLD, 12));
		txtNroCama.setEditable(false);
		txtNroCama.setColumns(10);
		txtNroCama.setBounds(130, 52, 70, 29);
		contentPane.add(txtNroCama);

		cboCategoria = new JComboBox<String>();
		cboCategoria.setEnabled(false);
		cboCategoria.setForeground(Color.BLACK);
		cboCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		cboCategoria.setBounds(130, 92, 161, 29);
		cboCategoria.addItem("ECONÓMICO");
		cboCategoria.addItem("EJECUTIVO");
		contentPane.add(cboCategoria);

		cboEstado = new JComboBox<String>();
		cboEstado.setEnabled(false);
		cboEstado.setForeground(Color.BLACK);
		cboEstado.setFont(new Font("Arial", Font.BOLD, 12));
		cboEstado.setBounds(130, 174, 161, 29);
		cboEstado.addItem("LIBRE");
		cboEstado.addItem("OCUPADO");
		contentPane.add(cboEstado);

		scpMedicamentos = new JScrollPane();
		scpMedicamentos.setBounds(336, 43, 430, 373);
		contentPane.add(scpMedicamentos);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblCamas = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}

		};
		jtblCamas.setFont(new Font("Arial", Font.BOLD, 14));
		jtblCamas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtblCamas.setRowHeight(25);
		scpMedicamentos.setViewportView(jtblCamas);

		lblMensaje = new JLabel("");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setBackground(Color.DARK_GRAY);
		lblMensaje.setBounds(10, 12, 316, 29);
		contentPane.add(lblMensaje);

		btnGrabarCamas = new JButton("GRABAR CAMAS");
		btnGrabarCamas.addActionListener(this);
		btnGrabarCamas.setBounds(25, 377, 290, 39);
		btnGrabarCamas.setForeground(Color.BLACK);
		btnGrabarCamas.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnGrabarCamas.setBackground(new Color(0, 250, 154));
		ds.setCurvasButton(btnGrabarCamas, "imagenes/grabar.png");
		contentPane.add(btnGrabarCamas);

		rdbtnLibre = new JRadioButton("LIBRE");
		rdbtnLibre.addActionListener(this);
		rdbtnLibre.setSelected(true);
		rdbtnLibre.setForeground(Color.BLACK);
		rdbtnLibre.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnLibre.setBackground(Color.WHITE);
		rdbtnLibre.setBounds(427, 12, 70, 23);
		contentPane.add(rdbtnLibre);

		rdbtnOcupado = new JRadioButton("OCUPADO");
		rdbtnOcupado.addActionListener(this);
		rdbtnOcupado.setForeground(Color.BLACK);
		rdbtnOcupado.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnOcupado.setBackground(Color.WHITE);
		rdbtnOcupado.setBounds(499, 12, 103, 23);
		contentPane.add(rdbtnOcupado);

		rdbtnTodo = new JRadioButton("TODO");
		rdbtnTodo.addActionListener(this);
		rdbtnTodo.setForeground(Color.BLACK);
		rdbtnTodo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnTodo.setBackground(Color.WHITE);
		rdbtnTodo.setBounds(604, 12, 70, 23);
		contentPane.add(rdbtnTodo);

		bp = new ButtonGroup();
		bp.add(rdbtnLibre);
		bp.add(rdbtnOcupado);
		bp.add(rdbtnTodo);

		modeloTabla();
		listadoLibre();
		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == rdbtnTodo) {
			actionPerformedRdbtnTodo(arg0);
		}
		if (arg0.getSource() == rdbtnOcupado) {
			actionPerformedRdbtnOcupado(arg0);
		}
		if (arg0.getSource() == rdbtnLibre) {
			actionPerformedRdbtnLibre(arg0);
		}
		if (arg0.getSource() == btnGrabarCamas) {
			actionPerformedBtnGrabarCamas(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}

	protected void actionPerformedRdbtnLibre(ActionEvent arg0) {
		listadoLibre();
	}

	protected void actionPerformedRdbtnOcupado(ActionEvent arg0) {
		listadoOcupado();
	}

	protected void actionPerformedRdbtnTodo(ActionEvent arg0) {
		listado();
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando camas");
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtNroCama.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando camas");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		cboEstado.setEnabled(false);
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando camas");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando camas");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		cboEstado.setEnabled(false);
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarCama();
	}

	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarCama();
				break;
			case CONSULTAR:
				limpieza();
				habilitarBusqueda(false);
				habilitarOperaciones(true);
				break;
			case MODIFICAR:
				modificarCama();
				break;
			case ELIMINAR:
				eliminarCama();
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		if (tipoOperacion != ADICIONAR)
			habilitarBusqueda(false);
		lblMensaje.setText("");
		habilitarEntradas(false);
		habilitarOperaciones(true);
	}

	protected void actionPerformedBtnGrabarCamas(ActionEvent arg0) {
		if (ac.existeArchivo()) {
			int ok = Libreria.confirmacion(this, "¿ Desea actualizar \"" + ac.getArchivo() + "\" ?");
			if (ok == 0) {
				ac.grabarCamas();
				Libreria.mensajeInformacion(this, "\"" + ac.getArchivo() + "\" ha sido actualizado");
			}
			else
				Libreria.mensajeInformacion(this, "No se actualizó  \"" + ac.getArchivo() + "\"");
		}
		else {
			ac.grabarCamas();
			Libreria.confirmacion(this, "\"" + ac.getArchivo() + "\" ha sido creado");
		}
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtPrecioxDia) {
			keyTypedTxtPrecioxDia(arg0);
		}
		if (arg0.getSource() == txtNroCama) {
			keyTypedTxtNroCama(arg0);
		}
	}

	protected void keyTypedTxtNroCama(KeyEvent e) {
		Validaciones.soloNumero(e, txtNroCama, 5);

		char t = e.getKeyChar();
		if (t == KeyEvent.VK_ENTER && tipoOperacion != ADICIONAR)
			consultarCama();
	}

	protected void keyTypedTxtPrecioxDia(KeyEvent e) {
		Validaciones.numeroReal(txtPrecioxDia, e, 5);
	}

	// Métodos tipo void sin parámetros
	void modeloTabla() {
		TableColumnModel tc = jtblCamas.getColumnModel();
		tc.getColumn(0).setPreferredWidth(100);
		tc.getColumn(1).setPreferredWidth(150);
		tc.getColumn(2).setPreferredWidth(150);
		tc.getColumn(3).setPreferredWidth(100);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
		tc.getColumn(1).setCellRenderer(tcr);
		tc.getColumn(3).setCellRenderer(tcr);

		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tc.getColumn(2).setCellRenderer(tcr);
	}

	void listado() {
		Libreria.limpiarJTable(jtblCamas, dtm);
		for (int i = 0; i < ac.tamaño(); i++) {
			Camas x = ac.obtener(i);
			dtm.addRow(new Object[] { x.getNroCama(), getCategoria(x.getCategoria()),
					String.format("%.2f", x.getPrecioxDia()), getEstado(x.getEstado()) });
		}
	}

	void listadoLibre() {
		Libreria.limpiarJTable(jtblCamas, dtm);
		for (int i = 0; i < ac.tamaño(); i++) {
			Camas x = ac.obtener(i);
			if (x.getEstado() == 0) {
				dtm.addRow(new Object[] { x.getNroCama(), getCategoria(x.getCategoria()),
						String.format("%.2f", x.getPrecioxDia()), getEstado(x.getEstado()) });
			}
		}
	}

	void listadoOcupado() {
		Libreria.limpiarJTable(jtblCamas, dtm);
		for (int i = 0; i < ac.tamaño(); i++) {
			Camas x = ac.obtener(i);
			if (x.getEstado() == 1) {
				dtm.addRow(new Object[] { x.getNroCama(), getCategoria(x.getCategoria()),
						String.format("%.2f", x.getPrecioxDia()), getEstado(x.getEstado()) });
			}
		}
	}

	void actualizarTabla() {
		if (rdbtnLibre.isSelected()) {
			listadoLibre();
		}
		else if (rdbtnOcupado.isSelected()) {
			listadoOcupado();
		}
		else {
			listado();
		}
	}

	void limpieza() {
		txtNroCama.setText("");
		txtPrecioxDia.setText("");
		cboCategoria.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
	}

	void adicionarCama() {
		if (leerNroCama() < 0) {
			Libreria.mensajeAdvertencia(this, "No ingresó el NRO DE CAMA");
			txtNroCama.requestFocus();
		}
		else if (leerPrecioxDia() < 0.0) {
			Libreria.mensajeAdvertencia(this, "No ingresó el PRECIO POR DÍA");
			txtPrecioxDia.setText("");
			txtPrecioxDia.requestFocus();
		}
		else {
			int c = 0;

			for (int i = 0; i < ac.tamaño(); i++) {
				if (ac.obtener(i).getNroCama() == leerNroCama()) {
					c++;
				}
			}

			if (c > 0) {
				Libreria.mensajeAdvertencia(this, "El NRO DE CAMA ya existe");
				txtNroCama.setText("");
				txtNroCama.requestFocus();
			}
			else {
				Camas nuevo = new Camas(leerNroCama(), leerCategoria(), leerPrecioxDia(), leerEstado());
				ac.adicionar(nuevo);
				lblMensaje.setText("");
				actualizarTabla();
				habilitarEntradas(false);
				habilitarOperaciones(true);
			}
		}
	}

	void consultarCama() {
		int nro = leerNroCama();

		if (nro == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el NRO DE CAMA");
			txtNroCama.requestFocus();
		}
		else {
			Camas x = ac.buscar(leerNroCama());
			if (x != null) {
				txtNroCama.setText("" + x.getNroCama());
				txtPrecioxDia.setText("" + x.getPrecioxDia());
				cboCategoria.setSelectedIndex(x.getCategoria());
				cboEstado.setSelectedIndex(x.getEstado());
			}
			else {
				Libreria.mensajeAdvertencia(this, "El número " + leerNroCama() + " no existe");
				limpieza();
				lblMensaje.setText("");
				txtNroCama.setText("");
				txtNroCama.requestFocus();
			}
		}
	}

	void modificarCama() {
		int nro = leerNroCama();

		if (nro == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el NRO DE CAMA");
			txtNroCama.requestFocus();
		}
		else {
			Camas x = ac.buscar(leerNroCama());
			if (x != null)
				if (leerNroCama() < 0) {
					Libreria.mensajeAdvertencia(this, "No ingresó el NRO DE CAMA");
					txtNroCama.requestFocus();
				}
				else if (leerPrecioxDia() < 0.0) {
					Libreria.mensajeAdvertencia(this, "No ingresó el PRECIO POR DÍA");
					txtPrecioxDia.setText("");
					txtPrecioxDia.requestFocus();
				}
				else {
					lblMensaje.setText("");
					x.setCategoria(leerCategoria());
					x.setPrecioxDia(leerPrecioxDia());
					x.setEstado(leerEstado());
					actualizarTabla();
					habilitarBusqueda(false);
					habilitarEntradas(false);
					habilitarOperaciones(true);
				}
			else {
				Libreria.mensajeAdvertencia(this, "El NRO " + leerNroCama() + " no existe");
				txtNroCama.setText("");
				txtNroCama.requestFocus();
			}
		}
	}

	void eliminarCama() {
		int nro = leerNroCama();

		if (nro == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el NRO DE CAMA");
			txtNroCama.requestFocus();
		}
		else {
			Camas x = ac.buscar(leerNroCama());
			if (x != null) {
				lblMensaje.setText("");
				ac.eliminar(x);
				actualizarTabla();
				limpieza();
				habilitarBusqueda(false);
				habilitarOperaciones(true);
			}
			else {
				Libreria.mensajeAdvertencia(this, "El NRO " + leerNroCama() + " no existe");
				txtNroCama.setText("");
				txtNroCama.requestFocus();
			}
		}
	}

	// Métodos tipo void con parámetros
	void habilitarBusqueda(boolean sino) {
		btnBuscar.setEnabled(sino);
		txtNroCama.setEditable(sino);
		if (sino)
			txtNroCama.requestFocus();
	}

	void habilitarEntradas(boolean sino) {
		if (!sino)
			limpieza();
		txtNroCama.setEditable(sino);
		txtPrecioxDia.setEditable(sino);
		cboCategoria.setEnabled(sino);
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
		String columnas[] = new String[] { "NRO CAMA", "CATEGORIA", "PRECIO POR DÍA", "ESTADO" };
		return columnas;
	}

	int leerNroCama() {
		return Libreria.leerEntero(txtNroCama);
	}

	int leerCategoria() {
		return cboCategoria.getSelectedIndex();
	}

	double leerPrecioxDia() {
		return Libreria.leerReal(txtPrecioxDia);
	}

	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}

	// Métodos que retornan valor con parámetros
	String getEstado(int est) {
		if (est == 0) {
			return "LIBRE";
		}
		else {
			return "OCUPADO";
		}
	}

	String getCategoria(int est) {
		if (est == 0) {
			return "ECONÓMICO";
		}
		else {
			return "EJECUTIVO";
		}
	}
}
