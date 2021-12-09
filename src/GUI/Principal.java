package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Principal() {
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				new Login();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagenes/home_icon-icons.com_73532.png")));
		setTitle("Principal");
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProductos = new JButton("");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CRUDProductos();
			}
		});
		btnProductos.setBackground(Color.WHITE);
		btnProductos.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/wondicon-ui-free-parcel_111208.png")));
		btnProductos.setBounds(245, 66, 133, 129);
		contentPane.add(btnProductos);
		
		JLabel lblNewLabel = new JLabel("MENU PRINCIPAL");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(136, 11, 161, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnUsuarios = new JButton("");
		btnUsuarios.setBackground(Color.WHITE);
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/Gender_Neutral_User_icon-icons.com_55902.png")));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CRUDUsuarios();
			}
		});
		btnUsuarios.setBounds(56, 66, 133, 129);
		contentPane.add(btnUsuarios);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCTOS");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(263, 206, 96, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIOS");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(82, 206, 81, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("   Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/arrowleft_icon-icons.com_61207.png")));
		btnNewButton.setBounds(150, 255, 133, 35);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
