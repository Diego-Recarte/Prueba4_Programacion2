/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioenum;

/**
 *
 * @author user
 */
public enum EstadoPedido {
    PENDIENTE("Pedido registrado, esperando procesamiento", false, 1), PROCESANDO("Pedido siendo preparado", false, 2), ENVIADO("Pedido en camino al cliente", false, 3),ENTREGADO("Pedido entregado al cliente", true, 0), CANCELADO("Pedido cancelado", true, 0);
    
    private final String descripcion;
    private final boolean esFinal;
    private final int diasEstimados;
    
    EstadoPedido(String descripcion, boolean esFinal, int diasEstimados){
        this.descripcion= descripcion;
        this.esFinal= esFinal;
        this.diasEstimados= diasEstimados;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    public boolean transicionarA(EstadoPedido nuevoEstado){
        
        if (this.esFinal){
            return false;
        }else{
            boolean valido = false;
                switch (this){

                    case PENDIENTE:
                        if (nuevoEstado == PROCESANDO || nuevoEstado ==CANCELADO){
                            valido = true;
                        }
                        break;

                    case PROCESANDO:
                        if (nuevoEstado == ENVIADO || nuevoEstado ==CANCELADO){
                            valido = true;
                        }
                        break;

                    case ENVIADO:
                        if (nuevoEstado == ENTREGADO){
                            valido = true;
                        }
                        break;

                    case ENTREGADO:
                        
                        break;

                    default:
                        valido = false;
                        break;


                }
                return valido;
        }
    }

    public boolean isEsFinal() {
        return esFinal;
    }
    
    
}
