package 代码的鲁棒性.反转链表;

public class Solution {

	public ListNode ReverseList_2(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		ListNode pReversedHead = null;
		ListNode current = head;
		ListNode pNext = null;
		ListNode pPrev = null;
		
		while(current != null) {
			pNext = current.next;
			current.next = pPrev;
			
			if(pNext == null) {
				pReversedHead = current;
			}
			pPrev = current;
			current = pNext;
			
		}
		return pReversedHead;
		
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Solution s = new Solution();
		node = s.ReverseList_2(node);

		while(node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}

	}
}
