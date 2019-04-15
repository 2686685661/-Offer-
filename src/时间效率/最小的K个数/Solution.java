package 时间效率.最小的K个数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	
	/**
	 * 利用快排思想，时间复杂度O(n)
	 * @param input
	 * @param k
	 * @return
	 */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input == null || input.length == 0 || k > input.length || k <= 0) {
    		return list;
    	}
    	
    	int start = 0;
    	int end = input.length - 1;
    	int index = Partition(input, start, end);
    	
    	while(index != k - 1) {
    		if(index < (k - 1)) {
    			start = index + 1;
    			index = Partition(input, start, end);
    		}
    		else {
    			end = index - 1;
    			index = Partition(input, start, end);
    		}
    	}
    	for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}
    	
    	return list;
    	
    }
    
    public int Partition(int[] elem, int low, int high) {
    	int pivotkey = elem[low];
    	while(low < high) {
    		while((low < high) && elem[high] > pivotkey) {
    			high--;
    		}
    		swap(elem, low, high);
    		
    		while((low < high) && elem[low] <= pivotkey) {
    			low++;
    		}
    		swap(elem, low, high);
     	}
    	return low;
    }
    
    public void swap(int[] elem, int i, int j) {
    	int temp = elem[i];
    	elem[i] = elem[j];
    	elem[j] = temp;
    }
    
    
    public ArrayList<Integer> GetLeastNumbers_Solution_2(int [] input, int k) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(input == null || input.length == 0 || k > input.length || k <= 0) {
    		return list;
    	}
    	
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
    		public int compare(Integer i1, Integer i2) {
    			return i2.compareTo(i1);
    		}
    	});
    	
    	for (int i = 0; i < input.length; i++) {
			if(maxHeap.size() < k) {
				maxHeap.add(input[i]);
			}
			else {
				if(maxHeap.peek() <= input[i]) {
					continue;
				}
				else {
					maxHeap.poll();
					maxHeap.add(input[i]);
				}
			}
		}
    	for (Integer integer : maxHeap) {
			list.add(integer);
		}
    	
    	return list;
    	
    }
    
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] elem = {4,5,1,6,2,7,3,8};
    	System.out.println(s.GetLeastNumbers_Solution_2(elem, 4));
	}
    
    
}
