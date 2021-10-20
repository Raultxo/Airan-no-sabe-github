package dialogosGestion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tablas.Deportista;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import javax.swing.JCheckBox;

public class DialogoDeportistas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton, cancelButton;
	private Deportista deportista;
	private JLabel lblTitulo, lblNombre, lblPeso, lblAltura;
	private JRadioButton rdbtnHombre, rdbtnMujer;
	private JTextField txtNombre;
	private JSpinner spinPeso, spinAltura;
	private JCheckBox checkPeso, checkAltura;
	
	public DialogoDeportistas() {
		setResizable(false);
		deportista = null;
		dibujar();
		cargarDatos();
		gestionarEventos();
		
	}
	public DialogoDeportistas(Deportista deportista) {
		this.deportista = deportista;
		dibujar();
		cargarDatos();
		gestionarEventos();
		
	}
	
	private void dibujar() {
		setBounds(100, 100, 450, 192);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 97, 234, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		lblTitulo = new JLabel("");
		lblTitulo.setBorder(new EmptyBorder(0, 0, 5, 0));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPanel.add(lblTitulo, gbc_lblTitulo);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPanel.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		contentPanel.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		ButtonGroup bg = new ButtonGroup();
		
		rdbtnHombre = new JRadioButton("Hombre");
		GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
		gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHombre.gridx = 0;
		gbc_rdbtnHombre.gridy = 2;
		contentPanel.add(rdbtnHombre, gbc_rdbtnHombre);
		bg.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
		gbc_rdbtnMujer.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMujer.gridx = 1;
		gbc_rdbtnMujer.gridy = 2;
		contentPanel.add(rdbtnMujer, gbc_rdbtnMujer);
		bg.add(rdbtnMujer);
		
		lblPeso = new JLabel("Peso");
		GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.gridx = 0;
		gbc_lblPeso.gridy = 3;
		contentPanel.add(lblPeso, gbc_lblPeso);
		
		spinPeso = new JSpinner();
		spinPeso.setPreferredSize(new Dimension(80, 20));
		spinPeso.setModel(new SpinnerNumberModel(70, 50, 200, 1));
		GridBagConstraints gbc_spinPeso = new GridBagConstraints();
		gbc_spinPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinPeso.insets = new Insets(0, 0, 5, 5);
		gbc_spinPeso.gridx = 1;
		gbc_spinPeso.gridy = 3;
		contentPanel.add(spinPeso, gbc_spinPeso);
		JFormattedTextField tf = ((JSpinner.DefaultEditor) spinPeso.getEditor()).getTextField();
		tf.setEditable(false);
		
		checkPeso = new JCheckBox("Peso desconocido");
		GridBagConstraints gbc_checkPeso = new GridBagConstraints();
		gbc_checkPeso.anchor = GridBagConstraints.WEST;
		gbc_checkPeso.insets = new Insets(0, 0, 5, 0);
		gbc_checkPeso.gridx = 2;
		gbc_checkPeso.gridy = 3;
		contentPanel.add(checkPeso, gbc_checkPeso);
		
		lblAltura = new JLabel("Altura");
		GridBagConstraints gbc_lblAltura = new GridBagConstraints();
		gbc_lblAltura.insets = new Insets(0, 0, 0, 5);
		gbc_lblAltura.gridx = 0;
		gbc_lblAltura.gridy = 4;
		contentPanel.add(lblAltura, gbc_lblAltura);
		
		spinAltura = new JSpinner();
		spinAltura.setPreferredSize(new Dimension(80, 20));
		spinAltura.setModel(new SpinnerNumberModel(160, 140, 230, 1));
		GridBagConstraints gbc_spinAltura = new GridBagConstraints();
		gbc_spinAltura.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinAltura.insets = new Insets(0, 0, 0, 5);
		gbc_spinAltura.gridx = 1;
		gbc_spinAltura.gridy = 4;
		contentPanel.add(spinAltura, gbc_spinAltura);
		
		checkAltura = new JCheckBox("Altura desconocida");
		GridBagConstraints gbc_checkAltura = new GridBagConstraints();
		gbc_checkAltura.anchor = GridBagConstraints.WEST;
		gbc_checkAltura.gridx = 2;
		gbc_checkAltura.gridy = 4;
		contentPanel.add(checkAltura, gbc_checkAltura);
		JFormattedTextField tf2 = ((JSpinner.DefaultEditor) spinAltura.getEditor()).getTextField();
		tf2.setEditable(false);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		panelBotones.add(okButton);
		getRootPane().setDefaultButton(okButton);
	
	
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		panelBotones.add(cancelButton);
		
		this.setModal(true);
	}
	private void cargarDatos() {
		if(deportista == null) {
			lblTitulo.setText("Añadir deportista");
		}
		else {
			lblTitulo.setText("Editar deportista");
			txtNombre.setText(deportista.getNombre());
			if(deportista.getSexo().equals("M")) {
				rdbtnHombre.setSelected(true);
			}
			else {
				rdbtnMujer.setSelected(true);
			}
			if(deportista.getPeso() == 0) {
				checkPeso.setSelected(true);
				spinPeso.setEnabled(false);
			}
			else {
				checkPeso.setSelected(false);
				spinPeso.setEnabled(true);
				spinPeso.setValue(deportista.getPeso());
			}
			if(deportista.getAltura() == 0) {
				checkAltura.setSelected(true);
				spinAltura.setEnabled(false);
			}
			else {
				checkAltura.setSelected(false);
				spinAltura.setEnabled(true);
				spinAltura.setValue(deportista.getAltura());
			}
			
		}
	}
	
	private void gestionarEventos() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		checkAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkAltura.isSelected()) {
					spinAltura.setEnabled(false);
				}
				else {
					spinAltura.setEnabled(true);
				}
			}
		});
		checkPeso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkPeso.isSelected()) {
					spinPeso.setEnabled(false);
				}
				else {
					spinPeso.setEnabled(true);
				}
			}
		});
	}
	
	private void cerrarVentana() {
		setVisible(false);
	}
	

}
