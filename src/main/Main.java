import models.*;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Main {
    public static void main(String[] args) {
        Queue<Client> queueClients = new Queue();
        int op;

        Display.menuMain();
        op = Leer.opcion(3, "Elija la opcion a realizar: ");
        switch (op) {
            case 1:
                while (!queueClients.isEmpty()) {
                        boolean terminada = false;
                        do {
                            Mostrar.menuTicketOffice();
                            op = Leer.opcion(3, "Elija la opcion a realizar: ");
                        
                            switch (op) {
                                case 1:
                                    // Apartado donde el usuario seleccionara el sabor 
                                    // de helado de su eleccion y se añadira a la factura
                                    if (contarHelados < MAXHELADOS) {
                                        Mostrar.elegirHelado();
                                        op = Leer.opcion(6, "Que sabor quiere? ");
                                        if (op != -1) {
                                            Helado saborElegido = new Helado(HELADOS[op - 1]);
                                            actualBarquilla.agregarHelado(saborElegido);
                                            invHelados.getValor(op -  1).setCantVentas();
                                            Mostrar.agregado("helado");
                                            contarHelados++;
                                        }
                                    } else {
                                        Mostrar.noagregado("helado");
                                    }
                                    break;
                                case 2:
                                    // Apartado donde el usuario seleccionara el sabor
                                    // de Topping de su eleccion y se añadira a la factura
                                    if (contarToppings < MAXTOPPINGS) {
                                        Mostrar.elegirTopping();
                                        op = Leer.opcion(7, "Que sabor quiere? ");
                                        if (op != -1) {
                                            Topping saborElegido = new Topping(TOPPINGS[op - 1]);
                                            actualBarquilla.agregarTopping(saborElegido);
                                            invToppings.getValor(op -  1).setCantVentas();
                                            Mostrar.agregado("topping");
                                            contarToppings++;
                                        }
                                    } else {
                                        Mostrar.noagregado("topping");
                                    }
                                    break;
                                case 3:
                                    // NO ME PAGAN LO SUFICIENTE PARA HACER ESTO, NISIQUIERA ME PAGAN... JAJAJA
                                    Cliente actualCliente = colaClientes.dequeue();
                                    if (actualBarquilla.getCosto() > 0) {
                                        nPedido++;
                                        String factura = actualBarquilla.toString();
                                        Mostrar.factura(nPedido, factura, actualCliente);
                                        File.guardarFactura(nPedido, factura, actualCliente); // todavia no esta listo
                                        terminada = true;
                                    } else {
                                        Mostrar.cancelar();
                                        op = Leer.opcion(2, "Elija la opcion a realizar: ");
                                        if (op == 1) {
                                            terminada = true;
                                        }
                                    }
                                    break;
                                default:
                                    if (op != -1) {
                                        Mostrar.error("La opcion no es valida.");
                                    }
                            }
                        } while (!terminada);
                    }
                    if (colaClientes.isEmpty()) {
                        Mostrar.sinCola();
                    }
                    break;
                case 2:
                    // aqui generar el inventario
                    if (colaClientes.isEmpty()) {
                        ListaInv listaInvHelados = ListaInv.ordenar(invHelados);
                        ListaInv listaInvToppings = ListaInv.ordenar(invToppings);
                        String invFinalHelados = listaInvHelados.toString();
                        String invFinalToppings = listaInvToppings.toString();
                        Mostrar.inventario(invFinalHelados, "helados");
                        Mostrar.inventario(invFinalToppings, "toppings");
                        File.guardarInventario(invFinalHelados, "helados");
                        File.guardarInventario(invFinalToppings, "toppings");
                    } else {
                        Mostrar.conCola();
                    }
                    break;
                case 3: 
                    // @author Richard: Se sale y ya jaja
                    // @author Rodrigo: Que fumaste el dia que hiciste esto? JAJAJA
                    Mostrar.salida(); // Esto es una salida con estilo
                    salir = true;
                    break;
                default:
                    if (op != -1) {
                        Mostrar.error("La opcion no es valida.");
                    }
            }
        } while(!salir);
    }
    }
}