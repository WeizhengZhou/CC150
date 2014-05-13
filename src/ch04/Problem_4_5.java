package ch04;

public class Problem_4_5 {
	public int min(Node root){
		if(root == null) return Integer.MAX_VALUE;
		else if(root.left == null)
			return root.value;
		else 
			return min(root.left);
	}
	public int max(Node root){
		if(root == null) return Integer.MIN_VALUE;
		else if(root.right == null)
			return root.value;
		else 
			return max(root.right);
	}
	public boolean isBST(Node root){
		if(root == null)
			return true;
		else{
			if(!isBST(root.left))
				return false;
			if(!isBST(root.right))
				return false;
			if(max(root.left) > root.value || min(root.right) < root.value)
				return false;
			return true;		
		}
	}
	public static void main(String[] args){
		String[] s = new String[]{"4","2","6","1","#","5","8"};
		BinaryTree bt = new BinaryTree(s);
		Node root = bt.getRoot();
		Problem_4_5 prob = new Problem_4_5();
		System.out.println(prob.isBST(root));
	}
	

}
