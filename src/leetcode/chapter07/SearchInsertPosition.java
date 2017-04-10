package leetcode.chapter07;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = {8};
		int target = 7;
		System.out.println(searchInsert(nums, target));
	}

	public static int searchInsert(int[] nums, int target) {
		if (nums.length==0) {
			return 0;
		}
		
		int left = 0;
		int right = nums.length-1;
		int mid;
		while (left<right) {
			mid = (left+right)/2;
			if (nums[mid]==target) {
				return mid;
			}else if (nums[mid]<target) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		if (target>nums[left]) {
			return left+1;
		}else {
			return left;
		}
	}
}
