package com;

import java.util.Arrays;

public class MinMoves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tmp[] = {1,3,3};
		System.out.println(minMoves(tmp));
	}

	public static int minMoves(int[] nums) {
		if (nums.length==1) {
			return 0;
		}
		int times = 0;
		Arrays.sort(nums);
		
		for (int i = 1; i < nums.length; i++) {
			times+=nums[i]-nums[0];
		}
		return times;
		
		/*if (nums.length==1) {
			return 0;
		}
		int times = 0;
		Arrays.sort(nums);
		int len = nums.length;
		while (nums[0]!=nums[len-1]) {
			int perTime = 0;
			for (int i = len-1; i >0; i--) {
				if (nums[i]!=nums[i-1]) {
					perTime = nums[i]-nums[i-1];
					break;
				}
			}
			if (perTime!=0) {
				times += perTime;
				for (int i = 0; i < len-1; i++) {
					nums[i] += perTime;
				}
				Arrays.sort(nums);
			}
		}
		return times;*/
	}

}
