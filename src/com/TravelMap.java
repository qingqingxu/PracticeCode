package com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TravelMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TravelMap().equals(new TravelMap()));
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "ab");
		map.put(4, "ab");
		map.put(4, "ab");// 和上面相同 ， 会自己筛选
		
		//map.keySet()
		for (Integer key : map.keySet()) {
			System.out.println(key+"\t"+map.get(key));
		}
		
		//map.values()
		for (String string : map.values()) {
			System.out.println(string);
		}
		
		//推荐，尤其是容量大时
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			System.out.println(entry.getKey()+"\t"+ entry.getValue());
		}
	}

}
