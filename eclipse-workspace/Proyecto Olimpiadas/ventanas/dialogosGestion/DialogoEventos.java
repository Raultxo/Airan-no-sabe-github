package dialogosGestion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import consultas.ConsultasDeportes;
import consultas.ConsultasEventos;
import tablas.Deporte;
import tablas.Evento;
import tablas.Olimpiada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DialogoEventos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JComboBox<Deporte> comboDeportes;
	private JButton okButton, cancelButton;
	private JLabel lblTitulo;
	private JButton btnAniadirDeporte, btnEditarDeporte, btnEliminarDeporte;
	private ConsultasDeportes cDeportes;
	private ConsultasEventos cEventos;
	private Olimpiada olimpiada;
	private Evento evento;
	
	public DialogoEventos(Olimpiada olimpiada) {
		this.olimpiada = olimpiada;
		cDeportes = new ConsultasDeportes();
		cEventos = new ConsultasEventos();
		evento = null;
		dibujar();
		cargarDatos();
		gestionarEventos();
	}
	
	public DialogoEventos(Olimpiada olimpiada, Evento evento) {
		this.olimpiada = olimpiada;
		cDeportes = new ConsultasDeportes();
		cEventos = new ConsultasEventos();
		this.evento = evento;
		dibujar();
		cargarDatos();
		gestionarEventos();
	}
	
	private void dibujar() {
		setResizable(false);
		setBounds(100, 100, 594, 169);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel();
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(10, 0, 0, 0));
		contentPanel.add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{183, 0, 0, 0, 0, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		JLabel lblNombre = new JLabel("Nombre del evento:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panelPrincipal.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		panelPrincipal.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDeporte = new JLabel("Deporte:");
		GridBagConstraints gbc_lblDeporte = new GridBagConstraints();
		gbc_lblDeporte.insets = new Insets(0, 0, 0, 5);
		gbc_lblDeporte.anchor = GridBagConstraints.EAST;
		gbc_lblDeporte.gridx = 0;
		gbc_lblDeporte.gridy = 1;
		panelPrincipal.add(lblDeporte, gbc_lblDeporte);
		
		comboDeportes = new JComboBox<Deporte>();
		GridBagConstraints gbc_comboDeportes = new GridBagConstraints();
		gbc_comboDeportes.insets = new Insets(0, 0, 0, 5);
		gbc_comboDeportes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDeportes.gridx = 1;
		gbc_comboDeportes.gridy = 1;
		panelPrincipal.add(comboDeportes, gbc_comboDeportes);
		
		btnAniadirDeporte = new JButton("");
		btnAniadirDeporte.setIcon(new ImageIcon(DialogoEventos.class.getResource("/imagenes/add.png")));
		GridBagConstraints gbc_btnAniadirDeporte = new GridBagConstraints();
		gbc_btnAniadirDeporte.insets = new Insets(0, 0, 0, 5);
		gbc_btnAniadirDeporte.gridx = 2;
		gbc_btnAniadirDeporte.gridy = 1;
		panelPrincipal.add(btnAniadirDeporte, gbc_btnAniadirDeporte);
		
		btnEditarDeporte = new JButton("");
		btnEditarDeporte.setIcon(new ImageIcon(DialogoEventos.class.getResource("/imagenes/edit.png")));
		GridBagConstraints gbc_btnEditarDeporte = new GridBagConstraints();
		gbc_btnEditarDeporte.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditarDeporte.gridx = 3;
		gbc_btnEditarDeporte.gridy = 1;
		panelPrincipal.add(btnEditarDeporte, gbc_btnEditarDeporte);
		
		btnEliminarDeporte = new JButton("");
		btnEliminarDeporte.setIcon(new ImageIcon(DialogoEventos.class.getResource("/imagenes/delete.png")));
		GridBagConstraints gbc_btnEliminarDeporte = new GridBagConstraints();
		gbc_btnEliminarDeporte.gridx = 4;
		gbc_btnEliminarDeporte.gridy = 1;
		panelPrincipal.add(btnEliminarDeporte, gbc_btnEliminarDeporte);
		
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
		DefaultComboBoxModel<Deporte> modelo = new DefaultComboBoxModel<Deporte>();
		modelo.addAll(cDeportes.listaDeportes());
		comboDeportes.setModel(modelo);
		if(modelo.getSize() > 0) {
			comboDeportes.setSelectedIndex(0);
			btnEditarDeporte.setEnabled(true);
			btnEliminarDeporte.setEnabled(true);
		}
		else {
			btnEditarDeporte.setEnabled(false);
			btnEliminarDeporte.setEnabled(false);
		}
		
		if(evento == null) {
			lblTitulo.setText("A??ADIR EVENTO");
		}
		else {
			lblTitulo.setText("EDITAR EVENTO");
			txtNombre.setText(evento.getNombre());
			comboDeportes.setSelectedItem(evento.getDeporte());
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
				if(comprobarDatos()) {
					JOptionPane.showMessageDialog(getContentPane(), "Faltan datos");
				}
				else {
					if(evento == null) {
						Evento nuevo = new Evento(0, txtNombre.getText(), olimpiada, (Deporte) comboDeportes.getSelectedItem());
						if(cEventos.existeEvento(nuevo)) {
							JOptionPane.showMessageDialog(getContentPane(), "Ese evento ya existe");
						}
						else {
							cEventos.aniadirEvento(nuevo);
							cerrarVentana();
						}
					}
					else {
						evento.setDeporte((Deporte) comboDeportes.getSelectedItem());
						evento.setNombre(txtNombre.getText());
						if(cEventos.existeEvento(evento)) {
							JOptionPane.showMessageDialog(getContentPane(), "Ese evento ya existe");
						}
						else {
							cEventos.editarEvento(evento);
							cerrarVentana();
						}
					}
				}
			}
		});
		
		btnAniadirDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoDeportes dialogoDeporte = new DialogoDeportes();
				dialogoDeporte.setVisible(true);
				cargarDatos();
			}
		});
		btnEditarDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoDeportes dialogoDeporte = new DialogoDeportes((Deporte) comboDeportes.getSelectedItem());
				dialogoDeporte.setVisible(true);
				cargarDatos();
			}
		});
		btnEliminarDeporte.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar el deporte?", "Borrar deporte", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
				    cDeportes.borrarDeporte((Deporte) comboDeportes.getSelectedItem());
				    cargarDatos();
				} 	
			}
		});	
	}
	
	private boolean comprobarDatos() {
		return txtNombre.getText().equals("") || comboDeportes.getSelectedItem() == null;
	}
	
	private void cerrarVentana() {
		cDeportes.cerrarConexion();
		cEventos.cerrarConexion();
		setVisible(false);
	}

}
