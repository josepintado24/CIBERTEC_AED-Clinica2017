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

public class DlgInternamiento extends JDialog implements ActionListener, KeyListener, ItemListener {

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
	private JLabel lblBordeCategoria;
	private JLabel lblBordeEstado;
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
		setBounds(100, 100, 1343, 476);
		getContentPane().setLayout(null);

		lblCodigoDeHospitalizacion = new JLabel("C\u00D3DIGO HOSPITALIZACI\u00D3N");
		lblCodigoDeHospitalizacion.setForeground(Color.BLACK);
		lblCodigoDeHospitalizacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigoDeHospitalizacion.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCodigoDeHospitalizacion.setBounds(10, 101, 170, 14);
		getContentPane().add(lblCodigoDeHospitalizacion);

		lblCodigoDePaciente = new JLabel("C\u00D3DIGO PACIENTE");
		lblCodigoDePaciente.setForeground(Color.BLACK);
		lblCodigoDePaciente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigoDePaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCodigoDePaciente.setBounds(10, 141, 170, 14);
		getContentPane().add(lblCodigoDePaciente);

		lblCodigoDeEmpleado = new JLabel("C\u00D3DIGO EMPLEADO");
		lblCodigoDeEmpleado.setForeground(Color.BLACK);
		lblCodigoDeEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigoDeEmpleado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCodigoDeEmpleado.setBounds(10, 177, 170, 14);
		getContentPane().add(lblCodigoDeEmpleado);

		lblNumeroDeCama = new JLabel("NRO CAMA");
		lblNumeroDeCama.setForeground(Color.BLACK);
		lblNumeroDeCama.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroDeCama.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblNumeroDeCama.setBounds(10, 259, 170, 14);
		getContentPane().add(lblNumeroDeCama);

		lblFechaDeLlegada = new JLabel("FECHA LLEGADA");
		lblFechaDeLlegada.setForeground(Color.BLACK);
		lblFechaDeLlegada.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaDeLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblFechaDeLlegada.setBounds(10, 299, 170, 14);
		getContentPane().add(lblFechaDeLlegada);

		lblEstado = new JLabel("ESTADO");
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblEstado.setBounds(10, 339, 170, 14);
		getContentPane().add(lblEstado);

		txtCodigopac = new JTextField();
		txtCodigopac.setForeground(Color.BLACK);
		txtCodigopac.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigopac.setEditable(false);
		txtCodigopac.setBounds(190, 134, 119, 29);
		getContentPane().add(txtCodigopac);
		txtCodigopac.setColumns(10);

		txtCodigoemple = new JTextField();
		txtCodigoemple.setForeground(Color.BLACK);
		txtCodigoemple.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigoemple.setEditable(false);
		txtCodigoemple.setBounds(190, 170, 119, 29);
		getContentPane().add(txtCodigoemple);
		txtCodigoemple.setColumns(10);
		txtCodigoemple.setText(""+DlgLogin.codigoEmpleado);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(58, 378, 149, 38);
		btnAceptar.setBackground(Color.CYAN);
		ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(217, 378, 149, 38);
		btnCancelar.setBackground(new Color(124, 252, 0));
		ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
		getContentPane().add(btnCancelar);

		txtCodigohos = new JTextField();
		txtCodigohos.setForeground(Color.BLACK);
		txtCodigohos.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigohos.setEditable(false);
		txtCodigohos.setBounds(190, 94, 119, 29);
		getContentPane().add(txtCodigohos);
		txtCodigohos.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(449, 141, 883, 324);
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
		cboNroCamas.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboNroCamas.setForeground(Color.BLACK);
		cboNroCamas.setBounds(190, 252, 59, 29);
		getContentPane().add(cboNroCamas);

		rdbtnEconomico = new JRadioButton("Econ\u00F3mico");
		rdbtnEconomico.setBackground(Color.WHITE);
		rdbtnEconomico.addActionListener(this);
		rdbtnEconomico.setSelected(true);
		rdbtnEconomico.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		rdbtnEconomico.setForeground(Color.BLACK);
		rdbtnEconomico.setBounds(195, 213, 98, 23);
		getContentPane().add(rdbtnEconomico);

		rdbtnEjecutivo = new JRadioButton("Ejecutivo");
		rdbtnEjecutivo.setBackground(Color.WHITE);
		rdbtnEjecutivo.addActionListener(this);
		rdbtnEjecutivo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		rdbtnEjecutivo.setForeground(Color.BLACK);
		rdbtnEjecutivo.setBounds(295, 213, 89, 23);
		getContentPane().add(rdbtnEjecutivo);

		lblBordeCategoria = new JLabel("");
		lblBordeCategoria.setBounds(190, 210, 206, 29);
		lblBordeCategoria.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		getContentPane().add(lblBordeCategoria);

		bp = new ButtonGroup();
		bp.add(rdbtnEconomico);
		bp.add(rdbtnEjecutivo);

		lblCategoraCama = new JLabel("CATEGOR\u00CDA CAMA");
		lblCategoraCama.setForeground(Color.BLACK);
		lblCategoraCama.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategoraCama.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCategoraCama.setBounds(10, 217, 170, 14);
		getContentPane().add(lblCategoraCama);

		cboDiaLlegada = new JComboBox<String>();
		cboDiaLlegada.setEnabled(false);
		cboDiaLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboDiaLlegada.setForeground(Color.BLACK);
		cboDiaLlegada.setBounds(190, 292, 59, 29);
		Fecha.colocarItems(cboDiaLlegada, 1, 31);
		Fecha.colocarDiaActual(cboDiaLlegada);
		getContentPane().add(cboDiaLlegada);

		cboMesLlegada = new JComboBox<String>();
		cboMesLlegada.setEnabled(false);
		cboMesLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboMesLlegada.setForeground(Color.BLACK);
		cboMesLlegada.setBounds(250, 292, 116, 29);
		Fecha.colocarMeses(cboMesLlegada);
		Fecha.colocarMesActual(cboMesLlegada);
		getContentPane().add(cboMesLlegada);

		cboAnoLlegada = new JComboBox<String>();
		cboAnoLlegada.setEnabled(false);
		cboAnoLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboAnoLlegada.setForeground(Color.BLACK);
		cboAnoLlegada.setBounds(367, 292, 72, 29);
		cboAnoLlegada.addItem("" + Fecha.añoActual());
		getContentPane().add(cboAnoLlegada);

		rdbtnAlojado = new JRadioButton("Alojado");
		rdbtnAlojado.setEnabled(false);
		rdbtnAlojado.setSelected(true);
		rdbtnAlojado.setForeground(Color.BLACK);
		rdbtnAlojado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		rdbtnAlojado.setBackground(Color.WHITE);
		rdbtnAlojado.setBounds(195, 335, 98, 23);
		getContentPane().add(rdbtnAlojado);

		rdbtnPagado = new JRadioButton("Pagado");
		rdbtnPagado.setEnabled(false);
		rdbtnPagado.setForeground(Color.BLACK);
		rdbtnPagado.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		rdbtnPagado.setBackground(Color.WHITE);
		rdbtnPagado.setBounds(295, 335, 89, 23);
		getContentPane().add(rdbtnPagado);
		this.setLocationRelativeTo(this);

		bp2 = new ButtonGroup();
		bp2.add(rdbtnAlojado);
		bp2.add(rdbtnPagado);

		lblBordeEstado = new JLabel("");
		lblBordeEstado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		lblBordeEstado.setBounds(190, 332, 206, 29);
		getContentPane().add(lblBordeEstado);

		btnBuscarPaciente = new JButton("...");
		btnBuscarPaciente.addActionListener(this);
		btnBuscarPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnBuscarPaciente.setForeground(Color.BLACK);
		btnBuscarPaciente.setBackground(new Color(127, 255, 212));
		btnBuscarPaciente.setBounds(313, 134, 62, 29);
		getContentPane().add(btnBuscarPaciente);

		btnGrabarHospitalizacion = new JButton("GRABAR HOSPITALIZACI\u00D3N");
		btnGrabarHospitalizacion.addActionListener(this);
		btnGrabarHospitalizacion.setForeground(Color.BLACK);
		btnGrabarHospitalizacion.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnGrabarHospitalizacion.setBounds(58, 427, 308, 38);
		btnGrabarHospitalizacion.setBackground(new Color(0, 250, 154));
		ds.setCurvasButton(btnGrabarHospitalizacion, "imagenes/grabar.png");
		getContentPane().add(btnGrabarHospitalizacion);

		pnlFiltrar = new JPanel();
		pnlFiltrar.setBorder(null);
		pnlFiltrar.setBackground(Color.WHITE);
		pnlFiltrar.setBounds(760, 101, 259, 29);
		getContentPane().add(pnlFiltrar);
		pnlFiltrar.setLayout(null);

		rdbtnFiltrarAlojado = new JRadioButton("ALOJADO");
		rdbtnFiltrarAlojado.addActionListener(this);
		rdbtnFiltrarAlojado.setSelected(true);
		rdbtnFiltrarAlojado.setBackground(Color.WHITE);
		rdbtnFiltrarAlojado.setForeground(Color.BLACK);
		rdbtnFiltrarAlojado.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnFiltrarAlojado.setBounds(6, 0, 90, 23);
		pnlFiltrar.add(rdbtnFiltrarAlojado);

		rdbtnFiltrarPagado = new JRadioButton("PAGADO");
		rdbtnFiltrarPagado.addActionListener(this);
		rdbtnFiltrarPagado.setBackground(Color.WHITE);
		rdbtnFiltrarPagado.setForeground(Color.BLACK);
		rdbtnFiltrarPagado.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnFiltrarPagado.setBounds(98, 0, 90, 23);
		pnlFiltrar.add(rdbtnFiltrarPagado);

		rdbtnFiltrarTodo = new JRadioButton("TODO");
		rdbtnFiltrarTodo.addActionListener(this);
		rdbtnFiltrarTodo.setBackground(Color.WHITE);
		rdbtnFiltrarTodo.setForeground(Color.BLACK);
		rdbtnFiltrarTodo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		rdbtnFiltrarTodo.setBounds(190, 0, 78, 23);
		pnlFiltrar.add(rdbtnFiltrarTodo);

		bp3 = new ButtonGroup();
		bp3.add(rdbtnFiltrarAlojado);
		bp3.add(rdbtnFiltrarPagado);
		bp3.add(rdbtnFiltrarTodo);

		lblBorderFiltro = new JLabel("");
		lblBorderFiltro.setBounds(756, 94, 274, 38);
		getContentPane().add(lblBorderFiltro);
		lblBorderFiltro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

		modeloTabla();
		setCodigoHospitalizacion();
		listadoAlojado();
		listarCamas(cboNroCamas);
		
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
		label.setBounds(1301, 0, 32, 39);
		panel.add(label);
		
		lblHospitalizacin = new JLabel("Hospitalizaci\u00F3n");
		lblHospitalizacin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHospitalizacin.setFont(new Font("Decker", Font.PLAIN, 16));
		lblHospitalizacin.setBounds(34, 0, 122, 39);
		panel.add(lblHospitalizacin);
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
}