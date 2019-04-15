package 树.重建二叉树;

public class Solution {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null) {
        	return null;
        }
        TreeNode tree = reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return tree;
    }
    
    
    //核心递归函数
    public TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {

    	TreeNode tree = new TreeNode(pre[preStart]);
    	if(preStart == preEnd && inStart == inEnd) {
    		return tree;
    	}
    	
    	int rootSubscript = 0;
    	while(rootSubscript < inEnd) {
    		if(pre[preStart] == in[rootSubscript]) {
    			break;
    		}
    		rootSubscript++;
    	}
    	
    	int leftTreeLength = rootSubscript - inStart;
    	int rightTreeLength = inEnd - rootSubscript;
    	
    	if(leftTreeLength > 0) {
    		tree.left = reConstructBinaryTreeCore(pre, in, preStart + 1, preStart + leftTreeLength, inStart, rootSubscript - 1);
    	}
    	
    	if(rightTreeLength > 0) {
    		tree.right = reConstructBinaryTreeCore(pre, in, preStart + leftTreeLength + 1, preEnd, rootSubscript + 1,inEnd);
    	}
    	
    	return tree;
    	 
    }
    
    
    //树的先序遍历，用来检测代码
    public void test(TreeNode tree) {
    	if(tree != null) {
    		System.out.print(tree.val + ", ");
    		test(tree.left);
    		test(tree.right);
    	}
    }
    
    public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		Solution s = new Solution();
		TreeNode tree = s.reConstructBinaryTree(pre, in);
		s.test(tree);
	}
}