package leetcode.chapter03;

public class StrIsNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(CHARACTOR.SIGN.ordinal());
		
		
	}

	/**
	 * 0初始无输入或者只有space的状态 
	 * 1输入了数字之后的状态 
	 * 2前面无数字，只输入了dot的状态 
	 * 3输入了符号状态 
	 * 4前面有数字和有dot的状态
	 * 5'e' or 'E'输入后的状态 
	 * 6输入e之后输入Sign的状态 
	 * 7输入e后输入数字的状态
	 * 8前面有有效数输入之后，输入space的状态
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s) {
		int transTable[][] = {  
		        //0INVA,1SPA,2SIG,3DI,4DO,5E  
		            {-1,  0,  3,  1,  2, -1},//0初始无输入或者只有space的状态  
		            {-1,  8, -1,  1,  4,  5},//1输入了数字之后的状态  
		            {-1, -1, -1,  4, -1, -1},//2前面无数字，只输入了Dot的状态  
		            {-1, -1, -1,  1,  2, -1},//3输入了符号状态  
		            {-1,  8, -1,  4, -1,  5},//4前面有数字和有dot的状态  
		            {-1, -1,  6,  7, -1, -1},//5'e' or 'E'输入后的状态  
		            {-1, -1, -1,  7, -1, -1},//6输入e之后输入Sign的状态  
		            {-1,  8, -1,  7, -1, -1},//7输入e后输入数字的状态  
		            {-1,  8, -1, -1, -1, -1}//8前面有有效数输入之后，输入space的状态  
		        }; 
		
		int state = 0;
		int i = 0;
		int inputtype = CHARACTOR.INVALID.ordinal();
		while (i<s.length()) {
			inputtype = CHARACTOR.INVALID.ordinal();
			if (s.charAt(i)==' ') {
				inputtype = CHARACTOR.SPACE.ordinal();
			}
			else if (s.charAt(i)=='+'||s.charAt(i)=='-') {
				inputtype = CHARACTOR.SIGN.ordinal();
			}
			else if (s.charAt(i)>='0'&&s.charAt(i)<='9') {
				inputtype = CHARACTOR.DIGIT.ordinal();
			}
			else if (s.charAt(i)=='.') {
				inputtype = CHARACTOR.DOT.ordinal();
			}
			else if (s.charAt(i)=='e'||s.charAt(i)=='E') {
				inputtype = CHARACTOR.EXPONENT.ordinal();
			}
			if (state==-1) {
				return false;
			}
			state = transTable[state][inputtype];
			i++;
		}
		
		return state == 1 || state == 4 || state == 7 || state == 8; 
	}

	enum CHARACTOR {
		INVALID, // 0 Include: Alphas, '(', '&' ans so on
		SPACE, // 1
		SIGN, // 2 '+','-'
		DIGIT, // 3 numbers
		DOT, // 4 '.'
		EXPONENT, // 5 'e' 'E'
	}

}
