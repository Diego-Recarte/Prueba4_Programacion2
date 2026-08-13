/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioenum;

/**
 *
 * @author user
 */
public class TransicionEstadoException extends Exception {
    
    public TransicionEstadoException(EstadoPedido actual, EstadoPedido nuevo){
       
        super("No se puede pasar de: "+actual+" a "+nuevo+  " (estado actual final: "+ actual.isEsFinal()+ ")");
    }
}
