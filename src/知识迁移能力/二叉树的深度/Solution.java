package 知识迁移能力.二叉树的深度;

public class Solution {
	
    public int TreeDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	if(root.left == null && root.right == null) {
    		return 1;
    	}
    	
        return depth(root);
    }
    
    private int depth(TreeNode node) {
    	if(node == null) return 0;
    	int m = depth(node.left);
    	int n = depth(node.right);
    	return m > n ? m + 1 : n + 1;
    }
}
