package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import MysqlConfig.MysqlConnector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CRUDUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable tbUsuarios;
	private MysqlConnector objConn = new MysqlConnector();
	

	public CRUDUsuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Login login = new Login();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(CRUDUsuarios.class.getResource("/Imagenes/Gender_Neutral_User_icon-icons.com_55902.png")));
		setTitle("Administrar Usuarios");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 713, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		tbUsuarios = new JTable();
		tbUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tbUsuarios.rowAtPoint(e.getPoint());
				
				String usuario =tbUsuarios.getValueAt(fila, 1).toString();
				String nombre =tbUsuarios.getValueAt(fila, 2).toString();
				String apellido =tbUsuarios.getValueAt(fila, 3).toString();
				String telefono = tbUsuarios.getValueAt(fila, 4).toString();
				String correo = tbUsuarios.getValueAt(fila, 5).toString();
			}
		});
		tbUsuarios.setBounds(8, 60, 495, 292);
		contentPane.add(tbUsuarios);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarse registrarse = new Registrarse("CRUDUsuarios");
				setVisible(false);
			}
		});
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAgregar.setIcon(new ImageIcon(CRUDUsuarios.class.getResource("/Imagenes/1491254405-plusaddmoredetail_82972.png")));
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(515, 60, 170, 35);
		contentPane.add(btnAgregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnActualizar.setIcon(new ImageIcon(CRUDUsuarios.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setBounds(515, 107, 170, 35);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnEliminar.setIcon(new ImageIcon(CRUDUsuarios.class.getResource("/Imagenes/trash_bin_icon-icons.com_67981.png")));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(515, 154, 170, 35);
		contentPane.add(btnEliminar);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login login = new Login();
			}
		});
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCerrarSesion.setIcon(new ImageIcon(CRUDUsuarios.class.getResource("/Imagenes/arrowleft_icon-icons.com_61207.png")));
		btnCerrarSesion.setBackground(SystemColor.activeCaptionBorder);
		btnCerrarSesion.setBounds(515, 317, 170, 35);
		contentPane.add(btnCerrarSesion);
	
		
		JLabel lblNewLabel = new JLabel("ADMINISTRAR USUARIOS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 21, 210, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnMenu = new JButton("Menu Principial");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Principal prin = new Principal();
			}
		});
		btnMenu.setIcon(new ImageIcon(CRUDUsuarios.class.getResource("/Imagenes/home_icon-icons.com_73532.png")));
		btnMenu.setFont(new Font("Dialog", Font.BOLD, 13));
		btnMenu.setBackground(Color.WHITE);
		btnMenu.setBounds(515, 270, 170, 35);
		contentPane.add(btnMenu);
		
		mostrarRegistrosUsuarios();
	}
	
	
	//METODOS
	
	private void mostrarRegistrosUsuarios() {
		
		String[] titulos = {"ID","Usuario", "Nombre", "Apellido", "Telefono", "Correo"};
		String[] registros = new String[6];
		
		DefaultTableModel modelo = new DefaultTableModel(null, titulos);
		try {
			ResultSet res = objConn.ejecutarConsulta("SELECT * FROM Usuarios");
			 while (res.next()){
				registros[0] = res.getString("ID");
				registros[1] = res.getString("Usuario");
				registros[2] = res.getString("Nombre");
				registros[3] = res.getString("Apellido");
				registros[4] = res.getString("Telefono");
				registros[5] = res.getString("Correo");
				modelo.addRow(registros);
			};
			tbUsuarios.setModel(modelo);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
