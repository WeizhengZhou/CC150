package ch03;

import java.util.Stack;

public class Problem_3_4 {
	
	public void Hanoi(Stack<Integer> s, Stack<Integer> i, Stack<Integer> d, int n){
		if(n==1)
			d.push(s.pop());//base case
		else{
			Hanoi(s,d,i,n-1);//move n-1 plates from source to inter
			d.push(s.pop());//move plate n from source to d
			Hanoi(i,s,d,n-1);//move n-1 plates from inter to dest
		}
	}

	
	public void print(Stack<Integer> s, Stack<Integer> i, Stack<Integer> d, int n){
		System.out.println(n + " " + s + " " + i + " " + d);
	}
	public static void main(String[] args){
		Stack<Integer> s = new Stack<Integer>();//source
		Stack<Integer> i = new Stack<Integer>();//Intermediate
		Stack<Integer> d = new Stack<Integer>();//destination
		
		int max = 4;
		for(int k=0;k<max;k++){
			s.push(max - k);
		}
				
		Problem_3_4 prob = new Problem_3_4();	
		prob.Hanoi(s, i, d, max);
		prob.print(s, i, d, max);
	}

}
