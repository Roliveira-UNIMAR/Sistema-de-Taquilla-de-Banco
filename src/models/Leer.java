import java.util.Scanner;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Leer {
    static Scanner leer = new Scanner(System.in);
    
    /**
     *
     * Metodo que lee la opcion del usuario, evitando que no sea un numero y que no se encuentre entre 0 y max
     *
     * @param max El numero maximo de opciones del usuario
     * @param msj El mesaje que se le muestra al usuario
     * @return La opcion del usuario que es un nuemero entre 1 y max, en caso de error retorna -1
     */
    public static int opcion(int max, String msj) {
        int op = -1;
        try {
            do {
                if (((op < 1) || (op > max)) && (op != -1)) {
                    Mostrar.error("La opcion no es valida");
                }
                System.out.print("\n\t" + msj);
                String l = leer.next();
                op = Integer.parseInt(l);
            } while ((op < 1) || (op > max));
        } catch(NumberFormatException nfe) {
           Mostrar.error("La opcion debe ser un numero");
        }
        return op;
    }
}