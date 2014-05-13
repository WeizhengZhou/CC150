package ch04;

public class Problem_4_7 {
	public boolean contains(Node r, Node n){
		if(r == null)
			return false;
		else if(r == n)
			return true;
		else
			return contains(r.left,n) || contains(r.right,n);
	}
	public Node firstCommonAncestor(Node r, Node n, Node m){
		boolean nInLeft = contains(r.left,n);
		boolean mInLeft = contains(r.left,m);
		
		if(nInLeft != mInLeft)
			return r;
		else if(nInLeft)
			return firstCommonAncestor(r.left,n,m);
		else
			return firstCommonAncestor(r.right,m,n);
	}
	public Node firstAncestor_bad(Node r, Node n, Node m){
		if(r == null) return null;
		if(r == n || r == m) return r;
		Node x = firstAncestor_bad(r.left,n,m);
		Node y = firstAncestor_bad(r.right,n,m);
		if(x == null && y == null)
			return null;
		else if(x == null)
			return y;
		else if(y == null)
			return x;
		else 
			return r;
	}
	
	public static void main(String[] args){
		String[] s = new String[]{"4","2","6","1","#","5","8"};
		BinaryTree bt = new BinaryTree(s);
		Node root = bt.getRoot();
		Problem_4_7 prob = new Problem_4_7();
		Node m = root.right.left;
		Node n = root.right.right;
		
		System.out.println(prob.firstCommonAncestor(root,m,n).value);
		
		m = root.left.left;
		n = root.right.right;
//		Node c = new Node(7);
		System.out.println(prob.firstAncestor_bad(root,m,n).value);
	}

}
