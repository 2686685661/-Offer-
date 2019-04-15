package 时间效率.把数组排成最小的数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {


	/*
	 * 解题思路：
	 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
	 * 排序规则如下：
	 * 若ab > ba 则 a > b，
	 * 若ab < ba 则 a < b，
	 * 若ab = ba 则 a = b；
	 * 解释说明：
	 * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
	 */
	public String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length <= 0) {
			return "";
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}

		Collections.sort(list, new Comparator<Integer>() {

			public int compare(Integer str1, Integer str2) {
				String s1 = str1 + "" + str2;
				String s2 = str2 + "" + str1;
				return s1.compareTo(s2);
			}
		});

		String str = "";

		for (Integer i : list) {
			str += i;
		}
		return str;

	}


	public static void main(String args[]) {
		Solution s = new Solution();
		int[] elem = {3,32,321};
		System.out.println(s.PrintMinNumber(elem));

		//        String str1 = "323";
		//        String str2 = "332";
		//        int result = str1.compareTo( str2 );
		//        System.out.println(result);

	}

}
