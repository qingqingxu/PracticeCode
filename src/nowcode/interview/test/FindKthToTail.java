package nowcode.interview.test;

public class FindKthToTail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		
		head.next = second;
		second.next = new ListNode(3);
		System.out.println(findKthToTail(head, 3).val);
	}
	
	public static ListNode findKthToTail(ListNode head,int k) {
		if (head==null || k<1) {
			return null;
		}
		ListNode pre = head;
		ListNode now = head.next;
		while(k>1&&now!=null){
			now = now.next;
			k--;
		}
		if (k>1&&now==null) {
			return null;
		}
		while(now!=null){
			pre = pre.next;
			now = now.next;
		}
		
		return pre;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}