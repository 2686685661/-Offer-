package 链表.从头到尾打印链表;

import java.util.ArrayList;
import java.util.Stack;
public class Solution {

	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		if(listNode == null) {
			return list;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
	
		while(listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}

		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}

		return list;
	}
	
	
	
	public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
		if(listNode != null) {
			printListFromTailToHead_2(listNode.next);
			list.add(listNode.val);
		}

		return list;
	}
	
	
	public ArrayList<Integer> printListFromTailToHead_3(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int temp;
		while(listNode != null) {
			list.add(listNode.val);
			listNode = listNode.next;
		}
		
		for (int i = 0; i < (list.size() / 2); i++) {
			temp = list.get(i);
			int j = list.size() - i - 1;
			list.set(i, list.get(j));
			list.set(j, temp);
		}
		
		return list;
	}
	
	
	

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		
		a.next = b;
		b.next = c;
		c.next = d;
		
		System.out.println(s.printListFromTailToHead_3(a));

	}
}
