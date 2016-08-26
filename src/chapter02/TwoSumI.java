package chapter02;


public class TwoSumI {

	public static void main(String[] args) {
		int numbers[] = {2, 7, 11, 15};
		int target = 9;
		int result[] = new int[2];
		int left =0;
		int right =numbers.length-1;
		while (left<right) {
			if (target<numbers[right]) {
				right--;
			}else{
				while (left<right&&(target-numbers[right]>numbers[left])) {
					left++;
				}
				if (target-numbers[right]==numbers[left]) {
					result[0]=left+1;
					result[1]=right+1;
					break;
				}else{
					right--;
				}
				while (left<right&&(target-numbers[right]<numbers[left])) {
					left--;
					if (left<0) {
						right--;
						break;
					}
				}
			}
		}
		
		System.out.println(result[0]+""+result[1]);
	}

}
