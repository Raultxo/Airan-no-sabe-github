package dialogosGestion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tablas.Equipo;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DialogoEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton, cancelButton;
	private Equipo equipo;
	private JLabel lblTitulo, lblNombreEquipo, lblAbreviaturaEquipo;
	private JTextField txtNombreequipo, txtAbreviaturaequipo;
	
	public DialogoEquipos() {
		setResizable(false);
		equipo = null;
		dibujar();
		cargarDatos();
		gestionarEventos();
	}
	
	public DialogoEquipos(Equipo equipo) {
		this.equipo = equipo;
		dibujar();
		cargarDatos();
		gestionarEventos();
	}
	
	private void dibujar() {
		setBounds(100, 100, 450, 126);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		lblTitulo = new JLabel("");
		lblTitulo.setBorder(new EmptyBorder(0, 0, 5, 0));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPanel.add(lblTitulo, gbc_lblTitulo);
		
		lblNombreEquipo = new JLabel("Nombre equipo:");
		GridBagConstraints gbc_lblNombreEquipo = new GridBagConstraints();
		gbc_lblNombreEquipo.anchor = GridBagConstraints.EAST;
		gbc_lblNombreEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreEquipo.gridx = 0;
		gbc_lblNombreEquipo.gridy = 1;
		contentPanel.add(lblNombreEquipo, gbc_lblNombreEquipo);
		
		txtNombreequipo = new JTextField();
		GridBagConstraints gbc_txtNombreequipo = new GridBagConstraints();
		gbc_txtNombreequipo.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombreequipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreequipo.gridx = 1;
		gbc_txtNombreequipo.gridy = 1;
		contentPanel.add(txtNombreequipo, gbc_txtNombreequipo);
		txtNombreequipo.setColumns(10);
		
		lblAbreviaturaEquipo = new JLabel("Abreviatura equipo:");
		GridBagConstraints gbc_lblAbreviaturaEquipo = new GridBagConstraints();
		gbc_lblAbreviaturaEquipo.anchor = GridBagConstraints.EAST;
		gbc_lblAbreviaturaEquipo.insets = new Insets(0, 0, 0, 5);
		gbc_lblAbreviaturaEquipo.gridx = 0;
		gbc_lblAbreviaturaEquipo.gridy = 2;
		contentPanel.add(lblAbreviaturaEquipo, gbc_lblAbreviaturaEquipo);
		
		txtAbreviaturaequipo = new JTextField();
		GridBagConstraints gbc_txtAbreviaturaequipo = new GridBagConstraints();
		gbc_txtAbreviaturaequipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAbreviaturaequipo.gridx = 1;
		gbc_txtAbreviaturaequipo.gridy = 2;
		contentPanel.add(txtAbreviaturaequipo, gbc_txtAbreviaturaequipo);
		txtAbreviaturaequipo.setColumns(3);
		
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
		if(equipo == null) {
			lblTitulo.setText("Añadir equipo");
		}
		else {
			lblTitulo.setText("Editar equipo");
			txtNombreequipo.setText(equipo.getNombre());
			txtAbreviaturaequipo.setText(equipo.getIniciales());
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
		txtAbreviaturaequipo.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent arg0) {
				if(txtAbreviaturaequipo.getText().length() > 3) {
					txtAbreviaturaequipo.setText(txtAbreviaturaequipo.getText().substring(0, 3));
				}
			}
		});			
	}
	
	private void cerrarVentana() {
		setVisible(false);
	}

}
