/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.*;
public class DALpago {
    private DConexion conexion;

    // Constructor
    public DALpago() {
        conexion = new DConexion();
    }

    /**
     * Método para insertar un nuevo pago
     * @param metodoPago El método de pago (Efectivo, Tarjeta, etc.)
     * @param monto El monto del pago
     * @param fechaPago La fecha del pago
     * @throws Exception Manejo de excepciones
     */
    public void insertarPago(String metodoPago, double monto, String fechaPago) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            // Conectar a la base de datos
            conexion.conectar();
            conn = conexion.getConnection();

            // Obtener el siguiente ID
            String obtenerMaxId = "SELECT COALESCE(MAX(idpago), 0) + 1 AS nuevo_id FROM pago";
            ps = conn.prepareStatement(obtenerMaxId);
            rs = ps.executeQuery();
            int nuevoIdPago = 1; // Valor predeterminado
            if (rs.next()) {
                nuevoIdPago = rs.getInt("nuevo_id");
            }

            // Insertar el nuevo pago
            String insertarSQL = "INSERT INTO pago (idpago, metodo_pago, monto, fecha_pago) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(insertarSQL);
            ps.setInt(1, nuevoIdPago);
            ps.setString(2, metodoPago);
            ps.setDouble(3, monto);
            ps.setString(4, fechaPago);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Pago insertado con éxito con ID: " + nuevoIdPago);
            } else {
                System.out.println("Error al insertar el pago.");
            }
        } catch (SQLException e) {
            System.err.println("Error en DALpago: " + e.getMessage());
            throw e;
        } finally {
            // Cerrar recursos
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            conexion.desconectar();
        }
    }
}
