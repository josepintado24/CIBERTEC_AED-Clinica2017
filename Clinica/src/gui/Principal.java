package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import AppPackage.AnimationClass;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionListener;
import java.net.URI;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

public class Principal extends JFrame implements MouseListener, ActionListener, MouseMotionListener {

	private static final JLabel lblEmpleados = null;
	private static final JLabel lblEmpleado = null;
	private JPanel contentPane;
	private JPanel jpnlIngreso;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel burge;
	private JLabel lblNewLabel_1;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel lblMantenimiento;
	private JLabel lblInternamiento;
	private JLabel lblAtencin;
	private JLabel lblPago;
	private JLabel lblReporte;
	private JLabel lblInternet;
	private JLabel lblCalculadora;
	private JLabel lblMusica;
	private JLabel label_9;
	private JLabel label_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Principal frame = new Principal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	
	public void OpenInternet(){
		try{
			Desktop.getDesktop().browse(URI.create("https://www.youtube.com/channel/UCDpT4o8ALlXUS79j8I8N1lg?view_as=subscriber"));
		}
		catch(Exception e){
			JOptionPane.showConfirmDialog(this , e);
		}
	}
	
	
	public void OpenCalculadora(){
		try{
			Runtime rt= Runtime.getRuntime();
			Process p = rt.exec("calc");
			p.waitFor();
		}
		catch(Exception e){
			JOptionPane.showConfirmDialog(this , e);
		}
	}
	
	public void OpenMusica(){
		try{
			Runtime rt= Runtime.getRuntime();
			Process p = rt.exec("calc");
			p.waitFor();
		}
		catch(Exception e){
			JOptionPane.showConfirmDialog(this , e);
		}
	}
	
	 private int x;
	 private int y;
	 private JPanel interPane;
	 private JLabel lblEmpleado_1;
	 private JLabel lblPaciente;
	 private JLabel lblCama;
	 private JLabel lblMedicamentos;
	 private JLabel lblServicios;
	 private JLabel atras;
	 private JPanel panel;
	 private JLabel lblInternados;
	 private JLabel lblIngresados;
	 private JLabel lblAtenciones;
	 private JLabel lblPacientesDeAlta;
	 private JLabel atras2;
	 
	public Principal() {
		setResizable(false);
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jpnlIngreso = new JPanel();
		jpnlIngreso.setForeground(Color.WHITE);
		jpnlIngreso.setBackground(Color.WHITE);
		jpnlIngreso.setBounds(0, 41, 46, 505);
		contentPane.add(jpnlIngreso);
		jpnlIngreso.setLayout(null);
		
		burge = new JLabel("");
		burge.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		burge.addMouseListener(this);
		burge.setIcon(new ImageIcon(Principal.class.getResource("/image/Menu_32px.png")));
		burge.setBounds(10, 11, 30, 28);
		jpnlIngreso.add(burge);
		
		lblInternet = new JLabel("");
		lblInternet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInternet.addMouseListener(this);
		lblInternet.setIcon(new ImageIcon(Principal.class.getResource("/image/Globe_32px.png")));
		lblInternet.setBounds(-30, 65, 30, 28);
		jpnlIngreso.add(lblInternet);
		
		lblCalculadora = new JLabel("");
		lblCalculadora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCalculadora.addMouseListener(this);
		lblCalculadora.setIcon(new ImageIcon(Principal.class.getResource("/image/Calculator_32px.png")));
		lblCalculadora.setBounds(-30, 104, 30, 28);
		jpnlIngreso.add(lblCalculadora);
		
		lblMusica = new JLabel("");
		lblMusica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMusica.addMouseListener(this);
		lblMusica.setIcon(new ImageIcon(Principal.class.getResource("/image/icons8_Music_32px.png")));
		lblMusica.setBounds(-30, 143, 30, 28);
		jpnlIngreso.add(lblMusica);
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(44, 41, 734, 505);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(this);
		lblNewLabel_1.addMouseMotionListener(this);
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/image/configuracion.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(57, 57, 132, 149);
		panel_1.add(lblNewLabel_1);
		
		label_3 = new JLabel("");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.addMouseListener(this);
		label_3.addMouseMotionListener(this);
		label_3.setIcon(new ImageIcon(Principal.class.getResource("/image/pagar.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(57, 313, 132, 136);
		panel_1.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.addMouseListener(this);
		label_4.addMouseMotionListener(this);
		label_4.setIcon(new ImageIcon(Principal.class.getResource("/image/reportar.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(318, 313, 132, 136);
		panel_1.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.addMouseListener(this);
		label_5.addMouseMotionListener(this);
		label_5.setIcon(new ImageIcon(Principal.class.getResource("/image/paciente.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(318, 51, 132, 155);
		panel_1.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.addMouseListener(this);
		label_6.addMouseMotionListener(this);
		label_6.setIcon(new ImageIcon(Principal.class.getResource("/image/atencion.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(567, 57, 132, 149);
		panel_1.add(label_6);
		
		lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setFont(new Font("Decker", Font.PLAIN, 18));
		lblMantenimiento.setBounds(63, 175, 122, 26);
		panel_1.add(lblMantenimiento);
		
		lblInternamiento = new JLabel("Internamiento");
		lblInternamiento.setFont(new Font("Decker", Font.PLAIN, 18));
		lblInternamiento.setBounds(328, 175, 115, 26);
		panel_1.add(lblInternamiento);
		
		lblAtencin = new JLabel("Atenci\u00F3n");
		lblAtencin.setFont(new Font("Decker", Font.PLAIN, 18));
		lblAtencin.setBounds(598, 175, 81, 26);
		panel_1.add(lblAtencin);
		
		lblPago = new JLabel("Pago");
		lblPago.setFont(new Font("Decker", Font.PLAIN, 18));
		lblPago.setBounds(107, 423, 51, 26);
		panel_1.add(lblPago);
		
		lblReporte = new JLabel("Reporte");
		lblReporte.setFont(new Font("Decker", Font.PLAIN, 18));
		lblReporte.setBounds(357, 423, 70, 26);
		panel_1.add(lblReporte);
		
		interPane = new JPanel();
		interPane.setBackground(Color.WHITE);
		interPane.setBounds(57, 50, 132, 188);
		panel_1.add(interPane);
		interPane.setVisible(false);
		interPane.setLayout(null);
		
		lblEmpleado_1 = new JLabel("  Empleado ");
		lblEmpleado_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEmpleado_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblEmpleado_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				if(arg0.getSource()== lblEmpleado_1){
					DlgEmpleado jFrame= new DlgEmpleado();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblEmpleado_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblEmpleado_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblEmpleado_1.setFont(new Font("Decker", Font.PLAIN, 14));
		lblEmpleado_1.setBounds(10, 0, 112, 26);
		interPane.add(lblEmpleado_1);
		
		lblPaciente = new JLabel("  Pacientes");
		lblPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblPaciente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(e.getSource()== lblPaciente){
					DlgPaciente jFrame= new DlgPaciente();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblPaciente.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblPaciente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblPaciente.setFont(new Font("Decker", Font.PLAIN, 14));
		lblPaciente.setBounds(10, 36, 112, 26);
		interPane.add(lblPaciente);
		
		lblCama = new JLabel("  Camas");
		lblCama.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCama.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()== lblCama){
					DlgCamas jFrame= new DlgCamas();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblCama.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblCama.setFont(new Font("Decker", Font.PLAIN, 14));
		lblCama.setBounds(10, 73, 112, 26);
		interPane.add(lblCama);
		
		lblMedicamentos = new JLabel("  Medicamentos");
		lblMedicamentos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMedicamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblMedicamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()== lblMedicamentos){
					DlgMedicamento jFrame= new DlgMedicamento();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblMedicamentos.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblMedicamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblMedicamentos.setFont(new Font("Decker", Font.PLAIN, 14));
		lblMedicamentos.setBounds(10, 110, 112, 26);
		interPane.add(lblMedicamentos);
		
		lblServicios = new JLabel("  Servicios");
		lblServicios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblServicios.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblServicios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblServicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblServicios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()== lblServicios){
					DlgServicios jFrame= new  DlgServicios();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblServicios.setFont(new Font("Decker", Font.PLAIN, 14));
		lblServicios.setBounds(10, 147, 112, 26);
		interPane.add(lblServicios);
		
		atras = new JLabel("");
		atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()== atras){
					interPane.setVisible(false);
					lblNewLabel_1.setVisible(true);
					lblMantenimiento.setVisible(true);
					atras.setVisible(false);
					}
				
			}
		});
		atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		atras.setIcon(new ImageIcon(Principal.class.getResource("/image/icons8_Undo_20px.png")));
		atras.setBounds(164, 21, 25, 26);
		atras.setVisible(false);
		panel_1.add(atras);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(318, 313, 162, 149);
		panel_1.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		lblInternados = new JLabel("  Internados");
		lblInternados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInternados.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblInternados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblInternados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblInternados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()== lblInternados){
					DlgReportePacientesAdmitidos jFrame= new DlgReportePacientesAdmitidos();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblInternados.setFont(new Font("Decker", Font.PLAIN, 14));
		lblInternados.setBounds(10, 0, 142, 26);
		panel.add(lblInternados);
		
		lblIngresados = new JLabel("  Internados Pagados");
		lblIngresados.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblIngresados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblIngresados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblIngresados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()== lblIngresados){
					DlgReporteHospitalizacionesPorFecha jFrame= new DlgReporteHospitalizacionesPorFecha();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblIngresados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIngresados.setFont(new Font("Decker", Font.PLAIN, 14));
		lblIngresados.setBounds(10, 37, 142, 26);
		panel.add(lblIngresados);
		
		lblAtenciones = new JLabel("  Atenciones Pagadas");
		lblAtenciones.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblAtenciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblAtenciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblAtenciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()== lblAtenciones){
					DlgReportePacientesPagado jFrame= new DlgReportePacientesPagado();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblAtenciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAtenciones.setFont(new Font("Decker", Font.PLAIN, 14));
		lblAtenciones.setBounds(10, 74, 142, 26);
		panel.add(lblAtenciones);
		
		lblPacientesDeAlta = new JLabel("  Pacientes de Alta");
		lblPacientesDeAlta.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblPacientesDeAlta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
			}
		});
		lblPacientesDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblPacientesDeAlta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource()== lblPacientesDeAlta){
					DlgReporteEmpleadosHospitalizaciones jFrame= new DlgReporteEmpleadosHospitalizaciones();
					setVisible(false);
					jFrame.setVisible(true);
					jFrame.setLocationRelativeTo(null);
					
				}
			}
		});
		lblPacientesDeAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPacientesDeAlta.setFont(new Font("Decker", Font.PLAIN, 14));
		lblPacientesDeAlta.setBounds(10, 111, 142, 26);
		panel.add(lblPacientesDeAlta);
		
		atras2 = new JLabel("");
		atras2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				label_4.setVisible(true);
				lblReporte.setVisible(true);
				atras2.setVisible(false);
			}
		});
		atras2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		atras2.setIcon(new ImageIcon(Principal.class.getResource("/image/icons8_Undo_20px.png")));
		atras2.setBounds(454, 282, 25, 20);
		atras2.setVisible(false);
		panel_1.add(atras2);
		
		panel_2 = new JPanel();
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				x = arg0.getX();
			    y = arg0.getY();
			}
		});
		panel_2.addMouseMotionListener(new MouseMotionAdapter() {	
			@Override
			public void mouseDragged(MouseEvent arg0) {
				  Point ubicacion = MouseInfo.getPointerInfo().getLocation();
				    setLocation(ubicacion.x - x, ubicacion.y - y);
				
			}
		});
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 778, 39);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		label_9 = new JLabel("");
		label_9.addMouseListener(this);
		label_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_9.setIcon(new ImageIcon(Principal.class.getResource("/image/Minimize_Window_32px.png")));
		label_9.setBounds(706, 11, 32, 21);
		panel_2.add(label_9);
		
		label_10 = new JLabel("");
		label_10.addMouseListener(this);
		label_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_10.setIcon(new ImageIcon(Principal.class.getResource("/image/X_32px.png")));
		label_10.setBounds(739, 11, 32, 21);
		panel_2.add(label_10);
		
		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setFont(new Font("Decker", Font.PLAIN, 16));
		lblPrincipal.setBounds(36, 11, 94, 21);
		panel_2.add(lblPrincipal);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Principal.class.getResource("/image/hospital.png")));
		label_11.setBounds(10, 11, 21, 21);
		panel_2.add(label_11);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblMusica) {
			mouseClickedLblMusica(e);
			lblMusica.setVisible(true);
			
			if (e.getSource() != lblMusica) {
			mouseClickedLblMusica(e);
			lblMusica.setVisible(false);
		}
		}
		
		else if (e.getSource() == lblCalculadora) {
			mouseClickedLblCalculadora(e);
			lblCalculadora.setVisible(true);
			if (e.getSource() != lblCalculadora) {
				mouseClickedLblCalculadora(e);
				lblCalculadora.setVisible(false);
			}
		}
		
		else if (e.getSource() == lblInternet) {
			mouseClickedLblInternet(e);
			lblInternet.setVisible(true);
			 if (e.getSource() != lblInternet) {
			mouseClickedLblInternet(e);
			lblInternet.setVisible(false);
		}
		}
		
		if (e.getSource() == label_10) {
			mouseClickedLabel_10(e);
		}
		if (e.getSource() == label_9) {
			mouseClickedLabel_9(e);
		}
		
/*--------------------------------------------------------------------*/		
		
		if(e.getSource()== burge){
			
		AnimationClass internet= new AnimationClass();
		/*start, stop, delay, increment, lblInternet*/
		internet.jLabelXRight(-30, 10, 10, 5, lblInternet);
		
		AnimationClass internett= new AnimationClass();
		/*start, stop, delay, increment, lblInternet*/
		internett.jLabelXLeft(10, -30, 10, 5, lblInternet);
		
		}
		
		
/*--------------------------------------------------------------------*/
		if(e.getSource()== burge){
		AnimationClass calculadora= new AnimationClass();
		/*start, stop, delay, increment, lblInternet*/
		calculadora.jLabelXRight(-30, 10, 10, 5, lblCalculadora);
		
		AnimationClass calculadoraa= new AnimationClass();
		/*start, stop, delay, increment, lblInternet*/
		calculadoraa.jLabelXLeft(10, -30, 10, 5, lblCalculadora);
		}
		
		
		
/*--------------------------------------------------------------------*/		
		if(e.getSource()== burge){
		AnimationClass musica= new AnimationClass();
		/*start, stop, delay, increment, lblInternet*/
		musica.jLabelXRight(-30, 10, 10, 5, lblMusica);
		
		AnimationClass musicaa= new AnimationClass();
		/*start, stop, delay, increment, lblInternet*/
		musicaa.jLabelXLeft(10, -30, 10, 5, lblMusica);
		}
	
		/*------------------------------------------------------------*/
		
	

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == label_4) {
			mouseExitedLabel_4(e);
		}
		if (e.getSource() == label_3) {
			mouseExitedLabel_3(e);
		}
		if (e.getSource() == label_6) {
			mouseExitedLabel_6(e);
		}
		if (e.getSource() == label_5) {
			mouseExitedLabel_5(e);
		}
		if (e.getSource() == lblNewLabel_1) {
			mouseExitedLblNewLabel_1(e);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getSource()== lblNewLabel_1){
		interPane.setVisible(true);
		lblNewLabel_1.setVisible(false);
		lblMantenimiento.setVisible(false);
		atras.setVisible(true);
		}
		
		if(e.getSource()== label_4){
			panel.setVisible(true);
			label_4.setVisible(false);
			lblReporte.setVisible(false);
			atras2.setVisible(true);
			}
		
		if(e.getSource()== label_5){
			DlgInternamiento jFrame= new DlgInternamiento();
			this.setVisible(false);
			jFrame.setVisible(true);
			jFrame.setLocationRelativeTo(null);
			
		}
		
		if(e.getSource()== label_6){
			DlgRegistroConsumo jFrame= new DlgRegistroConsumo();
			this.setVisible(false);
			jFrame.setVisible(true);
			jFrame.setLocationRelativeTo(null);
			
		}
		
		if(e.getSource()== label_3){
			DlgControlDePagos jFrame= new DlgControlDePagos();
			this.setVisible(false);
			jFrame.setVisible(true);
			jFrame.setLocationRelativeTo(null);
			
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent arg0) {
	}
	protected void mouseClickedLabel_9(MouseEvent e) {
		this.setState(Principal.ICONIFIED);
	}
	protected void mouseClickedLabel_10(MouseEvent e) {
		Icon m = new ImageIcon(getClass().getResource("/image/ADVERTENCIA.png"));
		int dialog = JOptionPane.YES_NO_OPTION;
		int result =JOptionPane.showConfirmDialog(null, "¿Desea Salir de la ventana Principal?","Exit",dialog,dialog,m);
		
		if(result ==0){
			System.exit(0);
		}
	}
	public void mouseDragged(MouseEvent arg0) {
	}
	public void mouseMoved(MouseEvent arg0) {
		if (arg0.getSource() == label_4) {
			mouseMovedLabel_4(arg0);
		}
		if (arg0.getSource() == label_3) {
			mouseMovedLabel_3(arg0);
		}
		if (arg0.getSource() == label_6) {
			mouseMovedLabel_6(arg0);
		}
		if (arg0.getSource() == label_5) {
			mouseMovedLabel_5(arg0);
		}
		if (arg0.getSource() == lblNewLabel_1) {
			mouseMovedLblNewLabel_1(arg0);
		}
	}
	
	protected void mouseMovedLblNewLabel_1(MouseEvent arg0) {
		lblNewLabel_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
	}
	protected void mouseExitedLblNewLabel_1(MouseEvent e) {
		lblNewLabel_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
	}
	

	protected void mouseMovedLabel_5(MouseEvent arg0) {
		label_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
	}
	protected void mouseExitedLabel_5(MouseEvent e) {
		label_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
	}
	
	
	protected void mouseMovedLabel_6(MouseEvent arg0) {
		label_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
	}
	protected void mouseExitedLabel_6(MouseEvent e) {
		label_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
	}
	
	
	protected void mouseMovedLabel_3(MouseEvent arg0) {
		label_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
	}
	protected void mouseExitedLabel_3(MouseEvent e) {
		label_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
	}
	
	
	protected void mouseMovedLabel_4(MouseEvent arg0) {
		label_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
	}
	
	protected void mouseExitedLabel_4(MouseEvent e) {
		label_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
	}
	
	protected void mouseClickedLblInternet(MouseEvent e) {
		OpenInternet();
	}
	protected void mouseClickedLblCalculadora(MouseEvent e) {
		OpenCalculadora();
	}
	protected void mouseClickedLblMusica(MouseEvent e) {
		
		
	}
}
