package link;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		int[] n1 = new int[]{};
		
		SwapNodesinPairs a = new SwapNodesinPairs();
		
		display(a.swapPairs(init(n1)));
	}
	
    public ListNode swapPairs(ListNode head) {
    	if(head == null) return null;
    	
    	ListNode preNode = new ListNode(0);
        ListNode curNode = head;
        ListNode nextNode = curNode.next;
        
        
        if(nextNode!=null) head = nextNode;
        
        while(nextNode!=null){
        	
        	curNode.next = nextNode.next;
        	nextNode.next = curNode;
        	preNode.next = nextNode;
        	
        	if(curNode.next == null) break;
        	else{
        		preNode = curNode;
        		curNode = curNode.next;
        		nextNode = curNode.next;
        	}
        }
        
        return head;
        
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
