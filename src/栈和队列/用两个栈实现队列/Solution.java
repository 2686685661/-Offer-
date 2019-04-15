package 栈和队列.用两个栈实现队列;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	int temp = stack2.pop();
    	
    	while(!stack2.isEmpty()) {
    		stack1.push(stack2.pop());
    	}
    	return temp;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	s.push(1);
    	s.push(2);
    	s.push(3);
    	System.out.println(s.pop());
    	s.push(4);
    	System.out.println(s.pop());
	}
}
