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
    
    
    public void crearPedidonacional(int id, String cliente, double monto,double km ){
        pedido nuevo = new PedidoNacional(id, cliente, monto, km);
        try{
        agregarPedido(nuevo);
        }catch(CapacidadException ex){
            
        }
    }
    
     public void crearPedidointernacional(int id, String cliente, double monto, String pais, double aduana){
        pedido nuevo =  new PedidoInternacional (id, cliente, monto, pais, aduana);
        try{
        agregarPedido(nuevo);
        }catch(CapacidadException ex){
            
        }
    }
    
    
    
    private void agregarPedido (pedido dato)throws CapacidadException{
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

    public pedido[] listarPorEstado(EstadoPedido estado) {
        int indices = 0;
        pedido[] resultado;
        for (int i = 0; i < cantidad; i++) {
            if (pedidos[i].getEstado() == estado) {
                indices++;
            }
        }

        resultado = new pedido[indices];
        
        int indice = 0;
        for (int i = 0; i < cantidad; i++) {
            if (pedidos[i].getEstado() == estado) {
                resultado[indice] = pedidos[i];
                indice++;
            }
        }

        return resultado;
    }

    
}
    
    
