/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioenum;

/**
 *
 * @author user
 */
public class PedidoInternacional extends pedido {
    
    private double aduana;
    private double TarifaBase= 60;
    private String pais;
    private double envio;
    
     public PedidoInternacional (int id, String cliente, double monto,String pais, double aduana ){
        super(id, cliente, monto);
        this.aduana = aduana;
        this.pais= pais;
        envio = calcularCostoEnvio();
    }
     @Override
    public double calcularCostoEnvio(){
        
        double costoEnvio;
         
        costoEnvio =TarifaBase + aduana;
        
        System.out.println("El monto por envio es de $"+ costoEnvio);
        
        return costoEnvio;
    
        
    }
    @Override
    public String getTipo(){
        
        return ("Este es un pedido a nivel INTERNACIONAL, con destino a " + pais.toUpperCase());
    }
    
    @Override
    public String toString(){
        
        return super.toString()+ " destino a "+pais.toUpperCase()+", impuestos de aduana: $"+envio;
    }
     
    
}
