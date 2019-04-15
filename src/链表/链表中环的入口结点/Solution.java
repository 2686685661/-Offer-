package 链表.链表中环的入口结点;

public class Solution {
	
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) {
        	return null;
        }
        
        ListNode meet = MeetNode(pHead);
        
        if(meet == null ) {
        	return null;
        }
        
        int nodeInLoop = 1;
        ListNode pNode = meet, pNode2 = pHead;
        while(pNode.next != meet) {
        	pNode = pNode.next;
        	++nodeInLoop;
        }
        
        pNode = pHead;
        
        for (int i = 0; i < nodeInLoop; i++) {
			pNode = pNode.next;
		}
        
        while(pNode != pNode2) {
        	pNode = pNode.next;
        	pNode2 = pNode2.next;
        }
        return pNode;
        
    }
    
    public ListNode MeetNode(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	
    	ListNode slow = head.next;
    	if(slow == null) {
    		return null;
    	}
    	
    	ListNode fast = slow.next;
    	
    	while(fast != null && slow != null) {
    		if(fast == slow) {
    			return slow;
    		}
    		slow = slow.next;
    		fast = fast.next;
    		
    		if(fast != null) {
    			fast = fast.next;
    		}
    	}
    	
    	return null;
    }
    
}
