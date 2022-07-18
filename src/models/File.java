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
     */
    public static Queue<Cliente> colaClientes() {
        Queue<Cliente> clientes = new Queue();
        Cliente tempCliente = new Cliente();
        FileRearder fileClientes = new FileReader("src\\models\\Clientes.txt");
        FileRearder fileClientesPendientes = new FileReader("src\\models\\clientes_pendientes.txt");
        BufferedReader br;
        String nombre, apellido, ci;
        nombre = apellido = ci = null;
        if (fileClientesPendientes.exists()) {
            try {
                br = new BufferedReader(fileClientesPendientes );
                while ((line = br.readLine()) != null) {
                    String[] separator = line.split("::");
                    nombre = separator[0];
                    apellido = separator[1];
                    ci = separator[2];
                    tempCliente = new Cliente(nombre, apellido, ci);
                    clientes.enqueue(tempCliente);
                }
            } catch (IOException ioe) {
                Mostrar.error("El archivo \"clientes_pendientes.txt\" no se puede leer.");
            }
            fileClientesPendientes.delete();
        }
        br = new BufferedReader(fileClientes);
        try {
            while ((line = br.readLine()) != null) {
                String[] separator = line.split("::");
                nombre = separator[0];
                apellido = separator[1];
                ci = separator[2];
                tempCliente = new Cliente(nombre, apellido, ci);
                clientes.enqueue(tempCliente);
            }
        } catch (FileNotFoundException fnfe) {
            Mostrar.error("El archivo \"Clientes.txt\" no encontrado.");
        } catch (IOException ioe) {
            Mostrar.error("El archivo \"Clientes.txt\" no se puede leer.");
        }
        return clientes;
    }
    
     /**
     *
     * Metodo que guarda la cola de clientes en un archivo .txt
     *
     * @param pendientes Los clientes que quedaron haciendo cola
     */
    public static void clientesPendientes(Queue<Cliente> pendientes) {
        FileWriter file = null;
        BufferedWriter bw = null;
        if (pendientes.isEmpty()) {
            return;
        } else {
            try {
                Cliente tempCliente = pendientes.dequeue();
                file = new FileWriter("clientes_pendientes.txt", true);
                bw = new BufferedWriter(file);
                bw.write(tempCliente.getNombre() + "::" + tempCliente.getApellido() + "::" + tempCliente.getCI());
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
            clientesPendientes(pendientes);
        }
    }
}