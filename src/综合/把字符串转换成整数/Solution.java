package 综合.把字符串转换成整数;

public class Solution {

	public int StrToInt(String str) {
		if (str.equals("") || str.length() == 0)
			return 0;
		char[] a = str.toCharArray();
		int fuhao = 0;
		if (a[0] == '-')
			fuhao = 1;
		int sum = 0;
		for (int i = fuhao; i < a.length; i++)
		{
			if (a[i] == '+')
				continue;
			if (a[i] < 48 || a[i] > 57)
				return 0;
			//123  可以 是1*10*10+2*10+3
			sum = sum * 10 + a[i] - 48;
		}
		return fuhao == 0 ? sum : sum * -1;
	}



	public static boolean flag;
	public static int StrToInt_2(String str) {
		flag = false;
		//判断输入是否合法
		if (str == null || str.trim().equals("")) {
			flag = true;
			return 0;
		}
		// symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
		int symbol = 0;
		int start = 0;
		char[] chars = str.trim().toCharArray();
		if (chars[0] == '+') {
			start = 1;
		} else if (chars[0] == '-') {
			start = 1;
			symbol = 1;
		}
		int result = 0;
		for (int i = start; i < chars.length; i++) {
			if (chars[i] > '9' || chars[i] < '0') {
				flag = true;
				return 0;
			}
			int sum= result * 10 + (int) (chars[i] - '0');


			if((sum-(int) (chars[i] - '0'))/10!=result){
				flag=true;
				return 0;
			}

			result=result * 10 + (int) (chars[i] - '0');
			/*
			 * 本人认为java热门第一判断是否溢出是错误的，举个反例
			 * 当输入为value=2147483648时，在计算机内部的表示应该是-2147483648
			 * 显然value>Integer.MAX_VALUE是不成立的
			 */
		}
		// 注意：java中-1的n次方不能用：(-1)^n .'^'异或运算
		// 注意，当value=-2147483648时，value=-value
		result = (int) Math.pow(-1, symbol) * result;
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.StrToInt("-2147483648"));
	}
}
