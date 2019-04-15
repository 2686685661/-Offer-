package 代码的完整性.数值的整数次方;

/**
 * 题目描述
	给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author shanlei
 *
 */
public class Solution {
	
	public double Power(double base, int exponent) {

		double res=1;
		if(exponent<0) {  
			base=1/base;
			exponent=Math.abs(exponent);
		}
		int flag=1;
		double res1=1;
		while(flag!=0){
			res1*=base;

			if((exponent&flag)!=0) {
				res *= res1;
			}
			flag=flag<<1;
			System.out.println(flag);
		}

		return res;
	}
	
	
	public double Power_2(double base, int exponent) {
		if(exponent == 0) {
			return 1.00000;
		}
		if(base >= -0.000001 && base <= 0.000001) {
			return 0;
		}
		
		double num = 1.0;	
		
		if(exponent > 0) {
			for (int i = 0; i < exponent; i++) {
				num *= base;
			}
		}
		else {
			exponent = -exponent;
			for (int i = 0; i < exponent; i++) {
				num *= base;
			}
			num = 1.0 / num;
		}
		return num;
	}
	

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.Power(3.1,4));
	}
}
