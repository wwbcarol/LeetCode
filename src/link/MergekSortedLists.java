package link;

import java.util.ArrayList;

public class MergekSortedLists {

	public static void main(String[] args) {
		MergekSortedLists a = new MergekSortedLists();
		int[] n1 = new int[]{2};
		int[] n2 = new int[]{1,3,5};
		
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		list.add(init(n1));
		list.add(init(n2));
		ListNode r = a.mergeKLists(list);
		
		if(r!=null)
			display(r);
		else {
			System.out.println("null");
		}
	}
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
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
