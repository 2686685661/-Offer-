package 抽象建模能力.扑克牌顺子;

import java.util.Arrays;

public class Solution {
	
    public boolean isContinuous(int [] numbers) {
    	if(numbers == null || numbers.length == 0) {
    		return false;
    	}
    	Arrays.sort(numbers);
    	int numberZero = 0, numberGap = 0;
    	
    	for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			++numberZero;
		}
    	
    	int low = numberZero;
    	int high = low + 1;
    	while(high < numbers.length) {
    		if(numbers[low] == numbers[high]) {
    			return false;
    		}
    		
    		numberGap += numbers[high] - numbers[low] - 1;
    		low = high;
    		++high;
    	}
    	System.out.println(numberGap);
    	return (numberGap > numberZero) ? false : true;
	
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] elem = {0, 1, 3, 4, 5};
    	System.out.println(s.isContinuous(elem));
	}
}
