/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioenum;

/**
 *
 * @author user
 */
public class PedidoNoEncontrado extends Exception {
    public PedidoNoEncontrado (int id){
        super ("No existe un pedido con id: "+id);
    }
}
