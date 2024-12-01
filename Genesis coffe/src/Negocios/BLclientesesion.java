/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DALclientesesion;
public class BLclientesesion {
 private DALclientesesion dalSesion; // Instancia de la capa DAL

    // Constructor que inicializa la capa DAL
    public BLclientesesion() {
        dalSesion = new DALclientesesion(); // Crear la instancia de DALclientesesion
    }

    /**
     * Método para verificar las credenciales del cliente.
     * 
     * @param correo     El correo electrónico del cliente.
     * @param contrasena La contraseña del cliente.
     * @return Mensaje indicando si las credenciales son válidas o no.
     */
    public String verificarCredenciales(String correo, String contrasena) {
        // Validar los parámetros de entrada (opcional)
        if (correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            return "Por favor, ingrese un correo y una contraseña válidos.";
        }

        // Llamar al método de la capa DAL para verificar las credenciales
        boolean credencialesValidas = dalSesion.verificarCredenciales(correo, contrasena);

        // Retornar el mensaje según el resultado
        if (credencialesValidas) {
            return "¡Bienvenido!";
        } else {
            return "La cuenta del cliente no existe o las credenciales son incorrectas.";
        }
    }
}
