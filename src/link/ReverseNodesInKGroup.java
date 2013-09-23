package link;

public class ReverseNodesInKGroup {
	
	public static void main(String[] args) {
		int[] n = new int[]{1,2 ,3, 4,5,6,7};
	
		ReverseNodesInKGroup a = new ReverseNodesInKGroup();
		
		display(a.reverseKGroup(init(n), 3));
		
	}

	
	public ListNode reverseKGroup(ListNode head, int k) {
        
		if(k==1||head == null) return head; 
		ListNode end = head;
		
		for(int i=0;i<k-1;i++){
			
			end = end.next;
			if(end == null) return head;
		}
		
		ListNode pre = new ListNode(0);
		ListNode current = head;
		ListNode next = current.next;
				
		pre.next = current;
		
		for(int i=0;i<k-1;i++){
			pre = current;
			current = next;
			next = current.next;
			
			current.next = pre;
			
		}
        head.next = reverseKGroup(next, k);
		return end;
    }
	
	public static ListNode init(int[] num){
		
		if(num.length>0){
			ListNode l = new ListNode(num[0]);
			ListNode c = l;
			for(int i=1;i<num.length;i++){
				c.next = new ListNode(num[i]);
				c = c.next;
			}
			return l;
		}
		else {
			return null;
		}
		
	}
	
	public static void display(ListNode l){
		if(l == null){
			System.out.println("NULL ListNode");
		}
		
		else{
			System.out.print("[");
			while(l.next!=null){
				System.out.print(l.val+" ");
				l = l.next;
			}
			System.out.println(l.val + "]");
		}
	}
	
}
