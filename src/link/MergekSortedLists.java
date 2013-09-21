package link;

import java.util.ArrayList;

public class MergekSortedLists {

	public static void main(String[] args) {
		MergekSortedLists a = new MergekSortedLists();
		int[] n1 = new int[]{2};
		int[] n2 = new int[]{1,3,5};
		int[] n3 = new int[]{-2,0,2,8,15};
		
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		list.add(init(n1));
		list.add(init(n2));
		list.add(init(n3));
		ListNode r = a.mergeKLists(list);
		
		if(r!=null)
			display(r);
		else {
			System.out.println("null");
		}
	}
	public ListNode mergeKLists(ArrayList<ListNode> lists) {    
        
		while(lists.size()>1){
			for(int i=0;i<lists.size()/2;i++){
				lists.add(mergeTwoLists(lists.get(0), lists.get(1)));
				lists.remove(0);
				lists.remove(0);
			}
		}
		
		if(lists.size()==1)
			return lists.get(0);
		else
			return null;
    }
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		
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
