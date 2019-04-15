package 举例让抽象具体化.包含min函数的栈;

import java.util.Stack;

public class Solution {

	Stack dataStack = new Stack();
	Stack minStack = new Stack();
	
    public void push(int node) {
        dataStack.push(node);
        
        if(minStack.empty() || node < (int)minStack.peek()) {
        	minStack.push(node);
        }
        else {
        	minStack.push(top());
        }
    }
    
    public void pop() {
        if(!dataStack.isEmpty() && !minStack.isEmpty()) {
        	dataStack.pop();
        	minStack.pop();
        }
    }
    
    public int top() {
        return (int) minStack.peek();
    }
    
    public int min() {
    	
    	if(!dataStack.isEmpty() && !minStack.isEmpty()) {
    		return top();
    	}else {
    		return (Integer) null;
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	s.push(3);
    	System.out.println(s.min());
    	s.push(4);
    	System.out.println(s.min());
    	s.push(2);
    	System.out.println(s.min());
    	s.push(1);
    	System.out.println(s.min());
    	s.pop();
    	System.out.println(s.min());
    	s.pop();
    	System.out.println(s.min());
    	s.push(0);
    	System.out.println(s.min());
	}
}
