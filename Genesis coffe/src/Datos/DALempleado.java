/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DALempleado {
  // Método para agregar un nuevo empleado
    public void agregarEmpleado(String nombre, String apellido, String correo, String telefono, String cargo) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO empleado (nombre, apellido, correo_electronico, telefono, cargo) VALUES (?, ?, ?, ?, ?)";
        
        // Obtener la conexión directamente
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda_cafeteria_pasteleria", "DEIVY", "2003");
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, correo);
            stmt.setString(4, telefono);
            stmt.setString(5, cargo);
            stmt.executeUpdate();
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Cerrar la conexión
            }
        }
    }

    // Método para actualizar la información de un empleado
    public void actualizarEmpleado(int idEmpleado, String nombre, String apellido, String correo, String telefono, String cargo) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE empleado SET nombre = ?, apellido = ?, correo_electronico = ?, telefono = ?, cargo = ? WHERE idempleado = ?";
        
        // Obtener la conexión directamente
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda_cafeteria_pasteleria", "DEIVY", "2003");
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, correo);
            stmt.setString(4, telefono);
            stmt.setString(5, cargo);
            stmt.setInt(6, idEmpleado);
            stmt.executeUpdate();
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Cerrar la conexión
            }
        }
    }

    // Método para eliminar un empleado por su ID
    public void eliminarEmpleado(int idEmpleado) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM empleado WHERE idempleado = ?";
        
        // Obtener la conexión directamente
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda_cafeteria_pasteleria", "DEIVY", "2003");
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEmpleado);
            stmt.executeUpdate();
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Cerrar la conexión
            }
        }
    }

    // Método para obtener todos los empleados
    public List<String> obtenerEmpleados() throws SQLException, ClassNotFoundException {
        List<String> empleados = new ArrayList<>();
        String sql = "SELECT idempleado, nombre, apellido FROM empleado";
        
        // Obtener la conexión directamente
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda_cafeteria_pasteleria", "DEIVY", "2003");
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String empleado = "ID: " + rs.getInt("idempleado") + " - " 
                        + rs.getString("nombre") + " " + rs.getString("apellido");
                empleados.add(empleado);
            }
        } finally {
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Cerrar la conexión
            }
        }
        return empleados;
    }

    // Método para obtener un empleado específico por su ID
    public String obtenerEmpleadoPorId(int idEmpleado) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM empleado WHERE idempleado = ?";
        
        // Obtener la conexión directamente
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/tienda_cafeteria_pasteleria", "DEIVY", "2003");
        ResultSet rs = null;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEmpleado);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return "ID: " + rs.getInt("idempleado") + " - " 
                        + rs.getString("nombre") + " " + rs.getString("apellido") 
                        + " - " + rs.getString("correo_electronico") + " - " 
                        + rs.getString("telefono") + " - " + rs.getString("cargo");
            } else {
                return "Empleado no encontrado.";
            }
        } finally {
            if (rs != null) rs.close();
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Cerrar la conexión
            }
        }
    }
}
