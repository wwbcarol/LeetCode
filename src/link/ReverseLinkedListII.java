package link;

public class ReverseLinkedListII {
	
	public static void main(String[] args) {
		int[] n1 = new int[]{1,2,3,4,5};
		
		ReverseLinkedListII a = new ReverseLinkedListII();
		
		display(a.reverseBetween(init(n1), 1, 5));
	}
	
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        
		ListNode start = new ListNode(0);
		if(m==1){
			start.next = head;
		}else{
			start = head;
			for(int i=0;i<m-2;i++)
				start = start.next;
		}
		ListNode pre = start;
		ListNode current = start.next;
		ListNode next = current.next;
		
//		System.out.println("(" + pre.val + "," + current.val + "," + next.val
//				+ ")");
		for(int i=m;i<n;i++){
			pre = current;
			current = next;
			next = current.next;
			
			current.next = pre;
//			System.out.println("(" + pre.val + "," + current.val + "," + next.val
//					+ ")");
		}
		
		start.next.next = next;
		start.next = current;
		
		if(m==1)return start.next;
		else return head;
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
