package nowcode;

/**
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。

input:[1,3,5,7,9],5,3

output:1
 * @author XuQingQing
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,5,9,9};
		System.out.println(getPos(A, 5, 9));
	}
	
	public static int getPos(int[] A, int n, int val) {
        // write code here
		int mid;
		int left = 0;
		int right = n-1;
		while (left<=right) {
			mid = (left+right)/2;
			if (val==A[mid]) {
				if (mid>=1 && A[mid]>A[mid-1]) {
					return mid;
				}else if(mid>=1 && A[mid]==A[mid-1]){
					right = mid-1;
				}else if (mid==0) {
					return mid;
				}
			}else if (val>A[mid]) {
				left = mid+1;
			}else{
				right = mid - 1;
			}
		}
		return -1;
    }

}
