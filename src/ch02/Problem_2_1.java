package ch02;

import java.util.Hashtable;

public class Problem_2_1 {
	public Node remove_Hashtable(Node head){
		if (head == null) return null;
		
		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		
		Node cur = head;
		Node pre = null;
		
		while(cur != null){			
			if(ht.containsKey(cur.value))
				//if duplicate, remove cur
				pre.next = cur.next;
			else{
				//else, put cur to ht,and update pre
				ht.put(cur.value, 1);	
				pre = cur;
			}
			cur = cur.next;	
		}
        return head;
	}
	public Node remove_iterate(Node head){
		Node watcher = head;		
		Node runner = null;
		Node preRunner = null;
		
	    while(watcher.next != null){
	    	runner = watcher.next;
	    	preRunner = watcher;
	    	while(runner != null){
	    		if(runner.value == watcher.value)
	    			preRunner.next = runner.next;
	    		else
	    			preRunner = runner;
	    		runner = runner.next;    		
	    	}  
	    	watcher = watcher.next;
	    }
	    return head;
	}
	public static void main(String[] args){
		Node head = Node.create(new int[]{1,4,3,4,2,3,1});
//		Node res = new Problem_2_1().remove_Hashtable(head);
		Node res = new Problem_2_1().remove_iterate(head);
		Node.print(res);		
	}

}
