package MysqlConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MysqlConnector {
	
	private String user = "uxkxbstkcictobkn";
	private String pass = "4H5sXcOOjuMTuzXmUQqY";
	private String url = "jdbc:mysql://bhzxv4bma6pz3chj7tsm-mysql.services.clever-cloud.com:3306/bhzxv4bma6pz3chj7tsm";
	private Connection conn = null;
	
	public MysqlConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Conexion Establecida");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet ejecutarConsulta(String sqlConsulta) {
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(sqlConsulta);
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	// CERRAR CONEXION

	
	//AGREGAR REGISTROS
	
	public void AgregarRegistro(String usuario, String nombre, String apellido, String telefono, String correo, String contraseña) {
		try {
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO Usuarios (ID,Usuario,Nombre,Apellido,Telefono,Correo,Contraseña) VALUES (null,?,?,?,?,?,?)");
			
			pstm.setString(1, usuario);
			pstm.setString(2, nombre);
			pstm.setString(3, apellido);
			pstm.setString(4, telefono);
			pstm.setString(5, correo);
			pstm.setString(6, contraseña);
			
			pstm.execute();
			conn.close();
			
			JOptionPane.showMessageDialog(null, "Usuario Agregado","Registrado", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void AgregarRegistro(String nombre, String marca, String categoria, String precio, String stock) {
		try {
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO Productos (ID,NombreProducto,MarcaProducto,CategoriaProducto,PrecioProducto,StockProducto) VALUES (null,?,?,?,?,?)");
			
			pstm.setString(1, nombre);
			pstm.setString(2, marca);
			pstm.setString(3, categoria);
			pstm.setString(4, precio);
			pstm.setString(5, stock);
			
			pstm.execute();
			conn.close();
			
			JOptionPane.showMessageDialog(null, "Producto Agregado","Registrado", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//ACTUALIZAR REGISTROS
	
	public void ActualizarRegistro(String ID ,String usuario, String nombre, String apellido, String telefono, String correo, String contraseña) {
		try {
			PreparedStatement pstm = conn.prepareStatement("UPDATE Usuarios SET Usuario = ?, Nombre = ?, Apellido = ?, Telefono = ?, Correo = ? WHERE ID = ?");
			
			pstm.setString(1, usuario);
			pstm.setString(2, nombre);
			pstm.setString(3, apellido);
			pstm.setString(4, telefono);
			pstm.setString(5, correo);
			pstm.setString(6, ID);
			
			pstm.execute();
			conn.close();
			
			JOptionPane.showMessageDialog(null, "Usuario Actualizado","Actualizado", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void ActualizarRegistro(String ID ,String nombre, String marca, String categoria, String precio, String stock) {
		try {
			PreparedStatement pstm = conn.prepareStatement("UPDATE Productos SET NombreProducto = ?, MarcaProducto = ?, CategoriaProducto = ?, PrecioProducto = ?, StockProducto= ? WHERE ID = ?");
			
			pstm.setString(1, nombre);
			pstm.setString(2, marca);
			pstm.setString(3, categoria);
			pstm.setString(4, precio);
			pstm.setString(5, stock);
			pstm.setString(6, ID);
			
			pstm.execute();
			conn.close();
			
			JOptionPane.showMessageDialog(null, "Producto Actualizado","Actualizado", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//ELIMINAR REGISTROS
	
	public void eliminarRegistro(String ID, String tabla) {
		if(tabla == "Usuarios") {
			try {
				PreparedStatement pstm = conn.prepareStatement("DELETE FROM Usuarios WHERE ID = ?");
				
				pstm.setString(1, ID);
				
				pstm.execute();
				conn.close();
				JOptionPane.showMessageDialog(null, "Registro Eliminado","Eliminado", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(tabla == "Productos") {
			try {
				PreparedStatement pstm = conn.prepareStatement("DELETE FROM Productos WHERE ID = ?");
				
				pstm.setString(1, ID);
				
				pstm.execute();
				conn.close();
				JOptionPane.showMessageDialog(null, "Registro Eliminado","Eliminado", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "La tabla que selecciona no existe");
		}
	}
	
	

}
