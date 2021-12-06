package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.setResizable(false);
		frame.setBounds(100, 100, 390, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JLabel iconLogin = new JLabel("");
		iconLogin.setBounds(123, 26, 128, 128);
		iconLogin.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/user_icon-icons.com_66546.png")));
		frame.getContentPane().add(iconLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsuario.setBounds(59, 198, 54, 16);
		frame.getContentPane().add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(59, 221, 255, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Dialog", Font.BOLD, 13));
		lblContraseña.setBounds(59, 258, 78, 16);
		frame.getContentPane().add(lblContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(60, 286, 255, 25);
		frame.getContentPane().add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		panel.setBounds(0, 371, 374, 136);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarse registrarse = new Registrarse();
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBounds(113, 79, 147, 35);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/adduser_añadir_3553.png")));
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
			}
		});
		btnAcceder.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAcceder.setBounds(113, 22, 147, 35);
		btnAcceder.setBackground(Color.WHITE);
		btnAcceder.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/login-square-arrow-button-outline_icon-icons.com_73220.png")));
		panel.setLayout(null);
		panel.add(btnNewButton);
		panel.add(btnAcceder);
	}
}
