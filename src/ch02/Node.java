package ch02;

public class Node {
	Node next = null;
	int value= 0;
	public Node(int v){
		this.value = v;
	}
	public static Node create(int[] m){
		Node head = null;
		Node tail = null;
		
		for(int i=0;i<m.length;i++){
			Node n = new Node(m[i]);
			if (i==0){
				head = n;
				tail = n;
			}
			else {
				tail.next = n;
				tail = n;
			}
		}
		return head;
	}

	public static void print(Node head){
		while(head != null){
			System.out.print(head.value + ", ");
			head=head.next;
		}
		System.out.println("");
	}
}
