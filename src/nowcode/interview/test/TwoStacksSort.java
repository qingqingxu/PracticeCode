package nowcode.interview.test;

import java.util.ArrayList;
import java.util.Stack;

public class TwoStacksSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {54695,46580,6418,52304,5595,5149,51943,11454,23596,6444,61037};
		twoStacksSort(numbers);
	}
	
	public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
		Stack<Integer> stack1 = new Stack<>();
		for (int i = numbers.length-1; i >= 0; i--) {
			stack1.push(numbers[i]);
		}
		Stack<Integer> stack2 = new Stack<>();
		for (int i = 0; i < numbers.length; i++) {
			int tmp = numbers.length-i;
			int min = stack1.pop();
			while (tmp>1) {
				int tmp0 = stack1.pop();
				if (min <= tmp0) {
					stack2.push(tmp0);
				}else{
					stack2.push(min);
					min = tmp0;
				}
				tmp--;
			}
			stack1.push(min);
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
		}
		ArrayList<Integer> array = new ArrayList<>();
		while (!stack1.isEmpty()) {
			//System.out.println(stack1.peek());
			array.add(stack1.pop());
			
		}
		return array;
    }
	
}
