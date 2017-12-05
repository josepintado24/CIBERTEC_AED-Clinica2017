package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.MouseInfo;
import java.awt.Point;
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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

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
	private JLabel lblMensaje;
	private JScrollPane scrollPane;
	private JTextField txtCodigo;
	private JTable jtblEmpleados;
	private int x;
	private int y;

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
	private JPanel panel_1;
	private JLabel label;
	private JLabel lblEmpleado;

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
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgEmpleado.class.getResource("/imagenes/mantenimiento.png")));
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setModal(true);
		setTitle("MANTENIMIENTO | EMPLEADOS");
		setBounds(100, 100, 1266, 718);
		getContentPane().setLayout(null);

		lblMensaje = new JLabel("");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setBackground(Color.DARK_GRAY);
		lblMensaje.setBounds(839, 85, 313, 29);
		getContentPane().add(lblMensaje);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 125, 722, 566);
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
		panel.setBounds(765, 125, 466, 566);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		
		
		
				lblCodigo = new JLabel("CODIGO");
				lblCodigo.setBounds(25, 11, 71, 14);
				panel.add(lblCodigo);
				lblCodigo.setForeground(Color.BLACK);
				lblCodigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
				lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
				
						lblLogin = new JLabel("USER");
						lblLogin.setBounds(25, 261, 46, 14);
						panel.add(lblLogin);
						lblLogin.setForeground(Color.BLACK);
						lblLogin.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
						lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
						
								lblTurno = new JLabel("TURNO");
								lblTurno.setBounds(25, 406, 65, 14);
								panel.add(lblTurno);
								lblTurno.setForeground(Color.BLACK);
								lblTurno.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
								lblTurno.setHorizontalAlignment(SwingConstants.RIGHT);
								
										txtApellidos = new JTextField();
										txtApellidos.setBounds(66, 176, 227, 29);
										panel.add(txtApellidos);
										txtApellidos.addKeyListener(this);
										txtApellidos.setEditable(false);
										txtApellidos.setForeground(Color.BLACK);
										txtApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
										txtApellidos.setColumns(10);
										txtApellidos.setBorder(null);
										txtApellidos.setOpaque(false);
										
												txtNombres = new JTextField();
												txtNombres.setBounds(68, 110, 207, 26);
												panel.add(txtNombres);
												txtNombres.addKeyListener(this);
												txtNombres.setEditable(false);
												txtNombres.setForeground(Color.BLACK);
												txtNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
												txtNombres.setColumns(10);
												txtNombres.setBorder(null);
												txtNombres.setOpaque(false);
												
														cboTipo = new JComboBox<String>();
														cboTipo.setBounds(111, 221, 154, 29);
														panel.add(cboTipo);
														cboTipo.setEnabled(false);
														cboTipo.setForeground(Color.BLACK);
														cboTipo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
														
																txtLogin = new JTextField();
																txtLogin.setBounds(74, 286, 154, 29);
																panel.add(txtLogin);
																txtLogin.addKeyListener(this);
																txtLogin.setEditable(false);
																txtLogin.setForeground(Color.BLACK);
																txtLogin.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																txtLogin.setColumns(10);
																txtLogin.setBorder(null);
																txtLogin.setOpaque(false);
																
																
																		txtPassword = new JTextField();
																		txtPassword.setBounds(75, 348, 154, 29);
																		panel.add(txtPassword);
																		txtPassword.addKeyListener(this);
																		txtPassword.setEditable(false);
																		txtPassword.setForeground(Color.BLACK);
																		txtPassword.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																		txtPassword.setColumns(10);
																		txtPassword.setBorder(null);
																		txtPassword.setOpaque(false);
																		
																		
																				cboTurno = new JComboBox<String>();
																				cboTurno.setBounds(100, 399, 154, 29);
																				panel.add(cboTurno);
																				cboTurno.setEnabled(false);
																				cboTurno.setForeground(Color.BLACK);
																				cboTurno.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																				
																						txtCodigo = new JTextField();
																						txtCodigo.setBounds(55, 36, 85, 21);
																						panel.add(txtCodigo);
																						txtCodigo.setBackground(new Color(255, 255, 255));
																						txtCodigo.addKeyListener(this);
																						txtCodigo.setEditable(false);
																						txtCodigo.setForeground(Color.BLACK);
																						txtCodigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																						txtCodigo.setColumns(10);
																						txtCodigo.setBorder(null);
																						txtCodigo.setOpaque(false);
																								
																										lblApellidos = new JLabel("APELLIDOS");
																										lblApellidos.setBounds(35, 157, 85, 14);
																										panel.add(lblApellidos);
																										lblApellidos.setForeground(Color.BLACK);
																										lblApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																										lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
																										
																												lblNombres = new JLabel("NOMBRES");
																												lblNombres.setBounds(35, 80, 73, 18);
																												panel.add(lblNombres);
																												lblNombres.setForeground(Color.BLACK);
																												lblNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																												lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
																												
																														lblTipo = new JLabel("TIPO");
																														lblTipo.setBounds(10, 228, 65, 14);
																														panel.add(lblTipo);
																														lblTipo.setForeground(Color.BLACK);
																														lblTipo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																														lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
																														
																																lblPassword = new JLabel("PASSWORD");
																																lblPassword.setBounds(25, 326, 85, 14);
																																panel.add(lblPassword);
																																lblPassword.setForeground(Color.BLACK);
																																lblPassword.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																																lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
																																						
																																						lbliconCodigo = new JLabel("");
																																						lbliconCodigo.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/codigo.png")));
																																						lbliconCodigo.setBounds(25, 36, 24, 22);
																																						panel.add(lbliconCodigo);
																																						
																																						sCodigo = new JSeparator();
																																						sCodigo.setForeground(Color.BLACK);
																																						sCodigo.setBounds(30, 58, 115, 2);
																																						panel.add(sCodigo);
																																						
																																						lbliconNombres = new JLabel("");
																																						lbliconNombres.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/user30.png")));
																																						lbliconNombres.setBounds(35, 109, 35, 27);
																																						panel.add(lbliconNombres);
																																						
																																						sNombres = new JSeparator();
																																						sNombres.setBounds(37, 137, 239, 2);
																																						panel.add(sNombres);
																																						
																																						lbliconApellidos = new JLabel("");
																																						lbliconApellidos.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/user30.png")));
																																						lbliconApellidos.setBounds(35, 180, 35, 27);
																																						panel.add(lbliconApellidos);
																																						
																																						sApellidos = new JSeparator();
																																						sApellidos.setBounds(36, 208, 257, 2);
																																						panel.add(sApellidos);
																																						
																																						lbliconLogin = new JLabel("");
																																						lbliconLogin.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/user2-32.png")));
																																						lbliconLogin.setBounds(39, 287, 35, 27);
																																						panel.add(lbliconLogin);
																																						
																																						sLogin = new JSeparator();
																																						sLogin.setBounds(35, 316, 191, 2);
																																						panel.add(sLogin);
																																						
																																						lbliconPassword = new JLabel("");
																																						lbliconPassword.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/image/Key_32px.png")));
																																						lbliconPassword.setBounds(35, 350, 35, 27);
																																						panel.add(lbliconPassword);
																																						
																																						sPassword = new JSeparator();
																																						sPassword.setBounds(38, 379, 201, 2);
																																						panel.add(sPassword);
																																						
																																						lblAgregar = new JLabel("Agregar");
																																						lblAgregar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/Agregar.png")));
																																						lblAgregar.addMouseListener(this);
																																						lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblAgregar.setForeground(new Color(0, 0, 0));
																																						lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
																																						lblAgregar.setBackground(new Color(255, 255, 0));
																																						lblAgregar.setBounds(145, 439, 175, 39);
																																						panel.add(lblAgregar);
																																						
																																						lblCancelar = new JLabel("Cancelar");
																																						lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblCancelar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/regreso.png")));
																																						lblCancelar.addMouseListener(this);
																																						lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblCancelar.setForeground(Color.BLACK);
																																						lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
																																						lblCancelar.setBounds(129, 474, 191, 39);
																																						panel.add(lblCancelar);
																																						
																																						lblGrabar = new JLabel("Grabar");
																																						lblGrabar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/save.png")));
																																						lblGrabar.addMouseListener(this);
																																						lblGrabar.setOpaque(true);
																																						lblGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblGrabar.setForeground(Color.WHITE);
																																						lblGrabar.setFont(new Font("Dialog", Font.PLAIN, 18));
																																						lblGrabar.setBackground(new Color(231, 96, 90));
																																						lblGrabar.setBounds(136, 514, 184, 41);
																																						panel.add(lblGrabar);
																																						
																																						lblBuscar = new JLabel("Buscar");
																																						lblBuscar.addMouseListener(this);
																																						lblBuscar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/buscar.png")));
																																						lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblBuscar.setForeground(Color.BLACK);
																																						lblBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
																																						lblBuscar.setBackground(Color.BLUE);
																																						lblBuscar.setBounds(150, 25, 170, 39);
																																						panel.add(lblBuscar);
																																						
																																						lblIngresar = new JLabel("INGRESAR");
																																						lblIngresar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/ingresarNaranja.png")));
																																						lblIngresar.addMouseListener(this);
																																						lblIngresar.setInheritsPopupMenu(false);
																																						lblIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblIngresar.setForeground(new Color(243, 124, 47));
																																						lblIngresar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																																						lblIngresar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																																						lblIngresar.setBackground(new Color(1, 168, 25));
																																						lblIngresar.setBounds(25, 70, 158, 37);
																																						getContentPane().add(lblIngresar);
																																						
																																						lblConsultar = new JLabel("CONSULTAR");
																																						lblConsultar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/ingresarNaranja.png")));
																																						lblConsultar.addMouseListener(this);
																																						lblConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblConsultar.setInheritsPopupMenu(false);
																																						lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblConsultar.setForeground(new Color(243, 124, 47));
																																						lblConsultar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																																						lblConsultar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																																						lblConsultar.setBackground(new Color(1, 168, 25));
																																						lblConsultar.setBounds(193, 70, 169, 37);
																																						getContentPane().add(lblConsultar);
																																						
																																						lblModificar = new JLabel("MODIFICAR");
																																						lblModificar.addMouseListener(this);
																																						lblModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
																																						lblModificar.setForeground(new Color(243, 124, 47));
																																						lblModificar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																																						lblModificar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																																						lblModificar.setBackground(Color.WHITE);
																																						lblModificar.setBounds(372, 71, 175, 36);
																																						getContentPane().add(lblModificar);
																																						
																																	lblEliminar = new JLabel("ELIMINAR");
																																	lblEliminar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/eliminarNaranja.png")));
																																	lblEliminar.addMouseListener(this);
																																	lblEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																	lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
																																	lblEliminar.setForeground(new Color(243, 124, 47));
																																	lblEliminar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																																	lblEliminar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																																	lblEliminar.setBounds(557, 70, 183, 36);
																																	getContentPane().add(lblEliminar);
																																						
																																						panel_1 = new JPanel();
																																						panel_1.addMouseMotionListener(new MouseMotionAdapter() {
																																							@Override
																																							public void mouseDragged(MouseEvent e) {
																																								Point ubicacion = MouseInfo.getPointerInfo().getLocation();
																																							    setLocation(ubicacion.x - x, ubicacion.y - y);
																																							}
																																						});
																																						panel_1.addMouseListener(new MouseAdapter() {
																																							@Override
																																							public void mousePressed(MouseEvent e) {
																																								x = e.getX();
																																							    y = e.getY();
																																							}
																																						});
																																						panel_1.setBackground(Color.WHITE);
																																						panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						panel_1.setBounds(0, 0, 1438, 39);
																																						getContentPane().add(panel_1);
																																						panel_1.setLayout(null);
																																						
																																						label = new JLabel("");
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
																																						label.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/image/icons8_Return_32px.png")));
																																						label.setBounds(1223, 0, 43, 39);
																																						panel_1.add(label);
																																						
																																						lblEmpleado = new JLabel("Empleado");
																																						lblEmpleado.setFont(new Font("Decker", Font.PLAIN, 16));
																																						lblEmpleado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																						lblEmpleado.setBounds(39, 0, 78, 39);
																																						panel_1.add(lblEmpleado);
																																						
																				cboTurno.addItem("Noche");
																				cboTurno.addItem("Día");
														cboTipo.addItem("Administrador");
														cboTipo.addItem("Cajero");

		listado();
		modeloTabla();
		this.setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent e) {
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
		if (leerNombres().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su NOMBRE");
			txtNombres.requestFocus();
		}
		else if (leerApellidos().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó su APELLIDO");
			txtApellidos.setText("");
			txtApellidos.requestFocus();
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
			Empleado nuevo = new Empleado(leerCodigo(),leerNombres(), leerApellidos(),leerTipo(), leerLogin(),
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
				visibleNombre(true);
				visibleApellido(true);
				visibleLogin(true);
				visiblePassword(true);
				visibleTipo(true);
				visibleTurno(true);
				
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
		lblBuscar.setEnabled(sino);
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
		lblIngresar.setEnabled(sino);
		lblConsultar.setEnabled(sino);
		lblModificar.setEnabled(sino);
		lblEliminar.setEnabled(sino);
		lblAgregar.setEnabled(!sino);
		lblCancelar.setEnabled(!sino);
	}
	
	void habilitarBotones(boolean sino){
		lblConsultar.setVisible(sino);
		lblModificar.setVisible(sino);
		lblEliminar.setVisible(sino);
		lblIngresar.setVisible(sino);
	}
	
	//
	
/*private void editableTrue(){
		
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
		}*/
	
	//metodos privados NO VISIBLEs 
	
		
	private void visibleCodigo(boolean sino){
		txtCodigo.setVisible(sino);
		lblCodigo.setVisible(sino);
		sCodigo.setVisible(sino);
		lbliconCodigo.setVisible(sino);
	}
	private void visibleNombre(boolean sino){
		txtNombres.setVisible(sino);
		lblNombres.setVisible(sino);
		sNombres.setVisible(sino);
		lbliconNombres.setVisible(sino);
	}
	private void visibleApellido(boolean sino){
		txtApellidos.setVisible(sino);
		lblApellidos.setVisible(sino);
		sApellidos.setVisible(sino);
		lbliconApellidos.setVisible(sino);
	}
	private void visibleTipo(boolean sino){
		cboTipo.setVisible(sino);
		lblTipo.setVisible(sino);
		}
	private void visibleTurno(boolean sino){
		cboTurno.setVisible(sino);
		lblTurno.setVisible(sino);
		}
	private void visibleLogin(boolean sino){
		txtLogin.setVisible(sino);
		lblLogin.setVisible(sino);
		sLogin.setVisible(sino);
		lbliconLogin.setVisible(sino);
	}
	
	private void visiblePassword(boolean sino){
		txtPassword.setVisible(sino);
		lblPassword.setVisible(sino);
		sPassword.setVisible(sino);
		lbliconPassword.setVisible(sino);
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
		if (arg0.getSource() == lblGrabar) {
			mouseClickedLblGrabar(arg0);
		}
		if (arg0.getSource() == lblModificar) {
			mouseClickedLblModificar(arg0);
		}
		if (arg0.getSource() == lblIngresar) {
			mouseClickedLblIngresar(arg0);
		}
		if (arg0.getSource() == lblConsultar) {
			mouseClickedLblConsultar(arg0);
		}
		if (arg0.getSource() == lblAgregar) {
			mouseClickedLblAgregar(arg0);
		}
		if (arg0.getSource() == lblCancelar) {
			mouseClickedLblCancelar(arg0);
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
		if (arg0.getSource() == lblAgregar) {
			mouseExitedLblAgregar(arg0);
		}
		if (arg0.getSource() == lblCancelar) {
			mouseExitedLblCancelar(arg0);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblModificar) {
			mouseExitedLblModificar(e);
		}
		
		if (e.getSource() == lblConsultar) {
			mouseExitedLblConsultar(e);
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
		lblConsultar.setOpaque(true);
		lblConsultar.setBackground(new Color(243, 124, 47));
		lblConsultar.setForeground(new Color(255, 255, 255));
		lblConsultar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/consultarBlnaco.png")));
	}
	protected void mouseEnteredLblModificar(MouseEvent arg0) {

		lblModificar.setOpaque(true);
		lblModificar.setBackground(new Color(243, 124, 47));
		lblModificar.setForeground(new Color(255, 255, 255));
		lblModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/modificarBlanco.png")));
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
		lblEliminar.setBackground(new Color(243, 124, 47));
		lblEliminar.setForeground(new Color(255, 255, 255));
		lblAgregar.setOpaque(true);
		lblAgregar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/AgregarBlanco.png")));
	}
	protected void mouseEnteredCancelar(MouseEvent e) {
		lblCancelar.setOpaque(true);
		lblCancelar.setBackground(new Color(30, 60, 79));
		lblCancelar.setForeground(new Color(255, 255, 255));
		lblCancelar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regresoNegro.png")));
	}
	
	
	
	///Exited
	protected void mouseExitedLblConsultar(MouseEvent arg0) {
		lblConsultar.setOpaque(false);
		lblConsultar.setForeground(new Color(243, 124, 47));
		lblConsultar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/consultarNaranja.png")));
		lblConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
	}
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
	
		lblCancelar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regreso.png")));
		//lblCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 60, 79)));
		lblEliminar.setOpaque(false);
		lblEliminar.setForeground(new Color(243, 124, 47));
		
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
	protected void mouseExitedLblModificar(MouseEvent arg0) {
		lblModificar.setOpaque(false);
		lblModificar.setForeground(new Color(243, 124, 47));
		lblModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/modificarNaranja.png")));
		lblModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
		
	}
	
	
	
	
	
	////CLICKed
	private void mouseClickedLblEliminar(MouseEvent arg0){
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Empleado");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
		visibleNombre(false);
		visibleApellido(false);
		visibleTurno(false);
		visibleTipo(false);
		visibleLogin(false);
		visiblePassword(false);
		lblAgregar.setText("Eliminar");
		habilitarBotones(false);
		lblBuscar.setVisible(true);
		
		
	
	}
	protected void mouseClickedLblConsultar(MouseEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Empleado");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
		visibleNombre(false);
		visibleApellido(false);
		visibleLogin(false);
		visibleTipo(false);
		visiblePassword(false);
		visibleTurno(false);
		lblAgregar.setVisible(false);
		lblGrabar.setVisible(false);
		habilitarBotones(false);
		lblBuscar.setVisible(true);
	}
	protected void mouseClickedLblModificar(MouseEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Empleado");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.requestFocus();
		panel.setVisible(true);
		visibleNombre(false);
		visibleApellido(false);
		visibleTurno(false);
		visibleTipo(false);
		visibleLogin(false);
		visiblePassword(false);
		lblAgregar.setText("Modificar");
		habilitarBotones(false);
		lblBuscar.setVisible(true);
	}
	
protected void mouseClickedLblIngresar(MouseEvent arg0) {
	tipoOperacion = ADICIONAR;
	lblMensaje.setText("Adicionando Empleado");
	txtCodigo.setText("" + ae.codigoCorrelativo());
	habilitarEntradas(true);
	habilitarOperaciones(false);
	txtCodigo.setEditable(false);
	txtApellidos.requestFocus();
	panel.setVisible(true);
	lblBuscar.setVisible(false);
	habilitarBotones(false);
	lblCancelar.setVisible(true);
	lblAgregar.setText("Ingresar");
	visibleNombre(true);
	visibleApellido(true);
	visibleTurno(true);
	visibleTipo(true);
	visibleLogin(true);
	visiblePassword(true);
	lblGrabar.setVisible(true);
	lblAgregar.setVisible(true);
	
}
		
		
	
	protected void mouseClickedLblAgregar(MouseEvent arg0) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarEmpleado();
			limpieza();
			txtCodigo.setText("" + ae.codigoCorrelativo());
			 habilitarEntradas(true);
			 lblAgregar.setEnabled(true);
			 lblCancelar.setEnabled(true);
			 lblGrabar.setEnabled(true);
			 txtNombres.requestFocus();
			break;
		case CONSULTAR:
			limpieza();
			habilitarBusqueda(false);
			habilitarOperaciones(true);
			lblMensaje.setText("");
			 lblBuscar.setEnabled(true);
			break;
		case MODIFICAR:
			modificarEmpleado();
			habilitarEntradas(true);
			lblAgregar.setEnabled(true);
			 lblCancelar.setEnabled(true);
			 lblGrabar.setEnabled(true);
			 txtNombres.requestFocus();
			 lblBuscar.setEnabled(true);
			
			break;
		case ELIMINAR:
			eliminarEmpleado();
			 lblBuscar.setEnabled(true);
			 lblAgregar.setEnabled(true);
			 lblCancelar.setEnabled(true);
			 lblGrabar.setEnabled(true);
			
	}

		
	}
	protected void mouseClickedLblCancelar(MouseEvent arg0) {
		panel.setVisible(false);
		if (tipoOperacion != ADICIONAR)
			habilitarBusqueda(false);
		lblMensaje.setText("");
		habilitarEntradas(false);
		habilitarOperaciones(true);
		habilitarBotones(true);
	}
	protected void mouseClickedLblBuscar(MouseEvent arg0) {
		consultarEmpleado();	
	}
	protected void mouseClickedLblGrabar(MouseEvent arg0) {
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
		
	}

