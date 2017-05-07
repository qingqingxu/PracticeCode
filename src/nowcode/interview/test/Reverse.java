package nowcode.interview.test;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("This is nowcoder"));
	}

	public static String reverseString(String iniString) {
        // write code here
        StringBuffer buffer = new StringBuffer();
        for (int i = iniString.length()-1; i >=0;  i--) {
			buffer.append(iniString.charAt(i));
		}
        return buffer.toString();
    }
}
