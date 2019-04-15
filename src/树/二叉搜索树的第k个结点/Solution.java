package 树.二叉搜索树的第k个结点;

import java.util.ArrayList;

public class Solution {

	
	TreeNode KthNode(TreeNode pRoot, int k) {
		
		if(pRoot == null || k <= 0) {
			return null;
		}
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		MiddleList(pRoot, list);
		
		if(k > list.size()) {
			return null;
		}
		return list.get(k - 1);
		
	}
	
	public void MiddleList(TreeNode node, ArrayList<TreeNode> list) {
		if(node != null) {
			MiddleList(node.left, list);
			list.add(node);
			MiddleList(node.right, list);
		}
	}
	
	int index = 0;
	TreeNode KthNode_2(TreeNode pRoot, int k) {
		if(pRoot != null) {
			TreeNode node = KthNode_2(pRoot.left, k);
			
			if(node != null) {
				return node;
			}
			index++;
			if(index == k) {
				return pRoot;
			}
			node = KthNode_2(pRoot.right, k);
			if(node != null) {
				return node;
			}
		}
		return null;
		
		
	}
}
