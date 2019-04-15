package 举例让抽象具体化.二叉搜索树的后序遍历序列;



 


public class Solution {

    public boolean VerifySquenceOfBST(int [] sequence) {
    	
    	if(sequence == null || sequence.length == 0) {
    		return false;
    	}
    	else if(sequence.length == 1) {
    		return true;
    	}
    	
    	return JudgePostOrder(sequence, 0, sequence.length - 1);
    	
    }
    
    public boolean JudgePostOrder(int[] sequence, int start, int end) {
    	
    	if(start >= end) {
    		return true;
    	}
    	
    	int i = start;
    	while (i <= end && sequence[i] < sequence[end]) {
    		i++;
    	}
    	
    	for (int j = i; j <= end; j++) {
			if(sequence[j] < sequence[end]) {	
				return false;
			}
		}
    	
    	return JudgePostOrder(sequence, start, i - 1) && JudgePostOrder(sequence, i, end - 1);

    }
    
    public boolean VerifySquenceOfBST_2(int [] sequence) {
    	if(sequence == null || sequence.length == 0) {
    		return false;
    	}
    	else if(sequence.length == 1) {
    		return true;
    	}
    	
    	int size = sequence.length - 1;
    	int i = 0;
    	
    	while(size > 0) {
    		
    		while(sequence[i] < sequence[size]) {
    			i++;
    		};
    		while(sequence[i] > sequence[size]) {
    			i++;
    		}
    		
    		if(i < size) {
    			return false;
    		}
    		
    		i = 0;
    		size--;
    	}
    	return true;

    }
    
    
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] test = {1,2,3,4,5};
    	System.out.println(s.VerifySquenceOfBST_2(test));
	}
    
   
}
