/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

/**
 * A Stack Abstract Data Type to be implemented by data structures including:
 * Doubly Linked List and Array List.
 *
 * @author Group 2
 * 
 * @param <E> The type of elements stored in the stack.
 */
public interface StackADT<E> {
    /**
     * Push an element onto the top of the stack.
     *
     * @param element The element to be pushed onto the stack.
     */
    void push(E element);

    /**
     * Pop an element off the top of the stack.
     *
     * @return The element popped off the top of the stack.
     */
    E pop();

    /**
     * Return the top element of the stack without removing it.
     *
     * @return The top element of the stack.
     */
    E peek();

    /**
     * Return the number of elements in the stack.
     * 
     * @return The number of elements in the stack.
     */
    int size();

    /**
     * Check if the stack is empty.
     *
     * @return true if the stack is empty, false if at least one element.
     */
    boolean isEmpty();
}
