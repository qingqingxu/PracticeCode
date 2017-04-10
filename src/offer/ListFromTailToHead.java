package offer;

import java.util.ArrayList;
import java.util.Stack;

public class ListFromTailToHead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode = new ListNode();
		ListNode listNode1 = new ListNode(1);
		listNode.next = listNode1;
		ListNode listNode2 = new ListNode(2);
		listNode1.next = listNode2;
		ListNode listNode3 = new ListNode(3);
		listNode2.next = listNode3;
		
		ArrayList<Integer> arrayList = printListFromTailToHead(listNode);
		for (Integer integer : arrayList) {
			System.out.println(integer);
		}
	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		if (listNode == null) {
			return arrayList;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			arrayList.add(stack.pop());
		}
		return arrayList;
	}

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	ListNode() {

	}
}
