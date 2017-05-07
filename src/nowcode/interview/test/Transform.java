package nowcode.interview.test;

public class Transform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[][] transformImage(int[][] mat, int n) {
        // write code here
		int tmp;
        for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < i; j++) {
				tmp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = tmp;
			}
		}
        int left = 0;
        int right = mat[0].length-1;
        while(left<right){
        	for(int i=0; i< mat.length; i++){
        		tmp = mat[i][left];
        		mat[i][left] = mat[i][right];
        		mat[i][right] = tmp;
        	}
        	left++;
        	right--;
        }
        return mat;
    }

}
