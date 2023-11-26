/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.EmptyStackException;


/**
 *
 * @author Matt
 */
public class MyStack<E> implements StackADT<E> {

    private MyArrayList<E> stack;

    public MyStack() {
    	stack = new MyArrayList<>();
    }

    public MyStack(int capacity) {
        if (capacity <= 0) {
        	stack = new MyArrayList<>();
        }
        else {
        	stack = new MyArrayList<>(capacity);
        }
    }

    @Override
    public void push(E element) {
    	stack.add(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E popItem = stack.remove(size() - 1);
        return popItem;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E peekItem = stack.get(size() - 1);
        return peekItem;
    }

    @Override
    public void clear() {
    	stack.clear();
    }
    
    @Override
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public Object[] toArray() {
        return stack.toArray();
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        return stack.toArray(toHold);
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return stack.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public Utility.IteratorADT<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public boolean equals(StackADT<E> that) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equals'");
    }
    
    @Override
    public int size() {
        return stack.size();
    }
}
