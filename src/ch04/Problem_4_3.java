package ch04;

public class Problem_4_3 {
	private Node buildBST_aux(int[] s, int i, int j){
		if(j<i)
			return null;
		int m = (i+j)/2;		
		Node root = new Node(s[m]);
		Node left = buildBST_aux(s,i,m-1);
		Node right = buildBST_aux(s,m+1,j);
		root.left = left;
		root.right = right;

		return root;
	}
	public Node buildBST(int[] s){
		return buildBST_aux(s,0,s.length-1);
	}
	public static void main(String[] args){
    	BinaryTree bt = new BinaryTree();
		Problem_4_3 pb = new Problem_4_3();
		Node root = pb.buildBST(new int[]{1,2,3,4,5});
		System.out.println(root.value);
     	bt.traversal(root, "pre");
		
	}

}
