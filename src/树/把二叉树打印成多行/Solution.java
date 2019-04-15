package 树.把二叉树打印成多行;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        
    	
    	ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >();
    	if(pRoot == null) {
    		return list;
    	}
    	
    	int start = 0, end = 1;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	ArrayList<Integer> layerList = new ArrayList<Integer>();
    	queue.add(pRoot);
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		layerList.add(node.val);
    		start++;
    		
    		if(node.left!= null) {
    			queue.add(node.left);
    		}
    		if(node.right != null) {
    			queue.add(node.right);
    		}
    		
    		if(start == end) {
    			end = queue.size();
    			start = 0;
    			list.add(layerList);
    			layerList = new ArrayList<Integer>();
    		}
    	}
    	
    	return list;
    }
    
}
