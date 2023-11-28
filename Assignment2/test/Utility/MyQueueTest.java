/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Utility;

import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;
import Utility.MyIterator;

/**
 *
 * @author pltdu
 */
public class MyQueueTest {
    
    public MyQueueTest() {
    }

    /**
     * Test of enqueue method, of class MyQueue.
     */
    @Test
    public void testEnqueue() {
        MyQueue<Integer> instance = new MyQueue<>(5);

        // Enqueue elements
        instance.enqueue(5);
        instance.enqueue(10);
        instance.enqueue(15);

        // Test if elements are added correctly
        assertEquals(5, (int) instance.peek());
        assertEquals(3, instance.size());
    }

    /**
     * Test of dequeue method, of class MyQueue.
     */
    @Test
    public void testDequeue() {
        MyQueue<Integer> instance = new MyQueue<>(5); // Assuming Integer type for MyQueue

        // Enqueue elements
        instance.enqueue(5);
        instance.enqueue(10);
        instance.enqueue(15);

        // Dequeue elements
        int dequeuedValue = instance.dequeue();
        
        // Test if elements are dequeued correctly
        assertEquals(5, dequeuedValue); // Assuming elements are dequeued in FIFO order
        assertEquals(2, instance.size()); // Assuming size() returns the number of elements in the queue

        // Dequeue from an empty queue should throw NoSuchElementException
        MyQueue<Integer> emptyQueue = new MyQueue<>(5); // Creating an empty queue
        try {
            emptyQueue.dequeue(); // Attempting to dequeue from an empty queue
            fail("Expected NoSuchElementException was not thrown");
        } catch (NoSuchElementException e) {
            // NoSuchElementException thrown as expected
            assertTrue(true);
        }
    }

    /**
     * Test of peek method, of class MyQueue.
     */
    @Test
    public void testPeek() {
        MyQueue<Integer> instance = new MyQueue<>(5); // Assuming Integer type for MyQueue

        // Enqueue elements
        instance.enqueue(5);
        instance.enqueue(10);
        instance.enqueue(15);

        // Peek at the front element
        int frontElement = instance.peek();
        
        // Test if the peeked value is correct
        assertEquals(5, frontElement); // Assuming the first element enqueued is 5

        // Peeking from an empty queue should throw NoSuchElementException
        MyQueue<Integer> emptyQueue = new MyQueue<>(5); // Creating an empty queue
        try {
            emptyQueue.peek(); // Attempting to peek from an empty queue
            fail("Expected NoSuchElementException was not thrown");
        } catch (NoSuchElementException e) {
            // NoSuchElementException thrown as expected
            assertTrue(true);
        }
    }

    /**
     * Test of size method, of class MyQueue.
     */
    @Test
    public void testSize() {
        MyQueue<Integer> instance = new MyQueue<>(5); // Assuming Integer type for MyQueue

        // Initially, the queue should be empty
        assertEquals(0, instance.size());

        // Enqueue some elements
        instance.enqueue(5);
        instance.enqueue(10);
        instance.enqueue(15);

        // Test if the size of the queue matches the number of elements enqueued
        assertEquals(3, instance.size());

        // Dequeue elements and check size changes accordingly
        instance.dequeue();
        assertEquals(2, instance.size());

        instance.dequeue();
        assertEquals(1, instance.size());

        instance.dequeue();
        assertEquals(0, instance.size());

        // Test size of an empty queue
        MyQueue<Integer> emptyQueue = new MyQueue<>(5); // Creating an empty queue
        assertEquals(0, emptyQueue.size());
    }

    /**
     * Test of isEmpty method, of class MyQueue.
     */
    @Test
    public void testIsEmpty() {
        MyQueue<Integer> instance = new MyQueue<>(5); // Assuming Integer type for MyQueue

        // Initially, the queue should be empty
        assertTrue(instance.isEmpty());

        // Enqueue an element
        instance.enqueue(5);

        // The queue should not be empty after enqueueing an element
        assertFalse(instance.isEmpty());

        // Dequeue the element
        instance.dequeue();

        // The queue should be empty after dequeueing the only element
        assertTrue(instance.isEmpty());

        // Test an empty queue
        MyQueue<Integer> emptyQueue = new MyQueue<>(5); // Creating an empty queue
        assertTrue(emptyQueue.isEmpty());
    }

    /**
     * Test of dequeueAll method, of class MyQueue.
     */
    @Test
    public void testDequeueAll() {
        MyQueue<Integer> instance = new MyQueue<>(5); // Assuming Integer type for MyQueue

        // Enqueue elements
        instance.enqueue(5);
        instance.enqueue(10);
        instance.enqueue(15);

        // Before dequeueAll, size should be 3
        assertEquals(3, instance.size());

        // Dequeue all elements
        instance.dequeueAll();

        // After dequeueAll, size should be 0
        assertEquals(0, instance.size());

        // Test dequeueAll on an empty queue
        instance.dequeueAll(); // Should not throw any exception for an empty queue
        assertEquals(0, instance.size()); // Size remains 0 for an empty queue
    }

    /**
     * Test of equals method, of class MyQueue.
     */
    @Test
    public void testEquals() {
        MyQueue<Integer> instance1 = new MyQueue<>(5); // Assuming Integer type for MyQueue
        MyQueue<Integer> instance2 = new MyQueue<>(5);

        // Enqueue elements in instance1
        instance1.enqueue(5);
        instance1.enqueue(10);
        instance1.enqueue(15);

        // Enqueue same elements in instance2
        instance2.enqueue(5);
        instance2.enqueue(10);
        instance2.enqueue(15);

        // Check if instance1 is equal to instance2
        assertTrue(instance1.equals(instance2));

        // Create a different instance with different elements
        MyQueue<Integer> instance3 = new MyQueue<>(5);
        instance3.enqueue(20);
        instance3.enqueue(25);
        instance3.enqueue(30);

        // Check if instance1 is not equal to instance3
        assertFalse(instance1.equals(instance3));

        // Check if instance1 is not equal to null
        assertFalse(instance1.equals(null));
    }

    /**
     * Test of toArray method, of class MyQueue.
     */
    @Test
    public void testToArray_0args() {
        MyQueue<Integer> instance = new MyQueue<>(5); // Assuming Integer type for MyQueue

        // Enqueue elements in the queue
        instance.enqueue(5);
        instance.enqueue(10);
        instance.enqueue(15);

        // Convert the queue to an array
        Object[] resultArray = instance.toArray();

        // Validate the array size
        assertEquals(3, resultArray.length);

        // Validate array elements
        assertEquals(5, resultArray[0]);
        assertEquals(10, resultArray[1]);
        assertEquals(15, resultArray[2]);
    }

    /**
     * Test of toArray method, of class MyQueue.
     */
    @Test
    public void testToArray_GenericType() {
        MyQueue<Integer> instance = new MyQueue<>(5); // Assuming Integer type for MyQueue

        // Enqueue elements in the queue
        instance.enqueue(5);
        instance.enqueue(10);
        instance.enqueue(15);

        // Create an array to hold the elements
        Integer[] resultArray = new Integer[5];

        // Convert the queue to an array using the provided array
        Integer[] toArrayResult = instance.toArray(resultArray);



        // Validate the array elements
        assertEquals(Integer.valueOf(5), resultArray[0]);
        assertEquals(Integer.valueOf(10), resultArray[1]);
        assertEquals(Integer.valueOf(15), resultArray[2]);
        assertNull(resultArray[3]); // Remaining indices should be null
        assertNull(resultArray[4]);
    }

    /**
     * Test of isFull method, of class MyQueue.
     */
    @Test
    public void testIsFull() {
        MyQueue<Integer> instance = new MyQueue<>(3); // Assuming Integer type for MyQueue and a capacity of 3

        assertFalse(instance.isFull()); // Initially, the queue should not be full

        // Enqueue elements to fill the queue
        instance.enqueue(5);
        instance.enqueue(10);
        instance.enqueue(15);

        assertTrue(instance.isFull()); // After filling the queue, it should be full
    }

    /**
     * Test of iterator method, of class MyQueue.
     */
    @Test
    public void testIterator() {
        MyQueue<Integer> instance = new MyQueue<>(5); // Assuming Integer type for MyQueue and a capacity of 5
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);

        MyIterator<Integer> iterator = (MyIterator<Integer>) instance.iterator();

        // Test if the iterator has the correct elements in the correct order
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertFalse(iterator.hasNext()); // No more elements in the queue
    }
    
}
