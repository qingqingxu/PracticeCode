package leetcode.chapter02;

public class SingleNumber {

	//异或
	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,4,3,2,1};
		int x = 0;
		for (int i = 0; i < nums.length; i++) {
			x ^= nums[i];
		}
		System.out.println(x);
	}

}
