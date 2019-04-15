package 树.对称的二叉树;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
    	return isSymmctrical(pRoot, pRoot);
    }
    
    public boolean isSymmctrical(TreeNode root1, TreeNode root2) {
    	if(root1 == null && root2 == null) {
    		return true;
    	}
    	if(root1 == null || root2 == null) {
    		return false;
    	}
    	
    	if(root1.val != root2.val) {
    		return false;
    	}
    	
    	return isSymmctrical(root1.left, root2.right) && isSymmctrical(root1.right, root2.left);
    }
}
