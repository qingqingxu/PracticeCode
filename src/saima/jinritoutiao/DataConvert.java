package saima.jinritoutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataConvert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			System.out.println(convert(str));
		}
	}
	
	private static long convert(String str){
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			char tmp = (char) ('a'+i);
			map.put(tmp, i);
		}
		
		long value = 0;
		for (int i = 0; i < str.length(); i++) {
			value = value*26+ map.get(str.charAt(i));
		}
		return value;
	}

}
