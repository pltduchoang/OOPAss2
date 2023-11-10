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
     * @postcondition The new element is at the top of the stack.
     * @throws FullStackException if the stack is full.
     */
    void push(E element);

    /**
     * Pop an element off the top of the stack.
     *
     * @precondition The stack is not empty.
     * @postcondition The element at the top of the stack is removed.
     * @return The element popped off the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    E pop();

    /**
     * Return the top element of the stack without removing it.
     *
     * @precondition The stack is not empty.
     * @return The top element of the stack.
     * @throws EmptyStackException if the stack is empty.
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
     * @return true if the stack is empty, false if it has at least one element.
     */
    boolean isEmpty();

    /**
     * Remove all elements from the stack.
     * 
     * @precondition The stack is not empty.
     * @postcondition The stack is empty.
     * @throws EmptyStackException if the stack is empty.
     */
    void clear();
}
