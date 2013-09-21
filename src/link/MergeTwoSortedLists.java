package link;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		
		MergeTwoSortedLists a = new MergeTwoSortedLists();
		int[] n1 = new int[]{2};
		int[] n2 = new int[]{1,3,5};
		ListNode l1 = init(n1);
		ListNode l2 = init(n2);
		
		ListNode r = a.mergeTwoLists(l1, l2);
		
		if(r!=null)
			display(r);
		else {
			System.out.println("null");
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		
		ListNode r = new ListNode(0);
		ListNode head = r;
		while(l1 != null && l2 != null){
			if(l1.val<l2.val){
				r.next = l1;
        		l1 = l1.next;
        		r = r.next;
        	}else{
        		r.next = l2;
        		l2 = l2.next;
        		r = r.next;
        	}
		}
		
		if(l2!=null){
        	r.next = l2;
        }else if(l1!=null){
        	r.next = l1;
        }
        return head.next;
	}
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode c1 = l1;
//        ListNode c2 = l2;
//        ListNode r = new ListNode(0);
//        ListNode head = r;
//        while(c1!=null&&c2!=null){
//        	
////        	System.out.println("c1:" + c1.val + ", c2:" + c2.val);
//        	if(c1.val<c2.val){
//        		r.next = new ListNode(c1.val);
//        		c1 = c1.next;
//        		r = r.next;
//        	}else{
//        		r.next = new ListNode(c2.val);
//        		c2 = c2.next;
//        		r = r.next;
//        	}
////        	display(r);
//
//        }
//        
//        if(c2!=null){
//        	r.next = c2;
//        }else if(c1!=null){
//        	r.next = c1;
//        }
//        return head.next;
//    }
	
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
		System.out.print("[");
		while(l.next!=null){
			System.out.print(l.val+" ");
			l = l.next;
		}
		System.out.println(l.val + "]");
	}
}
