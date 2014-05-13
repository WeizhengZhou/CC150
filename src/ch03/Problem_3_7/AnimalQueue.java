package ch03.Problem_3_7;

import java.util.LinkedList;
public class AnimalQueue {
	private int nextId = 1;
	private LinkedList<Animal> dog = new LinkedList<Animal>();
	private LinkedList<Animal> cat = new LinkedList<Animal>();
	
	public void enqueue(Animal a){
		a.setId(this.nextId++);
		if(a instanceof Dog)
			dog.add(a);
		else
			cat.add(a);
		System.out.println("Enqueued : name = " + a.getName() + "  id = " + a.getId());
	}
	public Animal dequeueDog(){
		return dog.remove();
	}
	public Animal dequeueCat(){
		return cat.remove();
	}
	public Animal dequeueAny(){
		if(dog.isEmpty())
			return cat.remove();
		else if(cat.isEmpty())
			return dog.remove();	
		else{
			Dog aDog = (Dog) dog.peekFirst();
			Cat aCat = (Cat) cat.peekFirst();
			if(aDog.getId() < aCat.getId())
				return dog.remove();
			else 
				return cat.remove();			
		}
	}

}
