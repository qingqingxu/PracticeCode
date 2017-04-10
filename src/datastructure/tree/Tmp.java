package datastructure.tree;

import java.util.Arrays;

public class Tmp {

	static int oo = 9;
	public static void main(String[] args) {
		char tmp = (char) ('a'+3);
		System.out.println(tmp);
		oo = 10;
		System.out.println(oo);
		uu();
		System.out.println(oo);
		String string = "99 21 2 1 11 7 4 3 6 5 8 9 10 20 13 12 18 14 16 15 17 19 47 38 26 24 22 23 25 29 27 28 34 31 30 33 32 35 37 36 44 40 39 43 42 41 46 45 60 55 51 49 48 50 52 54 53 57 56 59 58 72 68 65 64 61 62 63 66 67 70 69 71 73 97 76 75 74 78 77 96 89 81 80 79 88 87 86 82 85 84 83 95 90 92 91 93 94 98 100";
		String[] strs = string.split(" ");
		int[] left = new int[100];
		for (int i = 0; i < left.length; i++) {
			left[i] = Integer.valueOf(strs[i]);
		}
		
		String string2 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100";
		String[] strs2 = string.split(" ");
		int[] left2 = new int[100];
		for (int i = 0; i < left2.length; i++) {
			left2[i] = Integer.valueOf(strs2[i]);
		}
		
		Arrays.sort(left);
		Arrays.sort(left2);
		
		int i;
		for (i = 0; i < left2.length; i++) {
			if (left[i]!=left2[i]) {
				System.out.println(left[i]);
				System.out.println(left2[i]);
				break;
			}
		}
		System.out.println(i==left.length);
	}
	
	public static void uu() {
		oo=99;
	}
}
