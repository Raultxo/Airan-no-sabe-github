package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import beans.Usuario;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.awt.Color;
import gestion.GestionConexion;
import gestion.GestionUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private GestionUsuario gestionUsuarios;
	private JButton btnCancelar, btnLogin;
	private JLabel lblError;
	private boolean estadoLogin;
	private JTextField txtUsuario;
	private JPasswordField passPassword;
	
	/**
	 * Create the application.
	 */
	public Login() {
		
		gestionUsuarios = new GestionUsuario();
		
		dibujar();
		gestionarEventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void dibujar() {
		this.setTitle("AVIONES - LOGIN");
		this.setResizable(false);
		this.setBounds(100, 100, 466, 171);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		this.getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCredenciales = new JLabel("INTRODUCE TUS CREDENCIALES");
		lblCredenciales.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCredenciales.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorte.add(lblCredenciales);
		
		JPanel panelSur = new JPanel();
		this.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		panelSur.add(btnCancelar);
		
		btnLogin = new JButton("Login");
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		panelSur.add(btnLogin);
		
		lblError = new JLabel("Credenciales incorrectas");
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		panelSur.add(lblError);
		
		JPanel panelCentro = new JPanel();
		this.getContentPane().add(panelCentro, BorderLayout.WEST);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[]{93, 347, 0};
		gbl_panelCentro.rowHeights = new int[]{42, 42, 0};
		gbl_panelCentro.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCentro.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		JLabel lblUsuario_1 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario_1 = new GridBagConstraints();
		gbc_lblUsuario_1.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario_1.gridx = 0;
		gbc_lblUsuario_1.gridy = 0;
		panelCentro.add(lblUsuario_1, gbc_lblUsuario_1);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtTxtusuario = new GridBagConstraints();
		gbc_txtTxtusuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtTxtusuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTxtusuario.gridx = 1;
		gbc_txtTxtusuario.gridy = 0;
		panelCentro.add(txtUsuario, gbc_txtTxtusuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		panelCentro.add(lblPassword, gbc_lblPassword);
		
		passPassword = new JPasswordField();
		GridBagConstraints gbc_pwdPwdpassword = new GridBagConstraints();
		gbc_pwdPwdpassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPwdpassword.gridx = 1;
		gbc_pwdPwdpassword.gridy = 1;
		panelCentro.add(passPassword, gbc_pwdPwdpassword);
		this.pack();
		this.setVisible(true);
	}
	
	private void gestionarEventos() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario user = new Usuario(txtUsuario.getText(), passPassword.getText());
				switch(gestionUsuarios.comprobarLogin(user)) {
				case 1:
					lblError.setVisible(false);
					estadoLogin = true;
					dispose();
					new VentanaPrincipal();
					break;
				case 0:
					lblError.setText("Credenciales incorrectas");
					estadoLogin = false;
					lblError.setVisible(true);
					break;
				case -1:
					lblError.setText("Error de conexion");
					lblError.setVisible(true);
					estadoLogin = false;
					break;
				}
				
			}
		});
	}

	public boolean isEstadoLogin() {
		return estadoLogin;
	}
	
}
