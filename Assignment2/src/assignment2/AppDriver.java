/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment2;

import Utility.MyStack;

/**
 *
 * @author pltdu
 */
public class AppDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test Stack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        System.out.println(stack.peek());
        stack.push(20);
        System.out.println(stack.peek());
    }

}
