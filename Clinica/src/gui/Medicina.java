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
	private JTextField textField;
	private JLabel lblCategoria;
	private JComboBox comboBox;
	private JLabel lblPrecioS;
	private JTextField textField_1;
	private JLabel lblEstado;
	private JComboBox comboBox_1;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnCancelar;

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
		scrollPane.setBounds(145, 118, 598, 223);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNCama = new JLabel("Codigo");
		lblNCama.setBounds(193, 27, 89, 14);
		contentPane.add(lblNCama);
		
		textField = new JTextField();
		textField.setBounds(280, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblCategoria = new JLabel("Laboratorio");
		lblCategoria.setBounds(376, 30, 69, 14);
		contentPane.add(lblCategoria);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Economico", "Ejecutivo"}));
		comboBox.setBounds(462, 26, 104, 20);
		contentPane.add(comboBox);
		
		lblPrecioS = new JLabel("Nombre");
		lblPrecioS.setBounds(213, 72, 62, 14);
		contentPane.add(lblPrecioS);
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 69, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblEstado = new JLabel("Precio");
		lblEstado.setBounds(393, 72, 46, 14);
		contentPane.add(lblEstado);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado", ""}));
		comboBox_1.setBounds(462, 71, 102, 20);
		contentPane.add(comboBox_1);
		
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
	}
}
