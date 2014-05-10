package ch02;

public class Problem_2_6 {
	public Node getEntrance(Node head){
		if(head == null || head.next == null) return null;
		
		Node slow = head.next;
		Node fast = head.next.next;
		
		while(slow !=null && fast.next != null && fast != slow){
			slow = slow.next;
			fast = fast.next.next;
		}
		if(slow == null || fast.next == null)
			return null;
		
		Node r1 = head;
		Node r2 = fast;
		System.out.println("OK");
		while(r1 != r2){
			r1 = r1.next;
			r2 = r2.next;
		}
		return r1;		
	}
	public void print(Node head, int max){
		int i=0;
		Node cur = head;
		while(i++<max){
			System.out.print(cur.value + " -> ");
			cur = cur.next;
		}
		System.out.println("");
	}
	public static void main(String[] args){
		//create a circular linked list
		Node head = Node.create(new int[]{1,2,3,4,5});
		Node tail = null;
		Node cur = head;
		while(cur.next != null){
			cur = cur.next;
		}
		tail = cur;
		tail.next = head.next;
	
		//print the list up to 10 elements
		Problem_2_6 prob = new Problem_2_6();
		prob.print(head, 10);
		
		Node entrance = prob.getEntrance(head);
		System.out.println("The value of the entrance node is " + entrance.value);
	}

}
