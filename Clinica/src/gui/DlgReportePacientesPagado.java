package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloConsumo;
import arreglos.ArregloHospitalizacion;
import arreglos.ArregloPaciente;
import clases.Atencion;
import clases.Internamiento;
import clases.Paciente;
import libreria.Fecha;
import libreria.Libreria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgReportePacientesPagado extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable jtblPagoDePacientes;
	private JLabel lblFechaLlegada;
	private JComboBox<String> cboDia;
	private JComboBox<String> cboMes;
	private JComboBox<String> cboAño;
	private JButton btnBuscar;

	private DefaultTableModel dtm;

	// DECLARACIÓN GLOBAL DE ARREGLOS
	ArregloPaciente ap = new ArregloPaciente("pacientes.txt");
	ArregloConsumo ac = new ArregloConsumo("consumos.txt");
	ArregloHospitalizacion ah = new ArregloHospitalizacion("hospitalizaciones.txt");

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			DlgReportePacientesPagado dialog = new DlgReportePacientesPagado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgReportePacientesPagado() {
		setResizable(false);
		setModal(true);
		getContentPane().setBackground(Color.WHITE);
		setTitle("BÚSQUEDA DE PAGO DE PACIENTES");
		setBounds(100, 100, 688, 423);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 662, 324);
		getContentPane().add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblPagoDePacientes = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};
		jtblPagoDePacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtblPagoDePacientes.setFont(new Font("Arial", Font.BOLD, 14));
		scrollPane.setViewportView(jtblPagoDePacientes);

		lblFechaLlegada = new JLabel("FECHA LLEGADA");
		lblFechaLlegada.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaLlegada.setForeground(Color.BLACK);
		lblFechaLlegada.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		lblFechaLlegada.setBounds(10, 18, 103, 14);
		getContentPane().add(lblFechaLlegada);

		cboDia = new JComboBox<String>();
		cboDia.setForeground(Color.BLACK);
		cboDia.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboDia.setBounds(123, 6, 59, 38);
		Fecha.colocarItems(cboDia, 1, 31);
		Fecha.colocarDiaActual(cboDia);
		getContentPane().add(cboDia);

		cboMes = new JComboBox<String>();
		cboMes.setForeground(Color.BLACK);
		cboMes.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboMes.setBounds(183, 6, 116, 38);
		Fecha.colocarMeses(cboMes);
		Fecha.colocarMesActual(cboMes);
		getContentPane().add(cboMes);

		cboAño = new JComboBox<String>();
		cboAño.setForeground(Color.BLACK);
		cboAño.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		cboAño.setBounds(300, 6, 83, 38);
		Fecha.colocarItems(cboAño, 2000, Fecha.añoActual());
		cboAño.setSelectedIndex(16);
		getContentPane().add(cboAño);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 14));
		btnBuscar.setBounds(393, 6, 149, 38);
		getContentPane().add(btnBuscar);

		modeloTabla();
		listar(0);

		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		listar(Fecha.getFecha(cboDia, cboMes, cboAño));
	}

	// MÉTODOS VOID CON PARÁMETROS
	void listar(int fecha) {
		Libreria.limpiarJTable(jtblPagoDePacientes, dtm);
		Internamiento h;
		for (int i = 0; i < ah.tamaño(); i++) {
			h = ah.obtener(i);

			if (h.getEstado() == 2) {

				Paciente p;
				for (int j = 0; j < ap.tamaño(); j++) {
					p = ap.obtener(j);

					if (h.getCodPaci() == p.getCodpaciente()) {

						Atencion c;
						for (int j2 = 0; j2 < ac.tamaño(); j2++) {
							c = ac.obtener(j2);
							if (c.getEstado() == 1) {
								if (c.getCodPaciente() == p.getCodpaciente()) {
									if (fecha != 0) {
										if (h.getFecSali() == fecha) {
											dtm.addRow(new Object[] { c.getCodConsumo(), p.getApellidos().toUpperCase(),
													p.getNombres().toUpperCase(),
													Libreria.formato2Decimales(c.getTotalPago()) });
										}
									}
									else {
										dtm.addRow(new Object[] { c.getCodConsumo(), p.getApellidos().toUpperCase(),
												p.getNombres().toUpperCase(),
												Libreria.formato2Decimales(c.getTotalPago()) });
									}
								}
							}
						}
					}
				}
			}
		}
	}

	// MÉTODOS VOID SIN PARÁMETROS
	void modeloTabla() {
		TableColumnModel tc = jtblPagoDePacientes.getColumnModel();
		tc.getColumn(0).setPreferredWidth(70);
		tc.getColumn(1).setPreferredWidth(150);
		tc.getColumn(2).setPreferredWidth(150);
		tc.getColumn(3).setPreferredWidth(50);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);

		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tc.getColumn(3).setCellRenderer(tcr);
	}

	// MÉTODOS CON RETORNO SIN PARÁMETROS
	String[] getColumnas() {
		String columnas[] = new String[] { "CÓDIGO CONSUMO", "APELLIDOS PACIENTE", "NOMBRES PACIENTE",
				"TOTAL A PAGAR" };
		return columnas;
	}
}
