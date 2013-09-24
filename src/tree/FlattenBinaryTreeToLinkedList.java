package tree;


public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList a = new FlattenBinaryTreeToLinkedList();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;
		n5.right = n6;

		a.flatten(n1);
		

		while(n1!=null){
			System.out.print(n1.val+" ");
			n1 = n1.right;
		}
		System.out.println("");
	}
	
	public void flatten(TreeNode root) {
		
		if(root!=null){
			flatten(root.right);
			if(root.left != null){
				flatten(root.left);
				TreeNode RightMost = root.left;
				while(RightMost.right!=null){
					RightMost = RightMost.right;
				}
				
				RightMost.right = root.right;
				root.right = root.left;
				root.left = null;
			}
		}
		
	}

}
