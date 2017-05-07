package nowcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxPoker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();
		map.put("3", 3);
		map.put("4", 4);
		map.put("5", 5);
		map.put("6", 6);
		map.put("7", 7);
		map.put("8", 8);
		map.put("9", 9);
		map.put("10", 10);
		map.put("J", 11);
		map.put("Q", 12);
		map.put("K", 13);
		map.put("A", 14);
		map.put("2", 15);
		map.put("joker", 16);
		map.put("JOKER", 17);
		while (sc.hasNext()) {
			String string = sc.nextLine();
			String[] strs = string.split("-");
			if (strs[0].length()==1) {
				if (map.get(strs[0])>map.get(strs[1])) {
					System.out.println(strs[0]);
				}else {
					System.out.println(strs[1]);
				}
				continue;
			}
			if (strs[0].equals("joker JOKER")) {
				System.out.println(strs[0]);
				continue;
			}
			if (strs[1].equals("joker JOKER")) {
				System.out.println(strs[1]);
				continue;
			}
			String[] strs0 = strs[0].split(" ");
			String[] strs1 = strs[1].split(" ");
			if (strs0.length==4&&strs1.length!=4) {
				System.out.println(strs[0]);
				continue;
			}
			if (strs1.length==4&&strs0.length!=4) {
				System.out.println(strs[1]);
				continue;
			}
			if (strs0.length!=strs1.length) {
				System.out.println("ERROR");
				continue;
			}
			switch (strs0.length) {
			case 2:
			case 3:
			case 4:
			case 5:
				if (map.get(strs0[0])>map.get(strs1[0])) {
					System.out.println(strs[0]);
				}else {
					System.out.println(strs[1]);
				}
				break;
			default:
				System.out.println("ERROR");
				break;
			}
		}
	}

}
