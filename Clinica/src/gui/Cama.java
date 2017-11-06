package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Cama extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cboCama;
	private JButton btnGrabar;
	private JButton btnBuscar;
	private JButton btnCerrar;
	private JLabel lblCodigo;
	private JTextField txtCama;
	private JLabel lblApellidoMaterno;
	private JTextField txtPrecio;
	private JLabel lblEstado;
	private JComboBox cboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cama frame = new Cama();
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
	public Cama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboCama = new JComboBox();
		cboCama.setModel(new DefaultComboBoxModel(new String[] {"Ingreso", "Modificacion", "Consulta", "Eliminacion", "Listado"}));
		cboCama.setBounds(303, 30, 103, 20);
		contentPane.add(cboCama);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(438, 29, 89, 23);
		contentPane.add(btnGrabar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(438, 63, 89, 23);
		contentPane.add(btnBuscar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(438, 97, 89, 23);
		contentPane.add(btnCerrar);
		
		lblCodigo = new JLabel("Numero de cama:");
		lblCodigo.setBounds(10, 33, 84, 14);
		contentPane.add(lblCodigo);
		
		txtCama = new JTextField();
		txtCama.setBounds(104, 30, 110, 20);
		contentPane.add(txtCama);
		txtCama.setColumns(10);
		
		lblApellidoMaterno = new JLabel("Precio:");
		lblApellidoMaterno.setBounds(10, 67, 89, 14);
		contentPane.add(lblApellidoMaterno);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(104, 64, 110, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 101, 46, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupada"}));
		cboEstado.setBounds(104, 98, 110, 20);
		contentPane.add(cboEstado);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabaar(arg0);
		}
	}
	protected void actionPerformedBtnGrabaar(ActionEvent arg0) {
	}
}
