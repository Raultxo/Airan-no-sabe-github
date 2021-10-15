package ventanas;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.AeropuertoPrivado;
import beans.AeropuertoPublico;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AniadirEditarAeropuerto extends JDialog {

	private boolean aniadir, publico;
	private AeropuertoPrivado aeropuertoPrivado;
	private AeropuertoPublico aeropuertoPublico;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre, txtPais, txtCiudad, txtCalle, txtNumero, txtAnio, 
						txtCapacidad, txtNumTrabajadores, txtFinanciacion, txtNumSocios;
	private JRadioButton rdbtnPublico, rdbtnPrivado;
	private JLabel lblNumTrabajadores, lblFinanciacion, lblNumSocios;
	private JButton btnCancelar, btnGuardar;


	public AniadirEditarAeropuerto(boolean publico, AeropuertoPublico aeropuerto) {
		this.publico = publico;
		this.aniadir = false;
		this.aeropuertoPublico = aeropuerto;
		
		dibujar();
		gestionarEventos();

	}
	
	public AniadirEditarAeropuerto(boolean publico, AeropuertoPrivado aeropuerto) {
		this.publico = publico;
		this.aniadir = false;
		this.aeropuertoPrivado = aeropuerto;
		dibujar();
		gestionarEventos();
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public AniadirEditarAeropuerto(boolean aniadir) {
		setResizable(false);
		this.aniadir = aniadir;
		this.publico = true;
		dibujar();
		gestionarEventos();
	}
	
	
	private void dibujar() {
		setBounds(100, 100, 488, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("DATOS DEL AEROPUERTO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnGuardar = new JButton("Guardar");
		panelBotones.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnCancelar);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBorder(new EmptyBorder(10, 0, 0, 0));
		contentPane.add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[]{202, 233, 0};
		gbl_panelCentro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCentro.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCentro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panelCentro.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 0;
		panelCentro.add(txtNombre, gbc_textNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPais = new GridBagConstraints();
		gbc_lblPais.anchor = GridBagConstraints.EAST;
		gbc_lblPais.insets = new Insets(0, 0, 5, 5);
		gbc_lblPais.gridx = 0;
		gbc_lblPais.gridy = 1;
		panelCentro.add(lblPais, gbc_lblPais);
		
		txtPais = new JTextField();
		GridBagConstraints gbc_textPais = new GridBagConstraints();
		gbc_textPais.insets = new Insets(0, 0, 5, 0);
		gbc_textPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPais.gridx = 1;
		gbc_textPais.gridy = 1;
		panelCentro.add(txtPais, gbc_textPais);
		txtPais.setColumns(10);
		JLabel lblCiudad = new JLabel("Ciudad:");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 0;
		gbc_lblCiudad.gridy = 2;
		panelCentro.add(lblCiudad, gbc_lblCiudad);
		
		txtCiudad = new JTextField();
		GridBagConstraints gbc_txtCiudad = new GridBagConstraints();
		gbc_txtCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCiudad.gridx = 1;
		gbc_txtCiudad.gridy = 2;
		panelCentro.add(txtCiudad, gbc_txtCiudad);
		txtCiudad.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle:");
		GridBagConstraints gbc_lblCalle = new GridBagConstraints();
		gbc_lblCalle.anchor = GridBagConstraints.EAST;
		gbc_lblCalle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalle.gridx = 0;
		gbc_lblCalle.gridy = 3;
		panelCentro.add(lblCalle, gbc_lblCalle);
		
		txtCalle = new JTextField();
		GridBagConstraints gbc_txtCalle = new GridBagConstraints();
		gbc_txtCalle.insets = new Insets(0, 0, 5, 0);
		gbc_txtCalle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCalle.gridx = 1;
		gbc_txtCalle.gridy = 3;
		panelCentro.add(txtCalle, gbc_txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.EAST;
		gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumero.gridx = 0;
		gbc_lblNumero.gridy = 4;
		panelCentro.add(lblNumero, gbc_lblNumero);
		
		txtNumero = new JTextField();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 4;
		panelCentro.add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblAnio = new JLabel("Año de inauguración:");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.anchor = GridBagConstraints.EAST;
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 0;
		gbc_lblAnio.gridy = 5;
		panelCentro.add(lblAnio, gbc_lblAnio);
		
		txtAnio = new JTextField();
		GridBagConstraints gbc_txtAnio = new GridBagConstraints();
		gbc_txtAnio.insets = new Insets(0, 0, 5, 0);
		gbc_txtAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnio.gridx = 1;
		gbc_txtAnio.gridy = 5;
		panelCentro.add(txtAnio, gbc_txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		GridBagConstraints gbc_lblCapacidad = new GridBagConstraints();
		gbc_lblCapacidad.anchor = GridBagConstraints.EAST;
		gbc_lblCapacidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacidad.gridx = 0;
		gbc_lblCapacidad.gridy = 6;
		panelCentro.add(lblCapacidad, gbc_lblCapacidad);
		
		txtCapacidad = new JTextField();
		GridBagConstraints gbc_txtCapacidad = new GridBagConstraints();
		gbc_txtCapacidad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCapacidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCapacidad.gridx = 1;
		gbc_txtCapacidad.gridy = 6;
		panelCentro.add(txtCapacidad, gbc_txtCapacidad);
		txtCapacidad.setColumns(10);
		
		ButtonGroup bg = new ButtonGroup();
		
		rdbtnPublico = new JRadioButton("Publico");
		GridBagConstraints gbc_rdbtnPublico = new GridBagConstraints();
		gbc_rdbtnPublico.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPublico.gridx = 0;
		gbc_rdbtnPublico.gridy = 7;
		panelCentro.add(rdbtnPublico, gbc_rdbtnPublico);
		
		rdbtnPrivado = new JRadioButton("Privado");
		GridBagConstraints gbc_rdbtnPrivado = new GridBagConstraints();
		gbc_rdbtnPrivado.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnPrivado.gridx = 1;
		gbc_rdbtnPrivado.gridy = 7;
		panelCentro.add(rdbtnPrivado, gbc_rdbtnPrivado);
		
		bg.add(rdbtnPrivado);
		bg.add(rdbtnPublico);
		
		
		lblNumTrabajadores = new JLabel("Numero de trabajadores:");
		GridBagConstraints gbc_lblNumTrabajadores = new GridBagConstraints();
		gbc_lblNumTrabajadores.anchor = GridBagConstraints.EAST;
		gbc_lblNumTrabajadores.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumTrabajadores.gridx = 0;
		gbc_lblNumTrabajadores.gridy = 8;
		panelCentro.add(lblNumTrabajadores, gbc_lblNumTrabajadores);
		
		txtNumTrabajadores = new JTextField();
		GridBagConstraints gbc_txtNumTrabajadores = new GridBagConstraints();
		gbc_txtNumTrabajadores.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumTrabajadores.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumTrabajadores.gridx = 1;
		gbc_txtNumTrabajadores.gridy = 8;
		panelCentro.add(txtNumTrabajadores, gbc_txtNumTrabajadores);
		txtNumTrabajadores.setColumns(10);
		
		lblFinanciacion = new JLabel("Financiacion:");
		GridBagConstraints gbc_lblFinanciacion = new GridBagConstraints();
		gbc_lblFinanciacion.anchor = GridBagConstraints.EAST;
		gbc_lblFinanciacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinanciacion.gridx = 0;
		gbc_lblFinanciacion.gridy = 9;
		panelCentro.add(lblFinanciacion, gbc_lblFinanciacion);
		
		txtFinanciacion = new JTextField();
		GridBagConstraints gbc_txtFinanciacion = new GridBagConstraints();
		gbc_txtFinanciacion.insets = new Insets(0, 0, 5, 0);
		gbc_txtFinanciacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFinanciacion.gridx = 1;
		gbc_txtFinanciacion.gridy = 9;
		panelCentro.add(txtFinanciacion, gbc_txtFinanciacion);
		txtNumTrabajadores.setColumns(10);
		
		rdbtnPublico.setSelected(true);
		
		lblNumSocios = new JLabel("Numero de socios:");
		GridBagConstraints gbc_lblNumSocios = new GridBagConstraints();
		gbc_lblNumSocios.anchor = GridBagConstraints.EAST;
		gbc_lblNumSocios.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumSocios.gridx = 0;
		gbc_lblNumSocios.gridy = 8;
		panelCentro.add(lblNumSocios, gbc_lblNumSocios);
		
		txtNumSocios = new JTextField();
		GridBagConstraints gbc_txtNumSocios = new GridBagConstraints();
		gbc_txtCapacidad.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumSocios.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumSocios.gridx = 1;
		gbc_txtNumSocios.gridy = 8;
		panelCentro.add(txtNumSocios, gbc_txtNumSocios);
		txtNumTrabajadores.setColumns(10);
		
		lblNumSocios.setVisible(false);
		txtNumSocios.setVisible(false);
		
		if(!aniadir) {
			rdbtnPrivado.setEnabled(false);
			rdbtnPublico.setEnabled(false);
			cargarInfo();
		}

		this.setModal(true);
	}
	
	private void cargarInfo() {
		
		if(publico) {
			txtNombre.setText(aeropuertoPublico.getAeropuerto().getNombre());
			txtPais.setText(aeropuertoPublico.getAeropuerto().getDireccion().getPais());
			txtCiudad.setText(aeropuertoPublico.getAeropuerto().getDireccion().getCiudad());
			txtCalle.setText(aeropuertoPublico.getAeropuerto().getDireccion().getCalle());
			txtNumero.setText("" + aeropuertoPublico.getAeropuerto().getDireccion().getNumero());
			txtAnio.setText("" + aeropuertoPublico.getAeropuerto().getAnioInauguracion());
			txtCapacidad.setText("" + aeropuertoPublico.getAeropuerto().getCapacidad());
			txtNumTrabajadores.setText("" + aeropuertoPublico.getNum_trabajadores());
			txtFinanciacion.setText("" + aeropuertoPublico.getFinanciacion());
		}
		else {
			txtNombre.setText(aeropuertoPrivado.getAeropuerto().getNombre());
			txtPais.setText(aeropuertoPrivado.getAeropuerto().getDireccion().getPais());
			txtCiudad.setText(aeropuertoPrivado.getAeropuerto().getDireccion().getCiudad());
			txtCalle.setText(aeropuertoPrivado.getAeropuerto().getDireccion().getCalle());
			txtNumero.setText("" + aeropuertoPrivado.getAeropuerto().getDireccion().getNumero());
			txtAnio.setText("" + aeropuertoPrivado.getAeropuerto().getAnioInauguracion());
			txtCapacidad.setText("" + aeropuertoPrivado.getAeropuerto().getCapacidad());
			txtNumSocios.setText(""+ aeropuertoPrivado.getNum_socios());
		}
	}
	
	private void gestionarEventos() {
		
		rdbtnPublico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblNumSocios.setVisible(false);
				txtNumSocios.setVisible(false);
				
				lblFinanciacion.setVisible(true);
				txtFinanciacion.setVisible(true);
				lblNumTrabajadores.setVisible(true);
				txtNumTrabajadores.setVisible(true);
				
			}
		});
		
		rdbtnPrivado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblNumSocios.setVisible(true);
				txtNumSocios.setVisible(true);
				
				lblFinanciacion.setVisible(false);
				txtFinanciacion.setVisible(false);
				lblNumTrabajadores.setVisible(false);
				txtNumTrabajadores.setVisible(false);
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
	}

}
