package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import MysqlConfig.MysqlConnector;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CRUDProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbProductos;
	private MysqlConnector objConn;
	
	private String id = null;
	private String nombre = null;
	private String marca = null;
	private String categoria = null;
	private String precio = null;
	private String stock = null;

	public CRUDProductos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new Principal();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(CRUDProductos.class.getResource("/Imagenes/wondicon-ui-free-parcel_111208.png")));
		setTitle("Productos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 712, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JLabel lblAdministrarProductos = new JLabel("ADMINISTRAR PRODUCTOS");
		lblAdministrarProductos.setForeground(Color.WHITE);
		lblAdministrarProductos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAdministrarProductos.setBounds(12, 11, 233, 16);
		contentPane.add(lblAdministrarProductos);
		
		tbProductos = new JTable();
		tbProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tbProductos.rowAtPoint(e.getPoint());
				
				id = tbProductos.getValueAt(fila, 0).toString();
				nombre =tbProductos.getValueAt(fila, 1).toString();
				marca =tbProductos.getValueAt(fila, 2).toString();
				categoria =tbProductos.getValueAt(fila, 3).toString();
				precio = tbProductos.getValueAt(fila, 4).toString();
				stock = tbProductos.getValueAt(fila, 5).toString();
			}
		});
		tbProductos.setBounds(10, 50, 495, 292);
		contentPane.add(tbProductos);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AgregarProducto();
			}
		});
		btnAgregar.setIcon(new ImageIcon(CRUDProductos.class.getResource("/Imagenes/1491254405-plusaddmoredetail_82972.png")));
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(517, 50, 170, 35);
		contentPane.add(btnAgregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(nombre == null)) {
					new ActualizarProducto(id,nombre, marca, categoria, precio, stock);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Primero selecciona el registro que quieres actualizar","No seleccion",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnActualizar.setIcon(new ImageIcon(CRUDProductos.class.getResource("/Imagenes/3643749-edit-pen-pencil-write-writing_113397.png")));
		btnActualizar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setBounds(517, 97, 170, 35);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(nombre == null)) {
					int op = JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar este registro?");
					if(op == 0) {
						objConn=new MysqlConnector();
						objConn.eliminarRegistro(id, "Productos");
						mostrarRegistros();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Primero selecciona el registro que quieres actualizar","No seleccion",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnEliminar.setIcon(new ImageIcon(CRUDProductos.class.getResource("/Imagenes/trash_bin_icon-icons.com_67981.png")));
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(517, 144, 170, 35);
		contentPane.add(btnEliminar);
		
		JButton btnMenu = new JButton("Menu Principial");
		btnMenu.setIcon(new ImageIcon(CRUDProductos.class.getResource("/Imagenes/home_icon-icons.com_73532.png")));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Principal();
			}
		});
		btnMenu.setFont(new Font("Dialog", Font.BOLD, 13));
		btnMenu.setBackground(Color.WHITE);
		btnMenu.setBounds(517, 260, 170, 35);
		contentPane.add(btnMenu);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setIcon(new ImageIcon(CRUDProductos.class.getResource("/Imagenes/arrowleft_icon-icons.com_61207.png")));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login();
			}
		});
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCerrarSesion.setBackground(SystemColor.activeCaptionBorder);
		btnCerrarSesion.setBounds(517, 307, 170, 35);
		contentPane.add(btnCerrarSesion);

		
		mostrarRegistros();
	}
	
	// METODOS
	
	private void mostrarRegistros() {
		String[] titulos = {"ID", "Nombre", "Marca","Categoria", "Precio", "Stock"};
		String[] registros = new String[6];
		
		DefaultTableModel model = new DefaultTableModel(null, titulos);
		try {
			objConn = new MysqlConnector();
			ResultSet res = objConn.ejecutarConsulta("SELECT * From Productos");		
			while(res.next()){
				registros[0] = res.getString("ID");
				registros[1] = res.getString("NombreProducto");
				registros[2] = res.getString("MarcaProducto");
				registros[3] = res.getString("CategoriaProducto");
				registros[4] = res.getString("PrecioProducto");
				registros[5] = res.getString("StockProducto");
				
				model.addRow(registros);
			}
			
			tbProductos.setModel(model);
			tbProductos.getColumnModel().getColumn(0).setPreferredWidth(40);
			objConn.cerrarConexion();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
