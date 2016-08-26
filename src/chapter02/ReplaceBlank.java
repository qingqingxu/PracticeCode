package chapter02;

public class ReplaceBlank {

	public static void main(String[] args) {
		char str[] = new char[100];
		char strTmp[] = "I am a  girl, and  you    !    ".toCharArray(); 
		int len = strTmp.length;
		System.arraycopy(strTmp, 0, str, 0, len);
		int blankNum = 0;
		for (int i = 0; i < len; i++) {
			if (str[i] == ' ') {
				blankNum++;
			}
		}
		for (int i = len-1; i >=0; i--) {
			if (str[i] == ' ') {
				str[i+blankNum*2]='0';
				str[i+blankNum*2-1]='2';
				str[i+blankNum*2-2]='%';
				blankNum--;
			}else {
				str[i+blankNum*2]=str[i];
			}
			if (blankNum==0) {
				break;
			}
		}
		System.out.println("I am a  girl, and  you    !    ");
		System.out.println(str);
	}

}
