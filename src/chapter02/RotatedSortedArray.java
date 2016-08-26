package chapter02;

public class RotatedSortedArray {

	public static void main(String[] args) {
		int nums[] = {4,5,6,7,8,1,2,3};
		System.out.println(search(nums, 8));
	}

	
	public static int search(int[] nums, int target) {
        return binarySearch2(nums, 0, nums.length-1, target);
    }
	
	public static int binarySearch2(int nums[], int left, int right, int target){
		//判断本身是否有序
        if (nums[left] < nums[right]) {
			return binarySearch(nums, left, right, target);
		}else {
			int mid = (left + right)/2;
			//判断前半部分是否有序
			if (nums[left] <= nums[mid]) {
				if (target >= nums[left] && target <= nums[mid]) {
					return binarySearch(nums, left, mid, target);
				}else {
					left = mid + 1;
					if (left <= right) {
						return binarySearch2(nums, left, right, target);
					}else {
						return -1;
					}
				}
			}else {
				//后半部分有序，且判断target是否在后半部分
				if (target <= nums[right] && target >= nums[mid]) {
					return binarySearch(nums, mid, right, target);
				}else {
					right = mid - 1;
					if (left <= right) {
						return binarySearch2(nums, left, right, target);
					}else {
						return -1;
					}
				}
			}
		}
	}
	
	public static int binarySearch(int nums[], int left, int right, int target){
		int mid = (left + right)/2;
		while (left <= right) {
			if (target == nums[mid]) {
				return mid;
			}else if (target < nums[mid]) {
				right = mid - 1;
			}else if (target > nums[mid]) {
				left = mid + 1;
			}
			mid = (left + right)/2;
			
		}
		return -1;
	}
}
