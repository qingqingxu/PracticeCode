package chapter01;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 * 递归返回并删除栈底元素
 * 每层递归取出栈底的元素并缓存到变量中，直到栈空；
 * 然后逆向将每层变量压入栈，最后实现原栈数据的逆序。
 * @author XuQingQing
 *
 */
public class InvertedStack {

	private Stack<Integer> stack;
	
	public InvertedStack(){
		stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
	}
	
	public int popBottom(){
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		}else{
			int bottom = popBottom();
			stack.push(result);
			return bottom;
		}
	}
	
	public void invertedStack(){
		if (stack.isEmpty()) {
			return;
		}
		int i = popBottom();
		invertedStack();
		stack.push(i);
	}
	
	public int peek(){
		return stack.peek();
	}
	
	public void display(){
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvertedStack invertedStack = new InvertedStack();
		//System.out.println(invertedStack.popBottom());
		invertedStack.invertedStack();
		invertedStack.display();
		
	}

}
