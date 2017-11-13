package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
public class Cama extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCama;
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
	private JButton btnAceptar;
	private JButton btnCancelar;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cama frame = new Cama();
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
	public Cama() {
		setForeground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cama.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
		setTitle("Mantenimiento | Cama");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCama = new JButton("Cama");
		btnCama.setBounds(24, 26, 89, 23);
		contentPane.add(btnCama);
		
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
		btnAdicionar.setBounds(24, 187, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(24, 236, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(24, 286, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(24, 332, 89, 23);
		contentPane.add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setEnabled(false);
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(606, 44, 89, 23);
		contentPane.add(btnGrabar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(280, 352, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(429, 352, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	private void editableTrue(){
		txtNroCama.setEditable(true);
		txtPrecio.setEditable(true);
	}
	private void editableFalse(){
		txtNroCama.setEditable(false);
		txtPrecio.setEditable(false);
		btnGrabar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnAceptar.setEnabled(false);
		btnConsultar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAdicionar.setEnabled(true);
		cboCategoria.setEnabled(false);
		cboEstado.setEnabled(false);
		
	}
	

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
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
			btnAceptar.setEnabled(true);
			cboCategoria.setEnabled(true);			
			editableTrue();
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
			btnModificar.setEnabled(false);
			btnAdicionar.setEnabled(false);
			btnCancelar.setEnabled(true);
			btnAceptar.setEnabled(true);
		    txtNroCama.setEditable(true);
		    txtPrecio.setEditable(true);
			
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
			btnConsultar.setEnabled(false);
			btnModificar.setEnabled(false);
			btnGrabar.setEnabled(true);
			btnAceptar.setEnabled(true);
			btnCancelar.setEnabled(true);
			txtNroCama.setEditable(true);
			txtPrecio.setEditable(true);
			cboCategoria.setEnabled(true);
			cboEstado.setEnabled(false);
			
		}
	}
	/*private void BuscarTipo( int i){
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
		
		
		
	}*/
	ArregloCama ac=new ArregloCama();
	private void listar(){
		modelo.setRowCount(0);
				
				for(int i=0;i<ac.tamano();i++){
					Object[]fila={
							ac.obtener(i).getEstado(),
							ac.obtener(i).getnumero_Cama(),
							ac.obtener(i).getNombres(),
							ac.obtener(i).getTelefono(),
							ac.obtener(i).getDni()
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
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		editableFalse();
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
	}
}
