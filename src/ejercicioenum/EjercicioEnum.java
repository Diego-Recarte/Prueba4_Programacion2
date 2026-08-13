/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioenum;

/**
 *
 * @author user
 */
import java.util.Scanner;
public class EjercicioEnum {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        GestorPedidos gestor = new GestorPedidos(10);
        int opcion=0;
        
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Crear pedido nacional");
            System.out.println("2. Crear pedido internacional");
            System.out.println("3. Buscar pedido por ID");
            System.out.println("4. Cambiar estado de pedido");
            System.out.println("5. Listar pedidos por estado");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            
            String entrada = scanner.nextLine();
            
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido");
                continue;
            }
            
            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    String idStr = scanner.nextLine();
                    System.out.print("Cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Monto: ");
                    String montoStr = scanner.nextLine();
                    System.out.print("Kilometros: ");
                    String kmStr = scanner.nextLine();
                    
                    try {
                        int id = Integer.parseInt(idStr);
                        double monto = Double.parseDouble(montoStr);
                        double km = Double.parseDouble(kmStr);
                        
                        if (id <= 0) {
                            System.out.println("Error: El ID debe ser mayor a 0");
                        } else if (cliente.trim().isEmpty()) {
                            System.out.println("Error: El cliente no puede estar vacio");
                        } else if (monto <= 0) {
                            System.out.println("Error: El monto debe ser mayor a 0");
                        } else if (km < 0) {
                            System.out.println("Error: Los kilometros no pueden ser negativos");
                        } else {
                            gestor.crearPedidonacional(id, cliente, monto, km);
                            System.out.println("Pedido nacional creado exitosamente");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Algunos datos numericos no son validos");
                    } catch (CapacidadException e) {
                        System.out.println("Error: No se puede crear el pedido. Capacidad maxima alcanzada");
                    } catch (Exception e) {
                        System.out.println("Error: No se pudo crear el pedido");
                    }
                    break;
                    
                case 2:
                    System.out.print("ID: ");
                    idStr = scanner.nextLine();
                    System.out.print("Cliente: ");
                    cliente = scanner.nextLine();
                    System.out.print("Monto: ");
                    montoStr = scanner.nextLine();
                    System.out.print("Pais: ");
                    String pais = scanner.nextLine();
                    System.out.print("Aduana: ");
                    String aduanaStr = scanner.nextLine();
                    
                    try {
                        int id = Integer.parseInt(idStr);
                        double monto = Double.parseDouble(montoStr);
                        double aduana = Double.parseDouble(aduanaStr);
                        
                        if (id <= 0) {
                            System.out.println("Error: El ID debe ser mayor a 0");
                        } else if (cliente.trim().isEmpty()) {
                            System.out.println("Error: El cliente no puede estar vacio");
                        } else if (monto <= 0) {
                            System.out.println("Error: El monto debe ser mayor a 0");
                        } else if (pais.trim().isEmpty()) {
                            System.out.println("Error: El pais no puede estar vacio");
                        } else if (aduana < 0) {
                            System.out.println("Error: La aduana no puede ser negativa");
                        } else {
                            gestor.crearPedidointernacional(id, cliente, monto, pais, aduana);
                            System.out.println("Pedido internacional creado exitosamente");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Algunos datos numericos no son validos");
                    } catch  (Exception e){
                            
                       
                    
                     
                        System.out.println("Error: No se pudo crear el pedido");
                    }
                    break;
                    
                case 3:
                    System.out.print("ID del pedido a buscar: ");
                    String buscarIdStr = scanner.nextLine();
                    
                    try {
                        int buscarId = Integer.parseInt(buscarIdStr);
                        
                        if (buscarId <= 0) {
                            System.out.println("Error: El ID debe ser mayor a 0");
                        } else {
                            pedido encontrado = gestor.buscarPorId(buscarId);
                            System.out.println("Pedido encontrado: " + encontrado);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El ID debe ser un numero valido");
                    } catch (PedidoNoEncontrado e) {
                        System.out.println("Error: No se encontro ningun pedido con ID " + buscarIdStr);
                    } catch (Exception e) {
                        System.out.println("Error: No se pudo buscar el pedido");
                    }
                    break;
                    
                case 4:
                    System.out.print("ID del pedido: ");
                    String estadoIdStr = scanner.nextLine();
                    System.out.print("Nuevo estado (PENDIENTE, PROCESANDO, ENVIADO, ENTREGADO, CANCELADO): ");
                    String nuevoEstadoStr = scanner.nextLine();
                    
                    try {
                        int estadoId = Integer.parseInt(estadoIdStr);
                        
                        if (estadoId <= 0) {
                            System.out.println("Error: El ID debe ser mayor a 0");
                        } else if (nuevoEstadoStr.trim().isEmpty()) {
                            System.out.println("Error: El estado no puede estar vacio");
                        } else {
                            EstadoPedido nuevoEstado = EstadoPedido.valueOf(nuevoEstadoStr.trim().toUpperCase());
                            gestor.cambiarEstado(estadoId, nuevoEstado);
                            System.out.println("Estado cambiado exitosamente");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El ID debe ser un numero valido");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: Estado invalido. Use: PENDIENTE, PROCESANDO, ENVIADO, ENTREGADO, CANCELADO");
                    } catch (PedidoNoEncontrado e) {
                        System.out.println("Error: No se encontro ningun pedido con ese ID");
                    } catch (TransicionEstadoException e) {
                        System.out.println("Error: No se puede cambiar a ese estado desde el estado actual");
                    } catch (Exception e) {
                        System.out.println("Error: No se pudo cambiar el estado");
                    }
                    break;
                    
                case 5:
                    System.out.print("Estado a filtrar (PENDIENTE, PROCESANDO, ENVIADO, ENTREGADO, CANCELADO): ");
                    String filtroEstadoStr = scanner.nextLine();
                    
                    try {
                        if (filtroEstadoStr.trim().isEmpty()) {
                            System.out.println("Error: El estado no puede estar vacio");
                        } else {
                            EstadoPedido filtroEstado = EstadoPedido.valueOf(filtroEstadoStr.trim().toUpperCase());
                            pedido[] filtrados = gestor.listarPorEstado(filtroEstado);
                            
                            if (filtrados.length == 0) {
                                System.out.println("No hay pedidos con estado " + filtroEstado);
                            } else {
                                System.out.println("Pedidos con estado " + filtroEstado + ":");
                                for (pedido p : filtrados) {
                                    System.out.println(p);
                                }
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: Estado invalido. Use: PENDIENTE, PROCESANDO, ENVIADO, ENTREGADO, CANCELADO");
                    } catch (Exception e) {
                        System.out.println("Error: No se pudo listar los pedidos");
                    }
                    break;
                    
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("Error: Opcion no valida. Seleccione una opcion del 1 al 6");
            }
            
        } while (opcion != 6);
        
        scanner.close();
    

    }
    
}
