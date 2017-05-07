package nowcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MingMingRound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(Long.MAX_VALUE);
		while(sc.hasNext()){
			Set<Integer> set = new HashSet<>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				set.add(sc.nextInt());
			}
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			for (Integer integer : list) {
				System.out.println(integer);
			}
		}
	}

}
