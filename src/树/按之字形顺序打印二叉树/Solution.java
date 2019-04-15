package 树.按之字形顺序打印二叉树;

import java.util.ArrayList;
import java.util.Stack;


public class Solution {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	
    	int layer = 1;
    	Stack<TreeNode> stack_odd = new Stack<TreeNode>();
    	Stack<TreeNode> stack_even = new Stack<TreeNode>();
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	
    	if(pRoot == null) {
    		return list;
    	}
    	stack_odd.push(pRoot);
    	
    	while(!stack_odd.isEmpty() || !stack_even.isEmpty()) {
    		if(layer % 2 != 0) {
    			ArrayList<Integer> temp = new ArrayList<Integer>();
    			while(!stack_odd.isEmpty()) {
    				TreeNode node = stack_odd.pop();
    				if(node != null) {
    					temp.add(node.val);
    					stack_even.push(node.left);
    					stack_even.push(node.right);
    				}
    			}
				if(!temp.isEmpty()) {
					list.add(temp);
					layer++;
				}
    		}
    		else {
    			ArrayList<Integer> temp = new ArrayList<Integer>();
    			while(!stack_even.isEmpty()) {
    				TreeNode node = stack_even.pop();
    				if(node != null) {
    					temp.add(node.val);
    					stack_odd.push(node.right);
    					stack_odd.push(node.left);
    				}
    			}
    			if(!temp.isEmpty()) {
    				list.add(temp);
    				layer++;
    			}
    		}
    	}
    	
    	return list;
    	
    }
}
