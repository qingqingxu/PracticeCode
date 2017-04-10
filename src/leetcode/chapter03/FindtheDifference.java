package leetcode.chapter03;

import java.util.Arrays;

public class FindtheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findTheDifference("abdcde", "abdcdde"));
	}

	public static char findTheDifference(String s, String t) {
		char chs[] = s.toCharArray();
		char cht[] = t.toCharArray();
		Arrays.sort(chs);
		Arrays.sort(cht);
		int i;
		for ( i = 0; i < chs.length; i++) {
			if (chs[i]!=cht[i]) {
				break;
			}
		}
		return cht[i];
	}

}
