/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DALproducto;
public class BLproducto {
    private DALproducto dalProducto;

    public BLproducto() {
        this.dalProducto = new DALproducto(); // Crear una instancia de la capa DAL
    }

    // Método para agregar un nuevo producto
    public void agregarProducto(int idProducto, String nombre, String descripcion, double precio, int fkIdCategoria, int stockDisponible) {
        try {
            dalProducto.insertarProducto(idProducto, nombre, descripcion, precio, fkIdCategoria, stockDisponible);
            System.out.println("Producto agregado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al agregar el producto: " + e.getMessage());
        }
    }

    // Método para actualizar un producto existente
    public void actualizarProducto(int idProducto, String nombre, String descripcion, double precio, int fkIdCategoria, int stockDisponible) {
        try {
            dalProducto.actualizarProducto(idProducto, nombre, descripcion, precio, fkIdCategoria, stockDisponible);
            System.out.println("Producto actualizado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar el producto: " + e.getMessage());
        }
    }

    // Método para eliminar un producto
    public void eliminarProducto(int idProducto) {
        try {
            dalProducto.eliminarProducto(idProducto);
            System.out.println("Producto eliminado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
        }
    }
}
