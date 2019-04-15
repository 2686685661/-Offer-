package 举例让抽象具体化.二叉树中和为某一值的路径;

import java.util.ArrayList;

public class Solution {

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

		ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>(); //保存所有符合条件的路径
		ArrayList<Integer> list = new ArrayList<Integer>(); //当前路径
		return SeekPath(listAll, list, root, target);
	}

	public ArrayList<ArrayList<Integer>> SeekPath(ArrayList<ArrayList<Integer>> listAll, ArrayList<Integer> list, TreeNode root,int target) {
		if(root == null) return listAll;
		list.add(root.val);
		target -= root.val;
		if(target == 0 && root.left == null && root.right == null) { //当前路径和是指定值且当前节点是叶子节点
			listAll.add(new ArrayList<Integer>(list));
		}
		SeekPath(listAll, list, root.left, target);
		SeekPath(listAll, list, root.right, target);
		list.remove(list.size() - 1);  //递归回到父节点时需要在路径中删除上一个节点信息
		return listAll;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(12);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;

		Solution s = new Solution();
		System.out.println(s.FindPath(t1, 22));
	}

}
