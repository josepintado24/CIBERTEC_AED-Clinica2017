package gui;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import org.yatusaes.FocusTraversalOnArray;

import clases.Paciente;
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
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;

public class DlgPaciente extends JDialog implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JScrollPane scrollPane;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JLabel lblMensaje;
	private JTable tblPacientes;
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
	private JPanel panel;
	private JLabel lblIngresar;
	private JLabel lblConsultar;
	private JLabel lblModificar;
	private JLabel lblEliminar;
	private JLabel lblAgregar;
	private JLabel lblCancelar;
	private JLabel lblGrabar;
	private JLabel lblBuscar;
	private JLabel iconCodigo;
	private JLabel iconNombre;
	private JLabel iconApellido;
	private JLabel iconDni;
	private JLabel iconTelefono;
	private JSeparator lineCodigo;
	private JSeparator lineNombre;
	private JSeparator lineApellido;
	private JSeparator lineDni;
	private JSeparator lineTelefono;
	private int x;
	private int y;

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
		setUndecorated(true);
		getContentPane().addMouseListener(this);
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setResizable(false);
		setTitle("");
		setBounds(100, 100, 1227, 726);
		getContentPane().setLayout(null);

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
		tblPacientes.setSurrendersFocusOnKeystroke(true);
		tblPacientes.setAutoscrolls(false);
		tblPacientes.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tblPacientes.setSelectionBackground(SystemColor.textHighlight);
		tblPacientes.setGridColor(Color.WHITE);
		tblPacientes.setBackground(Color.WHITE);
		tblPacientes.setForeground(Color.BLACK);
		tblPacientes.setFont(new Font("Decker", Font.BOLD, 16));
		tblPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPacientes.setRowHeight(25);
		
		;

		scrollPane = new JScrollPane(tblPacientes);
		scrollPane.setBorder(new LineBorder(Color.GRAY, 2, true));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(12, 211, 758, 504);
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

		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.BLACK);
		lblMensaje.setBackground(Color.WHITE);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblMensaje.setOpaque(true);
		lblMensaje.setBounds(794, 65, 412, 29);
		getContentPane().add(lblMensaje);

		filtro = new JTextField();
		filtro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		filtro.addKeyListener(this);
		filtro.setHorizontalAlignment(SwingConstants.CENTER);
		filtro.setForeground(Color.BLACK);
		filtro.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		filtro.setColumns(10);
		filtro.setBounds(249, 172, 257, 29);
		getContentPane().add(filtro);

		rdbtnApellidos = new JRadioButton("APELLIDOS");
		rdbtnApellidos.setForeground(Color.BLACK);
		rdbtnApellidos.setBackground(Color.WHITE);
		rdbtnApellidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnApellidos.addActionListener(this);
		rdbtnApellidos.setSelected(true);
		rdbtnApellidos.setBounds(299, 147, 97, 23);
		getContentPane().add(rdbtnApellidos);

		rdbtnDni = new JRadioButton("DNI");
		rdbtnDni.setBackground(Color.WHITE);
		rdbtnDni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnDni.addActionListener(this);
		rdbtnDni.setBounds(408, 147, 60, 23);
		getContentPane().add(rdbtnDni);

		bp = new ButtonGroup();
		bp.add(rdbtnApellidos);
		bp.add(rdbtnDni);

		lblBuscarPor = new JLabel("BUSCAR POR :");
		lblBuscarPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscarPor.setForeground(Color.BLACK);
		lblBuscarPor.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblBuscarPor.setBounds(309, 126, 121, 14);
		getContentPane().add(lblBuscarPor);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(804, 105, 396, 610);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
				lblCodigo = new JLabel("C\u00D3DIGO");
				lblCodigo.setBounds(31, 11, 90, 22);
				panel.add(lblCodigo);
				lblCodigo.setForeground(Color.BLACK);
				lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
				lblCodigo.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
						
						lineNombre = new JSeparator();
						lineNombre.setForeground(Color.BLACK);
						lineNombre.setBackground(Color.BLACK);
						lineNombre.setBounds(44, 146, 297, 5);
						panel.add(lineNombre);
				
						txtCodigo = new JTextField();
						txtCodigo.setHorizontalAlignment(SwingConstants.LEFT);
						txtCodigo.setBounds(84, 44, 137, 29);
						panel.add(txtCodigo);
						txtCodigo.addKeyListener(this);
						txtCodigo.setEditable(false);
						txtCodigo.setForeground(Color.BLACK);
						txtCodigo.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
						txtCodigo.setColumns(10);
						txtCodigo.setBorder(null);
						txtCodigo.setOpaque(false);
								
										txtNombres = new JTextField();
										txtNombres.setHorizontalAlignment(SwingConstants.LEFT);
										txtNombres.setBounds(84, 119, 257, 29);
										panel.add(txtNombres);
										txtNombres.addKeyListener(this);
										txtNombres.setEditable(false);
										txtNombres.setForeground(Color.BLACK);
										txtNombres.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
										txtNombres.setColumns(10);
										txtNombres.setBorder(null);
										txtNombres.setOpaque(false);
										
												txtApellidos = new JTextField();
												txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
												txtApellidos.setBounds(84, 216, 257, 29);
												panel.add(txtApellidos);
												txtApellidos.addKeyListener(this);
												txtApellidos.setEditable(false);
												txtApellidos.setForeground(Color.BLACK);
												txtApellidos.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
												txtApellidos.setColumns(10);
												txtApellidos.setBorder(null);
												txtApellidos.setOpaque(false);
												
														txtTelefono = new JTextField();
														txtTelefono.setHorizontalAlignment(SwingConstants.LEFT);
														txtTelefono.setBounds(84, 385, 137, 29);
														panel.add(txtTelefono);
														txtTelefono.addKeyListener(this);
														txtTelefono.setEditable(false);
														txtTelefono.setForeground(Color.BLACK);
														txtTelefono.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
														txtTelefono.setColumns(10);
														txtTelefono.setBorder(null);
														txtTelefono.setOpaque(false);
														
																txtDni = new JTextField();
																txtDni.setHorizontalAlignment(SwingConstants.LEFT);
																txtDni.setBounds(84, 294, 137, 29);
																panel.add(txtDni);
																txtDni.addKeyListener(this);
																txtDni.setEditable(false);
																txtDni.setForeground(Color.BLACK);
																txtDni.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
																txtDni.setColumns(10);
																txtDni.setBorder(null);
																txtDni.setOpaque(false);
																
																		lblNombres = new JLabel("NOMBRES");
																		lblNombres.setBounds(31, 94, 103, 14);
																		panel.add(lblNombres);
																		lblNombres.setForeground(Color.BLACK);
																		lblNombres.setHorizontalAlignment(SwingConstants.LEFT);
																		lblNombres.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
																		
																				lblApellidos = new JLabel("APELLIDOS");
																				lblApellidos.setVerticalAlignment(SwingConstants.BOTTOM);
																				lblApellidos.setBounds(31, 167, 120, 23);
																				panel.add(lblApellidos);
																				lblApellidos.setForeground(Color.BLACK);
																				lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
																				lblApellidos.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
																				
																						lblTelefono = new JLabel("TEL\u00C9FONO");
																						lblTelefono.setBounds(31, 345, 117, 14);
																						panel.add(lblTelefono);
																						lblTelefono.setForeground(Color.BLACK);
																						lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
																						lblTelefono.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
																						
																								lblDni = new JLabel("DNI");
																								lblDni.setBounds(31, 269, 90, 14);
																								panel.add(lblDni);
																								lblDni.setForeground(Color.BLACK);
																								lblDni.setHorizontalAlignment(SwingConstants.LEFT);
																								lblDni.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
																														
																														lblAgregar = new JLabel("Agregar");
																														lblAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblAgregar.addMouseListener(this);
																														lblAgregar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/Agregar.png")));
																														lblAgregar.setBackground(new Color(255, 255, 0));
																														lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblAgregar.setForeground(new Color(0, 0, 0));
																														lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
																														lblAgregar.setBounds(123, 455, 206, 39);
																														panel.add(lblAgregar);
																														//lblAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 60, 79)));
																														
																														
																														lblCancelar = new JLabel("Cancelar");
																														lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblCancelar.addMouseListener(this);
																														lblCancelar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regreso.png")));
																														lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblCancelar.setForeground(new Color(0, 0, 0));
																														lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
																														lblCancelar.setBounds(123, 505, 206, 39);
																														panel.add(lblCancelar);
																														
																														lblGrabar = new JLabel("Grabar");
																														lblGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblGrabar.addMouseListener(this);
																														lblGrabar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/save.png")));
																														lblGrabar.setOpaque(true);
																														lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblGrabar.setForeground(Color.WHITE);
																														lblGrabar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
																														lblGrabar.setBackground(new Color(231, 96, 90));
																														lblGrabar.setBounds(123, 555, 206, 41);
																														panel.add(lblGrabar);
																														
																														lblBuscar = new JLabel("Buscar");
																														lblBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblBuscar.addMouseListener(this);
																														lblBuscar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/buscar.png")));
																														lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblBuscar.setForeground(Color.BLACK);
																														lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
																														lblBuscar.setBackground(Color.BLACK);
																														lblBuscar.setBounds(254, 37, 170, 39);
																														panel.add(lblBuscar);
																														
																														iconCodigo = new JLabel("");
																														iconCodigo.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/codigo.png")));
																														iconCodigo.setBounds(41, 44, 24, 22);
																														iconNombre = new JLabel("");
																														iconNombre.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/user30.png")));
																														iconNombre.setBounds(41, 119, 35, 27);
																														panel.add(iconNombre);
																														
																														iconApellido = new JLabel("");
																														iconApellido.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/user30.png")));
																														iconApellido.setBounds(39, 216, 35, 29);
																														panel.add(iconApellido);
																														
																														iconDni = new JLabel("");
																														iconDni.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/idDNI.png")));
																														iconDni.setBounds(41, 294, 35, 29);
																														panel.add(iconDni);
																														
																														iconTelefono = new JLabel("");
																														iconTelefono.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/telefono30.png")));
																														iconTelefono.setBounds(41, 375, 35, 39);
																														panel.add(iconTelefono);
																														
																														lineCodigo = new JSeparator();
																														lineCodigo.setBackground(new Color(0, 0, 0));
																														lineCodigo.setForeground(new Color(0, 0, 0));
																														lineCodigo.setBounds(44, 70, 186, 4);
																														panel.add(lineCodigo);
																														
																														lineApellido = new JSeparator();
																														lineApellido.setForeground(Color.BLACK);
																														lineApellido.setBackground(Color.BLACK);
																														lineApellido.setBounds(44, 244, 297, 5);
																														panel.add(lineApellido);
																														
																														lineDni = new JSeparator();
																														lineDni.setForeground(Color.BLACK);
																														lineDni.setBackground(Color.BLACK);
																														lineDni.setBounds(54, 323, 170, 4);
																														panel.add(lineDni);
																														
																														lineTelefono = new JSeparator();
																														lineTelefono.setForeground(new Color(192, 192, 192));
																														lineTelefono.setBackground(Color.BLACK);
																														lineTelefono.setBounds(56, 413, 170, 4);
																														panel.add(lineTelefono);
																														
																														JLabel Codigo = new JLabel("");
																														Codigo.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/codigo.png")));
																														Codigo.setBounds(41, 37, 26, 36);
																														panel.add(Codigo);
																														
																														lblIngresar = new JLabel("INGRESAR");
																														lblIngresar.setInheritsPopupMenu(false);
																														lblIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblIngresar.setForeground(new Color(243, 124, 47));
																														lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/ingresarNaranja.png")));
																														lblIngresar.addMouseListener(this);
																														lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/ingresarNaranja.png")));
																														lblIngresar.setBackground(new Color(1, 168, 25));
																														lblIngresar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																														lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblIngresar.setBounds(12, 67, 169, 37);
																														getContentPane().add(lblIngresar);
																														lblIngresar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																														
																														lblConsultar = new JLabel("CONSULTAR");
																														lblConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblConsultar.setForeground(new Color(243, 124, 47));
																														lblConsultar.addMouseListener(this);
																														lblConsultar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/consultarNaranja.png")));
																														lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblConsultar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																														lblConsultar.setBackground(new Color(1, 168, 25));
																														lblConsultar.setBounds(200, 68, 169, 36);
																														getContentPane().add(lblConsultar);
																														lblConsultar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																														
																														lblModificar = new JLabel("MODIFICAR");
																														lblModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblModificar.setForeground(new Color(243, 124, 47));
																														lblModificar.addMouseListener(this);
																														lblModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/modificarNaranja.png")));
																														lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblModificar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																														lblModificar.setBackground(new Color(1, 168, 25));
																														lblModificar.setBounds(390, 68, 175, 36);
																														getContentPane().add(lblModificar);
																														lblModificar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																														
																														lblEliminar = new JLabel("ELIMINAR");
																														lblEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblEliminar.setForeground(new Color(243, 124, 47));
																														lblEliminar.addMouseListener(this);
																														lblEliminar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/eliminarNaranja.png")));
																														lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblEliminar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																														lblEliminar.setBackground(Color.RED);
																														lblEliminar.setBounds(585, 68, 183, 36);
																														getContentPane().add(lblEliminar);
																														lblEliminar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
																														
																														JPanel panel_1 = new JPanel();
																														panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														panel_1.addMouseMotionListener(new MouseMotionAdapter() {
																															@Override
																															public void mouseDragged(MouseEvent arg0) {
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
																														panel_1.setBounds(0, 0, 1227, 38);
																														getContentPane().add(panel_1);
																														panel_1.setLayout(null);
																														
																														JLabel lblNewLabel = new JLabel("");
																														lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblNewLabel.addMouseListener(new MouseAdapter() {
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
																														lblNewLabel.setIcon(new ImageIcon(DlgPaciente.class.getResource("/image/icons8_Return_32px.png")));
																														lblNewLabel.setBounds(1185, 0, 32, 34);
																														panel_1.add(lblNewLabel);
																														
																														JLabel lblPaciente = new JLabel("Paciente");
																														lblPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														lblPaciente.setFont(new Font("Decker", Font.PLAIN, 16));
																														lblPaciente.setBounds(33, 0, 72, 34);
																														panel_1.add(lblPaciente);
																														
																														JLabel label = new JLabel("");
																														label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																														label.setIcon(new ImageIcon(DlgPaciente.class.getResource("/image/paciente2.png")));
																														label.setBounds(10, 0, 40, 34);
																														panel_1.add(label);
						setFocusTraversalPolicy(new FocusTraversalOnArray(
								new Component[] { txtCodigo, txtNombres, txtApellidos, txtTelefono, txtDni }));

		listado();
		modeloTabla();
		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == rdbtnDni) {
			actionPerformedRdbtnDni(arg0);
		}
		if (arg0.getSource() == rdbtnApellidos) {
			actionPerformedRdbtnApellidos(arg0);
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
			Paciente nuevo = new Paciente(leerCodigo(), leerNombres(), leerApellidos(), leerTelefono(), leerDni());
			ap.adicionar(nuevo);
			listado();
			habilitarEntradas(true);
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
				if ((tipoOperacion != CONSULTAR)&&(tipoOperacion != ADICIONAR)){
					lblAgregar.setVisible(true);
					lblGrabar.setVisible(true);
				}
				noVisibleNombre();
				noVisibleApellido();
				noVisibleDni();
				noVisibleTelefono();
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
					habilitarBusqueda(true);
					habilitarEntradas(true);
					limpieza();
					visibleApellido();
					visibleDni();
					visibleNombre();
					visibleTelefono();
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
				habilitarBusqueda(true);
				visibleApellido();
				visibleDni();
				visibleNombre();
				visibleTelefono();
				//habilitarOperaciones(true);
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
		txtNombres.setEditable(sino);
		txtApellidos.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtDni.setEditable(sino);
		txtCodigo.setEditable(sino);
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
	
private void editableTrue(){
		
		txtCodigo.setEditable(true);
		txtDni.setEditable(true);
		txtApellidos.setEditable(true);
		txtNombres.setEditable(true);
		txtTelefono.setEditable(true);
		noVisibleCodigo();
		noVisibleNombre();
		noVisibleApellido();
		noVisibleDni();
		noVisibleTelefono();
	}
	private void editableFalse(){
		txtCodigo.setEditable(false);
		txtDni.setEditable(false);
		txtApellidos.setEditable(false);
		txtNombres.setEditable(false);
		txtTelefono.setEditable(false);
		
		
	}
	private void visibleCodigo(){
		txtCodigo.setVisible(false);
		lblCodigo.setVisible(false);
		lineCodigo.setVisible(false);
		iconCodigo.setVisible(false);
	}
	private void visibleNombre(){
		txtNombres.setVisible(false);
		lblNombres.setVisible(false);
		lineNombre.setVisible(false);
		iconNombre.setVisible(false);
	}
	private void visibleApellido(){
		txtApellidos.setVisible(false);
		lblApellidos.setVisible(false);
		lineApellido.setVisible(false);
		iconApellido.setVisible(false);
	}
	private void visibleDni(){
		txtDni.setVisible(false);
		lblDni.setVisible(false);
		lineDni.setVisible(false);
		iconDni.setVisible(false);
	}
	private void visibleTelefono(){
		txtTelefono.setVisible(false);
		lblTelefono.setVisible(false);
		lineTelefono.setVisible(false);
		iconTelefono.setVisible(false);
	}
	
	////////
	private void noVisibleCodigo(){
		txtCodigo.setVisible(true);
		txtCodigo.setEditable(true);
		lblCodigo.setVisible(true);
		lineCodigo.setVisible(true);
		iconCodigo.setVisible(true);
	}
	private void noVisibleNombre(){
		txtNombres.setVisible(true);
		txtNombres.setEditable(true);
		lblNombres.setVisible(true);
		lineNombre.setVisible(true);
		iconNombre.setVisible(true);
	}
	private void noVisibleApellido(){
		txtApellidos.setVisible(true);
		txtApellidos.setEditable(true);
		lblApellidos.setVisible(true);
		lineApellido.setVisible(true);
		iconApellido.setVisible(true);
	}
	private void noVisibleDni(){
		txtDni.setVisible(true);
		txtDni.setEditable(true);
		lblDni.setVisible(true);
		lineDni.setVisible(true);
		iconDni.setVisible(true);
	}
	private void noVisibleTelefono(){
		txtTelefono.setVisible(true);
		txtTelefono.setEditable(true);
		lblTelefono.setVisible(true);
		lineTelefono.setVisible(true);
		iconTelefono.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent arg0) {
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
		if (arg0.getSource() == lblGrabar) {
			mouseClickedLblGrabar(arg0);
		}
		if (arg0.getSource() == lblBuscar) {
			mouseClickedLblBuscar(arg0);
		}
		if (arg0.getSource() == lblEliminar) {
			mouseClickedLblEliminar(arg0);
		}
		
	}
	private void mouseClickedLblEliminar(MouseEvent arg0){
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Paciente");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
		visibleApellido();
		visibleDni();
		visibleNombre();
		visibleTelefono();
		lblAgregar.setVisible(false);
		lblGrabar.setVisible(false);
		lblAgregar.setText("Eliminar");
	
	}
	private void mouseClickedLblBuscar(MouseEvent arg0){
		consultarPaciente();
	}
	
	
		private void mouseClickedLblGrabar(MouseEvent arg0){
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
	protected void mouseClickedLblAgregar(MouseEvent arg0) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarPaciente();
			limpieza();
			txtCodigo.setText("" + ap.codigoCorrelativo());
			break;
		case CONSULTAR:
			limpieza();
			habilitarBusqueda(false);
			habilitarOperaciones(true);
			lblMensaje.setText("");
			break;
		case MODIFICAR:
			modificarPaciente();
			
			break;
		case ELIMINAR:
			eliminarPaciente();
			
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
	protected void mouseClickedLblModificar(MouseEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Paciente");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
		panel.setVisible(true);
		noVisibleCodigo();
		visibleNombre();
		visibleApellido();
		visibleDni();
		visibleTelefono();
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
		txtCodigo.setText("" + ap.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.setEditable(false);
		txtNombres.requestFocus();
		lblBuscar.setVisible(false);
		lblGrabar.setVisible(true);
		lblAgregar.setText("Agregar");
		
		
		
	}
	protected void mouseClickedLblConsultar(MouseEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Paciente");
		panel.setVisible(true);
		noVisibleCodigo();
		visibleNombre();
		visibleApellido();
		visibleDni();
		visibleTelefono();
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		lblAgregar.setVisible(false);
		lblGrabar.setVisible(false);
		
	}
	
	
	
	
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == getContentPane()) {
			mouseEnteredThisContentPane(e);
		}
		if (e.getSource() == lblGrabar) {
			mouseEnteredLabel_2(e);
		}
		if (e.getSource() == lblCancelar) {
			mouseEnteredCancelar(e);
		}
		if (e.getSource() == lblAgregar) {
			mouseEnteredlblAgregar(e);
		}
		if (e.getSource() == lblBuscar) {
			mouseEnteredLblBuscar(e);
		}
		if (e.getSource() == lblEliminar) {
			mouseEnteredLblEliminar(e);
		}
		if (e.getSource() == lblModificar) {
			mouseEnteredLblModificar(e);
		}
		if (e.getSource() == lblConsultar) {
			mouseEnteredLblConsultar(e);
		}
		if (e.getSource() == lblIngresar) {
			mouseEnteredLblIngresar(e);
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
	///SALIR
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
	protected void mouseExitedLblModificar(MouseEvent arg0) {
		lblModificar.setOpaque(false);
		lblModificar.setForeground(new Color(243, 124, 47));
		lblModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/modificarNaranja.png")));
		lblModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
		
	}
	protected void mouseExitedLblConsultar(MouseEvent arg0) {
		lblConsultar.setOpaque(false);
		lblConsultar.setForeground(new Color(243, 124, 47));
		lblConsultar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/consultarNaranja.png")));
		lblConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
	}
	protected void mouseExitedLblIngresar(MouseEvent arg0) {
		lblIngresar.setOpaque(false);
		lblIngresar.setForeground(new Color(243, 124, 47));
		lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/ingresarNaranja.png")));
		lblIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
	}
	protected void mouseExitedLblEliminar(MouseEvent arg0) {
		lblEliminar.setOpaque(false);
		lblEliminar.setForeground(new Color(243, 124, 47));
		lblEliminar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/eliminarNaranja.png")));
		lblEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
	}
	
	
	
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	protected void mouseEnteredLblIngresar(MouseEvent e) {
		lblIngresar.setOpaque(true);
		lblIngresar.setBackground(new Color(243, 124, 47));
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/ingresarBlnco.png")));
	}
	protected void mouseEnteredLblConsultar(MouseEvent e) {
		lblConsultar.setOpaque(true);
		lblConsultar.setBackground(new Color(243, 124, 47));
		lblConsultar.setForeground(new Color(255, 255, 255));
		lblConsultar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/consultarBlnaco.png")));
	}
	protected void mouseEnteredLblModificar(MouseEvent e) {
		
		lblModificar.setOpaque(true);
		lblModificar.setBackground(new Color(243, 124, 47));
		lblModificar.setForeground(new Color(255, 255, 255));
		lblModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/modificarBlanco.png")));
	}
	protected void mouseEnteredLblEliminar(MouseEvent e) {
		lblEliminar.setOpaque(true);
		lblEliminar.setBackground(new Color(243, 124, 47));
		lblEliminar.setForeground(new Color(255, 255, 255));
		lblEliminar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/eliminarBlnco.png")));
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
	protected void mouseEnteredLabel_2(MouseEvent e) {
	}
	protected void mouseEnteredThisContentPane(MouseEvent e) {
	}
}
