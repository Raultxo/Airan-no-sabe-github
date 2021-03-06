package dialogosGestion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import consultas.ConsultasDeportes;
import tablas.Deporte;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

public class DialogoDeportes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel panelPrincipal = new JPanel();
	private JTextField txtNombre;
	private Deporte deporte;
	private JLabel lblTitulo;
	private JButton okButton, cancelButton;
	private ConsultasDeportes cDeportes;

	public DialogoDeportes() {
		cDeportes = new ConsultasDeportes();
		this.deporte = null;
		dibujar();
		gestionarEventos();		
	}
	
	public DialogoDeportes(Deporte deporte) {
		cDeportes = new ConsultasDeportes();
		this.deporte = deporte;
		dibujar();
		gestionarEventos();
	}
	
	private void dibujar() {
		setBounds(100, 100, 450, 146);
		getContentPane().setLayout(new BorderLayout());
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{0, 0, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panelPrincipal.add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panelPrincipal.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		panelPrincipal.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
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
		
		if(deporte == null) {
			lblTitulo.setText("A??adir deporte");
		}
		else {
			lblTitulo.setText("Editar deporte");
			txtNombre.setText(deporte.getNombre());
		}
		
		this.setModal(true);
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
				if(comprobarDatos()) {
					JOptionPane.showMessageDialog(getContentPane(), "Tienes que poner un nombre al deporte");
				}
				else {
					if(deporte == null) {
						Deporte nuevo = new Deporte(0, txtNombre.getText());
						if(cDeportes.existeDeporte(nuevo)) {
							JOptionPane.showMessageDialog(getContentPane(), "Ese deporte ya existe");
						}
						else {
							cDeportes.aniadirDeporte(nuevo);
							cerrarVentana();
						}
					}
					else {
						deporte.setNombre(txtNombre.getText());
						if(cDeportes.existeDeporte(deporte)) {
							JOptionPane.showMessageDialog(getContentPane(), "Ese deporte ya existe");
						}	
						else {
							cDeportes.editarDeporte(deporte);
							cerrarVentana();
						}
					}
				}
			}
		});
	}
	
	private boolean comprobarDatos() {
		return txtNombre.getText().equals("");	
	}
	
	private void cerrarVentana() {
		cDeportes.cerrarConexion();
		setVisible(false);
	}

}
