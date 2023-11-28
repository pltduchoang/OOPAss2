/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

/**
 *
 * @author pltdu
 * 
 */
public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;

    /**
     * Constructs a new node with the given data.
     *
     * @param data the data to be stored in the node
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * Gets the data stored in the node.
     *
     * @return the data in the node
     */
    public E getData() {
        return data;
    }

    /**
     * Sets the data in the node.
     *
     * @param data the data to be set
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Gets the next node in the linked list.
     *
     * @return the next node
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next the next node
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Gets the previous node in the linked list.
     *
     * @return the previous node
     */
    public Node<E> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the linked list.
     *
     * @param prev the previous node
     */
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
