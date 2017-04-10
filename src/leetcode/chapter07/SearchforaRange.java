package leetcode.chapter07;

public class SearchforaRange {

	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 10;
		int[] result = searchRange(nums, target);
		System.out.println(result[0]+" "+result[1]);
	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums.length>0) {
			int left = 0;
			int right = nums.length-1;
			int mid = (left+right)/2;
			while (left<=right) {
				if (nums[mid]==target) {
					int start = mid;
					int end = mid;
					while (start>0&&target==nums[start-1]) {
						start--;
					}
					while (end<nums.length-1&&target==nums[end+1]) {
						end++;
					}
					return new int[]{start, end};
				}else if (nums[mid]<target) {
					left = mid+1;
				} else {
					right = mid-1;
				}
				mid = (left+right)/2;
			}
		}
		return new int[]{-1,-1};
	}

}
