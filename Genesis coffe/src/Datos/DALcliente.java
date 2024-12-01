/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
public class DALcliente {
     // Método para insertar un cliente en la base de datos
    public boolean insertarCliente(String nombre, String apellido, String correo_electronico, String telefono, String direccion, String contraseña) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;
        
        try {
            // Establecemos la conexión
            conn = getConnection(); // Utiliza tu método de conexión aquí
            
            // Creamos la consulta SQL para insertar los datos del cliente
            String sql = "INSERT INTO cliente (nombre, apellido, correo_electronico, telefono, direccion, contraseña) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            
            // Establecemos los parámetros para la consulta
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, correo_electronico);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, contraseña);
            
            // Ejecutamos la consulta
            int rowsAffected = ps.executeUpdate();
            
            // Si la consulta se ejecutó con éxito y afectó al menos una fila, retornamos true
            if (rowsAffected > 0) {
                resultado = true;
            }
            
        } catch (SQLException e) {
            System.err.println("Error al insertar el cliente: " + e.getMessage());
        } finally {
            // Cerramos los recursos
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        
        return resultado;
    }

    // Método para obtener la conexión a la base de datos
    private Connection getConnection() throws SQLException {
        String bd = "tienda_cafeteria_pasteleria";
        String usuario = "DEIVY";
        String clave = "2003";
        String url = "jdbc:mysql://localhost/" + bd;
        try {
            // Establecemos la conexión
            return DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
