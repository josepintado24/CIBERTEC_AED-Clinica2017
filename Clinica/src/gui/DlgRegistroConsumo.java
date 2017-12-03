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
import libreria.DiseñoObjetos;
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

public class DlgRegistroConsumo extends JDialog implements ActionListener {

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
	private JButton btnBuscarPaciente;
	private JButton btnSeleccionarMedicamento;
	private JButton btnSeleccionarServicio;
	private JButton btnEliminar;
	private JButton btnRegistrar;
	private JPanel panel;
	private int x;
	private int y;

	// Declaración global para modelo de tabla
	private DefaultTableModel dtm;

	// Declaración global para arreglos
	ArregloConsumo ac = new ArregloConsumo("consumos.txt");
	ArregloDetalleConsumo adet = new ArregloDetalleConsumo("detallesconsumos.txt");
	ArregloMedicamento am = new ArregloMedicamento("medicamentos.txt");

	// Declaración global para libreria
	Fecha f = new Fecha();
	DiseñoObjetos ds = new DiseñoObjetos();

	// Declaración variable global para la suma total de la venta
	private double total = 0.0;
	private JPanel panel_1;
	private JLabel label;
	private JLabel lblRegitro;

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
		setBounds(100, 100, 754, 598);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 227, 728, 309);
		getContentPane().add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblConsumo = new JTable(dtm) {
			public static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};
		jtblConsumo.setFont(new Font("Arial", Font.BOLD, 14));
		jtblConsumo.setForeground(Color.BLACK);
		jtblConsumo.setRowHeight(25);
		scrollPane.setViewportView(jtblConsumo);

		txtTotal = new JTextField();
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
		lblTotal.setBounds(462, 560, 147, 14);
		getContentPane().add(lblTotal);

		btnEliminar = new JButton("ELIMINAR PRODUCTO DE LISTA");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(135, 206, 235));
		btnEliminar.setBounds(60, 548, 263, 39);
		ds.setCurvasButton(btnEliminar, "imagenes/eliminar.png");
		getContentPane().add(btnEliminar);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(0, 255, 127));
		btnRegistrar.setBounds(358, 548, 147, 39);
		ds.setCurvasButton(btnRegistrar, "imagenes/aceptar.png");
		getContentPane().add(btnRegistrar);

		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 83, 728, 133);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblCodigoConsumo = new JLabel("CODIGO CONSUMO :");
		lblCodigoConsumo.setBounds(10, 18, 124, 14);
		panel.add(lblCodigoConsumo);
		lblCodigoConsumo.setForeground(Color.BLACK);
		lblCodigoConsumo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoConsumo.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));

		lblCodigoPaciente = new JLabel("CODIGO PACIENTE :");
		lblCodigoPaciente.setBounds(10, 58, 124, 14);
		panel.add(lblCodigoPaciente);
		lblCodigoPaciente.setForeground(Color.BLACK);
		lblCodigoPaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoPaciente.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));

		txtCodigoConsumo = new JTextField();
		txtCodigoConsumo.setBounds(144, 11, 119, 29);
		panel.add(txtCodigoConsumo);
		txtCodigoConsumo.setBackground(Color.WHITE);
		txtCodigoConsumo.setForeground(Color.BLACK);
		txtCodigoConsumo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigoConsumo.setEditable(false);
		txtCodigoConsumo.setColumns(10);

		txtCodigoPaciente = new JTextField();
		txtCodigoPaciente.setBounds(144, 51, 119, 29);
		panel.add(txtCodigoPaciente);
		txtCodigoPaciente.setBackground(Color.WHITE);
		txtCodigoPaciente.setForeground(Color.BLACK);
		txtCodigoPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigoPaciente.setEditable(false);
		txtCodigoPaciente.setColumns(10);

		btnBuscarPaciente = new JButton("");
		btnBuscarPaciente.setBounds(273, 51, 47, 29);
		panel.add(btnBuscarPaciente);
		btnBuscarPaciente.addActionListener(this);
		btnBuscarPaciente.setForeground(Color.BLACK);
		btnBuscarPaciente.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		ds.setCurvasButton(btnBuscarPaciente, "imagenes/buscar.png");
		btnBuscarPaciente.setBackground(new Color(144, 238, 144));

		btnSeleccionarServicio = new JButton("Seleccionar Servicio");
		btnSeleccionarServicio.addActionListener(this);
		btnSeleccionarServicio.setBounds(251, 91, 195, 29);
		panel.add(btnSeleccionarServicio);
		btnSeleccionarServicio.setForeground(Color.BLACK);
		btnSeleccionarServicio.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnSeleccionarServicio.setBackground(new Color(0, 128, 0));
		ds.setCurvasButton(btnSeleccionarServicio, "imagenes/servicios.png");

		btnSeleccionarMedicamento = new JButton("Seleccionar Medicamento");
		btnSeleccionarMedicamento.setBounds(10, 91, 231, 29);
		panel.add(btnSeleccionarMedicamento);
		btnSeleccionarMedicamento.addActionListener(this);
		btnSeleccionarMedicamento.setForeground(Color.BLACK);
		btnSeleccionarMedicamento.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		btnSeleccionarMedicamento.setBackground(new Color(0, 255, 255));
		ds.setCurvasButton(btnSeleccionarMedicamento, "imagenes/medicamentos.png");

		cboAno = new JComboBox<String>();
		cboAno.setBounds(633, 11, 85, 29);
		panel.add(cboAno);
		cboAno.setForeground(Color.BLACK);
		cboAno.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboAno.setEnabled(false);
		Fecha.colocarItems(cboAno, Fecha.añoActual(), 2000);

		cboMes = new JComboBox<String>();
		cboMes.setBounds(516, 11, 107, 29);
		panel.add(cboMes);
		cboMes.setForeground(Color.BLACK);
		cboMes.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboMes.setEnabled(false);
		Fecha.colocarMeses(cboMes);
		Fecha.colocarMesActual(cboMes);

		cboDia = new JComboBox<String>();
		cboDia.setBounds(456, 11, 50, 29);
		panel.add(cboDia);
		cboDia.setForeground(Color.BLACK);
		cboDia.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboDia.setEnabled(false);
		Fecha.colocarItems(cboDia, 1, 31);
		Fecha.colocarDiaActual(cboDia);

		lblFecha = new JLabel("FECHA :");
		lblFecha.setBounds(362, 18, 84, 14);
		panel.add(lblFecha);
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 14));
		
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
		 		int result1 =JOptionPane.showConfirmDialog(null, "¿Desea Volver a la Ventana Principal?","Abvertencia",dialog,dialog,m);
		 	
		  		
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

		setCodigoConsumo();
		modeloTabla();

		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSeleccionarServicio) {
			actionPerformedBtnSeleccionarServicio(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnSeleccionarMedicamento) {
			actionPerformedBtnSeleccionarMedicamento(arg0);
		}
		if (arg0.getSource() == btnBuscarPaciente) {
			actionPerformedBtnBuscarPaciente(arg0);
		}
	}

	protected void actionPerformedBtnBuscarPaciente(ActionEvent arg0) {
		DlgHospitalizacion hos = new DlgHospitalizacion();
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

	protected void actionPerformedBtnSeleccionarServicio(ActionEvent arg0) {
		DlgServicios ser = new DlgServicios();
		ser.btnAdicionar.setEnabled(false);
		ser.btnConsultar.setEnabled(false);
		ser.btnEliminar.setEnabled(false);
		ser.btnModificar.setEnabled(false);
		ser.btnGuardarServicios.setEnabled(false);
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

	protected void actionPerformedBtnSeleccionarMedicamento(ActionEvent arg0) {
		DlgMedicamento med = new DlgMedicamento();
		/*med.lblAr.setEnabled(false);
		med.btnConsultar.setEnabled(false);
		med.btnEliminar.setEnabled(false);
		med.btnModificar.setEnabled(false);
		med.btnGuardarMedicamentos.setEnabled(false);
		med.setVisible(true);*/

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

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarProductoDeLista();
	}

	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		if (leerCodConsumo() == -1) {
			Libreria.mensajeInformacion(this, "EL CAMPO CÓDIGO DE CONSUMO NO PUEDE ESTAR VACÍO");
		}
		else if (leerCodPaciente() == -1) {
			Libreria.mensajeInformacion(this, "DEBE SELECCIONAR EL CÓDIGO DEL PACIENTE");
		}
		else {
			if (jtblConsumo.getRowCount() != 0) {
				int msj = Libreria.confirmacion(this, "¿Desea registrar el detalle de consumo?");

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
						for (int j = 0; j < am.tamaño(); j++) {
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

	// Métodos void sin parámetros
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
			Libreria.mensajeInformacion(this, "La lista está vacía.");
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

	// Métodos que retornar valores
	String[] getColumnas() {
		String columnas[] = new String[] { "CÓDIGO PRODUCTO", "NOMBRE PRODUCTO", "CANTIDAD", "PRECIO", "SUBTOTAL" };
		return columnas;
	}

	int leerCodConsumo() {
		return Libreria.leerEntero(txtCodigoConsumo);
	}

	int leerCodPaciente() {
		return Libreria.leerEntero(txtCodigoPaciente);
	}
}
