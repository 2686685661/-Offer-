package 画图让抽象形象化.顺时针打印矩阵;

import java.util.ArrayList;
public class Solution {
	
    public ArrayList<Integer> printMatrix(int [][] matrix) {
     
    	if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
    		return null;
    	}
    	
    	int start = 0;
    	int columns = matrix[0].length;
    	int rows = matrix.length;
    	ArrayList list = new ArrayList<Integer>();
    	
    	
    	while((columns > start * 2) && (rows > start * 2)) {
    		this.AppendListMatrix(list, matrix, columns, rows, start);
    		++start;
    	}
    	
    	return list;
    	
    }
    
    
    public void AppendListMatrix(ArrayList list, int[][] matrix, int columns, int rows, int start) {
    	
    	int endX = columns - 1 - start;
    	int endY = rows - 1 - start;
    	
    	for (int i = start; i <= endX; i++) {
			list.add(matrix[start][i]);
		}
    	
    	if(start < endY) {
    		for (int i = start + 1; i <= endY; i++) {
				list.add(matrix[i][endX]);
			}
    	}
    	
    	if(start < endX && start < endY) {
    		for (int i = endX - 1; i >= start ; i--) {
				list.add(matrix[endY][i]);
			}
    	}
    	
    	if(start < endX && start < endY - 1) {
    		for (int i = endY - 1; i >= start +1; i--) {
				list.add(matrix[i][start]);
			}
    	}
    }
}
