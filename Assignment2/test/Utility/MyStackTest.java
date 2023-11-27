/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emagt Sean
 */
public class MyStackTest {
    
    private MyStack<String> stack;
    
    public MyStackTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        stack = new MyStack<>();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testPush() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop() {
    	stack.push("A");
        stack.push("B");
        stack.push("C");
    	
    	assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        stack.push("X");
        stack.push("Y");

        assertEquals("Y", stack.peek());
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testClear() {
       stack.push("Apple");
        stack.push("Banana");

        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testIsEmpty() {
        stack.push("One");
        
        stack.pop();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testToArray() {
    	stack.push("X");
        stack.push("Y");
        
        String[] array = new String[2];
        
        assertArrayEquals(new String[]{"X", "Y"}, stack.toArray(array));
    }
    
    @Test
    public void testContains() {
    	stack.push("X");
        stack.push("Y");
        
        assertTrue(stack.contains("X"));
        assertFalse(stack.contains("Z"));
    }
    
    @Test
	public void testSearch() {
    	stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        
        assertEquals(3,stack.search("D"));
        assertEquals(-1,stack.search("Z"));
	}
	
    @Test
	public void testIterator() {
    	stack.push("A");
        stack.push("B");
        stack.push("C");
        
        MyIterator<String> iterator = (MyIterator<String>) stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
	}
	
    @Test
	public void testEquals() {
    	stack.push("A");
        stack.push("B");
        stack.push("C");
        
        MyStack<String> equalStack = new MyStack<>();
        equalStack.push("A");
        equalStack.push("B");
        equalStack.push("C");
        
        MyStack<String> unequalStack = new MyStack<>();
        unequalStack.push("A");
        unequalStack.push("B");
        unequalStack.push("D");
        
        assertTrue(stack.equals(equalStack));
        assertFalse(stack.equals(unequalStack));
	}

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        stack.push("One");

        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }
}