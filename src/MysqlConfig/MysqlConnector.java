package MysqlConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MysqlConnector {
	
	String user = "root";
	String pass = "admin";
	String url = "jdbc:mysql://localhost:3306/dbAlmacen";
	Connection conn = null;
	
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
	
	public void registrarUsuarios(String usuario, String nombre, String apellido, String telefono, String correo, String contraseña) {
		try {
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO Usuarios (ID,Usuario,Nombre,Apellido,Telefono,Correo,Contraseña) VALUES (null,?,?,?,?,?,?)");
			
			pstm.setString(1, usuario);
			pstm.setString(2, nombre);
			pstm.setString(3, apellido);
			pstm.setString(4, telefono);
			pstm.setString(5, correo);
			pstm.setString(6, contraseña);
			
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Usuario Registrado","Registrado", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	

}
