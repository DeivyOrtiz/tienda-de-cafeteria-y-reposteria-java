/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DALcliente;

public class BLcliente {
      private DALcliente dalCliente;

    // Constructor que inicializa el objeto DALcliente
    public BLcliente() {
        this.dalCliente = new DALcliente(); // Instanciamos la capa de datos
    }

    // Método para registrar un cliente
    public boolean registrarCliente(String nombre, String apellido, String correo_electronico, String telefono, String direccion, String contraseña) {
        // Validaciones de los datos recibidos (por ejemplo, si el correo no es vacío)
        if (nombre == null || nombre.isEmpty()) {
            System.err.println("El nombre es obligatorio.");
            return false;
        }
        if (apellido == null || apellido.isEmpty()) {
            System.err.println("El apellido es obligatorio.");
            return false;
        }
        if (correo_electronico == null || correo_electronico.isEmpty() || !correo_electronico.contains("@")) {
            System.err.println("Correo electrónico inválido.");
            return false;
        }
        if (telefono == null || telefono.isEmpty()) {
            System.err.println("El teléfono es obligatorio.");
            return false;
        }
        if (direccion == null || direccion.isEmpty()) {
            System.err.println("La dirección es obligatoria.");
            return false;
        }
        if (contraseña == null || contraseña.isEmpty()) {
            System.err.println("La contraseña es obligatoria.");
            return false;
        }

        // Si pasa las validaciones, llamamos a la capa de datos para insertar el cliente
        boolean resultado = dalCliente.insertarCliente(nombre, apellido, correo_electronico, telefono, direccion, contraseña);
        
        // Si el resultado es true, el cliente fue insertado correctamente, si no, hubo un error.
        return resultado;
    }
 
}