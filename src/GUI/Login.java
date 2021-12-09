package GUI;

import java.awt.EventQueue;
import MysqlConfig.MysqlConnector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class Login {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private JPasswordField passContraseña;
	private MysqlConnector objConn;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}
	
	
	
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/user_icon-icons.com_66546.png")));
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 390, 546);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setVisible(true);
		
		JLabel iconLogin = new JLabel("");
		iconLogin.setBounds(123, 26, 128, 128);
		iconLogin.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/user_icon-icons.com_66546.png")));
		frmLogin.getContentPane().add(iconLogin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsuario.setBounds(59, 198, 54, 16);
		frmLogin.getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(59, 221, 255, 25);
		frmLogin.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Dialog", Font.BOLD, 13));
		lblContraseña.setBounds(59, 258, 78, 16);
		frmLogin.getContentPane().add(lblContraseña);
		
		passContraseña = new JPasswordField();
		passContraseña.setBounds(60, 286, 255, 25);
		frmLogin.getContentPane().add(passContraseña);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 371, 374, 136);
		frmLogin.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				new AgregarUsuario("Login");
				frmLogin.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBounds(113, 79, 147, 35);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/adduser_añadir_3553.png")));
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
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
	
	//METODOS
	
	private void login() {
		String usuario = txtUsuario.getText().trim();
		String contraseña = new String(passContraseña.getPassword()).trim();
		Boolean UsuarioExiste = false;
		
		
		if(usuario.isEmpty() || contraseña.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe ingresar su usuario y contraseña, si no está registrado debe registrarse", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				objConn = new MysqlConnector();
				ResultSet result = objConn.ejecutarConsulta("SELECT * FROM Usuarios");
				result.next();
				do {
					if((usuario.equals(result.getString("Usuario"))) && (contraseña.equals(result.getString("Contraseña")))) {
						UsuarioExiste = true;
					}
				} while (result.next());
				
				result.close();
				objConn.cerrarConexion();
				
				if(UsuarioExiste) {
					new Principal();
					frmLogin.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"El Ususario No existe","Error",JOptionPane.ERROR_MESSAGE);
					txtUsuario.setText(null);
					passContraseña.setText(null);
					txtUsuario.requestFocus();
				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No hay usuarios registrados, registre un nuevo usuario."+e2.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				txtUsuario.setText(null);
				passContraseña.setText(null);
				txtUsuario.requestFocus();
			}
		
		}
	}
}
