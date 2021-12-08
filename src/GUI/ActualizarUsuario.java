package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MysqlConfig.MysqlConnector;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActualizarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private final JPanel panel = new JPanel();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private MysqlConnector objConn;
	
	public ActualizarUsuario(String ID,String Usuario, String Nombre, String Apellido, String Telefono, String Correo) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				CRUDUsuarios crudU = new CRUDUsuarios();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ActualizarUsuario.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		setTitle("Actualizar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 432, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACTUALIZAR USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 11, 211, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(25, 56, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(25, 82, 170, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(25, 123, 63, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(25, 148, 170, 20);
		contentPane.add(txtNombre);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(220, 123, 63, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(220, 148, 170, 20);
		contentPane.add(txtApellido);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefono");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(25, 190, 63, 14);
		contentPane.add(lblNewLabel_1_3);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(25, 215, 170, 20);
		contentPane.add(txtTelefono);
		
		JLabel lblNewLabel_1_4 = new JLabel("Correo");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(220, 190, 63, 14);
		contentPane.add(lblNewLabel_1_4);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(220, 215, 170, 20);
		contentPane.add(txtCorreo);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 282, 416, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//asignacion de valores a los jtxtfield
		
		txtUsuario.setText(Usuario);
		txtNombre.setText(Nombre);
		txtApellido.setText(Apellido);
		txtTelefono.setText(Telefono);
		txtCorreo.setText(Correo);
		
		
		btnNewButton = new JButton("Actulizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tUsuario = txtUsuario.getText().trim();
				String tNombre = txtNombre.getText().trim();
				String tApellido = txtApellido.getText().trim();
				String tTelefono = txtTelefono.getText().trim();
				String tCorreo = txtCorreo.getText().trim();
				
				if(tUsuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Usuario","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtUsuario.requestFocus();
				}
				
				if(tNombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Nombre","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtNombre.requestFocus();
				}
				
				if(tApellido.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Apellido","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtApellido.requestFocus();
				}
				
				if(tTelefono.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Telefono","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtTelefono.requestFocus();
				}
				
				if(tCorreo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Correo","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtUsuario.requestFocus();
				}
				
				if(!(tUsuario.isEmpty()) && !(tNombre.isEmpty()) && !(tApellido.isEmpty()) && !(tTelefono.isEmpty()) && !(tCorreo.isEmpty())) {
					try {
						objConn = new MysqlConnector();
						objConn.ActualizarRegistro(ID, tUsuario, tNombre, tApellido, tTelefono, tCorreo, tCorreo);
						setVisible(false);
						CRUDUsuarios crudU = new CRUDUsuarios();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(ActualizarUsuario.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		btnNewButton.setBounds(50, 32, 133, 35);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CRUDUsuarios crudU = new CRUDUsuarios();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton_1.setBounds(260, 32, 106, 35);
		panel.add(btnNewButton_1);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
