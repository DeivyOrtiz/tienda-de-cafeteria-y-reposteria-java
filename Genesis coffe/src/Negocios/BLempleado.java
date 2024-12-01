/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DALempleado;
import java.sql.SQLException;
import java.util.List;
public class BLempleado {
    private DALempleado dalEmpleado;

    // Constructor
    public BLempleado() {
        this.dalEmpleado = new DALempleado();
    }

    // Método para agregar un nuevo empleado
    public void agregarEmpleado(String nombre, String apellido, String correo, String telefono, String cargo) {
        try {
            dalEmpleado.agregarEmpleado(nombre, apellido, correo, telefono, cargo);
            System.out.println("Empleado agregado con éxito.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al agregar el empleado: " + e.getMessage());
        }
    }

    // Método para actualizar la información de un empleado
    public void actualizarEmpleado(int idEmpleado, String nombre, String apellido, String correo, String telefono, String cargo) {
        try {
            dalEmpleado.actualizarEmpleado(idEmpleado, nombre, apellido, correo, telefono, cargo);
            System.out.println("Empleado actualizado con éxito.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al actualizar el empleado: " + e.getMessage());
        }
    }

    // Método para eliminar un empleado
    public void eliminarEmpleado(int idEmpleado) {
        try {
            dalEmpleado.eliminarEmpleado(idEmpleado);
            System.out.println("Empleado eliminado con éxito.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al eliminar el empleado: " + e.getMessage());
        }
    }

    // Método para obtener la lista de todos los empleados
    public List<String> obtenerEmpleados() {
        try {
            return dalEmpleado.obtenerEmpleados();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener los empleados: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener un empleado por su ID
    public String obtenerEmpleadoPorId(int idEmpleado) {
        try {
            return dalEmpleado.obtenerEmpleadoPorId(idEmpleado);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener el empleado: " + e.getMessage());
            return null;
        }
    }
}
