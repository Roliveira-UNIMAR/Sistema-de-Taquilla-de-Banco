package models;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Client {
    private String name;
    private String surname;
    private String ci;
    private double balance;
    
    public Client() {
        this.name = null;
        this.surname = null;
        this.ci = null;
        this.balance = 0.0;
    }
    
    public Client(String n, String sn, String ci, double balance) {
        this.name = n;
        this.surname = sn;
        this.ci = ci;
        this.balance = balance;
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

    public double getBalance() {
        return this.balance;
    }
    
    public boolean withdrawal(double amount) {
        if (this.balance < amount) {
            return false;
        } else {
            this.balance -= (double) amount;
            return true;
        }
    }
    
    public void Deposit(double amount) {
        this.balance += (double) amount; 
    }
}