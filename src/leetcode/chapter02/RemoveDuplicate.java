package leetcode.chapter02;

public class RemoveDuplicate {
	public static void main(String[] args) {
		int nums[] = {1,1,2,3,3,4};
		int sum = 0;
		if (nums.length<2) {
			sum = nums.length;
		}else {
			sum = 2;
		}
		for (int i = 2; i < nums.length; i++) {
			if (nums[i]!=nums[i-2]) {
				sum++;
				nums[sum++] = nums[i];
			}
			
		}
	}
}
