package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloCamas;
import arreglos.ArregloHospitalizacion;
import arreglos.ArregloPaciente;
import clases.Camas;
import clases.Internamiento;
import libreria.DiseñoObjetos;
import libreria.Fecha;
import libreria.Libreria;

import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingConstants;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSeparator;
import java.awt.event.MouseListener;
import javax.swing.border.MatteBorder;

public class DlgInternamiento extends JDialog implements ActionListener, KeyListener, ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoDeHospitalizacion;
	private JLabel lblCodigoDePaciente;
	private JLabel lblCodigoDeEmpleado;
	private JLabel lblNumeroDeCama;
	private JLabel lblFechaDeLlegada;
	private JLabel lblEstado;
	private JTextField txtCodigopac;
	public JTextField txtCodigoemple;
	public JButton btnAceptar;
	public JButton btnCancelar;
	private JTextField txtCodigohos;
	private JScrollPane scrollPane;
	public JComboBox<Integer> cboNroCamas;
	public JRadioButton rdbtnEconomico;
	public JRadioButton rdbtnEjecutivo;
	private JLabel lblCategoraCama;
	private JComboBox<String> cboDiaLlegada;
	private JComboBox<String> cboMesLlegada;
	private JComboBox<String> cboAnoLlegada;
	public JRadioButton rdbtnAlojado;
	public JRadioButton rdbtnPagado;
	public JTable jtblHospitalizacion;
	public JButton btnBuscarPaciente;
	public JButton btnGrabarHospitalizacion;
	private JPanel pnlFiltrar;
	public JRadioButton rdbtnFiltrarAlojado;
	public JRadioButton rdbtnFiltrarPagado;
	public JRadioButton rdbtnFiltrarTodo;
	private JLabel lblBorderFiltro;
	private int x;
	private int y;

	// Declaración global de código de paciente
	public String codigoPaciente = "";

	// Declación global variable para grupo de radiobuton
	private ButtonGroup bp;
	private ButtonGroup bp2;
	private ButtonGroup bp3;

	// Declaración global para modelo de tabla
	private DefaultTableModel dtm;

	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR = 2;
	public final static int CONSULTAR = 3;

	// Declaración global de arreglo Paciente
	ArregloPaciente ap = new ArregloPaciente("pacientes.txt");

	// Declaración global de arreglo CAmas
	ArregloCamas ac = new ArregloCamas("camas.txt");

	// Declaración global de arreglo Hospitalización
	ArregloHospitalizacion ah = new ArregloHospitalizacion("hospitalizaciones.txt");

	// Declaración global de librerias
	Fecha f = new Fecha();
	Libreria lb = new Libreria();
	DiseñoObjetos ds = new DiseñoObjetos();
	private JPanel panel;
	private JLabel label;
	private JLabel lblHospitalizacin;
	private JLabel lblAgregar;
	private JLabel lblCancelar;
	private JLabel lblGrabar;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JButton button;
	private JLabel label_1;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgInternamiento dialog = new DlgInternamiento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgInternamiento() {
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setModal(true);
		setTitle("HOSPITALIZACIÓN DE PACIENTES");
		setBounds(100, 100, 910, 878);
		getContentPane().setLayout(null);
		
		

		lblCodigoDeHospitalizacion = new JLabel("C\u00D3DIGO HOSPITALIZACI\u00D3N");
		lblCodigoDeHospitalizacion.setForeground(Color.BLACK);
		lblCodigoDeHospitalizacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigoDeHospitalizacion.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCodigoDeHospitalizacion.setBounds(79, 50, 197, 14);
		getContentPane().add(lblCodigoDeHospitalizacion);

		lblCodigoDePaciente = new JLabel("C\u00D3DIGO PACIENTE");
		lblCodigoDePaciente.setForeground(Color.BLACK);
		lblCodigoDePaciente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigoDePaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCodigoDePaciente.setBounds(406, 50, 170, 14);
		getContentPane().add(lblCodigoDePaciente);

		lblCodigoDeEmpleado = new JLabel("C\u00D3DIGO EMPLEADO");
		lblCodigoDeEmpleado.setForeground(Color.BLACK);
		lblCodigoDeEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigoDeEmpleado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCodigoDeEmpleado.setBounds(79, 130, 170, 14);
		getContentPane().add(lblCodigoDeEmpleado);

		lblNumeroDeCama = new JLabel("NRO CAMA");
		lblNumeroDeCama.setForeground(Color.BLACK);
		lblNumeroDeCama.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroDeCama.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblNumeroDeCama.setBounds(79, 214, 170, 14);
		getContentPane().add(lblNumeroDeCama);

		lblFechaDeLlegada = new JLabel("FECHA LLEGADA");
		lblFechaDeLlegada.setForeground(Color.BLACK);
		lblFechaDeLlegada.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaDeLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblFechaDeLlegada.setBounds(406, 214, 170, 14);
		getContentPane().add(lblFechaDeLlegada);

		lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblEstado.setBounds(79, 315, 170, 14);
		getContentPane().add(lblEstado);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(156, 180, 164, 2);
		getContentPane().add(separator_1);

		txtCodigopac = new JTextField();
		txtCodigopac.setForeground(Color.BLACK);
		txtCodigopac.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigopac.setEditable(false);
		txtCodigopac.setBounds(473, 75, 119, 29);
		getContentPane().add(txtCodigopac);
		txtCodigopac.setColumns(10);
		txtCodigopac.setBorder(null);
		txtCodigopac.setOpaque(false);

		txtCodigoemple = new JTextField();
		txtCodigoemple.setForeground(Color.BLACK);
		txtCodigoemple.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigoemple.setEditable(false);
		txtCodigoemple.setBounds(190, 155, 119, 29);
		getContentPane().add(txtCodigoemple);
		txtCodigoemple.setColumns(10);
		txtCodigoemple.setText(""+DlgLogin.codigoEmpleado);
		txtCodigoemple.setBorder(null);
		txtCodigoemple.setOpaque(false);

		txtCodigohos = new JTextField();
		txtCodigohos.setForeground(Color.BLACK);
		txtCodigohos.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigohos.setEditable(false);
		txtCodigohos.setBounds(190, 75, 119, 29);
		getContentPane().add(txtCodigohos);
		txtCodigohos.setColumns(10);
		txtCodigohos.setBorder(null);
		txtCodigohos.setOpaque(false);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 532, 883, 335);
		getContentPane().add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblHospitalizacion = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}

		};
		jtblHospitalizacion.setFont(new Font("Arial", Font.BOLD, 14));
		jtblHospitalizacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtblHospitalizacion.setRowHeight(25);
		scrollPane.setViewportView(jtblHospitalizacion);

		jtblHospitalizacion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (e.getClickCount() == 2) {
						int row = jtblHospitalizacion.rowAtPoint(new Point(e.getX(), e.getY()));

						if (row < 0) {

						}
						else {
							codigoPaciente = jtblHospitalizacion.getValueAt(row, 1).toString();
							dispose();
						}
					}
				}
			}
		});

		cboNroCamas = new JComboBox<Integer>();
		cboNroCamas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboNroCamas.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboNroCamas.setForeground(Color.BLACK);
		cboNroCamas.setBounds(190, 236, 59, 29);
		getContentPane().add(cboNroCamas);
		cboNroCamas.setBorder(null);
		cboNroCamas.setOpaque(false);
		

		rdbtnEconomico = new JRadioButton("Econ\u00F3mico");
		rdbtnEconomico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnEconomico.setBackground(Color.WHITE);
		rdbtnEconomico.addActionListener(this);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(154, 364, 216, 2);
		getContentPane().add(separator_3);
		rdbtnEconomico.setSelected(true);
		rdbtnEconomico.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		rdbtnEconomico.setForeground(Color.BLACK);
		rdbtnEconomico.setBounds(478, 158, 98, 23);
		getContentPane().add(rdbtnEconomico);

		rdbtnEjecutivo = new JRadioButton("Ejecutivo");
		rdbtnEjecutivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnEjecutivo.setBackground(Color.WHITE);
		rdbtnEjecutivo.addActionListener(this);
		rdbtnEjecutivo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		rdbtnEjecutivo.setForeground(Color.BLACK);
		rdbtnEjecutivo.setBounds(578, 158, 89, 23);
		getContentPane().add(rdbtnEjecutivo);

		bp = new ButtonGroup();
		bp.add(rdbtnEconomico);
		bp.add(rdbtnEjecutivo);

		lblCategoraCama = new JLabel("CATEGOR\u00CDA CAMA");
		lblCategoraCama.setForeground(Color.BLACK);
		lblCategoraCama.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategoraCama.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCategoraCama.setBounds(406, 130, 170, 14);
		getContentPane().add(lblCategoraCama);

		cboDiaLlegada = new JComboBox<String>();
		cboDiaLlegada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboDiaLlegada.setEnabled(false);
		cboDiaLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboDiaLlegada.setForeground(Color.BLACK);
		cboDiaLlegada.setBounds(479, 236, 59, 29);
		Fecha.colocarItems(cboDiaLlegada, 1, 31);
		Fecha.colocarDiaActual(cboDiaLlegada);
		getContentPane().add(cboDiaLlegada);

		cboMesLlegada = new JComboBox<String>();
		cboMesLlegada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboMesLlegada.setEnabled(false);
		cboMesLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboMesLlegada.setForeground(Color.BLACK);
		cboMesLlegada.setBounds(539, 236, 116, 29);
		Fecha.colocarMeses(cboMesLlegada);
		Fecha.colocarMesActual(cboMesLlegada);
		getContentPane().add(cboMesLlegada);

		cboAnoLlegada = new JComboBox<String>();
		cboAnoLlegada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboAnoLlegada.setEnabled(false);
		cboAnoLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboAnoLlegada.setForeground(Color.BLACK);
		cboAnoLlegada.setBounds(656, 236, 72, 29);
		cboAnoLlegada.addItem("" + Fecha.añoActual());
		getContentPane().add(cboAnoLlegada);

		rdbtnAlojado = new JRadioButton("Alojado");
		rdbtnAlojado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnAlojado.setEnabled(false);
		rdbtnAlojado.setSelected(true);
		rdbtnAlojado.setForeground(Color.BLACK);
		rdbtnAlojado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		rdbtnAlojado.setBackground(Color.WHITE);
		rdbtnAlojado.setBounds(195, 343, 98, 23);
		getContentPane().add(rdbtnAlojado);

		rdbtnPagado = new JRadioButton("Pagado");
		rdbtnPagado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnPagado.setEnabled(false);
		rdbtnPagado.setForeground(Color.BLACK);
		rdbtnPagado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		rdbtnPagado.setBackground(Color.WHITE);
		rdbtnPagado.setBounds(295, 343, 89, 23);
		getContentPane().add(rdbtnPagado);
		this.setLocationRelativeTo(this);

		bp2 = new ButtonGroup();
		bp2.add(rdbtnAlojado);
		bp2.add(rdbtnPagado);

		btnBuscarPaciente = new JButton("...");
		btnBuscarPaciente.setContentAreaFilled(false);
		btnBuscarPaciente.setBorderPainted(false);
		btnBuscarPaciente.setRolloverIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/buscarA.png")));
		btnBuscarPaciente.setBorder(null);
		btnBuscarPaciente.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/buscar.png")));
		btnBuscarPaciente.addActionListener(this);
		btnBuscarPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnBuscarPaciente.setForeground(Color.WHITE);
		btnBuscarPaciente.setBackground(Color.WHITE);
		btnBuscarPaciente.setBounds(590, 75, 41, 29);
		getContentPane().add(btnBuscarPaciente);
		btnBuscarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		pnlFiltrar = new JPanel();
		pnlFiltrar.setBorder(null);
		pnlFiltrar.setBackground(Color.WHITE);
		pnlFiltrar.setBounds(322, 490, 277, 29);
		getContentPane().add(pnlFiltrar);
		pnlFiltrar.setLayout(null);

		rdbtnFiltrarAlojado = new JRadioButton("ALOJADO");
		rdbtnFiltrarAlojado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnFiltrarAlojado.addActionListener(this);
		rdbtnFiltrarAlojado.setSelected(true);
		rdbtnFiltrarAlojado.setBackground(Color.WHITE);
		rdbtnFiltrarAlojado.setForeground(Color.BLACK);
		rdbtnFiltrarAlojado.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnFiltrarAlojado.setBounds(6, 0, 95, 23);
		pnlFiltrar.add(rdbtnFiltrarAlojado);

		rdbtnFiltrarPagado = new JRadioButton("PAGADO");
		rdbtnFiltrarPagado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnFiltrarPagado.addActionListener(this);
		rdbtnFiltrarPagado.setBackground(Color.WHITE);
		rdbtnFiltrarPagado.setForeground(Color.BLACK);
		rdbtnFiltrarPagado.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnFiltrarPagado.setBounds(103, 0, 85, 23);
		pnlFiltrar.add(rdbtnFiltrarPagado);

		rdbtnFiltrarTodo = new JRadioButton("TODO");
		rdbtnFiltrarTodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnFiltrarTodo.addActionListener(this);
		rdbtnFiltrarTodo.setBackground(Color.WHITE);
		rdbtnFiltrarTodo.setForeground(Color.BLACK);
		rdbtnFiltrarTodo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnFiltrarTodo.setBounds(203, 0, 65, 23);
		pnlFiltrar.add(rdbtnFiltrarTodo);

		bp3 = new ButtonGroup();
		bp3.add(rdbtnFiltrarAlojado);
		bp3.add(rdbtnFiltrarPagado);
		bp3.add(rdbtnFiltrarTodo);

		lblBorderFiltro = new JLabel("");
		lblBorderFiltro.setBounds(307, 483, 304, 38);
		getContentPane().add(lblBorderFiltro);
		lblBorderFiltro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

		modeloTabla();
		setCodigoHospitalizacion();
		listadoAlojado();
		listarCamas(cboNroCamas);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
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
		panel.setBounds(0, 0, 1343, 39);
		getContentPane().add(panel);
		panel.setLayout(null);
		
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
		label.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/image/icons8_Return_32px.png")));
		label.setBounds(837, 0, 32, 39);
		panel.add(label);
		
		lblHospitalizacin = new JLabel("Internamiento");
		lblHospitalizacin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHospitalizacin.setFont(new Font("Decker", Font.PLAIN, 16));
		lblHospitalizacin.setBounds(38, 0, 122, 39);
		panel.add(lblHospitalizacin);
		
		button = new JButton("");
		button.setRolloverIcon(new ImageIcon(DlgInternamiento.class.getResource("/image/X2_32px.png")));
		button.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/image/X_32px.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Icon m = new ImageIcon(getClass().getResource("/image/ADVERTENCIA.png"));
				int dialog = JOptionPane.YES_NO_OPTION;
				int result =JOptionPane.showConfirmDialog(null, "¿Desea salir de la ventana?","Exit",dialog,dialog,m);
				
				if(result ==0){
					dispose();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(873, 0, 32, 37);
		panel.add(button);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/image/fracture.png")));
		label_1.setBounds(10, 0, 25, 39);
		panel.add(label_1);
		
		lblAgregar = new JLabel("Agregar");
		lblAgregar.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/Agregar.png")));
		lblAgregar.addMouseListener(this);
		
		
				btnAceptar = new JButton("ACEPTAR");
				btnAceptar.setForeground(Color.BLACK);
				btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
				btnAceptar.addActionListener(this);
				btnAceptar.setBounds(586, 699, 149, 38);
				btnAceptar.setBackground(Color.CYAN);
				ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
				getContentPane().add(btnAceptar);
				btnAceptar.setVisible(false);
		
				btnCancelar = new JButton("CANCELAR");
				btnCancelar.setForeground(Color.BLACK);
				btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
				btnCancelar.addActionListener(this);
				btnCancelar.setBounds(586, 748, 149, 38);
				btnCancelar.setBackground(new Color(124, 252, 0));
				ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
				getContentPane().add(btnCancelar);
				btnCancelar.setVisible(false);
		
				btnGrabarHospitalizacion = new JButton("GRABAR HOSPITALIZACI\u00D3N");
				btnGrabarHospitalizacion.setVisible(false);
				btnGrabarHospitalizacion.addActionListener(this);
				btnGrabarHospitalizacion.setForeground(Color.BLACK);
				btnGrabarHospitalizacion.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
				btnGrabarHospitalizacion.setBounds(437, 818, 277, 38);
				btnGrabarHospitalizacion.setBackground(new Color(0, 250, 154));
				ds.setCurvasButton(btnGrabarHospitalizacion, "imagenes/grabar.png");
				getContentPane().add(btnGrabarHospitalizacion);
		lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregar.setForeground(Color.BLACK);
		lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgregar.setBackground(Color.YELLOW);
		lblAgregar.setBounds(473, 290, 206, 39);
		getContentPane().add(lblAgregar);
		
		lblCancelar = new JLabel("Cancelar");
		lblCancelar.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/regreso.png")));
		lblCancelar.addMouseListener(this);
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setForeground(Color.BLACK);
		lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCancelar.setBounds(478, 353, 206, 39);
		getContentPane().add(lblCancelar);
		
		
		lblGrabar = new JLabel("Grabar");
		lblGrabar.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/save.png")));
		lblGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGrabar.addMouseListener(this);
		lblGrabar.setOpaque(true);
		lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrabar.setForeground(Color.WHITE);
		lblGrabar.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblGrabar.setBackground(new Color(231, 96, 90));
		lblGrabar.setBounds(478, 403, 206, 41);
		getContentPane().add(lblGrabar);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/codigo.png")));
		label_4.setBounds(154, 68, 26, 36);
		getContentPane().add(label_4);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/user30.png")));
		label_5.setBounds(154, 148, 26, 36);
		getContentPane().add(label_5);
		
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/camaNegro.png")));
		label_6.setBounds(154, 229, 37, 36);
		getContentPane().add(label_6);
		
		label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/estadoOF-ON.png")));
		label_7.setBounds(154, 330, 35, 36);
		getContentPane().add(label_7);
		
		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/codigo.png")));
		label_8.setBounds(437, 68, 26, 36);
		getContentPane().add(label_8);
		
		label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/estadoOF-ON.png")));
		label_9.setBounds(437, 148, 35, 36);
		getContentPane().add(label_9);
		
		label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(DlgInternamiento.class.getResource("/iconBotones/calendario.png")));
		label_10.setBounds(443, 229, 26, 36);
		getContentPane().add(label_10);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(156, 102, 164, 2);
		getContentPane().add(separator);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(154, 265, 110, 2);
		getContentPane().add(separator_2);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(447, 104, 164, 2);
		getContentPane().add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(439, 182, 216, 2);
		getContentPane().add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(451, 265, 277, 2);
		getContentPane().add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(25, 459, 875, 7);
		getContentPane().add(separator_7);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == rdbtnFiltrarTodo) {
			actionPerformedRdbtnFiltrarTodo(arg0);
		}
		if (arg0.getSource() == rdbtnFiltrarPagado) {
			actionPerformedRdbtnFiltrarPagado(arg0);
		}
		if (arg0.getSource() == rdbtnFiltrarAlojado) {
			actionPerformedRdbtnFiltrarAlojado(arg0);
		}
		if (arg0.getSource() == btnGrabarHospitalizacion) {
			actionPerformedBtnGrabarHospitalizacion(arg0);
		}
		if (arg0.getSource() == btnBuscarPaciente) {
			actionPerformedBtnBuscarPaciente(arg0);
		}
		if (arg0.getSource() == rdbtnEjecutivo) {
			actionPerformedRdbtnEjecutivo(arg0);
		}
		if (arg0.getSource() == rdbtnEconomico) {
			actionPerformedRdbtnEconomico(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}

	protected void actionPerformedBtnBuscarPaciente(ActionEvent arg0) {
		rdbtnFiltrarAlojado.setSelected(true);
		listadoAlojado();
		DlgPaciente pac = new DlgPaciente();
		pac.setTitle("LISTADO DE PACIENTES");
		pac.setVisible(true);

		int c = 0;
		for (int i = 0; i < jtblHospitalizacion.getRowCount(); i++) {
			if (jtblHospitalizacion.getValueAt(i, 1).toString().equals("" + pac.codigoPaciente)
					&& jtblHospitalizacion.getValueAt(i, 8).toString().equals("ALOJADO")) {
				c++;
				Libreria.mensajeInformacion(this,
						"El paciente ya está alojado\n" + "Código de hospitalización : "
								+ jtblHospitalizacion.getValueAt(i, 0).toString() + "\n" + "Nro de cama : "
								+ jtblHospitalizacion.getValueAt(i, 3).toString() + "\n" + "Fecha Llegada : "
								+ jtblHospitalizacion.getValueAt(i, 4).toString() + "\n" + "Hora Llegada : "
								+ jtblHospitalizacion.getValueAt(i, 5).toString() + "\n");
				txtCodigopac.setText("");
				break;
			}
		}

		if (c == 0) {
			txtCodigopac.setText(pac.codigoPaciente);
		}
	}

	protected void actionPerformedBtnGrabarHospitalizacion(ActionEvent arg0) {
		if (ah.existeArchivo()) {
			int ok = Libreria.confirmacion(this, "¿ Desea actualizar \"" + ah.getArchivo() + "\" ?");
			if (ok == 0) {
				ah.grabarHospitalizacion();
				ac.grabarCamas();
				Libreria.mensajeInformacion(this, "\"" + ah.getArchivo() + "\" ha sido actualizado");
			}
			else
				Libreria.mensajeInformacion(this, "No se actualizó  \"" + ah.getArchivo() + "\"");
		}
		else {
			ah.grabarHospitalizacion();
			ac.grabarCamas();
			Libreria.mensajeInformacion(this, "\"" + ah.getArchivo() + "\" ha sido creado");
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		adicionarHospitalizacion();
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void itemStateChanged(ItemEvent e) {
	}

	protected void actionPerformedRdbtnEconomico(ActionEvent arg0) {
		listarCamas(cboNroCamas);
	}

	protected void actionPerformedRdbtnEjecutivo(ActionEvent arg0) {
		listarCamas(cboNroCamas);
	}

	protected void actionPerformedRdbtnFiltrarAlojado(ActionEvent arg0) {
		listadoAlojado();
	}

	protected void actionPerformedRdbtnFiltrarPagado(ActionEvent arg0) {
		listadoPagado();
	}

	protected void actionPerformedRdbtnFiltrarTodo(ActionEvent arg0) {
		listadoTodo();
	}

	// Métodos tipo void sin parámetros
	void setCodigoHospitalizacion() {
		txtCodigohos.setText("" + ah.codigoCorrelativo());
	}

	void limpieza() {
		txtCodigohos.setText("");
		txtCodigopac.setText("");
		listarCamas(cboNroCamas);
		rdbtnEconomico.isSelected();
		setCodigoHospitalizacion();
	}

	void modeloTabla() {
		TableColumnModel tc = jtblHospitalizacion.getColumnModel();
		tc.getColumn(0).setPreferredWidth(50);
		tc.getColumn(1).setPreferredWidth(75);
		tc.getColumn(2).setPreferredWidth(82);
		tc.getColumn(3).setPreferredWidth(50);
		tc.getColumn(4).setPreferredWidth(85);
		tc.getColumn(5).setPreferredWidth(80);
		tc.getColumn(6).setPreferredWidth(75);
		tc.getColumn(7).setPreferredWidth(75);
		tc.getColumn(8).setPreferredWidth(75);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
		tc.getColumn(2).setCellRenderer(tcr);
		tc.getColumn(1).setCellRenderer(tcr);
		tc.getColumn(3).setCellRenderer(tcr);
		tc.getColumn(4).setCellRenderer(tcr);
		tc.getColumn(5).setCellRenderer(tcr);
		tc.getColumn(6).setCellRenderer(tcr);
		tc.getColumn(7).setCellRenderer(tcr);
		tc.getColumn(8).setCellRenderer(tcr);
	}

	void listadoTodo() {
		Libreria.limpiarJTable(jtblHospitalizacion, dtm);

		if (ah.tamaño() == 0) {

		}
		else {
			for (int i = 0; i < ah.tamaño(); i++) {
				Internamiento x = ah.obtener(i);
				if (x.getHorSali() != 0) {
					dtm.addRow(new Object[] { x.getCodHosp(), x.getCodPaci(), x.getCodEmpl(), x.getNumCama(),
							Fecha.dd_mm_aaaa(x.getFecLleg()), Fecha.hh_mm_ss(x.getHorLleg()),
							Fecha.dd_mm_aaaa(x.getFecSali()), Fecha.hh_mm_ss(x.getHorSali()), Estado(x.getEstado()) });
				}
				else {
					dtm.addRow(new Object[] { x.getCodHosp(), x.getCodPaci(), x.getCodEmpl(), x.getNumCama(),
							Fecha.dd_mm_aaaa(x.getFecLleg()), Fecha.hh_mm_ss(x.getHorLleg()),
							horaFechaSalida(x.getFecSali()), horaFechaSalida(x.getHorSali()), Estado(x.getEstado()) });
				}
			}
		}
	}

	void listadoAlojado() {
		Libreria.limpiarJTable(jtblHospitalizacion, dtm);

		if (ah.tamaño() == 0) {

		}
		else {
			for (int i = 0; i < ah.tamaño(); i++) {
				Internamiento x = ah.obtener(i);
				if (x.getEstado() == 1) {
					dtm.addRow(new Object[] { x.getCodHosp(), x.getCodPaci(), x.getCodEmpl(), x.getNumCama(),
							Fecha.dd_mm_aaaa(x.getFecLleg()), Fecha.hh_mm_ss(x.getHorLleg()),
							horaFechaSalida(x.getFecSali()), horaFechaSalida(x.getHorSali()), Estado(x.getEstado()) });
				}
			}
		}
	}

	void listadoPagado() {
		Libreria.limpiarJTable(jtblHospitalizacion, dtm);

		if (ah.tamaño() == 0) {

		}
		else {
			for (int i = 0; i < ah.tamaño(); i++) {
				Internamiento x = ah.obtener(i);
				if (x.getEstado() == 2) {
					dtm.addRow(new Object[] { x.getCodHosp(), x.getCodPaci(), x.getCodEmpl(), x.getNumCama(),
							Fecha.dd_mm_aaaa(x.getFecLleg()), Fecha.hh_mm_ss(x.getHorLleg()),
							Fecha.dd_mm_aaaa(x.getFecSali()), Fecha.hh_mm_ss(x.getHorSali()), Estado(x.getEstado()) });
				}
			}
		}
	}

	void adicionarHospitalizacion() {
		if (leerCodigopac() < 0) {
			Libreria.mensajeAdvertencia(this, "No seleccionó CÓDIGO de paciente");
		}
		else if (cboNroCamas.getSelectedIndex() < 0) {
			Libreria.mensajeAdvertencia(this, "No hay camas disponibles en la categoría");
		}
		else {
			Internamiento nueva = new Internamiento(leerCodigohos(), leerCodigopac(), leerCodigoemple(),
					leerNumerocama(), leerFechallegada(), Fecha.obtenerHoraActual(), 0, 0, leerEstado());
			ah.adicionar(nueva);
			fijarCamaOcupado(leerNumerocama());
			limpieza();
			listadoAlojado();
		}
	}

	// Métodos tipo void con parámetros
	void listarCamas(JComboBox<Integer> cbo) {
		if (rdbtnEconomico.isSelected()) {
			cboNroCamas.removeAllItems();
			for (int i = 0; i < ac.tamaño(); i++) {
				if (ac.obtener(i).getCategoria() == 0) {
					if (ac.obtener(i).getEstado() == 0) {
						cbo.addItem(ac.obtener(i).getNroCama());
					}
				}
			}
		}
		else {
			cboNroCamas.removeAllItems();
			for (int i = 0; i < ac.tamaño(); i++) {
				if (ac.obtener(i).getCategoria() == 1) {
					if (ac.obtener(i).getEstado() == 0) {
						cbo.addItem(ac.obtener(i).getNroCama());
					}
				}
			}
		}
	}

	void fijarCamaOcupado(int nroCama) {
		Camas x = ac.buscar(nroCama);
		x.setEstado(1);
	}

	// Métodos que retornan valor sin parámetros
	String[] getColumnas() {
		String columnas[] = new String[] { "CÓDIGO", "COD PACIENTE", "COD EMPLEADO", "NRO CAMA", "FECHA LLEGADA",
				"HORA LLEGADA", "FECHA SALIDA", "HORA SALIDA", "ESTADO" };
		return columnas;
	}

	int leerCodigohos() {
		return Libreria.leerEntero(txtCodigohos);
	}

	int leerCodigopac() {
		return Libreria.leerEntero(txtCodigopac);
	}

	int leerCodigoemple() {
		return Libreria.leerEntero(txtCodigoemple);
	}

	int leerNumerocama() {
		return Integer.parseInt(cboNroCamas.getSelectedItem().toString());
	}

	int leerFechallegada() {
		return Fecha.getFecha(cboDiaLlegada, cboMesLlegada, cboAnoLlegada);
	}

	int leerEstado() {
		if (rdbtnAlojado.isSelected()) {
			return 1;
		}
		else {
			return 2;
		}
	}

	private String Estado(int estado) {
		if (estado == 1) {
			return "ALOJADO";
		}
		else {
			return "PAGADO";
		}
	}

	private String horaFechaSalida(int num) {
		return "----";
	}
	
	int leerCodigo() {
		return Libreria.leerEntero(txtCodigopac);
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblGrabar) {
			mouseClickedLabel_3(arg0);
		}
		if (arg0.getSource() == lblCancelar) {
			mouseClickedLabel_2(arg0);
		}
		if (arg0.getSource() == lblAgregar) {
			mouseClickedLabel_1(arg0);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblGrabar) {
		}
		if (e.getSource() == lblCancelar) {
			mouseEnteredCancelar(e);
		}
		if (e.getSource() == lblAgregar) {
			mouseEnteredlblAgregar(e);
		}
	}
	protected void mouseEnteredlblAgregar(MouseEvent e) {
		lblAgregar.setOpaque(true);
		lblAgregar.setBackground(new Color(30, 60, 79));
		lblAgregar.setForeground(new Color(255, 255, 255));
		lblAgregar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/AgregarBlanco.png")));
		lblAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredCancelar(MouseEvent e) {
		lblCancelar.setOpaque(true);
		lblCancelar.setBackground(new Color(30, 60, 79));
		lblCancelar.setForeground(new Color(255, 255, 255));
		lblCancelar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regresoNegro.png")));
		lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblAgregar) {
			mouseExitedLblAgregar(e);
		}
		if (e.getSource() == lblCancelar) {
			mouseExitedLblCancelar(e);
		}
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
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLabel_1(MouseEvent arg0) {
		adicionarHospitalizacion();
	}
	protected void mouseClickedLabel_2(MouseEvent arg0) {
		dispose();
	}
	protected void mouseClickedLabel_3(MouseEvent arg0) {
		if (ah.existeArchivo()) {
			int ok = Libreria.confirmacion(this, "¿ Desea actualizar \"" + ah.getArchivo() + "\" ?");
			if (ok == 0) {
				ah.grabarHospitalizacion();
				ac.grabarCamas();
				Libreria.mensajeInformacion(this, "\"" + ah.getArchivo() + "\" ha sido actualizado");
			}
			else
				Libreria.mensajeInformacion(this, "No se actualizó  \"" + ah.getArchivo() + "\"");
		}
		else {
			ah.grabarHospitalizacion();
			ac.grabarCamas();
			Libreria.mensajeInformacion(this, "\"" + ah.getArchivo() + "\" ha sido creado");
		}
	}
}