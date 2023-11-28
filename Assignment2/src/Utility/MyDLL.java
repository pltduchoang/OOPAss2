/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;


import java.util.NoSuchElementException;

/**
 * This class represents a node in a doubly linked list.
 * 
 * @param <E> the type of the data stored in the node
 */
public class MyDLL<E> implements ListADT<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int capacity;

    /**
     * Constructs an empty list with the specified initial capacity.
     * 
     * @param capacity the initial capacity of the list
     */
    public MyDLL(int capacity) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Constructs an empty list with default capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the list.
     * 
     * @param capacity the new capacity of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Adds an element to the list at the specified index.
     * 
     * @param index the index at which to add the element
     * @param toAdd the element to add
     * @return true if the element was added successfully, false otherwise
     * @throws NullPointerException if the element to add is null
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> newNode = new Node<>(toAdd);

        if (index == 0) {
            addFirst(newNode);
        } else if (index == size) {
            addLast(newNode);
        } else {
            Node<E> current = getNode(index);
            Node<E> previous = current.getPrev();

            previous.setNext(newNode);
            newNode.setPrev(previous);

            newNode.setNext(current);
            current.setPrev(newNode);

            size++;
        }

        return true;
    }


    /**
     * Adds an element to the end of the list.
     * 
     * @param toAdd the element to add
     * @return true if the element was added successfully, false otherwise
     * @throws NullPointerException if the element to add is null
     * @throws IllegalStateException if the list is at capacity
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (size >= capacity) {
            throw new IllegalStateException("Cannot add more elements. The list is at its capacity.");
        }

        Node<E> newNode = new Node<>(toAdd);
        addLast(newNode);
        return true;
    }

    /**
     * Adds all of the elements in the specified collection to the end of the list.
     * 
     * @param toAdd the collection of elements to add
     * @return true if the elements were added successfully, false otherwise
     * @throws NullPointerException if the collection of elements to add is null
     * @throws IllegalStateException if the list is at capacity
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        E[] elements = (E[]) toAdd.toArray();

        for (E element : elements) {
            addLast(new Node<>(element));
        }
        return true;
    }


    /**
     * Returns the element at the specified index in the list.
     * 
     * @param index the index of the element to return
     * @return the element at the specified index in the list
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return getNode(index).getData();
    }


    /**
     * Removes the element at the specified index in the list.
     * 
     * @param index the index of the element to remove
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = getNode(index);
        Node<E> previous = current.getPrev();
        Node<E> next = current.getNext();

        if (previous == null) {
            // Removing the head
            head = next;
        } else {
            previous.setNext(next);
            current.setPrev(null);
        }

        if (next == null) {
            // Removing the tail
            tail = previous;
        } else {
            next.setPrev(previous);
            current.setNext(null);
        }

        size--;

        return current.getData();
    }

    /**
     * Removes the first occurrence in this list of the specified element. If this
     * list does not contain the element, it is unchanged. More formally, removes
     * the element with the lowest index <code>i</code> such that
     * <code>o.equals(get(i))</code> (if such an element exists).
     * 
     * @param toRemove the element to be removed from this list
     * @return the element which is being removed, or null if the list does not
     *         contain the element
     * @throws NullPointerException if the specified element is null and the list
     *                              implementation does not support having null
     *                              elements
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        Node<E> current = head;

        while (current != null) {
            if (toRemove.equals(current.getData())) {
                Node<E> previous = current.getPrev();
                Node<E> next = current.getNext();

                if (previous == null) {
                    // Removing the head
                    head = next;
                } else {
                    previous.setNext(next);
                    current.setPrev(null);
                }

                if (next == null) {
                    // Removing the tail
                    tail = previous;
                } else {
                    next.setPrev(previous);
                    current.setNext(null);
                }

                size--;

                return current.getData();
            }

            current = current.getNext();
        }

        return null; // Element not found
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * 
     * @param index    the index of the element to replace
     * @param toChange element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws NullPointerException     if the specified element is null and the
     *                                  list implementation does not support having
     *                                  null elements
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = getNode(index);
        E oldData = current.getData();
        current.setData(toChange);

        return oldData;
    }

    /**
     * Returns true if this list contains no elements.
     * 
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }



    /**
     * Returns true if this list contains the specified element.
     * 
     * @param toFind the element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     * @throws NullPointerException if the specified element is null and the list
     *                              implementation does not support having null
     *                              elements
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        Node<E> current = head;

        while (current != null) {
            if (toFind.equals(current.getData())) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }


   

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. Obeys the general contract of the Collection.toArray method.
     * 
     * @return an array containing all of the elements in this list in proper
     *         sequence
     */
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold.length < size) {
            // If the array is not big enough, create a new one of the correct size
            toHold = (E[]) new Object[size];
        }

        int index = 0;
        Node<E> current = head;

        while (current != null) {
            toHold[index++] = current.getData();
            current = current.getNext();
        }

        return toHold;
    }



    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. Obeys the general contract of the Collection.toArray method.
     * 
     * @return an array containing all of the elements in this list in proper
     *         sequence
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node<E> current = head;

        while (current != null) {
            array[index++] = current.getData();
            current = current.getNext();
        }

        return array;
    }


    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * 
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public MyIterator<E> iterator() {
        return new MyIterator<E>(this);
    }


    /**
     * Adds an element to the beginning of the list.
     * @param newNode
     */
    public void addFirst(Node<E> newNode) {
        if (head == null) {
            // List is empty
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        size++;
    }


    /**
     * Adds an element to the end of the list.
     * @param newNode
     */
    public void addLast(Node<E> newNode) {
        if (tail == null) {
            // List is empty
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    // Helper method to get the node at a specific index
    /**
     * Helper method to get the node at a specific index
     * @param index
     * @return
     */
    public Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current;
        if (index < size / 2) {
            // Start from the head and move forward
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            // Start from the tail and move backward
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }

        return current;
    }
}