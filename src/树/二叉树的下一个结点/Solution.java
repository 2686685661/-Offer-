package 树.二叉树的下一个结点;

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        
    	if(pNode == null) {
    		return null;
    	}
    	
    	TreeLinkNode node = null;
    	
    	if(pNode.right != null) {
    		TreeLinkNode nodeRight = pNode.right;
    		while(nodeRight.left != null) {
    			nodeRight = nodeRight.left;
    		}
    		
    		node = nodeRight;
    	}
    	else if(pNode.next != null) {
    		TreeLinkNode current = pNode;
    		TreeLinkNode parent = pNode.next;
    		
    		while(parent != null && current == parent.right) {
    			current = parent;
    			parent = parent.next;
    		}
    		
    		node = parent;
    	}
    	
    	return node;
    	
    }
}
