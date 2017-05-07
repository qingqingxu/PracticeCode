package nowcode;

import java.util.ArrayList;
import java.util.Scanner;

public class GetAlcalde {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int T = sc.nextInt();
			for (int time = 0; time < T; time++) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				if (m==0) {
					System.out.println(0);
					System.out.println();
					continue;
				}
				int[] know = new int[n];
				int[] known = new int[n];
				int a, b;
				for (int i = 0; i < m; i++) {
					a = sc.nextInt();
					b = sc.nextInt();
					if (a==b) {
						continue;
					}
					know[a-1]++;
					known[b-1]++;
				}

				ArrayList<Integer> arrayList = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					if (know[i]==0&&known[i]==n-1) {
						arrayList.add(i+1);
					}
				}
				
				System.out.println(arrayList.size());
				if (arrayList.size()==0) {
					System.out.println();
				}else {
					for (Integer integer : arrayList) {
						System.out.print(integer+" ");
					}
					System.out.println();
				}
				
				//超出內存限制
				/*int[][] persons = new int[n][n];
				for (int i = 0; i < m; i++) {
					persons[sc.nextInt()-1][sc.nextInt()-1] = 1;
				}
				
				ArrayList<Integer> arrayList = new ArrayList<>();
				for (int col = 0; col < persons[0].length; col++) {
					boolean isAllKnown = true;
					for (int row = 0; row < persons.length; row++) {
						if (row!=col&&persons[row][col]==0) {
							isAllKnown = false;
							break;
						}
					}
					if (isAllKnown) {
						boolean isKnownSomeone = false;
						for (int col2 = 0; col2 < persons[0].length; col2++) {
							if (col!=col2&&persons[col][col2]==1) {
								isKnownSomeone = true;
								break;
							}
						}
						if (isAllKnown&&!isKnownSomeone) {
							arrayList.add(col+1);
						}
					}
				}
				System.out.println(arrayList.size());
				if (arrayList.size()==0) {
					System.out.println();
				}else {
					for (Integer integer : arrayList) {
						System.out.print(integer+" ");
					}
					System.out.println();
				}*/
			}
			
		}
	}

}
