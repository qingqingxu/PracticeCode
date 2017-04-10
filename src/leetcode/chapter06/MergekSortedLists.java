package leetcode.chapter06;


public class MergekSortedLists {

	public static void main(String[] args) {
		
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		/*if(lists==null||lists.length==0)
	        return null;
	 
	    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
	        public int compare(ListNode l1, ListNode l2){
	            return l1.val - l2.val;
	        }
	    });
	 
	    ListNode head = new ListNode(0);
	    ListNode p = head;
	 
	    for(ListNode list: lists){
	        if(list!=null)
	            queue.offer(list);
	    }    
	 
	    while(!queue.isEmpty()){
	        ListNode n = queue.poll();
	        p.next = n;
	        p=p.next;
	 
	        if(n.next!=null)
	            queue.offer(n.next);
	    }    
	 
	    return head.next;*/
		//TOL
		if (lists.length==0) {
			return null;
		}
        ListNode p = lists[0];
        for (int i = 1; i < lists.length; i++) {
			p = mergeTwoLists(p, lists[i]);
		}
        return p;
    }
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode listNode = null;

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		listNode = new MergekSortedLists().new ListNode(-1);
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
		if (l1 != null) {
			tmpNode.next = l1;
		}
		if (l2 != null) {
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
