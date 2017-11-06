package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pacientes extends JFrame {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField textField;
	private JLabel lblNombres;
	private JTextField textField_1;
	private JLabel lblApellidoPaterno;
	private JTextField textField_2;
	private JLabel lblApellidoMaterno;
	private JTextField textField_3;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacientes frame = new Pacientes();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(35, 39, 46, 14);
		contentPane.add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(142, 36, 145, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(35, 64, 56, 14);
		contentPane.add(lblNombres);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 61, 145, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(35, 89, 100, 14);
		contentPane.add(lblApellidoPaterno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 86, 145, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(35, 114, 100, 14);
		contentPane.add(lblApellidoMaterno);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 111, 145, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(35, 139, 46, 14);
		contentPane.add(lblTelefono);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(35, 162, 46, 14);
		contentPane.add(lblDni);
		
		textField_4 = new JTextField();
		textField_4.setBounds(142, 136, 145, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(142, 159, 145, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(416, 35, 89, 23);
		contentPane.add(btnGrabar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(416, 89, 89, 23);
		contentPane.add(btnCerrar);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ingreso", "Modificacion", "Consulta", "Eliminacion"}));
		comboBox.setBounds(297, 36, 109, 20);
		contentPane.add(comboBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 198, 581, 156);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(416, 60, 89, 23);
		contentPane.add(btnBuscar);
	}
}
