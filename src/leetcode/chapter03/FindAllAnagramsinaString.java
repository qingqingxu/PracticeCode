package leetcode.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer integer : findAnagrams("cbaebabacd", "abc")) {
			System.out.println(integer);
		}
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s.length() >= p.length()) {
			int si[] = new int[256];
			int pi[] = new int[256];
			for (int i = 0; i < p.length(); i++) {
				pi[p.charAt(i)]++;
			}
			
			for (int i = 0; i < s.length(); i++) {
				si[s.charAt(i)]++;
				if (i>=p.length()) {
					si[s.charAt(i-p.length())]--;
				}
				if (Arrays.equals(pi, si)) {
					list.add(i-p.length()+1);
				}
			}
		}
		return list;
	}
	/*wrong
	 * public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s.length() >= p.length()) {
			Map<Character, Integer> pMap = new HashMap<>();
			for (int i = 0; i < p.length(); i++) {
				if (pMap.get(p.charAt(i)) == null) {
					pMap.put(p.charAt(i), 1);
				} else {
					pMap.put(p.charAt(i), pMap.get(p.charAt(i)) + 1);
				}
			}
			Map<Character, Integer> sMap = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				if (p.contains(s.charAt(i)+"")) {
					addCharacter(sMap, s.charAt(i));
					
					if (i-p.length()+1>=0) {
						int sum = 0;
						for (Integer integer : sMap.values()) {
							sum+=integer;
						}
						if (sum>p.length()) {
							removeCharacter(sMap, s.charAt(i-p.length()));
						}
					}
					if (isMapEqual(sMap, pMap)) {
						list.add(i-p.length()+1);
					}
				}else {
					sMap.clear();
				}
			}
		}

		return list;
	}

	public static Map<Character, Integer> removeCharacter(Map<Character, Integer> map, char c) {
		if (map.get(c) != null&&map.get(c)>1) {
			map.put(c, map.get(c) - 1);
		} else {
			map.remove(c);
		}
		return map;
	}
	
	public static Map<Character, Integer> addCharacter(Map<Character, Integer> map, char c) {
		if (map.get(c) != null) {
			map.put(c, map.get(c) + 1);
		} else {
			map.put(c, 1);
		}
		return map;
	}

	public static boolean isMapEqual(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
		if (sMap.size() != pMap.size()) {
			return false;
		}
		for (Character key : sMap.keySet()) {
			if (sMap.get(key) != pMap.get(key)) {
				return false;
			}
		}
		return true;
	}*/

	/*
	 * public static List<Integer> findAnagrams(String s, String p) {
	 * List<Integer> list = new ArrayList<>(); if (s.length() >= p.length()) { p
	 * = sortStr(p); for (int i = p.length() - 1; i < s.length(); i++) { if
	 * (p.contains("" + s.charAt(i))) { if (p.equals(sortStr(s.substring(i -
	 * p.length() + 1, i + 1)))) { list.add(i - p.length() + 1); } } else { i +=
	 * p.length() - 1; } } }
	 * 
	 * return list; }
	 * 
	 * public static String sortStr(String p) { char cstr[] = p.toCharArray();
	 * Arrays.sort(cstr); return String.valueOf(cstr); }
	 */

}
