package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloConsumo;
import arreglos.ArregloDetalleConsumo;
import arreglos.ArregloMedicamento;
import clases.Atencion;
import clases.DetalleAtencion;
import clases.Medicamentos;
import libreria.Dise�oObjetos;
import libreria.Fecha;
import libreria.Libreria; 

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import javax.swing.JSeparator;

public class DlgRegistroConsumo extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoConsumo;
	private JTextField txtCodigoConsumo;
	private JScrollPane scrollPane;
	private JTextField txtTotal;
	private JLabel lblTotal;
	private JComboBox<String> cboDia;
	private JComboBox<String> cboMes;
	private JComboBox<String> cboAno;
	private JLabel lblFecha;
	private JTextField txtCodigoPaciente;
	private JLabel lblCodigoPaciente;
	private JTable jtblConsumo;
	private JPanel panel;
	private int x;
	private int y;

	// Declaraci�n global para modelo de tabla
	private DefaultTableModel dtm;

	// Declaraci�n global para arreglos
	ArregloConsumo ac = new ArregloConsumo("consumos.txt");
	ArregloDetalleConsumo adet = new ArregloDetalleConsumo("detallesconsumos.txt");
	ArregloMedicamento am = new ArregloMedicamento("medicamentos.txt");

	// Declaraci�n global para libreria
	Fecha f = new Fecha();
	Dise�oObjetos ds = new Dise�oObjetos();

	// Declaraci�n variable global para la suma total de la venta
	private double total = 0.0;
	private JPanel panel_1;
	private JLabel label;
	private JLabel lblRegitro;
	private JLabel lblEliminarProductoDe;
	private JLabel lblRegistrar;
	private JLabel lblSeleccionarMedicamento;
	private JLabel lblSeleccionarServicio;
	private JLabel lblnext;
	private JLabel label_1;
	private JLabel label_2;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgRegistroConsumo dialog = new DlgRegistroConsumo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgRegistroConsumo() {
		setUndecorated(true);
		setModal(true);
		setResizable(false);
		setTitle("Registro de Consumo");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 753, 598);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane.setBounds(10, 312, 728, 224);
		getContentPane().add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblConsumo = new JTable(dtm) {
			public static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};
		jtblConsumo.setBorder(null);
		jtblConsumo.setFont(new Font("Arial", Font.BOLD, 14));
		jtblConsumo.setForeground(Color.BLACK);
		jtblConsumo.setRowHeight(25);
		scrollPane.setViewportView(jtblConsumo);

		txtTotal = new JTextField();
		txtTotal.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		txtTotal.setText("S/.00.00");
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setEditable(false);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setForeground(Color.RED);
		txtTotal.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 18));
		txtTotal.setColumns(10);
		txtTotal.setBounds(619, 547, 119, 39);
		getContentPane().add(txtTotal);

		lblTotal = new JLabel("TOTAL :");
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		lblTotal.setBounds(527, 560, 82, 14);
		getContentPane().add(lblTotal);

		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 50, 728, 251);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblCodigoConsumo = new JLabel("CODIGO CONSUMO :");
		lblCodigoConsumo.setBounds(10, 11, 153, 21);
		panel.add(lblCodigoConsumo);
		lblCodigoConsumo.setForeground(Color.BLACK);
		lblCodigoConsumo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoConsumo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));

		lblCodigoPaciente = new JLabel("CODIGO PACIENTE :");
		lblCodigoPaciente.setBounds(10, 87, 153, 19);
		panel.add(lblCodigoPaciente);
		lblCodigoPaciente.setForeground(Color.BLACK);
		lblCodigoPaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoPaciente.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));

		txtCodigoConsumo = new JTextField();
		txtCodigoConsumo.setBorder(null);
		txtCodigoConsumo.setBounds(99, 51, 119, 21);
		panel.add(txtCodigoConsumo);
		txtCodigoConsumo.setBackground(Color.WHITE);
		txtCodigoConsumo.setForeground(Color.BLACK);
		txtCodigoConsumo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigoConsumo.setEditable(false);
		txtCodigoConsumo.setColumns(10);

		txtCodigoPaciente = new JTextField();
		txtCodigoPaciente.setBounds(99, 127, 119, 29);
		panel.add(txtCodigoPaciente);
		txtCodigoPaciente.setBackground(Color.WHITE);
		txtCodigoPaciente.setForeground(Color.BLACK);
		txtCodigoPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigoPaciente.setEditable(false);
		txtCodigoPaciente.setColumns(10);

		cboAno = new JComboBox<String>();
		cboAno.setBounds(591, 30, 85, 29);
		panel.add(cboAno);
		cboAno.setForeground(Color.BLACK);
		cboAno.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboAno.setEnabled(false);
		Fecha.colocarItems(cboAno, Fecha.a�oActual(), 2000);

		cboMes = new JComboBox<String>();
		cboMes.setBounds(474, 30, 107, 29);
		panel.add(cboMes);
		cboMes.setForeground(Color.BLACK);
		cboMes.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboMes.setEnabled(false);
		Fecha.colocarMeses(cboMes);
		Fecha.colocarMesActual(cboMes);

		cboDia = new JComboBox<String>();
		cboDia.setBounds(414, 30, 50, 29);
		panel.add(cboDia);
		cboDia.setForeground(Color.BLACK);
		cboDia.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboDia.setEnabled(false);
		Fecha.colocarItems(cboDia, 1, 31);
		Fecha.colocarDiaActual(cboDia);

		lblFecha = new JLabel("FECHA :");
		lblFecha.setBounds(342, 11, 84, 14);
		panel.add(lblFecha);
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		
		lblSeleccionarMedicamento = new JLabel("SELECCIONAR MEDICAMENTO");
		lblSeleccionarMedicamento.addMouseListener(this);
		lblSeleccionarMedicamento.setIcon(new ImageIcon(DlgRegistroConsumo.class.getResource("/iconBotones/medicamento.png")));
		lblSeleccionarMedicamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarMedicamento.setForeground(new Color(10, 20, 26));
		lblSeleccionarMedicamento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSeleccionarMedicamento.setBorder(new LineBorder(new Color(10,20,26), 1, true));
		lblSeleccionarMedicamento.setBackground(new Color(1, 168, 25));
		lblSeleccionarMedicamento.setBounds(10, 194, 296, 36);
		panel.add(lblSeleccionarMedicamento);
		
		lblSeleccionarServicio = new JLabel("SELECCIONAR SERVICIO");
		lblSeleccionarServicio.addMouseListener(this);
		lblSeleccionarServicio.setIcon(new ImageIcon(DlgRegistroConsumo.class.getResource("/iconBotones/atencion_servicios.png")));
		lblSeleccionarServicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarServicio.setForeground(new Color(10, 20, 26));
		lblSeleccionarServicio.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSeleccionarServicio.setBorder(new LineBorder(new Color(10,20,26), 1, true));
		lblSeleccionarServicio.setBounds(316, 194, 258, 36);
		panel.add(lblSeleccionarServicio);
		
		lblnext = new JLabel("...");
		lblnext.addMouseListener(this);
		lblnext.setIcon(new ImageIcon(DlgRegistroConsumo.class.getResource("/iconBotones/siguienteNEgro.png")));
		lblnext.setHorizontalAlignment(SwingConstants.CENTER);
		lblnext.setForeground(new Color(10, 20, 26));
		lblnext.setFont(new Font("Dialog", Font.BOLD, 16));
		lblnext.setBorder(null);
		lblnext.setBackground(new Color(1, 168, 25));
		lblnext.setBounds(228, 127, 59, 29);
		panel.add(lblnext);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(65, 74, 119, 2);
		panel.add(separator);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(DlgRegistroConsumo.class.getResource("/iconBotones/codigo.png")));
		label_2.setBounds(61, 43, 28, 27);
		panel.add(label_2);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point ubicacion = MouseInfo.getPointerInfo().getLocation();
			    setLocation(ubicacion.x - x, ubicacion.y - y);
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
			    y = e.getY();
			}
		});
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setBounds(0, 0, 754, 39);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Icon m = new ImageIcon(getClass().getResource("/image/ADVERTENCIA.png"));
		  		int dialog = JOptionPane.YES_NO_OPTION;
		 		int result1 =JOptionPane.showConfirmDialog(null, "�Desea Volver a la Ventana Principal?","Abvertencia",dialog,dialog,m);
		 	
		  		
		  		if(result1 ==0){
		  			dispose();
		 			Principal frame = new Principal();
		 			frame.setVisible(true);
		  		}
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(DlgRegistroConsumo.class.getResource("/image/icons8_Return_32px.png")));
		label.setBounds(714, 0, 40, 39);
		panel_1.add(label);
		
		lblRegitro = new JLabel("Registro Consumo");
		lblRegitro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegitro.setFont(new Font("Decker", Font.PLAIN, 16));
		lblRegitro.setBounds(42, 0, 145, 39);
		panel_1.add(lblRegitro);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DlgRegistroConsumo.class.getResource("/image/registration.png")));
		label_1.setBounds(10, 0, 25, 39);
		panel_1.add(label_1);
		
		lblEliminarProductoDe = new JLabel("ELIMINAR PRODUCTO DE LISTA");
		lblEliminarProductoDe.addMouseListener(this);
		lblEliminarProductoDe.setIcon(new ImageIcon(DlgRegistroConsumo.class.getResource("/iconBotones/eliminarNegro.png")));
		lblEliminarProductoDe.setInheritsPopupMenu(false);
		lblEliminarProductoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarProductoDe.setForeground(new Color(10, 20, 26));
		lblEliminarProductoDe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEliminarProductoDe.setBorder(new LineBorder(new Color(10,20,26), 1, true));
		lblEliminarProductoDe.setBackground(new Color(1, 168, 25));
		lblEliminarProductoDe.setBounds(20, 547, 300, 37);
		getContentPane().add(lblEliminarProductoDe);
		
		lblRegistrar = new JLabel("REGISTRAR");
		lblRegistrar.addMouseListener(this);
		lblRegistrar.setIcon(new ImageIcon(DlgRegistroConsumo.class.getResource("/iconBotones/Agregar.png")));
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setForeground(new Color(10, 20, 26));
		lblRegistrar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRegistrar.setBorder(new LineBorder(new Color(10,20,26), 1, true));
		lblRegistrar.setBackground(new Color(1, 168, 25));
		lblRegistrar.setBounds(343, 547, 169, 36);
		getContentPane().add(lblRegistrar);

		setCodigoConsumo();
		modeloTabla();

		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
	}

	// M�todos void sin par�metros
	void nuevoRegistroConsumo() {
		setCodigoConsumo();
		txtCodigoPaciente.setText("");
		Libreria.limpiarJTable(jtblConsumo, dtm);
		total = 0;
		txtTotal.setText("S/.00.00");
	}

	void setCodigoConsumo() {
		txtCodigoConsumo.setText("" + ac.codigoCorrelativo());
	}

	void modeloTabla() {
		TableColumnModel tc = jtblConsumo.getColumnModel();
		tc.getColumn(0).setPreferredWidth(100);
		tc.getColumn(1).setPreferredWidth(200);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tc.getColumn(4).setCellRenderer(tcr);
		tc.getColumn(2).setCellRenderer(tcr);
		tc.getColumn(3).setCellRenderer(tcr);

		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
	}

	void eliminarProductoDeLista() {
		int row = jtblConsumo.getSelectedRow();

		if (jtblConsumo.getRowCount() == 0) {
			Libreria.mensajeInformacion(this, "La lista est� vac�a.");
		}
		else if (row < 0) {
			Libreria.mensajeInformacion(this, "Seleccione el producto a eliminar.");
		}
		else {
			double precio, subtotal;
			int cantidad;
			cantidad = Integer.parseInt(jtblConsumo.getValueAt(row, 2).toString());
			precio = Double.parseDouble(jtblConsumo.getValueAt(row, 3).toString());
			subtotal = precio * cantidad;
			total -= subtotal;
			txtTotal.setText(Libreria.formatoSoles(total));
			dtm.removeRow(row);
		}
	}

	// M�todos que retornar valores
	String[] getColumnas() {
		String columnas[] = new String[] { "C�DIGO PRODUCTO", "NOMBRE PRODUCTO", "CANTIDAD", "PRECIO", "SUBTOTAL" };
		return columnas;
	}

	int leerCodConsumo() {
		return Libreria.leerEntero(txtCodigoConsumo);
	}

	int leerCodPaciente() {
		return Libreria.leerEntero(txtCodigoPaciente);
	}
	
	
	//*****************************************************************

	public void mouseReleased(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}

	//***********************************************************
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblnext) {
			 mouseClickedlblNext(e);
		}
		if (e.getSource() == lblSeleccionarServicio) {
			mouseClickedLblSeleccionarServicio(e);
		}
		if (e.getSource() == lblSeleccionarMedicamento) {
			mouseClickedLblSeleccionarMedicamento(e);
		}
		if (e.getSource() == lblRegistrar) {
			mouseClickedLblRegistrar(e);
		}
		if (e.getSource() == lblEliminarProductoDe) {
			mouseClickedLblEliminarProductoDe(e);
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblnext) {
			mouseEnteredLblNext(e);
		}
		if (e.getSource() == lblSeleccionarServicio) {
			mouseEnteredLblSeleccionarServicio(e);
		}
		if (e.getSource() == lblSeleccionarMedicamento) {
			mouseEnteredLblSeleccionarMedicamento(e);
		}
		if (e.getSource() == lblRegistrar) {
			mouseEnteredLblRegistrar(e);
		}
		if (e.getSource() == lblEliminarProductoDe) {
			mouseEnteredLblEliminarProductoDe(e);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblnext) {
			mouseExitedLblNext(e);
		}
		if (e.getSource() == lblSeleccionarServicio) {
			mouseExitedLblSeleccionarServicio(e);
		}
		if (e.getSource() == lblSeleccionarMedicamento) {
			mouseExitedLblSeleccionarMedicamento(e);
		}
		if (e.getSource() == lblRegistrar) {
			mouseExitedLblRegistrar(e);
		}
		if (e.getSource() == lblEliminarProductoDe) {
			mouseExitedLblEliminarProductoDe(e);
		}
	}

	//******************************************************
	//Boton Eliminar Producto de Lista
	
	protected void mouseEnteredLblEliminarProductoDe(MouseEvent e) {
		lblEliminarProductoDe.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/eliminarBlnco.png")));
		lblEliminarProductoDe.setOpaque(true);
		lblEliminarProductoDe.setBackground(new Color(10, 20, 26));
		lblEliminarProductoDe.setForeground(new Color(255,255,255));
	}
	
	protected void mouseExitedLblEliminarProductoDe(MouseEvent e) {
		lblEliminarProductoDe.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/eliminarNegro.png")));
		lblEliminarProductoDe.setOpaque(false);
		lblEliminarProductoDe.setForeground(new Color(10, 20, 26));
	}
	
	public void mouseClickedLblEliminarProductoDe(MouseEvent e) {
		eliminarProductoDeLista();
	}
	
	//*************************************************************
	//Boton Registar LABEL
	
	protected void mouseEnteredLblRegistrar(MouseEvent e) {
		lblRegistrar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/AgregarBlanco.png")));
		lblRegistrar.setOpaque(true);
		lblRegistrar.setBackground(new Color(10, 20, 26));
		lblRegistrar.setForeground(new Color(255,255,255));
	}
	
	protected void mouseExitedLblRegistrar(MouseEvent e) {
		lblRegistrar.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/Agregar.png")));
		lblRegistrar.setOpaque(false);
		lblRegistrar.setForeground(new Color(10, 20, 26));
	}
	
	protected void mouseClickedLblRegistrar(MouseEvent e) {
		if (leerCodConsumo() == -1) {
			Libreria.mensajeInformacion(this, "EL CAMPO C�DIGO DE CONSUMO NO PUEDE ESTAR VAC�O");
		}
		else if (leerCodPaciente() == -1) {
			Libreria.mensajeInformacion(this, "DEBE SELECCIONAR EL C�DIGO DEL PACIENTE");
		}
		else {
			if (jtblConsumo.getRowCount() != 0) {
				int msj = Libreria.confirmacion(this, "�Desea registrar el detalle de consumo?");

				if (msj == 0) {
					ac.adicionar(new Atencion(leerCodConsumo(), leerCodPaciente(), Fecha.getFecha(cboDia, cboMes, cboAno), 0,
							total));
					ac.grabarConsumo();

					int codProducto = 0, cantidad = 0;
					double precioUnitario = 0.0, subtotal = 0.0;

					for (int i = 0; i < jtblConsumo.getRowCount(); i++) {
						codProducto = Integer.parseInt(jtblConsumo.getValueAt(i, 0).toString());
						cantidad = Integer.parseInt(jtblConsumo.getValueAt(i, 2).toString());
						precioUnitario = Double.parseDouble(jtblConsumo.getValueAt(i, 3).toString());
						subtotal = cantidad * precioUnitario;
						adet.adicionar(
								new DetalleAtencion(leerCodConsumo(), codProducto, cantidad, precioUnitario, subtotal));
					}

					for (int i = 0; i < jtblConsumo.getRowCount(); i++) {
						Medicamentos med;
						for (int j = 0; j < am.tama�o(); j++) {
							med = am.obtener(j);
							if (med.getCodMedicamento() == Integer.parseInt(jtblConsumo.getValueAt(i, 0).toString())){
								med.restarStock(Integer.parseInt(jtblConsumo.getValueAt(i, 2).toString()));
							}
						}
					}
					am.grabarMedicamentos();
					adet.grabarDetalleConsumo();
					nuevoRegistroConsumo();
				}
			}
		}
	}
	
	//**********************************************************************************************
	//Boton Seleccionar Medicamento
	protected void mouseEnteredLblSeleccionarMedicamento(MouseEvent e) {
		lblSeleccionarMedicamento.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/medicamentoBlanco.png")));
		lblSeleccionarMedicamento.setOpaque(true);
		lblSeleccionarMedicamento.setBackground(new Color(10, 20, 26));
		lblSeleccionarMedicamento.setForeground(new Color(255,255,255));
	}
	
	protected void mouseExitedLblSeleccionarMedicamento(MouseEvent e) {
		lblSeleccionarMedicamento.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/medicamento.png")));
		lblSeleccionarMedicamento.setOpaque(false);
		lblSeleccionarMedicamento.setForeground(new Color(10, 20, 26));
	}
	
	protected void mouseClickedLblSeleccionarMedicamento(MouseEvent e) {
		DlgMedicamento med = new DlgMedicamento();
		/*med.lblAr.setEnabled(false);
		med.btnConsultar.setEnabled(false);
		med.btnEliminar.setEnabled(false);
		med.btnModificar.setEnabled(false);
		med.btnGuardarMedicamentos.setEnabled(false);*/
		med.setVisible(true);

		if (!med.nombreProducto.equals("") && med.precioProducto > 0 && med.cantidadVender > 0) {
			if (jtblConsumo.getRowCount() == 0) {
				double subtotal = med.precioProducto * med.cantidadVender;
				dtm.addRow(new Object[] { med.codigoProducto, med.nombreProducto, med.cantidadVender,
						med.precioProducto, Libreria.formato2Decimales(subtotal) });
				total += subtotal;
				txtTotal.setText(Libreria.formatoSoles(total));
			}
			else {
				int c = 0;
				for (int i = 0; i < jtblConsumo.getRowCount(); i++) {
					if (med.codigoProducto.equals(jtblConsumo.getValueAt(i, 0).toString())) {
						c++;
						break;
					}
				}

				if (c == 0) {
					double subtotal = med.precioProducto * med.cantidadVender;
					dtm.addRow(new Object[] { med.codigoProducto, med.nombreProducto, med.cantidadVender,
							med.precioProducto, Libreria.formato2Decimales(subtotal) });
					total += subtotal;
					txtTotal.setText(Libreria.formatoSoles(total));
				}
				else {
					Libreria.mensajeInformacion(this, "El PRODUCTO ya fue agregado a la lista.");
				}
			}
		}
	}
	
	//*******************************************************************************************************
	//BOTON SELECIONAR SERVICIO
	
	protected void mouseEnteredLblNext(MouseEvent e) {
		lblnext.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/siguienteBlanco.png")));
		lblnext.setOpaque(true);
		lblnext.setBackground(new Color(10, 20, 26));
		lblnext.setForeground(new Color(255,255,255));
	}
	protected void mouseEnteredLblSeleccionarServicio(MouseEvent e) {
		lblSeleccionarServicio.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/atencion_serviciosBlanco.png")));
		lblSeleccionarServicio.setOpaque(true);
		lblSeleccionarServicio.setBackground(new Color(10, 20, 26));
		lblSeleccionarServicio.setForeground(new Color(255,255,255));
	}
	
	protected void mouseExitedLblNext(MouseEvent e) {
		lblnext.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/siguienteNegro.png")));
		lblnext.setOpaque(false);
		lblnext.setForeground(new Color(10, 20, 26));
	}
	protected void mouseExitedLblSeleccionarServicio(MouseEvent e) {
		lblSeleccionarServicio.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/atencion_servicios.png")));
		lblSeleccionarServicio.setOpaque(false);
		lblSeleccionarServicio.setForeground(new Color(10, 20, 26));
	}
	protected void mouseClickedlblNext(MouseEvent e) {
		DlgInternamiento hos = new DlgInternamiento();
		hos.setTitle("PACIENTES HOSPITALIZADOS");
		hos.btnBuscarPaciente.setEnabled(false);
		hos.rdbtnEconomico.setEnabled(false);
		hos.rdbtnEjecutivo.setEnabled(false);
		hos.cboNroCamas.setEnabled(false);
		hos.btnAceptar.setEnabled(false);
		hos.btnCancelar.setEnabled(false);
		hos.btnGrabarHospitalizacion.setEnabled(false);
		hos.rdbtnFiltrarPagado.setEnabled(false);
		hos.rdbtnFiltrarTodo.setEnabled(false);
		hos.setVisible(true);
		txtCodigoPaciente.setText(hos.codigoPaciente);

		
	}
	protected void mouseClickedLblSeleccionarServicio(MouseEvent e) {

		DlgServicios ser = new DlgServicios();
		/*ser.lblIngresar.setEnabled(false);
		ser.btnConsultar.setEnabled(false);
		ser.btnEliminar.setEnabled(false);
		ser.btnModificar.setEnabled(false);
		ser.btnGuardarServicios.setEnabled(false);*/
		ser.setVisible(true);
		if (!ser.codServicio.equals("") && ser.precioServicio > 0) {
			if (jtblConsumo.getRowCount() == 0) {
				dtm.addRow(new Object[] { ser.codServicio, ser.nomServicio, 1,
						Libreria.formatoDecimales(ser.precioServicio),
						Libreria.formato2Decimales(ser.precioServicio) });
				total += ser.precioServicio;
				txtTotal.setText(Libreria.formatoSoles(total));
			}
			else {
				int c = 0;
				for (int i = 0; i < jtblConsumo.getRowCount(); i++) {
					if (ser.codServicio.equals(jtblConsumo.getValueAt(i, 0).toString())) {
						c++;
						break;
					}
				}

				if (c == 0) {
					dtm.addRow(new Object[] { ser.codServicio, ser.nomServicio, 1,
							Libreria.formatoDecimales(ser.precioServicio),
							Libreria.formato2Decimales(ser.precioServicio) });
					total += ser.precioServicio;
					txtTotal.setText(Libreria.formatoSoles(total));
				}
				else {
					Libreria.mensajeInformacion(this, "El SERVICIO ya fue agregado a la lista.");
				}
			}
		}
	} 
	
	
	//********************************************************************************
	//BOTON PARA LLAMAR A PACIENTE
	protected void mouseEnteredLblnext(MouseEvent e) {
		lblnext.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/nextventanaBlanco.png")));
		lblnext.setOpaque(true);
		lblnext.setBackground(new Color(10, 20, 26));
		lblnext.setForeground(new Color(255,255,255));
	}
	
	protected void mouseExiteddLblnext(MouseEvent e) {
		lblnext.setIcon(new ImageIcon(DlgEmpleado.class.getResource("/iconBotones/nextventana.png")));
		lblnext.setOpaque(false);
		lblnext.setForeground(new Color(10, 20, 26));
	}
	
	protected void mouseClickedLblnext(MouseEvent e) {
		DlgInternamiento hos = new DlgInternamiento();
		hos.setTitle("PACIENTES HOSPITALIZADOS");
		hos.btnBuscarPaciente.setEnabled(false);
		hos.rdbtnEconomico.setEnabled(false);
		hos.rdbtnEjecutivo.setEnabled(false);
		hos.cboNroCamas.setEnabled(false);
		hos.btnAceptar.setEnabled(false);
		hos.btnCancelar.setEnabled(false);
		hos.btnGrabarHospitalizacion.setEnabled(false);
		hos.rdbtnFiltrarPagado.setEnabled(false);
		hos.rdbtnFiltrarTodo.setEnabled(false);
		hos.setVisible(true);
		txtCodigoPaciente.setText(hos.codigoPaciente);
	}
}
