package leetcode.chapter06;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1= new int[20];
		nums1[0] = 1;
		nums1[1] = 3;
		nums1[2] = 3;
		nums1[3] = 6;
		int[] nums2={2,3,4,5};
		merge(nums1, 4, nums2, 4);
		for (int i = 0; i < 8; i++) {
			System.out.print(nums1[i]+" ");
		}
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int len = m+n;
		while (m>0&&n>0) {
			while (m>0&&n>0&&nums1[m-1]>=nums2[n-1]) {
				nums1[--len] = nums1[--m];
			}
			while (m>0&&n>0&&nums1[m-1]<nums2[n-1]) {
				nums1[--len] = nums2[--n];
			}
		}
		while (n>0) {
			nums1[--len] = nums2[--n];
		}
	}

}
