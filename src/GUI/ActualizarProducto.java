package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MysqlConfig.MysqlConnector;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActualizarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private MysqlConnector objConn = new MysqlConnector();

	public ActualizarProducto(String ID,String nombre, String marca, String categoria, String precio, String stock) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				CRUDProductos crudP = new CRUDProductos();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ActualizarProducto.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		setResizable(false);
		setTitle("Actualizar Producto");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 398, 434, 109);
		contentPane.add(panel);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tNombre = txtNombre.getText().trim();
				String tMarca = txtMarca.getText().trim();
				String tCategoria = txtCategoria.getText().trim();
				String tPrecio = txtPrecio.getText().trim();
				String tStock = txtStock.getText().trim();
				
				if(tNombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Nombre","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtNombre.requestFocus();
				}
				
				if(tMarca.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Marca","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtMarca.requestFocus();
				}
				
				if(tCategoria.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Categoria","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtCategoria.requestFocus();
				}
				
				if(tPrecio.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Precio","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtPrecio.requestFocus();
				}
				
				if(tStock.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Falta el campo Stock","Falta el campo",JOptionPane.INFORMATION_MESSAGE);
					txtStock.requestFocus();
				}
				
				if(!(tNombre.isEmpty()) && !(tMarca.isEmpty()) && !(tCategoria.isEmpty()) && !(tPrecio.isEmpty()) && !(tStock.isEmpty())) {
					try {
						objConn.ActualizarRegistro(ID, tNombre, tMarca, tCategoria, tPrecio, tStock);
						setVisible(false);
						CRUDProductos crudP = new CRUDProductos();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnActualizar.setIcon(new ImageIcon(ActualizarProducto.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		btnActualizar.setToolTipText("");
		btnActualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setBounds(67, 37, 134, 35);
		panel.add(btnActualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CRUDProductos crudP = new CRUDProductos();
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(268, 37, 99, 35);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ActualizarProducto.class.getResource("/Imagenes/wondicon-ui-free-parcel_111208.png")));
		lblNewLabel.setBounds(156, 11, 122, 109);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ActualizarProducto.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		lblNewLabel_1.setBounds(179, 59, 37, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ACTUALIZAR PRODUCTO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(99, 131, 236, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre Producto");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(45, 207, 122, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Marca Producto");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(45, 263, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Categoria Producto");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(236, 263, 152, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Precio Producto");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(44, 319, 123, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Stock Producto");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(238, 319, 123, 14);
		contentPane.add(lblNewLabel_7);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("");
		txtNombre.setColumns(10);
		txtNombre.setBounds(45, 232, 150, 20);
		contentPane.add(txtNombre);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(44, 288, 150, 20);
		contentPane.add(txtMarca);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(238, 288, 150, 20);
		contentPane.add(txtCategoria);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(44, 342, 150, 20);
		contentPane.add(txtPrecio);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(238, 344, 150, 20);
		contentPane.add(txtStock);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(262, 191, 55, 16);
		contentPane.add(lblNewLabel_8);
		
		txtNombre.setText(nombre);
		txtMarca.setText(marca);
		txtCategoria.setText(categoria);
		txtPrecio.setText(precio);
		txtStock.setText(stock);

	}

}
