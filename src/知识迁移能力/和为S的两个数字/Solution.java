package 知识迁移能力.和为S的两个数字;

import java.util.ArrayList;

public class Solution {

	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list  = new ArrayList<Integer>();
		if(array == null || array.length <= 1) {
			return list;
		}
		int low = 0, high = array.length - 1;
		while(high > low) {
			if(array[low] + array[high] == sum) {
				list.add(0, array[low]);
				list.add(1, array[high]);
				break;
			}
			else if(array[low] + array[high] > sum) {
				high--;
			}
			else {
				low++;
			}
		}
		
		return list;

	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] elem = {1, 2, 3, 4, 5, 6, 7 ,8, 9, 10};
		System.out.println("ss");
		System.out.println(s.FindNumbersWithSum(elem, 8));
	}
}
