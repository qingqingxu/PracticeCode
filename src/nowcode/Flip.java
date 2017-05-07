package nowcode;

import java.util.Map;

public class Flip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[][] flipChess(int[][] A, int[][] f) {
        // write code here
		for (int i = 0; i < f.length; i++) {
			f[i][0]--;
			f[i][1]--;
			
			if (f[i][0]-1>=0) {
				A[f[i][0]-1][f[i][1]] = A[f[i][0]-1][f[i][1]]==1?0:1;
			}
			if (f[i][0]+1<4) {
				A[f[i][0]+1][f[i][1]] = A[f[i][0]+1][f[i][1]]==1?0:1;
			}

			if (f[i][1]-1>=0) {
				A[f[i][0]][f[i][1]-1] = A[f[i][0]][f[i][1]-1] ==1?0:1;
			}
			if (f[i][1]+1<4) {
				A[f[i][0]][f[i][1]+1] = A[f[i][0]][f[i][1]+1] ==1?0:1;
			}
		}
		return A;
    }

}
