package 代码的鲁棒性.链表中倒数第k个结点;

public class Solution {
	
	
    public ListNode FindKthToTail(ListNode head,int k) {

    	if(head == null || k <= 0) {
    		return null;
    	}
    	int len = 0;
    	ListNode node = head;
    	while(node != null) {
    		++len;
    		node = node.next;
    	}
    	
    	if(len < k) return null;
    	for (int j = 0; j <= len - k && head !=null; j++) {
			if(j == (len - k)) {
				break;
			}
			head = head.next;
		}
    	return head;
    }
    
    public ListNode FindKthToTail_2(ListNode head,int k) {
    	if(head == null || k <= 0) {
    		return null;
    	}
    	
    	ListNode node1 = head, node2 = head;
    	
    	for (int i = 0; i < (k - 1); i++) {
    		if(node1.next != null) {
    			node1 = node1.next;
    		}
    		else return null;
		}
    	
    	while(node1.next != null) {
    		node1 = node1.next;
    		node2 = node2.next;
    	}
    	
    	return node2;
    }
    
}
