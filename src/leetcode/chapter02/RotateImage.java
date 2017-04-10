package leetcode.chapter02;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix={{1,2},{3,4}};
		int tmp;
		int n = matrix.length;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < n -1 - i; j++) {
				tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][n-1-i];
				matrix[n-1-j][n-1-i] = tmp;
			}
		}
		
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n; j++) {
				tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-i][j];
				matrix[n-1-i][j] = tmp;
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
