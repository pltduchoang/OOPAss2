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
    private int size;

    public MyStack() {
        list = new MyArrayList<>();
        size = 0;
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
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
        size = 0;
    }

}
