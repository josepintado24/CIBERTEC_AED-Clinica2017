package gui;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloCamas;
import arreglos.ArregloHospitalizacion;
import arreglos.ArregloPaciente;
import clases.Camas;
import clases.Internamiento;
import clases.Paciente;
import libreria.Libreria;
import java.awt.Color;
import java.awt.Font;

public class DlgReportePacientesAdmitidos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable jtblPacientes;
	private DefaultTableModel dtm;

	// DECLARACIÓN GLOBAL DE ARREGLOS HOSPITALIZACIÓN, CAMA Y PACIENTES
	ArregloPaciente ap = new ArregloPaciente("pacientes.txt");
	ArregloCamas ac = new ArregloCamas("camas.txt");
	ArregloHospitalizacion ah = new ArregloHospitalizacion("hospitalizaciones.txt");

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			DlgReportePacientesAdmitidos dialog = new DlgReportePacientesAdmitidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgReportePacientesAdmitidos() {
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 826, 553);
		setTitle("PACIENTES ADMITIDOS");
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 799, 503);
		getContentPane().add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblPacientes = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}

		};
		jtblPacientes.setFont(new Font("Arial", Font.BOLD, 14));
		jtblPacientes.setForeground(Color.BLACK);
		jtblPacientes.setRowHeight(25);
		jtblPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtblPacientes);

		formatoTabla();
		listadoPacientes();

		setLocationRelativeTo(this);
	}

	// MÉTODOS VOID SIN PARÁMETROS
	void formatoTabla() {
		TableColumnModel tc = jtblPacientes.getColumnModel();
		tc.getColumn(0).setPreferredWidth(50);
		tc.getColumn(1).setPreferredWidth(150);
		tc.getColumn(2).setPreferredWidth(150);
		tc.getColumn(3).setPreferredWidth(50);
		tc.getColumn(4).setPreferredWidth(100);
		tc.getColumn(5).setPreferredWidth(100);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
		tc.getColumn(3).setCellRenderer(tcr);
		tc.getColumn(4).setCellRenderer(tcr);

		tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		tc.getColumn(5).setCellRenderer(tcr);
	}

	void listadoPacientes() {
		Internamiento h;
		for (int i = 0; i < ah.tamaño(); i++) {

			h = ah.obtener(i);
			if (h.getEstado() == 1) {
				Paciente p;
				for (int j = 0; j < ap.tamaño(); j++) {

					p = ap.obtener(j);
					if (p.getCodpaciente() == h.getCodPaci()) {

						Camas c;
						for (int j2 = 0; j2 < ac.tamaño(); j2++) {
							c = ac.obtener(j2);
							if (c.getNroCama() == h.getNumCama()) {
								dtm.addRow(new Object[] { p.getCodpaciente(), p.getNombres().toUpperCase(),
										p.getApellidos().toUpperCase(), h.getNumCama(), getCategoria(c.getCategoria()),
										Libreria.formato2Decimales(c.getPrecioxDia()) });
							}
						}

					}

				}
			}
		}
	}

	// MÉTODOS CON RETORNO SIN PARÁMETROS
	String[] getColumnas() {
		String columnas[] = new String[] { "CÓDIGO", "NOMBRES", "APELLIDOS", "NRO CAMA", "CATEGORÍA",
				"PRECIO POR DÍA" };
		return columnas;
	}

	// MÉTODOS CON RETORNO CON PARÁMETROS
	String getCategoria(int est) {
		if (est == 0) {
			return "ECONÓMICO";
		}
		else {
			return "EJECUTIVO";
		}
	}
}
