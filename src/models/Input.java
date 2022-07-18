import java.util.Scanner;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Input {
    static Scanner sc = new Scanner(System.in);
    
    /**
     *
     * Metodo que lee la opcion del usuario, evitando que no sea un numero y que no se encuentre entre 0 y max
     *
     * @param max El numero maximo de opciones del usuario
     * @param msj El mesaje que se le muestra al usuario
     * @return La opcion del usuario que es un nuemero entre 1 y max, en caso de error retorna -1
     */
    public static int option(int max, String msj) {
        int op = -1;
        try {
            do {
                if (((op < 1) || (op > max)) && (op != -1)) {
                    Display.error("La opcion no es valida");
                }
                System.out.print("\n\t" + msj);
                String opt = sc.next();
                op = Integer.parseInt(opt);
            } while ((op < 1) || (op > max));
        } catch(NumberFormatException nfe) {
           Display.error("La opcion debe ser un numero");
        }
        return op;
    }
}