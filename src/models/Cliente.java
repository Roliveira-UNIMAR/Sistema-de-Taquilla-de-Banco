/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private String ci;
    
    public Cliente() {
        this.nombre = null;
        this.apellido = null;
        this.ci = null;
    }
    
    public Cliente(String n, String a, String ci) {
        this.nombre = n;
        this.apellido = a;
        this.ci = ci;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getApellido() {
        return this.apellido;
    }
    
    public String getCI() {
        return this.ci;
    }
}