package 代码的完整性.调整数组顺序使奇数位于偶数前面;

import java.util.ArrayList;

public class Solution {
	
	
	/**
	 * 	 * @param array
	 */
    public void reOrderArray(int [] array) {
        ArrayList list_odd = new ArrayList();
        ArrayList list_even = new ArrayList();
        
        for (int i = 0; i < array.length; i++) {
			if(array[i] % 2 != 0) {
				list_odd.add(array[i]);
			}
			else {
				list_even.add(array[i]);
			}
		}
        for (int i = 0; i < list_odd.size(); i++) {
			array[i] = (int) list_odd.get(i);
		}
        
        for (int i = list_odd.size(), j = 0; i < array.length; i++, j++) {
        	array[i] = (int) list_even.get(j);
		}
    }
    
    public void reOrderArray_2(int [] array) {
    	int temp = 0;
    	for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if((array[j] % 2 != 0) && (array[j - 1] % 2 == 0)) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] arr = {2, 1, 4, 3};
    	s.reOrderArray_2(arr);
    	
    	for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
    	
	}
}
