package leetcode.chapter07;


public class Searcha2DMatrixI {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix, 51));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length-1;
		if (row>=0) {
			int col = matrix[0].length-1;
			int startCol = 0;
			int endCol = col;
			int endRow = row;
			while (startCol<=endCol) {
				if (matrix[0][endCol]==target) {
					return true;
				}else if (matrix[0][endCol]>target) {
					endCol--;
				}
				
				if (matrix[endRow][startCol]==target) {
					return true;
				}else if (matrix[endRow][startCol]<target) {
					startCol++;
				}else {
					if (matrix[0][startCol]<=target) {
						int tsRow = 0;
						int teRow = row;
						int tmRow;
						while (tsRow<=teRow) {
							tmRow = (tsRow+teRow)/2;
							if (matrix[tmRow][startCol]==target) {
								return true;
							}else if (matrix[tmRow][startCol]>target) {
								teRow = tmRow-1;
							}else {
								tsRow = tmRow+1;
							}
						}
					}
					startCol++;
				}
			}
			
		}
		
		return false;
	}

}
