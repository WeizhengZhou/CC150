package ch03;

public class MyStack {
	private int capacity = 0;
	private int[] stack = null;
	private int top = 0;
	
	public MyStack(int aCapacity){
		this.capacity = aCapacity;
		this.stack = new int[capacity];
		this.top = -1;
		
	}
	public void push(int e){
		if((top +1) > capacity-1)
			this.resize();  
		this.stack[++top] = e;		
	}
	public int pop(){
		if(top < 0){
			System.out.println("Error Pop, Empty Stack !");
			return 0;
		}
		else
			return this.stack[top--];		
	}
	public void resize(){
		this.capacity *= 2;
		int[] newStack = new int[this.capacity];
		for(int i=0;i<=this.top;i++){
			newStack[i] = this.stack[i];
		}
		this.stack = newStack;
		
	}
	public boolean isEmpty(){
		return top<0;
	}
	public int size(){
		return top+1;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<=top;i++){
			sb.append(stack[i]+",");
		}
		sb.append("]");
		return sb.toString();
	}
	public void describe(){
		System.out.println(this.isEmpty() + " " + this.capacity + " " +  this.size() + " " + this.toString());	
	}
	
	public static void main(String[] args){
		MyStack stack = new MyStack(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.describe();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.describe();
		
		for(int i =1;i<=8;i++){
			stack.push(i);
			stack.describe();
		}
		for(int i =1;i<=9;i++){
			stack.pop();
			stack.describe();
		}
//		stack.pop();		
	}

}
