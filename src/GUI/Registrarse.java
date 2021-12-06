package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Registrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField textField_2;
	private JTextField txtTelefono;
	private JTextField textField_4;
	private JPasswordField passContraseña;
	private JPasswordField passConfirContraseña;
	private final JPanel panel = new JPanel();

	public Registrarse() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 532, 620);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null); 
		
		JLabel iconRegistrarse = new JLabel("");
		iconRegistrarse.setBounds(199, 29, 133, 139);
		iconRegistrarse.setIcon(new ImageIcon(Registrarse.class.getResource("/Imagenes/adduser_añadir_3553 (1).png")));
		iconRegistrarse.setForeground(Color.DARK_GRAY);
		iconRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(21, 202, 49, 14);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(21, 227, 226, 20);
		txtUsuario.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(iconRegistrarse);
		contentPane.add(lblUsuario);
		contentPane.add(txtUsuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(21, 268, 49, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(21, 293, 226, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellido.setBounds(268, 268, 64, 14);
		contentPane.add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(268, 293, 226, 20);
		contentPane.add(textField_2);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefono.setBounds(21, 324, 64, 14);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(21, 349, 226, 20);
		contentPane.add(txtTelefono);
		
		JLabel lblCorreo = new JLabel("Correo Electronico");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCorreo.setBounds(268, 324, 119, 14);
		contentPane.add(lblCorreo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(268, 349, 226, 20);
		contentPane.add(textField_4);
		
		JLabel lblNombre_3_2 = new JLabel("Contraseña");
		lblNombre_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre_3_2.setBounds(21, 390, 89, 14);
		contentPane.add(lblNombre_3_2);
		
		JLabel lblNombre_3_3 = new JLabel("Confirmar Contraseña");
		lblNombre_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre_3_3.setBounds(268, 390, 151, 14);
		contentPane.add(lblNombre_3_3);
		
		passContraseña = new JPasswordField();
		passContraseña.setBounds(21, 415, 226, 20);
		contentPane.add(passContraseña);
		
		passConfirContraseña = new JPasswordField();
		passConfirContraseña.setBounds(268, 415, 226, 20);
		contentPane.add(passConfirContraseña);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 463, 516, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(Registrarse.class.getResource("/Imagenes/1491254405-plusaddmoredetail_82972.png")));
		btnNewButton.setBounds(97, 34, 134, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(328, 34, 89, 41);
		panel.add(btnNewButton_1);
		
		setVisible(true);
	}
}
