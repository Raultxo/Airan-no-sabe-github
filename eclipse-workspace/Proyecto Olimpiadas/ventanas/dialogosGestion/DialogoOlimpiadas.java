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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import consultas.ConsultasOlimpiadas;
import tablas.Olimpiada;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class DialogoOlimpiadas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel panelPrincipal = new JPanel();
	private JButton okButton, cancelButton;
	private JLabel lblTitulo, lblAnio, lblCiudad;
	private JTextField txtAnio, txtCiudad;
	private JRadioButton rdbtnSummer, rdbtnWinter;
	private ButtonGroup bg;
	private Olimpiada olimpiada;
	private ConsultasOlimpiadas cOlimpiadas;
	
	
	public DialogoOlimpiadas() {
		this.olimpiada = null;
		this.cOlimpiadas = new ConsultasOlimpiadas();
		dibujar();
		gestionarEventos();
	}
	
	public DialogoOlimpiadas(Olimpiada olimpiada) {
		this.olimpiada = olimpiada;
		this.cOlimpiadas = new ConsultasOlimpiadas();
		dibujar();
		cargarDatos();
		gestionarEventos();
	}
	
	private void dibujar() {
		
		this.setResizable(false);
		setBounds(100, 100, 450, 163);
		getContentPane().setLayout(new BorderLayout());
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{0, 0, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		lblTitulo = new JLabel();
		
		GridBagConstraints gbc_lbltITULO = new GridBagConstraints();
		gbc_lbltITULO.gridwidth = 2;
		gbc_lbltITULO.insets = new Insets(0, 0, 5, 0);
		gbc_lbltITULO.gridx = 0;
		gbc_lbltITULO.gridy = 0;
		panelPrincipal.add(lblTitulo, gbc_lbltITULO);
		
		lblAnio = new JLabel("A??o de las olimpiadas:");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.anchor = GridBagConstraints.EAST;
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 0;
		gbc_lblAnio.gridy = 1;
		panelPrincipal.add(lblAnio, gbc_lblAnio);
		
		txtAnio = new JTextField();
		GridBagConstraints gbc_textAnio = new GridBagConstraints();
		gbc_textAnio.insets = new Insets(0, 0, 5, 0);
		gbc_textAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAnio.gridx = 1;
		gbc_textAnio.gridy = 1;
		panelPrincipal.add(txtAnio, gbc_textAnio);
		txtAnio.setColumns(10);
		
		lblCiudad = new JLabel("Ciudad de las olimpiadas:");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 0;
		gbc_lblCiudad.gridy = 2;
		panelPrincipal.add(lblCiudad, gbc_lblCiudad);
		
		txtCiudad = new JTextField();
		GridBagConstraints gbc_txtCiudad = new GridBagConstraints();
		gbc_txtCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCiudad.gridx = 1;
		gbc_txtCiudad.gridy = 2;
		panelPrincipal.add(txtCiudad, gbc_txtCiudad);
		txtCiudad.setColumns(10);
		
		bg = new ButtonGroup();
		
		rdbtnSummer = new JRadioButton("Summer");
		rdbtnSummer.setHorizontalTextPosition(SwingConstants.RIGHT);
		rdbtnSummer.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_rdbtnSummer = new GridBagConstraints();
		gbc_rdbtnSummer.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnSummer.gridx = 0;
		gbc_rdbtnSummer.gridy = 3;
		panelPrincipal.add(rdbtnSummer, gbc_rdbtnSummer);
		
		rdbtnWinter = new JRadioButton("Winter");
		GridBagConstraints gbc_rdbtnWinter = new GridBagConstraints();
		gbc_rdbtnWinter.gridx = 1;
		gbc_rdbtnWinter.gridy = 3;
		panelPrincipal.add(rdbtnWinter, gbc_rdbtnWinter);
	
		bg.add(rdbtnSummer);
		bg.add(rdbtnWinter);
		rdbtnSummer.setSelected(true);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
			
		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		panelBotones.add(okButton);
		getRootPane().setDefaultButton(okButton);
	
		cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancelar");
		panelBotones.add(cancelButton);
		
		this.setModal(true);
	}
	
	private void cargarDatos() {
		if(olimpiada == null) {
			lblTitulo.setText("A??ADIR OLIMPIADA");
		}
		else {
			lblTitulo.setText("EDITAR OLIMPIADA");
			txtAnio.setText(String.valueOf(olimpiada.getAnio()));
			txtCiudad.setText(String.valueOf(olimpiada.getCiudad()));
			if(olimpiada.getTemporada().equals("Summer")) {
				rdbtnWinter.setSelected(false);
				rdbtnSummer.setSelected(true);
			}
			else {
				rdbtnSummer.setSelected(false);
				rdbtnWinter.setSelected(true);
			}
		}
	}
	
	private void gestionarEventos() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(olimpiada == null) {
					if(comprobarDatos()) {
						Olimpiada olimp = new Olimpiada(0, "", Integer.parseInt(txtAnio.getText()), "", txtCiudad.getText());
						if(rdbtnSummer.isSelected()) {
							olimp.setTemporada(rdbtnSummer.getText());
						}
						else {
							olimp.setTemporada(rdbtnWinter.getText());
						}
						olimp.setNombre(txtAnio.getText() + " " + olimp.getTemporada());
						
						if(cOlimpiadas.existeOlimpiada(olimp)) {
							JOptionPane.showMessageDialog(getContentPane(), "Esa olimpiada ya existe");
						}
						else {
							cOlimpiadas.insertarOlimpiada(olimp);
							cerrarVentana();
						}		
					}
				}
				else {
					if(comprobarDatos()) {
						olimpiada.setAnio(Integer.parseInt(txtAnio.getText()));
						olimpiada.setCiudad(txtCiudad.getText());
						if(rdbtnSummer.isSelected()) {
							olimpiada.setTemporada(rdbtnSummer.getText());
						}
						else {
							olimpiada.setTemporada(rdbtnWinter.getText());
						}
						olimpiada.setNombre(txtAnio.getText() + " " + olimpiada.getTemporada());
						
						if(cOlimpiadas.existeOlimpiada(olimpiada)) {
							JOptionPane.showMessageDialog(getContentPane(), "Esa olimpiada ya existe");
						}
						else {
							cOlimpiadas.editarOlimpiada(olimpiada);
							cerrarVentana();
						}
					}
				}	
			}
		});
	}
	
	private boolean comprobarDatos() {
		if(txtAnio.getText().equals("") || txtCiudad.getText().equals("")) {
			JOptionPane.showMessageDialog(getContentPane(), "Faltan datos");
			return false;
		}
		else {
			try {
				int anio = Integer.parseInt(txtAnio.getText());
				if(anio < 1896 || anio > 9999) {
					JOptionPane.showMessageDialog(getContentPane(), "El a??o no es correcto");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(getContentPane(), "El a??o no es numerico");
				return false;
			}
		}	
		return true;
	}
	
	private void cerrarVentana() {
		cOlimpiadas.cerrarConexion();
		setVisible(false);
	}

}
