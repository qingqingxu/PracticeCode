package com;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * Subscribe to see which companies asked this question
 * 
 * Show Tags Show Similar Problems
 * 
 * @author XuQingQing
 *
 */
public class SwapNodesinPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		ListNode point = new ListNode(2);
		ListNode three = new ListNode(3);
		head.next = point;
		point.next = three;
		three.next = null; 
		head = swapPairs(head);
		
		while (head!=null) {
			System.out.print (head.val);
			head = head.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {

		if (head==null||head.next==null) {
			return head;
		}
		ListNode p = head, q = head.next, tmp = q.next;
		if (tmp==null||tmp.next==null) {
			q.next = p;
			p.next = tmp;
			head = q;
			return head;
		}
		p.next = q.next;
		q.next = p;
		head = q;
		q = p.next;
		ListNode node = q.next;
		
		do {
			q.next = node.next;
			node.next = q;
			p.next = node;
			if (q.next==null||q.next.next==null) {
				break;
			}
			p = q;
			q = q.next;
			node = q.next;
		} while (true);
		return head;
	}

}
