package ch02;

public class Problem_2_2 {
	public Node kthToLast_FastAndSlow(Node head, int k){
		Node fast = head;
		Node slow = head;
		int i = 0;
		while(fast != null){
			if(i>k)
				slow=slow.next;
			i++;
			fast=fast.next;
		}
		return slow;		
	}
	private int getSequentialIndex(Node head, int k){
		// zeroth to last is the last elements, i.e. the nth elements in sequence 
		int n = 0;
		while(head != null){
			n++;
			head = head.next;
		}
		return n - k;
	}
	public Node kthToLast_sequential(Node head, int k){
		int targetIndex = this.getSequentialIndex(head, k);	
		int i = 1;
		while(i < targetIndex){
			i++;
			head = head.next;
		}
		return head;
	}
	public static void main(String[] args){
		Node head = Node.create(new int[]{1,2,3,4});
		int k = 0;
//		Node res = new Problem_2_2().kthToLast_sequential(head, k);
		Node res = new Problem_2_2().kthToLast_FastAndSlow(head, k);
		System.out.println(res.value);		
	}

}
