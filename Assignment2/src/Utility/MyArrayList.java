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

/**
 * This class represents a generic ArrayList implementation.
 * 
*/
public class MyArrayList<E> implements ListADT<E> {
    private static final int defaultCapacity = 10;
    private int size;
    private Object[] array;


    /**
     * Constructs an empty list with default capacity.
     */
    public MyArrayList() {
        array = new Object[defaultCapacity];
        size = 0;
    }


    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity The initial capacity of the list.
     */
    public MyArrayList(int capacity) {
        array = new Object[capacity];
        size = 0;

    }


    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        size = 0;
    }


    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index The index at which the specified element is to be inserted.
     * @param toAdd The element to be inserted.
     * @throws NullPointerException If the specified element is null.
     * @throws IndexOutOfBoundsException If the index is out of range.
     * @return true if element is added successfully.
     * @return false if array is full.
     */
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



    /**
     * Appends the specified element to the end of this list.
     *
     * @param toAdd The element to be appended to this list.
     * @throws NullPointerException If the specified element is null.
     * @return true if element is added successfully.
     * @return false if array is full.
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null || toAdd == "") {
            throw new NullPointerException("Cannot add null element.");
        }
        array[size] = toAdd; // size = index+1
        size++;
        return true;
    }


    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.
     *
     * @param toAdd The new sub list to be added.
     * @throws NullPointerException If the specified element is null.
     * @return true if element is added successfully.
     * @return false if array is full.
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        MyIterator<E> iterator = new MyIterator<E>(toAdd);
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }


    /**
     * Returns the element at the specified position in this list.
     *
     * @param index Index of element to return.
     * @throws IndexOutOfBoundsException If the index is out of range.
     * @return The element at the specified position in this list.
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        @SuppressWarnings("unchecked")
        E element = (E) array[index]; // Cast Object to E
        return element;
    }


    /**
     * remove a element from the list at the specified index
     * @param index
     * @return the element that was removed
     * @throws IndexOutOfBoundsException
     */
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
        size--;

        return removedElement;
    }



    /**
     * Removes the first occurrence in this list of the specified element. If
     * this list does not contain the element, it is unchanged. More formally,
     * removes the element with the lowest index <code>i</code> such that
     * <code>o.equals(get(i))</code> (if such an element exists).
     *
     * @param toRemove The element to be removed from this list.
     * @throws NullPointerException If the specified element is null.
     * @return The element which is being removed, or null if the list does
     * not contain the element.
     */
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


    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index The index of the element to replace.
     * @param toChange Element to be stored at the specified position.
     * @throws NullPointerException If the specified element is null.
     * @throws IndexOutOfBoundsException If the index is out of range.
     * @return The element previously at the specified position.
     */
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


    /**
     * Returns <code>true</code> if this list contains no elements.
     *
     * @return <code>true</code> if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns <code>true</code> if this list contains the specified element.
     *
     * @param toFind The element whose presence in this list is to be tested.
     * @throws NullPointerException If the specified element is null.
     * @return <code>true</code> if this list contains the specified element.
     */
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


    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * @return An array containing all of the elements in this list in proper
     * sequence.
     */
    @SuppressWarnings("unchecked")
	@Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Cannot hold null array.");
        }

        // if array isnt big enough, make a new one
        if (toHold.length < size) {
            toHold = (E[]) new Object[size];
        }
        for (int i = 0; i < size; i++) {
            toHold[i] = (E) array[i];
        }
        return toHold;
    }


    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element). Obeys the general contract of the
     * <code>java.util.Collection.toArray()</code> method.
     *
     * @return An array containing all of the elements in this list in proper
     * sequence.
     */
    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }


    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return An iterator over the elements in this list in proper sequence.
     */
    @Override
    public MyIterator<E> iterator() {
        return new MyIterator<E>(this);
    }

}
