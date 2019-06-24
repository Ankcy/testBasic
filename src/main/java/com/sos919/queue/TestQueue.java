package com.sos919.queue;

import java.util.Stack;

public class TestQueue {
    Stack<Integer> stack1 = new Stack<Integer>();  
    Stack<Integer> stack2 = new Stack<Integer>();  
  
    public void push(int node) {  
        stack1.push(node);  
    }  
  
    public int pop() {  
        if (stack1.empty() && stack2.empty()) {  
            throw new RuntimeException("Queue is empty!");  
        }  
        if (stack2.empty()) {  
            while (!stack1.empty()) {  
                stack2.push(stack1.pop());  
            }  
        }  
        return stack2.pop();  
    }
    
    public static void main(String[] args) {
        TestQueue tq = new TestQueue();
        for (int i = 0; i < 10; i++) {
            tq.push(i);
        }
        System.out.println(tq.pop());
    }
}
