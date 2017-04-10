package saima.jinritoutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Yihuo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
		}
		
		

	}

}

class TriNode{
	TriNode[] triNode = new TriNode[2];
	
}

/*Scanner sc = new Scanner(System.in);
while (sc.hasNextInt()) {
	int n = sc.nextInt();
	int m = sc.nextInt();
	Map<Integer, Integer> map = new HashMap<>();
	int tmp;
	for (int i = 0; i < n; i++) {
		tmp = sc.nextInt();
		if (map.get(tmp)==null) {
			map.put(tmp, 1);
		}else {
			map.put(tmp, map.get(tmp)+1);
		}
	}
	
	long count = 0;
	int[] d = new int[map.size()];
	int i=0;
	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		d[i++] = entry.getKey();
	}
	for (int j = 0; j < d.length; j++) {
		for (int j2 = 0; j2 < d.length && j2!=j; j2++) {
			if ((tmp = d[j]^d[j2])>m) {
				count+=map.get(d[j])*map.get(d[j2]);
			}
		}
	}
	System.out.println(count);
}*/
