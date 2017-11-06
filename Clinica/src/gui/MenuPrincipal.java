package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnInternamiento;
	private JMenu mnAtencion;
	private JMenu mnPago;
	private JMenu mnReporte;
	private JMenuItem mntmCama;
	private JMenuItem mntmPaciente;
	private JMenuItem mntmMedicina;
	private JMenuItem mntmPaciente_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 365);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmCama = new JMenuItem("Cama");
		mnMantenimiento.add(mntmCama);
		
		mntmPaciente = new JMenuItem("Paciente");
		mnMantenimiento.add(mntmPaciente);
		
		mntmMedicina = new JMenuItem("Medicina");
		mnMantenimiento.add(mntmMedicina);
		
		mnInternamiento = new JMenu("Internamiento");
		menuBar.add(mnInternamiento);
		
		mntmPaciente_1 = new JMenuItem("Paciente");
		mnInternamiento.add(mntmPaciente_1);
		
		mnAtencion = new JMenu("Atencion");
		menuBar.add(mnAtencion);
		
		mnPago = new JMenu("Pago");
		menuBar.add(mnPago);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
