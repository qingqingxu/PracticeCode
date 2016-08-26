package chapter01;

import java.util.Stack;

/**
 * 设计一个getMin的栈
 * @author XuQingQing
 *
 */
public class GetMinByStack {

	class MyStack{
		Stack<Integer> stackData;
		Stack<Integer> stackMin;
		
		public MyStack(){
			stackData = new Stack<>();
			stackMin = new Stack<>();
		}
		
		public void push(int newNum){
			if (stackMin.isEmpty()) {
				stackMin.push(newNum);
			}else if (newNum < stackMin.peek()) {
				stackMin.push(newNum);
			}else {
				int newMin = stackMin.peek();
				stackMin.push(newMin);
			}
			
			stackData.push(newNum);
		}
		
		public int pop(){
			if (stackData.isEmpty()) {
				throw new RuntimeException("stackData is Empty!");
			}
			
			stackMin.pop();
			return stackData.pop();
		}
		
		
		public int getMin(){
			if (stackMin.isEmpty()) {
				throw new RuntimeException("stackMin is Empty");
			}
			
			//peek返回栈顶元素，不删除
			return stackMin.peek();
		}
		
	}
	
	public static void main(String[] args) {
		MyStack stack = new GetMinByStack().new MyStack();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stack.push(4);
        int num = stack.pop();
        int min = stack.getMin();
        System.out.println(num + " " + min + "");
	}

}
