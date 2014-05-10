package ch02;

public class Problem_2_5 {
	public Node add_1(Node a, Node b){
		
		Node resHead = null;
		Node resTail = null;
		
		int carry = 0;
		while(a != null && b != null){		
			int value = a.value + b.value + carry;
			Node n = new Node(value%10);
			if(resHead == null){
				resHead = n;				
				resTail = n;
			}
			else{			
				resTail.next = n;		
				resTail = n;
			}
			carry = value >= 10 ? 1 : 0;

			a = a.next;
			b = b.next;
		}
		//the left list
		Node c = null;
		if(a != null)
			c = a;
		else 
			c = b;		
		while(c != null){		
			int value = c.value + carry;
			Node n = new Node(value%10);
			if(resHead == null){
				//it is possible a or b is empty
				resHead = n;
				resTail = n;
			}
			else{			
				resTail.next = n;
				resTail = n;
			}			
			carry = value >= 10 ? 1 : 0;
			c = c.next;
		}
        //last possible nonzero carry
		if(carry == 1){
			Node n = new Node(1);
			resTail.next = n;
			resTail = n;
		}
		
		return resHead;
	}
	public static void main(String[] args){
		Node a = Node.create(new int[]{7,1,6});
		Node b = Node.create(new int[]{5,9,2});
		Node d = new Problem_2_5().add_1(a, b);
		Node.print(d);
	}

}
