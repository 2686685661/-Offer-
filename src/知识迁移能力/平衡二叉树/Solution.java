package 知识迁移能力.平衡二叉树;

public class Solution {

	/**
	 * 方法一
	 * @param root
	 * @return
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null) {
			return true;
		}
		return Math.abs(depth(root.left) - depth(root.right)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}

	private int depth(TreeNode node) {
		if(node == null) return 0;

		int m = depth(node.left);
		int n = depth(node.right);

		return m > n ? m + 1 : n + 1;
	}
	
	
	/**
	 * 方法二
	 * @param root
	 * @return
	 */
	public boolean isAVL = true;
	
	public boolean IsBalanced_Solution_2(TreeNode root) {
		getdepth(root);
		return isAVL;
	}
	
	private int getdepth(TreeNode node) {
		if(!isAVL) return 0;
		if(node == null) return 0;
		int m = getdepth(node.left);
		int n = getdepth(node.right);
		if(Math.abs(m - n) > 1) {
			isAVL=false;
		}

		return m > n ? m + 1 : n + 1;
	}
}
