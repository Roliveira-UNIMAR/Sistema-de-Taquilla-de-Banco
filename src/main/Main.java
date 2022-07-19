package main;

import models.*;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Main {
    public static void main(String args[]) {
        Queue<Client> queueClients = Files.queueClients();
        Stack<Transaction> transactions = new Stack();
        int op;
        boolean isExit = false;

        do {
            Display.menuMain();
            op = Input.option(3, "Elija una opción: ");
            switch (op) {
                case 1:
                    while (!queueClients.isEmpty()) {
                        boolean finished = false;
                        int request = 0;
                        do {
                            request++;
                            double amount;
                            Client currentClient  = queueClients.dequeue();
                            Display.menuTicketOffice(currentClient.getName());
                            op = Input.option(6, "Elija la opcion a realizar: ");
                            switch (op) {
                                case 1:
                                    amount = Input.amount("Ingrese la cantidad a retirar: ");
                                    currentClient.withdrawal(amount);
                                    Display.waitClient(4);
                                    transactions.push(new Transaction("RETIRO", amount));
                                    break;
                                case 2:
                                    amount = Input.amount("Ingrese la cantidad a depositar: ");
                                    currentClient.Deposit(amount);
                                    Display.waitClient(3);
                                    transactions.push(new Transaction("DEPOSITO", amount));
                                    break;
                                case 3:
                                    Display.text("Estamos consultando sus movimientos");
                                    Display.waitClient(1, 5);
                                    transactions.push(new Transaction("CONSULTA DE MOVIMIENTOS"));
                                    break;
                                case 4:
                                    Display.text("Actualizando libretas");
                                    Display.waitClient(5);
                                    break;
                                case 5:
                                    Display.paymentServices();
                                    op = Input.option(4, "Elija el servicio a pagar: ");
                                    Display.waitClient(2);
                                    transactions.push(new Transaction("PAGO SERVICIOS"));
                                    break;
                                case 6:
                                    finished = true;
                                    break;
                                default:
                                    if (op != -1) {
                                        Display.error("La opcion no es valida.");
                                    }
                                }
                            } while ((!finished) || (request > 5));
                        }
                        Display.text("Operaciones terminadas");
                        if (queueClients.isEmpty()) {
                            Display.withoutQueue();
                        }
                        break;
                    case 2:
                        if (queueClients.isEmpty()) {
                            Stack<Transaction> operations = new Stack();
                            while (!transactions.isEmpty()) {
                                operations.push(transactions.pop());
                            }
                            Files.saveOperations(operations);
                        } else {
                            Display.withQueue();
                        }
                        break;
                    case 3: 
                        Display.exitSystem();
                        isExit = true;
                        break;
                    default:
                        if (op != -1) {
                            Display.error("La opcion no es valida.");
                        }
            }
        } while(!isExit);
    }
}