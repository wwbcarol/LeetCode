package tree;

import java.util.ArrayList;

//Definition for binary tree
class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
public class BinaryTreeInorderTraversal {

	

	public static void main(String[] args) {
		BinaryTreeInorderTraversal a = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		ArrayList<Integer> r = a.inorderTraversal(root);
		for(int i=0;i<r.size();i++){
			System.out.print(r.get(i));
		}
		System.out.println("");
	}
//	/** Recursion */
//	public ArrayList<Integer> inorderTraversal(TreeNode root) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		if (root == null)
//			return new ArrayList<Integer>();
//		else {
//			list.addAll(inorderTraversal(root.left));
//            list.add(root.val);
//            list.addAll(inorderTraversal(root.right));
//		}
//		return list;
//	}
	
	/** Iteration version*/
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		
		if(root != null){
			TreeNode node = root;
			while(nodes.size()>0||node!=null){
				
				while(node!=null){
					nodes.add(node);
					list.add(node.val);
					node = node.left;
				}
				
				node = nodes.get(nodes.size()-1);
				nodes.remove(nodes.size()-1);
//				list.add(node.val);
				node = node.right;
				
				
			}
		}
		
		return list;
	}
	
}
