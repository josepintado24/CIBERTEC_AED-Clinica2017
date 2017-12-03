package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import arreglos.ArregloCamas;
import arreglos.ArregloConsumo;
import arreglos.ArregloDetalleConsumo;
import arreglos.ArregloHospitalizacion;
import arreglos.ArregloMedicamento;
import arreglos.ArregloPaciente;
import arreglos.ArregloServicio;
import clases.Camas;
import clases.Atencion;
import clases.DetalleAtencion;
import clases.Internamiento;
import clases.Medicamentos;
import clases.Paciente;
import clases.Servicio;
import libreria.DiseñoObjetos;
import libreria.Fecha;
import libreria.Libreria;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import java.awt.event.MouseListener;

public class DlgControlDePagos extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCdigoPaciente;
	private JTextField txtCodigoPaciente;
	private JButton btnBuscarPaciente;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JComboBox<String> cboDia;
	private JComboBox<String> cboMes;
	private JComboBox<String> cboAno;
	private int x;
	private int y;

	// VARIABLE GLOBAL PARA OBTENER LA FECHA ACTUAL
	private int fecha;
	// VARIABLE GLOBAL PARA OBTENER LA HORA ACTUAL
	private int hora;
	// VARIABLE GLOBAL PARA ASIGNAR EL TOTAL DE IMPORTE QUE PAGARÀ EL CLIENTE
	private double totalVenta = 0.0;

	// VARIABLES GLOBALES PARA GUARDAR FACTURA
	private int nroCama = 0;
	private ArrayList<Integer> codDet;
	private int codHospitalizacion = 0;
	int cantDias = 0;
	double precioxDia = 0.0;

	// DECLARACIÓN GLOBAL DE ARREGLOS
	ArregloHospitalizacion ah = new ArregloHospitalizacion("hospitalizaciones.txt");
	ArregloCamas ac = new ArregloCamas("camas.txt");
	ArregloConsumo acon = new ArregloConsumo("consumos.txt");
	ArregloDetalleConsumo adet = new ArregloDetalleConsumo("detallesconsumos.txt");
	ArregloMedicamento am = new ArregloMedicamento("medicamentos.txt");
	ArregloServicio as = new ArregloServicio("servicios.txt");

	// DECLARACIÓN GLOBAL DE LIBRERIA
	DiseñoObjetos ds = new DiseñoObjetos();
	private JPanel panel;
	private JLabel lbliconPaciente;
	private JLabel lblVerFactura;
	private JLabel lblRegistrar;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			DlgControlDePagos dialog = new DlgControlDePagos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgControlDePagos() {
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setResizable(false);
		setTitle("CONTROL DE PAGOS");
		setBounds(100, 100, 608, 756);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 191, 576, 456);
		getContentPane().add(scrollPane);
		scrollPane.setBorder(null);

		txtS = new JTextArea();
		txtS.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 75, 575, 105);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.WHITE, 0, true));

		lblCdigoPaciente = new JLabel("CODIGO");
		lblCdigoPaciente.setBackground(Color.BLACK);
		lblCdigoPaciente.setBounds(57, 26, 59, 14);
		panel.add(lblCdigoPaciente);
		lblCdigoPaciente.setForeground(Color.BLACK);
		lblCdigoPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCdigoPaciente.setHorizontalAlignment(SwingConstants.RIGHT);

		txtCodigoPaciente = new JTextField();
		txtCodigoPaciente.setBounds(126, 19, 105, 21);
		panel.add(txtCodigoPaciente);
		txtCodigoPaciente.setBackground(Color.WHITE);
		txtCodigoPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoPaciente.setEditable(false);
		txtCodigoPaciente.setForeground(Color.BLACK);
		txtCodigoPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigoPaciente.setColumns(10);
		txtCodigoPaciente.setBorder(null);
		txtCodigoPaciente.setOpaque(false);

		btnBuscarPaciente = new JButton("");
		btnBuscarPaciente.setBounds(245, 11, 38, 29);
		panel.add(btnBuscarPaciente);
		btnBuscarPaciente.setBackground(new Color(102, 205, 170));
		btnBuscarPaciente.addActionListener(this);
		btnBuscarPaciente.setForeground(Color.BLACK);
		btnBuscarPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		ds.setCurvasButton(btnBuscarPaciente, "imagenes/buscar.png");

		cboDia = new JComboBox<String>();
		cboDia.setBounds(309, 11, 59, 29);
		panel.add(cboDia);
		cboDia.setForeground(Color.BLACK);
		cboDia.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboDia.setEnabled(false);
		Fecha.colocarItems(cboDia, 1, 31);
		Fecha.colocarDiaActual(cboDia);

		cboMes = new JComboBox<String>();
		cboMes.setBounds(369, 11, 116, 29);
		panel.add(cboMes);
		cboMes.setForeground(Color.BLACK);
		cboMes.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboMes.setEnabled(false);
		Fecha.colocarMeses(cboMes);
		Fecha.colocarMesActual(cboMes);

		cboAno = new JComboBox<String>();
		cboAno.setBounds(486, 11, 79, 29);
		panel.add(cboAno);
		cboAno.setForeground(Color.BLACK);
		cboAno.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboAno.setEnabled(false);
		cboAno.addItem("" + Fecha.añoActual());

		fecha = Fecha.getFecha(cboDia, cboMes, cboAno);
		
		lbliconPaciente = new JLabel("");
		lbliconPaciente.setIcon(new ImageIcon(DlgControlDePagos.class.getResource("/iconBotones/patient.png")));
		lbliconPaciente.setBounds(34, 19, 21, 21);
		panel.add(lbliconPaciente);
		
		lblVerFactura = new JLabel("LISTAR FACTURA");
		lblVerFactura.setIcon(new ImageIcon(DlgControlDePagos.class.getResource("/iconBotones/bill_blanco.png")));
		lblVerFactura.addMouseListener(this);
		lblVerFactura.setInheritsPopupMenu(false);
		lblVerFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerFactura.setForeground(new Color(243, 124, 47));
		lblVerFactura.setFont(new Font("Dialog", Font.BOLD, 16));
		lblVerFactura.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
		lblVerFactura.setBackground(new Color(1, 168, 25));
		lblVerFactura.setBounds(74, 64, 193, 37);
		panel.add(lblVerFactura);
		
		lblRegistrar = new JLabel("REGISTRAR PAGO");
		lblRegistrar.setIcon(new ImageIcon(DlgControlDePagos.class.getResource("/iconBotones/money_blanco.png")));
		lblRegistrar.addMouseListener(this);
		lblRegistrar.setInheritsPopupMenu(false);
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setForeground(new Color(243, 124, 47));
		lblRegistrar.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRegistrar.setBorder(new LineBorder(new Color(243, 124, 47), 1, true));
		lblRegistrar.setBackground(new Color(1, 168, 25));
		lblRegistrar.setBounds(309, 64, 193, 37);
		panel.add(lblRegistrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setBackground(Color.WHITE);
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				Point ubicacion = MouseInfo.getPointerInfo().getLocation();
			    setLocation(ubicacion.x - x, ubicacion.y - y);
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				x = arg0.getX();
			    y = arg0.getY();
			}
		});
		panel_1.setBounds(0, 0, 601, 39);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Icon m = new ImageIcon(getClass().getResource("/image/ADVERTENCIA.png"));
		  		int dialog = JOptionPane.YES_NO_OPTION;
		 		int result1 =JOptionPane.showConfirmDialog(null, "¿Desea Volver a la Ventana Principal?","Abvertencia",dialog,dialog,m);
		 	
		  		
		  		if(result1 ==0){
		  			dispose();
		 			Principal frame = new Principal();
		 			frame.setVisible(true);}
			}
		});
		label.setIcon(new ImageIcon(DlgControlDePagos.class.getResource("/image/icons8_Return_32px.png")));
		label.setBounds(558, 0, 33, 39);
		panel_1.add(label);
		
		JLabel lblPa = new JLabel("Pagos");
		lblPa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPa.setFont(new Font("Decker", Font.PLAIN, 16));
		lblPa.setBounds(30, 0, 77, 39);
		panel_1.add(lblPa);
		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
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

		if (hos.codigoPaciente.equals("")) {
			txtS.setText("");
			txtCodigoPaciente.setText("");
		}
		else {
			txtCodigoPaciente.setText(hos.codigoPaciente);
			txtS.setText("");
		}
	}

	void guardarFactura() {
		actualizarCamas();
		ac.grabarCamas();

		Internamiento h;
		for (int i = 0; i < ah.tamaño(); i++) {
			h = ah.obtener(i);
			if (h.getCodHosp() == codHospitalizacion) {
				h.setFecSali(fecha);
				h.setHorSali(hora);
				h.setEstado(2);
			}
		}
		ah.grabarHospitalizacion();

		if (!codDet.isEmpty()) {
			for (int j = 0; j < codDet.size(); j++) {
				Atencion con;
				for (int i = 0; i < acon.tamaño(); i++) {
					con = acon.obtener(i);
					if (con.getEstado() == 0) {
						if (con.getCodConsumo() == codDet.get(j)) {
							con.setEstado(1);
						}
					}
				}
			}

			Atencion con;
			for (int l = 0; l < acon.tamaño(); l++) {
				con = acon.obtener(l);
				if (con.getCodConsumo() == codDet.get(codDet.size() - 1)) {
					con.setTotalPago(con.getTotalPago() + (cantDias * precioxDia));
				}
			}

			adet.adicionar(new DetalleAtencion(codDet.get(codDet.size() - 1), nroCama, cantDias, precioxDia,
					cantDias * precioxDia));
		}
		else {
			acon.adicionar(
					new Atencion(acon.codigoCorrelativo(), leerCodigoPaciente(), fecha, 1, cantDias * precioxDia));
			adet.adicionar(new DetalleAtencion(acon.obtener(acon.tamaño() - 1).getCodConsumo(), nroCama, cantDias,
					precioxDia, cantDias * precioxDia));
		}

		acon.grabarConsumo();
		adet.grabarDetalleConsumo();
		am.grabarMedicamentos();
		as.grabarServicios();
	}

	void verFactura() {
		txtS.setText("");
		imprimir(String.format("%85s", "HOSPITAL DE LA SOLIDARIDAD"));
		imprimir(String.format("%85s", "RUC" + String.format("%11d", 1040501050)));
		imprimir(String.format("%90s", "Av. Angamos Este 734 · (01) 2431120"));
		imprimir(String.format("%85s", "BOLETA ELECTRÓNICA"));
		imprimir("\t                 ----------------------------------------------------------------");
		imprimir("\t                 ----------------------------------------------------------------");
		imprimir(String.format("%65s", "FECHA EMISIÓN\t:\t" + Fecha.dd_mm_aaaa(fecha)));
		imprimir(String.format("%62s", "HORA EMISIÓN\t:\t" + Fecha.hh_mm_ss(hora)));
		datosPaciente();
		imprimir("\t                 ----------------------------------------------------------------");
		imprimir("\t                 ----------------------------------------------------------------");

		// OBTENIENDO LOS CODIGOS DE CONSUMO DONDE HA COMPRADO EL PACIENTE
		Atencion con;
		codDet = new ArrayList<Integer>();
		for (int i = 0; i < acon.tamaño(); i++) {
			con = acon.obtener(i);
			if (con.getEstado() == 0) {
				if (con.getCodPaciente() == leerCodigoPaciente()) {
					codDet.add(con.getCodConsumo());
				}
			}
		}

		// LISTANDO PRODUCTOS COMPRADOS POR EL PACIENTE
		double total = 0.0;
		if (codDet.size() > 0 && !codDet.isEmpty()) {
			imprimir(String.format("%82s", "MEDICAMENTOS COMPRADOS"));
			imprimir("\tPRODUCTO\tPRECIO\tCANTIDAD\tSUBTOTAL");
			for (int i = 0; i < codDet.size(); i++) {
				total += listadoProductoAdquiridos(codDet.get(i));
			}
			imprimir("\t\t\t SUBTOTAL\t  " + String.format("%.2f", total));
			imprimir("\t                 ----------------------------------------------------------------");
			imprimir("\t                 ----------------------------------------------------------------");
		}

		// MOSTRANDO PRODUCTOS ADQUIRIDOS POR EL PACIENTE
		if (codDet.size() > 0 && !codDet.isEmpty()) {
			total = 0;
			imprimir(String.format("%85s", "SERVICIOS COMPRADOS"));
			imprimir("\tSERVICIO\tPRECIO\tCANTIDAD\tSUBTOTAL");
			for (int i = 0; i < codDet.size(); i++) {
				total += listadoServicios(codDet.get(i));
			}
			imprimir("\t\t\t SUBTOTAL\t  " + String.format("%.2f", total));
			imprimir("\t                 ----------------------------------------------------------------");
			imprimir("\t                 ----------------------------------------------------------------");
		}

		// OBTENIENDO EL NÚMERO DE CAMA DEL PACIENTE Y LA CANTIDAD DE DIAS
		// HOSPITALIZADO
		// Y LOS DATOS DE LA HOSPITALIZACION DEL PACIENTE
		Internamiento h;
		for (int i = 0; i < ah.tamaño(); i++) {
			h = ah.obtener(i);
			if (h.getEstado() == 1) {
				if (h.getCodPaci() == leerCodigoPaciente()) {
					codHospitalizacion = h.getCodHosp();
					cantDias = cantidadDeDias(h.getFecLleg());
					nroCama = h.getNumCama();
				}
			}
		}

		// OBTENIENDO DATOS DE LA CAMA DONDE SE HOSPITALIZÓ EL PACIENTE
		int categoriaCama = 0;
		Camas c;
		for (int i = 0; i < ac.tamaño(); i++) {
			c = ac.obtener(i);
			if (c.getNroCama() == nroCama) {
				precioxDia = c.getPrecioxDia();
				categoriaCama = c.getCategoria();
			}
		}

		// MOSTRANDO DE LA CAMA DONDE SE HOSPITALIZÓ
		imprimir(String.format("%85s", "HOSPITALIZACIÓN EN CAMA"));
		if (cantDias == 0) {
			imprimir("\t       CATERORIA CAMA\t:\t" + getCategoria(categoriaCama).toUpperCase());
			imprimir("\t       NRO CAMA\t\t:\t" + nroCama);
			imprimir("\t       PRECIO POR DÍA\t:\t" + String.format("%.2f", precioxDia));
			imprimir("\t       CANTIDAD DE DÍAS\t:\t" + 1);
			imprimir("\t\t\t SUBTOTAL\t  " + String.format("%.2f", precioxDia));
			totalVenta += precioxDia;
		}
		else {
			imprimir("\t       CATERORIA CAMA\t:\t" + getCategoria(categoriaCama).toUpperCase());
			imprimir("\t       NRO CAMA\t\t:\t" + nroCama);
			imprimir("\t       PRECIO POR DÍA\t:\t" + String.format("%.2f", precioxDia));
			imprimir("\t       CANTIDAD DE DÍAS\t:\t" + cantDias);
			imprimir("\t\t\t SUBTOTAL\t  " + String.format("%.2f", precioxDia * cantDias));
			totalVenta += (precioxDia * cantDias);
		}

		imprimir("\t                 ----------------------------------------------------------------");
		imprimir("\t                 ----------------------------------------------------------------");
		imprimir("\t\t\t TOTAL\t" + String.format("%.2f", totalVenta));
		totalVenta = 0.0;
		imprimir("\t                 ----------------------------------------------------------------");
		imprimir("\t                 ----------------------------------------------------------------");
		imprimir(String.format("%85s", "NO HAY DEVOLUCIÓN DE DINERO."));
		imprimir(String.format("%80s", "TODO CAMBIO DE PRODUCTO SE HARÁ DENTRO"));
		imprimir(String.format("%82s", "DE LAS 48 HORAS PREVIA PRESENTACIÓN DEL"));
		imprimir(String.format("%80s", "COMPROBANTE Y VERIFICACIÓN POR PARTE DEL"));
		imprimir(String.format("%85s", "ADMINISTRADOR"));
		imprimir("");
		imprimir(String.format("%83s", "WWW.SOLIDARIDAD.COM"));
		imprimir(String.format("%83s", "GRACIAS POR SU COMPRA"));
	}

	void nuevaFactura() {
		txtCodigoPaciente.setText("");
		totalVenta = 0.0;
		txtS.setText("");
		Fecha.colocarDiaActual(cboDia);
		Fecha.colocarMesActual(cboMes);
	}

	void actualizarCamas() {
		Camas c;
		for (int j = 0; j < ac.tamaño(); j++) {
			c = ac.obtener(j);
			if (c.getNroCama() == nroCama)
				c.setEstado(0);
		}
	}

	double listadoProductoAdquiridos(int codConsumo) {
		DetalleAtencion det;
		Medicamentos med;

		int codProducto;
		double total = 0.0;

		for (int i = 0; i < adet.tamaño(); i++) {
			det = adet.obtener(i);

			if (codConsumo == det.getCodConsumo()) {
				codProducto = det.getCodProducto();

				for (int j = 0; j < am.tamaño(); j++) {
					med = am.obtener(j);
					if (codProducto == med.getCodMedicamento()) {
						imprimir("\t" + med.getNombre() + "\t" + String.format("%.2f", med.getPrecio()) + "\t   "
								+ det.getCantidad() + "\t  " + String.format("%.2f", det.getSubtotal()));
						total += det.getSubtotal();
					}
				}
			}
		}
		totalVenta += total;
		return total;
	}

	double listadoServicios(int codConsumo) {
		DetalleAtencion det;
		Servicio ser;

		int codProducto;
		double total = 0.0;

		for (int i = 0; i < adet.tamaño(); i++) {
			det = adet.obtener(i);

			if (codConsumo == det.getCodConsumo()) {
				codProducto = det.getCodProducto();

				for (int j = 0; j < as.tamaño(); j++) {
					ser = as.obtener(j);
					if (codProducto == ser.getCodServicio()) {
						imprimir("\t" + ser.getDescripcion() + "\t" + String.format("%.2f", ser.getPrecio()) + "\t   "
								+ det.getCantidad() + "\t  " + String.format("%.2f", det.getSubtotal()));
						total += det.getSubtotal();
					}
				}
			}
		}
		totalVenta += total;
		return total;
	}

	void datosPaciente() {
		ArregloPaciente ap = new ArregloPaciente("pacientes.txt");
		Paciente p;
		for (int i = 0; i < ap.tamaño(); i++) {
			p = ap.obtener(i);
			if (p.getCodpaciente() == leerCodigoPaciente()) {
				imprimir("\t          NOMBRE\t\t:\t" + p.getApellidos().toUpperCase() + " "
						+ p.getNombres().toUpperCase());
				imprimir(String.format("%54s", "DNI\t\t:\t" + p.getDNI()));
			}
		}
	}

	String getCategoria(int est) {
		if (est == 0) {
			return "ECONÓMICO";
		}
		else {
			return "EJECUTIVO";
		}
	}

	int cantidadDeDias(int feclleg) {
		int cantidadDias = Fecha.CantidadDiasEntre2fechas(Fecha.obtenerAñoDeFecha(feclleg),
				Fecha.obtenerMesDeFecha(feclleg), Fecha.obtenerDiaDeFecha(feclleg), Fecha.obtenerAñoDeFecha(fecha),
				Fecha.obtenerMesDeFecha(fecha), Fecha.obtenerDiaDeFecha(fecha));
		return cantidadDias;
	}

	int leerCodigoPaciente() {
		return Libreria.leerEntero(txtCodigoPaciente);
	}

	void imprimir(String dato) {
		txtS.append(dato + "\n");
	}
	
	////***** EventoClicked***///
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblRegistrar) {
			mouseClickedLblRegistrar(arg0);
		}
		if (arg0.getSource() == lblVerFactura) {
			mouseClickedLblVerFactura(arg0);
		}
	}
	
	
	////****EventoEntered****////
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == lblVerFactura) {
			mouseEnteredLblVerFactura(arg0);
		}
		if (arg0.getSource() == lblRegistrar) {
			mouseEnteredLblRegistrar(arg0);
		}
		
	}
	
	
	////*****EventoExited****////
	
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblVerFactura) {
			mouseExitedLblVerFactura(e);
		}
		
		if (e.getSource() == lblRegistrar) {
			mouseExitedLblRegistrar(e);
		}		
	}
		
	//*** mouse entered *** /// 
	public void mouseEnteredLblVerFactura(MouseEvent arg0) {
		lblVerFactura.setOpaque(true);
		lblVerFactura.setBackground(new Color(243, 124, 47));
		lblVerFactura.setForeground(new Color(255, 255, 255));
		lblVerFactura.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/bill_color.png")));
		
	}
	
	public void mouseEnteredLblRegistrar(MouseEvent arg0) {
		lblRegistrar.setOpaque(true);
		lblRegistrar.setBackground(new Color(243, 124, 47));
		lblRegistrar.setForeground(new Color(255, 255, 255));
		lblRegistrar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/money_color.png")));
		
	}
	
	////****Mouse Exited****////
		
	
	
	public void mouseExitedLblVerFactura(MouseEvent arg0) {
		lblVerFactura.setOpaque(false);
		lblVerFactura.setForeground(new Color(243, 124, 47));
		lblVerFactura.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/bill_blanco.png")));
		lblVerFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
	}
		//
	public void mouseExitedLblRegistrar(MouseEvent arg0) {
		lblRegistrar.setOpaque(false);
		lblRegistrar.setForeground(new Color(243, 124, 47));
		lblRegistrar.setIcon(new ImageIcon(DlgPaciente.class.getResource("/iconBotones/money_blanco.png")));
		lblRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 124, 47)));
	}
	
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	
	
	
	
	
	
	
	//**Evento Mouse CLicked***///
	
	protected void mouseClickedLblVerFactura(MouseEvent arg0) {

		if (leerCodigoPaciente() != -1) {
			hora = Fecha.obtenerHoraActual();
			verFactura();
		}
	
	}
	protected void mouseClickedLblRegistrar(MouseEvent arg0) {
		if (!txtS.getText().trim().equals("") && leerCodigoPaciente() != -1) {
			int msj = Libreria.confirmacion(this, "¿DESEA GUARDAR EL REGISTRO DE FACTURA?");
			if (msj == 0) {
				guardarFactura();
				nuevaFactura();
			}
			else {
				Libreria.mensajeInformacion(this, "EL REGISTRO NO SE GUARDÓ");
			}
		}
		
	}
}
