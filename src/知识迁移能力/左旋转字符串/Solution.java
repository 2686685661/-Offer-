package 知识迁移能力.左旋转字符串;

public class Solution {
	
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n > str.length()) {
        	return str;
        }
        n %= str.length();
        char[] chars = str.toCharArray();
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
			swap(chars, i, j);
		}
        
        for (int i = n, j = chars.length - 1; i < j; ++i, --j) {
			swap(chars, i, j);
		}
        
        for (int i = 0, j = chars.length - 1; i < j; ++i, --j) {
			swap(chars, i, j);
		}
        return String.valueOf(chars);
        
    }
    
    public void swap(char[] elem, int i, int j) {
    	char temp = elem[i];
    	elem[i] = elem[j];
    	elem[j] = temp;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.LeftRotateString("abcdef", 3));
	}
}
