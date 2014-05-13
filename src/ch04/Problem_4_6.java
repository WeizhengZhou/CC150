package ch04;

public class Problem_4_6 {
	
	public int min(Node root){
		if(root == null) return Integer.MAX_VALUE;
		else if(root.left == null)
			return root.value;
		else 
			return min(root.left);
	}
	
	public int next(Node n){	
		if(n.right != null)
			return min(n.right);
		
	    while(n.parent != null){
	    	if(n == n.parent.left)
	    		return n.parent.value;
	    	n = n.parent;			
		}
	    System.out.println("No next value, current node is maximum");
	    return Integer.MAX_VALUE;		
	}
	
	public static void main(String[] args){
		String[] s = new String[]{"6","3","8","1","5","7","9","#","2","4"};
		BinaryTree bt = new BinaryTree(s);
		Node root = bt.assignParent(bt.getRoot());
		Problem_4_6 prob = new Problem_4_6();
		System.out.println(new Problem_4_5().isBST(root));
		
		Node c = root.left.right.left;
		c= root.left.left;
		System.out.print("Next to " + c.value + " = ");		
		System.out.println(prob.next(c));
	}

}
