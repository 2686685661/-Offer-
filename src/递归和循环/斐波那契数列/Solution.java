package 递归和循环.斐波那契数列;

public class Solution {
	
    public int Fibonacci(int n) {
    	if(n == 0) {
    		return 0;
    	}
    	else if(n == 1) {
    		return 1;
    	}
    	
    	return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    
    public int Fibonacci_2(int n) {
    	if(n == 0) {
    		return 0;
    	}
    	else if(n == 1) {
    		return 1;
    	}
    	int[] arr = new int[n + 1];
    	arr[0] = 0;
    	arr[1] = 1;
    	for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
    	return arr[n];
    }
    
    public int Fibonacci_3(int n) {
    	if(n == 0) {
    		return 0;
    	}
    	else if(n == 1) {
    		return 1;
    	}
    	int one = 0;
    	int two = 1;
    	int temp = 0;
    	for (int i = 2; i <= n; i++) {
    		temp = two + one;
			one = two;
			two = temp;
		}
    	return temp;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	
		System.out.println(s.Fibonacci_3(5));
	}
}
