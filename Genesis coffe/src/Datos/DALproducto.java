/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.sql.*;
public class DALproducto {
   // Método para insertar un nuevo producto
    public void insertarProducto(int idProducto, String nombre, String descripcion, double precio, int fkIdCategoria, int stockDisponible) throws Exception {
        String sql = "INSERT INTO producto (idproducto, nombre, descripcion, precio, fkidcategoria, stock_disponible) VALUES (?, ?, ?, ?, ?, ?)";
        DConexion conexion = new DConexion();
        conexion.conectar();
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            ps.setDouble(4, precio);  // Usamos double en lugar de BigDecimal
            ps.setInt(5, fkIdCategoria);
            ps.setInt(6, stockDisponible);
            ps.executeUpdate();
            System.out.println("Producto insertado correctamente.");
        } finally {
            conexion.desconectar();
        }
    }

    // Método para actualizar un producto existente
    public void actualizarProducto(int idProducto, String nombre, String descripcion, double precio, int fkIdCategoria, int stockDisponible) throws Exception {
        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ?, fkidcategoria = ?, stock_disponible = ? WHERE idproducto = ?";
        DConexion conexion = new DConexion();
        conexion.conectar();
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);  // Usamos double en lugar de BigDecimal
            ps.setInt(4, fkIdCategoria);
            ps.setInt(5, stockDisponible);
            ps.setInt(6, idProducto);
            ps.executeUpdate();
            System.out.println("Producto actualizado correctamente.");
        } finally {
            conexion.desconectar();
        }
    }

    // Método para eliminar un producto
    public void eliminarProducto(int idProducto) throws Exception {
        String sql = "DELETE FROM producto WHERE idproducto = ?";
        DConexion conexion = new DConexion();
        conexion.conectar();
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ps.executeUpdate();
            System.out.println("Producto eliminado correctamente.");
        } finally {
            conexion.desconectar();
        }
    }
}
