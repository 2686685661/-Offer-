package 知识迁移能力.数字在排序数组中出现的次数;

public class Solution {

	
	/**
	 * 方法一
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int [] array , int k) {
		if(array == null || array.length == 0) {
			return 0;
		}

		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == k) {
				++times;
			}
		}
		
		return times;
	}
	
	
	/**
	 * 方法二
	 */
	public int GetNumberOfK_2(int [] array , int k) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int low = 0, high = array.length - 1, mid = 0, times = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(k < array[mid]) {
				high = mid - 1;
			}
			else if(k > array[mid]) {
				low = mid + 1;
			}
			else {
				times = 1;
				break;
			}
		}
		
		for (low = mid - 1; (low >= 0) && (array[low] == k); low--) {
			times += 1;
		}
		for (low = mid + 1; (low < array.length) && (array[low] == k); low++) {
			times += 1;
		}
		
		return times;
	}
	
	
	/**
	 * 方法三
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK_3(int [] array , int k) {
		if(array == null || array.length == 0) {
			return 0;
		}
		
		int firstK = FetFirstK(array, k, 0, array.length - 1);
		int lastK = FetLastK(array, k, 0, array.length - 1);
		if(firstK != -1 && lastK != -1) {
			return lastK - firstK + 1;
		}
		return 0;

	}
	
	private int FetFirstK(int[] elem, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		if(elem[mid] > k) {
			return FetFirstK(elem, k, start, mid - 1);
		}
		else if(elem[mid] < k) {
			return FetFirstK(elem, k, mid + 1, end);
		}
		else if(mid - 1 >= 0 && elem[mid - 1] == k) {
			return FetFirstK(elem, k, start, mid - 1);
		}
		else {
			return mid;
		}
	}
	
	private int FetLastK(int[] elem, int k, int start, int end) {
		int mid = (start + end) / 2;
		while(start <= end) {
			if(elem[mid] > k) {
				end = mid - 1;
			}
			else if(elem[mid] < k) {
				start = mid + 1;
			}
			else if(mid + 1 <elem.length && elem[mid + 1] == k) {
				start = mid + 1;
			}
			else {
				return mid;
			}
			
			mid = (start + end) / 2;
		}
		
		return -1;
	}
	
	
	/**
	 * 方法四
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK_4(int [] array , int k) {
		if(array == null || array.length == 0) {
			return 0;
		}
		
		return biSearch(array, k + 0.5) - biSearch(array, k - 0.5);
	}
	
	private int biSearch(int[] elem, double num) {
		int start = 0, end = elem.length - 1, mid = (start + end) / 2;
		while(start <= end) {
			if(elem[mid] < num) {
				start = mid + 1;
			}
			else if(elem[mid] > num) {
				end = mid - 1;
			}
			mid = (start + end) / 2;
		}
		return start;
	}
	
	
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] elem = {1,3,3,3,3,4,5};
		System.out.println(s.GetNumberOfK_4(elem, 6));
	}
}
