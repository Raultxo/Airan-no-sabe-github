package dialogosGestion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import consultas.ConsultasDeportistas;
import consultas.ConsultasEquipos;
import tablas.Deportista;
import tablas.Equipo;
import tablas.Participacion;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class DialogoParticipaciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel panelPrincipal = new JPanel();
	private JLabel lblTitulo;
	private JButton okButton, cancelButton;
	private ConsultasDeportistas cDeportistas;
	private ConsultasEquipos cEquipos;
	private JList<Deportista> listaDeportistas;
	private JScrollPane scrollDeportistas, scrollEquipos;
	private JList<Equipo> listaEquipos;
	private JComboBox<String> comboMedallas;
	private JLabel lblMedalla, lblEdad;
	private JSpinner spinEdad;
	private JPanel panelBotonesDeportistas, panelBotonesEquipos, panelDatos;
	private JButton btnAniadirDeportista, btnEditarDeportista, btnEliminarDeportista;
	private JButton btnAniadirEquipo, btnEditarEquipo, btnEliminarEquipo;
	private Participacion participacion;
	private JLabel lblListaDeportistas, lblListaEquipos;
	private JCheckBox checkEdad;
	private JTextField txtBuscardeportista, txtBuscarequipo;
	private JPanel panelBuscarDeportista, panelBuscarEquipo;
	private JLabel lblImgbuscar1, lblImgbuscar2;
	
	public DialogoParticipaciones() {
		cDeportistas = new ConsultasDeportistas();
		cEquipos = new ConsultasEquipos();
		
		this.participacion = null;
		
		dibujar();
		cargarDatos();
		gestionarEventos();	
	}
	
	public DialogoParticipaciones(Participacion participacion) {
		cDeportistas = new ConsultasDeportistas();
		cEquipos = new ConsultasEquipos();
		
		this.participacion = participacion;
		
		dibujar();
		cargarDatos();
		gestionarEventos();	
	}
	
	private void dibujar() {	
		setResizable(false);
		setBounds(100, 100, 1000, 300);
		getContentPane().setLayout(new BorderLayout());
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{426, 344, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 15, 0, 0, 0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_panelPrincipal.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		lblTitulo = new JLabel();
		lblTitulo.setBorder(new EmptyBorder(0, 0, 10, 0));
		lblTitulo.setText("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.anchor = GridBagConstraints.NORTH;
		gbc_lblTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panelPrincipal.add(lblTitulo, gbc_lblTitulo);
		
		lblListaDeportistas = new JLabel("Lista Deportistas");
		GridBagConstraints gbc_lblListaDeportistas = new GridBagConstraints();
		gbc_lblListaDeportistas.insets = new Insets(0, 0, 5, 5);
		gbc_lblListaDeportistas.gridx = 0;
		gbc_lblListaDeportistas.gridy = 1;
		panelPrincipal.add(lblListaDeportistas, gbc_lblListaDeportistas);
		
		lblListaEquipos = new JLabel("Lista Equipos");
		GridBagConstraints gbc_lblListaEquipos = new GridBagConstraints();
		gbc_lblListaEquipos.insets = new Insets(0, 0, 5, 5);
		gbc_lblListaEquipos.gridx = 1;
		gbc_lblListaEquipos.gridy = 1;
		panelPrincipal.add(lblListaEquipos, gbc_lblListaEquipos);
		
		panelBuscarDeportista = new JPanel();
		GridBagConstraints gbc_panelBuscarDeportista = new GridBagConstraints();
		gbc_panelBuscarDeportista.fill = GridBagConstraints.BOTH;
		gbc_panelBuscarDeportista.insets = new Insets(0, 0, 5, 5);
		gbc_panelBuscarDeportista.gridx = 0;
		gbc_panelBuscarDeportista.gridy = 2;
		panelPrincipal.add(panelBuscarDeportista, gbc_panelBuscarDeportista);
		GridBagLayout gbl_panelBuscarDeportista = new GridBagLayout();
		gbl_panelBuscarDeportista.columnWidths = new int[]{0, 426, 0};
		gbl_panelBuscarDeportista.rowHeights = new int[]{0, 0};
		gbl_panelBuscarDeportista.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelBuscarDeportista.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBuscarDeportista.setLayout(gbl_panelBuscarDeportista);
		
		lblImgbuscar1 = new JLabel("");
		lblImgbuscar1.setIcon(new ImageIcon(DialogoParticipaciones.class.getResource("/imagenes/search.png")));
		GridBagConstraints gbc_lblImgbuscar1 = new GridBagConstraints();
		gbc_lblImgbuscar1.insets = new Insets(0, 0, 0, 5);
		gbc_lblImgbuscar1.gridx = 0;
		gbc_lblImgbuscar1.gridy = 0;
		panelBuscarDeportista.add(lblImgbuscar1, gbc_lblImgbuscar1);
		
		txtBuscardeportista = new JTextField();
		GridBagConstraints gbc_txtBuscardeportista = new GridBagConstraints();
		gbc_txtBuscardeportista.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBuscardeportista.gridx = 1;
		gbc_txtBuscardeportista.gridy = 0;
		panelBuscarDeportista.add(txtBuscardeportista, gbc_txtBuscardeportista);
		txtBuscardeportista.setColumns(10);
		
		panelBuscarEquipo = new JPanel();
		GridBagConstraints gbc_panelBuscarEquipo = new GridBagConstraints();
		gbc_panelBuscarEquipo.fill = GridBagConstraints.BOTH;
		gbc_panelBuscarEquipo.insets = new Insets(0, 0, 5, 5);
		gbc_panelBuscarEquipo.gridx = 1;
		gbc_panelBuscarEquipo.gridy = 2;
		panelPrincipal.add(panelBuscarEquipo, gbc_panelBuscarEquipo);
		GridBagLayout gbl_panelBuscarEquipo = new GridBagLayout();
		gbl_panelBuscarEquipo.columnWidths = new int[]{0, 344, 0};
		gbl_panelBuscarEquipo.rowHeights = new int[]{0, 0};
		gbl_panelBuscarEquipo.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelBuscarEquipo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBuscarEquipo.setLayout(gbl_panelBuscarEquipo);
		
		lblImgbuscar2 = new JLabel("");
		lblImgbuscar2.setIcon(new ImageIcon(DialogoParticipaciones.class.getResource("/imagenes/search.png")));
		GridBagConstraints gbc_lblImgbuscar_1 = new GridBagConstraints();
		gbc_lblImgbuscar_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblImgbuscar_1.gridx = 0;
		gbc_lblImgbuscar_1.gridy = 0;
		panelBuscarEquipo.add(lblImgbuscar2, gbc_lblImgbuscar_1);
		
		txtBuscarequipo = new JTextField();
		GridBagConstraints gbc_txtBuscarequipo = new GridBagConstraints();
		gbc_txtBuscarequipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBuscarequipo.gridx = 1;
		gbc_txtBuscarequipo.gridy = 0;
		panelBuscarEquipo.add(txtBuscarequipo, gbc_txtBuscarequipo);
		txtBuscarequipo.setColumns(10);
		
		scrollDeportistas = new JScrollPane();
		GridBagConstraints gbc_scrollDeportistas = new GridBagConstraints();
		gbc_scrollDeportistas.insets = new Insets(0, 0, 5, 5);
		gbc_scrollDeportistas.fill = GridBagConstraints.BOTH;
		gbc_scrollDeportistas.gridx = 0;
		gbc_scrollDeportistas.gridy = 3;
		panelPrincipal.add(scrollDeportistas, gbc_scrollDeportistas);
		
		listaDeportistas = new JList<Deportista>();
		scrollDeportistas.setViewportView(listaDeportistas);
		
		scrollEquipos = new JScrollPane();
		GridBagConstraints gbc_scrollEquipos = new GridBagConstraints();
		gbc_scrollEquipos.insets = new Insets(0, 0, 5, 5);
		gbc_scrollEquipos.fill = GridBagConstraints.BOTH;
		gbc_scrollEquipos.gridx = 1;
		gbc_scrollEquipos.gridy = 3;
		panelPrincipal.add(scrollEquipos, gbc_scrollEquipos);
		
		listaEquipos = new JList<Equipo>();
		scrollEquipos.setViewportView(listaEquipos);
		
		panelDatos = new JPanel();
		GridBagConstraints gbc_panelDatos = new GridBagConstraints();
		gbc_panelDatos.insets = new Insets(0, 0, 5, 0);
		gbc_panelDatos.fill = GridBagConstraints.BOTH;
		gbc_panelDatos.gridx = 2;
		gbc_panelDatos.gridy = 3;
		panelPrincipal.add(panelDatos, gbc_panelDatos);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[]{0, 0, 0};
		gbl_panelDatos.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelDatos.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelDatos.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDatos.setLayout(gbl_panelDatos);
		
		lblMedalla = new JLabel("Medalla:");
		GridBagConstraints gbc_lblMedalla = new GridBagConstraints();
		gbc_lblMedalla.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedalla.anchor = GridBagConstraints.EAST;
		gbc_lblMedalla.gridx = 0;
		gbc_lblMedalla.gridy = 0;
		panelDatos.add(lblMedalla, gbc_lblMedalla);
		
		comboMedallas = new JComboBox<String>();
		GridBagConstraints gbc_comboMedallas = new GridBagConstraints();
		gbc_comboMedallas.insets = new Insets(0, 0, 5, 0);
		gbc_comboMedallas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboMedallas.gridx = 1;
		gbc_comboMedallas.gridy = 0;
		panelDatos.add(comboMedallas, gbc_comboMedallas);
		
		lblEdad = new JLabel("Edad:");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 1;
		panelDatos.add(lblEdad, gbc_lblEdad);
		
		spinEdad = new JSpinner();
		spinEdad.setModel(new SpinnerNumberModel(13, 13, 100, 1));
		GridBagConstraints gbc_spinEdad = new GridBagConstraints();
		gbc_spinEdad.insets = new Insets(0, 0, 5, 0);
		gbc_spinEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinEdad.gridx = 1;
		gbc_spinEdad.gridy = 1;
		panelDatos.add(spinEdad, gbc_spinEdad);
		
		checkEdad = new JCheckBox("Edad desconocida");
		GridBagConstraints gbc_checkEdad = new GridBagConstraints();
		gbc_checkEdad.anchor = GridBagConstraints.EAST;
		gbc_checkEdad.gridwidth = 2;
		gbc_checkEdad.insets = new Insets(0, 0, 0, 5);
		gbc_checkEdad.gridx = 0;
		gbc_checkEdad.gridy = 2;
		panelDatos.add(checkEdad, gbc_checkEdad);
		JFormattedTextField tf = ((JSpinner.DefaultEditor) spinEdad.getEditor()).getTextField();
		tf.setEditable(false);
		
		panelBotonesDeportistas = new JPanel();
		GridBagConstraints gbc_panelBotonesDeportistas = new GridBagConstraints();
		gbc_panelBotonesDeportistas.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotonesDeportistas.gridx = 0;
		gbc_panelBotonesDeportistas.gridy = 4;
		panelPrincipal.add(panelBotonesDeportistas, gbc_panelBotonesDeportistas);
		panelBotonesDeportistas.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnAniadirDeportista = new JButton("");
		btnAniadirDeportista.setIcon(new ImageIcon(DialogoParticipaciones.class.getResource("/imagenes/add.png")));
		panelBotonesDeportistas.add(btnAniadirDeportista);
		
		btnEditarDeportista = new JButton("");
		btnEditarDeportista.setIcon(new ImageIcon(DialogoParticipaciones.class.getResource("/imagenes/edit.png")));
		panelBotonesDeportistas.add(btnEditarDeportista);
		
		btnEliminarDeportista = new JButton("");
		btnEliminarDeportista.setIcon(new ImageIcon(DialogoParticipaciones.class.getResource("/imagenes/delete.png")));
		panelBotonesDeportistas.add(btnEliminarDeportista);
		
		panelBotonesEquipos = new JPanel();
		GridBagConstraints gbc_panelBotonesEquipos = new GridBagConstraints();
		gbc_panelBotonesEquipos.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotonesEquipos.gridx = 1;
		gbc_panelBotonesEquipos.gridy = 4;
		panelPrincipal.add(panelBotonesEquipos, gbc_panelBotonesEquipos);
		panelBotonesEquipos.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnAniadirEquipo = new JButton("");
		btnAniadirEquipo.setIcon(new ImageIcon(DialogoParticipaciones.class.getResource("/imagenes/add.png")));
		panelBotonesEquipos.add(btnAniadirEquipo);
		
		btnEditarEquipo = new JButton("");
		btnEditarEquipo.setIcon(new ImageIcon(DialogoParticipaciones.class.getResource("/imagenes/edit.png")));
		panelBotonesEquipos.add(btnEditarEquipo);
		
		btnEliminarEquipo = new JButton("");
		btnEliminarEquipo.setIcon(new ImageIcon(DialogoParticipaciones.class.getResource("/imagenes/delete.png")));
		panelBotonesEquipos.add(btnEliminarEquipo);
		
		JPanel panelBotonesVentana = new JPanel();
		GridBagConstraints gbc_panelBotonesVentana = new GridBagConstraints();
		gbc_panelBotonesVentana.gridx = 2;
		gbc_panelBotonesVentana.gridy = 4;
		panelPrincipal.add(panelBotonesVentana, gbc_panelBotonesVentana);
		panelBotonesVentana.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		panelBotonesVentana.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		panelBotonesVentana.add(cancelButton);
	
		this.setModal(true);
	}
	
	private void cargarDatos() {
		DefaultListModel<Equipo> modeloEquipos = new DefaultListModel<Equipo>();
		modeloEquipos.addAll(cEquipos.listaEquipos(""));
		listaEquipos.setModel(modeloEquipos);
		if(modeloEquipos.size() > 0) {
			listaEquipos.setSelectedIndex(0);
			btnEliminarEquipo.setEnabled(true);
			btnEditarEquipo.setEnabled(true);
		}
		else {
			btnEliminarEquipo.setEnabled(false);
			btnEditarEquipo.setEnabled(false);
		}
		
		DefaultListModel<Deportista> modeloDeportistas = new DefaultListModel<Deportista>();
		modeloDeportistas.addAll(cDeportistas.listaDeportistas(""));
		listaDeportistas.setModel(modeloDeportistas);
		if(modeloDeportistas.size() > 0) {
			listaDeportistas.setSelectedIndex(0);
			btnEliminarDeportista.setEnabled(true);
			btnEditarDeportista.setEnabled(true);
		}
		else {
			btnEliminarDeportista.setEnabled(false);
			btnEditarDeportista.setEnabled(false);
		}
		
		ArrayList<String> medallas = new ArrayList<String>();
		medallas.add("Oro");
		medallas.add("Plata");
		medallas.add("Bronce");
		medallas.add("Sin medalla");
		DefaultComboBoxModel<String> modeloMedallas = new DefaultComboBoxModel<String>();
		modeloMedallas.addAll(medallas);
		comboMedallas.setModel(modeloMedallas);
		comboMedallas.setSelectedIndex(3);
		
		if(participacion != null) {
			lblTitulo.setText("Editar participacion");
			listaEquipos.setSelectedValue(participacion.getEquipo(), true);
			listaDeportistas.setSelectedValue(participacion.getDeportista(), true);
			comboMedallas.setSelectedItem(participacion.getMedalla());
			if(participacion.getEdad() == 0) {
				checkEdad.setSelected(true);
				spinEdad.setEnabled(false);
			}
			else {
				checkEdad.setSelected(false);
				spinEdad.setEnabled(true);
				spinEdad.setValue(participacion.getEdad());
			}		
		}
		else {
			lblTitulo.setText("Añadir participacion");
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
		checkEdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkEdad.isSelected()) {
					spinEdad.setEnabled(false);
				}
				else {
					spinEdad.setEnabled(true);
				}
			}
		});
		
		gestionarEventosDeportistas();
		gestionarEventosEquipos();
	}
	
	private void gestionarEventosDeportistas() {
		btnAniadirDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoDeportistas dialogoDeportistas = new DialogoDeportistas();
				dialogoDeportistas.setVisible(true);
			}
		});
		btnEditarDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoDeportistas dialogoDeportistas = new DialogoDeportistas(listaDeportistas.getSelectedValue());
				dialogoDeportistas.setVisible(true);
			}
		});
		btnEliminarDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		txtBuscardeportista.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				DefaultListModel<Deportista> modeloDeportistas = new DefaultListModel<Deportista>();
				modeloDeportistas.addAll(cDeportistas.listaDeportistas(txtBuscardeportista.getText()));
				listaDeportistas.setModel(modeloDeportistas);
				if(modeloDeportistas.size() > 0) {
					listaDeportistas.setSelectedIndex(0);
					btnEliminarDeportista.setEnabled(true);
					btnEditarDeportista.setEnabled(true);
				}
				else {
					btnEliminarDeportista.setEnabled(false);
					btnEditarDeportista.setEnabled(false);
				}
			}
		});
	}
	
	private void gestionarEventosEquipos() {
		btnAniadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoEquipos dialogoEquipos = new DialogoEquipos();
				dialogoEquipos.setVisible(true);
			}
		});
		btnEditarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoEquipos dialogoEquipos = new DialogoEquipos(listaEquipos.getSelectedValue());
				dialogoEquipos.setVisible(true);
			}
		});
		btnEliminarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		txtBuscarequipo.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				DefaultListModel<Equipo> modeloEquipos = new DefaultListModel<Equipo>();
				modeloEquipos.addAll(cEquipos.listaEquipos(txtBuscarequipo.getText()));
				listaEquipos.setModel(modeloEquipos);
				if(modeloEquipos.size() > 0) {
					listaEquipos.setSelectedIndex(0);
					btnEliminarEquipo.setEnabled(true);
					btnEditarEquipo.setEnabled(true);
				}
				else {
					btnEliminarEquipo.setEnabled(false);
					btnEditarEquipo.setEnabled(false);
				}
			}
		});
	}
	
	private void cerrarVentana() {
		cDeportistas.cerrarConexion();
		cEquipos.cerrarConexion();
		setVisible(false);
	}


	

}
