import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class File {

    /**
     *
     * Metodo que hace la cola de clientes a traves de archivos .txt
     *
     * @return La cola de clientes que estan esperando pasar a taquilla
     */
    public static Queue<Cliente> queueClients() {
        Queue<Cliente> clients = new Queue();
        Cliente tempClient = new Cliente();
        FileRearder fileClients = new FileReader("src\\models\\Clientes.txt");
        FileRearder fileClientsSlopes = new FileReader("src\\models\\Clientes_pendientes.txt");
        BufferedReader br;
        String name, surname, ci;
        name = surname = ci = null;
        if (fileClientsSlopes.exists()) {
            try {
                br = new BufferedReader(fileClientsSlopes);
                while ((line = br.readLine()) != null) {
                    String[] separator = line.split("::");
                    name = separator[0];
                    surname = separator[1];
                    ci = separator[2];
                    tempClient = new Client(name, surname, ci);
                    clients.enqueue(tempClient);
                }
            } catch (IOException ioe) {
                Mostrar.error("El archivo \"clientes_pendientes.txt\" no se puede leer.");
            }
            fileClientsSlopes.delete();
        }
        br = new BufferedReader(fileClients);
        try {
            while ((line = br.readLine()) != null) {
                String[] separator = line.split("::");
                name = separator[0];
                surname = separator[1];
                ci = separator[2];
                tempClient = new Cliente(name, surname, ci);
                clients.enqueue(tempClient);
            }
        } catch (FileNotFoundException fnfe) {
            Mostrar.error("El archivo \"Clientes.txt\" no encontrado.");
        } catch (IOException ioe) {
            Mostrar.error("El archivo \"Clientes.txt\" no se puede leer.");
        }
        return clients;
    }
    
     /**
     *
     * Metodo que guarda la cola de clientes en un archivo .txt
     *
     * @param slopes Los clientes que quedaron haciendo cola
     */
    public static void clientsSlopes(Queue<Cliente> slopes) {
        FileWriter file = null;
        BufferedWriter bw = null;
        if (slopes.isEmpty()) {
            return;
        } else {
            try {
                Cliente tempClient = slopes.dequeue();
                file = new FileWriter("clientes_pendientes.txt", true);
                bw = new BufferedWriter(file);
                bw.write(tempClient.getname() + "::" + tempClient.getsurname() + "::" + tempClient.getCI());
                bw.newLine();
                bw.flush();
            } catch (FileNotFoundException fnfe) {
                Mostrar.error("El archivo \"Clientes_pendientes.txt\" no encontrado.");
            } catch (IOException ioe) {
                Mostrar.error("El archivo \"Clientes_pendientes.txt\" no se puede leer.");
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