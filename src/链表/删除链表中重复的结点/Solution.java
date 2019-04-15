package 链表.删除链表中重复的结点;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public ListNode deleteDuplication(ListNode pHead) {
		Queue<ListNode> queue = new LinkedList<ListNode>();
		if(pHead == null || pHead.next == null) {
			return pHead;
		}

		int val = Integer.MAX_VALUE;
		ListNode node = pHead;
		
		while(node != null) {
			if(node.next != null) {
				if(node.val != node.next.val && node.val != val) {
					queue.offer(node);
				}
			}
			else {
				if(node.val != val) {
					queue.offer(node);
				}
			}
			
			val = node.val;
			node  = node.next;
		}
		
		if(!queue.isEmpty()) {
			ListNode node2 = queue.poll();
			node = node2;
			
			while(!queue.isEmpty()) {
				ListNode temp = queue.poll();
				node2.next = temp;
				node2 = temp;
			}
			node2.next = null;

			return node;
		}
		else return null;

	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		Solution s = new Solution();
		ListNode node = s.deleteDuplication(node1);
		
		while(node!= null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		
	}
}
