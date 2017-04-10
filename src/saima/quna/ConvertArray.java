package saima.quna;

import java.util.Arrays;
import java.util.Scanner;

public class ConvertArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int[] d = new int[n];
			int[] copy = new int[n];
			for (int i = 0; i < n; i++) {
				d[i] = sc.nextInt();
				copy[i] = d[i];
			}
			int start = 0;
			int end = n-1;
			Arrays.sort(copy);
			while(start<n&&d[start]==copy[start]){
				start++;
			}
			while (end>=0 && d[end]==copy[end]) {
				end--;
			}
			int index;
			for (index = 0; index <= end-start; index++) {
				if (d[start+index]!=copy[end-index]) {
					break;
				}
			}
			
			if (index>=(end-start)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
		}
	}

}
