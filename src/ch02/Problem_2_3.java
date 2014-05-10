package ch02;

public class Problem_2_3 {
	public void deleteMiddle(Node n){
		if(n.next == null){
			System.out.println("This is the tail node, only works for the middle node!");
			System.exit(0);
		}
		
		while(n.next.next != null){
		    n.value = n.next.value;
			n=n.next;					
		}
		n.value = n.next.value;
		n.next=null;
	}
	public static void main(String[] args){
		Node head = Node.create(new int[]{1,2,3,4});
		Node target = head.next;
	    new Problem_2_3().deleteMiddle(target);
		Node.print(head);
	}


}
