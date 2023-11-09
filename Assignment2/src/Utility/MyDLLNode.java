/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

/**
 * This class represents a node in a doubly linked list.
 * 
 * @param <E> the type of the data stored in the node
 */
public class MyDLLNode {
    private int value;
    private MyDLLNode prev;
    private MyDLLNode next;
    
    /**
     * Constructs a new node with the given data.
     * 
     * @param data the data to be stored in the node
     */
    public MyDLLNode(int value) {
        this.value = value;
        prev = next = null;
    }

    /**
     * Gets the data stored in the node.
     * 
     * @return the data in the node
     */ 
    public int getValue() {
        return value;
    }

    /**
     * Sets the data in the node.
     * 
     * @param data the data to be set
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Gets the previous node in the linked list.
     * 
     * @return the previous node
     */
    public MyDLLNode getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the linked list.
     * 
     * @param prev the previous node
     */
    public void setPrev(MyDLLNode prev) {
        this.prev = prev;
    }

    /**
     * Gets the next node in the linked list.
     * 
     * @return the next node
     */
    public MyDLLNode getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     * 
     * @param next the next node
     */
    public void setNext(MyDLLNode next) {
        this.next = next;
    }

    /**
     * Returns a string representation of the node.
     * 
     * @return a string representation of the node
     */
    @Override
    public String toString() {
        return "DNode{" + "value=" + value + '}';
    }
}
