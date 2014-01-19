package tree;

import java.util.ArrayList;


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}


public class PopulatingNextRightPointersInEachNodeII {
	
	public static void main(String[] args) {
		TreeLinkNode a2 = new TreeLinkNode(2);
		TreeLinkNode b1 = new TreeLinkNode(1);
		TreeLinkNode b3 = new TreeLinkNode(3);
		TreeLinkNode c0 = new TreeLinkNode(0);
		TreeLinkNode c7 = new TreeLinkNode(7);
		TreeLinkNode c9 = new TreeLinkNode(9);
		TreeLinkNode c1 = new TreeLinkNode(1);
		TreeLinkNode d2 = new TreeLinkNode(2);
		TreeLinkNode d1 = new TreeLinkNode(1);
		TreeLinkNode d0 = new TreeLinkNode(0);
		TreeLinkNode d81 = new TreeLinkNode(8);
		TreeLinkNode d82 = new TreeLinkNode(8);
		TreeLinkNode e7 = new TreeLinkNode(7);
		a2.left = b1;
		a2.right = b3;
		b1.left = c0;
		b1.right = c7;
		b3.left = c9;
		b3.right = c1;
		
		c0.left = d2;
		c7.left = d1;
		c7.right = d0;
		c1.left = d81;
		c1.right = d82;
		d0.left = e7;
		
		PopulatingNextRightPointersInEachNodeII a = new PopulatingNextRightPointersInEachNodeII();
		a.connect(a2);
		System.out.println("");
	}
	
	    public void connect(TreeLinkNode root) {
	        
	    	ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
	    	list.add(root);
	    	
	    	while(list.size()>0){
	    		TreeLinkNode node = list.get(0);
	    		connectHelp(node);
	    		list.remove(0);
	    		if(node.left!=null)list.add(node.left);
	    		if(node.right!=null)list.add(node.right);
	    		
	    	}
	        
	    }
	    
	    public static void connectHelp(TreeLinkNode root){
	    	if(root!=null&&(root.left!=null||root.right!=null)){
	            if(root.left!=null){
	                if(root.right!=null){
	                    root.left.next = root.right;
	                }else{
	                    root.left.next = findSibling(root);
	                }
	            }
	            
	            if(root.right!=null){
	                root.right.next = findSibling(root);
	            }
	        }
	    }
	    
	    public static TreeLinkNode findSibling(TreeLinkNode root){
	        if(root.next == null) return null;
	        else{
	            if(root.next.left!=null) return root.next.left;
	            else if(root.next.right!=null) return root.next.right;
	            else return findSibling(root.next);
	        }
	    }

}
