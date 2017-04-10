package leetcode.chapter03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Roman {

	public static void main(String[] args) {
		// System.out.println(romanToInt("MCMXCVI"));
		System.out.println(intToRoman(3976));
	}

	public static String intToRoman(int num) {
		StringBuffer buffer = new StringBuffer();

		Map<Integer, String> map = new TreeMap<Integer, String>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}

		});
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		for (Integer key : map.keySet()) {
			int count = num / key;
			num = num%key;
			for (int i = 0; i < count; i++) {
				buffer.append(map.get(key));
			}
		}
		
		return buffer.toString();

	}

	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int digit = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
				digit -= map.get(s.charAt(i));
				digit += map.get(s.charAt(++i));
			} else {
				digit += map.get(s.charAt(i));
			}
		}
		return digit;
	}

}
