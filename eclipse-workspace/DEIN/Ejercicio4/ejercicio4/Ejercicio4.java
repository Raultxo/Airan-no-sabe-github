package ejercicio4;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;

public class Ejercicio4 {

	private JLabel lblHora1, lblHora2, lblMinuto1, lblMinuto2, lblSegundo1, lblSegundo2;
	private HashMap<Integer, String> mapaImgs;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					new Ejercicio4();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio4() {
		mapaImgs = new HashMap<Integer, String>();
		mapaImgs.put(0,"/ejercicio4/imagenes/ZERO.png");
		mapaImgs.put(1,"/ejercicio4/imagenes/ONE.png");
		mapaImgs.put(2,"/ejercicio4/imagenes/TWO.png");
		mapaImgs.put(3,"/ejercicio4/imagenes/THREE.png");
		mapaImgs.put(4,"/ejercicio4/imagenes/FOUR.png");
		mapaImgs.put(5,"/ejercicio4/imagenes/FIVE.png");
		mapaImgs.put(6,"/ejercicio4/imagenes/SIX.png");
		mapaImgs.put(7,"/ejercicio4/imagenes/SEVEN.png");
		mapaImgs.put(8,"/ejercicio4/imagenes/EIGHT.png");
		mapaImgs.put(9,"/ejercicio4/imagenes/NINE.png");
		
		dibujar();
		gestionarEventos();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void dibujar() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Ejercicio4.class.getResource("/ejercicio4/imagenes/reloj.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 484, 438);
		
		frame.getContentPane().setLayout(null);
		
		lblSegundo2 = new JLabel("");
		lblSegundo2.setBounds(394, 166, 54, 133);
		frame.getContentPane().add(lblSegundo2);
		
		lblSegundo1 = new JLabel("");
		lblSegundo1.setBounds(340, 166, 54, 133);
		frame.getContentPane().add(lblSegundo1);
		
		JLabel lblDosPuntos2 = new JLabel(":");
		lblDosPuntos2.setForeground(new Color(255, 69, 0));
		lblDosPuntos2.setFont(new Font("Dialog", Font.BOLD, 60));
		lblDosPuntos2.setBounds(304, 165, 24, 113);
		frame.getContentPane().add(lblDosPuntos2);
		
		lblMinuto2 = new JLabel("");
		lblMinuto2.setBounds(238, 166, 54, 133);
		frame.getContentPane().add(lblMinuto2);
		
		lblMinuto1 = new JLabel("");
		lblMinuto1.setBounds(184, 165, 54, 133);
		frame.getContentPane().add(lblMinuto1);
		
		JLabel lblDosPuntos1 = new JLabel(":");
		lblDosPuntos1.setFont(new Font("Dialog", Font.BOLD, 60));
		lblDosPuntos1.setForeground(new Color(255, 69, 0));
		lblDosPuntos1.setBounds(148, 165, 24, 113);
		frame.getContentPane().add(lblDosPuntos1);
		
		lblHora2 = new JLabel("");
		lblHora2.setBounds(87, 166, 54, 133);
		frame.getContentPane().add(lblHora2);
		
		lblHora1 = new JLabel("");
		lblHora1.setBounds(35, 165, 54, 133);
		frame.getContentPane().add(lblHora1);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 478, 412);
		lblFondo.setIcon(new ImageIcon(Ejercicio4.class.getResource("/ejercicio4/imagenes/fondoReloj.png")));
		frame.getContentPane().add(lblFondo);
		frame.setVisible(true);
	}

	private void gestionarEventos() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				actualizarReloj();
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);	
	}
	
	public void actualizarReloj() {

		int hora = LocalTime.now().getHour();
		int mins = LocalTime.now().getMinute();
		int secs = LocalTime.now().getSecond();
		
		lblHora1.setIcon(new ImageIcon(Ejercicio4.class.getResource(mapaImgs.get(hora / 10))));
		lblHora2.setIcon(new ImageIcon(Ejercicio4.class.getResource(mapaImgs.get(hora % 10))));
		lblMinuto1.setIcon(new ImageIcon(Ejercicio4.class.getResource(mapaImgs.get(mins / 10))));
		lblMinuto2.setIcon(new ImageIcon(Ejercicio4.class.getResource(mapaImgs.get(mins % 10))));
		lblSegundo1.setIcon(new ImageIcon(Ejercicio4.class.getResource(mapaImgs.get(secs / 10))));
		lblSegundo2.setIcon(new ImageIcon(Ejercicio4.class.getResource(mapaImgs.get(secs % 10))));
		
	}

}
