package com;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String dtrd[] = {"a","sasb","a"};
		System.out.println(longestCommonPrefix(dtrd));
		
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length==0) {
			return "";
		}else if (strs.length==1) {
			return strs[0];
		}
		int minlen = Integer.MAX_VALUE;
		int location = 0;
		for (int i = 0; i<strs.length; i++) {
			int len = strs[i].length();
			if (len<minlen) {
				minlen = len;
				location = i;
			}
		}
		
		if (minlen==0) {
			return "";
		}
		int maxCommlen = -1;
		boolean flag = true;
		for(int i = 0; i < minlen; i++){
			for (int j = 0; j < strs.length; j++) {
				if (location==j) {
					continue;
				}
				//最后一步才能确认所有一致
				if ((strs[location].charAt(i)!=strs[j].charAt(i))) {
					maxCommlen = i;
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		if (flag) {
			maxCommlen = minlen;
		}
		return (maxCommlen==-1)?"":strs[location].substring(0, maxCommlen);
	}
}
