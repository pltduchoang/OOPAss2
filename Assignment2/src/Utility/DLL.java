/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

/**
 *
 * @author pltdu
 */

public class DLL<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs an empty Doubly Linked List.
     */
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Checks if the DLL is empty.
     *
     * @return true if the DLL is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Gets the number of elements in the DLL.
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the front of the DLL.
     *
     * @param data the data to add
     */
    public void addToFront(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the DLL.
     *
     * @param data the data to add
     */
    public void addToEnd(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds an element with data after a specific key.
     *
     * @param key  the key after which to add the new element
     * @param data the data to add
     */
    public void addAfter(E key, E data) {
        Node<E> current = head;
        while (current != null && !current.getData().equals(key)) {
            current = current.getNext();
        }

        if (current != null) {
            Node<E> newNode = new Node<>(data);
            newNode.setPrev(current);
            newNode.setNext(current.getNext());
            if (current.getNext() != null) {
                current.getNext().setPrev(newNode);
            } else {
                tail = newNode;
            }
            current.setNext(newNode);
            size++;
        }
    }

    /**
     * Deletes an element with a specific key.
     *
     * @param key the key of the element to delete
     */
    public void delete(E key) {
        Node<E> current = head;
        while (current != null && !current.getData().equals(key)) {
            current = current.getNext();
        }

        if (current != null) {
            if (current.getPrev() != null) {
                current.getPrev().setNext(current.getNext());
            } else {
                head = current.getNext();
            }

            if (current.getNext() != null) {
                current.getNext().setPrev(current.getPrev());
            } else {
                tail = current.getPrev();
            }

            size--;
        }
    }

    /**
     * Displays elements in the forward direction.
     */
    public void displayForward() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Displays elements in the backward direction.
     */
    public void displayBackward() {
        Node<E> current = tail;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }
}
