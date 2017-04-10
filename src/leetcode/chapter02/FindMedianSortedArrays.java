package leetcode.chapter02;

public class FindMedianSortedArrays {

	public static void main(String[] args) {
		int nums1[] = {1, 3};
		int nums2[] = {2};
		
		int nums1len = nums1.length;
		int nums2len = nums2.length;
		
		int tmp = (nums1len + nums2len)/2;
		int left1 = 0, right1 = nums1len - 1, mid1;
		int left2 = 0, right2 = nums2len - 1, mid2;
		while (tmp != 0) {
			mid1 = (left1 + right1)/2;
			mid2 = (left2 + right2)/2;
			if (nums1[mid1] <= nums2[mid2]) {
				tmp -= (mid1 + 1);
				left1 = mid1 + 1;
			}else {
				tmp -= (mid2 + 1);
				left2 = mid2 + 1;
			}
			System.out.println(mid1+" "+mid2+" "+tmp);
		}
	}

}
