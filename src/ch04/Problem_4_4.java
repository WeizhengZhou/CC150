package ch04;

import java.util.LinkedList;

public class Problem_4_4 {
	public LinkedList<LinkedList<Node>> levelTraversal(Node n){
		
		LinkedList<LinkedList<Node>> levelList = new LinkedList();

		LinkedList<Node> curLevel = new LinkedList();
		LinkedList<Node> nextLevel = new LinkedList();
			
		curLevel.add(n);
		levelList.add((LinkedList<Node>) curLevel.clone());
			
		while(!curLevel.isEmpty()){
			Node curNode = curLevel.remove();
			if(curNode.left != null)
				nextLevel.add(curNode.left);
			if(curNode.right != null)
				nextLevel.add(curNode.right);
				
			if(curLevel.isEmpty() && !nextLevel.isEmpty()){						    
				levelList.add((LinkedList<Node>) nextLevel.clone());			    
			    curLevel = (LinkedList<Node>) nextLevel.clone();
			    nextLevel.clear();
			}
		}
		return levelList;	
	}
	public void print(LinkedList<Node> level){
		for(Node n:level){
			System.out.print(n.value + ", ");
		}
		System.out.println();	
	}
	public static void main(String[] args){
		String[] s = new String[]{"1","2","3","#","4","5","6","#","#","#","7"};
		BinaryTree bt = new BinaryTree(s);
		Node root = bt.getRoot();
		Problem_4_4 prob = new Problem_4_4();
		LinkedList<LinkedList<Node>> levelList = prob.levelTraversal(root);
			
		for(int i=0;i<levelList.size();i++){
			System.out.print("Level " + (i+1) + " :   ");
			prob.print((LinkedList<Node>) levelList.get(i));
		}	
	}
	


}
