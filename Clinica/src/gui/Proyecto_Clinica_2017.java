package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloCamas;
import arreglos.ArregloPaciente;
import libreria.DiseñoObjetos;
import libreria.Libreria;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.Insets;

@SuppressWarnings("unused")
public class Proyecto_Clinica_2017 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnHospitalización;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JLabel lblFondo;
	private JMenu mnPago;
	private JMenu mnRegistroDeConsumo;
	private JMenuItem mntmEmpleados;
	private JMenuItem mntmPacientes;
	private JMenuItem mntmCamas;
	private JMenuItem mntmMedicamentos;
	private JMenuItem mntmServicios;
	private JMenuItem mntmConsumo;
	private JMenuItem mntmRegistrar;
	private JMenuItem mntmIniciarSesin;
	private JMenuItem mntmRegistrarPago;
	private JMenuItem mntmPacientesAdmitidos;
	private JMenuItem mntmHospitalizacionesPorFecha;
	private JMenuItem mntmEmpledadoshospitalizaciones;
	private JMenuItem mntmPacientespago;

	// Variable global para obtener código del empleado
	private int codigoEmpleado;

	// Variable global para libreria
	Libreria lb = new Libreria();
	DiseñoObjetos ds = new DiseñoObjetos();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto_Clinica_2017 frame = new Proyecto_Clinica_2017();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Proyecto_Clinica_2017() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		final int ANCHO = 900, ALTO = 600, DX = 8, DY = 53;

		setTitle("Cl\u00EDnica L\u00E1zaro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Proyecto_Clinica_2017.class.getResource("/imagenes/logo_hospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((getToolkit().getScreenSize().width - ANCHO - DX) / 2,
				(getToolkit().getScreenSize().height - ALTO - DY) / 2, ANCHO + DX, ALTO + DY);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuProyecto = new JMenuBar();
		menuProyecto.setMargin(new Insets(10, 10, 15, 15));
		setJMenuBar(menuProyecto);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Arial", Font.BOLD, 12));
		mnArchivo.setForeground(Color.BLACK);
		menuProyecto.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Arial", Font.BOLD, 12));
		mntmSalir.setForeground(Color.BLACK);
		mntmSalir.addActionListener(this);

		mntmIniciarSesin = new JMenuItem("Iniciar sesi\u00F3n");
		mntmIniciarSesin.setFont(new Font("Arial", Font.BOLD, 12));
		mntmIniciarSesin.setForeground(Color.BLACK);
		mntmIniciarSesin.addActionListener(this);
		mntmIniciarSesin.setIcon(new ImageIcon("imagenes/usuario.png"));
		mnArchivo.add(mntmIniciarSesin);
		mntmSalir.setIcon(new ImageIcon(("imagenes/salir.png")));
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setEnabled(false);
		mnMantenimiento.setFont(new Font("Arial", Font.BOLD, 12));
		menuProyecto.add(mnMantenimiento);

		mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.setFont(new Font("Arial", Font.BOLD, 12));
		mntmEmpleados.setForeground(Color.BLACK);
		mntmEmpleados.addActionListener(this);
		mntmEmpleados.setIcon(new ImageIcon("imagenes/empleado.png"));
		mnMantenimiento.add(mntmEmpleados);

		mntmPacientes = new JMenuItem("Pacientes");
		mntmPacientes.setFont(new Font("Arial", Font.BOLD, 12));
		mntmPacientes.setForeground(Color.BLACK);
		mntmPacientes.addActionListener(this);
		mntmPacientes.setIcon(new ImageIcon("imagenes/paciente.png"));
		mnMantenimiento.add(mntmPacientes);

		mntmCamas = new JMenuItem("Camas");
		mntmCamas.setFont(new Font("Arial", Font.BOLD, 12));
		mntmCamas.setForeground(Color.BLACK);
		mntmCamas.addActionListener(this);
		mntmCamas.setIcon(new ImageIcon("imagenes/camas.png"));
		mnMantenimiento.add(mntmCamas);

		mntmMedicamentos = new JMenuItem("Medicamentos");
		mntmMedicamentos.setFont(new Font("Arial", Font.BOLD, 12));
		mntmMedicamentos.setForeground(Color.BLACK);
		mntmMedicamentos.addActionListener(this);
		mntmMedicamentos.setIcon(new ImageIcon("imagenes/medicamentos.png"));
		mnMantenimiento.add(mntmMedicamentos);

		mntmServicios = new JMenuItem("Servicios");
		mntmServicios.setFont(new Font("Arial", Font.BOLD, 12));
		mntmServicios.setForeground(Color.BLACK);
		mntmServicios.addActionListener(this);
		mntmServicios.setIcon(new ImageIcon("imagenes/servicios.png"));
		mnMantenimiento.add(mntmServicios);

		mnHospitalización = new JMenu("Hospitalizaci\u00F3n");
		mnHospitalización.setEnabled(false);
		mnHospitalización.setFont(new Font("Arial", Font.BOLD, 12));
		mnHospitalización.addActionListener(this);
		menuProyecto.add(mnHospitalización);

		mntmRegistrar = new JMenuItem("Hospitalizar Paciente");
		mntmRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
		mntmRegistrar.setForeground(Color.BLACK);
		mntmRegistrar.addActionListener(this);
		mntmRegistrar.setIcon(new ImageIcon("imagenes/hospitalizar.png"));
		mnHospitalización.add(mntmRegistrar);

		mnRegistroDeConsumo = new JMenu("Registro de Consumo");
		mnRegistroDeConsumo.setEnabled(false);
		mnRegistroDeConsumo.setFont(new Font("Arial", Font.BOLD, 12));
		menuProyecto.add(mnRegistroDeConsumo);

		mntmConsumo = new JMenuItem("Registrar Consumo de Pacientes");
		mntmConsumo.setFont(new Font("Arial", Font.BOLD, 12));
		mntmConsumo.setForeground(Color.BLACK);
		mntmConsumo.addActionListener(this);
		mntmConsumo.setIcon(new ImageIcon("imagenes/registroconsumo.png"));
		mnRegistroDeConsumo.add(mntmConsumo);

		mnPago = new JMenu("Pagos");
		mnPago.setEnabled(false);
		mnPago.setFont(new Font("Arial", Font.BOLD, 12));
		mnPago.addActionListener(this);
		menuProyecto.add(mnPago);

		mntmRegistrarPago = new JMenuItem("Registrar Pago de Consumo");
		mntmRegistrarPago.setFont(new Font("Arial", Font.BOLD, 12));
		mntmRegistrarPago.setForeground(Color.BLACK);
		mntmRegistrarPago.addActionListener(this);
		mntmRegistrarPago.setIcon(new ImageIcon("imagenes/pagos.gif"));
		mnPago.add(mntmRegistrarPago);

		mnReporte = new JMenu("Reporte");
		mnReporte.setEnabled(false);
		mnReporte.setFont(new Font("Arial", Font.BOLD, 12));

		menuProyecto.add(mnReporte);

		mntmPacientesAdmitidos = new JMenuItem("Pacientes Admitidos");
		mntmPacientesAdmitidos.setFont(new Font("Arial", Font.BOLD, 12));
		mntmPacientesAdmitidos.setForeground(Color.BLACK);
		mntmPacientesAdmitidos.addActionListener(this);
		mntmPacientesAdmitidos.setIcon(new ImageIcon("imagenes/pacientesadmitidos.png"));
		mnReporte.add(mntmPacientesAdmitidos);

		mntmHospitalizacionesPorFecha = new JMenuItem("Hospitalizaciones Por Fecha");
		mntmHospitalizacionesPorFecha.addActionListener(this);
		mntmHospitalizacionesPorFecha.setForeground(Color.BLACK);
		mntmHospitalizacionesPorFecha.setFont(new Font("Arial", Font.BOLD, 12));
		mntmHospitalizacionesPorFecha.setIcon(new ImageIcon("imagenes/hospitaporfecha.png"));
		mnReporte.add(mntmHospitalizacionesPorFecha);

		mntmPacientespago = new JMenuItem("Pacientes/Pago");
		mntmPacientespago.addActionListener(this);
		mntmPacientespago.setForeground(Color.BLACK);
		mntmPacientespago.setFont(new Font("Arial", Font.BOLD, 12));
		mntmPacientespago.setIcon(new ImageIcon("imagenes/pagosrealizados.gif"));
		mnReporte.add(mntmPacientespago);

		mntmEmpledadoshospitalizaciones = new JMenuItem("Empledados/Hospitalizaciones");
		mntmEmpledadoshospitalizaciones.addActionListener(this);
		mntmEmpledadoshospitalizaciones.setForeground(Color.BLACK);
		mntmEmpledadoshospitalizaciones.setFont(new Font("Arial", Font.BOLD, 12));
		mntmEmpledadoshospitalizaciones.setIcon(new ImageIcon("imagenes/empleadosquehospitalizaron.png"));
		mnReporte.add(mntmEmpledadoshospitalizaciones);

		lblFondo = new JLabel(new ImageIcon(Proyecto_Clinica_2017.class.getResource("/imagenes/clinica.jpg")));
		lblFondo.setBounds(1, 0, ANCHO, ALTO);
		contentPane.add(lblFondo);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmEmpledadoshospitalizaciones) {
			actionPerformedMntmEmpledadoshospitalizaciones(arg0);
		}
		if (arg0.getSource() == mntmPacientespago) {
			actionPerformedMntmPacientespago(arg0);
		}
		if (arg0.getSource() == mntmHospitalizacionesPorFecha) {
			actionPerformedMntmHospitalizacionesPorFecha(arg0);
		}
		if (arg0.getSource() == mntmPacientesAdmitidos) {
			actionPerformedMntmPacientesAdmitidos(arg0);
		}
		if (arg0.getSource() == mntmRegistrarPago) {
			actionPerformedMntmRegistrarPago(arg0);
		}
		if (arg0.getSource() == mntmIniciarSesin) {
			actionPerformedMntmIniciarSesin(arg0);
		}
		if (arg0.getSource() == mntmRegistrar) {
			actionPerformedMntmRegistrar(arg0);
		}
		if (arg0.getSource() == mntmConsumo) {
			actionPerformedMntmConsumo(arg0);
		}
		if (arg0.getSource() == mntmServicios) {
			actionPerformedMntmServicios(arg0);
		}
		if (arg0.getSource() == mntmMedicamentos) {
			actionPerformedMntmMedicamentos(arg0);
		}
		if (arg0.getSource() == mntmCamas) {
			actionPerformedMntmCamas(arg0);
		}
		if (arg0.getSource() == mntmPacientes) {
			actionPerformedMntmPacientes(arg0);
		}
		if (arg0.getSource() == mntmEmpleados) {
			actionPerformedMntmEmpleados(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}

	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		int ok = confirmacionDeSalida();
		if (ok == 0)
			System.exit(0);
	}

	protected void actionPerformedMntmEmpleados(ActionEvent arg0) {
		DlgEmpleado emp = new DlgEmpleado();
		emp.setVisible(true);
	}

	protected void actionPerformedMntmPacientes(ActionEvent arg0) {
		DlgPaciente pac = new DlgPaciente();
		pac.setVisible(true);

	}

	protected void actionPerformedMntmCamas(ActionEvent arg0) {
		DlgCamas cam = new DlgCamas();
		cam.setVisible(true);
	}

	protected void actionPerformedMntmMedicamentos(ActionEvent arg0) {
		DlgMedicamento med = new DlgMedicamento();
		med.setVisible(true);
	}

	protected void actionPerformedMntmServicios(ActionEvent arg0) {
		DlgServicios ser = new DlgServicios();
		ser.setVisible(true);
	}

	protected void actionPerformedMntmConsumo(ActionEvent arg0) {
		DlgRegistroConsumo con = new DlgRegistroConsumo();
		con.setVisible(true);
	}

	protected void actionPerformedMntmRegistrar(ActionEvent arg0) {
		ArregloPaciente ap = new ArregloPaciente("pacientes.txt");
		ArregloCamas ac = new ArregloCamas("camas.txt");

		DlgHospitalizacion hos = new DlgHospitalizacion();
		hos.txtCodigoemple.setText("" + this.codigoEmpleado);

		if (ac.tamaño() == 0) {
			Libreria.mensajeAdvertenciaFrame(this,
					"Antes de registrar una hospitalización debe registrar camas. Verificar.");
			hos.dispose();
		}
		else if (ap.tamaño() == 0) {
			Libreria.mensajeAdvertenciaFrame(this,
					"Antes de registrar una hospitalización debe registrar pacientes. Verificar.");
			hos.dispose();
		}
		else {
			hos.setVisible(true);
		}
	}

	protected void actionPerformedMntmIniciarSesin(ActionEvent arg0) {
		DlgLogin log = new DlgLogin();
		log.setVisible(true);

		if (log.codigoEmpleado != -1) {
			this.codigoEmpleado = log.codigoEmpleado;
			if (log.tipoEmpleado == 0) {
				activarmenu(true);
			}else {
				activarmenu(false);
			}
		}
	}

	protected void actionPerformedMntmRegistrarPago(ActionEvent arg0) {
		DlgControlDePagos pag = new DlgControlDePagos();
		pag.setVisible(true);
	}

	protected void actionPerformedMntmPacientesAdmitidos(ActionEvent arg0) {
		DlgReportePacientesAdmitidos pac = new DlgReportePacientesAdmitidos();
		pac.setVisible(true);
	}

	protected void actionPerformedMntmHospitalizacionesPorFecha(ActionEvent arg0) {
		DlgReporteHospitalizacionesPorFecha hos = new DlgReporteHospitalizacionesPorFecha();
		hos.setVisible(true);
	}

	protected void actionPerformedMntmPacientespago(ActionEvent arg0) {
		DlgReportePacientesPagado pac = new DlgReportePacientesPagado();
		pac.setVisible(true);
	}

	protected void actionPerformedMntmEmpledadoshospitalizaciones(ActionEvent arg0) {
		DlgReporteEmpleadosHospitalizaciones emp = new DlgReporteEmpleadosHospitalizaciones();
		emp.setVisible(true);
	}

	// métodos void con parámetros
	void activarmenu(boolean dato) {
		mnMantenimiento.setEnabled(dato);
		mnHospitalización.setEnabled(true);
		mnRegistroDeConsumo.setEnabled(true);
		mnPago.setEnabled(true);
		mnReporte.setEnabled(dato);
		mntmIniciarSesin.setEnabled(false);
	}

	// MÉTODOS CON RETORNO SIN PARÁMETROS
	public int confirmacionDeSalida() {
		return JOptionPane.showConfirmDialog(this, "¿ Desea salir del programa ?", "Proyecto AED 2016 1", 2);
	}
}
