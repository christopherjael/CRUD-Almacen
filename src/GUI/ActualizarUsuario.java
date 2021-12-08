package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActualizarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final JPanel panel = new JPanel();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	public ActualizarUsuario() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//ME QUE DE AQUI
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ActualizarUsuario.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		setTitle("Actualizar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblNewLabel_1.setBounds(20, 56, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(20, 81, 170, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(25, 123, 63, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(25, 148, 170, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(220, 123, 63, 14);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(220, 148, 170, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefono");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(25, 190, 63, 14);
		contentPane.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(25, 215, 170, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Correo");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(220, 190, 63, 14);
		contentPane.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(220, 215, 170, 20);
		contentPane.add(textField_4);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 282, 416, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Actulizar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(ActualizarUsuario.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		btnNewButton.setBounds(50, 32, 133, 35);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton_1.setBounds(260, 32, 106, 35);
		panel.add(btnNewButton_1);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
