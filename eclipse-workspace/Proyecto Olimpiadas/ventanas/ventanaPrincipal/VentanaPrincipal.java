package ventanaPrincipal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import consultas.ConsultasEventos;
import consultas.ConsultasOlimpiadas;
import consultas.ConsultasParticipaciones;
import dialogosGestion.DialogoEventos;
import dialogosGestion.DialogoOlimpiadas;
import dialogosGestion.DialogoParticipaciones;
import tablas.Evento;
import tablas.Olimpiada;
import tablas.Participacion;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JComboBox<Olimpiada> comboOlimpiadas;
	private ConsultasOlimpiadas cOlimpiada;
	private ConsultasEventos cEvento;
	private ConsultasParticipaciones cParticipacion;
	private JButton btnAniadirOlimpiada, btnEditarOlimpiada, btnEliminarOlimpiada;
	private JButton btnAniadirEvento, btnEditarEvento, btnEliminarEvento;
	private JButton btnEditarParticipacion, btnAniadirParticipacion, btnEliminarParticipacion;
	private JList<Evento> listaEventos;
	private JList<Participacion> listaParticipaciones;
	private JMenuItem mntmIdiomaEsp, mntmIdiomaIng, mntmIdiomaEus;
	private JTextField txtBuscarEvento;
	private JPanel panelBuscar;
	private JLabel lblImgbuscar;
	
	public VentanaPrincipal() {
		
		cOlimpiada = new ConsultasOlimpiadas();
		cEvento = new ConsultasEventos();
		cParticipacion = new ConsultasParticipaciones();
		
		dibujar();
		cargarDatos();
		gestionarEventos();
	}
	
	private void dibujar() {
		setBounds(100, 100, 1000, 500);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menu = new JMenuBar();
		panelPrincipal.add(menu, BorderLayout.NORTH);
		
		JMenu Idioma = new JMenu("Idioma");
		menu.add(Idioma);
		
		mntmIdiomaEsp = new JMenuItem("Espa??ol");
		Idioma.add(mntmIdiomaEsp);
		
		mntmIdiomaIng = new JMenuItem("Ingles");
		Idioma.add(mntmIdiomaIng);
		
		mntmIdiomaEus = new JMenuItem("Euskera");
		Idioma.add(mntmIdiomaEus);
		
		JPanel panel = new JPanel();
		panelPrincipal.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{549, 294, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 126, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblOlimpiada = new JLabel("Olimpiada:");
		GridBagConstraints gbc_lblOlimpiada = new GridBagConstraints();
		gbc_lblOlimpiada.insets = new Insets(0, 0, 5, 5);
		gbc_lblOlimpiada.anchor = GridBagConstraints.EAST;
		gbc_lblOlimpiada.gridx = 0;
		gbc_lblOlimpiada.gridy = 0;
		panel.add(lblOlimpiada, gbc_lblOlimpiada);
		
		comboOlimpiadas = new JComboBox<Olimpiada>();
		GridBagConstraints gbc_comboOlimpiadas = new GridBagConstraints();
		gbc_comboOlimpiadas.insets = new Insets(0, 0, 5, 5);
		gbc_comboOlimpiadas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboOlimpiadas.gridx = 1;
		gbc_comboOlimpiadas.gridy = 0;
		panel.add(comboOlimpiadas, gbc_comboOlimpiadas);
		
		JPanel panelBotonesOlimpiada = new JPanel();
		panelBotonesOlimpiada.setBorder(new EmptyBorder(0, 0, 0, 5));
		GridBagConstraints gbc_panelBotonesOlimpiada = new GridBagConstraints();
		gbc_panelBotonesOlimpiada.anchor = GridBagConstraints.WEST;
		gbc_panelBotonesOlimpiada.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotonesOlimpiada.gridx = 2;
		gbc_panelBotonesOlimpiada.gridy = 0;
		panel.add(panelBotonesOlimpiada, gbc_panelBotonesOlimpiada);
		panelBotonesOlimpiada.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnAniadirOlimpiada = new JButton("");
		panelBotonesOlimpiada.add(btnAniadirOlimpiada);
		btnAniadirOlimpiada.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/add.png")));
		
		btnEditarOlimpiada = new JButton("");
		panelBotonesOlimpiada.add(btnEditarOlimpiada);
		btnEditarOlimpiada.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/edit.png")));
		
		btnEliminarOlimpiada = new JButton("");
		panelBotonesOlimpiada.add(btnEliminarOlimpiada);
		btnEliminarOlimpiada.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/delete.png")));
			
		JLabel lblListaDeEventos = new JLabel("Lista de eventos");
		GridBagConstraints gbc_lblListaDeEventos = new GridBagConstraints();
		gbc_lblListaDeEventos.insets = new Insets(0, 0, 5, 5);
		gbc_lblListaDeEventos.gridx = 0;
		gbc_lblListaDeEventos.gridy = 1;
		panel.add(lblListaDeEventos, gbc_lblListaDeEventos);
		
		JLabel lblListaDeParticipantes = new JLabel("Lista de participaciones");
		GridBagConstraints gbc_lblListaDeParticipantes = new GridBagConstraints();
		gbc_lblListaDeParticipantes.gridwidth = 2;
		gbc_lblListaDeParticipantes.insets = new Insets(0, 0, 5, 0);
		gbc_lblListaDeParticipantes.gridx = 1;
		gbc_lblListaDeParticipantes.gridy = 1;
		panel.add(lblListaDeParticipantes, gbc_lblListaDeParticipantes);
		
		panelBuscar = new JPanel();
		GridBagConstraints gbc_panelBuscar = new GridBagConstraints();
		gbc_panelBuscar.fill = GridBagConstraints.BOTH;
		gbc_panelBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_panelBuscar.gridx = 0;
		gbc_panelBuscar.gridy = 2;
		panel.add(panelBuscar, gbc_panelBuscar);
		GridBagLayout gbl_panelBuscar = new GridBagLayout();
		gbl_panelBuscar.columnWidths = new int[]{40, 0, 0};
		gbl_panelBuscar.rowHeights = new int[]{0, 0};
		gbl_panelBuscar.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelBuscar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBuscar.setLayout(gbl_panelBuscar);
		
		lblImgbuscar = new JLabel("");
		lblImgbuscar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/search.png")));
		GridBagConstraints gbc_lblImgbuscar = new GridBagConstraints();
		gbc_lblImgbuscar.insets = new Insets(0, 0, 0, 5);
		gbc_lblImgbuscar.gridx = 0;
		gbc_lblImgbuscar.gridy = 0;
		panelBuscar.add(lblImgbuscar, gbc_lblImgbuscar);
		
		txtBuscarEvento = new JTextField();
		GridBagConstraints gbc_txtBuscarEvento = new GridBagConstraints();
		gbc_txtBuscarEvento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBuscarEvento.gridx = 1;
		gbc_txtBuscarEvento.gridy = 0;
		panelBuscar.add(txtBuscarEvento, gbc_txtBuscarEvento);
		txtBuscarEvento.setColumns(10);
		
		JScrollPane scrollEventos = new JScrollPane();
		GridBagConstraints gbc_scrollEventos = new GridBagConstraints();
		gbc_scrollEventos.fill = GridBagConstraints.BOTH;
		gbc_scrollEventos.insets = new Insets(0, 0, 5, 5);
		gbc_scrollEventos.gridx = 0;
		gbc_scrollEventos.gridy = 3;
		panel.add(scrollEventos, gbc_scrollEventos);
		
		listaEventos = new JList<Evento>();
		scrollEventos.setViewportView(listaEventos);
		
		JScrollPane scrollParticipantes = new JScrollPane();
		GridBagConstraints gbc_scrollParticipantes = new GridBagConstraints();
		gbc_scrollParticipantes.fill = GridBagConstraints.BOTH;
		gbc_scrollParticipantes.gridwidth = 2;
		gbc_scrollParticipantes.insets = new Insets(0, 0, 5, 0);
		gbc_scrollParticipantes.gridx = 1;
		gbc_scrollParticipantes.gridy = 3;
		panel.add(scrollParticipantes, gbc_scrollParticipantes);
		
		listaParticipaciones = new JList<Participacion>();
		scrollParticipantes.setViewportView(listaParticipaciones);
		
		JPanel panelBotonesEventos = new JPanel();
		GridBagConstraints gbc_panelBotonesEventos = new GridBagConstraints();
		gbc_panelBotonesEventos.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotonesEventos.gridx = 0;
		gbc_panelBotonesEventos.gridy = 4;
		panel.add(panelBotonesEventos, gbc_panelBotonesEventos);
		panelBotonesEventos.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnAniadirEvento = new JButton("");
		btnAniadirEvento.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/add.png")));
		panelBotonesEventos.add(btnAniadirEvento);
		
		btnEditarEvento = new JButton("");
		btnEditarEvento.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/edit.png")));
		panelBotonesEventos.add(btnEditarEvento);
		
		btnEliminarEvento = new JButton("");
		btnEliminarEvento.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/delete.png")));
		panelBotonesEventos.add(btnEliminarEvento);
		
		JPanel panelBotonesParticipaciones = new JPanel();
		GridBagConstraints gbc_panelBotonesParticipaciones = new GridBagConstraints();
		gbc_panelBotonesParticipaciones.gridwidth = 2;
		gbc_panelBotonesParticipaciones.gridx = 1;
		gbc_panelBotonesParticipaciones.gridy = 4;
		panel.add(panelBotonesParticipaciones, gbc_panelBotonesParticipaciones);
		panelBotonesParticipaciones.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnAniadirParticipacion = new JButton("");
		btnAniadirParticipacion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/add.png")));
		panelBotonesParticipaciones.add(btnAniadirParticipacion);
		
		btnEditarParticipacion = new JButton("");
		btnEditarParticipacion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/edit.png")));
		panelBotonesParticipaciones.add(btnEditarParticipacion);
		
		btnEliminarParticipacion = new JButton("");
		btnEliminarParticipacion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/delete.png")));
		panelBotonesParticipaciones.add(btnEliminarParticipacion);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void cargarDatos() {
		cargarOlimpiadas();
		cargarEventos();
	}
	
	private void gestionarEventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cEvento.cerrarConexion();
				cOlimpiada.cerrarConexion();
				cParticipacion.cerrarConexion();
			}
		});
		
		gestionarEventosOlimpiadas();
		gestionarEventosDeEventos();
		gestionarEventosParticipaciones();
	}

	private void gestionarEventosOlimpiadas() {
		btnAniadirOlimpiada.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				DialogoOlimpiadas dialogoOlimpiadas = new DialogoOlimpiadas();
				dialogoOlimpiadas.setVisible(true);
				cargarOlimpiadas();
			}
		});
		
		btnEditarOlimpiada.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				DialogoOlimpiadas dialogoOlimpiadas = new DialogoOlimpiadas((Olimpiada) comboOlimpiadas.getSelectedItem());
				dialogoOlimpiadas.setVisible(true);
			}
		});
		
		btnEliminarOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar la olimpiada?", "Borrar olimpiada", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					if(cOlimpiada.borrarOlimpiada((Olimpiada) comboOlimpiadas.getSelectedItem())) {
						JOptionPane.showMessageDialog(getContentPane(), "Olimpiada borrada correctamente");
						cargarOlimpiadas();
					}
					else {
						JOptionPane.showMessageDialog(getContentPane(), "No se puede borrar, existen dependencias");
					}		    
				} 	
			}
		});
		comboOlimpiadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarEventos();
			}
		});
		txtBuscarEvento.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				DefaultListModel<Evento> modelo = new DefaultListModel<Evento>();
				modelo.addAll(cEvento.listaEventos((Olimpiada) comboOlimpiadas.getSelectedItem(), txtBuscarEvento.getText()));
				listaEventos.setModel(modelo);
				if(modelo.size() > 0) {
					listaEventos.setSelectedIndex(0);
					btnEditarEvento.setEnabled(true);
					btnEliminarEvento.setEnabled(true);
					btnAniadirParticipacion.setEnabled(true);
				}
				else {
					btnEditarEvento.setEnabled(false);
					btnEliminarEvento.setEnabled(false);
					btnAniadirParticipacion.setEnabled(false);
				}
				cargarParticipaciones();	
			}
		});
	}
	
	private void gestionarEventosDeEventos() {
		btnAniadirEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoEventos dialogoEventos = new DialogoEventos((Olimpiada) comboOlimpiadas.getSelectedItem());
				dialogoEventos.setVisible(true);
				cargarEventos();
			}
		});
		
		btnEditarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoEventos dialogoEventos = new DialogoEventos((Olimpiada) comboOlimpiadas.getSelectedItem(), listaEventos.getSelectedValue());
				dialogoEventos.setVisible(true);
				cargarEventos();
			}
		});
		
		btnEliminarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar el Evento?", "Borrar evento", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					if(cEvento.elimiarEvento(listaEventos.getSelectedValue())) {
						JOptionPane.showMessageDialog(getContentPane(), "Evento borrado correctamente");
						cargarEventos();
					}
					else {
						JOptionPane.showMessageDialog(getContentPane(), "No se puede borrar el evento, existen dependencias");
					}
				    
				} 	
			}
		});
		
		listaEventos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				cargarParticipaciones();
			}
		});
	}
	
	private void gestionarEventosParticipaciones() {
		btnAniadirParticipacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoParticipaciones dialogParticipaciones = new DialogoParticipaciones();
				dialogParticipaciones.setVisible(true);
			}
		});
		
		btnEditarParticipacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DialogoParticipaciones dialogoParticipaciones = new DialogoParticipaciones(listaParticipaciones.getSelectedValue());
				dialogoParticipaciones.setVisible(true);	
			}
		});
		
		btnEliminarParticipacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar la participacion?", "Borrar participacion", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					if(cParticipacion.borrarParticipacion((Participacion) listaParticipaciones.getSelectedValue())) {
						JOptionPane.showMessageDialog(getContentPane(), "Participacion borrada correctamente");
						cargarOlimpiadas();
					}
				} 
			}
		});
	}
	
	private void cargarOlimpiadas() {
		DefaultComboBoxModel<Olimpiada> modelo = new DefaultComboBoxModel<Olimpiada>();
		modelo.addAll(cOlimpiada.listaOlimpiadas());
		comboOlimpiadas.setModel(modelo);
		if(modelo.getSize() > 0) {
			comboOlimpiadas.setSelectedIndex(0);
			btnEditarOlimpiada.setEnabled(true);
			btnEliminarOlimpiada.setEnabled(true);
			btnAniadirEvento.setEnabled(true);
		}
		else {
			btnEditarOlimpiada.setEnabled(false);
			btnEliminarOlimpiada.setEnabled(false);
			btnAniadirEvento.setEnabled(false);
		}
	}
	
	private void cargarEventos() {
		DefaultListModel<Evento> modelo = new DefaultListModel<Evento>();
		modelo.addAll(cEvento.listaEventos((Olimpiada) comboOlimpiadas.getSelectedItem(), ""));
		listaEventos.setModel(modelo);
		if(modelo.size() > 0) {
			listaEventos.setSelectedIndex(0);
			btnEditarEvento.setEnabled(true);
			btnEliminarEvento.setEnabled(true);
			btnAniadirParticipacion.setEnabled(true);
		}
		else {
			btnEditarEvento.setEnabled(false);
			btnEliminarEvento.setEnabled(false);
			btnAniadirParticipacion.setEnabled(false);
		}
		
		cargarParticipaciones();
	}
	
	private void cargarParticipaciones() {
		DefaultListModel<Participacion> modelo = new DefaultListModel<Participacion>();
		modelo.addAll(cParticipacion.listaParticipacionesPorEvento(listaEventos.getSelectedValue()));
		listaParticipaciones.setModel(modelo);
		if(modelo.size() > 0) {
			listaParticipaciones.setSelectedIndex(0);
			btnEditarParticipacion.setEnabled(true);
			btnEliminarParticipacion.setEnabled(true);
		}
		else {
			btnEditarParticipacion.setEnabled(false);
			btnEliminarParticipacion.setEnabled(false);
		}
	}

}
