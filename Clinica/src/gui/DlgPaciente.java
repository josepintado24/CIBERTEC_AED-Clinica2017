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
import javax.swing.JPanel;
import javax.swing.ImageIcon;

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
	private JPanel panel;
	private JLabel lblIngresar;
	private JLabel lblConsultar;
	private JLabel lblModificar;
	private JLabel lblEliminar;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

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
		setBounds(100, 100, 1269, 883);
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
		tblPacientes.setForeground(Color.BLACK);
		tblPacientes.setFont(new Font("Arial", Font.BOLD, 14));
		tblPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPacientes.setRowHeight(25);
		;

		scrollPane = new JScrollPane(tblPacientes);
		scrollPane.setBounds(29, 278, 630, 360);
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
		btnAdicionar.setBounds(24, 11, 137, 39);
		ds.setCurvasButton(btnAdicionar, "imagenes/adicionar.png");
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBackground(Color.CYAN);
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnConsultar.setBounds(181, 11, 145, 39);
		ds.setCurvasButton(btnConsultar, "imagenes/consultar.png");
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(0, 139, 139));
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnModificar.setBounds(350, 11, 145, 39);
		ds.setCurvasButton(btnModificar, "imagenes/modificar.png");
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(127, 255, 212));
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnEliminar.setBounds(522, 11, 137, 39);
		ds.setCurvasButton(btnEliminar, "imagenes/eliminar.png");
		getContentPane().add(btnEliminar);

		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setBackground(Color.DARK_GRAY);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setOpaque(true);
		lblMensaje.setBounds(754, 11, 342, 29);
		getContentPane().add(lblMensaje);

		filtro = new JTextField();
		filtro.addKeyListener(this);
		filtro.setHorizontalAlignment(SwingConstants.CENTER);
		filtro.setForeground(Color.BLACK);
		filtro.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		filtro.setColumns(10);
		filtro.setBounds(190, 238, 257, 29);
		getContentPane().add(filtro);

		rdbtnApellidos = new JRadioButton("APELLIDOS");
		rdbtnApellidos.addActionListener(this);
		rdbtnApellidos.setSelected(true);
		rdbtnApellidos.setBounds(240, 213, 97, 23);
		getContentPane().add(rdbtnApellidos);

		rdbtnDni = new JRadioButton("DNI");
		rdbtnDni.addActionListener(this);
		rdbtnDni.setBounds(349, 213, 60, 23);
		getContentPane().add(rdbtnDni);

		bp = new ButtonGroup();
		bp.add(rdbtnApellidos);
		bp.add(rdbtnDni);

		lblBuscarPor = new JLabel("BUSCAR POR");
		lblBuscarPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscarPor.setForeground(Color.BLACK);
		lblBuscarPor.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblBuscarPor.setBounds(271, 192, 97, 14);
		getContentPane().add(lblBuscarPor);
		
		panel = new JPanel();
		panel.setBounds(692, 71, 546, 582);
		getContentPane().add(panel);
		panel.setLayout(null);
		
				lblCdigo = new JLabel("C\u00D3DIGO");
				lblCdigo.setBounds(93, 36, 75, 14);
				panel.add(lblCdigo);
				lblCdigo.setForeground(Color.BLACK);
				lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCdigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
				
						txtCodigo = new JTextField();
						txtCodigo.setBounds(162, 36, 137, 29);
						panel.add(txtCodigo);
						txtCodigo.addKeyListener(this);
						txtCodigo.setEditable(false);
						txtCodigo.setForeground(Color.BLACK);
						txtCodigo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
						txtCodigo.setColumns(10);
						
								btnBuscar = new JButton("BUSCAR");
								btnBuscar.setBounds(309, 36, 110, 29);
								panel.add(btnBuscar);
								btnBuscar.setBackground(new Color(102, 205, 170));
								btnBuscar.setEnabled(false);
								btnBuscar.addActionListener(this);
								btnBuscar.setForeground(Color.BLACK);
								btnBuscar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
								ds.setCurvasButton(btnBuscar, "imagenes/buscar.png");
								
										txtNombres = new JTextField();
										txtNombres.setBounds(162, 76, 257, 29);
										panel.add(txtNombres);
										txtNombres.addKeyListener(this);
										txtNombres.setEditable(false);
										txtNombres.setForeground(Color.BLACK);
										txtNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
										txtNombres.setColumns(10);
										
												txtApellidos = new JTextField();
												txtApellidos.setBounds(162, 116, 257, 29);
												panel.add(txtApellidos);
												txtApellidos.addKeyListener(this);
												txtApellidos.setEditable(false);
												txtApellidos.setForeground(Color.BLACK);
												txtApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
												txtApellidos.setColumns(10);
												
														txtTelefono = new JTextField();
														txtTelefono.setBounds(162, 156, 137, 29);
														panel.add(txtTelefono);
														txtTelefono.addKeyListener(this);
														txtTelefono.setEditable(false);
														txtTelefono.setForeground(Color.BLACK);
														txtTelefono.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
														txtTelefono.setColumns(10);
														
																txtDni = new JTextField();
																txtDni.setBounds(162, 196, 137, 29);
																panel.add(txtDni);
																txtDni.addKeyListener(this);
																txtDni.setEditable(false);
																txtDni.setForeground(Color.BLACK);
																txtDni.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																txtDni.setColumns(10);
																
																		lblNombres = new JLabel("NOMBRES");
																		lblNombres.setBounds(93, 76, 75, 14);
																		panel.add(lblNombres);
																		lblNombres.setForeground(Color.BLACK);
																		lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
																		lblNombres.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																		
																				lblApellidos = new JLabel("APELLIDOS");
																				lblApellidos.setBounds(93, 116, 75, 14);
																				panel.add(lblApellidos);
																				lblApellidos.setForeground(Color.BLACK);
																				lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
																				lblApellidos.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																				
																						lblTelfono = new JLabel("TEL\u00C9FONO");
																						lblTelfono.setBounds(93, 156, 75, 14);
																						panel.add(lblTelfono);
																						lblTelfono.setForeground(Color.BLACK);
																						lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
																						lblTelfono.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																						
																								lblDni = new JLabel("DNI");
																								lblDni.setBounds(93, 196, 75, 14);
																								panel.add(lblDni);
																								lblDni.setForeground(Color.BLACK);
																								lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
																								lblDni.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																								
																										btnAceptar = new JButton("ACEPTAR");
																										btnAceptar.setBounds(69, 437, 137, 39);
																										panel.add(btnAceptar);
																										btnAceptar.setBackground(new Color(30, 144, 255));
																										btnAceptar.setEnabled(false);
																										btnAceptar.addActionListener(this);
																										btnAceptar.setForeground(Color.BLACK);
																										btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																										ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
																										
																												btnCancelar = new JButton("CANCELAR");
																												btnCancelar.setBounds(264, 462, 145, 39);
																												panel.add(btnCancelar);
																												btnCancelar.setBackground(new Color(0, 255, 255));
																												btnCancelar.setEnabled(false);
																												btnCancelar.addActionListener(this);
																												btnCancelar.setForeground(Color.BLACK);
																												btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																												ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
																												
																														btnGuardarPacientes = new JButton("GUARDAR PACIENTES");
																														btnGuardarPacientes.setBounds(117, 512, 302, 39);
																														panel.add(btnGuardarPacientes);
																														btnGuardarPacientes.addActionListener(this);
																														btnGuardarPacientes.setForeground(Color.BLACK);
																														btnGuardarPacientes.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
																														btnGuardarPacientes.setBackground(new Color(0, 250, 154));
																														ds.setCurvasButton(btnGuardarPacientes, "imagenes/grabar.png");
																														
																														label = new JLabel("Agregar");
																														label.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/Agregar.png")));
																														label.setBackground(new Color(0, 0, 0));
																														label.setHorizontalAlignment(SwingConstants.CENTER);
																														label.setForeground(new Color(0, 0, 0));
																														label.setFont(new Font("Tahoma", Font.BOLD, 14));
																														label.setBounds(139, 257, 206, 39);
																														panel.add(label);
																														
																														label_1 = new JLabel("Cancelar");
																														label_1.setHorizontalAlignment(SwingConstants.CENTER);
																														label_1.setForeground(new Color(0, 0, 0));
																														label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
																														label_1.setBounds(139, 307, 206, 39);
																														panel.add(label_1);
																														
																														label_2 = new JLabel("Grabar");
																														label_2.setOpaque(true);
																														label_2.setHorizontalAlignment(SwingConstants.CENTER);
																														label_2.setForeground(Color.WHITE);
																														label_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
																														label_2.setBackground(new Color(231, 96, 90));
																														label_2.setBounds(139, 357, 206, 41);
																														panel.add(label_2);
																														
																														lblIngresar = new JLabel("INGRESAR");
																														lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/Ingresar.png")));
																														lblIngresar.setBackground(new Color(1, 168, 25));
																														lblIngresar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																														lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblIngresar.setBounds(24, 71, 151, 53);
																														getContentPane().add(lblIngresar);
																														
																														lblConsultar = new JLabel("CONSULTAR");
																														lblConsultar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/consultar.png")));
																														lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblConsultar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
																														lblConsultar.setBackground(new Color(1, 168, 25));
																														lblConsultar.setBounds(190, 72, 151, 53);
																														getContentPane().add(lblConsultar);
																														
																														lblModificar = new JLabel("MODIFICAR");
																														lblModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/modificar.png")));
																														lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblModificar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
																														lblModificar.setBackground(new Color(1, 168, 25));
																														lblModificar.setBounds(357, 72, 151, 53);
																														getContentPane().add(lblModificar);
																														
																														lblEliminar = new JLabel("Eliminar");
																														lblEliminar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/eliminar.png")));
																														lblEliminar.setOpaque(true);
																														lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
																														lblEliminar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
																														lblEliminar.setBackground(new Color(1, 168, 25));
																														lblEliminar.setBounds(532, 71, 151, 53);
																														getContentPane().add(lblEliminar);
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
