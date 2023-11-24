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

    public MyDLL(int capacity) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

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

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (size >= capacity) {
            throw new IllegalStateException("Cannot add more elements. The list is at its capacity.");
        }

        Node<E> newNode = new Node<>(toAdd);
        addLast(newNode);
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        E[] elements = (E[]) toAdd.toArray();

        for (E element : elements) {
            addLast(new Node<>(element));
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return getNode(index).getData();
    }

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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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

    @Override
    public MyIterator<E> iterator() {
        return new MyIterator<E>(this);
    }

    // Helper method to add a node to the front of the list
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

    // Helper method to add a node to the end of the list
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