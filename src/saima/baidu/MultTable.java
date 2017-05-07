package saima.baidu;

import java.util.Scanner;

public class MultTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			long n = sc.nextLong();
			long m = sc.nextLong();
			long k = sc.nextLong();
			long left = 1;
			long right = n*m;
			long mid = 0;
			while(left<=right){
				mid = (left+right)/2;
				long count = 0;
				for(int i=1; i<=n; i++){
					count += Math.min(m, mid/i);
				}
				if (count<k) {
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
			System.out.println(left);
		}
	}

}
