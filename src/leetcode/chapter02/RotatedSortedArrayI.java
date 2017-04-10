package leetcode.chapter02;

public class RotatedSortedArrayI {

	public static void main(String[] args) {
		int nums[] = { 1, 3, 5 };
		System.out.println(search(nums, 3));
	}

	public static boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = (left + right)/2;
			if (target == nums[left] || target == nums[right] || target == nums[mid]) {
				return true;
			}
			if (nums[left] < nums[right]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}else if (nums[left] > nums[mid]) {
				if (target > nums[mid] && target < nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}else {
				left++;
			}
		}
		return false;
	}

}
