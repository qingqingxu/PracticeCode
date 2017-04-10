package leetcode.chapter03;

public class CountandSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countAndSay(5));
	}

	public static String countAndSay(int n) {
		String str = "1";
		for (int i = 1; i < n; i++) {
			str = convert(str);
		}
		return str;
	}
	
	public static String convert(String str){
		char cstr[] = str.toCharArray();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < cstr.length; i++) {
			int num = 1;
			while (i+1<cstr.length&&cstr[i]==cstr[i+1]) {
				num++;
				i++;
			}
			buffer.append(num);
			buffer.append(cstr[i]);
		}
		return buffer.toString();
	}

}
