package 发散思维能力.不用加减乘除做加法;

public class Solution {

	public int Add(int num1,int num2) {
		if (num2 == 0) return num1;
		int sum, carry;
		sum = num1 ^ num2;
		carry = (num1 & num2) << 1;
		return Add(sum, carry);
	}


	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.Add(4, 5));
	}

}
