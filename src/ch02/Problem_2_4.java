package ch02;

public class Problem_2_4 {
	public Node partition(Node n, int x){
		
		Node smallHead = null;
		Node smallTail = null;
		Node largeHead = null;
		Node largeTail = null;
		
		while(n != null){
			Node next = n.next;
			if(n.value < x){
				if(smallHead == null){
					smallHead = n;
					smallTail = n;
				}
				else{
					smallTail.next = n;
					smallTail = smallTail.next;
				}
				smallTail.next = null;
			}
			else{
				if(largeHead == null){
					largeHead = n;
					largeTail = n;
				}
				else{
					largeTail.next = n;
					largeTail = largeTail.next;
				}
				largeTail.next = null;
			}
			n = next;		
		}
		
		//Concatenate small with large
		smallTail.next = largeHead;
		return smallHead;
	}
	public static void main(String[] args){
		Node head = Node.create(new int[]{1,5,3,2,4,6,7});
		int x = 3;
	    Node res = new Problem_2_4().partition(head, x);
		Node.print(res);
	}

}
