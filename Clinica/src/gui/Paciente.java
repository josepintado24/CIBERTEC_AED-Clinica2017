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
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Paciente extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
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
	public Paciente() {
		setTitle("PACIENTE-MANTENIMIENTO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(7, 38, 58));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		modelo=new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		
		btnGrabar = new JButton("Aceptar");
		btnGrabar.setBounds(517, 379, 160, 23);
		contentPane.add(btnGrabar);
		btnGrabar.addActionListener(this);
		btnGrabar.setEnabled(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(517, 413, 160, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setEnabled(false);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(36, 64, 89, 23);
		contentPane.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(142, 64, 89, 23);
		contentPane.add(btnConsultar);
		
		
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(241, 64, 89, 23);
		contentPane.add(btnIngresar);
		
		cboBuscar = new JComboBox();
		cboBuscar.setBounds(517, 11, 86, 20);
		contentPane.add(cboBuscar);
		cboBuscar.addActionListener(this);
		cboBuscar.setEnabled(false);
		cboBuscar.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Apellido", "Nombre", "DNI"}));
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(255, 255, 255));
		txtNombre.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtNombre.setBounds(554, 145, 117, 23);
		contentPane.add(txtNombre);
		txtNombre.addKeyListener(this);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBorder(null);
		txtNombre.setOpaque(false);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNombre.setBounds(554, 123, 117, 23);
		contentPane.add(lblNombre);
		
		txtApellido = new JTextField();
		txtApellido.setForeground(new Color(255, 255, 255));
		txtApellido.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtApellido.setBounds(554, 213, 117, 20);
		contentPane.add(txtApellido);
		txtApellido.addKeyListener(this);
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBorder(null);
		txtApellido.setOpaque(false);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblApellido.setBounds(554, 189, 117, 23);
		contentPane.add(lblApellido);
		
		txtDNI = new JTextField();
		txtDNI.setForeground(new Color(255, 255, 255));
		txtDNI.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtDNI.setBounds(554, 278, 117, 20);
		contentPane.add(txtDNI);
		txtDNI.addKeyListener(this);
		txtDNI.setEditable(false);
		txtDNI.setColumns(10);
		txtDNI.setBorder(null);
		txtDNI.setOpaque(false);
		
		
		lblDni = new JLabel("DNI");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblDni.setBounds(554, 244, 117, 23);
		contentPane.add(lblDni);
		
		
		txtCodigo = new JTextField();
		txtCodigo.setForeground(new Color(255, 255, 255));
		txtCodigo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtCodigo.setBounds(554, 64, 117, 23);
		contentPane.add(txtCodigo);
		txtCodigo.addKeyListener(this);
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBorder(null);
		txtCodigo.setOpaque(false);
		
		lblCodigo = new JLabel("codigo");
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblCodigo.setBounds(554, 42, 117, 23);
		contentPane.add(lblCodigo);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblTelefono.setBounds(554, 309, 117, 23);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(255, 255, 255));
		txtTelefono.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		txtTelefono.setBounds(554, 331, 114, 23);
		contentPane.add(txtTelefono);
		txtTelefono.addKeyListener(this);
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setOpaque(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 444, 371);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Paciente.class.getResource("/img/key.png")));
		label.setBounds(517, 49, 35, 50);
		contentPane.add(label);
		
		LineCodigo = new JSeparator();
		LineCodigo.setBounds(517, 94, 160, 2);
		contentPane.add(LineCodigo);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Paciente.class.getResource("/img/name.png")));
		label_1.setBounds(517, 128, 35, 50);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Paciente.class.getResource("/img/apellido.png")));
		label_2.setBounds(517, 195, 35, 50);
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Paciente.class.getResource("/img/dni.png")));
		label_3.setBounds(517, 256, 35, 50);
		contentPane.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Paciente.class.getResource("/img/phpmp.png")));
		label_4.setBounds(517, 318, 35, 50);
		contentPane.add(label_4);
		
		separator = new JSeparator();
		separator.setBounds(517, 176, 160, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(517, 243, 160, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(517, 298, 160, 2);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(517, 362, 160, 2);
		contentPane.add(separator_3);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(340, 61, 129, 27);
		contentPane.add(btnEliminar);
		
		
		lblGrabar = new JLabel("Grabar");
		lblGrabar.addMouseListener(this);
		lblGrabar.setIcon(new ImageIcon(Paciente.class.getResource("/img/save.png")));
		lblGrabar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblGrabar.setForeground(new Color(255, 255, 255));
		lblGrabar.setBackground(new Color(231, 96, 90));
		lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrabar.setBounds(517, 456, 174, 41);
		lblGrabar.setOpaque(true);
		contentPane.add(lblGrabar);
		
		lblModificar = new JLabel("MODIFICAR");
		lblModificar.setIcon(new ImageIcon(Paciente.class.getResource("/img/edit.png")));
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModificar.setForeground(new Color(255, 255, 255));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setBounds(10, 26, 117, 27);
		contentPane.add(lblModificar);
		
		lblConsultar = new JLabel("CONSULTAR");
		lblConsultar.setIcon(new ImageIcon(Paciente.class.getResource("/img/buscar.png")));
		lblConsultar.setForeground(new Color(255, 255, 255));
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultar.setBounds(142, 26, 117, 27);
		contentPane.add(lblConsultar);
		
		lblIngresar = new JLabel("INGRESAR");
		lblIngresar.setIcon(new ImageIcon(Paciente.class.getResource("/img/ingresar.png")));
		lblIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setBackground(new Color(255, 255, 255));
		lblIngresar.setBounds(279, 26, 117, 27);
		contentPane.add(lblIngresar);
		
		lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEliminar.setForeground(new Color(255, 255, 255));
		lblEliminar.setIcon(new ImageIcon(Paciente.class.getResource("/img/tacho.png")));
		lblEliminar.setBounds(397, 26, 110, 24);
		contentPane.add(lblEliminar);
		
		label_8 = new JLabel("New label");
		label_8.setBounds(79, 456, 46, 14);
		contentPane.add(label_8);
		
		label_9 = new JLabel("New label");
		label_9.setBounds(167, 456, 46, 14);
		contentPane.add(label_9);
		btnIngresar.addActionListener(this);
		btnConsultar.addActionListener(this);
		btnModificar.addActionListener(this);
		
	}
	ArregloPacientes ap= new ArregloPacientes();
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel label;
	private JSeparator LineCodigo;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JButton btnEliminar;
	private JLabel lblGrabar;
	private JLabel lblModificar;
	private JLabel lblConsultar;
	private JLabel lblIngresar;
	private JLabel lblEliminar;
	private JLabel label_8;
	private JLabel label_9;
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
		setBounds(100, 100, 779, 520);
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
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == lblGrabar) {
			mouseEnteredLblGrabar(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
		lblGrabar.setBackground(new Color(231, 96, 90));
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseEnteredLblGrabar(MouseEvent arg0) {
		lblGrabar.setBackground(new Color(154, 65, 60));
	}
}
