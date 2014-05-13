package ch04;

public class Problem_4_1 {
	//method one
	public boolean isBalanced(Node root){
		if(root == null) return true;
		Node left = root.left;
		Node right = root.right;
		
		boolean isLeftBal = isBalanced(left);
		boolean isRightBal = isBalanced(right);
		
		int leftHeight = height(left);
		int rightHeight = height(right);
		
		
		return isLeftBal && isRightBal 
			   && Math.abs(leftHeight - rightHeight) <= 1; 
	}
	private int height(Node root){
		if(root == null) return -1;
		else
			return Math.max(height(root.left), height(root.right)) + 1;
	}
	//method two, which is quicker
	private int checkHeight(Node root){
		if(root == null) return 0;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1)
			return -1;
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1)
			return -1;
		if(Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight,rightHeight) + 1;
		
	}
	public boolean isBalanced_quick(Node root){
		if(checkHeight(root) == -1)
			return false;
		else 
			return true;
	}
	
	
	public static void main(String[] args){
		String[] s = new String[]{"1","2","3","#","4","5","6","#","#","#","7","7"};
		BinaryTree bt = new BinaryTree(s);
		Node root = bt.getRoot();
		Problem_4_1 pb = new Problem_4_1();
		
		System.out.println("Is balanced tree : " + pb.isBalanced(root));

		System.out.println("Is balanced tree : " + pb.isBalanced_quick(root));
		
	}
}
