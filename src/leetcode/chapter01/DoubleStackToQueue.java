package leetcode.chapter01;

import java.util.Stack;

/**
 * 由两个栈组成的队列
 * @author XuQingQing
 *
 */
public class DoubleStackToQueue {

	class MyQueue{
		Stack<Integer> stack1;
		//辅助栈
		Stack<Integer> stack2;
		
		public MyQueue(){
			stack1 = new Stack<>();
			stack2 = new Stack<>();
		}
		
		public void offer(int newNum){
			if(!stack2.isEmpty()){
				while (!stack2.isEmpty()) {
					stack1.push(stack2.pop());
				}
			}
			stack1.push(newNum);
		}
		
		public int peek(){
			if (!stack1.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				return stack2.peek();
			}else if (!stack2.isEmpty()) {
				return stack2.peek();
			}else {
				throw new RuntimeException("Queue is Empty!");
			}
			
		}
		
		public int poll(){
			if (!stack1.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				return stack2.pop();
			}else if (!stack2.isEmpty()) {
				return stack2.pop();
			}else {
				throw new RuntimeException("Queue is Empty!");
			}
		}
	}
	
	public static void main(String[] args) {
		MyQueue myQueue = new DoubleStackToQueue().new MyQueue();
		
		myQueue.offer(1);
		myQueue.offer(2);
		myQueue.offer(3);
		myQueue.offer(4);
		
		System.out.println(myQueue.poll());
		System.out.println(myQueue.peek());
		System.out.println(myQueue.poll());
		System.out.println(myQueue.peek());
		
	}

}
