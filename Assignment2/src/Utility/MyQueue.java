/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.NoSuchElementException;

/**
 *
 * @author pltdu
 */
/**
 * This class represents a generic queue implementation using an underlying
 * ArrayList.
 *
 * @param <E> The type of elements stored in the queue.
 */


public class MyQueue<E> implements QueueADT<E>, IteratorADT<E> {



    private MyDLL<E> queue;


    /**
     * Constructs an empty queue with default capacity.
     *
     * @param capacity
     */
    public MyQueue(int capacity) {
        queue = new MyDLL<>(capacity);
    }


    /**
     * Constructs an empty queue with the specified initial capacity.
     *
     * @param capacity The initial capacity of the queue.
     */

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        queue.addLast(newNode);
    }


    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return The element removed from the front of the queue.
     * @throws NoSuchElementException If the queue is empty.
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return(queue.remove(0));
    }


    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return The element at the front of the queue.
     * @throws NoSuchElementException If the queue is empty.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.get(0);
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    @Override
    public int size() {
        return queue.size();
    }


    /**
     * Returns <code>true</code> if the queue contains no elements.
     *
     * @return <code>true</code> if the queue contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    /**
     * Removes all elements from the queue.
     */
    @Override
    public void dequeueAll() {
        queue.clear();
    }

  

    /**
     * Used to compare two Queue ADT's. To be equal two queues must contain
     * equal items appearing in the same order.
     *
     * @param that the Queue ADT to be compared to this queue.
     * @return <code>true</code> if the queues are equal.
     */

    @Override
    public boolean equals(QueueADT<E> that) {
        if (that == null) {
            return false;
        }
    
        if (this.size() != that.size()) {
            return false;
        }
    
        IteratorADT<E> thisIterator = this.iterator();
        IteratorADT<E> thatIterator = that.iterator();
    
        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            E thisElement = thisIterator.next();
            E thatElement = thatIterator.next();
    
            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }
    
        return true;
    }


    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. Obeys the general contract of the Collection.toArray method.
     *
     * @return an array containing all of the elements in this list in proper
     * sequence.
     */
    
    @Override
    public Object[] toArray() {
        return queue.toArray();
    }


    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array. Obeys the general contract of the Collection.toArray(Object[])
     * method.
     *
     * @param toHold the array into which the elements of this queue are to be
     * stored, if it is big enough; otherwise, a new array of the same runtime
     * type is allocated for this purpose.
     * @return an array containing the elements of this queue.
     * @throws NullPointerException if the specified array is null.
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return queue.toArray(holder);
    }


    /**
     * Returns <code>true</code> if this queue contains the specified element.
     *
     * @param toFind The element whose presence in this queue is to be tested.
     * @return <code>true</code> if this queue contains the specified element.
     * @throws NullPointerException if the specified element is null and the
     * queue implementation does not support having null elements.
     */
    @Override
    public boolean isFull() {
        return queue.size() == queue.getCapacity();
    }


    /**
     * Returns the length of the current queue as an integer value.
     *
     * @return the current size to the queue as an integer.
     */
    @Override
    public IteratorADT<E> iterator() {
        return new MyIterator<>(this.queue);
    }


    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     *
     * @return an iterator over the elements in this queue in proper sequence.
     */
    @Override
    public boolean hasNext() {
        return iterator().hasNext();
    }


    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration.
     * @throws NoSuchElementException if the iteration has no more elements.
     */
    @Override
    public E next() throws NoSuchElementException {
        return iterator().next();
    }
}
