package 时间空间效率的平衡.两个链表的第一个公共结点;

import java.util.Stack;

public class Solution {
	
	
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	
    	if(pHead1 == null || pHead2 == null) {
    		return null;
    	}
    	Stack<ListNode> pStack1 = new Stack<ListNode>();
    	Stack<ListNode> pStack2 = new Stack<ListNode>();
    	while(pHead1 != null) {
    		pStack1.add(pHead1);
    		pHead1 = pHead1.next;
    	}
    	while(pHead2 != null) {
    		pStack2.add(pHead2);
    		pHead2 = pHead2.next;
    	}
    	ListNode temp = null;
    	while(!pStack1.isEmpty() && !pStack2.isEmpty()) {
    		ListNode pH1 = pStack1.pop();
    		ListNode pH2 = pStack2.pop();
    		if(pH1.val == pH2.val) {
    			temp = pH1;		
    		}
    		else {
    			break;
    		}
    	}
    	return temp;

    }
    
    public ListNode FindFirstCommonNode_2(ListNode pHead1, ListNode pHead2) {
    	if(pHead1 == null || pHead2 == null) {
    		return null;
    	}
    	
    	int pHead1Length = getListLength(pHead1);
    	int pHead2Length = getListLength(pHead2);
    	
    	int gap = pHead1Length - pHead2Length;
    	ListNode tempList1 = pHead1;
    	ListNode tempList2 = pHead2;
    	
    	if(pHead2Length > pHead1Length) {
    		tempList1 = pHead2;
    		tempList2 = pHead1;
    		gap = pHead2Length - pHead1Length;
    	}
    	
    	for (int i = 0; i < gap; i++) {
    		tempList1 = tempList1.next;
		}
    	
    	while((tempList1 != null) && (tempList2 != null) && (tempList1.val != tempList2.val)) {
    		tempList1 = tempList1.next;
    		tempList2 = tempList2.next;
    	}
    	
    	return tempList1;

    }
    
    public int getListLength(ListNode list) {
    	int number = 0;
    	while(list != null) {
    		++number;
    		list = list.next;
    	}
    	return number;
    }
    
    public ListNode FindFirstCommonNode_3(ListNode pHead1, ListNode pHead2) {
    	if(pHead1 == null || pHead2 == null) {
    		return null;
    	}
    	ListNode temp1 = pHead1;
    	ListNode temp2 = pHead2;
    	while(temp1 != temp2) {
    		temp1 = (temp1 == null ? pHead2 : temp1.next);
    		
    		temp2 = (temp2 == null ? pHead1 : temp2.next);
    		System.out.println(pHead1.val);
    	}
    	
    	return temp1;
    }
    
    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(5);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	
    	ListNode f = new ListNode(3);
    	ListNode g = new ListNode(4);
    	ListNode h = new ListNode(5);
    	
    	f.next = g;
    	g.next = h;
    	
    	Solution s = new Solution();
    	ListNode temp = s.FindFirstCommonNode_3(a, c);
//    	System.out.println(temp.next.val);
    	
	}
    
    
}
