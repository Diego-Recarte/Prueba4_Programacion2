/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioenum;

/**
 *
 * @author user
 */
public class GestorPedidos {
    private final  pedido[] pedidos;
    private int cantidad;
    
    public GestorPedidos(int size){
        pedidos = new pedido [size];
        cantidad = 0;
    }
    
    public void agregarPedido (pedido dato)throws CapacidadException{
        if (cantidad== pedidos.length){
            throw new CapacidadException(pedidos.length);
        }else{
            pedidos[cantidad]= dato;
            cantidad++;
        }
            
                
    }
    
}
