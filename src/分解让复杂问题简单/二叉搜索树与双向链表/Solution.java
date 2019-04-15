package 分解让复杂问题简单.二叉搜索树与双向链表;

public class Solution {
	TreeNode head = null;
	TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
    	ConvertSub(pRootOfTree);
    	return realHead;
    }
    
    public void ConvertSub(TreeNode pRootOfTree) {
    	if(pRootOfTree == null) {
    		return;
    	}
    	
    	ConvertSub(pRootOfTree.left);
    	if(head == null) {     //遍历到树的最左叶子节点，也就是双向链表的头结点
    		head = pRootOfTree;      //缓存当前节点
    		realHead = pRootOfTree;   //指向双向链表的头结点
    	}
    	else {
    		head.right = pRootOfTree;  //head为是当前节点在双向链表中的前一个节点
    		pRootOfTree.left = head;
    		head = pRootOfTree;
    	}
    	
    	ConvertSub(pRootOfTree.right);
    }
}
