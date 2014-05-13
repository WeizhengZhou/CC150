package ch04;

import java.util.LinkedList;
import java.util.Stack;
public class BinaryTree {
	private Node root = null;
	
	public Node getRoot(){
		return root;
	}

	public BinaryTree(){
		
	}
	
	//build a binary tree based on string s
	public BinaryTree(String[] s){	
		LinkedList<Node> curLevel = new LinkedList<Node>();
		LinkedList<Node> nextLevel = new LinkedList<Node>();
		
		root = new Node(Integer.parseInt(s[0]));
		//we insert two parent nodes for both children
		curLevel.add(root);
		curLevel.add(root);
		
		//is current a left child or not		
		boolean isLeft = true;
		
		for(int i=1;i<s.length;i++){	
			//get current parent node
			Node n = curLevel.remove();
			if(s[i].equals("#")){//if current child is empty
				//add two empty parent to nextLevel
				nextLevel.add(new NIL(0));
				nextLevel.add(new NIL(0));
			}
			else if(n instanceof NIL){//if parent is empty, but child is not empty
				System.out.println("Wrong input string : the paraent of " + s[i] + " is NIL.");
				System.exit(0);
			}
			else{//both are not empty
				Node child = new Node(Integer.parseInt(s[i]));//new child node
			    if(isLeft){//if current child is left child
			    	n.left = child;
			    }
			    else{
			    	n.right = child;
			    }
			   nextLevel.add(child);
			   nextLevel.add(child);
			}
			//remember to reverse isLeft
			isLeft = !isLeft;
			
			//curLevel is empty, swap curLevel and nextLevel
			if(curLevel.isEmpty()){
				curLevel = (LinkedList<Node>)nextLevel.clone();
				nextLevel.clear();		
			}
		}
	}
	public Node assignParent(Node root){
		if(root != null){
			if(root.left != null)
				root.left.parent = root;
			if(root.right != null)
				root.right.parent = root;
			assignParent(root.left);
			assignParent(root.right);
		}	
		return root;
	}

	private void preOrder_aux(Node r){
		if(r != null){
			System.out.print(r.value + ", ");
			preOrder_aux(r.left);
			preOrder_aux(r.right);
		}
	}
	private void inOrder_aux(Node r){
		if(r != null){
			inOrder_aux(r.left);
			System.out.print(r.value + ", ");
			inOrder_aux(r.right);
		}
	}
	private void postOrder_aux(Node r){
		if(r != null){
			postOrder_aux(r.left);
			postOrder_aux(r.right);
			System.out.print(r.value + ", ");
		}
	}
	public void traversal(Node r, String mode){
		
		if(mode.equals("pre")){
			 System.out.print("pre order = [");
			 preOrder_aux(r);
		}
		else if(mode.equals("in")){
			System.out.print("in order = [");
			inOrder_aux(r);	 	
		}
		else if(mode.equals("post")){
			System.out.print("pos order = [");
			postOrder_aux(r);		
		}
		else
			System.out.println("Wrong mode");
		System.out.println("]");
	}
	public void preOrder_iterate(Node r){
		Stack<Node> s = new Stack<Node>();
		System.out.print("pre order = [");	
		
		Node node = r;		
		while(!s.isEmpty() || node != null){
			if(node != null){			
			     System.out.print(node.value + ", ");
			     s.push(node);
			     node = node.left;
			}
			else{
				node = s.pop();
				node = node.right;
			}
		}
		System.out.println("]");
	}
	public void inOrder_iterate(Node r){
		Stack<Node> s = new Stack<Node>();
		System.out.print("in order = [");	
		
		Node node = r;
		
		while(!s.isEmpty() || node != null){
			if(node != null){					     
			     s.push(node);
			     node = node.left;
			}
			else{				
				node = s.pop();
				System.out.print(node.value + ", ");
				node = node.right;
			}
		}
		System.out.println("]");
	}
	public void postOrder_iterate(Node r){
		Stack<Node> s = new Stack<Node>();
		System.out.print("post order = [");
		Node node = r;
		Node lastVisited = null;
		while(!s.isEmpty() || node != null){
			if (node != null){
				s.push(node);
				node = node.left;
			}
			else{
				Node peek = s.peek();
				if(peek.right != null && lastVisited != peek.right){
					node = peek.right;
				}
				else{
					s.pop();
					System.out.print(peek.value + ", ");	
					lastVisited = peek;
				}			
			}
		}
		System.out.println("]");
	}
	public int height(Node root){
		if(root == null) return -1;
		else
			return Math.max(height(root.left), height(root.right)) + 1;
	}
	public static void main(String[] args){
		String[] s = new String[]{"1","2","3","#","4","5","6","#","#","#","7"};
		BinaryTree bt = new BinaryTree(s);
		Node root = bt.getRoot();
		
		bt.traversal(root,"pre");
		bt.traversal(root,"in");
		bt.traversal(root,"post");
		
		bt.preOrder_iterate(root);
		bt.inOrder_iterate(root);
		bt.postOrder_iterate(root);
		
		System.out.println("The height of the tree is " + bt.height(root));
				
	}
	

}
