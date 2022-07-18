package models;

/**
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    /**
     * Constructor por defecto del nodo
     */
    public Node() {
        this.value = null;
        this.next = null;
    }

    /**
     * Constructor con parametros del nodo
     * 
     * @param v El valor del nodo
     * @param next El nodo siguiente
     */
    public Node(T v, Node<T> next){
        this.value = v;
        this.next = next;
    }
    
    /**
     * Constructor con parametros del nodo
     *
     * @param v Es el objeto del nodo
     */
    public Node(T v) {
        this.value = v;
        this.next = null;
    }
    
    /**
     * Metodo que obtiene el siguiente nodo
     *
     * @return El siguiente nodo
     */
    public Node<T> getNext() {
       return this.next;
    }
    
    /**
     * Metodo que modifica el siguiente nodo
     *
     * @param next El nodo por el cual se cambiara el actual
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    /**
     * Metodo que obtiene el valor del nodo
     *
     * @return El siguiente nodo
     */
    public T getValue() {
       return this.value;
    }
    
    /**
     * Metodo que modifica el siguiente nodo
     *
     * @param v El valor por el cual se cambiara el actual
     */
    public void setValue(T v) {
        this.value = v;
    }
}