package ch03;

public class Problem_3_2{

	private int[] stack = new int[10];
	private int[] min = new int[10];
	private int top = -1;
	
	public void push(int e){
		if(top == -1)
			min[top+1] = e;
		else
			min[top+1] = Math.min(min[top], e);
		
		stack[top+1] = e;
		top++;

	}
	public int pop(){
		if(top < 0){
			System.out.println("Error Pop, Empty Stack !");
			return 0;
		}
		else{
			int e =  this.stack[top--];				
			return e;
		}
	}
	public int min(){
		if(top >=0)
		    return min[top];
		else{
			System.out.println("Empty Stack !");
			return 0;
		}		
	}
	
	public void print(){
		StringBuilder sb = new StringBuilder();
		sb.append("stack = [");
		for(int i=0;i<=top;i++){
			sb.append(stack[i]+",");
		}
		sb.append("]");
		System.out.println(sb.toString());
		
		StringBuilder sm = new StringBuilder();
		sm.append("min   = [");
		for(int i=0;i<=top;i++){
			sm.append(min[i]+",");
		}
		sm.append("]");
		System.out.println(sm.toString());
	}
	public static void main(String[] args){
		Problem_3_2 stack = new Problem_3_2();
		stack.push(4);
		stack.push(2);
		stack.push(1);
		stack.push(3);
		
		stack.print();
		
		stack.pop();
		stack.print();
		
		stack.pop();
		stack.print();
		
		stack.pop();
		stack.print();
			
	}
		

}
