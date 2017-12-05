package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloServicio;
import clases.Servicio;
import libreria.DiseñoObjetos;
import libreria.Validaciones;
import libreria.Libreria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class DlgServicios extends JDialog implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;
	private JLabel lblTipo;
	private JComboBox<String> cboTipo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblMensaje;
	private JScrollPane scrollPane;
	private JTable jtblServicios;
	private int x;
	private int y;

	// Declaración global para modelo de tabla
	private DefaultTableModel dtm;

	// Tipo de operación a procesar:
	// Adicionar, Modificar, Eliminar o Consultar
	private int tipoOperacion;
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR = 2;
	public final static int CONSULTAR = 3;
	// declaracion global
	ArregloServicio as = new ArregloServicio("servicios.txt");
	// Declaración global de libreria Validaciones
	Validaciones v = new Validaciones();
	// Declaración global de libreria DiseñoObjetos
	DiseñoObjetos ds = new DiseñoObjetos();
	// Declaración global de libreria
	Libreria lb = new Libreria();
	//DECLARACIÓN GLOBAL PARA OBTENER CÓDIGO Y PRECIO DEL SERVICO 
	public String codServicio = "";
	public double precioServicio = 0.0;
	public String nomServicio = "";
	private JPanel panel;
	private JLabel label;
	private JLabel lblServicios;
	private JPanel panel_1;
	private JLabel lbliconCodigo;
	private JSeparator sCodigo;
	private JLabel lbliconDescripcion;
	private JSeparator sDescripcion;
	private JLabel lbliconPrecio;
	private JSeparator sPrecio;
	private JLabel lblIngresar;
	private JLabel lblConsultar;
	private JLabel lblModificar;
	private JLabel lblEliminar;
	private JLabel lblBuscar;
	private JLabel lblAgregar;
	private JLabel lblCancelar;
	private JLabel lblGrabar;
	private JLabel label_1;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgServicios dialog = new DlgServicios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgServicios() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setTitle("MANTENIMIENTO | SERVICIO");
		setBounds(100, 100, 1152, 526);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblMensaje = new JLabel("");
		lblMensaje.setOpaque(true);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.BLACK);
		lblMensaje.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblMensaje.setBackground(Color.WHITE);
		lblMensaje.setBounds(26, 70, 361, 29);
		contentPanel.add(lblMensaje);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 98, 724, 415);
		contentPanel.add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblServicios = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}

		};
		jtblServicios.addMouseListener(this);
		jtblServicios.setForeground(Color.BLACK);
		jtblServicios.setFont(new Font("Arial", Font.BOLD, 14));
		jtblServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtblServicios.setRowHeight(25);
		scrollPane.setViewportView(jtblServicios);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel.setBackground(Color.WHITE);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point ubicacion = MouseInfo.getPointerInfo().getLocation();
			    setLocation(ubicacion.x - x, ubicacion.y - y);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
			    y = e.getY();
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBounds(0, 0, 1152, 39);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Icon m = new ImageIcon(getClass().getResource("/image/ADVERTENCIA.png"));
		  		int dialog = JOptionPane.YES_NO_OPTION;
		 		int result1 =JOptionPane.showConfirmDialog(null, "¿Desea Volver a la Ventana Principal?","Abvertencia",dialog,dialog,m);
		 	
		  		
		  		if(result1 ==0){
		  			dispose();
		 			Principal frame = new Principal();
		 			frame.setVisible(true);
		  		}
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(DlgServicios.class.getResource("/image/icons8_Return_32px.png")));
		label.setBounds(1110, 0, 32, 39);
		panel.add(label);
		
		lblServicios = new JLabel("Servicios");
		lblServicios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblServicios.setFont(new Font("Decker", Font.PLAIN, 16));
		lblServicios.setBounds(38, 0, 130, 39);
		panel.add(lblServicios);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DlgServicios.class.getResource("/image/salesman.png")));
		label_1.setBounds(10, 0, 25, 39);
		panel.add(label_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(10, 50, 391, 463);
		contentPanel.add(panel_1);
		panel_1.setVisible(false);
				panel_1.setLayout(null);
		
				txtPrecio = new JTextField();
				txtPrecio.setBounds(124, 242, 94, 20);
				panel_1.add(txtPrecio);
				txtPrecio.setEditable(false);
				txtPrecio.addKeyListener(this);
				txtPrecio.setForeground(Color.BLACK);
				txtPrecio.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
				txtPrecio.setColumns(10);
				txtPrecio.setBorder(null);
				txtPrecio.setOpaque(false);
				
						lblPrecio = new JLabel("PRECIO");
						lblPrecio.setBounds(-5, 248, 88, 14);
						panel_1.add(lblPrecio);
						lblPrecio.setForeground(Color.BLACK);
						lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
						lblPrecio.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
						
								cboTipo = new JComboBox<String>();
								cboTipo.setBounds(100, 190, 252, 29);
								panel_1.add(cboTipo);
								cboTipo.setForeground(Color.BLACK);
								cboTipo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
								
										lblTipo = new JLabel("TIPO");
										lblTipo.setInheritsPopupMenu(false);
										lblTipo.setBounds(-5, 197, 68, 14);
										panel_1.add(lblTipo);
										lblTipo.setForeground(Color.BLACK);
										lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
										lblTipo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
										
												txtDescripcion = new JTextField();
												txtDescripcion.setBounds(124, 143, 252, 19);
												panel_1.add(txtDescripcion);
												txtDescripcion.setEditable(false);
												txtDescripcion.addKeyListener(this);
												txtDescripcion.setForeground(Color.BLACK);
												txtDescripcion.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
												txtDescripcion.setColumns(10);
												txtDescripcion.setBorder(null);
												txtDescripcion.setOpaque(false);
												
														lblDescripcion = new JLabel("DESCRIP");
														lblDescripcion.setInheritsPopupMenu(false);
														lblDescripcion.setBounds(10, 151, 81, 14);
														panel_1.add(lblDescripcion);
														lblDescripcion.setForeground(Color.BLACK);
														lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
														lblDescripcion.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
														
																lblCodigo = new JLabel("C\u00D3DIGO");
																lblCodigo.setBounds(17, 98, 68, 14);
																panel_1.add(lblCodigo);
																lblCodigo.setForeground(Color.BLACK);
																lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
																lblCodigo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
																
																		txtCodigo = new JTextField();
																		txtCodigo.setBounds(119, 85, 99, 29);
																		panel_1.add(txtCodigo);
																		txtCodigo.setEditable(false);
																		txtCodigo.addKeyListener(this);
																		txtCodigo.setForeground(Color.BLACK);
																		txtCodigo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
																		txtCodigo.setColumns(10);
																		txtCodigo.setBorder(null);
																		txtCodigo.setOpaque(false);
																				
																				lbliconCodigo = new JLabel("");
																				lbliconCodigo.setBounds(96, 92, 24, 22);
																				lbliconCodigo.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/codigo.png")));
																				panel_1.add(lbliconCodigo);
																				
																				sCodigo = new JSeparator();
																				sCodigo.setBounds(102, 115, 121, 2);
																				panel_1.add(sCodigo);
																				
																				lbliconDescripcion = new JLabel("");
																				lbliconDescripcion.setBounds(96, 141, 24, 22);
																				lbliconDescripcion.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/description.png")));
																				panel_1.add(lbliconDescripcion);
																				
																				sDescripcion = new JSeparator();
																				sDescripcion.setBounds(97, 163, 284, 2);
																				panel_1.add(sDescripcion);
																				
																				lbliconPrecio = new JLabel("");
																				lbliconPrecio.setBounds(93, 230, 24, 33);
																				lbliconPrecio.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/price-tag.png")));
																				panel_1.add(lbliconPrecio);
																				
																				sPrecio = new JSeparator();
																				sPrecio.setBounds(93, 262, 130, 2);
																				panel_1.add(sPrecio);
																				
																				lblBuscar = new JLabel("Buscar");
																				lblBuscar.setBounds(228, 80, 136, 39);
																				lblBuscar.addMouseListener(this);
																				lblBuscar.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/buscar.png")));
																				lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
																				lblBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				lblBuscar.setForeground(Color.BLACK);
																				lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
																				lblBuscar.setBackground(Color.BLUE);
																				panel_1.add(lblBuscar);
																				
																				lblAgregar = new JLabel("Agregar");
																				lblAgregar.setBounds(98, 275, 195, 39);
																				lblAgregar.addMouseListener(this);
																				lblAgregar.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/Agregar.png")));
																				lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
																				lblAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				lblAgregar.setForeground(Color.BLACK);
																				lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
																				lblAgregar.setBackground(new Color(1, 168, 25));
																				panel_1.add(lblAgregar);
																				
																				lblCancelar = new JLabel("Cancelar");
																				lblCancelar.setBounds(98, 325, 195, 39);
																				lblCancelar.addMouseListener(this);
																				lblCancelar.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/regreso.png")));
																				lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
																				lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				lblCancelar.setForeground(Color.BLACK);
																				lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
																				panel_1.add(lblCancelar);
																				
																				lblGrabar = new JLabel("Grabar");
																				lblGrabar.setBounds(98, 375, 195, 41);
																				lblGrabar.addMouseListener(this);
																				lblGrabar.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/save.png")));
																				lblGrabar.setOpaque(true);
																				lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
																				lblGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				lblGrabar.setForeground(Color.WHITE);
																				lblGrabar.setFont(new Font("Dialog", Font.PLAIN, 18));
																				lblGrabar.setBackground(new Color(231, 96, 90));
																				panel_1.add(lblGrabar);
																				
																				lblIngresar = new JLabel("INGRESAR");
																				lblIngresar.addMouseListener(this);
																				lblIngresar.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/ingresarNegro.png")));
																				lblIngresar.setInheritsPopupMenu(false);
																				lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
																				lblIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				lblIngresar.setForeground(Color.BLACK);
																				lblIngresar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																				lblIngresar.setBorder(new LineBorder(Color.BLACK, 1, true));
																				lblIngresar.setBackground(new Color(1, 168, 25));
																				lblIngresar.setBounds(411, 50, 158, 37);
																				contentPanel.add(lblIngresar);
																				
																				lblConsultar = new JLabel("CONSULTAR");
																				lblConsultar.addMouseListener(this);
																				lblConsultar.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/consultarNegro.png")));
																				lblConsultar.setInheritsPopupMenu(false);
																				lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
																				lblConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				lblConsultar.setForeground(Color.BLACK);
																				lblConsultar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																				lblConsultar.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
																				lblConsultar.setBackground(new Color(1, 168, 25));
																				lblConsultar.setBounds(579, 50, 169, 37);
																				contentPanel.add(lblConsultar);
																				
																				lblModificar = new JLabel("MODIFICAR");
																				lblModificar.addMouseListener(this);
																				lblModificar.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/modificarNegro.png")));
																				lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
																				lblModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				lblModificar.setForeground(Color.BLACK);
																				lblModificar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																				lblModificar.setBorder(new LineBorder(Color.BLACK, 1, true));
																				lblModificar.setBackground(Color.WHITE);
																				lblModificar.setBounds(758, 50, 175, 36);
																				contentPanel.add(lblModificar);
																				
																				lblEliminar = new JLabel("ELIMINAR");
																				lblEliminar.addMouseListener(this);
																				lblEliminar.setIcon(new ImageIcon(DlgServicios.class.getResource("/iconBotones/eliminarNegro.png")));
																				lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
																				lblEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				lblEliminar.setForeground(Color.BLACK);
																				lblEliminar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
																				lblEliminar.setBorder(new LineBorder(Color.BLACK, 1, true));
																				lblEliminar.setBounds(952, 50, 183, 36);
																				contentPanel.add(lblEliminar);
								cboTipo.addItem("ANÁLISIS CLÍNICOS");
								cboTipo.addItem("INTERVENCIONES QUIRÚRJICAS");

		listado();
		modeloTabla();

		this.setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtPrecio) {
			keyTypedTxtPrecio(arg0);
		}
		if (arg0.getSource() == txtDescripcion) {
			keyTypedTxtDescripcion(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigo(arg0);
		}
	}

	protected void keyTypedTxtCodigo(KeyEvent e) {
		Validaciones.soloNumero(e, txtCodigo, 8);

		char t = e.getKeyChar();
		if (t == KeyEvent.VK_ENTER)
			consultarServicio();
	}

	protected void keyTypedTxtDescripcion(KeyEvent e) {
		Validaciones.cadenaTexto(e, txtDescripcion, 20);
	}

	protected void keyTypedTxtPrecio(KeyEvent e) {
		Validaciones.numeroReal(txtPrecio, e, 5);
	}
//***Evento Clicked***//
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblGrabar) {
			mouseClickedLblGrabar(arg0);
		}
		if (arg0.getSource() == jtblServicios) {
			mouseClickedJtblServicios(arg0);
		}
		if (arg0.getSource() == lblIngresar) {
			mouseClickedLblIngresar(arg0);
		}
		if (arg0.getSource() == lblConsultar) {
			mouseClickedLblConsultar(arg0);
		}
		if (arg0.getSource() == lblModificar) {
			mouseClickedLblModificar(arg0);
		}
		if (arg0.getSource() == lblEliminar) {
			mouseClickedLblEliminar(arg0);
		}
		if (arg0.getSource() == lblBuscar) {
			mouseClickedLblBuscar(arg0);
		}
		if (arg0.getSource() == lblAgregar) {
			mouseClickedLblAgregar(arg0);
		}
		if (arg0.getSource() == lblCancelar) {
			mouseClickedLblCancelar(arg0);
		}
		
		
		
		}
	
	//***Evento Exited***///
	public void mouseExited(MouseEvent e) {
			
		if (e.getSource() == lblConsultar) {
			mouseExitedLblConsultar(e);
		}
		if (e.getSource() == lblIngresar) {
			mouseExitedLblIngresar(e);
		}
		if (e.getSource() == lblModificar) {
			mouseExitedLblModificar(e);
		}
		if (e.getSource() == lblEliminar) {
			mouseExitedLblEliminar(e);
		}
		if (e.getSource() == lblBuscar) {
			mouseExitedLblBuscar(e);
		}
		if (e.getSource() == lblAgregar) {
			mouseExitedLblAgregar(e);
		}
		if (e.getSource() == lblCancelar) {
			mouseExitedLblCancelar(e);
		}
		
		}
	
	
	
	
////******////
	
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == lblCancelar) {
			mouseEnteredLblCancelar(arg0);
		}
		if (arg0.getSource() == lblAgregar) {
			mouseEnteredLblAgregar(arg0);
		}
		if (arg0.getSource() == lblBuscar) {
			mouseEnteredLblBuscar(arg0);
		}
		if (arg0.getSource() == lblEliminar) {
			mouseEnteredLblEliminar(arg0);
		}
		if (arg0.getSource() == lblModificar) {
			mouseEnteredLblModificar(arg0);
		}
		if (arg0.getSource() == lblConsultar) {
			mouseEnteredLblConsultar(arg0);
		}
		if (arg0.getSource() == lblIngresar) {
			mouseEnteredLblIngresar(arg0);
		}
	}
//***Mouse Exited**//
	
	public void mouseExitedLblIngresar(MouseEvent e) {
		lblIngresar.setOpaque(false);
		lblIngresar.setForeground(new Color(10, 20, 26));
		lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/ingresarNegro.png")));
	}

	public void mouseExitedLblConsultar(MouseEvent e) {
			lblConsultar.setOpaque(false);
			lblConsultar.setForeground(new Color(10, 20, 26));
			lblConsultar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/consultarNegro.png")));
	}
	public void mouseExitedLblModificar(MouseEvent e) {
		lblModificar.setOpaque(false);
		lblModificar.setForeground(new Color(10, 20, 26));
		lblModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/modificarNegro.png")));
	}
	
	public void mouseExitedLblEliminar(MouseEvent e) {
		lblEliminar.setOpaque(false);
		lblEliminar.setForeground(new Color(10, 20, 26));
		lblEliminar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/eliminarNegro.png")));
	}
	public void mouseExitedLblBuscar(MouseEvent e) {
		lblBuscar.setOpaque(false);
		lblBuscar.setForeground(new Color(10, 20, 26));
		lblBuscar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/buscar.png")));
	}
	public void mouseExitedLblAgregar(MouseEvent e) {
		lblAgregar.setOpaque(false);
		lblAgregar.setForeground(new Color(10, 20, 26));
		lblAgregar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/Agregar.png")));
	}
	public void mouseExitedLblCancelar(MouseEvent e) {
		lblCancelar.setOpaque(false);
		lblCancelar.setForeground(new Color(10, 20, 26));
		lblCancelar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regreso.png")));
	}
	
	
	
/////////
	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	protected void mouseClickedJtblServicios(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (e.getClickCount() == 2) {
				int row = jtblServicios.rowAtPoint(new Point(e.getX(), e.getY()));

				if (row >= 0) {
					codServicio = jtblServicios.getValueAt(row, 0).toString();
					precioServicio = Double.parseDouble(jtblServicios.getValueAt(row, 3).toString());
					nomServicio = jtblServicios.getValueAt(row, 1).toString();
					dispose();
				}
			}
		}
	}
//***///
	void habilitarBotones(boolean sino){
		lblConsultar.setVisible(sino);
		lblModificar.setVisible(sino);
		lblEliminar.setVisible(sino);
		lblIngresar.setVisible(sino);
	}
	
	//*****///
	void visibleDescripcion(boolean sino){
		lblDescripcion.setVisible(sino);
		txtDescripcion.setVisible(sino);
		sDescripcion.setVisible(sino);
		lbliconDescripcion.setVisible(sino);
	}
	void visiblePrecio(boolean sino){
		lblPrecio.setVisible(sino);
		txtPrecio.setVisible(sino);
		sPrecio.setVisible(sino);
		lbliconPrecio.setVisible(sino);
	}
	void visibleTipo(boolean sino){
		lblTipo.setVisible(sino);
		cboTipo.setVisible(sino);
		
	}
	
	
	
	// Métodos tipo void sin parámetros
	void limpieza() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		cboTipo.setSelectedIndex(0);
	}

	String[] getColumnas() {
		String columnas[] = new String[] { "CÓDIGO", "DESCRIPCIÓN", "TIPO", "PRECIO" };
		return columnas;
	}

	void modeloTabla() {
		TableColumnModel tc = jtblServicios.getColumnModel();
		tc.getColumn(0).setPreferredWidth(50);
		tc.getColumn(1).setPreferredWidth(300);
		tc.getColumn(2).setPreferredWidth(200);
		tc.getColumn(3).setPreferredWidth(40);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
		tc.getColumn(2).setCellRenderer(tcr);

		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tc.getColumn(3).setCellRenderer(tcr);
	}

	void listado() {
		Libreria.limpiarJTable(jtblServicios, dtm);
		if (as.tamaño() == 0) {

		}
		else {
			for (int i = 0; i < as.tamaño(); i++) {
				Servicio x = as.obtener(i);
				dtm.addRow(new Object[] { x.getCodServicio(), x.getDescripcion(), getTipoServicio(x.getTipo()),
						x.getPrecio() });
			}
		}
	}

	void adicionarEmpleado() {
		if (leerDescripcion().equals("")) {
			Libreria.mensajeAdvertencia(this, "No ingresó la DESCRIPCIÓN");
			txtDescripcion.requestFocus();
		}
		else if (leerPrecio() < 0) {
			Libreria.mensajeAdvertencia(this, "No ingresó el PRECIO");
			txtPrecio.setText("");
			txtPrecio.requestFocus();
		}
		else {
			Servicio nuevo = new Servicio(leerCodigo(), leerDescripcion(), leerTipo(), leerPrecio());
			as.adicionar(nuevo);
			listado();
			habilitarEntradas(false);
			habilitarOperaciones(true);
		}
	}

	void consultarServicio() {

		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del SERVICIO");
			txtCodigo.requestFocus();
		}
		else {
			Servicio x = as.buscar(leerCodigo());
			if (x != null) {
				if ((tipoOperacion != CONSULTAR)&&(tipoOperacion != ADICIONAR)){
					lblAgregar.setVisible(true);
					lblGrabar.setVisible(true);
					
				}
				visibleDescripcion(true);
				visibleTipo(true);
				visiblePrecio(true);
								
			
				txtDescripcion.setText(x.getDescripcion());
				cboTipo.setSelectedIndex(x.getTipo());
				txtPrecio.setText("" + x.getPrecio());
			}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				limpieza();
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	void modificarServicio() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del Empleado");
			txtCodigo.requestFocus();
		}
		else {
			Servicio x = as.buscar(leerCodigo());
			if (x != null)
				if (leerDescripcion().equals("")) {
					Libreria.mensajeAdvertencia(this, "No ingresó la DESCRIPCIÓN");
					txtDescripcion.requestFocus();
				}
				else if (leerPrecio() < 0) {
					Libreria.mensajeAdvertencia(this, "No ingresó el PRECIO");
					txtPrecio.setText("");
					txtPrecio.requestFocus();
				}
				else {
					x.setCodServicio(leerCodigo());
					x.setDescripcion(leerDescripcion());
					x.setPrecio(leerPrecio());
					x.setTipo(leerTipo());
					listado();
					habilitarBusqueda(false);
					habilitarEntradas(false);
					habilitarOperaciones(true);
				}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	void eliminarEmpleado() {
		int codigo = leerCodigo();

		if (codigo == -1) {
			Libreria.mensajeAdvertencia(this, "No ha ingresado el CÓDIGO del SERVICIO");
			txtCodigo.requestFocus();
		}
		else {
			Servicio x = as.buscar(leerCodigo());
			if (x != null) {
				as.eliminar(x);
				listado();
				limpieza();
				habilitarBusqueda(false);
				habilitarOperaciones(true);
			}
			else {
				Libreria.mensajeAdvertencia(this, "El código " + leerCodigo() + " no existe");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
	}

	// Métodos tipo void con parámetros
	void habilitarBusqueda(boolean sino) {
		lblBuscar.setEnabled(sino);
		txtCodigo.setEditable(sino);
		if (sino)
			txtCodigo.requestFocus();
	}

	void habilitarEntradas(boolean sino) {
		if (!sino)
			limpieza();
		txtDescripcion.setEditable(sino);
		txtPrecio.setEditable(sino);
		txtCodigo.setEditable(sino);
	}

	void habilitarOperaciones(boolean sino) {
		lblIngresar.setEnabled(sino);
		lblConsultar.setEnabled(sino);
		lblModificar.setEnabled(sino);
		lblEliminar.setEnabled(sino);
		lblAgregar.setEnabled(!sino);
		lblCancelar.setEnabled(!sino);
	}

	// Métodos que retornan valor sin parámetros
	int leerCodigo() {
		return Libreria.leerEntero(txtCodigo);
	}

	String leerDescripcion() {
		return Libreria.leerCadena(txtDescripcion);
	}

	double leerPrecio() {
		return Libreria.leerReal(txtPrecio);
	}

	int leerTipo() {
		return cboTipo.getSelectedIndex();
	}

	// Métodos que retornan valor con parámetros
	String getTipoServicio(int tipo) {
		if (tipo == 0) {
			return "ANÁLISIS CLÍNICOS";
		}
		else {
			return "INTERVENCIONES QUIRÚRJICAS";
		}
	}
	
	///****Mouse Entered****///
	
	protected void mouseEnteredLblIngresar(MouseEvent arg0) {
		lblIngresar.setOpaque(true);
		lblIngresar.setBackground(new Color(30, 60, 79));
		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/ingresarBlnco.png")));
	}
	protected void mouseEnteredLblConsultar(MouseEvent arg0) {
		lblConsultar.setOpaque(true);
		lblConsultar.setBackground(new Color(30, 60, 79));
		lblConsultar.setForeground(new Color(255, 255, 255));
		lblConsultar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/consultarBlnaco.png")));
	}
	protected void mouseEnteredLblModificar(MouseEvent arg0) {
		lblModificar.setOpaque(true);
		lblModificar.setBackground(new Color(30, 60, 79));
		lblModificar.setForeground(new Color(255, 255, 255));
		lblModificar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/modificarBlanco.png")));
	}
	protected void mouseEnteredLblEliminar(MouseEvent arg0) {
		lblEliminar.setOpaque(true);
		lblEliminar.setBackground(new Color(30, 60, 79));
		lblEliminar.setForeground(new Color(255, 255, 255));
		lblEliminar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/eliminarBlnco.png")));
	}
	protected void mouseEnteredLblBuscar(MouseEvent arg0) {
		lblBuscar.setOpaque(true);
		lblBuscar.setBackground(new Color(30, 60, 79));
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/buscarBlnco.png")));
	}
	protected void mouseEnteredLblAgregar(MouseEvent arg0) {
		lblAgregar.setOpaque(true);
		lblAgregar.setBackground(new Color(30, 60, 79));
		lblAgregar.setForeground(new Color(255, 255, 255));
		lblAgregar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/AgregarBlanco.png")));
	}
	protected void mouseEnteredLblCancelar(MouseEvent arg0) {
		lblCancelar.setOpaque(true);
		lblCancelar.setBackground(new Color(30, 60, 79));
		lblCancelar.setForeground(new Color(255, 255, 255));
		lblCancelar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/regresoNegro.png")));
	}


//Mouse Clicked//
protected void mouseClickedLblIngresar(MouseEvent arg0) {
	tipoOperacion = ADICIONAR;
	lblMensaje.setText("Adicionando Servicio");
	txtCodigo.setText("" + as.codigoCorrelativo());
	habilitarEntradas(true);
	habilitarOperaciones(false);
	txtCodigo.setEditable(false);
	txtDescripcion.requestFocus();
	panel_1.setVisible(true);
	lblBuscar.setVisible(false);
	habilitarBotones(false);
	visiblePrecio(true);
	visibleDescripcion(true);
	visibleTipo(true);	
	lblBuscar.setVisible(false);
	lblCancelar.setVisible(true);
	lblAgregar.setText("Ingresar");
	lblGrabar.setVisible(true);
	lblAgregar.setVisible(true);
	
}

protected void mouseClickedLblConsultar(MouseEvent arg0) {
	tipoOperacion = CONSULTAR;
	lblMensaje.setText("Consultando Servicio");
	habilitarBusqueda(true);
	habilitarOperaciones(false);
	panel_1.setVisible(true);
	habilitarBotones(false);
	visiblePrecio(false);
	visibleDescripcion(false);
	visibleTipo(false);	
	lblBuscar.setVisible(true);
	lblAgregar.setVisible(false);
	lblGrabar.setVisible(false);
}

protected void mouseClickedLblModificar(MouseEvent arg0) {
	tipoOperacion = MODIFICAR;
	lblMensaje.setText("Modificando Servicio");
	habilitarBusqueda(true);
	habilitarEntradas(true);
	habilitarOperaciones(false);
	panel_1.setVisible(true);
	habilitarBotones(false);
	visiblePrecio(false);
	visibleDescripcion(false);
	visibleTipo(false);
	lblBuscar.setVisible(true);
	lblAgregar.setText("Modificar");
}

protected void mouseClickedLblEliminar(MouseEvent arg0) {
	tipoOperacion = ELIMINAR;
	lblMensaje.setText("Eliminando Servicio");
	habilitarBusqueda(true);
	habilitarOperaciones(false);
	panel_1.setVisible(true);
	habilitarBotones(false);
	visiblePrecio(false);
	visibleDescripcion(false);
	visibleTipo(false);
	lblBuscar.setVisible(true);
	lblAgregar.setText("Eliminar");
	}

protected void mouseClickedLblBuscar(MouseEvent arg0) {
	consultarServicio();
}
protected void mouseClickedLblAgregar(MouseEvent arg0) {
	switch (tipoOperacion) {
	case ADICIONAR:
		adicionarEmpleado();
		txtCodigo.setText("" + as.codigoCorrelativo());
		habilitarEntradas(true);
		//lblMensaje.setText("");
		lblAgregar.setEnabled(true);
		lblCancelar.setEnabled(true);
		lblGrabar.setEnabled(true);
		break;
	case CONSULTAR:
		limpieza();
		habilitarBusqueda(false);
		habilitarOperaciones(true);
		lblMensaje.setText("");
		lblBuscar.setEnabled(true);
		break;
	case MODIFICAR:
		 modificarServicio();
		 habilitarEntradas(true);
		//lblMensaje.setText("");
		 lblAgregar.setEnabled(true);
		 lblCancelar.setEnabled(true);
		 lblGrabar.setEnabled(true);
		 lblBuscar.setEnabled(true);
		 visibleTipo(false);
		 visibleDescripcion(false);
		 visiblePrecio(false);
		break;
	case ELIMINAR:
		eliminarEmpleado();
		//lblMensaje.setText("");
		lblBuscar.setEnabled(true);
		lblAgregar.setEnabled(true);
		lblCancelar.setEnabled(true);
		lblGrabar.setEnabled(true);
		visibleTipo(false);
		visibleDescripcion(false);
		visiblePrecio(false);
		
	}
}
protected void mouseClickedLblCancelar(MouseEvent arg0) {
	panel_1.setVisible(false);
	if (tipoOperacion != ADICIONAR)
		habilitarBusqueda(false);
	lblMensaje.setText("");
	habilitarEntradas(false);
	habilitarOperaciones(true);
	habilitarBotones(true);
}

	protected void mouseClickedLblGrabar(MouseEvent arg0) {
		if (as.existeArchivo()) {
			int ok = Libreria.confirmacion(this, "¿ Desea actualizar \"" + as.getArchivo() + "\" ?");
			if (ok == 0) {
				as.grabarServicios();
				Libreria.mensajeInformacion(this, "\"" + as.getArchivo() + "\" ha sido actualizado");
			}
			else
				Libreria.mensajeInformacion(this, "No se actualizó  \"" + as.getArchivo() + "\"");
		}
		else {
			as.grabarServicios();
			Libreria.mensajeInformacion(this, "\"" + as.getArchivo() + "\" ha sido creado");
		}		
	}
}
