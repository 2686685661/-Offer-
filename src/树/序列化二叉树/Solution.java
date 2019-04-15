package 树.序列化二叉树;

public class Solution {
	String Serialize(TreeNode root) {
		StringBuilder builder = new StringBuilder();
		pre(root, builder);
		return builder.toString();
	}
	
	
	public void pre(TreeNode node, StringBuilder builder) {
		if(node == null) {
			builder.append("#!");
		}
		else {
			builder.append(node.val + "!");
			pre(node.left, builder);
			pre(node.right, builder);
		}
	}
	int index = -1;
	TreeNode Deserialize(String str) {
		String[] arr = str.split("!");
		TreeNode node = null;
		index++;
		if(!arr[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(arr[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
			
		}
		return node;

	}
}
