package 数组.数组中重复的数字;

public class Solution {

	public boolean duplicate(int[] numbers,int length,int[] duplication) {
		if(numbers == null || numbers.length <= 1) {
			return false;
		}
		int times = 0;
		for (int i = 0; i < numbers.length && times == 0; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if(numbers[i] == numbers[j]) {
					++times;
					duplication[0] = numbers[i];
					break;
				}
			}
		}
		return times > 0 ? true : false;

	}
	
	public boolean duplicate_2(int[] numbers,int length,int[] duplication) {
		for (int i = 0; i < length; i++) {
			while(numbers[i] != i) {
				if(numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				}
				
				swap(numbers, i, numbers[i]);
			}
		}
		return false;
	}
	
	public void swap(int[] elem, int i, int j) {
		int temp = elem[i];
		elem[i] = elem[j];
		elem[j] = temp;
	}

	public boolean duplicate_3(int[] numbers,int length,int[] duplication) {
		for ( int i= 0; i < length; i++) {

			int index = numbers[i];

			if (index >= length) {
				index -= length;
			}   

			if (numbers[index] >= length) {
				duplication[0] = index;
				return true;
			}   

			numbers[index] = numbers[index] + length;
		}   
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] num = {2,3,1,0,2,5,3};
		int[] du = new int[1];
		s.duplicate_2(num, num.length, du);
		System.out.println(du[0]);
	}
}
