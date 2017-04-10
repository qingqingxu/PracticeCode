package leetcode.chapter04;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
			case '{':
			case '[':
				stack.push(s.charAt(i));
				break;
			case ')':
				
				if (!stack.isEmpty()&&stack.peek() == '(') {
					stack.pop();
					break;
				} else {
					return false;
				}
			case '}':
				if (!stack.isEmpty()&&stack.peek() == '{') {
					stack.pop();
					break;
				} else {
					return false;
				}
			case ']':
				if (!stack.isEmpty()&&stack.peek() == '[') {
					stack.pop();
					continue;
				} else {
					return false;
				}
			default:
				return false;
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
