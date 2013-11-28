package tree;



//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//} 
 

public class Solution {

	
	
//	static Integer min = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		Solution a = new Solution();
		System.out.println(a.isValidBST(root));
	}
	TreeNode min;
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        
        if(min==null) min = new TreeNode(root.val);
        else if(root.val<=min.val) return false;
        else min.val = root.val;
        
        if(!isValidBST(root.right)) return false;
        
        return true;
    }
}
