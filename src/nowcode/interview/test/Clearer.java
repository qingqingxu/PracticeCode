package nowcode.interview.test;

import java.util.ArrayList;
import java.util.List;

public class Clearer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[][] clearZero(int[][] mat, int n) {
        // write code here
		List<Location> list = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j]==0) {
					list.add(new Location(i, j));
				}
			}
		}
		for (Location location : list) {
			for(int i=0; i< mat[0].length; i++){
				mat[location.row][i] = 0;
				mat[i][location.col] = 0;
			}
		}
		return mat;
    }

}

class Location{
	int row;
	int col;
	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
}