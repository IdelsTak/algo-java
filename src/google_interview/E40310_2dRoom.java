/*

 */

package google_interview;

import java.util.LinkedList;

public class E40310_2dRoom {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] arg){
		char[][] a;
		a = butil.MazeUtil.getMatrix("000 BGG B00");
		int M = a.length, N = a[0].length;
		butil.Print.matrix(a);
		Sol_1_BruteForce.run(a, M, N);

	}

	public static class Sol_1_BruteForce{//<editor-fold defaultstate="collapsed" desc="comment">
		static void run(char[][] a, int M, int N){
			System.out.println("Brute Force");
			run2(a, M, N);
			butil.Print.matrix(a);
		}

		private static void run2(char[][] a, int M, int N){
			boolean isChanged = true;
			do{
				isChanged = false;
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < N; j++) {
						if(a[i][j] == 'B' || a[i][j] == 'G' )	continue;
						char min = getMin(a, M, N, i, j);
						char aij = a[i][j];
						if(compare(aij, min)>1){
							a[i][j] = (char) (getInt(min) +1);
							isChanged = true;
						}
					}//for j
				}//for i
			}while(isChanged);
		}

		static char min(char a, char b){
			if(compare(a, b)>0) return b;
			else return a;
		}

		static int compare(char a, char b){
			return getInt(a) - getInt(b);
		}

		static int getInt(char a){
			if(a == 'G')
				return (int)'0';
			else if(a=='B')
				return Integer.MAX_VALUE;
			else if(a=='0')
				return Integer.MAX_VALUE/2;
			else
				return (int) a;
		}


		public static char getMin(char[][] a, int M, int N, int i, int j){
			char min = 'B';
			for(int k = 0; k<4; k++){
				char val = getVal(a, M, N, i + d[k][0], j+d[k][1]);
				min = min(min, val);
			}
			return min;
		}

		public static char getVal(char[][] a, int M, int N, int i, int j){
			if(i<0 || j<0 || i==M || j==N) return 'B';
			return a[i][j];
		}
	}//</editor-fold>

	public static class Sol_2_QueueBased{
		public static class Node{
			public int i;
			public int j;
			Node(int i, int j){
				this.i = i;
				this.j = j;
			}
		}

		static void run(char[][] a, int M, int N){
			System.out.println("QueueBased");
			run2(a, M, N);
			butil.Print.matrix(a);
		}

		private static void run2(char[][] a, int M, int N){
			LinkedList<Node> list = new LinkedList<>();
			for (int i = 0; i < M; i++) for (int j = 0; j < N; j++) if(a[i][j] == 'G') list.addLast(new Node(i, j));
			while(!list.isEmpty()){
				Node n = list.removeFirst();
				//...
				//TODO: more
			}
		}//run2
	}
}
