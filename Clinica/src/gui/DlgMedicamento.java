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
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

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
	private JScrollPane scrollPane;
	private JScrollPane scpMedicamentos;
	private JLabel lblMensaje;
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

	private JLabel lblIngresar;
	private JLabel lblConsultar;
	private JLabel lblModificar;
	private JLabel lblEliminar;
	private JPanel panel;
	private JLabel lblBuscar;
	private JLabel lblGrabar;
	private JSeparator lineCodigo;
	private JTextField txtCodigo;
	private JLabel iconCodigo;
	private JTextField txtNombre;
	private JLabel iconNombre;
	private JSeparator lineNombre;
	private JSeparator lineLaboratorio;
	private JLabel iconLaboratorio;
	private JTextField txtLaboratorio;
	private JSeparator linePrecio;
	private JLabel iconPrecio;
	private JTextField txtPrecio;
	private JSeparator lineStock;
	private JLabel iconStock;
	private JTextField txtStock;
	private JLabel lblAgregar;
	private JLabel lblCancelar;
=======
	private JPanel panel;
>>>>>>> branch 'master' of https://github.com/josepintado24/ProyectClinica-Cibertec-II.git

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
<<<<<<< HEAD
		setBounds(100, 100, 1266, 785);
=======
		setBounds(100, 100, 1038, 515);
>>>>>>> branch 'master' of https://github.com/josepintado24/ProyectClinica-Cibertec-II.git
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

<<<<<<< HEAD
=======
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

>>>>>>> branch 'master' of https://github.com/josepintado24/ProyectClinica-Cibertec-II.git
		scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 276, -394, -54);
		contentPane.add(scrollPane);

<<<<<<< HEAD
=======
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

>>>>>>> branch 'master' of https://github.com/josepintado24/ProyectClinica-Cibertec-II.git
		scpMedicamentos = new JScrollPane();
<<<<<<< HEAD
		scpMedicamentos.setBounds(21, 211, 631, 436);
=======
		scpMedicamentos.setBounds(391, 68, 631, 436);
>>>>>>> branch 'master' of https://github.com/josepintado24/ProyectClinica-Cibertec-II.git
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

<<<<<<< HEAD
=======
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

>>>>>>> branch 'master' of https://github.com/josepintado24/ProyectClinica-Cibertec-II.git
		lblMensaje = new JLabel("");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setBackground(Color.DARK_GRAY);
<<<<<<< HEAD
		lblMensaje.setBounds(736, 11, 376, 29);
=======
		lblMensaje.setBounds(10, 68, 376, 29);
>>>>>>> branch 'master' of https://github.com/josepintado24/ProyectClinica-Cibertec-II.git
		contentPane.add(lblMensaje);
<<<<<<< HEAD
		
		lblIngresar = new JLabel("INGRESAR");
		lblIngresar.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/ingresarNaranja.png")));
		lblIngresar.addMouseListener(this);
		lblIngresar.setInheritsPopupMenu(false);
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setForeground(new Color(243, 124, 47));
		lblIngresar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIngresar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
		lblIngresar.setBackground(new Color(1, 168, 25));
		lblIngresar.setBounds(16, 79, 169, 37);
		contentPane.add(lblIngresar);
		
		lblConsultar = new JLabel("CONSULTAR");
		lblConsultar.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/consultarNaranja.png")));
		lblConsultar.addMouseListener(this);
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setForeground(new Color(243, 124, 47));
		lblConsultar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblConsultar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
		lblConsultar.setBackground(new Color(1, 168, 25));
		lblConsultar.setBounds(204, 80, 169, 36);
		contentPane.add(lblConsultar);
		
		lblModificar = new JLabel("MODIFICAR");
		lblModificar.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/modificarNaranja.png")));
		lblModificar.addMouseListener(this);
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setForeground(new Color(243, 124, 47));
		lblModificar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblModificar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
		lblModificar.setBackground(new Color(1, 168, 25));
		lblModificar.setBounds(394, 80, 175, 36);
		contentPane.add(lblModificar);
		
		lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/eliminarNaranja.png")));
		lblEliminar.addMouseListener(this);
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(new Color(243, 124, 47));
		lblEliminar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEliminar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
		lblEliminar.setBackground(Color.RED);
		lblEliminar.setBounds(589, 80, 183, 36);
		contentPane.add(lblEliminar);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(761, 160, 409, 582);
		contentPane.add(panel);
		panel.setLayout(null);
				
						lblStock = new JLabel("STOCK");
						lblStock.setBounds(23, 330, 76, 14);
						panel.add(lblStock);
						lblStock.setForeground(Color.BLACK);
						lblStock.setHorizontalAlignment(SwingConstants.RIGHT);
						lblStock.setFont(new Font("Arial", Font.BOLD, 13));
						
								lblPrecio = new JLabel("PRECIO");
								lblPrecio.setBounds(10, 259, 89, 14);
								panel.add(lblPrecio);
								lblPrecio.setForeground(Color.BLACK);
								lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
								lblPrecio.setFont(new Font("Arial", Font.BOLD, 13));
												
														lblLaboratorio = new JLabel("LABORATORIO");
														lblLaboratorio.setBounds(39, 171, 99, 14);
														panel.add(lblLaboratorio);
														lblLaboratorio.setForeground(Color.BLACK);
														lblLaboratorio.setHorizontalAlignment(SwingConstants.RIGHT);
														lblLaboratorio.setFont(new Font("Arial", Font.BOLD, 13));
														
																lblNombre = new JLabel("NOMBRE");
																lblNombre.setBounds(0, 95, 99, 14);
																panel.add(lblNombre);
																lblNombre.setForeground(Color.BLACK);
																lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
																lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
																				
																						lblCodigo = new JLabel("CODIGO");
																						lblCodigo.setBounds(8, 22, 86, 14);
																						panel.add(lblCodigo);
																						lblCodigo.setForeground(Color.BLACK);
																						lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
																						lblCodigo.setFont(new Font("Arial", Font.BOLD, 13));
																														
																														lblBuscar = new JLabel("Buscar");
																														lblBuscar.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/buscar.png")));
																														lblBuscar.addMouseListener(this);
																														lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblBuscar.setForeground(Color.BLACK);
																														lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
																														lblBuscar.setBackground(Color.BLACK);
																														lblBuscar.setBounds(251, 30, 170, 39);
																														panel.add(lblBuscar);
																														
																														lblGrabar = new JLabel("Grabar");
																														lblGrabar.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/save.png")));
																														lblGrabar.addMouseListener(this);
																														lblGrabar.setOpaque(true);
																														lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblGrabar.setForeground(Color.WHITE);
																														lblGrabar.setFont(new Font("Dialog", Font.PLAIN, 18));
																														lblGrabar.setBackground(new Color(231, 96, 90));
																														lblGrabar.setBounds(117, 508, 206, 41);
																														panel.add(lblGrabar);
																														
																														lineCodigo = new JSeparator();
																														lineCodigo.setForeground(Color.BLACK);
																														lineCodigo.setBackground(Color.BLACK);
																														lineCodigo.setBounds(71, 65, 186, 4);
																														panel.add(lineCodigo);
																														
																														txtCodigo = new JTextField();
																														txtCodigo.setOpaque(false);
																														txtCodigo.setHorizontalAlignment(SwingConstants.LEFT);
																														txtCodigo.setForeground(Color.BLACK);
																														txtCodigo.setFont(new Font("Dialog", Font.BOLD, 16));
																														txtCodigo.setEditable(false);
																														txtCodigo.setColumns(10);
																														txtCodigo.setBorder(null);
																														txtCodigo.setBounds(104, 40, 176, 29);
																														panel.add(txtCodigo);
																														
																														iconCodigo = new JLabel("");
																														iconCodigo.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/codigo.png")));
																														iconCodigo.setBounds(71, 36, 26, 36);
																														panel.add(iconCodigo);
																														
																														txtNombre = new JTextField();
																														txtNombre.setOpaque(false);
																														txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
																														txtNombre.setForeground(Color.BLACK);
																														txtNombre.setFont(new Font("Dialog", Font.BOLD, 16));
																														txtNombre.setEditable(false);
																														txtNombre.setColumns(10);
																														txtNombre.setBorder(null);
																														txtNombre.setBounds(126, 108, 257, 29);
																														panel.add(txtNombre);
																														
																														iconNombre = new JLabel("");
																														iconNombre.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/user30.png")));
																														iconNombre.setBounds(80, 110, 35, 27);
																														panel.add(iconNombre);
																														
																														lineNombre = new JSeparator();
																														lineNombre.setForeground(Color.BLACK);
																														lineNombre.setBackground(Color.BLACK);
																														lineNombre.setBounds(80, 140, 186, 4);
																														panel.add(lineNombre);
																														
																														lineLaboratorio = new JSeparator();
																														lineLaboratorio.setForeground(Color.BLACK);
																														lineLaboratorio.setBackground(Color.BLACK);
																														lineLaboratorio.setBounds(67, 228, 206, 2);
																														panel.add(lineLaboratorio);
																														
																														iconLaboratorio = new JLabel("");
																														iconLaboratorio.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/Agregar.png")));
																														iconLaboratorio.setBounds(66, 196, 35, 29);
																														panel.add(iconLaboratorio);
																														
																														txtLaboratorio = new JTextField();
																														txtLaboratorio.setOpaque(false);
																														txtLaboratorio.setHorizontalAlignment(SwingConstants.LEFT);
																														txtLaboratorio.setForeground(Color.BLACK);
																														txtLaboratorio.setFont(new Font("Dialog", Font.BOLD, 16));
																														txtLaboratorio.setEditable(false);
																														txtLaboratorio.setColumns(10);
																														txtLaboratorio.setBorder(null);
																														txtLaboratorio.setBounds(103, 196, 198, 29);
																														panel.add(txtLaboratorio);
																														
																														linePrecio = new JSeparator();
																														linePrecio.setForeground(Color.BLACK);
																														linePrecio.setBackground(Color.BLACK);
																														linePrecio.setBounds(67, 315, 150, 4);
																														panel.add(linePrecio);
																														
																														iconPrecio = new JLabel("");
																														iconPrecio.setBounds(64, 284, 35, 29);
																														panel.add(iconPrecio);
																														
																														txtPrecio = new JTextField();
																														txtPrecio.setOpaque(false);
																														txtPrecio.setHorizontalAlignment(SwingConstants.LEFT);
																														txtPrecio.setForeground(Color.BLACK);
																														txtPrecio.setFont(new Font("Dialog", Font.BOLD, 16));
																														txtPrecio.setEditable(false);
																														txtPrecio.setColumns(10);
																														txtPrecio.setBorder(null);
																														txtPrecio.setBounds(92, 284, 99, 29);
																														panel.add(txtPrecio);
																														
																														lineStock = new JSeparator();
																														lineStock.setForeground(Color.BLACK);
																														lineStock.setBackground(Color.BLACK);
																														lineStock.setBounds(71, 394, 133, 4);
																														panel.add(lineStock);
																														
																														iconStock = new JLabel("");
																														iconStock.setBounds(71, 365, 35, 29);
																														panel.add(iconStock);
																														
																														txtStock = new JTextField();
																														txtStock.setOpaque(false);
																														txtStock.setHorizontalAlignment(SwingConstants.LEFT);
																														txtStock.setForeground(Color.BLACK);
																														txtStock.setFont(new Font("Dialog", Font.BOLD, 16));
																														txtStock.setEditable(false);
																														txtStock.setColumns(10);
																														txtStock.setBorder(null);
																														txtStock.setBounds(104, 365, 76, 29);
																														panel.add(txtStock);
																														
																														lblAgregar = new JLabel("Agregar");
																														lblAgregar.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/Agregar.png")));
																														lblAgregar.addMouseListener(this);
																														lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblAgregar.setForeground(Color.BLACK);
																														lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
																														lblAgregar.setBackground(Color.YELLOW);
																														lblAgregar.setBounds(104, 408, 206, 39);
																														panel.add(lblAgregar);
																														
																														lblCancelar = new JLabel("Cancelar");
																														lblCancelar.setIcon(new ImageIcon(DlgMedicamento.class.getResource("/iconBotones/regreso.png")));
																														lblCancelar.addMouseListener(this);
																														lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblCancelar.setForeground(Color.BLACK);
																														lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
																														lblCancelar.setBounds(104, 458, 206, 39);
																														panel.add(lblCancelar);
=======

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
>>>>>>> branch 'master' of https://github.com/josepintado24/ProyectClinica-Cibertec-II.git

		listado();
		modeloTabla();
		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblBuscar) {
			mouseClickedLblBuscar(arg0);
		}
		if (arg0.getSource() == lblCancelar) {
			mouseClickedLblCancelar(arg0);
		}
		if (arg0.getSource() == lblGrabar) {
			mouseClickedLblGrabar(arg0);
		}
		if (arg0.getSource() == lblAgregar) {
			mouseClickedLblAgregar(arg0);
		}
		if (arg0.getSource() == lblEliminar) {
			mouseClickedLblEliminar(arg0);
		}
		if (arg0.getSource() == lblModificar) {
			mouseClickedLblModificar(arg0);
		}
		if (arg0.getSource() == lblConsultar) {
			mouseClickedLblConsultar(arg0);
		}
		if (arg0.getSource() == lblIngresar) {
			mouseClickedLblIngresar(arg0);
		}
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
				if ((tipoOperacion != CONSULTAR)&&(tipoOperacion != ADICIONAR)){
					lblAgregar.setVisible(true);
					lblGrabar.setVisible(true);
				}
			
			noVisibleNombre();
			noVisibleLaboratorio();
			noVisiblePrecio();
			noVisibleStock();
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
		lblBuscar.setVisible(sino);
		txtCodigo.setVisible(sino);
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
		txtPrecio.setEditable(sino);
		txtStock.setEditable(sino);
	}

	void habilitarOperaciones(boolean sino) {
		lblIngresar.setVisible(sino);
		lblConsultar.setVisible(sino);
		lblModificar.setVisible(sino);
		lblEliminar.setVisible(sino);
		lblAgregar.setVisible(!sino);
		lblCancelar.setVisible(!sino);
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
	protected void mouseClickedLblIngresar(MouseEvent arg0) {
		panel.setVisible(true);
		editableTrue();
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando Medicamento");///verificar
		txtCodigo.setText("" + am.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.setEditable(false);
		txtNombre.requestFocus();
		lblBuscar.setVisible(false);
		lblGrabar.setVisible(true);
	}
private void editableTrue(){
		
		txtCodigo.setEditable(true);
		txtNombre.setEditable(true);
		txtLaboratorio.setEditable(true);
		txtPrecio.setEditable(true);
		txtStock.setEditable(true);
		noVisibleCodigo();
		noVisibleNombre();
		noVisibleLaboratorio();
		noVisiblePrecio();
		noVisibleStock();
	}
private void editableFalse(){
	txtCodigo.setEditable(false);
	txtNombre.setEditable(false);
	txtLaboratorio.setEditable(false);
	txtPrecio.setEditable(false);
	txtStock.setEditable(false);
	
	
}
private void visibleCodigo(){
	txtCodigo.setVisible(false);
	lblCodigo.setVisible(false);
	lineCodigo.setVisible(false);
	iconCodigo.setVisible(false);
}
private void visibleNombre(){
	txtNombre.setVisible(false);
	lblNombre.setVisible(false);
	lineNombre.setVisible(false);
	iconNombre.setVisible(false);
}
private void visibleLaboratorio(){
	txtLaboratorio.setVisible(false);
	lblLaboratorio.setVisible(false);
	lineLaboratorio.setVisible(false);
	iconLaboratorio.setVisible(false);
}
private void visiblePrecio(){
	txtPrecio.setVisible(false);
	lblPrecio.setVisible(false);
	linePrecio.setVisible(false);
	iconPrecio.setVisible(false);
}
private void visibleStock(){
	txtStock.setVisible(false);
	lblStock.setVisible(false);
	lineStock.setVisible(false);
	iconStock.setVisible(false);
}
private void noVisibleCodigo(){
	txtCodigo.setVisible(true);
	txtCodigo.setEditable(true);
	lblCodigo.setVisible(true);
	lineCodigo.setVisible(true);
	iconCodigo.setVisible(true);
}
private void noVisibleNombre(){
	txtNombre.setVisible(true);
	txtNombre.setEditable(true);
	lblNombre.setVisible(true);
	lineNombre.setVisible(true);
	iconNombre.setVisible(true);
}
private void noVisibleLaboratorio(){
	txtLaboratorio.setVisible(true);
	txtLaboratorio.setEditable(true);
	lblLaboratorio.setVisible(true);
	lineLaboratorio.setVisible(true);
	iconLaboratorio.setVisible(true);
}
private void noVisiblePrecio(){
	txtPrecio.setVisible(true);
	txtPrecio.setEditable(true);
	lblPrecio.setVisible(true);
	linePrecio.setVisible(true);
	iconPrecio.setVisible(true);
}
private void noVisibleStock(){
	txtStock.setVisible(true);
	txtStock.setEditable(true);
	lblStock.setVisible(true);
	lineStock.setVisible(true);
	iconStock.setVisible(true);
}
	protected void mouseClickedLblConsultar(MouseEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Paciente");
		panel.setVisible(true);
		noVisibleCodigo();
		visibleNombre();
		visibleLaboratorio();
		visiblePrecio();
		visibleStock();
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		lblAgregar.setVisible(false);
		lblGrabar.setVisible(false);
		
	}
	
	protected void mouseClickedLblAgregar(MouseEvent arg0) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarMedicamento();
			limpieza();
			txtCodigo.setText("" + am.codigoCorrelativo());
			break;
		case CONSULTAR:
			limpieza();
			habilitarBusqueda(false);
			habilitarOperaciones(true);
			lblMensaje.setText("");
			break;
		case MODIFICAR:
			modificarMedicamento();
			
			break;
		case ELIMINAR:
			eliminarMedicamento();
			
	}
		
	}
	protected void mouseClickedLblGrabar(MouseEvent arg0) {
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
	protected void mouseClickedLblModificar(MouseEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Paciente");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
		noVisibleCodigo();
		visibleNombre();
		visibleLaboratorio();
		visiblePrecio();
		visibleStock();
		lblGrabar.setVisible(true);
		lblAgregar.setVisible(false);
		lblGrabar.setVisible(false);
		lblAgregar.setText("Modificar");
	}
	protected void mouseClickedLblEliminar(MouseEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Paciente");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
		visibleLaboratorio();
		visiblePrecio();
		visibleNombre();
		visibleStock();
		lblAgregar.setVisible(false);
		lblGrabar.setVisible(false);
		lblAgregar.setText("Eliminar");
	}

	protected void mouseClickedLblCancelar(MouseEvent arg0) {
		panel.setVisible(false);
		if (tipoOperacion != ADICIONAR)
			habilitarBusqueda(false);
		lblMensaje.setText("");
		habilitarEntradas(false);
		habilitarOperaciones(true);
	}
	protected void mouseClickedLblBuscar(MouseEvent arg0) {
		consultarMedicamento();
	}
}
