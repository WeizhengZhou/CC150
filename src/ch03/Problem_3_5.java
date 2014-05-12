package ch03;

import java.util.Stack;

public class Problem_3_5 {
	private Stack<Integer> s = new Stack<Integer>();//stack
	private Stack<Integer> r = new Stack<Integer>();//reverse stack
	
	public void enqueue(int e){
		s.push(e);
	}
	public int dequeue(){
		if(r.isEmpty()){
	        while(!s.isEmpty()){
				r.push(s.pop());
			}
		}
		return r.pop();		
	}
	public void print(){
		System.out.println(s + "  |   " + r);
	}
	
	public static void main(String[] args){
		Problem_3_5 prob = new Problem_3_5();
		for(int i=1;i<5;i++){
			prob.enqueue(i);
			prob.print();
		}
		prob.dequeue();
		prob.print();
		prob.dequeue();
		prob.print();
		
		prob.enqueue(5);	
		prob.print();
	}
}
