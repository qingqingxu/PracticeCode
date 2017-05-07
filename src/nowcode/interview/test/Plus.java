package nowcode.interview.test;

public class Plus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(6);
		ListNode second = new ListNode(2);
		
		head.next = second;
		second.next = new ListNode(8);
		ListNode node = new ListNode(0);
		head = plusAB(head, node);
		
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        int tmp = 0;
        ListNode head=null, lp = null;
        
        while(a!=null&&b!=null){
            
            if(head==null){
                head = new ListNode((a.val+b.val+tmp)%10);
                lp = head;
            }else{
                lp.next = new ListNode((a.val+b.val+tmp)%10);
                lp = lp.next;
            }
            tmp = (a.val+b.val+tmp)/10;
            
            a = a.next;
            b = b.next;
        }
        while(a!=null){
            a.val = (a.val+tmp)%10;
            tmp = (a.val +tmp)/10;
            lp.next = a;
            lp = a;
            a = a.next;
        }
        while(b!=null){
            b.val = (b.val+tmp)%10;
            tmp = (b.val +tmp)/10;
            lp.next = b;
            lp = b;
            b = b.next;
        }
        if(tmp!=0){
            lp.next = new ListNode(tmp);
        }
        return head;
    }

}
