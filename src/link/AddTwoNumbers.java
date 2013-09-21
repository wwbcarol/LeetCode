package link;

import java.awt.geom.Line2D;

//Definition for singly-linked list.
 class ListNode {
	 int val;
     ListNode next;
     ListNode(int x) {
    	 val = x;
    	 next = null;
    }
 }
 
public class AddTwoNumbers {

	
	 
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		 ListNode c1 = l1;
		 ListNode c2 = l2;
		 ListNode result = new ListNode(0);
		 ListNode c = result;
		 int carry = 0;
	
		 while(c1!=null||c2!=null||carry!=0){
			 c.next = new ListNode(0);
			 c = c.next;
			 int n1 = (c1==null?0:c1.val);
			 int n2 = (c2==null?0:c2.val);
			 c.val = (n1+n2+carry)%10;
			 carry = (n1+n2+carry)/10;
			 c1 = (c1==null?null:c1.next);
			 c2 = (c2==null?null:c2.next);
		 }
		 
		 return result.next;
	 }
	
	 public static void main(String[] args) {
		 int[] n1 = new int[]{5,2,3};
		 int[] n2 = new int[]{0,1};
		ListNode l1 = init(n1);
		ListNode l2 = init(n2);
		display(l1);
		display(l2);
		display(addTwoNumbers(l1, l2));
	}
	 
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
