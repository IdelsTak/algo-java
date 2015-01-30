
package t04_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class E2_CheckRoute {
	/*
	Solution 1
	*/
	boolean search_1(Graph g, Td n1, Td n2){
		if(n1 == n2) return true;
		if(n1 == null || n2 == null) return false;
		
		Stack<Td> stack = new Stack<>();
		n1.setVisited();
		stack.push(n1);
		while(!stack.isEmpty()){
			Td curr = stack.peek();
			Td next = g.getNextUnvisitedAjacent(curr);
			if(null == next){
				stack.pop();
			}else{
				if(next == n2) return true;
				next.setVisited();
				stack.push(next);
			}
		}
		return false;
	}
	
	/*
	Solution 2
	*/
	boolean search_2(Graph g, Td n1, Td n2){
		Queue<Td> q = new LinkedList<>();
		n1.setVisited();
		q.add(n1);
		while(!q.isEmpty()){
			Td curr = q.remove();
			if(curr != null){
				Td next = g.getNextUnvisitedAjacent(curr);
				while( next != null){
					if(n2 == next){
						return true;
					}else{
						next.setVisited();
						q.add(next);
					}
				}//while
			}//if
		}//while		
		return false;
	}
	
	@Test
	public void test(){
		Graph g = Graph.createTestGraph();
		g.setRootNode('A');
		g.setDestNode('F');
		assertTrue("A F is connected", search_1(g, g.root, g.dest));
	}
}
