/* 
Solutions to http://www.careercup.com/question?id=5988741646647296
 Given a undirected graph with corresponding edges. Find the number of possible triangles?
 Example:
 0 1
 2 1
 0 2
 4 1


 Answer:
 1
 */

package google_interview;


//import edu.princeton.cs.algs4.Graph;
//import edu.princeton.cs.introcs.In;

public class E40325_findTriangles {//TODO: No optional solutions

/*    
	//O(N*N*N*N) select any three points, and check for trianble
	static class Sol_1_BruteForce{}

	//O(E*N*N)  select each edge: (a b), a<b, select c>b, check for connectivity)
	static class Sol_2_BruteForce2{//<editor-fold defaultstate="collapsed" desc="comment">
		static int count(Graph g){
			int n=0;
			int N = g.V();
			for(int i = 0; i<N; i++)
				for(int j : g.adj(i))
					if(j>i)
						for(int k = j+1; k<g.V(); k++)
							if(isConnected(g, i, k) && isConnected(g, j, k))
								n++;
			return n;
		}

		static private boolean isConnected(Graph g, int i, int j){
			for(int k:g.adj(i))
				if(k==j) return true;
			return false;
		}
	}//</editor-fold>

	public static void main(String[] arg){
		//In in = new In("/mediumG.txt");
		In in = new In("/tinyG.txt");
		Graph g = new Graph(in);
		System.out.printf("Vectors: %d\n", g.V());
		System.out.println(Sol_2_BruteForce2.count(g));
	}
*/
}
