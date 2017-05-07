package nowcode.interview.test;

import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(3);
		ListNode second = new ListNode(1);
		
		head.next = second;
		
		ListNode third = new ListNode(1);
		second.next = third;
		third.next = new ListNode(3);
		System.out.println(isPalindrome(head));
	}
	
	public static boolean isPalindrome(ListNode pHead) {
        // write code here
        if(pHead==null){
            return false;
        }
        if(pHead.next==null){
            return true;
        }
        if(pHead.next.next==null){
            if(pHead.val==pHead.next.val){
                return true;
            }else{
                return false;
            }
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode signal = pHead;
        ListNode dou = pHead.next;
        while(dou!=null){
        	stack.push(signal);
        	dou = dou.next;
        	if (dou!=null) {
        		signal = signal.next;
				dou = dou.next;
			}
        }
        signal = signal.next;
        boolean is = true;
        while(!stack.isEmpty()){
        	if (signal.val!=stack.pop().val) {
				is = false;
				break;
			}
        	signal = signal.next;
        }
        if (signal!=null) {
			is = false;
		}
        
        return is;
        
    }

}
