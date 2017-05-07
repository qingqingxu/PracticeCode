package nowcode;

import java.util.ArrayList;
import java.util.Collections;

public class FindCoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String string : "CoderCoder".split("Coder")) {
			System.out.println(string);
		}
	}
	
	public static String[] findCoder(String[] A, int n) {
        // write code here
		ArrayList<MyString> myStrings = new ArrayList<>();
		int count;
		for (int i = 0; i < n; i++) {
			String lower = A[i].toLowerCase();
			count = (lower.length()-lower.replace("coder", "").length())/5;
			myStrings.add(new MyString(A[i], count));
		}
		Collections.sort(myStrings);
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = myStrings.get(i).str;
		}
		return a;
    }

}

class MyString implements Comparable<MyString>{
	String str;
	int count = 0;
	
	public MyString(String str, int count) {
		this.str = str;
		this.count = count;
	}

	@Override
	public int compareTo(MyString o) {
		// TODO Auto-generated method stub
		//从小到大
		return count - o.count;
	}
	
}