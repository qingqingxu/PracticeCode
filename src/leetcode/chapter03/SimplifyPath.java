package leetcode.chapter03;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/abc/..."));
	}

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < path.length(); i++) {
			switch (path.charAt(i)) {
			case '/':
				if (stack.isEmpty()||!stack.peek().equals("/")) {
					if (buffer.toString().equals("..")) {
						if (stack.size()>0) {
							stack.pop();
						}
						buffer.setLength(0);
						continue;
					}else if (buffer.toString().equals(".")) {
						buffer.setLength(0);
						continue;
					}else if(buffer.length()!=0){
						stack.push(buffer.toString());
					}
					buffer.setLength(0);
				}
				break;
				//. other charactor
			default:
				buffer.append(path.charAt(i)+"");
				break;
			}
		}
		if (buffer.toString().equals("..")) {
			if (stack.size()>0) {
				stack.pop();
			}
			buffer.setLength(0);
		}else if (buffer.toString().equals(".")) {
			buffer.setLength(0);
		}else if(buffer.length()!=0){
			stack.push(buffer.toString());
		}
		buffer.setLength(0);
		if (stack.isEmpty()) {
			return "/";
		}
		
		String string = "";
		while(!stack.isEmpty()){
			string = "/"+stack.pop()+string;
		}
		return string;
	}

}
