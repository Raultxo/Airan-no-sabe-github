package ventanas;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestion.GestionAeropuerto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import beans.Aeropuerto;
import beans.AeropuertoPrivado;
import beans.AeropuertoPublico;
import beans.Direccion;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtBusqueda;
	private JTable table;
	private GestionAeropuerto gestionAeropuerto;
	private JRadioButton rdbtnPrivados, rdbtnPublicos;
	boolean privado;
	private JMenuBar menuBar;
	private JMenu menuAerupuertos;
	private JPanel panelPrincipal, panelNorte;
	private JMenuItem itemAniadir1, itemEditar;
	private JMenu menuAviones;
	private JMenuItem itemBorrar1, itemMostrar, itemAniadir2, itemActivar, itemBorrar2;
	private JMenu menuAyuda;
	
	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		
		gestionAeropuerto = new GestionAeropuerto();
		
		initialize();
		gestionarEventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("AVIONES - GESTIÓN DE AEROPUERTOS");
		this.setBounds(100, 100, 1017, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		ButtonGroup bg = new ButtonGroup();
		
		menuBar = new JMenuBar();
		this.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		menuAerupuertos = new JMenu("Aeropuertos");
		menuBar.add(menuAerupuertos);
		
		itemAniadir1 = new JMenuItem("Añadir");
		menuAerupuertos.add(itemAniadir1);
		
		itemEditar = new JMenuItem("Editar");
		menuAerupuertos.add(itemEditar);
		
		itemBorrar1 = new JMenuItem("Borrar");
		menuAerupuertos.add(itemBorrar1);
		
		itemMostrar = new JMenuItem("Mostrar información");
		menuAerupuertos.add(itemMostrar);
		
		menuAviones = new JMenu("Aviones");
		menuBar.add(menuAviones);
		
		itemAniadir2 = new JMenuItem("Añadir");
		menuAviones.add(itemAniadir2);
		
		itemActivar = new JMenuItem("Activar");
		menuAviones.add(itemActivar);
		
		itemBorrar2 = new JMenuItem("Borrar");
		menuAviones.add(itemBorrar2);
		
		menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		panelPrincipal = new JPanel();
		this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelNorte = new JPanel();
		panelPrincipal.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorteNorte = new JPanel();
		
		panelNorte.add(panelNorteNorte, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("LISTADO DE AEROPUERTOS");
		panelNorteNorte.add(lblTitulo);
		
		JPanel panelNorteOeste = new JPanel();
		panelNorte.add(panelNorteOeste, BorderLayout.WEST);
		panelNorteOeste.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rdbtnPrivados = new JRadioButton("Privados");
		panelNorteOeste.add(rdbtnPrivados);
		bg.add(rdbtnPrivados);
		
		rdbtnPublicos = new JRadioButton("Publicos");
		panelNorteOeste.add(rdbtnPublicos);
		bg.add(rdbtnPublicos);
		rdbtnPublicos.setSelected(true);
		
		JPanel panelNorteEste = new JPanel();
		panelNorte.add(panelNorteEste, BorderLayout.EAST);
		GridBagLayout gbl_panelNorteEste = new GridBagLayout();
		gbl_panelNorteEste.columnWidths = new int[]{0, 200, 0};
		gbl_panelNorteEste.rowHeights = new int[]{0, 0};
		gbl_panelNorteEste.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelNorteEste.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelNorteEste.setLayout(gbl_panelNorteEste);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panelNorteEste.add(lblNombre, gbc_lblNombre);
		
		txtBusqueda = new JTextField();
		
		GridBagConstraints gbc_txtBusqueda = new GridBagConstraints();
		gbc_txtBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBusqueda.gridx = 1;
		gbc_txtBusqueda.gridy = 0;
		panelNorteEste.add(txtBusqueda, gbc_txtBusqueda);
		txtBusqueda.setColumns(10);
		
		table = new JTable();
		panelPrincipal.add(table, BorderLayout.CENTER);
		DefaultTableModel modelo = modeloPublico("");
		table.setModel(modelo);
		privado = false;
		this.pack();
		this.setVisible(true);
	}
	
	private void gestionarEventos() {

		rdbtnPrivados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(modeloPrivado(""));
				privado = true;
			}
		});
		rdbtnPublicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(modeloPublico(""));
				privado = false;
			}
		});
		
		txtBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(privado) {
					table.setModel(modeloPrivado(txtBusqueda.getText()));
				}
				else {		
					table.setModel(modeloPublico(txtBusqueda.getText()));
				}
			}
		});
		
		itemAniadir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AniadirEditarAeropuerto dialogoAniadir = new AniadirEditarAeropuerto(true);
				dialogoAniadir.setVisible(true);
				
			}
		});
		itemEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Tienes que seleccionar un aeropuerto");
				}
				else {
					AniadirEditarAeropuerto dialogoAniadir;
					if(privado) {
						AeropuertoPrivado prueba = new AeropuertoPrivado(new Aeropuerto(1, "prueba", 1, 1, new Direccion(1, "prueba", "prueba", "prueba", 1)), 1);
						dialogoAniadir = new AniadirEditarAeropuerto(false, prueba);
						
					}
					else {
						AeropuertoPublico prueba = new AeropuertoPublico(new Aeropuerto(1, "prueba", 1, 1, new Direccion(1, "prueba", "prueba", "prueba", 1)), 1, 1);
						dialogoAniadir = new AniadirEditarAeropuerto(true, prueba);
					}
					dialogoAniadir.setVisible(true);
				}	
			}
		});
	}
	
	private DefaultTableModel modeloPublico(String nombreAer) {
		ArrayList<AeropuertoPublico> aeropuertos = gestionAeropuerto.aeropuertosPublicos(nombreAer);
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
					{"ID", "NOMBRE", "PAIS", "NUMERO", "CALLE", "CIUDAD", "A\u00D1O DE INAUGURACION", "CAPACIDAD", "NUMERO DE TRABAJADORES", "FINANCIACION"},
				},
				new String[] {
					"ID", "NOMBRE", "PAIS", "NUMERO", "CALLE", "CIUDAD", "ANIO", "CAPACIDAD", "NUMTRABAJADORES", "FINANCIACION"
				}
			) {

				private static final long serialVersionUID = 1L;	
		};
		
		if(aeropuertos != null) {
			for(int i = 0; i < aeropuertos.size(); i++) {
				modelo.addRow(new String[] 
				{
					String.valueOf(aeropuertos.get(i).getAeropuerto().getId()),
					aeropuertos.get(i).getAeropuerto().getNombre(),
					aeropuertos.get(i).getAeropuerto().getDireccion().getPais(),
					String.valueOf(aeropuertos.get(i).getAeropuerto().getDireccion().getNumero()),
					aeropuertos.get(i).getAeropuerto().getDireccion().getCalle(),
					aeropuertos.get(i).getAeropuerto().getDireccion().getCiudad(),
					String.valueOf(aeropuertos.get(i).getAeropuerto().getAnioInauguracion()),
					String.valueOf(aeropuertos.get(i).getAeropuerto().getCapacidad()),
					String.valueOf(aeropuertos.get(i).getNum_trabajadores()),
					String.valueOf(aeropuertos.get(i).getFinanciacion())
				});
			}
		}

		return modelo;
	}
	
	private DefaultTableModel modeloPrivado(String nombreAer) {
		ArrayList<AeropuertoPrivado> aeropuertos = gestionAeropuerto.aeropuertosPrivados(nombreAer);
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
					{"ID", "NOMBRE", "PAIS", "NUMERO", "CALLE", "CIUDAD", "A\u00D1O DE INAUGURACION", "CAPACIDAD", "NUMERO DE SOCIOS"},
				},
				new String[] {
					"ID", "NOMBRE", "PAIS", "NUMERO", "CALLE", "CIUDAD", "ANIO", "CAPACIDAD", "NUMSOCIOS"
				}
			) {

				private static final long serialVersionUID = 1L;	
		};
		
		if(aeropuertos != null) {
			for(int i = 0; i < aeropuertos.size(); i++) {
				modelo.addRow(new String[] 
				{
					String.valueOf(aeropuertos.get(i).getAeropuerto().getId()),
					aeropuertos.get(i).getAeropuerto().getNombre(),
					aeropuertos.get(i).getAeropuerto().getDireccion().getPais(),
					String.valueOf(aeropuertos.get(i).getAeropuerto().getDireccion().getNumero()),
					aeropuertos.get(i).getAeropuerto().getDireccion().getCalle(),
					aeropuertos.get(i).getAeropuerto().getDireccion().getCiudad(),
					String.valueOf(aeropuertos.get(i).getAeropuerto().getAnioInauguracion()),
					String.valueOf(aeropuertos.get(i).getAeropuerto().getCapacidad()),
					String.valueOf(aeropuertos.get(i).getNum_socios())
				});
			}
		}
		
		return modelo;
	}

}
