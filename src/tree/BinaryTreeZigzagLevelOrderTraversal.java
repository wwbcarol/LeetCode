package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		ArrayList<ArrayList<Integer>> res = zigzagLevelOrder(root);
		for(ArrayList<Integer> list : res){
			for(Integer i : list){
				System.out.print(i+" ");
			}
			System.out.println("");
		}
 	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if(root==null) return res;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		queue.offer(root);
		level.offer(0);
		int pre = -1;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		boolean isorder = false;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			Integer l = level.poll();
			
			if(node.left!=null){
				queue.offer(node.left);
				level.offer(l+1);
			}
			if(node.right!=null){
				queue.offer(node.right);
				level.offer(l+1);
			}
			
			if(l!=pre){
				if(tmp.size()>0){
					res.add(new ArrayList<Integer>(tmp));
					tmp.clear();
				}
				isorder = !isorder;
				pre = l;
			}
			
			if(isorder)tmp.add(node.val);
			else tmp.add(0, node.val);
			if(queue.size()==0) res.add(tmp);
		}
		
        return res;
    }
}
