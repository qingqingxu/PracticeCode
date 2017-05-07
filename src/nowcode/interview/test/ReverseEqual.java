package nowcode.interview.test;

public class ReverseEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkReverseEqual("ookvnorsiwwddjkpqasgbqjqrgsyriuxsruxidwprrxagjxzbwwgztsgndyfoelcgfzqzxzximtdwjlkhouxqrdzdguhxweqkvqabcltywygpbgeprmhbltnhkhynvpuszoqdrspwldgecrbvzsiywkfzphczpxyeyzhdhnegmodldikwnjhlwer",
				"sgndyfoelcgfzqzxzximtdwjlkhouxqrdzdguhxweqkvqabcltywygpbgeprmhbltnhkhynvpuszoqdrspwldgecrbvzsiywkfzphczpxyeyzhdhnegmodldikwnjhlwerookvnorsiwwddjkpqasgbqjqrgsyriuxsruxidwprrxagjxzbwwgzt"));
	}

	public static boolean checkReverseEqual(String s1, String s2) {
        // write code here
		int val = 0;
		int s1Index = 0;
		boolean is = true;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i)==s2.charAt(val)) {
				val++;
				if (val==1) {
					s1Index = i;
					is = true;
				}
			}else{
				val=0;
				s1Index = 0;
				is = false;
			}
		}
		if (val!=0&&val==s1.length()-s1Index) {
			for (int i = 0; i < s1Index; i++) {
				if (s1.charAt(i)!=s2.charAt(val++)) {
					is = false;
					break;
				}

			}
		}
		if (val != s2.length()) {
			is = false;
		}
		return is;
    }
}
