/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioenum;

/**
 *
 * @author user
 */
public class PedidoNacional extends pedido {
    
    
    private double km;
    private double TarifaBase = 30;
    private double TarifaKm= 5;
   
    public PedidoNacional (int id, String cliente, double monto, double km ){
        super(id, cliente, monto);
        this.km = km;
        System.out.println(calcularCostoEnvio());
    }
    
    @Override
    public double calcularCostoEnvio(){
        
        double costoEnvio;
         
        costoEnvio =TarifaBase + (km * TarifaKm);
        
        System.out.println("El monto por envio es de $"+ costoEnvio);
        
        return costoEnvio;
    
        
    }
    
    @Override
    public String getTipo(){
        
        return ("Este es un pedido a nivel NACIONAl");
    }
    
}
