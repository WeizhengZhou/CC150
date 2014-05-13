package ch03.Problem_3_7;

public abstract class Animal {
	private String name = null;
	private int id = 0;
	public Animal(String aName){
		this.name = aName;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
