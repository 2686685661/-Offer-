package 时间空间效率的平衡.第一个只出现一次的字符位置;

import java.util.HashMap;

public class Solution {

	public int FirstNotRepeatingChar(String str) {
		if(str == null || str.length() == 0) {
			return -1;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			if(!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			}
			else {
				int times = map.get(str.charAt(i));
				map.put(str.charAt(i), ++times);
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if(map.get(str.charAt(i)) == 1) {
				return i;
			}
		}

		return -1;
	}


	public int FirstNotRepeatingChar_2(String str) {
		char[] c = str.toCharArray();
		int[] a = new int['z' + 1];
		for (char d : c)
			a[(int) d]++;
		for (int i = 0; i < c.length; i++)
			if (a[(int) c[i]] == 1)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		Solution s =new Solution();
		System.out.println(s.FirstNotRepeatingChar_2("aabbc"));
	}
}
