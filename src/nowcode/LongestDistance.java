package nowcode;

import java.util.Arrays;

public class LongestDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2676,4662,8383,357,6595};
		System.out.println(getDis(A, 5));
	}
	
	public static int getDis(int[] A, int n) {
        // write code here
		int minLoc = 0;
		int maxLoc = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			minLoc = i;
			maxLoc = i;
			for (int j = i; j < n; j++) {
				if (A[j]>A[maxLoc]) {
					maxLoc = j;
				}
			}
			for (int j = 0; j < maxLoc; j++) {
				if (A[j]<A[minLoc]) {
					minLoc = j;
				}
			}
			max = (A[maxLoc]-A[minLoc])>max?A[maxLoc]-A[minLoc]:max;
		}
		return max;
    }

}
