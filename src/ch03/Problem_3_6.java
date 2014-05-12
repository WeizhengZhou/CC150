package ch03;

import java.util.Stack;

public class Problem_3_6 {
	public Stack<Integer> sort(Stack<Integer> s){
		for(int i=s.size();i>0;i--){
			sort_aux(s,new Stack<Integer>(),i);
			
		}
		return s;	
	}
	private void sort_aux(Stack<Integer> s, Stack<Integer> r, int n){
		//scan top n elements in s to find a minimum
		//pop these elements to r
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			int e = s.pop();
			min = Math.min(min,e);
			r.push(e);
		}
		//push current minimum to s
		s.push(min);
		//push back all other elements, be careful about duplicate minimum elements 
		
		boolean isOmitted = false;
		for(int i=0;i<n;i++){
			int e = r.pop();
			if(e != min || isOmitted)//this element is not min, or min is already omitted once
				s.push(e);
			else
				isOmitted = true;
		}
		print(s,r);
	}
	public void print(Stack<Integer> s, Stack<Integer> r){
		System.out.println(s + "   |   " + r);
		
	}
	public static void main(String[] args){
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		s.push(2);
		s = new Problem_3_6().sort(s);
			
	}

}
