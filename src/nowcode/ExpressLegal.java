package nowcode;

import java.util.Scanner;
import java.util.Stack;

//有问题
public class ExpressLegal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			Stack<String> digit = new Stack<>();
			StringBuffer buffer = new StringBuffer();
			char ch;
			boolean isHasOperator = false;
			boolean isLegal = true;
			int len = str.length();
			int i = 0;
			while(i<len){
				ch = str.charAt(i);
				switch (ch) {
				case '[':
				case '{':
				case '(':
				case '+':
				case '-':
				case '*':
				case '/':
					digit.push(ch+"");
					i++;
					break;
				case ']':
				case '}':
				case ')':
					String second = null;
					while(digit.size()>1){
						//!digit.peek().equals("{")&&!digit.peek().equals("[")&&!digit.peek().equals("(")
						if(!digit.peek().equals("{")&&!digit.peek().equals("[")&&!digit.peek().equals("(")&&!digit.peek().equals(")")
								&&!digit.peek().equals("]")&&!digit.peek().equals("}")&&!digit.peek().equals("+")&&!digit.peek().equals("-")&&!digit.peek().equals("*")&&!digit.peek().equals("/")){
							second = digit.pop();
							if (digit.size()>0&&(digit.peek().equals("+")||digit.peek().equals("-")||digit.peek().equals("*")||digit.peek().equals("/"))) {
								isHasOperator = true;
								digit.pop();
								if (digit.size()>0) {
									second = digit.pop();
								}else {
									isLegal = false;
									break;
								}
								
							}
						}else {
							isLegal = false;
							break;
						}
						String first = digit.pop();
						if (digit.size()>0&&!digit.peek().equals("{")&&!digit.peek().equals("[")&&!digit.peek().equals("(")) {
							if (digit.peek().equals("+")||digit.peek().equals("-")||digit.peek().equals("*")||digit.peek().equals("/")) {
								isHasOperator = true;
								digit.pop();
								if (isHasOperator&&!digit.peek().equals("{")&&!digit.peek().equals("[")&&!digit.peek().equals("(")&&!digit.peek().equals(")")
										&&!digit.peek().equals("]")&&!digit.peek().equals("}")&&!digit.peek().equals("+")&&!digit.peek().equals("-")&&!digit.peek().equals("*")&&!digit.peek().equals("/")) {
									second = digit.pop();
									
								}
							}
						}
					}
					if (second==null) {
						isLegal = false;
						break;
					}else {
						digit.pop();
						digit.push(second);
					}
					
					i++;
					break;
				default:
					buffer.append(ch);
					i++;
					while(i<len&&ch!='+'&&ch!='-'&&ch!='*'&&ch!='/'&&ch!='['&&ch!='{'&&ch!='('&&ch!=')'&&ch!=']'&&ch!='}'){
						ch = str.charAt(i);
						buffer.append(ch);
						i++;
					}
					digit.push(buffer.toString());
					buffer.setLength(0);
					i++;
					break;
				}
				if (!isLegal) {
					break;
				}
			}
			if (digit.size()==1&&!digit.peek().equals("{")&&!digit.peek().equals("[")&&!digit.peek().equals("(")) {
				
			}else {
				isLegal = false;
			}
			System.out.println(isLegal);
		}
	}

}
