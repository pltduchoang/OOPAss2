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
public class MyDLL {
    private int size; 
    private MyDLLNode head;
    private MyDLLNode tail;

    /**
     * Constructs a new node with the given data.
     * 
     * @param data the data to be stored in the node
     */
    public MyDLL() {
        head = tail = null;
        size = 0;
        
    }
    
    /**
     * Gets the data stored in the node.
     * 
     * @return the data in the node
     */
    public void add(MyDLLNode node)
    {
       if(isEmpty())
       {
           head = tail = node;
       }
       else
       {
           tail.setNext(node);
           node.setPrev(tail);
           tail = node;
       }
       size++;
    }
    
    /**
     * Sets the data in the node.
     * 
     * @param data the data to be set
     */
    public MyDLLNode getHead() {
        return head;
    }

    /**
     * Gets the previous node in the linked list.
     * 
     * @return the previous node
     */
    public void setHead(MyDLLNode head) {
        this.head = head;
    }

    /**
     * Gets the next node in the linked list.
     * 
     * @return the next node
     */
    public MyDLLNode getTail() {
        return tail;
    }

    /**
     * Sets the next node in the linked list.
     * 
     * @param next the next node
     */
    public void setTail(MyDLLNode tail) {
        this.tail = tail;
    }

    /**
     * Gets the size of the list.
     * 
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Sets the size of the list.
     * 
     * @param size the size of the list
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns a string representation of the node.
     * 
     * @return a string representation of the node
     */
    @Override
    public String toString() {
        String info= "";
        MyDLLNode node = head;
        for (int i=0;i<size;i++)
        {
            info += node.toString()+'\n';
            node = node.getNext();
        }
            
        return info;
    }
}
