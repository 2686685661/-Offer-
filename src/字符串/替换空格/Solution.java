package 字符串.替换空格;


/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author shanlei
 *
 */
public class Solution {
	public String replaceSpace(StringBuffer str) {
		String result = str.toString();
		if(result.contains(" ")){
			while(str.indexOf(" ") != str.lastIndexOf(" ")){
				int index = str.indexOf(" ");
				str.replace(index,index+1,"%20");
			}
			int index = str.indexOf(" ");
			str.replace(index,index+1,"%20");
			result = str.toString();
			return result;

		}else{
			return result;
		}
	}
	
	public String replaceSpace_2(StringBuffer str) {
		int index = str.indexOf(" ");
		while(index != -1) {
			str.replace(index, index + 1, "%20");
			index = str.indexOf(" ");
		}
		String result = str.toString();
		return result;
	}
	
	public String replaceSpace_3(StringBuffer str) {
		int len = str.length();
		int space_len = 0;
		for (int i = 0; i < len; i++) {
			if(str.charAt(i) == ' ') {
				space_len++;
			}
		}
		int arr_len = len + 2 * space_len;  //(len - space_len) + 3 * space_len
		char[] str_arr = new char[arr_len];
		int index = arr_len - 1;
		while(len > 0) {
			if(str.charAt(len - 1) != ' ') {
				str_arr[index--] = str.charAt(len - 1);
			}
			else {
				str_arr[index--] = '0';
				str_arr[index--] = '2';
				str_arr[index--] = '%';
			}
			len--;
		}
		
		return String.valueOf(str_arr);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		StringBuffer str = new StringBuffer("We are test ");
		System.out.println(s.replaceSpace_3(str));
	}
}

