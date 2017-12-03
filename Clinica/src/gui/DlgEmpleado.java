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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Cursor;

public class DlgEmpleado extends JDialog implements ActionListener, KeyListener, MouseListener {

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
	private JPanel panel;
	private JLabel lblIngresar;
	private JLabel lblConsultar;
	private JLabel lblModificar;
	private JLabel lblEliminar;
	private JLabel lbliconCodigo;
	private JSeparator sCodigo;
	private JLabel lbliconNombres;
	private JSeparator sNombres;
	private JLabel lbliconApellidos;
	private JSeparator sApellidos;
	private JLabel lbliconLogin;
	private JSeparator sLogin;
	private JLabel lbliconPassword;
	private JSeparator sPassword;
	private JLabel lblAgregar;
	private JLabel lblCancelar;
	private JLabel lblGrabar;
	private JLabel lblBuscar;

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
		setBounds(100, 100, 1438, 914);
		getContentPane().setLayout(null);

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBackground(new Color(124, 252, 0));
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnAdicionar.setBounds(20, 70, 137, 39);
		ds.setCurvasButton(btnAdicionar, "imagenes/adicionar.png");
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setBackground(Color.CYAN);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnConsultar.setBounds(177, 70, 145, 39);
		ds.setCurvasButton(btnConsultar, "imagenes/consultar.png");
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBackground(new Color(0, 139, 139));
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnModificar.setBounds(511, 70, 145, 39);
		ds.setCurvasButton(btnModificar, "imagenes/modificar.png");
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(127, 255, 212));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnEliminar.setBounds(355, 70, 137, 39);
		ds.setCurvasButton(btnEliminar, "imagenes/eliminar.png");
		getContentPane().add(btnEliminar);

		lblMensaje = new JLabel("");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setBackground(Color.DARK_GRAY);
		lblMensaje.setBounds(1091, 11, 313, 29);
		getContentPane().add(lblMensaje);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 248, 722, 278);
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
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(792, 70, 630, 847);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
				lblCodigo = new JLabel("CODIGO");
				lblCodigo.setBounds(24, 49, 71, 14);
				panel.add(lblCodigo);
				lblCodigo.setForeground(Color.BLACK);
				lblCodigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
				lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
				
						lblLogin = new JLabel("LOGIN");
						lblLogin.setBounds(50, 280, 46, 14);
						panel.add(lblLogin);
						lblLogin.setForeground(Color.BLACK);
						lblLogin.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
						lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
						
								lblTurno = new JLabel("TURNO");
								lblTurno.setBounds(50, 440, 65, 14);
								panel.add(lblTurno);
								lblTurno.setForeground(Color.BLACK);
								lblTurno.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
								lblTurno.setHorizontalAlignment(SwingConstants.RIGHT);
								
										txtApellidos = new JTextField();
										txtApellidos.setBounds(357, 166, 227, 29);
										panel.add(txtApellidos);
										txtApellidos.addKeyListener(this);
										txtApellidos.setEditable(false);
										txtApellidos.setForeground(Color.BLACK);
										txtApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
										txtApellidos.setColumns(10);
										txtApellidos.setBorder(null);
										txtApellidos.setOpaque(false);
										
												txtNombres = new JTextField();
												txtNombres.setBounds(72, 168, 207, 26);
												panel.add(txtNombres);
												txtNombres.addKeyListener(this);
												txtNombres.setEditable(false);
												txtNombres.setForeground(Color.BLACK);
												txtNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
												txtNombres.setColumns(10);
												txtNombres.setBorder(null);
												txtNombres.setOpaque(false);
												
														cboTipo = new JComboBox<String>();
														cboTipo.setBounds(134, 222, 154, 29);
														panel.add(cboTipo);
														cboTipo.setEnabled(false);
														cboTipo.setForeground(Color.BLACK);
														cboTipo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
														
																txtLogin = new JTextField();
																txtLogin.setBounds(86, 310, 154, 29);
																panel.add(txtLogin);
																txtLogin.addKeyListener(this);
																txtLogin.setEditable(false);
																txtLogin.setForeground(Color.BLACK);
																txtLogin.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																txtLogin.setColumns(10);
																txtLogin.setBorder(null);
																txtLogin.setOpaque(false);
																
																
																		txtPassword = new JTextField();
																		txtPassword.setBounds(93, 381, 154, 29);
																		panel.add(txtPassword);
																		txtPassword.addKeyListener(this);
																		txtPassword.setEditable(false);
																		txtPassword.setForeground(Color.BLACK);
																		txtPassword.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																		txtPassword.setColumns(10);
																		txtPassword.setBorder(null);
																		txtPassword.setOpaque(false);
																		
																		
																				cboTurno = new JComboBox<String>();
																				cboTurno.setBounds(134, 433, 154, 29);
																				panel.add(cboTurno);
																				cboTurno.setEnabled(false);
																				cboTurno.setForeground(Color.BLACK);
																				cboTurno.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																				
																						txtCodigo = new JTextField();
																						txtCodigo.setBounds(68, 83, 85, 21);
																						panel.add(txtCodigo);
																						txtCodigo.setBackground(new Color(255, 255, 255));
																						txtCodigo.addKeyListener(this);
																						txtCodigo.setEditable(false);
																						txtCodigo.setForeground(Color.BLACK);
																						txtCodigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																						txtCodigo.setColumns(10);
																						txtCodigo.setBorder(null);
																						txtCodigo.setOpaque(false);
																						
																								btnBuscar = new JButton("BUSCAR");
																								btnBuscar.setBounds(188, 84, 110, 29);
																								panel.add(btnBuscar);
																								btnBuscar.addActionListener(this);
																								btnBuscar.setBackground(new Color(102, 205, 170));
																								btnBuscar.setEnabled(false);
																								btnBuscar.setForeground(Color.BLACK);
																								btnBuscar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																								ds.setCurvasButton(btnBuscar, "imagenes/buscar.png");
																								
																										lblApellidos = new JLabel("APELLIDOS");
																										lblApellidos.setBounds(318, 134, 85, 14);
																										panel.add(lblApellidos);
																										lblApellidos.setForeground(Color.BLACK);
																										lblApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																										lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
																										
																												lblNombres = new JLabel("NOMBRES");
																												lblNombres.setBounds(40, 132, 73, 18);
																												panel.add(lblNombres);
																												lblNombres.setForeground(Color.BLACK);
																												lblNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																												lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
																												
																														lblTipo = new JLabel("TIPO");
																														lblTipo.setBounds(0, 229, 85, 14);
																														panel.add(lblTipo);
																														lblTipo.setForeground(Color.BLACK);
																														lblTipo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																														lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
																														
																																lblPassword = new JLabel("PASSWORD");
																																lblPassword.setBounds(42, 358, 85, 14);
																																panel.add(lblPassword);
																																lblPassword.setForeground(Color.BLACK);
																																lblPassword.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																																lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
																																
																																		btnAceptar = new JButton("ACEPTAR");
																																		btnAceptar.setBounds(89, 669, 137, 39);
																																		panel.add(btnAceptar);
																																		btnAceptar.addActionListener(this);
																																		btnAceptar.setBackground(new Color(30, 144, 255));
																																		btnAceptar.setEnabled(false);
																																		btnAceptar.setForeground(Color.BLACK);
																																		btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																																		ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
																																		
																																				btnCancelar = new JButton("CANCELAR");
																																				btnCancelar.setBounds(395, 687, 145, 39);
																																				panel.add(btnCancelar);
																																				btnCancelar.addActionListener(this);
																																				btnCancelar.setBackground(new Color(0, 255, 255));
																																				btnCancelar.setEnabled(false);
																																				btnCancelar.setForeground(Color.BLACK);
																																				btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																																				ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
																																				
																																						btnGuardar = new JButton("GUARDAR EMPLEADOS");
																																						btnGuardar.setBounds(188, 737, 303, 39);
																																						panel.add(btnGuardar);
																																						btnGuardar.addActionListener(this);
																																						btnGuardar.setForeground(Color.BLACK);
																																						btnGuardar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																																						btnGuardar.setBackground(new Color(0, 250, 154));
																																						ds.setCurvasButton(btnGuardar, "imagenes/grabar.png");
																																						
																																						lbliconCodigo = new JLabel("");
																																						lbliconCodigo.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/codigo.png")));
																																						lbliconCodigo.setBounds(34, 82, 24, 22);
																																						panel.add(lbliconCodigo);
																																						
																																						sCodigo = new JSeparator();
																																						sCodigo.setForeground(Color.BLACK);
																																						sCodigo.setBounds(47, 106, 115, 2);
																																						panel.add(sCodigo);
																																						
																																						lbliconNombres = new JLabel("");
																																						lbliconNombres.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/user30.png")));
																																						lbliconNombres.setBounds(40, 167, 35, 27);
																																						panel.add(lbliconNombres);
																																						
																																						sNombres = new JSeparator();
																																						sNombres.setBounds(40, 194, 239, 2);
																																						panel.add(sNombres);
																																						
																																						lbliconApellidos = new JLabel("");
																																						lbliconApellidos.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/user30.png")));
																																						lbliconApellidos.setBounds(318, 166, 35, 27);
																																						panel.add(lbliconApellidos);
																																						
																																						sApellidos = new JSeparator();
																																						sApellidos.setBounds(318, 194, 277, 2);
																																						panel.add(sApellidos);
																																						
																																						lbliconLogin = new JLabel("");
																																						lbliconLogin.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/user2-32.png")));
																																						lbliconLogin.setBounds(53, 310, 35, 27);
																																						panel.add(lbliconLogin);
																																						
																																						sLogin = new JSeparator();
																																						sLogin.setBounds(53, 338, 191, 2);
																																						panel.add(sLogin);
																																						
																																						lbliconPassword = new JLabel("");
																																						lbliconPassword.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/image/Key_32px.png")));
																																						lbliconPassword.setBounds(55, 383, 35, 27);
																																						panel.add(lbliconPassword);
																																						
																																						sPassword = new JSeparator();
																																						sPassword.setBounds(55, 410, 201, 2);
																																						panel.add(sPassword);
																																						
																																						lblAgregar = new JLabel("Agregar");
																																						lblAgregar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/Agregar.png")));
																																						lblAgregar.addMouseListener(this);
																																						lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblAgregar.setForeground(Color.BLACK);
																																						lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
																																						lblAgregar.setBackground(Color.YELLOW);
																																						lblAgregar.setBounds(159, 490, 206, 39);
																																						panel.add(lblAgregar);
																																						
																																						lblCancelar = new JLabel("Cancelar");
																																						lblCancelar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/regreso.png")));
																																						lblCancelar.addMouseListener(this);
																																						lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblCancelar.setForeground(Color.BLACK);
																																						lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
																																						lblCancelar.setBounds(159, 540, 206, 39);
																																						panel.add(lblCancelar);
																																						
																																						lblGrabar = new JLabel("Grabar");
																																						lblGrabar.setOpaque(true);
																																						lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblGrabar.setForeground(Color.WHITE);
																																						lblGrabar.setFont(new Font("Dialog", Font.PLAIN, 18));
																																						lblGrabar.setBackground(new Color(231, 96, 90));
																																						lblGrabar.setBounds(188, 590, 206, 41);
																																						panel.add(lblGrabar);
																																						
																																						lblBuscar = new JLabel("Buscar");
																																						lblBuscar.addMouseListener(this);
																																						lblBuscar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/buscar.png")));
																																						lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblBuscar.setForeground(Color.BLACK);
																																						lblBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
																																						lblBuscar.setBackground(Color.BLUE);
																																						lblBuscar.setBounds(321, 72, 170, 39);
																																						panel.add(lblBuscar);
																																						
																																						lblIngresar = new JLabel("INGRESAR");
																																						lblIngresar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/ingresarNaranja.png")));
																																						lblIngresar.addMouseListener(this);
																																						lblIngresar.setInheritsPopupMenu(false);
																																						lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblIngresar.setForeground(new Color(243, 124, 47));
																																						lblIngresar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																																						lblIngresar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																																						lblIngresar.setBackground(new Color(1, 168, 25));
																																						lblIngresar.setBounds(15, 134, 169, 37);
																																						getContentPane().add(lblIngresar);
																																						
																																						lblConsultar = new JLabel("CONSULTAR");
																																						lblConsultar.addMouseListener(this);
																																						lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblConsultar.setForeground(new Color(243, 124, 47));
																																						lblConsultar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																																						lblConsultar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																																						lblConsultar.setBackground(new Color(1, 168, 25));
																																						lblConsultar.setBounds(203, 135, 169, 36);
																																						getContentPane().add(lblConsultar);
																																						
																																						lblModificar = new JLabel("MODIFICAR");
																																						lblModificar.addMouseListener(this);
																																						lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblModificar.setForeground(new Color(243, 124, 47));
																																						lblModificar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																																						lblModificar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																																						lblModificar.setBackground(new Color(1, 168, 25));
																																						lblModificar.setBounds(393, 135, 175, 36);
																																						getContentPane().add(lblModificar);
																																						
																																						lblEliminar = new JLabel("ELIMINAR");
																																						lblEliminar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/eliminarNaranja.png")));
																																						lblEliminar.addMouseListener(this);
																																						lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblEliminar.setForeground(new Color(243, 124, 47));
																																						lblEliminar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																																						lblEliminar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																																						
																																						lblEliminar.setBounds(588, 135, 183, 36);
																																						getContentPane().add(lblEliminar);
																																						
																				cboTurno.addItem("Noche");
																				cboTurno.addItem("Día");
														cboTipo.addItem("Administrador");
														cboTipo.addItem("Cajero");

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
		panel.setVisible(true);
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Empleado");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
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
				if ((tipoOperacion != CONSULTAR)&&(tipoOperacion != ADICIONAR)){
					lblAgregar.setVisible(true);
					lblGrabar.setVisible(true);
				}
				novisibleNombre();
				novisibleApellido();
				novisibleTurno();
				novisibleTipo();
				novisibleLogin();
				novisiblePassword();
				
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
	
	//
	
private void editableTrue(){
		
		txtCodigo.setEditable(true);
		txtApellidos.setEditable(true);
		txtNombres.setEditable(true);
		txtLogin.setEditable(true);
		txtPassword.setEditable(true);
		cboTipo.setEditable(true);
		cboTurno.setEditable(true);
		novisibleCodigo();
		novisibleNombre();
		novisibleApellido();
		novisibleLogin();
		novisiblePassword();
		novisibleTipo();
		novisibleTurno();
		
	}
	private void editableFalse(){
		txtCodigo.setEditable(false);
		txtApellidos.setEditable(false);
		txtNombres.setEditable(false);
		txtLogin.setEditable(false);
		txtPassword.setEditable(false);
		cboTipo.setEditable(false);
		cboTurno.setEditable(false);
		}
	
	//metodos privados visible 
	
		
	private void visibleCodigo(){
		txtCodigo.setVisible(false);
		lblCodigo.setVisible(false);
		sCodigo.setVisible(false);
		lbliconCodigo.setVisible(false);
	}
	private void visibleNombre(){
		txtNombres.setVisible(false);
		lblNombres.setVisible(false);
		sNombres.setVisible(false);
		lbliconNombres.setVisible(false);
	}
	private void visibleApellido(){
		txtApellidos.setVisible(false);
		lblApellidos.setVisible(false);
		sApellidos.setVisible(false);
		lbliconApellidos.setVisible(false);
	}
	private void visibleTipo(){
		cboTipo.setVisible(false);
		lblTipo.setVisible(false);
		}
	private void visibleTurno(){
		cboTurno.setVisible(false);
		lblTurno.setVisible(false);
		}
	private void visibleLogin(){
		txtLogin.setVisible(false);
		lblLogin.setVisible(false);
		sLogin.setVisible(false);
		lbliconLogin.setVisible(false);
	}
	
	private void visiblePassword(){
		txtPassword.setVisible(false);
		lblPassword.setVisible(false);
		sPassword.setVisible(false);
		lbliconPassword.setVisible(false);
	}
	
	//metodos privados  no visible
	
	private void novisibleCodigo(){
		txtCodigo.setVisible(false);
		lblCodigo.setVisible(false);
		sCodigo.setVisible(false);
		lbliconCodigo.setVisible(false);
	}
	private void novisibleNombre(){
		txtNombres.setVisible(false);
		lblNombres.setVisible(false);
		sNombres.setVisible(false);
		lbliconNombres.setVisible(false);
	}
	private void novisibleApellido(){
		txtApellidos.setVisible(false);
		lblApellidos.setVisible(false);
		sApellidos.setVisible(false);
		lbliconApellidos.setVisible(false);
	}
	private void novisibleTipo(){
		cboTipo.setVisible(false);
		lblTipo.setVisible(false);
		}
	private void novisibleTurno(){
		cboTurno.setVisible(false);
		lblTurno.setVisible(false);
		}
	private void novisibleLogin(){
		txtLogin.setVisible(false);
		lblLogin.setVisible(false);
		sLogin.setVisible(false);
		lbliconLogin.setVisible(false);
	}
	
	private void novisiblePassword(){
		txtPassword.setVisible(false);
		lblPassword.setVisible(false);
		sPassword.setVisible(false);
		lbliconPassword.setVisible(false);
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
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblModificar) {
			mouseClickedLblModificar(arg0);
		}
		if (arg0.getSource() == lblIngresar) {
			mouseClickedLblIngresar(arg0);
		}
		if (arg0.getSource() == lblConsultar) {
			//mouseClickedLblConsultar(arg0);
		}
		if (arg0.getSource() == lblAgregar) {
			mouseClickedLblAgregar(arg0);
		}
		if (arg0.getSource() == lblCancelar) {
			mouseClickedLblCancelar(arg0);
		}
		if (arg0.getSource() == lblGrabar) {
			//mouseClickedLblGrabar(arg0);
		}
		if (arg0.getSource() == lblBuscar) {
			mouseClickedLblBuscar(arg0);
		}
		if (arg0.getSource() == lblEliminar) {
			mouseClickedLblEliminar(arg0);
		}
		
	}
		
		
		
		
		
	
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == lblEliminar) {
			mouseEnteredLblEliminar(arg0);
		}
		if (arg0.getSource() == lblModificar) {
			mouseEnteredLblModificar(arg0);
		}
		if (arg0.getSource() == lblConsultar) {
			mouseEnteredLblConsultar(arg0);
		}
		if (arg0.getSource() == lblIngresar) {
			mouseEnteredLblIngresar(arg0);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblModificar) {
			//mouseExitedLblModificar(e);
		}
		
		if (e.getSource() == lblConsultar) {
			//mouseExitedLblConsultar(e);
		}
		if (e.getSource() == lblIngresar) {
			mouseExitedLblIngresar(e);
		}
		if (e.getSource() == lblEliminar) {
			mouseExitedLblEliminar(e);
		}
		if (e.getSource() == lblAgregar) {
			mouseExitedLblAgregar(e);
		}
		if (e.getSource() == lblCancelar) {
			mouseExitedLblCancelar(e);
		}
		if (e.getSource() == lblBuscar) {
			mouseExitedLblBuscar(e);
		}
		
		
	}
	
	
	
	
	
	
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	
	///Entered
	protected void mouseEnteredLblIngresar(MouseEvent e) {
		lblIngresar.setOpaque(true);
		lblIngresar.setBackground(new Color(243, 124, 47));
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/ingresarBlnco.png")));
	}
	protected void mouseEnteredLblConsultar(MouseEvent arg0) {
	}
	protected void mouseEnteredLblModificar(MouseEvent arg0) {
	}
	protected void mouseEnteredLblEliminar(MouseEvent arg0) {
		lblEliminar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/eliminarBlnco.png")));
		lblEliminar.setOpaque(true);
		lblEliminar.setBackground(new Color(243, 124, 47));
		lblEliminar.setForeground(new Color(255, 255, 255));
	}
	protected void mouseEnteredLblBuscar(MouseEvent e) {
		lblBuscar.setOpaque(true);
		lblBuscar.setBackground(new Color(30, 60, 79));
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/BuscarBlnco.png")));
	}
	protected void mouseEnteredlblAgregar(MouseEvent e) {
		lblAgregar.setOpaque(true);
		lblAgregar.setBackground(new Color(30, 60, 79));
		lblAgregar.setForeground(new Color(255, 255, 255));
		lblAgregar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/AgregarBlanco.png")));
	}
	protected void mouseEnteredCancelar(MouseEvent e) {
		lblCancelar.setOpaque(true);
		lblCancelar.setBackground(new Color(30, 60, 79));
		lblCancelar.setForeground(new Color(255, 255, 255));
		lblCancelar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regresoNegro.png")));
	}
	
	
	
	///Exited
	protected void mouseExitedLblEliminar(MouseEvent arg0) {
		lblEliminar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/eliminarNaranja.png")));
		lblEliminar.setOpaque(false);
		lblEliminar.setForeground(new Color(243, 124, 47));
	}
	protected void mouseExitedLblBuscar(MouseEvent arg0) {
		lblBuscar.setOpaque(false);
		lblBuscar.setForeground(new Color(10, 20, 26));
		lblBuscar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/buscar.png")));
		//lblCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 60, 79)));
		
	}
	protected void mouseExitedLblCancelar(MouseEvent arg0) {
		lblCancelar.setOpaque(false);
		lblCancelar.setForeground(new Color(10, 20, 26));
		lblCancelar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regreso.png")));
		//lblCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 60, 79)));
		
	}
	protected void mouseExitedLblAgregar(MouseEvent arg0) {
		lblAgregar.setOpaque(false);
		lblAgregar.setForeground(new Color(10, 20, 26));
		lblAgregar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/Agregar.png")));
		//lblAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 60, 79)));
		
	}
	protected void mouseExitedLblIngresar(MouseEvent arg0) {
		lblIngresar.setOpaque(false);
		lblIngresar.setForeground(new Color(243, 124, 47));
		lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/ingresarNaranja.png")));
		lblIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
	}
	
	
	
	
	
	////CLICKed
	protected void mouseClickedLblEliminar(MouseEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Paciente");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
		visibleApellido();
		visibleNombre();
		visibleTipo();
		visibleTurno();
		visibleLogin();
		visiblePassword();
		lblAgregar.setVisible(false);
		lblGrabar.setVisible(false);
		lblAgregar.setText("Eliminar");
	}
	protected void mouseClickedLblModificar(MouseEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Paciente");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
		novisibleCodigo();
		visibleNombre();
		visibleApellido();
		lblGrabar.setVisible(true);
		lblAgregar.setVisible(false);
		lblGrabar.setVisible(false);
		lblAgregar.setText("Modificar");
	}
	
protected void mouseClickedLblIngresar(MouseEvent arg0) {
		
		panel.setVisible(true);
		editableTrue();
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando Paciente");///verificar
		txtCodigo.setText("" + ae.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.setEditable(false);
		txtNombres.requestFocus();
		lblBuscar.setVisible(false);
		lblGrabar.setVisible(true);
		
		
		
	}
	protected void mouseClickedLblAgregar(MouseEvent arg0) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarEmpleado();
			limpieza();
			txtCodigo.setText("" + ae.codigoCorrelativo());
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
	protected void mouseClickedLblCancelar(MouseEvent arg0) {
		panel.setVisible(false);
		if (tipoOperacion != ADICIONAR)
			habilitarBusqueda(false);
		lblMensaje.setText("");
		habilitarEntradas(false);
		habilitarOperaciones(true);
	}
	protected void mouseClickedLblBuscar(MouseEvent arg0) {
		consultarEmpleado();	
	}
}
