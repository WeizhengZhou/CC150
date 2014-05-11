package ch03;
import java.util.ArrayList;
public class Problem_3_3 {
	private int stackSize = 5;
	private ArrayList<MyStack> setOfStacks = new ArrayList<MyStack>();
	private int topStack = -1;
	
	public void push(int e){
		if(topStack == -1){
			topStack = 0;
			MyStack stack = new MyStack(stackSize);
			stack.push(e);
			setOfStacks.add(stack);
		}
		else{
			MyStack stack = setOfStacks.remove(topStack);
			if(stack.size() == stackSize){
				setOfStacks.add(stack);
				MyStack newStack = new MyStack(stackSize);
				newStack.push(e);
				setOfStacks.add(newStack);
				topStack ++;
			}
			else{
				stack.push(e);
				setOfStacks.add(stack);			
			}
		}
	}
	
	public void pop(){
		if(topStack == -1){
			System.out.println("Empty set of stacks!");
		}
		else{
			MyStack stack = setOfStacks.remove(topStack);
			stack.pop();
			if(stack.isEmpty())
				topStack--;
			else
				setOfStacks.add(stack);
		}
	}
	public void popAt(int index){
		if(index < 0 || index > topStack)
			System.out.println("Wrong index to pop");
		
		MyStack stack = setOfStacks.remove(index);
		stack.pop();
		if(stack.isEmpty())
			topStack--;
		else
			setOfStacks.add(index,stack);
		
	}
	public void print(){
		System.out.println("------------------------------");
		for(int i=0;i<=topStack;i++){
			MyStack stack = setOfStacks.get(i);
			System.out.println("Stack_" + i + ": " + stack.toString());
		}
	}
	
	public static void main(String[] args){
		Problem_3_3 prob = new Problem_3_3();
		for(int i=0;i<5;i++){
			prob.push(10+i);
		}
		prob.print();
		for(int i=0;i<5;i++){
			prob.push(20+i);
		}
		prob.print();
		for(int i=0;i<2;i++){
			prob.popAt(0);
		}	
		prob.print();
		
	}

}
