package ch02;

import java.util.Stack;

public class Problem_2_7 {
	private Node clone(Node n){
		Node head = null;
		Node tail = null;
		while(n != null){
			Node t = new Node(n.value);
			if(head == null){
				head = t;
				tail = t;
			}
			else{
				tail.next = t;
				tail = t;
			}
			n = n.next;
		}		
		return head;
	}
	private Node reverse(Node cur){
		Node head = null;//the head of reversed list
		Node next = null;
			
		while(cur != null){
			next = cur.next;//store the next node
			cur.next = head;//
			head = cur;//new head = cur node
			cur = next;//move cur node to next node
		}
    	return head;
		
	}
	public boolean isPalindrome_reverse(Node head){
		//need to clone this list first, otherwise the original list is reversed
		Node clone = this.clone(head);
		System.out.print("Cloned list: ");
		Node.print(clone);	
			
		Node reverse = this.reverse(clone);
	    System.out.print("Reverse list: ");
	    Node.print(reverse);
	    
		while(head != null && reverse != null){
			if(head.value != reverse.value)
				return false;
			head = head.next;
			reverse = reverse.next;
		}
		return true;		
	}
	
	public boolean isPalindrome_Stack(Node head){
		Node slow = head;
		Node fast = head;
		Stack<Integer> s = new Stack<Integer>();
		while(fast != null && fast.next != null){
			s.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;	
		}
		//indicating odd number of nodes
		//therefore skip the middle node
		//Note fast.next == null not work, since fast maybe null
		if(fast != null)
			slow = slow.next;
		while(slow != null){
			int value = s.pop();
			if(slow.value != value)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	private class Result{
		Node left = null;
		boolean isPalindrome = false;
		public Result(Node aLeft, boolean aIsPalindrome){
			this.left = aLeft;
			this.isPalindrome = aIsPalindrome;
		}
	}
	private Result isPalindrome_recusive_aux(Node curLeft, Node curRight, Result curResult){
		//base case
		if(curRight.next == null){
			if(curResult.left.value == curRight.value)
				//left node should move one step rigthward
				return new Result(curResult.left.next,true);
			else
				return new Result(curResult.left.next,false);
		}
		//recursive case
		else{			
			//recursive call to next level
			Result nextResult = isPalindrome_recusive_aux(curLeft,//left not change
					        curRight.next, new Result(curLeft,false));//right should move one step
			//if next level is a palindrome
			if(nextResult.isPalindrome == true){
				//and current pair is the same
				if(nextResult.left.value == curRight.value)
					//new result object with left node move right
					return new Result(nextResult.left.next,true);
				else
					return new Result(nextResult.left.next,false);
			}
			else
				//else return false
				return new Result(nextResult.left.next,false);			
		}
		
	}
	public boolean isPalindrome_recusive(Node head){
		
		Result result = isPalindrome_recusive_aux(head,
		        head, new Result(head,false));
		return result.isPalindrome;
	}
    
//	public void test(Node n){
//		System.out.println("Before clone, the n.value = " + n.value);
//		Node c = this.clone(n);
//		System.out.println("After clone, the n.value = " + n.value);	
//		
//		System.out.println("Before reverse, the n.value = " + n.value);
//		Node r = this.reverse(n);
//		System.out.println("After reverse, the n.value = " + n.value);	
//		
//		Node.print(c);
//		Node.print(r);
//	}
	
	public static void main(String[] args){
//		Node n = Node.create(new int[]{1,2,3,2,1});
//		Node n = Node.create(new int[]{1,2,3,1});
		Node n = Node.create(new int[]{1,3});
		
		Problem_2_7 prob = new Problem_2_7();

//    	System.out.println(prob.isPalindrome_reverse(n));
//		System.out.println(prob.isPalindrome_Stack(n));
//		System.out.println(prob.isPalindrome_recusive(n));
		
//		prob.test(n);
		
		
	}

}
