package leetcode.chapter02;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int nums[] = {0,4,3,0};
		int target = 0;
		int result[] = new int[2];
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer n = numMap.get(nums[i]);
			if (n==null) {
				numMap.put(nums[i], i);
			}
			n = numMap.get(target-nums[i]);
			if (n!=null&&n<i) {
				result[0] = n;
				result[1] = i;
				break;
			}
			
		}
		
		System.out.println(result[0]+""+result[1]);
	}

}
