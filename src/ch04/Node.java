package ch04;

public class Node {
	Node left = null;
	Node right = null;
	Node parent = null;
	int value = 0;
	public Node(int v){
		this.value = v;
		this.left = null;
		this.right = null;
	}
}
