package leetcode.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> list = new ArrayList<>();
		if (strs.length==0) {
			return list;
		}
		Map<String, List<String>> map = new HashMap<>();
		
		for (String str : strs) {
			char []str_chars = str.toCharArray();
			Arrays.sort(str_chars);
			String key = new String(str_chars);
			List<String> values = map.get(key);
			if (values==null) {
				values = new ArrayList<>();
			}
			values.add(str);
			map.put(key, values);
		}
		for (String key : map.keySet()) {
			List<String> list2 = map.get(key);
			Collections.sort(list2);
			list.add(list2);
		}
		return list;
	}
}
