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

import arreglos.ArregloEmpleado;
import arreglos.ArregloHospitalizacion;
import clases.Empleado;
import clases.Internamiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;

public class DlgReporteEmpleadosHospitalizaciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable jtblEmpleados;
	private DefaultTableModel dtm;
	private int x;
	private int y;

	// DECLARACI�N GLOBAL DE ARREGLOS HOSPITALIZACI�N
	ArregloEmpleado ae = new ArregloEmpleado("empleados.txt");
	ArregloHospitalizacion ah = new ArregloHospitalizacion("hospitalizaciones.txt");

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			DlgReporteEmpleadosHospitalizaciones dialog = new DlgReporteEmpleadosHospitalizaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteEmpleadosHospitalizaciones() {
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 826, 611);
		setTitle("EMPLEADOS QUE REALIZARON HOSPITALIZACIONES");
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLACK, 1, true));
		scrollPane.setBounds(10, 50, 806, 550);
		getContentPane().add(scrollPane);

		dtm = new DefaultTableModel(null, getColumnas());
		jtblEmpleados = new JTable(dtm) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}

		};
		jtblEmpleados.setBorder(null);
		jtblEmpleados.setFont(new Font("Arial", Font.BOLD, 14));
		jtblEmpleados.setForeground(Color.BLACK);
		jtblEmpleados.setRowHeight(25);
		jtblEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtblEmpleados);
		
		JPanel panel = new JPanel();
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
		panel.setBounds(0, 0, 826, 39);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
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
		label.setIcon(new ImageIcon(DlgReporteEmpleadosHospitalizaciones.class.getResource("/image/icons8_Return_32px.png")));
		label.setBounds(787, 0, 39, 39);
		panel.add(label);
		
		JLabel lblReporteEmpleados = new JLabel("Reporte Empleados");
		lblReporteEmpleados.setFont(new Font("Decker", Font.PLAIN, 16));
		lblReporteEmpleados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblReporteEmpleados.setBounds(39, 0, 192, 39);
		panel.add(lblReporteEmpleados);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(DlgReporteEmpleadosHospitalizaciones.class.getResource("/image/analytics.png")));
		label_1.setBounds(10, 0, 25, 39);
		panel.add(label_1);

		formatoTabla();
		listadoPacientes();

		setLocationRelativeTo(this);
	}

	// M�TODOS VOID SIN PAR�METROS
	void formatoTabla() {
		TableColumnModel tc = jtblEmpleados.getColumnModel();
		tc.getColumn(0).setPreferredWidth(50);
		tc.getColumn(1).setPreferredWidth(150);
		tc.getColumn(2).setPreferredWidth(150);
		tc.getColumn(3).setPreferredWidth(50);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tc.getColumn(0).setCellRenderer(tcr);
		tc.getColumn(3).setCellRenderer(tcr);
	}

	void listadoPacientes() {

		Empleado e;
		for (int j = 0; j < ae.tama�o(); j++) {
			e = ae.obtener(j);

			Internamiento h;
			for (int j2 = 0; j2 < ah.tama�o(); j2++) {
				h = ah.obtener(j2);

				if (h.getCodEmpl() == e.getCodEmpleado()) {
					if (jtblEmpleados.getRowCount() == 0 ){
						dtm.addRow(new Object[] { e.getCodEmpleado(), e.getNombres().toUpperCase(),
								e.getApellidos().toUpperCase(), getTipoEmpleado(e.getTipoEmpleado()) });	
					}else {
						int c = 0;
						for (int i = 0; i < jtblEmpleados.getRowCount(); i++) {
							if (e.getCodEmpleado() == Integer.parseInt(jtblEmpleados.getValueAt(i, 0).toString())){
								c++;
								break;
							}
						}
						
						if (c == 0) {
							dtm.addRow(new Object[] { e.getCodEmpleado(), e.getNombres().toUpperCase(),
									e.getApellidos().toUpperCase(), getTipoEmpleado(e.getTipoEmpleado()) });
						}
					}
				}
			}
		}

	}

	// M�TODOS CON RETORNO SIN PAR�METROS
	String[] getColumnas() {
		String columnas[] = new String[] { "C�DIGO EMPLEADO", "NOMBRES", "APELLIDOS", "TIPO" };
		return columnas;
	}

	// M�TODOS CON RETORNO CON PAR�METROS
	String getTipoEmpleado(int tipo) {
		if (tipo == 0) {
			return "ADMINISTRADOR";
		}
		else {
			return "CAJERO";
		}
	}

}
