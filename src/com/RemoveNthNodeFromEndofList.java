package com;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		ListNode point = new ListNode(2);
		ListNode three = new ListNode(3);
		head.next = point;
		point.next = three;
		three.next = null; 
		head = removeNthFromEnd(head, 2);
		
		while (head!=null) {
			System.out.print (head.val);
			head = head.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0 || (head.next==null&&n>1)) {
			return head;
		}
		ListNode point = head;
		ListNode endPoint = head.next;
		if (endPoint==null&&n==1) {
			return null;
		}
		int i;
		for (i = 1; i < n; i++) {
			if (endPoint.next!=null) {
				endPoint = endPoint.next;
			}else if(endPoint.next ==null&&i<n-1){
				return head;
			}
		}
		while(endPoint.next!=null){
			endPoint = endPoint.next;
			point = point.next;
		}
		
		System.out.println(point.val+"   "+endPoint.val);
		
		if (n==1) {
			point.next = null;
		}else if (point==head&&(i==n)) {
			head = head.next;
		}else{
			point.next = point.next.next;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}