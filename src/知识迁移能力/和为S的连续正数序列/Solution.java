package 知识迁移能力.和为S的连续正数序列;

import java.util.ArrayList;
public class Solution {

	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer> > allList = new ArrayList<ArrayList<Integer> >();
		if(sum <= 1) {
			return allList;
		}

		int mid = sum;

		for (int i = 1; i < mid; i++) {
			int pag = i;
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			for (int j = i + 1; j < mid; j++) {
				pag += j;
				if(pag < sum) {
					list.add(j);
				}
				else if(pag > sum) {
					list = null;
					break;
				}
				else {
					list.add(j);
					allList.add(new ArrayList<Integer>(list));
				}
			}
		}

		return allList;
	}

	public ArrayList<ArrayList<Integer> > FindContinuousSequence_2(int sum) {
		ArrayList<ArrayList<Integer> > allList = new ArrayList<ArrayList<Integer> >();
		//两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
		int low = 1, high = 2;
		while(high > low) {
			//由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
			int cur = (high + low) * (high - low + 1) / 2;
			//相等，那么就将窗口范围的所有数添加进结果集
			if(cur == sum) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = low; i <= high; i++) {
					list.add(i);
				}
				allList.add(list);
				low++;
			}
			//如果当前窗口内的值之和小于sum，那么右边窗口右移一下
			else if(cur < sum) {
				high++;
			}
			//如果当前窗口内的值之和大于sum，那么左边窗口右移一下
			else {
				low++;
			}
		}
		return allList;
	}



	public ArrayList<ArrayList<Integer> > FindContinuousSequence_3(int sum) {
		ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
		
		for (int i = (int) Math.sqrt(2 * sum); i >= 2; i--) {
			if((i & 1) == 1 && sum % i == 0 || (sum % i) * 2 == i) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int j = 0, k = (sum / i) - (i - 1) / 2; j < i; j++, k++) {
					list.add(k);
				}
				allList.add(list);
			}
		}
		
		return allList;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.FindContinuousSequence_3(100));
	}
}
