package link;

public class RemoveNthNodeFromEndofList {
	
	public static void main(String[] args) {
		RemoveNthNodeFromEndofList a = new RemoveNthNodeFromEndofList();
		int[] n = new int[]{1, 2, 3, 4, 5};
		ListNode l = init(n);
		ListNode r = a.removeNthFromEnd(l, 5);
		
		display(r);
		
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n){
		
		int count = 0;
		ListNode curNode = head;
		
		while(count<n-1){
			curNode = curNode.next;
			count++;
		}
		
		ListNode lastNode = head;
		ListNode removeNode = head;
		while(curNode.next!=null){
			curNode = curNode.next;
			lastNode = removeNode;
			removeNode = removeNode.next;
		}
		
		if(lastNode == removeNode){
			return head.next;
		}
		else{
			lastNode.next = lastNode.next.next;
			return head;
		}
	}
//	public ListNode removeNthFromEnd(ListNode head, int n) {
//       
//		int num = 0;
//		ListNode curNode = head;
//		while(curNode!=null){
//			num++;
//			curNode = curNode.next;
//		}
//		
//		int count = 0;
//		curNode = head;
//		while(count<num-n-1){
//			count++;
//			curNode = curNode.next;
//		}
//		if(n == num) return head.next;
//		
//		curNode.next = curNode.next.next;
//		
//		return head;
//        
//    }
	
	public static ListNode init(int[] num){
		ListNode l = new ListNode(num[0]);
		ListNode c = l;
		for(int i=1;i<num.length;i++){
			c.next = new ListNode(num[i]);
			c = c.next;
		}
		return l;
	}
	
	public static void display(ListNode l){
		System.out.print("[");
		while(l.next!=null){
			System.out.print(l.val+" ");
			l = l.next;
		}
		System.out.println(l.val + "]");
	}
}
