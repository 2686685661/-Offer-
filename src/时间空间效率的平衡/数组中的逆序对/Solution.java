package 时间空间效率的平衡.数组中的逆序对;

public class Solution {
	
	
	
    public int InversePairs(int [] array) {
        if(array == null || array.length <= 1) {
        	return 0;
        }
        
        int times = 0;
        for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if(array[i] > array[j]) {
					++times;
				}
			}
		}
        
        return times % 1000000007;
    }
    
    
    public int times = 0;
    
    public int InversePairs_2(int [] array) {
        if(array != null && array.length > 0) {
        	mergeSortUp2Down(array, 0, array.length - 1);
        }
        return times;
        
    }
    
    public void mergeSortUp2Down(int[] elem, int start, int end) {
    	if(start >= end) {
    		return;
    	}
    	int mid = (start + end) / 2;
    	
    	mergeSortUp2Down(elem, start, mid);
    	mergeSortUp2Down(elem, mid + 1, end);
    	
    	merge(elem, start, mid, end);
    }
    
    public void merge(int[] elem, int start, int mid, int end) {
    	int[] temp = new int[end - start + 1];
    	int i = start;
    	int j = mid + 1;
    	int k = 0;
    	while(i <= mid && j <= end) {
    		if(elem[i] <= elem[j]) {
    			temp[k++] = elem[i++];
    		}
    		else {
    			temp[k++] = elem[j++];
    			times += mid - i + 1; // core code, calculate InversePairs
    			times %= 1000000007;
    		}
    	}
    	
    	while(i <= mid) {
    		temp[k++] = elem[i++];
    	}
    	
    	while(j <= end) {
    		temp[k++] = elem[j++];
    	}
    	
    	for (i = 0; i < k; i++) {
			elem[start + i] = temp[i];
		}
    	temp = null;
    } 
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] arr = {1,2,3,4,5,6,7,0};
    	System.out.println(s.InversePairs_2(arr));
	}
}
