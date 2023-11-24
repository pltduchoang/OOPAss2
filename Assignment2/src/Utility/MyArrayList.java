/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

//import Utility.MyIterator;
/**
 *
 * @author Matt
 */
public class MyArrayList<E> implements ListADT<E> {
    private static final int defaultCapacity = 10;
    private int size;
    private Object[] array;

    public MyArrayList() {
        array = new Object[defaultCapacity];
        size = 0;
    }

    public MyArrayList(int capacity) {
        array = new Object[capacity];
        this.size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[defaultCapacity];
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (toAdd == null || toAdd == "") {
            throw new NullPointerException("Cannot add null element.");
        }

        // If array is already full
        if (size == array.length) {
            return false;
        }

        // Shift elements to make space for the new one
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        // Add new element
        array[index] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null || toAdd == "") {
            throw new NullPointerException("Cannot add null element.");
        }
        array[size] = toAdd; // size = index+1
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        MyIterator<E> iterator = new MyIterator<E>(toAdd);
        while (iterator.hasNext()) {
            add(iterator.next());
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        @SuppressWarnings("unchecked")
        E element = (E) array[index]; // Cast Object to E
        return element;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        // Save the removed element for the return
        E removedElement = get(index);

        // Shift elements after the removed element to the left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        return removedElement;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null || toRemove == "") {
            throw new NullPointerException("Cannot remove null element.");
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == toRemove) {
                return remove(i); // Remove and return the element
            }
        }
        return null; // Element not found
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (toChange == null) {
            throw new NullPointerException("Cannot change to null element.");
        }
        // Save the old element for the return
        E old = get(index);
        array[index] = toChange;
        return old;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null || toFind == "") {
            throw new NullPointerException("Cannot find null element.");
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Cannot hold null array.");
        }

        E[] newArray = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = (E) array[i];
        }
        return newArray;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public Utility.MyIterator<E> iterator() {
        return new SLLIterator();
    }

}
