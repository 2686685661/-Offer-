package 时间效率.数组中出现次数超过一半的数字;

public class Solution {
	
	/**
	 * 利用Partition函数的时间复杂度为O(n)的算法
	 * @param array
	 * @return
	 */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) {
        	return 0;
        }
        if(array.length == 1) {
        	return array[0];
        }
        
        int middle = array.length / 2;
        int start = 0;
        int end = array.length - 1;
        
        int index = Partition(array, start, end);
        while(index != middle) {
        	if(index > middle) {
        		end = index - 1;
        		index = Partition(array, start, end);
        	}
        	else {
        		start = index + 1;
        		index = Partition(array, start, end);
        	}
        }
        
        int result = array[middle];
        if(!CheckMoreThanHalf(array, result)) {
        	result = 0;
        }
        return result;
    }
    
    public boolean CheckMoreThanHalf(int[] elem, int result) {
    	int times = 0;
    	boolean isMoreThanHalf = true;
    	for (int i = 0; i < elem.length; i++) {
			if(elem[i] == result) {
				++times;
			}
		}
    	
    	if(times * 2 <= elem.length) {
    		isMoreThanHalf = false;
    	}
    	
    	return isMoreThanHalf;
    }
    
    public int Partition(int[] elem, int low, int high) {
    	int pivotkey = elem[low];
    	while(low < high) {
    		while((low < high) && elem[high] > pivotkey) {
    			high--;
    		}
    		swap(elem, low, high);
    		while((low < high) && elem[low] <= pivotkey) {
    			low ++;
    		}
    		swap(elem, low, high);
    		
    	}
    	return low;
    }
    
    
    
    public void swap(int[] elem, int i, int j) {
    	int temp = elem[i];
    	elem[i] = elem[j];
    	elem[j] = temp;
    }
    
    
    /**
     * 根据数组特点找出时间复杂度为O(n)的算法
     * @param args
     */
    
    public int MoreThanHalfNum_Solution_2(int [] array) {
    	if(array == null || array.length == 0) {
    		return 0;
    	}
    	
    	if(array.length == 1) {
    		return array[0];
    	}
    	
    	int tempNumber = array[0];
    	int times = 1;
    	
    	for (int i = 1; i < array.length; i++) {
    		if(tempNumber == array[i]) {
    			times++;
    		}
    		else {
    			
    			times--;
        		if(times == 0) {
        			tempNumber = array[i];
        			times = 1;
        		}

    		}
		}
        if(!CheckMoreThanHalf(array, tempNumber)) {
        	tempNumber = 0;
        }
        return tempNumber;
    	
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] elem = {1,2,3,2,2,2,5,4,2};
    	System.out.println(s.MoreThanHalfNum_Solution_2(elem));
	}
    
}
