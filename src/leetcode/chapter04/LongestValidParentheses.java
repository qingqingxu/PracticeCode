package leetcode.chapter04;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses( ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"));
	}

	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		boolean []bool = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			bool[i] = false;
			if (s.charAt(i)==')') {
				int tmp = i-1;
				while(tmp>=0){
					if (s.charAt(tmp)=='('&&!bool[tmp]) {
						bool[tmp] = true;
						bool[i] = true;
						break;
					}
					tmp--;
				}
			}
		}
		int maxValid = 0;
		int tmp = 0;
		for (int i = 0; i < bool.length; i++) {
			if (bool[i]) {
				tmp++;
			}else{
				if (tmp>maxValid) {
					maxValid = tmp;
					
				}
				tmp = 0;
			}
		}
		if (tmp>maxValid) {
			maxValid = tmp;
			tmp = 0;
		}
		return maxValid;
		/*Stack<Character> stack = new Stack<>();
		int maxValid = 0;
		int tmp = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.push(s.charAt(i));
				tmp++;
				break;
			case ')':
				if (!stack.isEmpty()&&stack.peek() == '(') {
					stack.pop();
					tmp++;
					break;
				} else {
					stack.clear();
					if (tmp>maxValid) {
						maxValid = tmp;
						tmp=0;
					}
				}
			default:
				break;
			}
		}
		if (!stack.isEmpty()) {
			tmp-=stack.size();
			stack.clear();
		}
		if (tmp>maxValid) {
			maxValid = tmp;
		}
		
		return maxValid;*/
	}

}
