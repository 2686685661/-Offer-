package 数组.构建乘积数组;

import java.util.ArrayList;
public class Solution {
	public int[] multiply(int[] A) {
		int[] b = new int[A.length];
		if(A == null || A.length == 0) {
			return b;
		}
		
		for (int i = 0; i < b.length; i++) {
			b[i] = Factorial(A, 0, i - 1) * Factorial(A, i + 1, b.length - 1);
		}
		return b;
	}
	
	public int Factorial(int[] elem, int low, int high) {
		int temp = 1;
		for (int i = low; i <= high; i++) {
			temp *= elem[i];
		}
		return temp;
	}
	
	
	public int[] multiply_2(int[] A) {
		int length = A.length;
		int[] b = new int[length];
		if(length != 0) {
			b[0] = 1;
			for (int i = 1; i < length; i++) {
				b[i] = b[i - 1] * A[i - 1];
			}
			int temp = 1;
			for (int i = length - 2; i >= 0; i--) {
				temp *= A[i + 1];
				b[i] *= temp;
			}
		}
		return b;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = {1, 2, 3, 4};
		int[] b = s.multiply_2(a);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + ",");
		}
	}
}
