package leetcode.chapter06;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static ListNode insertionSortList(ListNode head) {
		if (head.next==null) {
			return null;
		}
        ListNode tail = new InsertionSortList().new ListNode(Integer.MAX_VALUE);
        tail.next = null;
        ListNode front = new InsertionSortList().new ListNode(Integer.MIN_VALUE);
        front.next = tail;
        ListNode point = front.next;
        while (head.next!=null) {
        	ListNode tmp = head.next;
			if (point.val>=tmp.val) {
				head = head.next;
				tmp.next = point;
				front.next = tmp;
			}else {
				point = point.next;
			}
		}
		return front;
    }

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
