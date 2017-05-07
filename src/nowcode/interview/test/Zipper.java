package nowcode.interview.test;

public class Zipper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(zipString("qwertyuioplkjhgfdsAzxcvbNM"));
	}
	public static String zipString(String iniString) {
        // write code here
        StringBuffer buffer = new StringBuffer();
        int tmp = 1;
        char ch = iniString.charAt(0);
        for(int i=1; i<iniString.length(); i++){
            if(ch!=iniString.charAt(i)){
                buffer.append(ch);
                buffer.append(tmp);
                tmp = 1;
                ch = iniString.charAt(i);
            }else{
                tmp++;
            }
        }
        buffer.append(ch);
        buffer.append(tmp);
        return buffer.length()>=iniString.length()? iniString:buffer.toString();
    }

}
