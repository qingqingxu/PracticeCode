package saima.xiaomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TelephoneDvidied {

	public static void main(String[] args) {
		String[] strings = {"ZERO", "ONE", "TWO", "THREE", "FOUR", 
				"FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
		
		char[] array = {'Z','W','U','X','G','S','F','H','O','I'};
		Map<Character, Integer> tmp = new HashMap<>();
		tmp.put('Z', 0);
		tmp.put('W', 2);
		tmp.put('U', 4);
		tmp.put('X', 6);
		tmp.put('G', 8);
		tmp.put('S', 7);
		tmp.put('F', 5);
		tmp.put('H', 3);
		tmp.put('O', 1);
		tmp.put('I', 9);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			int n = Integer.valueOf(sc.nextLine());
			for (int i = 0; i < n; i++) {
				String string = sc.nextLine();
				Map<Character, Integer> chars = new HashMap<>();
				for (int j = 0; j < string.length(); j++) {
					if (chars.get(string.charAt(j))==null) {
						chars.put(string.charAt(j), 1);
					}else {
						chars.put(string.charAt(j), (chars.get(string.charAt(j)))+1);
					}
				}
				List<Integer> list = new ArrayList<>();
				for (int j = 0; j < array.length; j++) {
					if (chars.get(array[j])!=null) {
						int num = chars.get(array[j]);
						for (int k = 0; k < num; k++) {
							list.add((tmp.get(array[j])-8+10)%10);
							
						}
						String mm = strings[tmp.get(array[j])];
						for (int k = 0; k < mm.length(); k++) {
							if (chars.get(mm.charAt(k))==num) {
								chars.remove(mm.charAt(k));
							}else {
								chars.put(mm.charAt(k), chars.get(mm.charAt(k))-num);
							}
							
						}
					}
				}
				Collections.sort(list);
				for (Integer integer : list) {
					System.out.print(integer);
				}
				System.out.println();
			}
		}
	}

}
