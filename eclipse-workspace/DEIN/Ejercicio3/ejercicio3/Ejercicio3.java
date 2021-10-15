package ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 {

	private boolean luces = true;
	private JLabel lblCoche, lblColorRojo, lblColorAzulClaro, lblColorAzulOscuro, lblColorNegro, lblColorPlateado, lblColorBlanco, lblColorGris, lblColorNaranja, lblIconoLuces, lblLuces, lblConfiguracion, lblSeleccionar;
	private JButton btnBotonES, btnNBotonEN, btnBotonEUS;
	private JFrame frame;
	private final JPanel panelLuces = new JPanel();
	private Locale locale;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 window = new Ejercicio3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio3() {
		locale = new Locale("es", "ES");
		dibujar(locale);
		eventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void dibujar(Locale locale) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 750, 537);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panelColores = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelColores, -54, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelColores, 0, SpringLayout.SOUTH, frame.getContentPane());
		panelColores.setBackground(Color.BLACK);
		frame.getContentPane().add(panelColores);
		panelColores.setLayout(new GridLayout(0, 8, 0, 0));
		
		lblColorRojo = new JLabel("");
		lblColorRojo.setHorizontalAlignment(SwingConstants.CENTER);
		lblColorRojo.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/colores/colorBlazingRed.jpg")));
		panelColores.add(lblColorRojo);
		
		lblColorAzulClaro = new JLabel("");
		lblColorAzulClaro.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/colores/colorElectricBlue.jpg")));
		lblColorAzulClaro.setHorizontalAlignment(SwingConstants.CENTER);
		panelColores.add(lblColorAzulClaro);
		
		lblColorAzulOscuro = new JLabel("");
		lblColorAzulOscuro.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/colores/colorLapisluxuryBlue.jpg"))); 
		lblColorAzulOscuro.setHorizontalAlignment(SwingConstants.CENTER);
		panelColores.add(lblColorAzulOscuro);
		
		lblColorNegro = new JLabel("");
		lblColorNegro.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/colores/colorMidnightBlack.jpg"))); 
		lblColorNegro.setHorizontalAlignment(SwingConstants.CENTER);
		panelColores.add(lblColorNegro);
		
		lblColorPlateado = new JLabel("");
		lblColorPlateado.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/colores/colorMoonwalkGrey.jpg")));
		lblColorPlateado.setHorizontalAlignment(SwingConstants.CENTER);
		panelColores.add(lblColorPlateado);
		
		lblColorBlanco = new JLabel("");
		lblColorBlanco.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/colores/colorPepperWhite.jpg")));
		lblColorBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		panelColores.add(lblColorBlanco);
		
		lblColorGris = new JLabel("");
		lblColorGris.setHorizontalAlignment(SwingConstants.CENTER);
		lblColorGris.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/colores/colorThunderGray.jpg"))); 
		panelColores.add(lblColorGris);
		
		lblColorNaranja = new JLabel("");
		lblColorNaranja.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/colores/colorVolcaninOrange.jpg"))); 
		lblColorNaranja.setHorizontalAlignment(SwingConstants.CENTER);
		panelColores.add(lblColorNaranja);
		
		JPanel panelNorte = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelLuces, 0, SpringLayout.SOUTH, panelNorte);
		springLayout.putConstraint(SpringLayout.NORTH, panelNorte, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelNorte, 91, SpringLayout.NORTH, frame.getContentPane());
		panelNorte.setBackground(Color.BLACK);
		frame.getContentPane().add(panelNorte);
		panelNorte.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblImagenMarca = new JLabel("");
		lblImagenMarca.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/images/cooperLogo.png")));
		panelNorte.add(lblImagenMarca);
		
		lblConfiguracion = new JLabel(Messages.getString("Ejercicio3.18", locale)); 
		lblConfiguracion.setForeground(Color.WHITE);
		lblConfiguracion.setHorizontalAlignment(SwingConstants.RIGHT);
		panelNorte.add(lblConfiguracion);
		
		lblSeleccionar = new JLabel(Messages.getString("Ejercicio3.19", locale));
		springLayout.putConstraint(SpringLayout.SOUTH, panelLuces, 0, SpringLayout.NORTH, lblSeleccionar);
		springLayout.putConstraint(SpringLayout.WEST, lblSeleccionar, 67, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblSeleccionar, -64, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSeleccionar, -57, SpringLayout.EAST, frame.getContentPane());
		lblSeleccionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionar.setForeground(Color.WHITE);
		frame.getContentPane().add(lblSeleccionar);
		
		JPanel panelOeste = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panelLuces, 0, SpringLayout.EAST, panelOeste);
		panelOeste.setBackground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.WEST, panelNorte, 0, SpringLayout.EAST, panelOeste);
		springLayout.putConstraint(SpringLayout.WEST, panelColores, 0, SpringLayout.EAST, panelOeste);
		springLayout.putConstraint(SpringLayout.WEST, panelOeste, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelOeste, 50, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelOeste, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panelOeste, 0, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(panelOeste);
		
		JPanel panelEste = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panelLuces, 0, SpringLayout.WEST, panelEste);
		panelEste.setBackground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.WEST, panelEste, -50, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelNorte, 0, SpringLayout.WEST, panelEste);
		springLayout.putConstraint(SpringLayout.EAST, panelColores, 0, SpringLayout.WEST, panelEste);
		springLayout.putConstraint(SpringLayout.EAST, panelEste, 0, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panelEste, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelEste, 0, SpringLayout.SOUTH, panelColores);
		frame.getContentPane().add(panelEste);
		panelEste.setLayout(null);
		
		JPanel panelBotonesIdioma = new JPanel();
		panelBotonesIdioma.setBounds(-16, 170, 87, 172);
		panelEste.add(panelBotonesIdioma);
		panelBotonesIdioma.setLayout(new GridLayout(3, 0, 0, 0));
		
		btnBotonES = new JButton("ES");
		
		btnBotonES.setBackground(Color.BLACK);
		btnBotonES.setForeground(Color.WHITE);
		panelBotonesIdioma.add(btnBotonES);
		
		btnNBotonEN = new JButton("EN");
		btnNBotonEN.setBackground(Color.BLACK);
		btnNBotonEN.setForeground(Color.WHITE);
		panelBotonesIdioma.add(btnNBotonEN);
		
		btnBotonEUS = new JButton("EUS");
		btnBotonEUS.setBackground(Color.BLACK);
		btnBotonEUS.setForeground(Color.WHITE);
		btnBotonEUS.setFont(new Font("Dialog", Font.BOLD, 12));
		panelBotonesIdioma.add(btnBotonEUS);
		
		JPanel panelCoche = new JPanel();
		panelCoche.setBackground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.NORTH, panelCoche, 0, SpringLayout.SOUTH, panelNorte);
		springLayout.putConstraint(SpringLayout.WEST, panelCoche, 0, SpringLayout.EAST, panelOeste);
		SpringLayout sl_panelOeste = new SpringLayout();
		panelOeste.setLayout(sl_panelOeste);
		
		lblIconoLuces = new JLabel("");
		
		lblCoche = new JLabel("");
		lblCoche.setBackground(Color.BLACK);
		lblCoche.setOpaque(true);
		lblCoche.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniBlazingRed.png"))); 
		panelCoche.add(lblCoche);
		
		sl_panelOeste.putConstraint(SpringLayout.NORTH, lblIconoLuces, 135, SpringLayout.NORTH, panelOeste);
		sl_panelOeste.putConstraint(SpringLayout.EAST, lblIconoLuces, -10, SpringLayout.EAST, panelOeste);
		lblIconoLuces.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/images/lucesOn.png"))); 
		panelOeste.add(lblIconoLuces);
		panelLuces.setOpaque(false);
		panelLuces.setBackground(Color.BLACK);
		frame.getContentPane().add(panelLuces);
		panelLuces.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblLuces = new JLabel("");
		lblLuces.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuces.setVisible(false);
		lblLuces.setBackground(Color.BLACK);
		lblLuces.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/images/autoLuz.png"))); 
		panelLuces.add(lblLuces);
		springLayout.putConstraint(SpringLayout.SOUTH, panelCoche, 0, SpringLayout.NORTH, lblSeleccionar);
		springLayout.putConstraint(SpringLayout.EAST, panelCoche, 0, SpringLayout.WEST, panelEste);
		frame.getContentPane().add(panelCoche);
		panelCoche.setLayout(new GridLayout(1, 0, 0, 0));
		
		
	}
	
	private void eventos() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblColorRojo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniBlazingRed.png")));
				
			}
		});
		
		lblColorAzulClaro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniElectricBlue.png")));
				
			}
		});
		
		lblColorAzulOscuro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniLapisluxuryBlue.png")));
	
			}
		});
		
		lblColorNegro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniMidnightBlack.png")));
			
			}
		});
		
		lblColorPlateado.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniMoonwalkGrey.png"))); 
			
			}
		});
		
		lblColorBlanco.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniPepperWhite.png"))); //$NON-NLS-1$
			
			}
		});
		
		lblColorGris.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniLapisluxuryBlue.png"))); //$NON-NLS-1$
			
			}
		});
		
		lblColorNaranja.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCoche.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/coches/miniElectricBlue.png"))); //$NON-NLS-1$
			}
		});
		
		lblIconoLuces.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(luces) {
					lblIconoLuces.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/images/lucesOff.png"))); //$NON-NLS-1$
					lblLuces.setVisible(true);
					luces = false;
				}
				else {
					lblIconoLuces.setIcon(new ImageIcon(Ejercicio3.class.getResource("/ejercicio3/iconos/images/lucesOn.png"))); //$NON-NLS-1$
					lblLuces.setVisible(false);
					luces = true;
				}
			}
		});
		
		btnBotonES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				locale = new Locale("es", "ES");
				lblConfiguracion.setText(Messages.getString("Ejercicio3.18", locale));
				lblSeleccionar.setText(Messages.getString("Ejercicio3.19", locale));
			}
		});
		btnNBotonEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				locale = new Locale("en", "GB");
				lblConfiguracion.setText(Messages.getString("Ejercicio3.18", locale));
				lblSeleccionar.setText(Messages.getString("Ejercicio3.19", locale));
			}
		});
		btnBotonEUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				locale = new Locale("eu", "ES");
				lblConfiguracion.setText(Messages.getString("Ejercicio3.18", locale));
				lblSeleccionar.setText(Messages.getString("Ejercicio3.19", locale));
			}
		});
	}
}
