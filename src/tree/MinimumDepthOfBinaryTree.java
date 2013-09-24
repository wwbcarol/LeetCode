package tree;

public class MinimumDepthOfBinaryTree {
	
	public int minDepth(TreeNode root) {
	       return inorder(root, 1);
	    }
	    
	    public int inorder(TreeNode root, int n){
	        if(root == null) return 0;
	        if(root.left == null && root.right == null){
	            return n;
	        }else{
	            int left = inorder(root.left, n+1);
	            int right = inorder(root.right, n+1);
	            if(left == 0) return right;
	            else if(right == 0) return left;
	            else return Math.min(left, right);
	        }
	    }

}
