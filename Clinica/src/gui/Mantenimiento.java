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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JTable;

public class Mantenimiento extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCama;
	private JLabel lblPaciente;
	private JLabel lblMedicina;
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
	private JButton btnIngresar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JComboBox cboBuscar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento frame = new Mantenimiento();
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
	public Mantenimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(192, 35, 604, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("codigo");
		lblCodigo.setBounds(32, 26, 46, 14);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(88, 23, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(184, 29, 46, 14);
		panel.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(336, 26, 46, 14);
		panel.add(lblNombre);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(32, 70, 46, 14);
		panel.add(lblTelefono);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(184, 70, 46, 14);
		panel.add(lblDni);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(this);
		txtApellido.setEditable(false);
		txtApellido.setBounds(240, 26, 86, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setEditable(false);
		txtNombre.setBounds(380, 23, 86, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(88, 67, 86, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setEditable(false);
		txtDNI.setBounds(240, 70, 86, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(111, 333, 89, 23);
		panel.add(btnIngresar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(309, 333, 89, 23);
		panel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(409, 333, 89, 23);
		panel.add(btnModificar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setEnabled(false);
		btnGrabar.setBounds(505, 22, 89, 23);
		panel.add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(505, 66, 89, 23);
		panel.add(btnCancelar);
		
		cboBuscar = new JComboBox();
		cboBuscar.addActionListener(this);
		cboBuscar.setEnabled(false);
		cboBuscar.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Apellido", "Nombre", "DNI"}));
		cboBuscar.setBounds(380, 67, 86, 20);
		panel.add(cboBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 120, 543, 166);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		modelo=new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		table.setModel(modelo);
		
		lblCama = new JLabel("Cama");
		lblCama.setBounds(41, 80, 46, 14);
		contentPane.add(lblCama);
		
		lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(41, 123, 46, 14);
		contentPane.add(lblPaciente);
		
		lblMedicina = new JLabel("Medicina");
		lblMedicina.setBounds(41, 182, 46, 14);
		contentPane.add(lblMedicina);
	}
	ArregloPacientes ap= new ArregloPacientes();
	private JScrollPane scrollPane;
	private JTable table;
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
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboBuscar) {
			actionPerformedCboBuscar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
			btnConsultar.setEnabled(false);
			btnIngresar.setEnabled(false);
			btnGrabar.setEnabled(true);
			btnCancelar.setEnabled(true);
			editableTrue();
		
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
			btnModificar.setEnabled(false);
			btnIngresar.setEnabled(false);
			btnCancelar.setEnabled(true);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
			btnConsultar.setEnabled(false);
			btnModificar.setEnabled(false);
			btnGrabar.setEnabled(true);
			btnCancelar.setEnabled(true);
		}
	}
	private int comboBuscar(){
		return cboBuscar.getSelectedIndex();
	}
	private void BuscarTipo( int i){
		switch (i){
		case 0:
			txtCodigo.setEditable(true);
			txtApellido.setEditable(false);
			txtNombre.setEditable(false);
			txtDNI.setEditable(false);
			
			break;
		case 1:
			txtCodigo.setEditable(false);
			txtApellido.setEditable(true);
			txtNombre.setEditable(false);
			txtDNI.setEditable(false);
			break;
		case 2:
			txtCodigo.setEditable(false);
			txtApellido.setEditable(false);
			txtNombre.setEditable(true);
			txtDNI.setEditable(false);
			break;
		case 3:
			txtCodigo.setEditable(false);
			txtApellido.setEditable(false);
			txtNombre.setEditable(false);
			txtDNI.setEditable(true);
			break;
		}
		
		
		
	}
	
	private void editableTrue(){
		txtCodigo.setEditable(true);
		txtDNI.setEditable(true);
		txtApellido.setEditable(true);
		txtNombre.setEditable(true);
		txtTelefono.setEditable(true);
	}
	private void editableFalse(){
		txtCodigo.setEditable(false);
		txtDNI.setEditable(false);
		txtApellido.setEditable(false);
		txtNombre.setEditable(false);
		txtTelefono.setEditable(false);
		btnGrabar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnConsultar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnIngresar.setEnabled(true);
		cboBuscar.setEnabled(false);
	}
	
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		editableTrue();
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		cboBuscar.setEnabled(true);
		
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		int codigo=Integer.parseInt(txtCodigo.getText());
		String apellido=txtApellido.getText();
		String nombre=txtNombre.getText();
		String telefono=txtTelefono.getText();
		String dni=txtDNI.getText();
		Pacientes objap=new Pacientes(codigo,apellido,nombre,telefono,dni);
		ap.adicionar(objap);
		listar();
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		editableFalse();
	}
	protected void actionPerformedCboBuscar(ActionEvent arg0) {
		BuscarTipo( comboBuscar());
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
}
