package ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Ejercicio2 {

	private JFrame frmRegistroDeAnimales;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 window = new Ejercicio2();
					window.frmRegistroDeAnimales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio2() {
		dibujar();
		gestionarEventos();
	}

	private void gestionarEventos() {
		frmRegistroDeAnimales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void dibujar() {
		frmRegistroDeAnimales = new JFrame();
		frmRegistroDeAnimales.setTitle("REGISTRO DE ANIMALES");
		frmRegistroDeAnimales.setIconImage(Toolkit.getDefaultToolkit().getImage(Ejercicio2.class.getResource("/ejercicio2/iconos/iconoapp.png")));
		frmRegistroDeAnimales.getContentPane().setBackground(new Color(220, 20, 60));
		frmRegistroDeAnimales.setBounds(100, 100, 945, 501);
		
		SpringLayout springLayout = new SpringLayout();
		frmRegistroDeAnimales.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frmRegistroDeAnimales.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frmRegistroDeAnimales.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 45, SpringLayout.NORTH, frmRegistroDeAnimales.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, frmRegistroDeAnimales.getContentPane());
		frmRegistroDeAnimales.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, frmRegistroDeAnimales.getContentPane());
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRegistroDeAnimales = new JLabel("REGISTRO DE ANIMALES");
		lblRegistroDeAnimales.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegistroDeAnimales.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRegistroDeAnimales);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frmRegistroDeAnimales.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, frmRegistroDeAnimales.getContentPane());
		frmRegistroDeAnimales.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, panel_1);
		panel_2.setBackground(new Color(220, 20, 60));
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 322, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 328, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 135, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, -10, SpringLayout.EAST, panel_1);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JPanel panel_4 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 29, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, 61, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, 312, SpringLayout.WEST, panel_2);
		panel_2.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("C??digo del animal:");
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, panel_4);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, textField);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Datos del animal");
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -7, SpringLayout.SOUTH, panel_4);
		panel_4.add(lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, panel_2);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre del animal:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, panel_4);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, panel_4);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Especie:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_2);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblRaza = new JLabel("Raza:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblRaza, 7, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblRaza, 0, SpringLayout.EAST, lblNewLabel_2);
		panel_2.add(lblRaza);
		
		JLabel lblSexo = new JLabel("Sexo:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblSexo, 17, SpringLayout.SOUTH, lblRaza);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblSexo, 0, SpringLayout.WEST, lblRaza);
		panel_2.add(lblSexo);
		
		JLabel lblPeso = new JLabel("Peso:");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblPeso, 77, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblPeso, 0, SpringLayout.EAST, lblNewLabel_2);
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblPeso);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblObservaciones, 10, SpringLayout.SOUTH, lblPeso);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblObservaciones, 0, SpringLayout.EAST, lblNewLabel_2);
		panel_2.add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		sl_panel_2.putConstraint(SpringLayout.WEST, textPane, 153, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, textPane, 0, SpringLayout.EAST, textField);
		panel_2.add(textPane);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de ingreso:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 80, SpringLayout.SOUTH, lblObservaciones);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_2);
		panel_2.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblNewLabel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, lblNewLabel_2);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, textField_2, -2, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel_2.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblNewLabel_3);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, textField_3, -2, SpringLayout.NORTH, lblRaza);
		sl_panel_2.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblRaza);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, textField_1);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, textPane, 8, SpringLayout.SOUTH, textField_6);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblPeso, 2, SpringLayout.NORTH, textField_6);
		sl_panel_2.putConstraint(SpringLayout.NORTH, textField_6, 6, SpringLayout.SOUTH, textField_5);
		sl_panel_2.putConstraint(SpringLayout.EAST, textField_6, 0, SpringLayout.EAST, textField_1);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		panel_1.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JPanel panel_5 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_5, 6, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_5, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_5, -10, SpringLayout.SOUTH, panel_3);
		panel_5.setBackground(Color.GREEN);
		panel_3.add(panel_5);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/guardar.png")));
		sl_panel_5.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -41, SpringLayout.SOUTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, panel_5);
		panel_5.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Nuevo");
		sl_panel_5.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 10, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -6, SpringLayout.NORTH, btnNewButton_1);
		sl_panel_5.putConstraint(SpringLayout.EAST, btnNewButton_1_1, 0, SpringLayout.EAST, btnNewButton_1);
		btnNewButton_1_1.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/nuevo.png")));
		panel_5.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Cancelar");
		btnNewButton_1_2.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/Cancelar.png")));
		sl_panel_5.putConstraint(SpringLayout.NORTH, btnNewButton_1_2, 6, SpringLayout.SOUTH, btnNewButton_1);
		sl_panel_5.putConstraint(SpringLayout.WEST, btnNewButton_1_2, 0, SpringLayout.WEST, btnNewButton_1);
		sl_panel_5.putConstraint(SpringLayout.EAST, btnNewButton_1_2, 0, SpringLayout.EAST, btnNewButton_1);
		panel_5.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_5, -6, SpringLayout.WEST, lblNewLabel_5);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel_5, -236, SpringLayout.EAST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_5, 161, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 115, SpringLayout.NORTH, panel_3);
		lblNewLabel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_6, 34, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_6, 6, SpringLayout.EAST, lblNewLabel_5);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_6, 0, SpringLayout.SOUTH, panel_5);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_6, -10, SpringLayout.EAST, panel_3);
		panel_6.setBackground(Color.GREEN);
		panel_3.add(panel_6);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Seleccionar imagen");
		sl_panel_6.putConstraint(SpringLayout.EAST, btnNewButton_1_2_1_1, -10, SpringLayout.EAST, panel_6);
		btnNewButton_1_2_1_1.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/Seleccionar.png")));
		sl_panel_6.putConstraint(SpringLayout.NORTH, btnNewButton_1_2_1_1, 10, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, btnNewButton_1_2_1_1, 10, SpringLayout.WEST, panel_6);
		panel_6.add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_1_3 = new JButton("Guardar");
		btnNewButton_1_3.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/guardar.png")));
		sl_panel_6.putConstraint(SpringLayout.NORTH, btnNewButton_1_3, 6, SpringLayout.SOUTH, btnNewButton_1_2_1_1);
		sl_panel_6.putConstraint(SpringLayout.WEST, btnNewButton_1_3, 0, SpringLayout.WEST, btnNewButton_1_2_1_1);
		sl_panel_6.putConstraint(SpringLayout.EAST, btnNewButton_1_3, 0, SpringLayout.EAST, btnNewButton_1_2_1_1);
		panel_6.add(btnNewButton_1_3);
		
		JPanel panel_7 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_7, 3, SpringLayout.SOUTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_7, 10, SpringLayout.WEST, panel_3);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_7, 39, SpringLayout.SOUTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_7, -10, SpringLayout.EAST, panel_3);
		panel_7.setBackground(new Color(220, 20, 60));
		panel_1.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Buscar");
		sl_panel_7.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 10, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, lblNewLabel_6, 10, SpringLayout.WEST, panel_7);
		panel_7.add(lblNewLabel_6);
		
		textField_7 = new JTextField();
		sl_panel_7.putConstraint(SpringLayout.NORTH, textField_7, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel_7.putConstraint(SpringLayout.WEST, textField_7, 6, SpringLayout.EAST, lblNewLabel_6);
		panel_7.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Salir");
		sl_panel_7.putConstraint(SpringLayout.NORTH, btnNewButton, -7, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel_7.putConstraint(SpringLayout.WEST, btnNewButton, -106, SpringLayout.EAST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, panel_7);
		btnNewButton.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/salir.png")));
		panel_7.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		sl_panel_7.putConstraint(SpringLayout.NORTH, btnNewButton_2, -7, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel_7.putConstraint(SpringLayout.EAST, btnNewButton_2, -6, SpringLayout.WEST, btnNewButton);
		btnNewButton_2.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/borrar.png")));
		panel_7.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Buscar");
		sl_panel_7.putConstraint(SpringLayout.WEST, btnNewButton_2, 6, SpringLayout.EAST, btnNewButton_2_1);
		sl_panel_7.putConstraint(SpringLayout.EAST, textField_7, -6, SpringLayout.WEST, btnNewButton_2_1);
		sl_panel_7.putConstraint(SpringLayout.WEST, btnNewButton_2_1, -342, SpringLayout.EAST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, btnNewButton_2_1, -238, SpringLayout.EAST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.NORTH, btnNewButton_2_1, -7, SpringLayout.NORTH, lblNewLabel_6);
		btnNewButton_2_1.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/buscar.png")));
		panel_7.add(btnNewButton_2_1);
		
		table = new JTable();
		sl_panel_1.putConstraint(SpringLayout.NORTH, table, 6, SpringLayout.SOUTH, panel_7);
		sl_panel_1.putConstraint(SpringLayout.WEST, table, 342, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, table, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, table, -20, SpringLayout.EAST, panel_1);
		
		textField_4 = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.SOUTH, textPane, -6, SpringLayout.NORTH, textField_4);
		sl_panel_2.putConstraint(SpringLayout.NORTH, textField_4, 325, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, textField_4, -114, SpringLayout.EAST, textField_1);
		sl_panel_2.putConstraint(SpringLayout.EAST, textField_4, -15, SpringLayout.EAST, textField_1);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("");
		sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_3, 6, SpringLayout.SOUTH, textPane);
		sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_3, 6, SpringLayout.EAST, textField_4);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 26, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel_2.putConstraint(SpringLayout.EAST, btnNewButton_3, 149, SpringLayout.WEST, textPane);
		btnNewButton_3.setIcon(new ImageIcon(Ejercicio2.class.getResource("/ejercicio2/iconos/calendario.png")));
		panel_2.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
		sl_panel_2.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.SOUTH, textField_3);
		sl_panel_2.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblSexo);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, comboBox, -15, SpringLayout.NORTH, textField_5);
		sl_panel_2.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, textField_1);
		comboBox.setPreferredSize(new Dimension(19, 5));
		panel_2.add(comboBox);
		
		JLabel lblEdadaprox = new JLabel("Edad (aprox.):");
		sl_panel_2.putConstraint(SpringLayout.NORTH, textField_5, -2, SpringLayout.NORTH, lblEdadaprox);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblEdadaprox, 21, SpringLayout.SOUTH, lblSexo);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblEdadaprox, 0, SpringLayout.EAST, lblNewLabel_2);
		panel_2.add(lblEdadaprox);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"NOMBRE", "ESPECIE", "RAZA", "SEXO", "EDAD", "PESO", "OBSERVACIONES", null},
				{"Sua", "Perro", null, "Macho", "8", null, "Operacion prevista", "30/09/2021"},
			},
			new String[] {
				"NOMBRE", "ESPECIE", "RAZA", "SEXO", "EDAD", "PESO", "OBSERVACIONES", "FECHA"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		panel_1.add(table);
	}
}
