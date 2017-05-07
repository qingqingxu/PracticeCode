package nowcode.interview.test;

import java.util.LinkedList;
import java.util.Queue;

public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(6);
		ListNode second = new ListNode(2);
		
		head.next = second;
		second.next = new ListNode(8);
		head = partition(head, 9);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode partition(ListNode pHead, int x) {
		if(pHead==null||pHead.next==null){
            return pHead;
        }
		Queue<ListNode> lower = new LinkedList<>();
		Queue<ListNode> upper = new LinkedList<>();
		while(pHead!=null){
			if(pHead.val<x){
				lower.offer(pHead);
			}else {
				upper.offer(pHead);
			}
			pHead = pHead.next;
			
		}
		ListNode tmp = null;
		while(!lower.isEmpty()){
			if (tmp==null) {
				tmp = lower.poll();
				pHead = tmp;
			}else{
				tmp.next = lower.poll();
				tmp = tmp.next;
			}
			
		}
		while(!upper.isEmpty()){
			if (tmp==null) {
				tmp = upper.poll();
				pHead = tmp;
			}else{
				tmp.next = upper.poll();
				tmp = tmp.next;
			}
		}
		tmp.next = null;
		return pHead;	
	}

}
