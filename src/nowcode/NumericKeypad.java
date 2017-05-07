package nowcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumericKeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, ArrayList<Character>> map = new HashMap<>();
		map.put('0', null);
		map.put('1', new ArrayList<Character>(){{add('9');add('8');add('7');add('6');add('5');add('4');add('3');add('2');add('0');}});
		map.put('2', new ArrayList<Character>(){{add('9');add('8');add('6');add('5');add('3');add('0');}});
		map.put('3', new ArrayList<Character>(){{add('9');add('6');}});
		map.put('4', new ArrayList<Character>(){{add('9');add('8');add('7');add('6');add('5');add('0');}});
		map.put('5', new ArrayList<Character>(){{add('9');add('8');add('6');add('0');}});
		map.put('6', new ArrayList<Character>(){{add('9');}});
		map.put('7', new ArrayList<Character>(){{add('9');add('8');add('0');}});
		map.put('8', new ArrayList<Character>(){{add('9');add('0');}});
		map.put('9', null);
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		while (sc.hasNext()) {
			int T = Integer.valueOf(sc.nextLine());
			for (int j = 0; j < T; j++) {
				String K = sc.nextLine();
				sb.append(K.charAt(0));
				for (int i = 1; i < K.length(); i++) {
					if (map.get(sb.charAt(i-1))==null) {
						int tmp = i-1;
						while (i < K.length()) {
							sb.append(sb.charAt(tmp));
							i++;
						}
					}else{
						if (map.get(sb.charAt(i-1)).contains(K.charAt(i))) {
							sb.append(K.charAt(i));
						}else{
							for (Character ch : map.get(sb.charAt(i-1))) {
								if (ch < K.charAt(i)) {
									sb.append(ch);
									
									break;
								}
							}
							if (sb.length()<i+1) {
								//System.out.println(sb.toString());
								int tmp = sb.length();
								if (tmp==1) {
									sb.setCharAt(tmp-1, (char)(sb.charAt(tmp-1)-1));
									char ch = map.get((char)(sb.charAt(tmp-1)-1)).get(0);
									while (tmp<K.length()) {
										sb.append(ch);
									}
								}else {
									for (Character ch : map.get(sb.charAt(i-2))) {
										if (ch < sb.charAt(i-1)) {
											sb.setCharAt(i-1, ch);
											char ch2 = map.get(ch).get(0);
											while (sb.length()<K.length()) {
												sb.append(ch2);
											}
											break;
										}
									}
								}
							}
							
						}
					}
					if (sb.length()==K.length()) {
						break;
					}
				}
				System.out.println(sb.toString());
				sb.setLength(0);
			}
			
		}
	}

}
