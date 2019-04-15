package 抽象建模能力.孩子们的游戏_圆圈中最后剩下的数;

public class Solution {
	
    public int LastRemaining_Solution(int n, int m) {
        
    	if(n < 1 || m < 1) {
    		return -1;
    	}
    	int[] arr = new int[n];
    	int i = -1, step = 0, count = n;
    	
    	while(count > 0) {
    		i++;
    		if(i >= n) i = 0;
    		if(arr[i] == -1) continue;
    		step++;
    		if(step == m) {
    			arr[i] = -1;
    			step = 0;
    			count--;
    		}
    	}
    	return i;
    }
    
    public int LastRemaining_Solution_2(int n, int m) {
    	if(n < 1 || m < 1) {
    		return -1;
    	}
    	
    	int last = 0;
    	for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
    	return last;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.LastRemaining_Solution_2(5, 3));
	}
}
