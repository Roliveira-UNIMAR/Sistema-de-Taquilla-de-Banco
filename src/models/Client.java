/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Client {
    private String name;
    private String surname;
    private String ci;
    
    public Client() {
        this.name = null;
        this.surname = null;
        this.ci = null;
    }
    
    public Client(String n, String sn, String ci) {
        this.name = n;
        this.surname = sn;
        this.ci = ci;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public String getCI() {
        return this.ci;
    }
}