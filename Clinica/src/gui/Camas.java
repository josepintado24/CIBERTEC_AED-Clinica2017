package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Cama;
import Clases.Pacientes;
import controlador.ArregloCama;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Camas extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabla;
	private JLabel lblNCama;
	private JTextField txtNroCama;
	private JLabel lblCategoria;
	private JComboBox cboCategoria;
	private JLabel lblPrecioS;
	private JTextField txtPrecio;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Camas frame = new Camas();
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
	public Camas() {
		setForeground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Camas.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
		setTitle("Mantenimiento | Cama");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 118, 598, 223);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		modelo=new DefaultTableModel();
		modelo.addColumn("Numero de Cama");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio por dia");
		modelo.addColumn("Estado");
		tabla.setModel(modelo);
		
		lblNCama = new JLabel("Numero Cama");
		lblNCama.setBounds(193, 27, 89, 14);
		contentPane.add(lblNCama);
		
		txtNroCama = new JTextField();
		txtNroCama.setEditable(false);
		txtNroCama.setBounds(280, 27, 86, 20);
		contentPane.add(txtNroCama);
		txtNroCama.setColumns(10);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(401, 29, 69, 14);
		contentPane.add(lblCategoria);
		
		cboCategoria = new JComboBox();
		cboCategoria.setEditable(true);
		cboCategoria.setEnabled(false);
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Economico", "Ejecutivo"}));
		cboCategoria.setBounds(462, 26, 104, 20);
		contentPane.add(cboCategoria);
		
		lblPrecioS = new JLabel("Precio");
		lblPrecioS.setBounds(213, 72, 62, 14);
		contentPane.add(lblPrecioS);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(280, 69, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(401, 74, 46, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setEditable(true);
		cboEstado.setEnabled(false);
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado", ""}));
		cboEstado.setBounds(462, 71, 102, 20);
		contentPane.add(cboEstado);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(26, 118, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(26, 167, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(26, 217, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(26, 263, 89, 23);
		contentPane.add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setEnabled(false);
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(606, 23, 89, 23);
		contentPane.add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(606, 68, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	private void editableTrue(){
		txtNroCama.setEditable(true);
		txtPrecio.setEditable(true);
		cboCategoria.setEnabled(true);
		cboEstado.setEnabled(true);
	}
	private void editableFalse(){
		txtNroCama.setEditable(false);
		txtPrecio.setEditable(false);
		btnGrabar.setEnabled(false);
		btnCancelar.setEnabled(false);
		cboCategoria.setEnabled(false);
		cboEstado.setEnabled(false);
		
	}
	

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
			btnConsultar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnAdicionar.setEnabled(true);
			btnEliminar.setEnabled(true);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
			btnConsultar.setEnabled(false);
			btnAdicionar.setEnabled(false);
			btnGrabar.setEnabled(true);
			btnCancelar.setEnabled(true);
			cboCategoria.setEnabled(true);	
			btnEliminar.setEnabled(true);
			editableTrue();
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
			btnModificar.setEnabled(false);
			btnAdicionar.setEnabled(false);
			btnCancelar.setEnabled(true);
		    txtNroCama.setEditable(true);
		    txtPrecio.setEditable(true);
			
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
			btnConsultar.setEnabled(false);
			btnModificar.setEnabled(false);
			btnGrabar.setEnabled(true);
			btnCancelar.setEnabled(true);
			btnEliminar.setEnabled(false);
			editableTrue();
			
			
		}
	}
	
	
	
	
	
	
	ArregloCama ac=new ArregloCama();
	private void listar(){
		modelo.setRowCount(0);
				
				for(int i=0;i<ac.tamano();i++){
					Object[]fila={
							ac.obtener(i).getnumero_Cama(),
							ac.obtener(i).getCategoria(),
							ac.obtener(i).getPrecioDia(),
							ac.obtener(i).getEstado()
					};
					modelo.addRow(fila);
				}
	}

	
	
	

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		editableFalse();
	}
	private int obtenerCategoria(){
		return cboCategoria.getSelectedIndex();
	}
	private String categoria(int i){
		String cate="";
		switch (i){
		case 0:
			cate="Economico";
					
			
			break;
		case 1:
			cate="Ejecutivo";
			break;
		}
		return cate;
	}
	
	private int obtenerEstado(){
		return cboCategoria.getSelectedIndex();
	}
	private String estado(int i){
		String stad="";
		switch (i){
		case 0:
			stad="Libre";
					
			
			break;
		case 1:
			stad="Ocupado";
			break;
		}
		return stad;
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {

		int nroCama=Integer.parseInt(txtNroCama.getText());
		double precio=Double.parseDouble(txtPrecio.getText());
		String categoria=categoria(obtenerCategoria());
		String estado=estado(obtenerEstado());
		Cama objap=new Cama(nroCama,estado,precio,categoria);
		ac.adicionar(objap);
		listar();
	}
}
