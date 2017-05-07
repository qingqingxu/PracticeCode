package nowcode.interview.test;

import java.util.HashMap;
import java.util.Map;

public class Same {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkSam("Here you are", "Are you here"));
	}
	public static boolean checkSam(String stringA, String stringB) {
        // write code here
		if (stringA.length()!=stringB.length()) {
			return false;
		}
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < stringA.length(); i++) {
        	Object object = map.get(stringA.charAt(i));
			if (object==null) {
				map.put(stringA.charAt(i), 1);
			}else {
				map.put(stringA.charAt(i), (int)object+1);
			}
		}
        for (int i = 0; i < stringB.length(); i++) {
        	Object object = map.get(stringB.charAt(i));
			if (object==null || (int)object==0) {
				return false;
			}else{
				map.put(stringB.charAt(i), (int)object-1);
			}
		}
        for(Integer integer: map.values()){
        	if (integer!=0) {
				return false;
			}
        }
        return true;
    }

}
