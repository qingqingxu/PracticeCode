package leetcode.chapter03;

public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "Hello World!  ";
		System.out.println(lengthOfLastWord(string));
	}
	public static int lengthOfLastWord(String s) {
		int prenum = 0;
        int num = 0;
        if(s==null)
        	return 0;
        
		for(int i = 0; i<s.length();i++){
			if (s.charAt(i)==' '&&num!=0) {
				prenum = num;
				num=0;
			}else if (s.charAt(i)!=' ') {
				num++;
			}else{
				num=0;
			}
		}
		return num!=0?num:prenum;
    }
}
