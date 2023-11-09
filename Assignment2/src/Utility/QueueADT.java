/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

/**
 * A Queue Abstract Data Type to be implemented by data structures including:
 * Doubly Linked List and Array List.
 *
 * @author Group 2
 * 
 * @param <E> The type of elements stored in the stack.
 */
public interface QueueADT<E> {
    /**
     * Enqueue (add) an element at the back of the queue.
     *
     * @param element The element to be enqueued.
     */
    void enqueue(E element);

    /**
     * Dequeue (remove) an element from the front (bottom) of the queue.
     * 
     * @return the new element at the front of he queue
     */
    E dequeue();

    /**
     * Return the top element of the stack without removing it.
     *
     * @return The front (bottom) element of the stack.
     */
    E peek();

    /**
     * Return the number of elements in the queue.
     * 
     * @return The number of elements in the queue.
     */
    int size();

    /**
     * Check if the queue is empty.
     *
     * @return true if the queue is empty, false if at least one element.
     */
    boolean isEmpty();
}
