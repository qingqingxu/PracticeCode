package leetcode.chapter07;


public class Searcha2DMatrix {

	public static void main(String[] args) {
		int[][] matrix ={{1}};// { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix, 1));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if (row>0) {
			int col = matrix[0].length-1;
			int startRow = 0;
			int endRow = row-1;
			int midRow;
			while (startRow<=endRow) {
				midRow = (startRow+endRow)/2;
				if (matrix[midRow][col]==target) {
					return true;
				}else if (matrix[midRow][col]>target) {
					if (matrix[midRow][0]<=target) {
						int startCol = 0;
						int midCol;
						while (startCol<=col) {
							midCol = (startCol+col)/2;
							if (matrix[midRow][midCol]==target) {
								return true;
							}else if (matrix[midRow][midCol]<target) {
								startCol = midCol+1;
							}else {
								col = midCol-1;
							}
						}
						break;
					}
					endRow = midRow-1;
				}else{
					startRow = midRow+1;
				}
			}
			
		}
		
		return false;
	}

}
