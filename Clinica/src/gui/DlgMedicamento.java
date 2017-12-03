package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloMedicamento;
import clases.Medicamentos;
import libreria.DiseñoObjetos;
import libreria.Libreria;
import libreria.Validaciones;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class DlgMedicamento extends JDialog implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblLaboratorio;
	private JLabel lblPrecio;
	private JLabel lblStock;
	private JTextField txtNombre;
	private JTextField txtLaboratorio;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JScrollPane scrollPane;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JScrollPane scpMedicamentos;
	public JButton btnAdicionar;
	public JButton btnConsultar;
	public JButton btnModificar;
	public JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblMensaje;
	public JButton btnGuardarMedicamentos;
	private JTable jtblMedicamentos;
	private int x;
	private int y;

	// Declaración global para modelo de tabla
	private DefaultTableModel dtm;

	/*
	 * Tipo de operación a procesar: Adicionar, Modificar, Eliminar o Consultar
	 */
	private int tipoOperacion;
	/* Variables globales para realizar venta */
	public int cantidadVender = 0;
	public String nombreProducto = "";
	public double precioProducto = 0.0;
	public String codigoProducto = "";
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR = 2;
	public final static int CONSULTAR = 3;
	// Declaración global
	ArregloMedicamento am = new ArregloMedicamento("medicamentos.txt");
	// Declaración global de libreria Validaciones
	Validaciones v = new Validaciones();
	// Declaración global de libreria DiseñoObjetos
	DiseñoObjetos ds = new DiseñoObjetos();
	// Declaración global de libreria
	Libreria lb = new Libreria();
	private JPanel panel;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgMedicamento dialog = new DlgMedicamento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMedicamento() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setTitle("MANTENIMIENTO | MEDICAMENTOS");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1038, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 13));
		lblCodigo.setBounds(13, 116, 86, 14);
		contentPane.add(lblCodigo);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombre.setBounds(0, 155, 99, 14);
		contentPane.add(lblNombre);

		lblLaboratorio = new JLabel("LABORATORIO");
		lblLaboratorio.setForeground(Color.BLACK);
		lblLaboratorio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLaboratorio.setFont(new Font("Arial", Font.BOLD, 13));
		lblLaboratorio.setBounds(0, 193, 99, 14);
		contentPane.add(lblLaboratorio);

		lblPrecio = new JLabel("PRECIO");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 13));
		lblPrecio.setBounds(12, 233, 89, 14);
		contentPane.add(lblPrecio);

		lblStock = new JLabel("STOCK");
		lblStock.setForeground(Color.BLACK);
		lblStock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStock.setFont(new Font("Arial", Font.BOLD, 13));
		lblStock.setBounds(23, 273, 76, 14);
		contentPane.add(lblStock);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Arial", Font.BOLD, 14));
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setBounds(111, 148, 270, 29);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtLaboratorio = new JTextField();
		txtLaboratorio.addKeyListener(this);
		txtLaboratorio.setEditable(false);
		txtLaboratorio.setFont(new Font("Arial", Font.BOLD, 14));
		txtLaboratorio.setForeground(Color.BLACK);
		txtLaboratorio.setBounds(111, 186, 270, 29);
		contentPane.add(txtLaboratorio);
		txtLaboratorio.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setEditable(false);
		txtPrecio.setFont(new Font("Arial", Font.BOLD, 14));
		txtPrecio.setForeground(Color.BLACK);
		txtPrecio.setBounds(111, 226, 76, 29);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtStock = new JTextField();
		txtStock.addKeyListener(this);
		txtStock.setEditable(false);
		txtStock.setFont(new Font("Arial", Font.BOLD, 14));
		txtStock.setForeground(Color.BLACK);
		txtStock.setBounds(111, 266, 76, 29);
		contentPane.add(txtStock);
		txtStock.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 276, -394, -54);
		contentPane.add(scrollPane);

		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		txtCodigo.setForeground(Color.BLACK);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(111, 109, 126, 29);
		contentPane.add(txtCodigo);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnBuscar.setEnabled(false);
		btnBuscar.setBackground(new Color(102, 205, 170));
		btnBuscar.setBounds(271, 109, 110, 29);
		ds.setCurvasButton(btnBuscar, "imagenes/buscar.png");
		contentPane.add(btnBuscar);

		scpMedicamentos = new JScrollPane();
		scpMedicamentos.setBounds(391, 68, 631, 436);
		contentPane.add(scpMedicamentos);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblMedicamentos = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}

		};
		jtblMedicamentos.addMouseListener(this);
		jtblMedicamentos.setForeground(Color.BLACK);
		jtblMedicamentos.setFont(new Font("Arial", Font.BOLD, 14));
		jtblMedicamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtblMedicamentos.setRowHeight(25);
		scpMedicamentos.setViewportView(jtblMedicamentos);

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAdicionar.setBackground(new Color(124, 252, 0));
		btnAdicionar.setBounds(42, 317, 137, 39);
		ds.setCurvasButton(btnAdicionar, "imagenes/adicionar.png");
		contentPane.add(btnAdicionar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnConsultar.setBackground(Color.CYAN);
		btnConsultar.setBounds(199, 317, 145, 39);
		ds.setCurvasButton(btnConsultar, "imagenes/consultar.png");
		contentPane.add(btnConsultar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnModificar.setBackground(new Color(0, 139, 139));
		btnModificar.setBounds(199, 367, 145, 39);
		ds.setCurvasButton(btnModificar, "imagenes/modificar.png");
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(127, 255, 212));
		btnEliminar.setBounds(42, 367, 137, 39);
		ds.setCurvasButton(btnEliminar, "imagenes/eliminar.png");
		contentPane.add(btnEliminar);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAceptar.setEnabled(false);
		btnAceptar.setBackground(new Color(30, 144, 255));
		btnAceptar.setBounds(42, 417, 137, 39);
		ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
		contentPane.add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnCancelar.setEnabled(false);
		btnCancelar.setBackground(new Color(0, 255, 255));
		btnCancelar.setBounds(199, 417, 145, 39);
		ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
		contentPane.add(btnCancelar);

		lblMensaje = new JLabel("");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setBackground(Color.DARK_GRAY);
		lblMensaje.setBounds(10, 68, 376, 29);
		contentPane.add(lblMensaje);

		btnGuardarMedicamentos = new JButton("GUARDAR MEDICAMENTOS");
		btnGuardarMedicamentos.addActionListener(this);
		btnGuardarMedicamentos.setForeground(Color.BLACK);
		btnGuardarMedicamentos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnGuardarMedicamentos.setBackground(new Color(0, 250, 154));
		btnGuardarMedicamentos.setBounds(42, 465, 302, 39);
		ds.setCurvasButton(btnGuardarMedicamentos, "imagenes/grabar.png");
		contentPane.add(btnGuardarMedicamentos);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
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
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBounds(0, 0, 1038, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Icon m = new ImageIcon(getClass().getResource("/image/ADVERTENCIA.png"));
		  		int dialog = JOptionPane.YES_NO_OPTION;
		 		int result1 =JOptionPane.showConfirmDialog(null, "¿Desea Volver a la Ventana Principal?","Abvertencia",dialog,dialog,m);
		 	
		  		
		  		if(result1 ==0){
		  			dispose();
		 			Principal frame = new Principal();
		 			frame.setVisible(true);
		  		}
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/image/icons8_Return_32px.png")));
		label.setBounds(992, 0, 46, 39);
		panel.add(label);
		
		JLabel lblMedicament = new JLabel("Medicamento");
		lblMedicament.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMedicament.setFont(new Font("Decker", Font.PLAIN, 16));
		lblMedicament.setBounds(34, 0, 107, 39);
		panel.add(lblMedicament);

		listado();
		modeloTabla();
		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardarMedicamentos) {
			actionPerformedBtnGuardarMedicamentos(arg0);
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

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando Medicamento");
		txtCodigo.setText("" + am.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.setEditable(false);
		txtNombre.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Medicamento");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Medicamento");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Medicamento");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarMedicamento();
	}

	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarMedicamento();
				lblMensaje.setText("");
				break;
			case CONSULTAR:
				limpieza();
				habilitarBusqueda(false);
				habilitarOperaciones(true);
				lblMensaje.setText("");
				break;
			case MODIFICAR:
				modificarMedicamento();
				lblMensaje.setText("");
				break;
			case ELIMINAR:
				eliminarMedicamento();
				lblMensaje.setText("");
		}
	}

	protected void actionPerformedBtnGuardarMedicamentos(ActionEvent arg0) {
		if (am.existeArchivo()) {
			int ok = Libreria.confirmacion(this, "¿ Desea actualizar \"" + am.getArchivo() + "\" ?");
			if (ok == 0) {
				am.grabarMedicamentos();
				Libreria.mensajeInformacion(this, "\"" + am.getArchivo() + "\" ha sido actualizado");
			}
			else
				Libreria.mensajeInformacion(this, "No se actualizó  \"" + am.getArchivo() + "\"");
		}
		else {
			am.grabarMedicamentos();
			Libreria.mensajeInformacion(this, "\"" + am.getArchivo() + "\" ha sido creado");
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		if (tipoOperacion != ADICIONAR)
			habilitarBusqueda(false);
		lblMensaje.setText("");
		habilitarEntradas(false);
		habilitarOperaciones(true);
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtStock) {
			keyTypedTxtStock(arg0);
		}
		if (arg0.getSource() == txtPrecio) {
			keyTypedTxtPrecio(arg0);
		}
		if (arg0.getSource() == txtLaboratorio) {
			keyTypedTxtLaboratorio(arg0);
		}
		if (arg0.getSource() == txtNombre) {
			keyTypedTxtNombre(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigo(arg0);
		}
	}

	protected void keyTypedTxtCodigo(KeyEvent e) {
		Validaciones.soloNumero(e, txtCodigo, 5);

		char t = e.getKeyChar();
		if (t == KeyEvent.VK_ENTER) {
			consultarMedicamento();
		}
	}

	protected void keyTypedTxtNombre(KeyEvent e) {
		Validaciones.cadenaTexto(e, txtNombre, 20);
	}

	protected void keyTypedTxtLaboratorio(KeyEvent e) {
		Validaciones.cadenaTexto(e, txtLaboratorio, 20);
	}

	protected void keyTypedTxtPrecio(KeyEvent e) {
		Validaciones.numeroReal(txtPrecio, e, 5);
	}

	protected void keyTypedTxtStock(KeyEvent e) {
		Validaciones.soloNumero(e, txtStock, 4);
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == jtblMedicamentos) {
			mouseClickedJtblMedicamentos(arg0);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedJtblMedicamentos(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (e.getClickCount() == 2) {
				int row = jtblMedicamentos.rowAtPoint(new Point(e.getX(), e.getY()));

				if (row >= 0) {
					int cant = cantidadaVender();

					if (cant >= 0) {
						if (cant <= Integer.parseInt(jtblMedicamentos.getValueAt(row, 4).toString())) {
							cantidadVender = cant;
							precioProducto = Double.parseDouble(jtblMedicamentos.getValueAt(row, 3).toString());
							nombreProducto = jtblMedicamentos.getValueAt(row, 1).toString();
							codigoProducto = jtblMedicamentos.getValueAt(row, 0).toString();
							dispose();
						}
						else {
							Libreria.mensajeInformacion(this,
									"La cantidad a vender es mayor a la cantidad de stock disponible");
						}
					}
					else {
					}
				}
			}
		}
	}

	// Métodos tipo void sin parámetros
	void limpieza() {
		txtNombre.setText("");
		txtCodigo.setText("");
		txtLaboratorio.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
	}

	String[] getColumnas() {
		String columnas[] = new String[] { "CÓDIGO", "NOMBRE", "LABORATORIO", "PRECIO", "STOCK" };
		return columnas;
	}

	void modeloTabla() {
		TableColumnModel tc = jtblMedicamentos.getColumnModel();
		tc.getColumn(0).setPreferredWidth(100);
		tc.getColumn(1).setPreferredWidth(150);
		tc.getColumn(2).setPreferredWidth(150);
		tc.getColumn(3).setPreferredWidth(100);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);

		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tc.getColumn(3).setCellRenderer(tcr);
		tc.getColumn(4).setCellRenderer(tcr);
	}

	void listado() {
		Libreria.limpiarJTable(jtblMedicamentos, dtm);

		if (am.tamaño() == 0) {

		}
		else {
			for (int i = 0; i < am.tamaño(); i++) {
				Medicamentos x = am.obtener(i);

				dtm.addRow(new Object[] { x.getCodMedicamento(), x.getNombre(), x.getLaboratorio(), x.getPrecio(),
						x.getStock() });
			}
		}
	}

	void adicionarMedicamento() {
		if (leerNombre().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó el NOMBRE");
			txtNombre.requestFocus();
		}
		else if (leerLaboratorio().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó el LABORATORIO");
			txtLaboratorio.setText("");
			txtLaboratorio.requestFocus();
		}
		else if (leerPrecio() < 10) {
			Libreria.mensajeAdvertencia(this, "Ingrese el PRECIO de forma correcta");
			txtPrecio.setText("");
			txtPrecio.requestFocus();
		}
		else if (leerStock() < 0) {
			Libreria.mensajeAdvertencia(this, "Ingrese el STOCK de forma correcta");
			txtStock.setText("");
			txtStock.requestFocus();
		}
		else {
			Medicamentos nuevo = new Medicamentos(leerCodigo(), leerNombre(), leerLaboratorio(), leerPrecio(),
					leerStock());
			am.adicionar(nuevo);
			listado();
			habilitarEntradas(false);
			habilitarOperaciones(true);
		}
	}

	void consultarMedicamento() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Paciente");
			txtCodigo.requestFocus();
		}
		else {
			Medicamentos x = am.buscar(leerCodigo());
			if (x != null) {
				txtNombre.setText(x.getNombre());
				txtLaboratorio.setText(x.getLaboratorio());
				txtPrecio.setText("" + x.getPrecio());
				txtStock.setText("" + x.getStock());
			}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				limpieza();
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	void modificarMedicamento() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Medicamento");
			txtCodigo.requestFocus();
		}
		else {
			Medicamentos x = am.buscar(leerCodigo());
			if (x != null)
				if (leerNombre().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó el NOMBRE");
					txtNombre.requestFocus();
				}
				else if (leerLaboratorio().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó el LABORATORIO");
					txtLaboratorio.setText("");
					txtLaboratorio.requestFocus();
				}
				else if (leerPrecio() < 10) {
					Libreria.mensajeAdvertencia(this, "Ingrese el PRECIO de forma correcta");
					txtPrecio.setText("");
					txtPrecio.requestFocus();
				}
				else if (leerStock() < 0) {
					Libreria.mensajeAdvertencia(this, "Ingrese el STOCK de forma correcta");
					txtStock.setText("");
					txtStock.requestFocus();
				}
				else {
					x.setNombre(leerNombre());
					x.setLaboratorio(leerLaboratorio());
					x.setPrecio(leerPrecio());
					x.setStock(leerStock());
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

	void eliminarMedicamento() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del EMPLEADO");
			txtCodigo.requestFocus();
		}
		else {
			Medicamentos x = am.buscar(leerCodigo());
			if (x != null) {
				am.eliminar(x);
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
		txtNombre.setEditable(sino);
		txtCodigo.setEditable(sino);
		txtLaboratorio.setEditable(sino);
		;
		txtPrecio.setEditable(sino);
		txtStock.setEditable(sino);
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
	int cantidadaVender() {
		int cant = -1;
		try {
			cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
		}
		catch (Exception e2) {
		}

		return cant;
	}

	int leerCodigo() {
		return Libreria.leerEntero(txtCodigo);
	}

	String leerNombre() {
		return txtNombre.getText().trim();
	}

	String leerLaboratorio() {
		return txtLaboratorio.getText().trim();
	}

	double leerPrecio() {
		return Libreria.leerReal(txtPrecio);
	}

	int leerStock() {
		return Libreria.leerEntero(txtStock);
	}
}
