/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.EmptyStackException;
//import Utility.MyArrayList;


/**
 *
 * @author Matt
 */
public class MyStack<E> implements StackADT<E> {

    private MyArrayList<E> list;
    private int capacity;
    private int size;

    public MyStack() {
        list = new MyArrayList<>();
        size = 0;
        capacity = 10;
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        size = 0;
        // list = (E[]) (new MyStack<>(capacity));
        // list = new MyArrayList<>(capacity);
        // need to implement constructor that takes int
    }

    @Override
    public void push(E element) {
        list.add(element);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E remove = list.remove(list.size() - 1);
        size--;
        return remove;

        // size--;
        // return list[size];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        list.clear();
        size = 0;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public int search(E toFind) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public boolean equals(StackADT<E> that) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equals'");
    }

    @Override
    public Utility.IteratorADT<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
