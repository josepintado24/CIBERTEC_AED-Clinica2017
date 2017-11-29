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

	private JPanel contentPane;
	private JPanel jpnlIngreso;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblUser;
	private JLabel lblPasw;
	private JLabel lblNewLabel;
	private JTextField txtIngreseSuUsuario;
	private JSeparator separator;
	private JPasswordField passwordField;
	private JSeparator separator_1;
	private JLabel burge;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnNewButton;
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
	 
	public Principal() {
		setResizable(false);
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jpnlIngreso = new JPanel();
		jpnlIngreso.setForeground(Color.WHITE);
		jpnlIngreso.setBackground(Color.WHITE);
		jpnlIngreso.setBounds(0, 41, 290, 505);
		contentPane.add(jpnlIngreso);
		jpnlIngreso.setLayout(null);
		
		lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Decker", Font.PLAIN, 18));
		lblUser.setBounds(26, 225, 46, 14);
		jpnlIngreso.add(lblUser);
		
		lblPasw = new JLabel("Password:");
		lblPasw.setFont(new Font("Decker", Font.PLAIN, 18));
		lblPasw.setBounds(26, 348, 78, 14);
		jpnlIngreso.add(lblPasw);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/image/user.png")));
		lblNewLabel.setBounds(83, 43, 134, 128);
		jpnlIngreso.add(lblNewLabel);
		
		txtIngreseSuUsuario = new JTextField();
		txtIngreseSuUsuario.setText("  Ingrese su usuario");
		txtIngreseSuUsuario.setFont(new Font("Decker", Font.PLAIN, 14));
		txtIngreseSuUsuario.setForeground(Color.GRAY);
		txtIngreseSuUsuario.setBounds(83, 258, 171, 28);
		jpnlIngreso.add(txtIngreseSuUsuario);
		txtIngreseSuUsuario.setColumns(10);
		txtIngreseSuUsuario.setBorder(null);
		
		
		separator = new JSeparator();
		separator.setBounds(48, 287, 206, 17);
		jpnlIngreso.add(separator);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(83, 382, 171, 28);
		jpnlIngreso.add(passwordField);
		passwordField.setBorder(null);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(48, 410, 206, 17);
		jpnlIngreso.add(separator_1);
		
		burge = new JLabel("");
		burge.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		burge.addMouseListener(this);
		burge.setIcon(new ImageIcon(Principal.class.getResource("/image/Menu_32px.png")));
		burge.setBounds(10, 11, 30, 28);
		jpnlIngreso.add(burge);
		
		
		
		
		
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Principal.class.getResource("/image/User_32px.png")));
		label_1.setBounds(42, 258, 30, 28);
		jpnlIngreso.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Principal.class.getResource("/image/Key_32px.png")));
		label_2.setBounds(42, 382, 30, 28);
		jpnlIngreso.add(label_2);
		
		btnNewButton = new JButton((String) null);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setRolloverIcon(new ImageIcon(Principal.class.getResource("/image/ingresar2.png")));
		btnNewButton.setSelectedIcon(new ImageIcon(Principal.class.getResource("/image/ingresar1.png")));
		//btnNewButton.setRolloverIcon(new ImageIcon(Principal.class.getResource("/image/ingresar2.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/image/ingresar1.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(66, 450, 134, 41);
		jpnlIngreso.add(btnNewButton);
		
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
		panel_1.setBounds(292, 41, 826, 505);
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
		label_3.setBounds(57, 257, 132, 136);
		panel_1.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.addMouseListener(this);
		label_4.addMouseMotionListener(this);
		label_4.setIcon(new ImageIcon(Principal.class.getResource("/image/reportar.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(318, 257, 132, 136);
		panel_1.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.addMouseListener(this);
		label_5.addMouseMotionListener(this);
		label_5.setIcon(new ImageIcon(Principal.class.getResource("/image/paciente.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(318, 57, 132, 149);
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
		lblPago.setBounds(107, 367, 51, 26);
		panel_1.add(lblPago);
		
		lblReporte = new JLabel("Reporte");
		lblReporte.setFont(new Font("Decker", Font.PLAIN, 18));
		lblReporte.setBounds(357, 367, 70, 26);
		panel_1.add(lblReporte);
		
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
		panel_2.setBounds(0, 0, 1044, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		label_9 = new JLabel("");
		label_9.addMouseListener(this);
		label_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_9.setIcon(new ImageIcon(Principal.class.getResource("/image/Minimize_Window_32px.png")));
		label_9.setBounds(969, 11, 32, 21);
		panel_2.add(label_9);
		
		label_10 = new JLabel("");
		label_10.addMouseListener(this);
		label_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_10.setIcon(new ImageIcon(Principal.class.getResource("/image/X_32px.png")));
		label_10.setBounds(1002, 11, 32, 21);
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
		
		if(e.getSource()== label_5){
			Paciente inter1= new Paciente();
			inter1.setVisible(true);
			inter1.setLocationRelativeTo(null);
			this.setVisible(false);
			
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
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
