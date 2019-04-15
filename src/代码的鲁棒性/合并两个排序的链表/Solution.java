package 代码的鲁棒性.合并两个排序的链表;

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
    	
    	if(list2 == null) {
    		return list1;
    	}
    	else if(list1 == null) {
    		return list2;
    	}
    	
    	ListNode listAll = null;
    	
    	if(list1.val < list2.val) {
    		listAll = list1;
    		listAll.next = Merge(list1.next, list2);
    	}
    	else {
    		listAll = list2;
    		listAll.next = Merge(list1, list2.next);
    	}

    	return listAll;
    	
    }
    
    
    public ListNode Merge_2(ListNode list1,ListNode list2) {
    	if(list2 == null) {
    		return list1;
    	}
    	else if(list1 == null) {
    		return list2;
    	}
    	
    	ListNode mergeHead = new ListNode(0);
    	ListNode current = mergeHead;
    	
    	while(list1 != null && list2 != null) {
    		if(list1.val < list2.val) {
    			current.next = list1;
    			list1 = list1.next;
    		}
    		else {
    			current.next = list2;
    			list2 = list2.next;
    		}
    		
    		current = current.next;
    	}
    	
    	if(list1 == null) {
    		current.next = 	list2;
    	}
    	
    	if(list2 == null) {
    		current.next = list1;
    	}
    	
    	return mergeHead.next;

    }
    
    
    
}
