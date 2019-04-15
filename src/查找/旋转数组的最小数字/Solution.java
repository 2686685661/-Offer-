package 查找.旋转数组的最小数字;

import java.util.ArrayList;
public class Solution {
	
    public int minNumberInRotateArray(int [] array) {
    	if(array.length > 0) {
    		int temp = array[0];
    		for (int i = 1; i < array.length; i++) {
				if(array[i] < temp) {
					temp = array[i];
				}
			}
    		return temp;
    	}
    	else return 0;
    }
    
    
    public int minNumberInRotateArray_2(int [] array) {
    	if(array.length > 0) {
    		int left = 0;
    		int right = array.length - 1;
    		int mid = -1;
    		while(array[left] >= array[right]) {
    			if(right - left == 1) {
    				mid = right;
    				break;
    			}
    			mid = left + (right - left) / 2;
    			
    			if(array[mid] >= array[left]) 
    				left = mid;
    			if(array[mid] <= array[right])
    				right = mid;
    		}
    		return array[mid];
    	}
    	else return 0;
    }
    
    public static void main(String[] args) {
		int[] a = {3,4,5,1,2};
		Solution s = new Solution();
		System.out.println(s.minNumberInRotateArray_2(a));
	}
}