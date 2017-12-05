package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.MatteBorder;

public class DlgCamas extends JDialog implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNroCama;
	private JLabel lblCategoria;
	private JLabel lblPrecioPorDia;
	private JTextField txtPrecioxDia;
	private JScrollPane scrollPane;
	private JTextField txtNroCama;
	private JLabel lblEstado;
	private JComboBox<String> cboCategoria;
	private JComboBox<String> cboEstado;
	private JScrollPane scpMedicamentos;
	private JLabel lblMensaje;
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
	private JLabel lblIngresar;
	private JLabel lblIconCodigoCama;
	private JSeparator SepNroCama;
	private JLabel lblIconPrecioCama;
	private JSeparator SepPrecioxDia;
	private JLabel lblConsultar;
	private JLabel lblModificar;
	private JLabel lblEliminar;
	private JLabel lblBuscarCama;
	private JLabel lblAgregarCama;
	private JLabel lblCancelarCama;
	private JLabel lblGrabarCama;
	private JPanel panel_1;
	private int x;
	private int y;
	private JLabel label;

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
		setUndecorated(true);
		setModal(true);
		setResizable(false);
		setTitle("MANTENIMIENTO | CAMAS");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1199, 690);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 251, -394, -54);
		contentPane.add(scrollPane);

		scpMedicamentos = new JScrollPane();
		scpMedicamentos.setBounds(10, 174, 756, 505);
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

		rdbtnLibre = new JRadioButton("LIBRE");
		rdbtnLibre.setBounds(243, 130, 70, 23);
		rdbtnLibre.addActionListener(this);
		rdbtnLibre.setSelected(true);
		rdbtnLibre.setForeground(Color.BLACK);
		rdbtnLibre.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnLibre.setBackground(Color.WHITE);
		contentPane.add(rdbtnLibre);

		rdbtnOcupado = new JRadioButton("OCUPADO");
		rdbtnOcupado.setBounds(315, 130, 103, 23);
		rdbtnOcupado.addActionListener(this);
		rdbtnOcupado.setForeground(Color.BLACK);
		rdbtnOcupado.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnOcupado.setBackground(Color.WHITE);
		contentPane.add(rdbtnOcupado);

		rdbtnTodo = new JRadioButton("TODO");
		rdbtnTodo.setBounds(420, 130, 70, 23);
		rdbtnTodo.addActionListener(this);
		rdbtnTodo.setForeground(Color.BLACK);
		rdbtnTodo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnTodo.setBackground(Color.WHITE);
		contentPane.add(rdbtnTodo);

		bp = new ButtonGroup();
		bp.add(rdbtnLibre);
		bp.add(rdbtnOcupado);
		bp.add(rdbtnTodo);
																										
																										lblIngresar = new JLabel("INGRESAR");
																										lblIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																										lblIngresar.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/ingresarNegro.png")));
																										lblIngresar.addMouseListener(this);
																										lblIngresar.setInheritsPopupMenu(false);
																										lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
																										lblIngresar.setForeground(new Color(10,20,26));
																										lblIngresar.setFont(new Font("Dialog", Font.BOLD, 16));
																										lblIngresar.setBorder(new LineBorder(new Color(10,20,26), 1, true));
																										lblIngresar.setBackground(new Color(1, 168, 25));
																										lblIngresar.setBounds(10, 62, 169, 37);
																										contentPane.add(lblIngresar);
																										
																										lblConsultar = new JLabel("CONSULTAR");
																										lblConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																										lblConsultar.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/consultarNegro.png")));
																										lblConsultar.addMouseListener(this);
																										lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
																										lblConsultar.setForeground(new Color(10,20,26));
																										lblConsultar.setFont(new Font("Dialog", Font.BOLD, 16));
																										lblConsultar.setBorder(new LineBorder(new Color(10,20,26), 1, true));
																										lblConsultar.setBackground(new Color(1, 168, 25));
																										lblConsultar.setBounds(198, 63, 169, 36);
																										contentPane.add(lblConsultar);
																										
																										lblModificar = new JLabel("MODIFICAR");
																										lblModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																										lblModificar.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/modificarNegro.png")));
																										lblModificar.addMouseListener(this);
																										lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
																										lblModificar.setForeground(new Color(10,20,26));
																										lblModificar.setFont(new Font("Dialog", Font.BOLD, 16));
																										lblModificar.setBorder(new LineBorder(new Color(10,20,26), 1, true));
																										lblModificar.setBackground(new Color(1, 168, 25));
																										lblModificar.setBounds(388, 63, 175, 36);
																										contentPane.add(lblModificar);
																										
																										lblEliminar = new JLabel("ELIMINAR");
																										lblEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																										lblEliminar.addMouseListener(this);
																										lblEliminar.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/modificarNegro.png")));
																										lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
																										lblEliminar.setForeground(new Color(10,20,26));
																										lblEliminar.setFont(new Font("Dialog", Font.BOLD, 16));
																										lblEliminar.setBorder(new LineBorder(new Color(10,20,26), 1, true));
																										lblEliminar.setBounds(583, 63, 183, 36);
																										contentPane.add(lblEliminar);
																										
																										panel_1 = new JPanel();
																										panel_1.setForeground(Color.WHITE);
																										panel_1.setBackground(new Color(255, 255, 255));
																										panel_1.setBounds(776, 62, 404, 617);
																										contentPane.add(panel_1);
																										panel_1.setLayout(null);
																										
																												lblPrecioPorDia = new JLabel("PRECIO POR D\u00CDA");
																												lblPrecioPorDia.setBounds(54, 234, 110, 14);
																												panel_1.add(lblPrecioPorDia);
																												lblPrecioPorDia.setForeground(Color.BLACK);
																												lblPrecioPorDia.setHorizontalAlignment(SwingConstants.RIGHT);
																												lblPrecioPorDia.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
																												
																														txtPrecioxDia = new JTextField();
																														txtPrecioxDia.setBounds(78, 259, 118, 29);
																														panel_1.add(txtPrecioxDia);
																														txtPrecioxDia.addKeyListener(this);
																														txtPrecioxDia.setForeground(Color.BLACK);
																														txtPrecioxDia.setFont(new Font("Arial", Font.BOLD, 12));
																														txtPrecioxDia.setEditable(false);
																														txtPrecioxDia.setColumns(10);
																														txtPrecioxDia.setBorder(null);
																														txtPrecioxDia.setOpaque(false);
																														
																																txtNroCama = new JTextField();
																																txtNroCama.setBounds(79, 104, 86, 29);
																																panel_1.add(txtNroCama);
																																txtNroCama.addKeyListener(this);
																																txtNroCama.setForeground(Color.BLACK);
																																txtNroCama.setFont(new Font("Arial", Font.BOLD, 12));
																																txtNroCama.setEditable(true);
																																txtNroCama.setColumns(10);
																																txtNroCama.setBorder(null);
																																txtNroCama.setOpaque(false);
																																
																																		cboCategoria = new JComboBox<String>();
																																		cboCategoria.setBounds(92, 183, 161, 29);
																																		panel_1.add(cboCategoria);
																																		cboCategoria.setEnabled(false);
																																		cboCategoria.setForeground(Color.BLACK);
																																		cboCategoria.setFont(new Font("Arial", Font.BOLD, 12));
																																		
																																				cboEstado = new JComboBox<String>();
																																				cboEstado.setBounds(92, 342, 161, 29);
																																				panel_1.add(cboEstado);
																																				cboEstado.setEnabled(false);
																																				cboEstado.setForeground(Color.BLACK);
																																				cboEstado.setFont(new Font("Arial", Font.BOLD, 12));
																																				
																																				lblIconCodigoCama = new JLabel("");
																																				lblIconCodigoCama.setBounds(51, 104, 30, 29);
																																				panel_1.add(lblIconCodigoCama);
																																				lblIconCodigoCama.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/codigo.png")));
																																				
																																				SepNroCama = new JSeparator();
																																				SepNroCama.setBounds(51, 131, 145, 2);
																																				panel_1.add(SepNroCama);
																																				
																																				lblIconPrecioCama = new JLabel("");
																																				lblIconPrecioCama.setBounds(49, 259, 32, 29);
																																				panel_1.add(lblIconPrecioCama);
																																				lblIconPrecioCama.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/iconCama.png")));
																																				
																																				SepPrecioxDia = new JSeparator();
																																				SepPrecioxDia.setBounds(54, 286, 150, 2);
																																				panel_1.add(SepPrecioxDia);
																																				
																																				lblAgregarCama = new JLabel("Agregar");
																																				lblAgregarCama.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																				lblAgregarCama.setBounds(92, 445, 206, 39);
																																				panel_1.add(lblAgregarCama);
																																				lblAgregarCama.addMouseListener(this);
																																				lblAgregarCama.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/Agregar.png")));
																																				lblAgregarCama.setHorizontalAlignment(SwingConstants.CENTER);
																																				lblAgregarCama.setForeground(Color.BLACK);
																																				lblAgregarCama.setFont(new Font("Tahoma", Font.BOLD, 14));
																																				lblAgregarCama.setBackground(Color.YELLOW);
																																				
																																				lblCancelarCama = new JLabel("Cancelar");
																																				lblCancelarCama.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																				lblCancelarCama.setBounds(92, 495, 206, 39);
																																				panel_1.add(lblCancelarCama);
																																				lblCancelarCama.addMouseListener(this);
																																				lblCancelarCama.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/regreso.png")));
																																				lblCancelarCama.setHorizontalAlignment(SwingConstants.CENTER);
																																				lblCancelarCama.setForeground(Color.BLACK);
																																				lblCancelarCama.setFont(new Font("Tahoma", Font.BOLD, 14));
																																				
																																				lblGrabarCama = new JLabel("Grabar");
																																				lblGrabarCama.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																				lblGrabarCama.setBounds(92, 546, 206, 41);
																																				panel_1.add(lblGrabarCama);
																																				lblGrabarCama.addMouseListener(this);
																																				lblGrabarCama.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/save.png")));
																																				lblGrabarCama.setOpaque(true);
																																				lblGrabarCama.setHorizontalAlignment(SwingConstants.CENTER);
																																				lblGrabarCama.setForeground(Color.WHITE);
																																				lblGrabarCama.setFont(new Font("Dialog", Font.PLAIN, 18));
																																				lblGrabarCama.setBackground(new Color(231, 96, 90));
																																				
																																						lblEstado = new JLabel("ESTADO");
																																						lblEstado.setBounds(34, 317, 66, 14);
																																						panel_1.add(lblEstado);
																																						lblEstado.setForeground(Color.BLACK);
																																						lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
																																						lblEstado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
																																						
																																								lblCategoria = new JLabel("CATEGORIA");
																																								lblCategoria.setBounds(34, 162, 90, 14);
																																								panel_1.add(lblCategoria);
																																								lblCategoria.setForeground(Color.BLACK);
																																								lblCategoria.setVisible(false);
																																								lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
																																								lblCategoria.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
																																								
																																								
																																										lblNroCama = new JLabel("NRO CAMA");
																																										lblNroCama.setBounds(10, 71, 81, 14);
																																										panel_1.add(lblNroCama);
																																										lblNroCama.setForeground(Color.BLACK);
																																										lblNroCama.setHorizontalAlignment(SwingConstants.RIGHT);
																																										lblNroCama.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
																																										
																																										lblBuscarCama = new JLabel("Buscar");
																																										lblBuscarCama.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																										lblBuscarCama.setBounds(233, 71, 170, 39);
																																										panel_1.add(lblBuscarCama);
																																										lblBuscarCama.addMouseListener(this);
																																										lblBuscarCama.setIcon(new ImageIcon(DlgCamas.class.getResource("/iconBotones/buscar.png")));
																																										lblBuscarCama.setHorizontalAlignment(SwingConstants.CENTER);
																																										lblBuscarCama.setForeground(Color.BLACK);
																																										lblBuscarCama.setFont(new Font("Tahoma", Font.BOLD, 14));
																																										lblBuscarCama.setBackground(Color.BLACK);
																																										
																																												lblMensaje = new JLabel("");
																																												lblMensaje.setBounds(10, 11, 383, 29);
																																												panel_1.add(lblMensaje);
																																												lblMensaje.setOpaque(true);
																																												lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
																																												lblMensaje.setForeground(Color.BLACK);
																																												lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
																																												lblMensaje.setBackground(Color.WHITE);
																																												
																																												JPanel panel = new JPanel();
																																												panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
																																												panel.setBackground(Color.WHITE);
																																												panel.addMouseMotionListener(new MouseMotionAdapter() {
																																													@Override
																																													public void mouseDragged(MouseEvent arg0) {
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
																																												panel.setBounds(0, 0, 1199, 37);
																																												contentPane.add(panel);
																																												panel.setLayout(null);
																																												
																																												JLabel lblNewLabel = new JLabel("");
																																												lblNewLabel.addMouseListener(new MouseAdapter() {
																																													@Override
																																													public void mouseClicked(MouseEvent arg0) {
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
																																												lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																												lblNewLabel.setIcon(new ImageIcon(DlgCamas.class.getResource("/image/icons8_Return_32px.png")));
																																												lblNewLabel.setBounds(1160, 0, 39, 37);
																																												panel.add(lblNewLabel);
																																												
																																												JLabel lblCamas = new JLabel("Camas");
																																												lblCamas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																																												lblCamas.setFont(new Font("Decker", Font.PLAIN, 16));
																																												lblCamas.setBounds(39, 0, 113, 37);
																																												panel.add(lblCamas);
																																												
																																												label = new JLabel("");
																																												label.setIcon(new ImageIcon(DlgCamas.class.getResource("/image/bed.png")));
																																												label.setBounds(10, 0, 25, 39);
																																												panel.add(label);
																																												
																																				cboEstado.addItem("LIBRE");
																																				cboEstado.addItem("OCUPADO");
																																		cboCategoria.addItem("ECONÓMICO");
																																		cboCategoria.addItem("EJECUTIVO");
																										panel_1.setVisible(false);

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
				lblMensaje.setText("Modificando Cama");
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
				visibleCategoria(false);
				visibleEstado(false);
				visiblePrecioxDia(false);
				lblAgregarCama.setVisible(false);
				lblGrabarCama.setVisible(false);
				
				if (tipoOperacion!=CONSULTAR){
					lblAgregarCama.setVisible(true);
					lblGrabarCama.setVisible(true);
				}
				
				
			}
			else {
				Libreria.mensajeAdvertencia(this, "El número " + leerNroCama() + " no existe");
				limpieza();
				lblMensaje.setText("");
				txtNroCama.setText("");
				txtNroCama.requestFocus();
				switch(tipoOperacion){
				case 0: lblMensaje.setText("Adiciondo cama");break;
				case 1: lblMensaje.setText("Modificando cama");break;
				case 2: lblMensaje.setText("Eliminando cama");break;
				case 3: lblMensaje.setText("Consultando cama");break;
				}
				
				lblCategoria.setVisible(false);
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
					lblMensaje.setText("Modificando camas");
					txtPrecioxDia.requestFocus();
				}
				else {
					lblMensaje.setText("Modificando camas");;
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
		txtNroCama.requestFocus();
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
		lblBuscarCama.setEnabled(sino);
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
		lblIngresar.setVisible(sino);
		lblConsultar.setVisible(sino);
		lblModificar.setVisible(sino);
		lblEliminar.setVisible(sino);
		lblAgregarCama.setEnabled(!sino);
		lblCancelarCama.setEnabled(!sino);
	}

	void habilitarBotones(boolean sino){
		lblConsultar.setVisible(sino);
		lblModificar.setVisible(sino);
		lblEliminar.setVisible(sino);
		lblIngresar.setVisible(sino);
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
	//*********************CLICKED***********************  mouseEnteredLblAgregarCama
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblGrabarCama){
			mouseClickedLblGrabarCama(e);
		}
		if (e.getSource() == lblCancelarCama) {
			mouseClickedLblCancelarCama(e);
		}
		if (e.getSource() == lblAgregarCama) {
			mouseClickedLblAgregarCama(e);
		}
		if (e.getSource() == lblBuscarCama) {
			mouseClickedLblBuscar(e);
		}
		if (e.getSource() == lblEliminar) {
			mouseClickedLblEliminar(e);
		}
		if (e.getSource() == lblModificar) {
			mouseClickedLblModificar(e);
		}
		if (e.getSource() == lblConsultar) {
			mouseClickedLblConsultar(e);
		}
		if (e.getSource() == lblIngresar) {
			mouseClickedLblIngresar(e);
		}
	}
	
	//*****************ENTERED***************************    mouseEnteredLblCancelarCama
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblGrabarCama) {
			mouseEnteredLblGrabarCama(e);
		}
		if (e.getSource() == lblCancelarCama) {
			mouseEnteredLblCancelarCama(e);
		}
		if (e.getSource() == lblAgregarCama) {
			mouseEnteredLblAgregarCama(e);
		}
		if (e.getSource() == lblAgregarCama) {
			mouseEnteredLblAgregarCama(e);
		}
		if (e.getSource() == lblBuscarCama) {
			mouseEnteredLblBuscar(e);
		}
		if (e.getSource() == lblEliminar) {
			mouseEnteredLblnEliminar(e);
		}
		if (e.getSource() == lblModificar) {
			mouseEnteredLblModificar(e);
		}
		if (e.getSource() == lblConsultar) {
			mouseEnteredLblConsultar(e);
		}
		if (e.getSource() == lblIngresar) {
			mouseEnteredBtnIngresar(e);
		}
		
	}

	//*********************EXITED*************************** 
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblCancelarCama) {
			mouseExitedLblCancelarCama(e);
		}
		if (e.getSource() == lblAgregarCama) {
			mouseExitedLblAgregarCama(e);
		}
		if (e.getSource() == lblBuscarCama) {
			mouseExitedLblBuscar(e);
		}
		if (e.getSource() == lblEliminar) {
			mouseExitedLblEliminar(e);
		}
		if (e.getSource() == lblModificar) {
			mouseExitedLblModificar(e);
		}
		if (e.getSource() == lblIngresar) {
			mouseExitedLblIngresar(e);
		}
		if (e.getSource() == lblConsultar) {
			mouseExitedLblConsultar(e);
		}
	}
	//*******************************************************************
	//*******************************************************
	
	public void mousePressed(MouseEvent e) {		
	}
	public void mouseReleased(MouseEvent e) {	
	}
	
	
	/*INGRESAR  MOUSE*/
	protected void mouseEnteredBtnIngresar(MouseEvent e) {
		lblIngresar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/ingresarBlnco.png")));
		lblIngresar.setOpaque(true);
		lblIngresar.setBackground(new Color(10, 20, 26));
		lblIngresar.setForeground(new Color(255,255,255));
		
	}
	
	protected void mouseExitedLblIngresar(MouseEvent arg0) {
		lblIngresar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/ingresarNegro.png")));
		lblIngresar.setOpaque(false);
		lblIngresar.setForeground(new Color(10, 20, 26));
		txtNroCama.requestFocus();
		
		}
	
	
	protected void mouseClickedLblIngresar(MouseEvent arg0) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando camas");
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtNroCama.requestFocus();
		panel_1.setVisible(true);
		lblBuscarCama.setVisible(false);
		habilitarBotones(false);
		lblCancelarCama.setVisible(true);
		lblAgregarCama.setText("Ingresar");
		//visibleCodigo(true);
		visibleCategoria(false);
		visiblePrecioxDia(false);
		visibleEstado(false);
		lblGrabarCama.setVisible(true);
		lblAgregarCama.setVisible(true);
		
		
		
		
	}
	
	
	
	
	//**************************************************************************
	//CONSULTAR MOUSE
	protected void mouseEnteredLblConsultar(MouseEvent e) {
		lblConsultar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/consultarBlnaco.png")));
		lblConsultar.setOpaque(true);
		lblConsultar.setBackground(new Color(10, 20, 26));
		lblConsultar.setForeground(new Color(255,255,255));
	}
	
	protected void mouseExitedLblConsultar(MouseEvent arg0) {
		lblConsultar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/consultarNegro.png")));
		lblConsultar.setOpaque(false);
		lblConsultar.setForeground(new Color(10, 20, 26));	
	}
	
	protected void mouseClickedLblConsultar(MouseEvent e) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando camas");
		habilitarOperaciones(false);
		cboEstado.setEnabled(false);
		panel_1.setVisible(true);
		visibleCodigo(false);
		visibleCategoria(true);
		visibleEstado(true);
		visiblePrecioxDia(true);
		lblAgregarCama.setVisible(false);
		lblGrabarCama.setVisible(false);
		lblBuscarCama.setEnabled(true);
		txtNroCama.setEditable(true);
		txtNroCama.requestFocus();
	}
	
	
	//***************************************************************************
	//MODIFICAR MOUSE 

	protected void mouseEnteredLblModificar(MouseEvent e) {
		lblModificar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/modificarBlanco.png")));
		lblModificar.setOpaque(true);
		lblModificar.setBackground(new Color(10, 20, 26));
		lblModificar.setForeground(new Color(255,255,255));
	}
	
	protected void mouseExitedLblModificar(MouseEvent arg0) {
		lblModificar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/modificarNegro.png")));
		lblModificar.setOpaque(false);
		lblModificar.setForeground(new Color(10, 20, 26));	
	}
	
	protected void mouseClickedLblModificar(MouseEvent e) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando camas");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
		panel_1.setVisible(true);
		visibleCodigo(false);
		visibleCategoria(true);
		visibleEstado(true);
		visiblePrecioxDia(true);
		lblAgregarCama.setText("Modificar");
		lblAgregarCama.setVisible(false);
		lblGrabarCama.setVisible(false);
		habilitarBotones(false);
		
		lblBuscarCama.setVisible(true);
	}
	
	//***************************************************************************
	//ELIMINAR MOUSE 
	protected void mouseEnteredLblnEliminar(MouseEvent e) {
		lblEliminar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/eliminarBlnco.png")));
		lblEliminar.setOpaque(true);
		lblEliminar.setBackground(new Color(10, 20, 26));
		lblEliminar.setForeground(new Color(255,255,255));
	}
	
	protected void mouseExitedLblEliminar(MouseEvent arg0) {
		lblEliminar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/eliminarNegro.png")));
		lblEliminar.setOpaque(false);
		lblEliminar.setForeground(new Color(10, 20, 26));	
	}
	
	
	protected void mouseClickedLblEliminar(MouseEvent e) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando camas");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
		cboEstado.setEnabled(false);
		panel_1.setVisible(true);
		visibleCategoria(true);
		visiblePrecioxDia(true);
		visibleEstado(true);
		lblAgregarCama.setText("Eliminar");
		lblAgregarCama.setVisible(false);
		lblGrabarCama.setVisible(false);
	}
	
	//***************************************************************************
		//BUSCAR CAMA  MOUSE EVENT
	protected void mouseEnteredLblBuscar(MouseEvent e){
		lblBuscarCama.setOpaque(true);
		lblBuscarCama.setBackground(new Color(30, 60, 79));
		lblBuscarCama.setForeground(new Color(255, 255, 255));
		lblBuscarCama.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/BuscarBlnco.png")));
	}
	
	protected void mouseExitedLblBuscar(MouseEvent arg0) {
		lblBuscarCama.setOpaque(false);
		lblBuscarCama.setForeground(new Color(10, 20, 26));
		lblBuscarCama.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/buscar.png")));
		//lblCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 60, 79)));
	}
	
	private void mouseClickedLblBuscar(MouseEvent arg0){
		consultarCama();
		panel_1.setVisible(true);
		visibleCodigo(false);
		txtNroCama.setEditable(true);
		txtNroCama.requestFocus();
	}
	
	//***************************************************************************
	//ACEPTAR CAMA  MOUSE EVENT
	protected void mouseEnteredLblAgregarCama(MouseEvent e) {
		lblAgregarCama.setOpaque(true);
		lblAgregarCama.setBackground(new Color(30, 60, 79));
		lblAgregarCama.setForeground(new Color(255, 255, 255));
		lblAgregarCama.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/AgregarBlanco.png")));
	}
	
	protected void mouseExitedLblAgregarCama(MouseEvent arg0) {
		lblAgregarCama.setOpaque(false);
		lblAgregarCama.setForeground(new Color(10, 20, 26));
		lblAgregarCama.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/Agregar.png")));
		//lblAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 60, 79)));
	}
	
	private void mouseClickedLblAgregarCama(MouseEvent arg0){
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarCama();
			limpieza();
			txtNroCama.setText("");
			habilitarEntradas(true);
			lblAgregarCama.setEnabled(true);
			lblCancelarCama.setEnabled(true);
			lblGrabarCama.setEnabled(true);
			habilitarBotones(false);
			lblMensaje.setText("Adicionando cama");
			txtNroCama.requestFocus();
			break;
		case CONSULTAR:
			limpieza();
			habilitarBusqueda(false);
			habilitarOperaciones(true);
			lblMensaje.setText("Consultando cama");
			lblBuscarCama.setVisible(true);
			break;
		case MODIFICAR:
			modificarCama();
			habilitarEntradas(true);
			lblAgregarCama.setEnabled(true);
			lblCancelarCama.setEnabled(true);
			lblGrabarCama.setEnabled(true);
			habilitarBotones(false);
			lblBuscarCama.setEnabled(true);
			lblMensaje.setText("Modificando cama");
			txtNroCama.requestFocus();
			
			break;
		case ELIMINAR:
			eliminarCama();
			habilitarBotones(false);
			lblBuscarCama.setEnabled(true);
			lblAgregarCama.setEnabled(true);
			lblCancelarCama.setEnabled(true);
			lblGrabarCama.setEnabled(true);
			lblMensaje.setText("Eliminando cama");
			txtNroCama.setEditable(true);
			
		}	
	}
	//***************************************************************************
	//CANCELAR CAMA  MOUSE EVENT	
	protected void mouseEnteredLblCancelarCama(MouseEvent e) {
		lblCancelarCama.setOpaque(true);
		lblCancelarCama.setBackground(new Color(30, 60, 79));
		lblCancelarCama.setForeground(new Color(255, 255, 255));
		lblCancelarCama.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regresoNegro.png")));
	}
	
	protected void mouseExitedLblCancelarCama(MouseEvent arg0) {
		lblCancelarCama.setOpaque(false);
		lblCancelarCama.setForeground(new Color(10, 20, 26));
		lblCancelarCama.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regreso.png")));
		//lblCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 60, 79)));
	}
	
	private void mouseClickedLblCancelarCama(MouseEvent arg0){
		if (tipoOperacion != ADICIONAR)
			habilitarBusqueda(false);
			lblMensaje.setText("");
			habilitarEntradas(false);
			habilitarOperaciones(true);
			panel_1.setVisible(false);
	}
	
	//***************************************************************************
	//GRABAR CAMA  MOUSE EVENT	
	protected void mouseEnteredLblGrabarCama(MouseEvent e) {
		
	}
	
	private void mouseClickedLblGrabarCama(MouseEvent e){
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
			Libreria.mensajeInformacion(this, "\"" + ac.getArchivo() + "\" ha sido creado");
		}
	}
	
	//******************************************************************************
	//VALIDACIONES DE ENTRADA PARA MOSTRAR LOS LABEL DENTRO DEL PANEL
	
	void visibleCodigo(boolean sino){
		lblNroCama.setVisible(!sino);
		lblIconCodigoCama.setVisible(!sino);
		txtNroCama.setVisible(!sino);
		SepNroCama.setVisible(!sino);
		
	}
	
	void visibleCategoria(boolean sino){
		lblCategoria.setVisible(!sino);
		cboCategoria.setVisible(!sino);
	}
	
	void visiblePrecioxDia(boolean sino){
		lblPrecioPorDia.setVisible(!sino);
		lblIconPrecioCama.setVisible(!sino);
		txtPrecioxDia.setVisible(!sino);
		SepPrecioxDia.setVisible(!sino);
	}
	
	void visibleEstado(boolean sino){
		lblEstado.setVisible(!sino);
		cboEstado.setVisible(!sino);
	}
}
