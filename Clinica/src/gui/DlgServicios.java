package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloServicio;
import clases.Servicio;
import libreria.DiseñoObjetos;
import libreria.Validaciones;
import libreria.Libreria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class DlgServicios extends JDialog implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;
	private JLabel lblTipo;
	private JComboBox<String> cboTipo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JButton btnAceptar;
	private JButton btnCancelar;
	public JButton btnEliminar;
	public JButton btnConsultar;
	public JButton btnModificar;
	public JButton btnAdicionar;
	private JButton btnBuscar;
	private JLabel lblMensaje;
	public JButton btnGuardarServicios;
	private JScrollPane scrollPane;
	private JTable jtblServicios;
	private int x;
	private int y;

	// Declaración global para modelo de tabla
	private DefaultTableModel dtm;

	// Tipo de operación a procesar:
	// Adicionar, Modificar, Eliminar o Consultar
	private int tipoOperacion;
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR = 2;
	public final static int CONSULTAR = 3;
	// declaracion global
	ArregloServicio as = new ArregloServicio("servicios.txt");
	// Declaración global de libreria Validaciones
	Validaciones v = new Validaciones();
	// Declaración global de libreria DiseñoObjetos
	DiseñoObjetos ds = new DiseñoObjetos();
	// Declaración global de libreria
	Libreria lb = new Libreria();
	//DECLARACIÓN GLOBAL PARA OBTENER CÓDIGO Y PRECIO DEL SERVICO 
	public String codServicio = "";
	public double precioServicio = 0.0;
	public String nomServicio = "";
	private JPanel panel;
	private JLabel label;
	private JLabel lblServicios;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgServicios dialog = new DlgServicios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgServicios() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setTitle("MANTENIMIENTO | SERVICIO");
		setBounds(100, 100, 1111, 499);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 117, 89, 14);
		contentPanel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.addKeyListener(this);
		txtCodigo.setForeground(Color.BLACK);
		txtCodigo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigo.setBounds(109, 110, 96, 29);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcion.setForeground(Color.BLACK);
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblDescripcion.setBounds(10, 157, 89, 14);
		contentPanel.add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.addKeyListener(this);
		txtDescripcion.setForeground(Color.BLACK);
		txtDescripcion.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtDescripcion.setBounds(109, 150, 252, 29);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		lblTipo = new JLabel("TIPO");
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblTipo.setBounds(10, 197, 88, 14);
		contentPanel.add(lblTipo);

		cboTipo = new JComboBox<String>();
		cboTipo.setForeground(Color.BLACK);
		cboTipo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboTipo.addItem("ANÁLISIS CLÍNICOS");
		cboTipo.addItem("INTERVENCIONES QUIRÚRJICAS");
		cboTipo.setBounds(109, 190, 252, 29);
		contentPanel.add(cboTipo);

		lblPrecio = new JLabel("PRECIO");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 237, 88, 14);
		contentPanel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.addKeyListener(this);
		txtPrecio.setForeground(Color.BLACK);
		txtPrecio.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtPrecio.setBounds(111, 230, 94, 29);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setBackground(new Color(30, 144, 255));
		btnAceptar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(36, 371, 146, 39);
		ds.setCurvasButton(btnAceptar, "imagenes/aceptar.png");
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(new Color(0, 255, 255));
		btnCancelar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(192, 371, 145, 39);
		ds.setCurvasButton(btnCancelar, "imagenes/eliminar.png");
		contentPanel.add(btnCancelar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(new Color(127, 255, 212));
		btnEliminar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(37, 321, 145, 39);
		ds.setCurvasButton(btnEliminar, "imagenes/eliminar.png");
		contentPanel.add(btnEliminar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setBackground(Color.CYAN);
		btnConsultar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(192, 270, 146, 40);
		ds.setCurvasButton(btnConsultar, "imagenes/consultar.png");
		contentPanel.add(btnConsultar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setBackground(new Color(0, 139, 139));
		btnModificar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(191, 321, 146, 39);
		ds.setCurvasButton(btnModificar, "imagenes/modificar.png");
		contentPanel.add(btnModificar);

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setBackground(new Color(124, 252, 0));
		btnAdicionar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(37, 271, 145, 39);
		ds.setCurvasButton(btnAdicionar, "imagenes/adicionar.png");
		contentPanel.add(btnAdicionar);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setBackground(new Color(102, 205, 170));
		btnBuscar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(225, 110, 136, 29);
		ds.setCurvasButton(btnBuscar, "imagenes/buscar.png");
		contentPanel.add(btnBuscar);

		lblMensaje = new JLabel("");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setBackground(Color.DARK_GRAY);
		lblMensaje.setBounds(10, 70, 351, 29);
		contentPanel.add(lblMensaje);

		btnGuardarServicios = new JButton("GUARDAR SERVICIOS");
		btnGuardarServicios.setForeground(Color.BLACK);
		btnGuardarServicios.setBackground(new Color(0, 250, 154));
		btnGuardarServicios.addActionListener(this);
		btnGuardarServicios.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnGuardarServicios.setBounds(36, 421, 302, 39);
		ds.setCurvasButton(btnGuardarServicios, "imagenes/grabar.png");
		contentPanel.add(btnGuardarServicios);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 70, 724, 390);
		contentPanel.add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblServicios = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}

		};
		jtblServicios.addMouseListener(this);
		jtblServicios.setForeground(Color.BLACK);
		jtblServicios.setFont(new Font("Arial", Font.BOLD, 14));
		jtblServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtblServicios.setRowHeight(25);
		scrollPane.setViewportView(jtblServicios);
		
		panel = new JPanel();
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
		panel.setBounds(0, 0, 1111, 39);
		contentPanel.add(panel);
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
		label.setIcon(new ImageIcon(DlgServicios.class.getResource("/image/icons8_Return_32px.png")));
		label.setBounds(1069, 0, 32, 39);
		panel.add(label);
		
		lblServicios = new JLabel("Servicios");
		lblServicios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblServicios.setFont(new Font("Decker", Font.PLAIN, 16));
		lblServicios.setBounds(29, 0, 130, 39);
		panel.add(lblServicios);

		listado();
		modeloTabla();

		this.setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardarServicios) {
			actionPerformedBtnGuardarServicios(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando Servicio");
		txtCodigo.setText("" + as.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.setEditable(false);
		txtDescripcion.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		lblMensaje.setText("Consultando Servicio");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		lblMensaje.setText("Modificando Servicio");
		habilitarBusqueda(true);
		habilitarEntradas(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		lblMensaje.setText("Eliminando Servicio");
		habilitarBusqueda(true);
		habilitarOperaciones(false);
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarServicio();
	}

	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
			case ADICIONAR:
				adicionarEmpleado();
				lblMensaje.setText("");
				break;
			case CONSULTAR:
				limpieza();
				habilitarBusqueda(false);
				habilitarOperaciones(true);
				lblMensaje.setText("");
				break;
			case MODIFICAR:
				modificarServicio();
				lblMensaje.setText("");
				break;
			case ELIMINAR:
				eliminarEmpleado();
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

	protected void actionPerformedBtnGuardarServicios(ActionEvent arg0) {
		if (as.existeArchivo()) {
			int ok = Libreria.confirmacion(this, "¿ Desea actualizar \"" + as.getArchivo() + "\" ?");
			if (ok == 0) {
				as.grabarServicios();
				Libreria.mensajeInformacion(this, "\"" + as.getArchivo() + "\" ha sido actualizado");
			}
			else
				Libreria.mensajeInformacion(this, "No se actualizó  \"" + as.getArchivo() + "\"");
		}
		else {
			as.grabarServicios();
			Libreria.mensajeInformacion(this, "\"" + as.getArchivo() + "\" ha sido creado");
		}
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtPrecio) {
			keyTypedTxtPrecio(arg0);
		}
		if (arg0.getSource() == txtDescripcion) {
			keyTypedTxtDescripcion(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigo(arg0);
		}
	}

	protected void keyTypedTxtCodigo(KeyEvent e) {
		Validaciones.soloNumero(e, txtCodigo, 8);

		char t = e.getKeyChar();
		if (t == KeyEvent.VK_ENTER)
			consultarServicio();
	}

	protected void keyTypedTxtDescripcion(KeyEvent e) {
		Validaciones.cadenaTexto(e, txtDescripcion, 20);
	}

	protected void keyTypedTxtPrecio(KeyEvent e) {
		Validaciones.numeroReal(txtPrecio, e, 5);
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == jtblServicios) {
			mouseClickedJtblServicios(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	protected void mouseClickedJtblServicios(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (e.getClickCount() == 2) {
				int row = jtblServicios.rowAtPoint(new Point(e.getX(), e.getY()));

				if (row >= 0) {
					codServicio = jtblServicios.getValueAt(row, 0).toString();
					precioServicio = Double.parseDouble(jtblServicios.getValueAt(row, 3).toString());
					nomServicio = jtblServicios.getValueAt(row, 1).toString();
					dispose();
				}
			}
		}
	}

	// Métodos tipo void sin parámetros
	void limpieza() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		cboTipo.setSelectedIndex(0);
	}

	String[] getColumnas() {
		String columnas[] = new String[] { "CÓDIGO", "DESCRIPCIÓN", "TIPO", "PRECIO" };
		return columnas;
	}

	void modeloTabla() {
		TableColumnModel tc = jtblServicios.getColumnModel();
		tc.getColumn(0).setPreferredWidth(50);
		tc.getColumn(1).setPreferredWidth(300);
		tc.getColumn(2).setPreferredWidth(200);
		tc.getColumn(3).setPreferredWidth(40);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
		tc.getColumn(2).setCellRenderer(tcr);

		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tc.getColumn(3).setCellRenderer(tcr);
	}

	void listado() {
		Libreria.limpiarJTable(jtblServicios, dtm);
		if (as.tamaño() == 0) {

		}
		else {
			for (int i = 0; i < as.tamaño(); i++) {
				Servicio x = as.obtener(i);
				dtm.addRow(new Object[] { x.getCodServicio(), x.getDescripcion(), getTipoServicio(x.getTipo()),
						x.getPrecio() });
			}
		}
	}

	void adicionarEmpleado() {
		if (leerDescripcion().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó la DESCRIPCIÓN");
			txtDescripcion.requestFocus();
		}
		else if (leerPrecio() < 0) {
			Libreria.mensajeAdvertencia(this, "No ingresó el PRECIO");
			txtPrecio.setText("");
			txtPrecio.requestFocus();
		}
		else {
			Servicio nuevo = new Servicio(leerCodigo(), leerDescripcion(), leerTipo(), leerPrecio());
			as.adicionar(nuevo);
			listado();
			habilitarEntradas(false);
			habilitarOperaciones(true);
		}
	}

	void consultarServicio() {

		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del SERVICIO");
			txtCodigo.requestFocus();
		}
		else {
			Servicio x = as.buscar(leerCodigo());
			if (x != null) {
				txtDescripcion.setText(x.getDescripcion());
				cboTipo.setSelectedIndex(x.getTipo());
				txtPrecio.setText("" + x.getPrecio());
			}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				limpieza();
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	void modificarServicio() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Empleado");
			txtCodigo.requestFocus();
		}
		else {
			Servicio x = as.buscar(leerCodigo());
			if (x != null)
				if (leerDescripcion().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó la DESCRIPCIÓN");
					txtDescripcion.requestFocus();
				}
				else if (leerPrecio() < 0) {
					Libreria.mensajeAdvertencia(this, "No ingresó el PRECIO");
					txtPrecio.setText("");
					txtPrecio.requestFocus();
				}
				else {
					x.setCodServicio(leerCodigo());
					x.setDescripcion(leerDescripcion());
					x.setPrecio(leerPrecio());
					x.setTipo(leerTipo());
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
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del SERVICIO");
			txtCodigo.requestFocus();
		}
		else {
			Servicio x = as.buscar(leerCodigo());
			if (x != null) {
				as.eliminar(x);
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
		txtDescripcion.setEditable(sino);
		txtPrecio.setEditable(sino);
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
	int leerCodigo() {
		return Libreria.leerEntero(txtCodigo);
	}

	String leerDescripcion() {
		return Libreria.leerCadena(txtDescripcion);
	}

	double leerPrecio() {
		return Libreria.leerReal(txtPrecio);
	}

	int leerTipo() {
		return cboTipo.getSelectedIndex();
	}

	// Métodos que retornan valor con parámetros
	String getTipoServicio(int tipo) {
		if (tipo == 0) {
			return "ANÁLISIS CLÍNICOS";
		}
		else {
			return "INTERVENCIONES QUIRÚRJICAS";
		}
	}
}
