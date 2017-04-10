package saima.jd;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CombineSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Set<Integer> A = new TreeSet<>();
			Set<Integer> B = new TreeSet<>();
			for (int i = 0; i < n; i++) {
				A.add(sc.nextInt());
			}
			
			for (int i = 0; i < m; i++) {
				B.add(sc.nextInt());
			}
			
			A.addAll(B);
			
			for (Integer integer : A) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}

}
