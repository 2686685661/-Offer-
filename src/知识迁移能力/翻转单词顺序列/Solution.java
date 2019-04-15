package 知识迁移能力.翻转单词顺序列;

public class Solution {

	public String ReverseSentence(String str) {
		if(str.trim().equals("")){
			return str;
		}
		String[] a = str.split(" ");
		StringBuffer o = new StringBuffer();
		int i;
		for (i = a.length; i >0;i--){
			o.append(a[i-1]);
			if(i > 1){
				o.append(" ");
			}
		}
		return o.toString();
	}
	
	
	public String ReverseSentence_2(String str) {
		String res = "", tmp = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				res = " " + tmp + res;
				tmp = "";
			}
			else {
				tmp += str.charAt(i);
			}
		}
		
		if(tmp.length() > 0) {
			res = tmp + res;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.ReverseSentence_2(" ") +"a");
	}
}
