package 面试思路.二叉树的镜像;

public class Solution {
	
    public void Mirror(TreeNode root) {
    	TreeNode temp = null;
    	
    	if(root == null) {
    		return;
    	}
    	
    	if(root.left == null && root.right == null) {
    		return;
    	}
    	temp = root.right;
    	root.right = root.left;
    	root.left = temp;
    	
    	if(root.left != null) {
    		Mirror(root.left);
    	}
    	
    	if(root.right != null) {
    		Mirror(root.right);
    	}
    }
}
