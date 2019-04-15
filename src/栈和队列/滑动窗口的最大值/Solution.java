package 栈和队列.滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> maxInWindows(int [] num, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(num == null || num.length == 0 || size < 1 || size > num.length) {
			return list;
		}
		if(size >= num.length) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < num.length; i++) {
				if(num[i] > max) {
					max = num[i];
				}
			}
			list.add(max);

		}
		else {
			int i = 0, j = size - 1, max = Integer.MIN_VALUE;

			while(j < num.length) {
				for (int j2 = i; j2 <= j; j2++) {
					if(num[j2] > max) {
						max = num[j2];
					}
				}
				list.add(max);
				max = Integer.MIN_VALUE;
				i++;
				j++;
			}
		}

		return list; 
	}


	public ArrayList<Integer> maxInWindows_2(int [] num, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		if(size == 0) return res;
		int begin; 
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < num.length; i++){
			begin = i - size + 1;
			if(q.isEmpty())
				q.add(i);
			else if(begin > q.peekFirst())
				q.pollFirst();

			while((!q.isEmpty()) && num[q.peekLast()] <= num[i]) //从后面依次弹出队列中比当前num[i]值小的元素，同时也能保证队列首元素为当前窗口最大值下标
				q.pollLast();
			q.add(i);   //把每次滑动的i下标加入队列
			if(begin >= 0)
				res.add(num[q.peekFirst()]);
			
//			System.out.print("i=" + i + ", ");
//			System.out.print("begin=" + begin + ", ");
//			System.out.print("q=" + q.toString() + ", ");
//			System.out.print("res=" + res.toString() + ", ");
//			System.out.println();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] elem = {2,3,4,2,6,2,5,1};
		Solution s = new Solution();

		ArrayList<Integer> list = s.maxInWindows_2(elem, 8);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}
	}
}
