package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Graph {
	List<Vertex> vertexList = new ArrayList<Vertex>();
	
	public Graph(String[] s, int[][] m){
		int n = s.length;
		
		if(m.length != n || m[0].length != n){
			System.out.println("Dimension does not match, exit!");
			System.exit(0);
		}
			
		for(int i=0;i<s.length;i++){
			vertexList.add(new Vertex(s[i]));
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(m[i][j] == 1){
					Vertex u = vertexList.get(i);
					Vertex v = vertexList.get(j);
					u.addEdge(v);
				}
			}
		}
	}
	public List<Vertex> getVerties(){
		return vertexList;
	}
	public void print(){
		for(Vertex u : vertexList){
			System.out.print(u.name + ": [");
			for(Vertex v : u.neighbors){
				System.out.print(v.name + ", ");
			}
			System.out.println("]");
		}
	}

	public void bfs(Vertex s){		
		for(Vertex v : vertexList){	
			v.distance = Integer.MAX_VALUE;	
			v.isVisited = false;
		}
		s.distance = 0;
		
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		queue.add(s);
		while(!queue.isEmpty()){
			Vertex v = queue.remove();
			for(Vertex u : v.neighbors){
				if(!u.isVisited){
					u.distance = v.distance + 1;
					queue.add(u);
				}
			}
			v.isVisited = true;
		}
		
		System.out.println("distance from " + s.name + " to ");
		for(Vertex u:vertexList){
			System.out.println(u.name + " : " + u.distance);
		}
	}
	public boolean isPath(Vertex s, Vertex t){
		this.bfs(s);
		if(t.distance != Integer.MAX_VALUE)
			return true;
		else 
			return false;		
	}
	public void dfs(){
		for(Vertex u : vertexList){
			u.distance = Integer.MAX_VALUE;
			u.isVisited = false;
		}
		int time = 0;
		for(Vertex u : vertexList){
			if(!u.isVisited){
				dfs_aux(u,time);
			}
		}
		
		for(Vertex u:vertexList){
			System.out.println(u.name + ", d = " + u.discover + ", f = " + u.finish);
		}
		
	}
	public int dfs_aux(Vertex u, int time){
		u.isVisited = true;		
		time++;
		u.discover = time;
		for(Vertex v : u.neighbors){
			if(!v.isVisited){
				time = dfs_aux(v,time);
			}
		}
		time++;
		u.finish = time;	
		return time;		
	}
	
	
	public static void main(String[] args){
		String[] s = new String[]{"a","b","c","d"};
//		int[][] m = {{0,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,1,0}};
		int[][] m = {{0,1,0,0},{0,0,1,0},{0,0,0,1},{1,0,0,0}};
		Graph g = new Graph(s,m);
		List<Vertex> vertexList = g.getVerties();
		g.print();
//		g.bfs(vertexList.get(1));
		g.dfs();
		
	}

}
