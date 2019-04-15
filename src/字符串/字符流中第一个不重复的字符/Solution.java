package 字符串.字符流中第一个不重复的字符;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	
	public HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	ArrayList list = new ArrayList();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(!map.containsKey(ch)) {
        	map.put(ch, 1);
        	list.add(ch);
        }
        else {
        	map.put(ch, map.get(ch) + 1);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	
    	for (int i = 0; i < list.size(); i++) {
			if(map.get(list.get(i)) == 1) {
				return (char) list.get(i);
			}
		}
    	return '#';

    }
}
