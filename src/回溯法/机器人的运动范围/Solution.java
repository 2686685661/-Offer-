package 回溯法.机器人的运动范围;

public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
    	int[] flag = new int[rows * cols];
    	return helper(threshold, rows, cols, 0, 0, flag);
    }
    
    public int helper(int k, int rows, int cols, int i, int j, int[] flag) {
    	
    	if(i < 0 || i >= rows || j < 0 || j >= cols || (getDigit(i) + getDigit(j) > k) || flag[i * cols + j] == 1) {
    		return 0;
    	}
    	
    	flag[i * cols + j] = 1;
    	return helper(k, rows, cols, i - 1, j, flag) 
    	    	+ helper(k, rows, cols, i + 1, j, flag) 
    	    	+ helper(k, rows, cols, i, j - 1, flag) 
    	    	+ helper(k, rows, cols, i, j + 1, flag)
				+ 1;
    }
    
    public int getDigit(int num) {
    	int digit = Integer.toString(num).length();
    	int nums = 0;
    	for (int i = 1, j = 0; j < digit; i *= 10, j++) {
    		nums += ((num / i) % 10); 
		}
    	
    	return nums;
    }

}
