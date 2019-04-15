package 发散思维能力.求n的阶乘;

/**
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author shanlei
 *
 */
public class Solution {
    public int Sum_Solution(int n) {
        return n * (n + 1) / 2;
    }
    
    public int Sum_Solution_2(int n) {
    	int sum = n;
    	boolean ans = (n > 0) && ((sum += Sum_Solution(n-1))>0);
    	return sum;
    }
    
    public int Sum_Solution_3(int n) {
    	return (int)(Math.pow(n, 2) + n) >> 1;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.Sum_Solution_3(4));
	}
}
