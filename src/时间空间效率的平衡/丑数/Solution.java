package 时间空间效率的平衡.丑数;

public class Solution {

    public int GetUglyNumber_Solution(int index) {
    	if(index == 0) {
    		return 0;    		
    	}
    	
    	int uglyFound = 0;
    	int number = 0;

    	while(uglyFound < index) {
    		++number;
    		
    		if(JudgeUgly(number)) {
    			++uglyFound;
    		}
    	}
    	return number;
    }
    
    public boolean JudgeUgly(int i) {
    	while(i % 2 == 0) 
    		i = i / 2;
    	while(i % 3 == 0)
    		i = i / 3;
    	while(i % 5 == 0)
    		i = i / 5;
    	return (i == 1) ? true : false;
    }
    
    public int GetUglyNumber_Solution_2(int index) {
    	if(index < 7) return index;
    	int[] res = new int[index];
    	res[0] = 1;
    	int t2 = 0, t3 = 0, t5 = 0, i;
    	for (i = 1; i < index; i++) {
			res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
			if(res[i] == res[t2] * 2) t2++;
			if(res[i] == res[t3] * 3) t3++;
			if(res[i] == res[t5] * 5) t5++;
		}
    	return res[index - 1];
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
		System.out.println(s.GetUglyNumber_Solution_2(4));
	}
    
    
    
}
