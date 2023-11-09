package Utility;
import java.util.NoSuchElementException;

public class MyIterator<E> implements Iterator<E>{
    private E[] elements;
    private int currentPosition;

    public MyIterator(E[] elements) {
        this.elements = elements;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < elements.length;
    }

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
