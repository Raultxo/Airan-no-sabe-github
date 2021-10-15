package prueba;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana {

	private JFrame frame;
	private JButton btnSeleccionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		dibujar();
		eventos();
	}
	
	private void dibujar() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JRadioButton rdbtnRadio_1 = new JRadioButton("Radio2");
		frame.getContentPane().add(rdbtnRadio_1);
		
		JRadioButton rdbtnRadio = new JRadioButton("Radio1");
		frame.getContentPane().add(rdbtnRadio);
		
		btnSeleccionar = new JButton("Seleccionar");
		
		frame.getContentPane().add(btnSeleccionar);
	}
	
	private void eventos() {
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSeleccionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSeleccionar.setBackground(new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255)));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSeleccionar.setBackground(new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255)));
			}
		});
	}

}
