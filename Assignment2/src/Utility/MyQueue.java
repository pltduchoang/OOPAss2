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



public class MyQueue<E> implements QueueADT<E>, IteratorADT<E> {

    private MyDLL<E> queue;

    public MyQueue(int capacity) {
        queue = new MyDLL<>(capacity);
    }


    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        queue.addLast(newNode);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return(queue.remove(0));
    }


    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.get(0);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void dequeueAll() {
        queue.clear();
    }

  

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

    
    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return queue.toArray(holder);
    }

    @Override
    public boolean isFull() {
        return queue.size() == queue.getCapacity();
    }


    @Override
    public IteratorADT<E> iterator() {
        return new MyIterator<>(this.queue);
    }


    @Override
    public boolean hasNext() {
        return iterator().hasNext();
    }


    @Override
    public E next() throws NoSuchElementException {
        return iterator().next();
    }
}
