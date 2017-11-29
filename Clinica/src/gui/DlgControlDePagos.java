package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
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

public class DlgControlDePagos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCdigoPaciente;
	private JTextField txtCodigoPaciente;
	private JButton btnBuscarPaciente;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnRegistrarPago;
	private JComboBox<String> cboDia;
	private JComboBox<String> cboMes;
	private JComboBox<String> cboAno;
	private JButton btnVerFactura;

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
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setResizable(false);
		setTitle("CONTROL DE PAGOS");
		setBounds(100, 100, 601, 622);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 576, 456);
		getContentPane().add(scrollPane);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 11, 575, 105);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.red, 3, false));

		lblCdigoPaciente = new JLabel("C\u00D3DIGO PACIENTE ");
		lblCdigoPaciente.setBounds(0, 18, 129, 14);
		panel.add(lblCdigoPaciente);
		lblCdigoPaciente.setForeground(Color.WHITE);
		lblCdigoPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblCdigoPaciente.setHorizontalAlignment(SwingConstants.RIGHT);

		txtCodigoPaciente = new JTextField();
		txtCodigoPaciente.setBounds(130, 11, 105, 29);
		panel.add(txtCodigoPaciente);
		txtCodigoPaciente.setBackground(Color.WHITE);
		txtCodigoPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoPaciente.setEditable(false);
		txtCodigoPaciente.setForeground(Color.BLACK);
		txtCodigoPaciente.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		txtCodigoPaciente.setColumns(10);

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

		btnRegistrarPago = new JButton("REGISTRAR PAGO");
		btnRegistrarPago.setBounds(275, 54, 176, 40);
		panel.add(btnRegistrarPago);
		btnRegistrarPago.addActionListener(this);
		btnRegistrarPago.setBackground(Color.CYAN);
		btnRegistrarPago.setForeground(Color.BLACK);
		btnRegistrarPago.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		ds.setCurvasButton(btnRegistrarPago, "imagenes/aceptar.png");

		btnVerFactura = new JButton("VER FACTURA");
		btnVerFactura.setBounds(103, 54, 150, 40);
		panel.add(btnVerFactura);
		btnVerFactura.addActionListener(this);
		btnVerFactura.setForeground(Color.BLACK);
		btnVerFactura.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnVerFactura.setBackground(Color.GREEN);
		ds.setCurvasButton(btnVerFactura, "imagenes/listado.png");
		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVerFactura) {
			actionPerformedBtnVerFactura(arg0);
		}
		if (arg0.getSource() == btnRegistrarPago) {
			actionPerformedBtnRegistrarPago(arg0);
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

		if (hos.codigoPaciente.equals("")) {
			txtS.setText("");
			txtCodigoPaciente.setText("");
		}
		else {
			txtCodigoPaciente.setText(hos.codigoPaciente);
			txtS.setText("");
		}
	}

	protected void actionPerformedBtnRegistrarPago(ActionEvent arg0) {
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

	protected void actionPerformedBtnVerFactura(ActionEvent arg0) {
		if (leerCodigoPaciente() != -1) {
			hora = Fecha.obtenerHoraActual();
			verFactura();
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
}
