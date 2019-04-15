package 位运算.二进制中1的个数;

public class Solution {
	
	
    public int NumberOf1(int n) {
    	int k = 0;
    	if(n == 0) {
    		return 0;
    	}
    	else if(n > 0) {
    		
    		String str = Integer.toBinaryString(n);
    		for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '1') {
					k++;
				}
			}
    		
    		return k;
    	}
    	else {
    		StringBuffer str = new StringBuffer();
    		
    		for (int i = 0; i < 32; i++) {
				int t = (n & 0x80000000 >>> i) >>> (31 - i);
				str.append(t);
			}
    		
    		for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '1') {
					k++;
				}
			}
    		return k;
    	}
    }
    
    
    public static void printComplementCode(int a)
    {
        for (int i = 0; i < 32; i++)
        {
            // 0x80000000 是一个首位为1，其余位数为0的整数
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
//    	Solution s = new Solution();
    	printComplementCode(-7);
	}
}
