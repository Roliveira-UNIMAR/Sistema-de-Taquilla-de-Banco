package models;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Files {

    /**
     *
     * Metodo que hace la cola de clientes a traves de archivos .txt
     *
     * @return La cola de clientes que estan esperando pasar a taquilla
     */
    public static Queue<Client> queueClients() {
        Queue<Client> clients = new Queue();
        Client tempClient = new Client();
        File fileClients = new File("src\\models\\Clientes.txt");
        File fileClientsSlopes = new File("src\\models\\Clientes_pendientes.txt");
        Scanner sc;
        String name, surname, ci;
        name = null;
        surname = null;
        ci = null;
        String line;
        if (fileClientsSlopes.exists()) {
            try {
                sc = new Scanner(fileClientsSlopes);
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    String[] separator = line.split("::");
                    name = separator[0];
                    surname = separator[1];
                    ci = separator[2];
                    tempClient = new Client(name, surname, ci);
                    clients.enqueue(tempClient);
                }
            } catch (IOException ioe) {
                Display.error("El archivo \"clientes_pendientes.txt\" no se puede leer.");
            }
            fileClientsSlopes.delete();
        }
        try {
            sc = new Scanner(fileClients);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] separator = line.split("::");
                name = separator[0];
                surname = separator[1];
                ci = separator[2];
                tempClient = new Client(name, surname, ci);
                clients.enqueue(tempClient);
            }
        } catch (FileNotFoundException fnfe) {
            Display.error("El archivo \"Clientes.txt\" no encontrado.");
        } catch (IOException ioe) {
            Display.error("El archivo \"Clientes.txt\" no se puede leer.");
        }
        return clients;
    }
    
     /**
     *
     * Metodo que guarda la cola de clientes en un archivo .txt
     *
     * @param slopes Los clientes que quedaron haciendo cola
     */
    public static void clientsSlopes(Queue<Client> slopes) {
        FileWriter file = null;
        BufferedWriter bw = null;
        if (slopes.isEmpty()) {
            return;
        } else {
            try {
                Client tempClient = slopes.dequeue();
                file = new FileWriter("clientes_pendientes.txt", true);
                bw = new BufferedWriter(file);
                bw.write(tempClient.getName() + "::" + tempClient.getSurname() + "::" + tempClient.getCI());
                bw.newLine();
                bw.flush();
            } catch (FileNotFoundException fnfe) {
                Display.error("El archivo \"Clientes_pendientes.txt\" no encontrado.");
            } catch (IOException ioe) {
                Display.error("El archivo \"Clientes_pendientes.txt\" no se puede leer.");
            } finally {
                try {
                    if(bw != null) { 
                        bw.close();
                    }
                    if(file != null) { 
                        file.close();
                    } 
                } catch (IOException ioe) { }
            }
            clientsSlopes(slopes);
        }
    }
}