package leetcode.chapter06;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode listNode = null;

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		listNode = new MergeTwoSortedLists().new ListNode(-1);
		ListNode tmpNode = listNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tmpNode.next = l1;
				tmpNode = l1;
				l1 = l1.next;
			} else {
				tmpNode.next = l2;
				tmpNode = l2;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			tmpNode.next = l1;
		}
		while (l2 != null) {
			tmpNode.next = l2;
		}

		return listNode.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
