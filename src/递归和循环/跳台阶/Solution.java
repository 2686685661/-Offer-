package 递归和循环.跳台阶;

public class Solution {

    public int JumpFloor(int target) {

    	if(target <= 2) {
    		return target;
    	}
    	
    	int t1 = 1;
    	int t2 = 2;
    	int temp = 0;
    	for (int i = 3; i <= target; i++) {
			temp = t1 + t2;
			t1 = t2;
			t2 = temp;	
		}
    	
    	return temp;
    	
    }
    
    /**
     * 扩展题目：
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 
     * 对于一节台阶，可以跳一次f(1) = 1
     * 对于两节台阶，它可以跳一次一节或两节，f(2)=f(2-1)+f(2-2)
     * 对于三节台阶跳的方式，他可以跳１节,2节,3节，那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3).因此结论是
		f(3) = f(3-1)+f(3-2)+f(3-3)
		
     * 
     * f(n)时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
     * f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) 
     * 	=> f(0) + f(1) + f(2) + f(3) + ... + f(n-1) == f(n) = 2*f(n-1)	
     * 
     *　推导：
     *　f(n) = f(n-1)+f(n-2)+...+f(1)
     *  f(n-1) = f(n-2)+ f(n-3)...+f(1)
     *  两式相减：
     *  f(n)=2 * f(n - 1)
     * @param target
     * @return
     */
	    public int JumpFloor_2(int target) {
	    	
	    	if(target <= 2) {
	    		return target;
	    	}
	    	return 2 * JumpFloor_2(target - 1);
	    	
	    }
    
    
    public int JumpFloor_2_5(int target) {
    	if(target <= 2) {
    		return target;
    	}
    	int temp = 0;
    	int oldtemp = 2;
    	for (int i = 3; i <= target; i++) {
			temp = oldtemp * 2;
			oldtemp = temp;
		}
    	return temp;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.JumpFloor_2_5(3));
	}
}
