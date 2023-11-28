package Utility;

import java.util.NoSuchElementException;

/**
 * This class represents a generic iterator implementation.
 *
 * @param <E> The type of elements stored in the iterator.
 */
public class MyIterator<E> implements IteratorADT<E> {
    private E[] elements;
    private int currentPosition;

    /**
     * Constructs an iterator for the given array.
     *
     * @param elements The array to iterate over.
     */
    public MyIterator(E[] elements) {
        this.elements = elements;
        this.currentPosition = 0;
    }
    
    /**
     * Constructs an iterator for the given array list.
     *
     * @param myArrayList The array list to iterate over.
     */
    public MyIterator(MyArrayList<E> myArrayList) {
        this.elements = (E[]) myArrayList.toArray();
        this.currentPosition = 0;
    }

    /**
     * Constructs an iterator for the given doubly linked list.
     *
     * @param myDLL The doubly linked list to iterate over.
     */
    public MyIterator(MyDLL<E> myDLL) {
        this.elements = (E[]) myDLL.toArray();
        this.currentPosition = 0;
    }

    /**
     * Constructs an iterator for the given queue.
     *
     * @param myQueue The queue to iterate over.
     */
    public MyIterator(ListADT<? extends E> toAdd) {
    	this.elements = (E[]) toAdd.toArray();
        this.currentPosition = 0;
	}

    /**
     * returns true if there are more elements in the iteration.
     */
	@Override
    public boolean hasNext() {
        return currentPosition < elements.length;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return The next element in the iteration.
     * @throws NoSuchElementException If there are no more elements in the iteration.
     */
    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iteration");
        } else {
            E nextElement = elements[currentPosition];
            currentPosition++;
            return nextElement;
        }
    }
}
