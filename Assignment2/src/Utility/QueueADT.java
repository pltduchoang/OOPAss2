/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

/**
 * A Queue Abstract Data Type to be implemented by data structures including:
 * Doubly Linked List and Array List.
 *
 * @authors Group 2: Duc Hoang, Sean Lam, Edward Magtoto, Matt Yackel
 * 
 * @param <E> The type of elements stored in the queue.
 */
public interface QueueADT<E> {
    /**
     * Enqueue (add) an element at the back of the queue.
     *
     * @param element The element to be enqueued (added).
     * @postcondition The new element is at the back of the queue.
     * @throws FullQueueException   if the queue is full.
     * @throws InvalidTypeException if the element is not of the correct type.
     */
    void enqueue(E element);

    /**
     * Dequeue (remove) an element from the front (bottom) of the queue.
     * 
     * @param element The element to be enqueued (added).
     * @precondition The queue is not empty.
     * @postcondition The element at the front of the queue is removed.
     * @return the element that was removed from the front of he queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    E dequeue();

    /**
     * Return the top element of the stack without removing it.
     *
     * @precondition The stack is not empty.
     * @return The front (bottom) element of the stack.
     * @throws EmptyQueueException if the stack is empty.
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
     * @return true if the queue is empty, false if it has at least one element.
     */
    boolean isEmpty();

    /**
     * Remove all elements from the queue.
     * 
     * @precondition The queue is not empty.
     * @postcondition The queue is empty.
     * @throws EmptyQueueException if the queue is empty.
     */
    void clear();
}
