package saima.jinritoutiao;

import java.util.Arrays;
import java.util.Scanner;

public class GiveTitle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int[] d = new int[n];
			for (int i = 0; i < n; i++) {
				d[i] = sc.nextInt();
			}
			
			Arrays.sort(d);
			int[] sub = new int[n-1];
			for (int i = 0; i < n-1; i++) {
				sub[i] = d[i+1]-d[i];
			}
			int index = 0;
			int count = 0;
			
			while (index<n-1) {
				if (sub[index]>20) {
					if ((count+index+1)%3!=0) {
						count += 3-(count+index+1)%3;
					}
					
				}else if (sub[index]>10) {
					if ((count+index+1)%3==0) {
						index++;
					}else if((count+index+1)%3==1){
						count++;
						index++;
					}else {
						count++;
					}
				}
				index++;
			}
			if ((count+n)%3!=0) {
				count += 3-(count+index+1)%3;
			}
			System.out.println(count);
		}
	}

}
