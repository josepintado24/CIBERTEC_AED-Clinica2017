package gui;

import java.awt.BorderLayout;
import libreria.Validaciones;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Pacientes;
import controlador.ArregloPacientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.ComponentOrientation;
import java.awt.event.MouseMotionListener;
import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Paciente extends JFrame implements ActionListener, KeyListener, MouseListener, AncestorListener, MouseMotionListener {
	
	
	

	private JPanel JPanel;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDNI;
	private JComboBox cboBuscar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paciente frame = new Paciente();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 private int x;
	 private int y;
	 
	public Paciente() {
		setUndecorated(true);
		setResizable(false);
		setTitle("PACIENTE-MANTENIMIENTO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 662);
		JPanel = new JPanel();
		JPanel.setForeground(new Color(0, 128, 128));
		JPanel.setBackground(new Color(0, 66, 102));
		JPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanel);
		modelo=new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		
		cboBuscar = new JComboBox();
		cboBuscar.setBounds(737, 71, 142, 27);
		cboBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cboBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		JPanel.setLayout(null);
		cboBuscar.setBorder(null);
		cboBuscar.setBackground(Color.WHITE);
		cboBuscar.setForeground(SystemColor.desktop);
		cboBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		JPanel.add(cboBuscar);
		cboBuscar.addActionListener(this);
		cboBuscar.setEnabled(false);
		cboBuscar.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Nombre", "Apellido", "DNI"}));
		cboBuscar.setVisible(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 707, 482);
		JPanel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		lblModificar = new JLabel("MODIFICAR");
		lblModificar.setBounds(356, 63, 148, 42);
		lblModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModificar.addMouseListener(this);
		lblModificar.setIcon(new ImageIcon(Paciente.class.getResource("/img/edit.png")));
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModificar.setForeground(new Color(255, 255, 255));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel.add(lblModificar);
		
		lblConsultar = new JLabel("CONSULTAR");
		lblConsultar.setBounds(191, 63, 148, 42);
		lblConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.addMouseListener(this);
		lblConsultar.setIcon(new ImageIcon(Paciente.class.getResource("/img/buscar.png")));
		lblConsultar.setForeground(new Color(255, 255, 255));
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		JPanel.add(lblConsultar);
		
		lblIngresar = new JLabel("INGRESAR");
		lblIngresar.setBounds(10, 63, 142, 42);
		lblIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.addMouseListener(this);
		lblIngresar.setIcon(new ImageIcon(Paciente.class.getResource("/img/ingresar.png")));
		lblIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setBackground(new Color(255, 255, 255));
		JPanel.add(lblIngresar);
		
		lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setBounds(547, 64, 148, 40);
		lblEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.addMouseListener(this);
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEliminar.setForeground(new Color(255, 255, 255));
		lblEliminar.setIcon(new ImageIcon(Paciente.class.getResource("/img/tacho.png")));
		JPanel.add(lblEliminar);
		
		panel = new JPanel();
		panel.setBounds(737, 125, 304, 524);
		panel.setBackground(new Color(0, 66, 102));
		JPanel.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		txtNombre = new JTextField();
		txtNombre.setCaretColor(Color.WHITE);
		txtNombre.setBounds(86, 125, 169, 23);
		panel.add(txtNombre);
		txtNombre.setForeground(new Color(255, 255, 255));
		txtNombre.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtNombre.addKeyListener(this);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBorder(null);
		txtNombre.setOpaque(false);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(49, 91, 117, 23);
		panel.add(lblNombre);
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		
		txtApellido = new JTextField();
		txtApellido.setCaretColor(Color.WHITE);
		txtApellido.setBounds(86, 193, 169, 20);
		panel.add(txtApellido);
		txtApellido.setForeground(new Color(255, 255, 255));
		txtApellido.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtApellido.addKeyListener(this);
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBorder(null);
		txtApellido.setOpaque(false);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(49, 159, 117, 23);
		panel.add(lblApellido);
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		
		txtDNI = new JTextField();
		txtDNI.setCaretColor(Color.WHITE);
		txtDNI.setBounds(86, 247, 169, 20);
		panel.add(txtDNI);
		txtDNI.setForeground(new Color(255, 255, 255));
		txtDNI.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtDNI.addKeyListener(this);
		txtDNI.setEditable(false);
		txtDNI.setColumns(10);
		txtDNI.setBorder(null);
		txtDNI.setOpaque(false);
		
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(49, 224, 117, 23);
		panel.add(lblDni);
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		
		
		txtCodigo = new JTextField();
		txtCodigo.setCaretColor(Color.WHITE);
		txtCodigo.setText(""+ap.codigoCorrelativo());
		
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(86, 49, 169, 23);
		panel.add(txtCodigo);
		txtCodigo.setForeground(new Color(255, 255, 255));
		txtCodigo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtCodigo.addKeyListener(this);
		txtCodigo.setColumns(10);
		txtCodigo.setBorder(null);
		txtCodigo.setOpaque(false);
		
		lblCodigo = new JLabel("codigo");
		lblCodigo.setBounds(49, 15, 117, 23);
		panel.add(lblCodigo);
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(49, 278, 117, 23);
		panel.add(lblTelefono);
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		
		txtTelefono = new JTextField();
		txtTelefono.setCaretColor(Color.WHITE);
		txtTelefono.setBounds(86, 311, 169, 23);
		panel.add(txtTelefono);
		txtTelefono.setForeground(new Color(255, 255, 255));
		txtTelefono.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtTelefono.addKeyListener(this);
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setOpaque(false);
		
		iconCodigo = new JLabel("");
		iconCodigo.setBounds(49, 34, 35, 50);
		panel.add(iconCodigo);
		iconCodigo.setIcon(new ImageIcon(Paciente.class.getResource("/img/key.png")));
		
		LineCodigo = new JSeparator();
		LineCodigo.setBounds(49, 79, 206, 2);
		panel.add(LineCodigo);
		
		iconNombre = new JLabel("");
		iconNombre.setBounds(49, 108, 35, 50);
		panel.add(iconNombre);
		iconNombre.setIcon(new ImageIcon(Paciente.class.getResource("/img/name.png")));
		
		iconApellido = new JLabel("");
		iconApellido.setBounds(49, 175, 35, 50);
		panel.add(iconApellido);
		iconApellido.setIcon(new ImageIcon(Paciente.class.getResource("/img/apellido.png")));
		
		iconDni = new JLabel("");
		iconDni.setBounds(49, 237, 35, 50);
		panel.add(iconDni);
		iconDni.setIcon(new ImageIcon(Paciente.class.getResource("/img/dni.png")));
		
		iconTelefono = new JLabel("");
		iconTelefono.setBounds(49, 298, 35, 50);
		panel.add(iconTelefono);
		iconTelefono.setIcon(new ImageIcon(Paciente.class.getResource("/img/phpmp.png")));
		
		lineNombre = new JSeparator();
		lineNombre.setBounds(49, 156, 206, 2);
		panel.add(lineNombre);
		
		lineApellido = new JSeparator();
		lineApellido.setBounds(49, 223, 206, 2);
		panel.add(lineApellido);
		
		lineDni = new JSeparator();
		lineDni.setBounds(49, 278, 206, 2);
		panel.add(lineDni);
		
		lineTelefono = new JSeparator();
		lineTelefono.setBounds(49, 342, 206, 2);
		panel.add(lineTelefono);
		
		lblAgregar = new JLabel("Agregar");
		lblAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAgregar.addAncestorListener(this);
		lblAgregar.setBounds(49, 355, 206, 39);
		panel.add(lblAgregar);
		lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregar.addMouseListener(this);
		lblAgregar.setIcon(new ImageIcon(Paciente.class.getResource("/img/adelante.png")));
		lblAgregar.setForeground(new Color(255, 255, 255));
		lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblCancelar = new JLabel("Cancelar");
		lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCancelar.setBounds(49, 405, 206, 39);
		panel.add(lblCancelar);
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.addMouseListener(this);
		lblCancelar.setIcon(new ImageIcon(Paciente.class.getResource("/img/atras.png")));
		lblCancelar.setForeground(new Color(255, 255, 255));
		lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		lblGrabar = new JLabel("Grabar");
		lblGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGrabar.setBounds(49, 472, 206, 41);
		panel.add(lblGrabar);
		lblGrabar.addMouseListener(this);
		lblGrabar.setIcon(new ImageIcon(Paciente.class.getResource("/img/save.png")));
		lblGrabar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblGrabar.setForeground(new Color(255, 255, 255));
		lblGrabar.setBackground(new Color(231, 96, 90));
		lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrabar.setOpaque(true);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1057, 42);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.addMouseMotionListener(this);
		panel_1.addMouseListener(this);
		JPanel.setForeground(new Color(0, 128, 128));
		JPanel.setBackground(new Color(0, 66, 102));
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JPanel.add(panel_1);
		panel_1.setLayout(null);
		
		lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Decker", Font.PLAIN, 16));
		lblPaciente.setBounds(36, 11, 96, 20);
		panel_1.add(lblPaciente);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Paciente.class.getResource("/image/paciente2.png")));
		label.setBounds(10, 11, 16, 20);
		panel_1.add(label);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(this);
		label_1.setIcon(new ImageIcon(Paciente.class.getResource("/image/icons8_Return_32px.png")));
		label_1.setBounds(1019, 0, 32, 42);
		panel_1.add(label_1);
		
		label_3 = new JLabel("");
		label_3.addMouseListener(this);
		label_3.setIcon(new ImageIcon(Paciente.class.getResource("/image/Minimize_Window_32px.png")));
		label_3.setBounds(977, 0, 32, 42);
		panel_1.add(label_3);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{JPanel, cboBuscar, scrollPane, table, lblModificar, lblConsultar, lblIngresar, lblEliminar, panel, txtNombre, lblNombre, txtApellido, lblApellido, txtDNI, lblDni, txtCodigo, lblCodigo, lblTelefono, txtTelefono, iconCodigo, LineCodigo, iconNombre, iconApellido, iconDni, iconTelefono, lineNombre, lineApellido, lineDni, lineTelefono, lblAgregar, lblCancelar, lblGrabar, panel_1, lblPaciente, label, label_1, label_3}));
		
	}
	ArregloPacientes ap= new ArregloPacientes();
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel iconCodigo;
	private JSeparator LineCodigo;
	private JLabel iconNombre;
	private JLabel iconApellido;
	private JLabel iconDni;
	private JLabel iconTelefono;
	private JSeparator lineNombre;
	private JSeparator lineApellido;
	private JSeparator lineDni;
	private JSeparator lineTelefono;
	private JLabel lblGrabar;
	private JLabel lblModificar;
	private JLabel lblConsultar;
	private JLabel lblIngresar;
	private JLabel lblEliminar;
	private JLabel lblAgregar;
	private JLabel lblCancelar;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblPaciente;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_3;
	private void listar(){
		modelo.setRowCount(0);
				
				for(int i=0;i<ap.tamano();i++){
					Object[]fila={
							ap.obtener(i).getCodigo(),
							ap.obtener(i).getApellidos(),
							ap.obtener(i).getNombres(),
							ap.obtener(i).getTelefono(),
							ap.obtener(i).getDni()
					};
					modelo.addRow(fila);
				}
	}
	
	void limpiar(){
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtTelefono.setText("");
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboBuscar) {
			actionPerformedCboBuscar(arg0);
		}
		
	}
	private int comboBuscar(){
		return cboBuscar.getSelectedIndex();
	}
	private void BuscarTipo( int i){
		switch (i){
		case 0:
			
			noVisibleCodigo();
			visibleNombre();
			visibleApellido();
			visibleDni();
			visibleTelefono();
			break;
		case 1:
			
			visibleCodigo();
			noVisibleNombre();
			visibleApellido();
			visibleDni();
			visibleTelefono();
			break;
		case 2:
			
			visibleCodigo();
			visibleNombre();
			noVisibleApellido();
			visibleDni();
			visibleTelefono();
			break;
		case 3:
			
			visibleCodigo();
			visibleNombre();
			visibleApellido();
			noVisibleDni();
			visibleTelefono();
			break;
		}
		
		
		
	}
	
	private void editableTrue(){
		
		txtCodigo.setEditable(true);
		txtDNI.setEditable(true);
		txtApellido.setEditable(true);
		txtNombre.setEditable(true);
		txtTelefono.setEditable(true);
		noVisibleCodigo();
		noVisibleNombre();
		noVisibleApellido();
		noVisibleDni();
		noVisibleTelefono();
	}
	private void editableFalse(){
		txtCodigo.setEditable(false);
		txtDNI.setEditable(false);
		txtApellido.setEditable(false);
		txtNombre.setEditable(false);
		txtTelefono.setEditable(false);
		
		cboBuscar.setEnabled(false);
	}
	private void visibleCodigo(){
		txtCodigo.setVisible(false);
		lblCodigo.setVisible(false);
		LineCodigo.setVisible(false);
		iconCodigo.setVisible(false);
	}
	private void visibleNombre(){
		txtNombre.setVisible(false);
		lblNombre.setVisible(false);
		lineNombre.setVisible(false);
		iconNombre.setVisible(false);
	}
	private void visibleApellido(){
		txtApellido.setVisible(false);
		lblApellido.setVisible(false);
		lineApellido.setVisible(false);
		iconApellido.setVisible(false);
	}
	private void visibleDni(){
		txtDNI.setVisible(false);
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
		LineCodigo.setVisible(true);
		iconCodigo.setVisible(true);
	}
	private void noVisibleNombre(){
		txtNombre.setVisible(true);
		txtNombre.setEditable(true);
		lblNombre.setVisible(true);
		lineNombre.setVisible(true);
		iconNombre.setVisible(true);
	}
	private void noVisibleApellido(){
		txtApellido.setVisible(true);
		txtApellido.setEditable(true);
		lblApellido.setVisible(true);
		lineApellido.setVisible(true);
		iconApellido.setVisible(true);
	}
	private void noVisibleDni(){
		txtDNI.setVisible(true);
		txtDNI.setEditable(true);
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
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		
		
	}
	protected void actionPerformedCboBuscar(ActionEvent arg0) {
		BuscarTipo( comboBuscar());
		panel.setVisible(true);
		 
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtNombre) {
			keyTypedTxtNombre(arg0);
		}
		if (arg0.getSource() == txtApellido) {
			keyTypedTxtApellido(arg0);
		}
		if (arg0.getSource() == txtDNI) {
			keyTypedTxtDNI(arg0);
		}
		if (arg0.getSource() == txtTelefono) {
			keyTypedTxtTelefono(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigo(arg0);
		}
	}
	protected void keyTypedTxtCodigo(KeyEvent arg0) {
		Validaciones.soloNumero(arg0, txtCodigo, 6);
		
		
	}
	protected void keyTypedTxtTelefono(KeyEvent arg0) {
		Validaciones.soloNumero(arg0, txtTelefono, 9);
	}
	protected void keyTypedTxtDNI(KeyEvent arg0) {
		Validaciones.soloNumero(arg0, txtDNI, 8);
	}
	protected void keyTypedTxtApellido(KeyEvent arg0) {
		Validaciones.soloLetras(arg0, txtApellido, 60);
	}
	protected void keyTypedTxtNombre(KeyEvent arg0) {
		Validaciones.soloLetras(arg0, txtNombre, 60);
	}
	
	
	
	
	//Click en Objeto
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == label_3) {
			mouseClickedLabel_3(arg0);
		}
		if (arg0.getSource() == label_1) {
			mouseClickedLabel_1(arg0);
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
	}
	
	
	protected void mouseClickedLblAgregar(MouseEvent arg0) {
		
		int codigo=Integer.parseInt(txtCodigo.getText());
		String apellido=txtApellido.getText();
		String nombre=txtNombre.getText();
		String telefono=txtTelefono.getText();
		String dni=txtDNI.getText();
		Pacientes objap=new Pacientes(codigo,apellido,nombre,telefono,dni);
		ap.adicionar(objap);
		listar();
		txtCodigo.setText(""+ap.codigoCorrelativo());
	}
	protected void mouseClickedLblCancelar(MouseEvent arg0) {
		panel.setVisible(false);
		lblModificar.setVisible(true);
		lblConsultar.setVisible(true);
		lblEliminar.setVisible(true);
		lblIngresar.setVisible(true);
	}
	protected void mouseClickedLblModificar(MouseEvent arg0) {
		lblAgregar.setText("Buscar");
		lblAgregar.setIcon(new ImageIcon(Paciente.class.getResource("/img/Lupa.png")));
		lblAgregar.setVisible(true);
		BuscarTipo(0);
		panel.setVisible(true);
		lblConsultar.setVisible(false);
		lblEliminar.setVisible(false);
		lblIngresar.setVisible(false);
	}
	
	protected void mouseClickedLblIngresar(MouseEvent arg0) {
		lblAgregar.setText("Agregar");
		lblAgregar.setIcon(new ImageIcon(Paciente.class.getResource("/img/adelante.png")));
		panel.setVisible(true);
		editableTrue();
		lblModificar.setVisible(false);
		lblConsultar.setVisible(false);
		lblEliminar.setVisible(false);
		tipoOperacion = ADICIONAR;
		lblMensaje.setText("Adicionando Paciente");
		txtCodigo.setText("" + ap.codigoCorrelativo());
		habilitarEntradas(true);
		habilitarOperaciones(false);
		txtCodigo.setEditable(false);
		txtNombres.requestFocus();
		
	}
	protected void mouseClickedLblConsultar(MouseEvent arg0) {
		cboBuscar.setVisible(true);
		lblAgregar.setText("Buscar");
		lblAgregar.setIcon(new ImageIcon(Paciente.class.getResource("/img/Lupa.png")));
		lblAgregar.setVisible(true);
		cboBuscar.setEnabled(true);
		lblIngresar.setVisible(false);
		lblModificar.setVisible(false);
		lblEliminar.setVisible(false);
		lblGrabar.setVisible(false);
		BuscarTipo(0);
		panel.setVisible(true);
		
		
	}
	//Sobre el Objeto
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == lblIngresar) {
			mouseEnteredLblIngresar(arg0);
		}
		if (arg0.getSource() == lblCancelar) {
			mouseEnteredLblCancelar(arg0);
		}
		if (arg0.getSource() == lblAgregar) {
			mouseEnteredLblAgregar(arg0);
		}
		if (arg0.getSource() == lblEliminar) {
			mouseEnteredLblEliminar(arg0);
		}
		if (arg0.getSource() == lblConsultar) {
			mouseEnteredLblConsultar(arg0);
		}
		if (arg0.getSource()==lblGrabar){
			mouseEnteredLblGrabar(arg0);
		}
		if (arg0.getSource()==lblModificar){
			mouseEnteredLblModificar(arg0);
		}
		
		
	}
	
	//Salir del Objeto
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblModificar) {
			mouseExitedLblModificar(e);
		}
		if (e.getSource() == lblGrabar) {
			mouseExitedLblGrabar(e);
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
			limpiar();
		}
		if (e.getSource() == lblCancelar) {
			mouseExitedLblCancelar(e);
		}
		
		
	}
	
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == panel_1) {
			mousePressedPanel_1(arg0);
			
		}
		
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	
	//METODOS SALIR 
	protected void mouseExitedLblGrabar(MouseEvent arg0) {
		
		lblGrabar.setBackground(new Color(231, 96, 90));
	}
	protected void mouseExitedLblModificar(MouseEvent arg0) {
		lblModificar.setOpaque(false);
		lblModificar.setBackground(new Color(255,255,255));
		
	}
	protected void mouseExitedLblConsultar(MouseEvent arg0) {
		lblConsultar.setOpaque(false);
		lblConsultar.setBackground(new Color(255,255,255));
	}
	protected void mouseExitedLblIngresar(MouseEvent arg0) {
		lblIngresar.setOpaque(false);
		lblIngresar.setBackground(new Color(255,255,255));
	}
	protected void mouseExitedLblEliminar(MouseEvent arg0) {
		lblEliminar.setOpaque(false);
		lblEliminar.setBackground(new Color(255,255,255));
	}
	
	protected void mouseExitedLblAgregar(MouseEvent arg0) {
		lblAgregar.setOpaque(false);
		lblAgregar.setBackground(new Color(255,255,255));
	}
	protected void mouseExitedLblCancelar(MouseEvent arg0) {
		lblCancelar.setOpaque(false);
		lblCancelar.setBackground(new Color(255,255,255));
	}
	
	//METODOS ENTRAR
	protected void mouseEnteredLblGrabar(MouseEvent arg0) {
		lblGrabar.setBackground(new Color(168, 1, 25));
	}
	protected void mouseEnteredLblModificar(MouseEvent arg0) {
		lblModificar.setOpaque(true);
		lblModificar.setBackground(new Color(1, 168, 25));
	}
	protected void mouseEnteredLblConsultar(MouseEvent arg0) {
		lblConsultar.setOpaque(true);
		lblConsultar.setBackground(new Color(1, 168, 25));
	}
	
	protected void mouseEnteredLblIngresar(MouseEvent arg0) {
		lblIngresar.setOpaque(true);
		lblIngresar.setBackground(new Color(1, 168, 25));
	}
	protected void mouseEnteredLblEliminar(MouseEvent arg0) {
		lblEliminar.setOpaque(true);
		lblEliminar.setBackground(new Color(1, 168, 25));
	}
	protected void mouseEnteredLblAgregar(MouseEvent arg0) {
		lblAgregar.setOpaque(true);
		lblAgregar.setBackground(new Color(0, 171, 152));
	}
	protected void mouseEnteredLblCancelar(MouseEvent arg0) {
		lblCancelar.setOpaque(true);
		lblCancelar.setBackground(new Color(0, 171, 152));
	}
	
	public void ancestorAdded(AncestorEvent arg0) {
		if (arg0.getSource() == lblAgregar) {
			ancestorAddedLblAgregar(arg0);
		}
	}
	public void ancestorMoved(AncestorEvent arg0) {
	}
	public void ancestorRemoved(AncestorEvent arg0) {
	}
	protected void ancestorAddedLblAgregar(AncestorEvent arg0) {

	}
	protected void mousePressedPanel_1(MouseEvent arg0) {
		x = arg0.getX();
	    y = arg0.getY();
	}
	public void mouseDragged(MouseEvent arg0) {
		if (arg0.getSource() == panel_1) {
			mouseDraggedPanel_1(arg0);
		}
	}
	public void mouseMoved(MouseEvent arg0) {
	}
	protected void mouseDraggedPanel_1(MouseEvent arg0) {
		 Point ubicacion = MouseInfo.getPointerInfo().getLocation();
		    setLocation(ubicacion.x - x, ubicacion.y - y);
	}

	protected void mouseClickedLabel_1(MouseEvent arg0) {
		Icon m = new ImageIcon(getClass().getResource("/image/ADVERTENCIA.png"));
		int dialog = JOptionPane.YES_NO_OPTION;
		int result =JOptionPane.showConfirmDialog(null, "¿Desea Volver a la Ventana Principal?","Advertencia",dialog,dialog,m);
	
		
		if(result ==0){
			dispose();
			Principal frame = new Principal();
			frame.setVisible(true);
		}
		
		
	}
	protected void mouseClickedLabel_3(MouseEvent arg0) {
		this.setState(Principal.ICONIFIED);
	}
}
