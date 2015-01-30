/*
Solutions to http://www.careercup.com/question?id=5138832865361920

 Draw a graph as a graph. 
 Assume there is graphics library to draw lines and all. Just tell 
 how will you order the vertices such that the edges don't intersect and they seem ordered.
 */

package google_interview;

import butil.Graph;
import java.util.LinkedList;

/**

 */
public class E40518_DrawGraph_NotIntersect {
	public void drawGraph_DFS(Graph.Node<Character> root, Graph<Character> g) {
		if (null == root) {
			return;
		}
		if (Graph.State.visited == root.state) {
			return;
		}
		g.draw(root);
		root.state = Graph.State.visited;

		for (Graph.Node<Character> n : root.adjNodes) {
			g.drawLine(root, n);
			drawGraph_DFS(root, g);
		}
	}

	public void drawGraph_BFS(Graph.Node<Character> root, Graph<Character> g) {
		if (null == root) {
			return;
		}
		LinkedList<Graph.Node<Character>> queue = new LinkedList<>();
		root.state = Graph.State.visited;
		queue.addLast(root);
		g.draw(root);
		while (!queue.isEmpty()) {
			Graph.Node<Character> n0 = queue.removeFirst();
			for (Graph.Node<Character> n1 : n0.adjNodes) {
				//draw
				if (n1.state != Graph.State.visited) {
					g.draw(n1);
					g.drawLine(n0, n1);
					queue.addLast(n1);
				}
			}
			n0.state = Graph.State.visited;
		}
	}

}
