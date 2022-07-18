package models;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Display {
    public static void menuMain() {
        System.out.println("\n\tSistema de Taquilla de Bancamiga\n");
        System.out.println("\t1. Iniciar Operaciones");
        System.out.println("\t2. Imprimir Transacciones del Dia");
        System.out.println("\t3. Salir del sistema");
    }
    
    public static void menuTicketOffice(String nameClient) {
        System.out.println("\n\t***** Bienvenido " + nameClient + "*****\n");
        System.out.println("\t1. Retiro");
        System.out.println("\t2. Deposito");
        System.out.println("\t3. Consulta de Movimientos");
        System.out.println("\t4. Actualización de Libretas");
        System.out.println("\t5. pago de servicios)");
        
    }
    
    public static void error(String msj) {
        System.out.println("\n\tError: " + msj);
    }
    
    public static void withoutQueue() {
        System.out.println("\n\tNo hay clientes en cola");
        System.out.println("\tPor favor, presione \"3\" para salir del sistema");
    }
    
    public static void withQueue() {
        System.out.println("\n\tHay clientes en cola");
        System.out.println("\tPor favor, atiende a los clientes antes de hacer imprimir las transacciones");
    }
    
    public static void exitSystem() {
        System.out.print("\n\tHa salido del sistema");
        for (int i = 1; i <= 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000); // Duerme el hilo durante 1000 milisegundos, 1 segundo pues
            } catch(InterruptedException ie) {
                // ignorar
            }
        }
    }
    
}