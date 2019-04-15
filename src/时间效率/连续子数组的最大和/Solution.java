package 时间效率.连续子数组的最大和;

public class Solution {
	
    public int FindGreatestSumOfSubArray(int[] array) {
        
    	if(array == null || array.length == 0) {
    		return 0;
    	}
    	
    	if(array.length == 1) {
    		return array[0];
    	}
    	int max = 0;
    	int temp = -65535;
    	for (int i = 0; i < array.length; i++) {
    		max = array[i];
			for (int j = i; j < array.length; j++) {
				if(j != i) {
				max += array[j];
				}
				if(temp <= max) {
					temp = max;
				}
				else {
					continue;
				}
			}
		}
    	
    	return temp;
    }
    
    
    public int FindGreatestSumOfSubArray_2(int[] array) {
    	if(array == null || array.length == 0) {
    		return 0;
    	}
    	
    	if(array.length == 1) {
    		return array[0];
    	}
    	
    	int total = array[0];
    	int maxSum = array[0];
    	
    	for (int i = 1; i < array.length; i++) {
			if(total >= 0) {
				total += array[i];
			}
			else {
				total = array[i];
			}
			
			if(total > maxSum) {
				maxSum = total;
			}
		}
    	return maxSum;
    }
    
    public int FindGreatestSumOfSubArray_3(int[] array) {
    	if(array == null || array.length == 0) {
    		return 0;
    	}
    	
    	if(array.length == 1) {
    		return array[0];
    	}
    	
    	int maxSum = array[0];
    	int total = array[0];
    	
    	for (int i = 1; i < array.length; i++) {
    		maxSum = Math.max(maxSum + array[i], array[i]);
    		total = Math.max(maxSum, total);
		}
    	return total;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] elem = {6,-3,-2,7,-15,1,2,2};
    	System.out.println(s.FindGreatestSumOfSubArray_3(elem));

	}
}
