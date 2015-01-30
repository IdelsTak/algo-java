/*
	use the test case from 
http://www.codeproject.com/Articles/32212/Introduction-to-Graph-with-Breadth-First-Search-BF
*/

package t04_Tree_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author andy
 */
public class Graph {
	ArrayList<Td> nodes = new ArrayList();;
	int size;
	int[][] matrix;

	Td root;
	Td dest;
	
	void clearVisited(){
		nodes.stream().forEach((n) -> {
			n.visited = false;
		});
	}
	
	void DFS(Td root){
		root.visited = true;
		int i = getNodeIndex(root);
		int len = matrix[i].length;
		for(int j = 0; j < len; j++){
			if(matrix[i][j]>0 && j != i){
				Td n = nodes.get(j);
				if(!n.visited) DFS(n);
			}
		}
	}
	
	//return next not visited ajacent
	Td getNextUnvisitedAjacent(Td node){
		int i = getNodeIndex(node);
		for(int j = 0; j < matrix.length; j++){
			if(matrix[i][j]>0 && j != i && !nodes.get(j).visited){
				return nodes.get(j);
			}
		}
		return null;
	}
	
	void DFS_stack(Td root){
		Stack<Td> stack = new Stack<>();
		root.setVisited();
		stack.push(root);
		while(!stack.isEmpty()){
			Td curr = stack.peek();
			Td next = getNextUnvisitedAjacent(curr);
			if(null != next){
				next.setVisited();
				stack.push(next);
			}else{
				stack.pop();
			}
		}
			
	}
	
	void BFS(Td root){
		Queue<Td> q = new LinkedList<>();
		root.setVisited();
		q.add(root);
		while(!q.isEmpty()){
			Td curr = q.peek();
			Td next = getNextUnvisitedAjacent(curr);			
			if(next == null){
				q.remove();
			}else{
				next.setVisited();
				q.add(next);
			}
		}
		
	}

	private int getNodeIndex(Td n) {
		return nodes.indexOf(n);
	}
	
	/*
	
	for testing
	
	*/
	static Graph createTestGraph(){
		Td nA=new Td('A');
		Td nB=new Td('B');
		Td nC=new Td('C');
		Td nD=new Td('D');
		Td nE=new Td('E');
		Td nF=new Td('F');

		//Create the graph, add nodes, create edges between nodes
		Graph g=new Graph();
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.setRootNode(nA);
		g.setDestNode(nF);
		
		g.connectNode(nA,nB);
		g.connectNode(nA,nC);
		g.connectNode(nA,nD);
		
		g.connectNode(nB,nE);
		g.connectNode(nB,nF);
		g.connectNode(nC,nF);		
		return g;
	}

	public void addNode(Td n) {
		nodes.add(n);
	}

	public void setRootNode(Td n) {
		this.root=n;
	}

	public void setRootNode(char ch){
		nodes.stream().filter((n) -> (n.data == ch)).forEach((n) -> {
			setRootNode(n);
		});
	}
	
	public void setDestNode(Td n) {
		this.dest = n;
	}
	

	public void setDestNode(char ch){
		nodes.stream().filter((n) -> (n.data == ch)).forEach((n) -> {
			setDestNode(n);
		});
	}

	public void connectNode(Td start, Td end) {
		if(matrix==null)
		{
			size=nodes.size();
			matrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
		matrix[startIndex][endIndex]=1;
		matrix[endIndex][startIndex]=1;		
	}
	
}
