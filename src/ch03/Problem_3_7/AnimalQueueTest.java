package ch03.Problem_3_7;

public class AnimalQueueTest {
	public static void main(String[] args){
		AnimalQueue q = new AnimalQueue();
		q.enqueue(new Cat("c1"));
		q.enqueue(new Cat("c2"));
		q.enqueue(new Dog("d1"));
		q.enqueue(new Cat("c3"));
		q.enqueue(new Dog("d2"));
		q.enqueue(new Dog("d3"));
	
		System.out.println(q.dequeueCat().getName());
		
		System.out.println(q.dequeueAny().getName());
		System.out.println(q.dequeueAny().getName());
		System.out.println(q.dequeueDog().getName());
		
		
	}

}
