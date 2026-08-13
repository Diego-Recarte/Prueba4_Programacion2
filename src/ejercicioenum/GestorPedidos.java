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
    
    public pedido buscarPorId(int id) throws PedidoNoEncontrado {
        for (int i = 0; i < cantidad; i++) {
            if (pedidos[i].getId() == id) {
                return pedidos[i];
            }
        }
        throw new PedidoNoEncontrado(id);
    }


    
    public void cambiarEstado(int id, EstadoPedido nuevoEstado)throws PedidoNoEncontrado, TransicionEstadoException {

        pedido pedido = buscarPorId(id);

        EstadoPedido estadoActual = pedido.getEstado();

        if (!estadoActual.transicionarA(nuevoEstado)) {
            throw new TransicionEstadoException(estadoActual, nuevoEstado);
        }
        else{
            pedido.setEstado(nuevoEstado);
        }
    }
}
    
    
