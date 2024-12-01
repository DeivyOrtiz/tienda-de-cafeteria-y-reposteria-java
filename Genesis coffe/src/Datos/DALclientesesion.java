/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DALclientesesion {
    private DConexion conexion; // Objeto para gestionar la conexión a la base de datos

    // Constructor que inicializa la conexión
    public DALclientesesion() {
        conexion = new DConexion(); // Instancia de tu clase de conexión
    }

    /**
     * Método para verificar las credenciales del cliente.
     * 
     * @param correo     El correo electrónico del cliente.
     * @param contrasena La contraseña del cliente.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public boolean verificarCredenciales(String correo, String contrasena) {
        // Consulta SQL para buscar un cliente con el correo y la contraseña proporcionados
        String sql = "SELECT * FROM CLIENTE WHERE correo_electronico = ? AND contraseña = ?";
        try (Connection conn = conexion.getConnection(); // Obtener conexión
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Establecer los valores en la consulta preparada
            stmt.setString(1, correo);       // Sustituye el primer "?" con el correo
            stmt.setString(2, contrasena);  // Sustituye el segundo "?" con la contraseña

            // Ejecutar la consulta y obtener resultados
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si hay al menos un resultado, las credenciales son válidas
            }
        } catch (Exception e) {
            // Imprimir el error en caso de problemas
            System.out.println("Error al verificar credenciales: " + e.getMessage());
            return false; // En caso de error, retorna false
        }
    }
}
