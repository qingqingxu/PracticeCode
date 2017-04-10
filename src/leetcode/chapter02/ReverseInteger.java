package leetcode.chapter02;
/**
 * 细节问题：结果溢出问题
 * @author XuQingQing
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		long x = -2147483648;
		boolean flag = x>0 ? true : false;
		x = x>0?x:-x;
		long result = 0;
		while (x/10!=0) {
			result = result*10+x%10;
			x/=10;
		}
		result = result*10+x%10;
		result = flag?result:-result;
		if (result>Integer.MAX_VALUE||(!flag&&(result<Integer.MIN_VALUE))) {
			result = 0;
		}
		System.out.println((int)result);
	}

}
