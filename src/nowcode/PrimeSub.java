package nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeSub {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println(getResult(sc.nextLong()));
		}
	}
	public static String getResult(long ulDataInput){
		if (ulDataInput==1) {
			return null;
		}
		List<Long> primes = new ArrayList<>();
		primes.add((long) 2);
		primes.add((long) 3);
		int index = 1;
		for (long i = 4; i <= Math.sqrt(ulDataInput); i++) {
			boolean isPrime = true;
			for (int j = 0; primes.get(j) <= Math.sqrt(i) && j <= index ; j++) {
				if (i%primes.get(j)==0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
				index++;
			}
		}

		StringBuffer sb = new StringBuffer();
		long tmp = ulDataInput;
		for (int i = 0;  i<primes.size() && primes.get(i) <= Math.sqrt(ulDataInput); i++) {
			while (tmp%primes.get(i)==0) {
				sb.append(primes.get(i)).append(' ');
				tmp/=primes.get(i);
			}
			
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
