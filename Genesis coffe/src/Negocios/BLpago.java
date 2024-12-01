/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DALpago;
public class BLpago {
    private DALpago dalPago;

    // Constructor
    public BLpago() {
        dalPago = new DALpago();
    }

    /**
     * Método para validar e insertar un pago
     * @param metodoPago El método de pago (Efectivo, Tarjeta, etc.)
     * @param monto El monto del pago
     * @param fechaPago La fecha del pago
     * @throws Exception Manejo de excepciones
     */
    public void insertarPago(String metodoPago, double monto, String fechaPago) throws Exception {
        // Validar datos de entrada
        if (metodoPago == null || metodoPago.trim().isEmpty()) {
            throw new Exception("El método de pago no puede estar vacío.");
        }

        if (monto <= 0) {
            throw new Exception("El monto debe ser mayor que cero.");
        }

        if (fechaPago == null || fechaPago.trim().isEmpty()) {
            throw new Exception("La fecha de pago no puede estar vacía.");
        }

        // Si las validaciones pasan, llamar a la capa DAL
        dalPago.insertarPago(metodoPago, monto, fechaPago);
    }
}
