package nowcode;

import java.util.HashSet;
import java.util.Set;

public class FindFirstRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findFirstRepeat("qywyer23tdd", 11));
	}
	
	public static char findFirstRepeat(String A, int n) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
			if (set.contains(A.charAt(i))) {
				return A.charAt(i);
			}
			set.add(A.charAt(i));
		}
        return (Character) null;
    }

}
