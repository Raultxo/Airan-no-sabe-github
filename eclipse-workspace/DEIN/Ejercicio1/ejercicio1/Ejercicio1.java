package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.ComponentOrientation;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.ScrollPaneConstants;

public class Ejercicio1 {

	private JFrame frmEncuesta;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 window = new Ejercicio1();
					window.frmEncuesta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio1() {
		dibujar();
		eventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void dibujar() {
		frmEncuesta = new JFrame();
		frmEncuesta.setTitle("ENCUESTA");
		frmEncuesta.setBounds(100, 100, 663, 553);
		
		frmEncuesta.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		frmEncuesta.getContentPane().add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Aceptar");
		panelSur.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panelSur.add(btnNewButton_1);
		
		JPanel panelNorte = new JPanel();
		frmEncuesta.getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panelNorte.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Profesi\u00F3n:");
		lblNewLabel_2.setPreferredSize(new Dimension(100, 14));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_2, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new MigLayout("", "[547px]", "[55px]"));
		
		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField.setPreferredSize(new Dimension(80, 20));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(40);
		panel_6.add(textField, "cell 0 0,growx,aligny center");
		
		JPanel panel_1 = new JPanel();
		panelNorte.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_4.add(panel_14);
		SpringLayout sl_panel_14 = new SpringLayout();
		panel_14.setLayout(sl_panel_14);
		
		JLabel lblNewLabel_1 = new JLabel("Nº Hermanos:");
		sl_panel_14.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 20, SpringLayout.NORTH, panel_14);
		sl_panel_14.putConstraint(SpringLayout.WEST, lblNewLabel_1, 40, SpringLayout.WEST, panel_14);
		sl_panel_14.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -17, SpringLayout.SOUTH, panel_14);
		sl_panel_14.putConstraint(SpringLayout.EAST, lblNewLabel_1, -4, SpringLayout.EAST, panel_14);
		panel_14.add(lblNewLabel_1);
		lblNewLabel_1.setPreferredSize(new Dimension(120, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		SpringLayout sl_panel_12 = new SpringLayout();
		panel_12.setLayout(sl_panel_12);
		
		JSpinner spinner = new JSpinner();
		sl_panel_12.putConstraint(SpringLayout.NORTH, spinner, 26, SpringLayout.NORTH, panel_12);
		sl_panel_12.putConstraint(SpringLayout.WEST, spinner, 0, SpringLayout.WEST, panel_12);
		sl_panel_12.putConstraint(SpringLayout.SOUTH, spinner, -21, SpringLayout.SOUTH, panel_12);
		sl_panel_12.putConstraint(SpringLayout.EAST, spinner, 107, SpringLayout.WEST, panel_12);
		panel_12.add(spinner);
		spinner.setSize(new Dimension(50, 0));
		spinner.setPreferredSize(new Dimension(80, 30));
		spinner.setMinimumSize(new Dimension(50, 20));
		spinner.setBounds(new Rectangle(0, 0, 50, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15);
		SpringLayout sl_panel_15 = new SpringLayout();
		panel_15.setLayout(sl_panel_15);
		
		JLabel lblNewLabel = new JLabel("Edad:");
		sl_panel_15.putConstraint(SpringLayout.NORTH, lblNewLabel, 16, SpringLayout.NORTH, panel_15);
		sl_panel_15.putConstraint(SpringLayout.WEST, lblNewLabel, 43, SpringLayout.WEST, panel_15);
		sl_panel_15.putConstraint(SpringLayout.SOUTH, lblNewLabel, -21, SpringLayout.SOUTH, panel_15);
		sl_panel_15.putConstraint(SpringLayout.EAST, lblNewLabel, -1, SpringLayout.EAST, panel_15);
		panel_15.add(lblNewLabel);
		lblNewLabel.setPreferredSize(new Dimension(120, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		SpringLayout sl_panel_13 = new SpringLayout();
		panel_13.setLayout(sl_panel_13);
		
		JComboBox comboBox = new JComboBox();
		sl_panel_13.putConstraint(SpringLayout.NORTH, comboBox, 16, SpringLayout.NORTH, panel_13);
		sl_panel_13.putConstraint(SpringLayout.WEST, comboBox, 3, SpringLayout.WEST, panel_13);
		sl_panel_13.putConstraint(SpringLayout.SOUTH, comboBox, -21, SpringLayout.SOUTH, panel_13);
		sl_panel_13.putConstraint(SpringLayout.EAST, comboBox, -11, SpringLayout.EAST, panel_13);
		panel_13.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70"}));
		comboBox.setSize(new Dimension(80, 0));
		comboBox.setPreferredSize(new Dimension(200, 30));
		comboBox.setMinimumSize(new Dimension(80, 22));
		
		JPanel panel_3 = new JPanel();
		panelNorte.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		panel_5.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
		panel_5.add(rdbtnNewRadioButton_1);
		
		ButtonGroup grupoRadios = new ButtonGroup();
		grupoRadios.add(rdbtnNewRadioButton_1);
		grupoRadios.add(rdbtnNewRadioButton);
		
		JPanel panel_11 = new JPanel();
		panelNorte.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u00BFPr\u00E1ctica alg\u00FAn deporte?");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(chckbxNewCheckBox);
		
		JPanel panel_16 = new JPanel();
		panel_11.add(panel_16);
		SpringLayout sl_panel_16 = new SpringLayout();
		panel_16.setLayout(sl_panel_16);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_16.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, panel_16);
		sl_panel_16.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, panel_16);
		scrollPane.setViewportBorder(new TitledBorder(null, "\u00BFC\u00FAal?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sl_panel_16.putConstraint(SpringLayout.WEST, scrollPane, 51, SpringLayout.WEST, panel_16);
		sl_panel_16.putConstraint(SpringLayout.EAST, scrollPane, -39, SpringLayout.EAST, panel_16);
		panel_16.add(scrollPane);
		
		JList list = new JList();
		list.setVisibleRowCount(2);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Tenis", "Fútbol", "Baloncesto", "Natación", "Ciclismo", "Otro"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JPanel panelCentro = new JPanel();
		frmEncuesta.getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panelCentro.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Marque del 1 al 10 su grado de aficci\u00F3n a:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_8 = new JPanel();
		panelCentro.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Compras:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setPreferredSize(new Dimension(120, 14));
		panel_8.add(lblNewLabel_4, BorderLayout.WEST);
		
		JSlider slider = new JSlider();
		slider.setToolTipText("kkkkkkkkk");
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setValue(5);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(10);
		panel_8.add(slider);
		
		JPanel panel_9 = new JPanel();
		panelCentro.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Ver televisi\u00F3n:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setPreferredSize(new Dimension(120, 14));
		panel_9.add(lblNewLabel_5, BorderLayout.WEST);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(5);
		slider_1.setMinimum(1);
		slider_1.setMajorTickSpacing(1);
		slider_1.setMaximum(10);
		slider_1.setMinorTickSpacing(1);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		panel_9.add(slider_1);
		
		JPanel panel_10 = new JPanel();
		panelCentro.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Ir al cine:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setPreferredSize(new Dimension(120, 14));
		panel_10.add(lblNewLabel_6, BorderLayout.WEST);
		
		JSlider slider_2 = new JSlider();
		slider_2.setMajorTickSpacing(1);
		slider_2.setMinorTickSpacing(1);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setValue(5);
		slider_2.setMaximum(10);
		slider_2.setMinimum(1);
		panel_10.add(slider_2);
	}
	
	private void eventos() {
		frmEncuesta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	


}
