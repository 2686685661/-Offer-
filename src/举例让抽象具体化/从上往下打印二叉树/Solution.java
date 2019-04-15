package 举例让抽象具体化.从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(root == null) {
    		return list;
    	}
    	
    	TreeNode temp;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {
    		temp = queue.poll();
    		list.add(temp.val);
    		
    		if(temp.left != null) {
    			queue.add(temp.left);
    		}
    		if(temp.right != null) {
    			queue.add(temp.right);
    		}
    		
    	}
    	
    	return list;
    }
}
