/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.EmptyStackException;


/**
 *
 * @author Sean
 */
/**
 * This class represents a generic stack implementation using an underlying ArrayList.
 *
 * @param <E> The type of elements stored in the stack.
 */
@SuppressWarnings("serial")
public class MyStack<E> implements StackADT<E>, IteratorADT<E> {

    private MyArrayList<E> stack;

    /**
     * Constructs an empty stack with default capacity.
     */
    public MyStack() {
    	stack = new MyArrayList<>();
    }

    /**
     * Constructs an empty stack with the specified initial capacity.
     *
     * @param capacity The initial capacity of the stack.
     */

    public MyStack(int capacity) {
        if (capacity <= 0) {
        	stack = new MyArrayList<>();
        }
        else {
        	stack = new MyArrayList<>(capacity);
        }
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element The element to be pushed onto the stack.
     */
    @Override
    public void push(E element) {
    	stack.add(element);
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element removed from the top of the stack.
     * @throws EmptyStackException If the stack is empty.
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E popItem = stack.remove(size() - 1);
        return popItem;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException If the stack is empty.
     */

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E peekItem = stack.get(size() - 1);
        return peekItem;
    }


    /**
     * Removes all elements from the stack.
     * 
     */
    @Override
    public void clear() {
    	stack.clear();
    }
    

    /**
     * Returns <code>true</code> if the stack contains no elements.
     *
     * @return <code>true</code> if the stack contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return stack.size() == 0;
    }


    /**
     * Returns an array containing all of the elements in this stack in proper
     * sequence (from the top of the stack to the bottom of the stack).
     *
     * @return An array containing all of the elements in this stack in proper
     * sequence.
     */
    @Override
    public Object[] toArray() {
        return stack.toArray();
    }

    /**
     * Returns an array containing all of the elements in this stack in proper
     * sequence (from the top of the stack to the bottom of the stack); the
     * runtime type of the returned array is that of the specified array.
     *
     * @param toHold The array into which the elements of this stack are to be
     * stored, if it is big enough; otherwise, a new array of the same runtime
     * type is allocated for this purpose.
     * @return An array containing all of the elements in this stack in proper
     * sequence.
     * @throws NullPointerException If the specified array is <code>null</code>.
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        return stack.toArray(toHold);
    }


    /**
     * Returns <code>true</code> if this stack contains the specified element.
     *
     * @param toFind The element whose presence in this stack is to be tested.
     * @return <code>true</code> if this stack contains the specified element.
     * @throws NullPointerException If the specified element is <code>null</code>
     * and the stack implementation does not support having <code>null</code>
     * elements.
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return stack.contains(toFind);
    }

    /**
     * Returns the 1-based position where an object is on this stack. If the
     * object <code>toFind</code> occurs as an item in this stack, this method
     * returns the distance from the top of the stack of the occurrence nearest
     * the top of the stack; the topmost item on the stack is considered to be
     * at distance <code>1</code>. The <code>equals</code> method is used to
     * compare <code>toFind</code> to the items in this stack.
     *
     * @param toFind The desired object.
     * @return The 1-based position from the top of the stack where the object
     * is located; the return value <code>-1</code> indicates that the object
     * is not on the stack.
     * @throws NullPointerException If the specified element is <code>null</code>
     * and the stack implementation does not support having <code>null</code>
     * elements.
     */

    @Override
    public int search(E toFind) {
    	int distance = 0;
    	for (int i = stack.size() - 1; i >= 0; i--) {
    		distance++;
            if (stack.get(i) == toFind) {
                return distance;
            }
        }
    	return -1;
    }

    /**
     * Returns an iterator over the elements in this stack in proper sequence.
     *
     * @return An iterator over the elements in this stack in proper sequence.
     */
    @Override
    public IteratorADT<E> iterator() {
    	return new MyIterator<>(this.stack);
    }


    /**
     * Used to compare two Stack ADT's. To be equal two stacks must contain
     * equal items appearing in the same order.
     *
     * @param that The Stack ADT to be compared to this stack.
     * @return <code>true</code> if the stacks are equal.
     */
    @Override
    public boolean hasNext() {
        return iterator().hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return The next element in the iteration.
     * @throws java.util.NoSuchElementException If the iteration has no more
     * elements.
     */
    @Override
    public E next() {
        return iterator().next();
    }
    
    /**
     * Used to compare two Stack ADT's. To be equal two stacks must contain
     * equal items appearing in the same order.
     *
     * @param that The Stack ADT to be compared to this stack.
     * @return <code>true</code> if the stacks are equal.
     */
    @Override
    public boolean equals(StackADT<E> that) {
    	IteratorADT<E> thisIterator = this.iterator();
        IteratorADT<E> thatIterator = that.iterator();

        while (thisIterator.hasNext()) {
            E thisElement = thisIterator.next();
            E thatElement = thatIterator.next();

            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the depth of the current stack as an integer value.
     *
     * @return The current size to the stack as an integer.
     */
    
    @Override
    public int size() {
        return stack.size();
    }
}
