package saima.xiaomi;

public class CountBitDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countBitDiff(1999, 2299));
	}

	public static int countBitDiff(int m, int n) {
		int tmp = m^n;
		int count = 0;
		while(tmp!=0){
			count++;
			tmp = (tmp-1)&tmp;
		}
		return count;
    }
	
}
