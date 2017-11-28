package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

@SuppressWarnings("unused")
public class Medicina extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNCama;
	private JTextField txtCodigo;
	private JLabel lblCategoria;
	private JLabel lblPrecioS;
	private JTextField txtNombre;
	private JLabel lblEstado;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JLabel lblStock;
	private JTextField txtStock;
	private JTextField txtLaboratorio;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicina frame = new Medicina();
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
	public Medicina() {
		setResizable(false);
		setForeground(Color.LIGHT_GRAY);
		
		setTitle("Mantenimiento | Medicina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(155, 89, 598, 223);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNCama = new JLabel("Codigo");
		lblNCama.setBounds(208, 30, 62, 14);
		contentPane.add(lblNCama);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(280, 27, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblCategoria = new JLabel("Laboratorio");
		lblCategoria.setBounds(383, 30, 69, 14);
		contentPane.add(lblCategoria);
		
		lblPrecioS = new JLabel("Nombre");
		lblPrecioS.setBounds(208, 61, 62, 14);
		contentPane.add(lblPrecioS);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(280, 58, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblEstado = new JLabel("Precio");
		lblEstado.setBounds(386, 55, 46, 14);
		contentPane.add(lblEstado);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(32, 115, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(32, 164, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(32, 214, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(32, 260, 89, 23);
		contentPane.add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(613, 27, 89, 23);
		contentPane.add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(613, 67, 89, 23);
		contentPane.add(btnCancelar);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(208, 93, 62, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setBounds(280, 90, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		txtLaboratorio = new JTextField();
		txtLaboratorio.setBounds(456, 27, 86, 20);
		contentPane.add(txtLaboratorio);
		txtLaboratorio.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(456, 58, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
	}
}
