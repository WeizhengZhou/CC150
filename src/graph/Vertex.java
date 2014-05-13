package graph;

import java.util.ArrayList;
import java.util.List;
public class Vertex {
	
	String name = null;
	boolean isVisited = false;
	int distance = 0;
	int discover = 0;
	int finish = 0;
	
	List<Vertex> neighbors = new ArrayList<Vertex>();
	public Vertex(String aName){
		name = aName;
	}
	
	public void addEdge(Vertex v){
		neighbors.add(v);
	}
	
}
