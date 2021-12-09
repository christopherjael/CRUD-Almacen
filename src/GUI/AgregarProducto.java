package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MysqlConfig.MysqlConnector;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private MysqlConnector objConn;

	public AgregarProducto() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new CRUDProductos();
			}
		});
		setResizable(false);
		setTitle("Agregar Producto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarProducto.class.getResource("/Imagenes/1491254405-plusaddmoredetail_82972.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 398, 434, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText().trim();
				String marca = txtMarca.getText().trim();
				String categoria = txtCategoria.getText().trim();
				String precio = txtPrecio.getText().trim();
				String stock = txtStock.getText().trim();
				
				if(nombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Nombre Producto Vacio.","",JOptionPane.INFORMATION_MESSAGE);
					txtNombre.requestFocus();
				}
				
				if(marca.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Marca Producto Vacio.","",JOptionPane.INFORMATION_MESSAGE);
					txtMarca.requestFocus();
				}
				
				if(categoria.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Categoria Producto Vacio.","",JOptionPane.INFORMATION_MESSAGE);
					txtCategoria.requestFocus();
				}
				
				if(precio.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Precio Producto Vacio.","",JOptionPane.INFORMATION_MESSAGE);
					txtPrecio.requestFocus();
				}
				
				if(stock.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Stock Producto Vacio.","",JOptionPane.INFORMATION_MESSAGE);
					txtStock.requestFocus();
				}
				
				if(!nombre.isEmpty() && !marca.isEmpty() && !categoria.isEmpty() && !precio.isEmpty() && !stock.isEmpty()) {
					objConn = new MysqlConnector();
					objConn.AgregarRegistro(nombre, marca, categoria, precio, stock);
					objConn.cerrarConexion();
					txtNombre.setText(null);
					txtMarca.setText(null);
					txtCategoria.setText(null);
					txtPrecio.setText(null);
					txtStock.setText(null);

					txtNombre.requestFocus();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(AgregarProducto.class.getResource("/Imagenes/1491254405-plusaddmoredetail_82972.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(71, 37, 121, 35);
		panel.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CRUDProductos();
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(263, 37, 99, 35);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AgregarProducto.class.getResource("/Imagenes/wondicon-ui-free-parcel_111208.png")));
		lblNewLabel.setBounds(156, 11, 122, 109);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AgregarProducto.class.getResource("/Imagenes/1491254405-plusaddmoredetail_82972.png")));
		lblNewLabel_1.setBounds(179, 59, 37, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AGREGAR PRODUCTO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(119, 131, 195, 22);
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
		txtNombre.setBounds(45, 232, 150, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
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
	}
}
